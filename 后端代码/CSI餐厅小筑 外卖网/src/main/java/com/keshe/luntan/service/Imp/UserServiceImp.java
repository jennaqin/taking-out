package com.keshe.luntan.service.Imp;

import com.keshe.luntan.dao.UserDao;
import com.keshe.luntan.entity.Paging;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.entity.User;
import com.keshe.luntan.entity.UserState;
import com.keshe.luntan.service.UserService;
import com.keshe.luntan.utils.EncryptionUtils;
import com.keshe.luntan.utils.ResultEnum;
import com.keshe.luntan.utils.TokenUtils;
import com.keshe.luntan.utils.exception.ServiceException;
import com.keshe.luntan.utils.manager.LoginManager;
import com.keshe.luntan.utils.manager.SmsManager;
import com.keshe.luntan.utils.manager.UserStateManager;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userdao;

    @Override
    public ResponseBean login(String userphone, String password) {
        Map<String, Object> userMsgMap = new HashMap<>(5);
        String encryptionPWD = null;
        try {
            encryptionPWD = EncryptionUtils.getInstance().strEncrypt(password, "mypwd");
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(ResultEnum.ENCRYPT_ERROR.getResultMsg(), e);
        }
        //数据库查询
        User u = userdao.login(userphone, encryptionPWD);
        if (u == null) {
            //记录密码错误的次数
            throw new ServiceException(ResultEnum.VERIFICATION_ERROR.getResultMsg());
        } else if (u.getState() < 0) {
            throw new ServiceException(ResultEnum.USER_BANNED.getResultMsg());
        } else {
            //获得token
            String token = null;
            try {
                token = TokenUtils.getToken(u.getUserid(), (long) 1000 * 60 * 60 * 24 * 7);
            } catch (JOSEException e) {
                throw new ServiceException(ResultEnum.TOKEN_ERROR.getResultMsg(), e);
            }
            //把登录的用户记录到登录管理器(记录token)
            LoginManager.AddLoginflag(u.getUserid(), token);
            //解析权限数字
            UserState userState = new UserState(u.getState());
            UserStateManager.AddUserStateflag(u.getUserid(), userState);
            userMsgMap.put("token", token);
            userMsgMap.put("user", u);
            userMsgMap.put("userState", userState);
        }

        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), userMsgMap);
    }

    @Override
    public ResponseBean register(String userphone, String password) {
        User u = new User();
        if (userdao.getUserByPhone(userphone) != null) {
            throw new ServiceException(ResultEnum.PHONE_EXIST.getResultMsg());
        } else {
            u.setUserphone(userphone);
            u.setIcon("USERdefault.png");
            u.setName("user" + userphone.substring(7, 11));
            u.setAddress("isNotSet");
            u.setState(0);
            //密码加密处理
            String encryptionPWD = null;
            try {
                encryptionPWD = EncryptionUtils.getInstance().strEncrypt(password, "mypwd");
            } catch (NoSuchAlgorithmException e) {
                throw new ServiceException(ResultEnum.ENCRYPT_ERROR.getResultMsg(), e);
            }
            u.setPassword(encryptionPWD);
            userdao.addUser(u);
        }
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), null);
    }

    @Override
    public ResponseBean updateUser(User u) {
        userdao.updateUser(u);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), null);
    }

    @Override
    public ResponseBean updateIcon(int userid, String userIcon) {
        userdao.updateIcon(userid, userIcon);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), null);
    }

    @Override
    public ResponseBean banUser(int userid) {
        userdao.updateState(userid, -1);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), null);
    }

    @Override
    public ResponseBean updatePhone(int userid, String userphone, String phonecode) {
        if (phonecode.equals(SmsManager.getSms(userphone))) {
            //销毁验证码
            SmsManager.deleteSms(userphone);
            if (userdao.getUserByPhone(userphone) != null) {
                throw new ServiceException(ResultEnum.PHONE_EXIST.getResultMsg());
            } else {
                userdao.updatePhone(userid, userphone);
            }
        } else {
            throw new ServiceException(ResultEnum.CODE_ERROR.getResultMsg());
        }
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), null);
    }


    @Override
    public ResponseBean getUserCount(int state) {
        int userCount = userdao.getUserCount(state);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), userCount);
    }

    @Override
    public ResponseBean getUsers(int currentPage, int numbers, int state) {
        int count = userdao.getUserCount(state);
        int totalPage = (int) Math.ceil((double) count / numbers);
        Paging paging = new Paging(totalPage, currentPage * numbers, numbers, 0, state);
        List<User> userList = userdao.getUsers(paging);
        paging.setCurrentpage(currentPage);
        paging.setPojo(userList);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), paging);
    }

    @Override
    public ResponseBean getUserById(int userid) {
        User user = userdao.getUserByID(userid);
        return null;
    }

    @Override
    public ResponseBean refreshMsg(int userid) {
        User user = userdao.getUserByID(userid);
        Map<String, Object> userMsgMap = new HashMap<>(3);
        userMsgMap.put("user", user);
        userMsgMap.put("userState", UserStateManager.getUserStateflag(user.getUserid()));
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), userMsgMap);
    }

    @Override
    public ResponseBean updatePassword(int userid, String oldPassword, String newPassword) {
        String encryptionPWD = null;
        try {
            encryptionPWD = EncryptionUtils.getInstance().strEncrypt(oldPassword, "mypwd");
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(ResultEnum.ENCRYPT_ERROR.getResultMsg(), e);
        }
        if (userdao.checkPassword(userid, encryptionPWD) != 0) {
            try {
                encryptionPWD = EncryptionUtils.getInstance().strEncrypt(newPassword, "mypwd");
            } catch (NoSuchAlgorithmException e) {
                throw new ServiceException(ResultEnum.ENCRYPT_ERROR.getResultMsg(), e);
            }
            userdao.updatePasswordById(userid, encryptionPWD);
            return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
        }
        throw new ServiceException(ResultEnum.OLDPWD_ERROR.getResultMsg());
    }

    @Override
    public ResponseBean forgetPassword(String userphone, String phonecode, String newPassword) {
        String code = SmsManager.getSms(userphone);
        if (phonecode.equals(code)) {
            SmsManager.deleteSms(userphone);
            String newPWD = null;
            try {
                newPWD = EncryptionUtils.getInstance().strEncrypt(newPassword, "mypwd");
            } catch (NoSuchAlgorithmException e) {
                throw new ServiceException(ResultEnum.ENCRYPT_ERROR.getResultMsg(), e);
            }
            userdao.updatePasswordByPhone(userphone, newPWD);
        } else {
            throw new ServiceException(ResultEnum.CODE_ERROR.getResultMsg());
        }
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateUserState(int userid, int process) {
        userdao.updateState(userid,process);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateUserMsg(int userid, String name, String address) {
        userdao.updateUserMsg(userid,name,address);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }
}
