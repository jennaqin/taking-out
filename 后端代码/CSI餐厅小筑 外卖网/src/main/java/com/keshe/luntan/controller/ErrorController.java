package com.keshe.luntan.controller;


import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.utils.ResultEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * <h3>权限异常跳转Controller</h3>
 * @author 燕富成
 */
@RestController
@RequestMapping("error")
//此类中的url都由拦截器转发过来
public class ErrorController {



    /***
     * <p>用户未登录错误</p>
     * @return bean
     */
    @RequestMapping("/userpermissionerror")
    public ResponseBean userError() {
        ResponseBean bean = new ResponseBean(ResultEnum.LOGIN_POWER_ERROR.getResultMsg());
        return bean;
    }

    /***
     * <p>没有管理员权限</p>
     * @return bean
     */
    @RequestMapping("/managerpermissionerror")
    public ResponseBean managerError() {
        ResponseBean bean = new ResponseBean(ResultEnum.MANAGER_POWER_ERROR.getResultMsg());
        return bean;
    }

    /***
     * <p>没有实名认证权限</p>
     * @return bean
     */
    @RequestMapping("/realnamedpermissionerror")
    public ResponseBean realnamedError() {
        ResponseBean bean = new ResponseBean(ResultEnum.IS_NOT_REALNAME.getResultMsg());
        return bean;
    }
}
