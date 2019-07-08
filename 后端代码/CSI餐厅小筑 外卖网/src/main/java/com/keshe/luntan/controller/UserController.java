package com.keshe.luntan.controller;

import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.entity.ResultMsg;
import com.keshe.luntan.entity.User;
import com.keshe.luntan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.Addressing;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResponseBean login(String userphone, String password) {
        return userService.login(userphone, password);
    }

    @RequestMapping("/register")
    public ResponseBean register(String userphone, String password) {
        userService.register(userphone, password);
        return new ResponseBean(new ResultMsg(1000,"123"));
    }

    @RequestMapping("/manager/updateuser")
    public ResponseBean updateUser(User u) {
        return userService.updateUser(u);
    }

    @RequestMapping("/user/updateicon")
    public ResponseBean updateIcon(String userIcon, HttpServletRequest request) {
        return userService.updateIcon((int) request.getAttribute("userid"), userIcon);
    }

    @RequestMapping("/user/updateusermsg")
    public ResponseBean updateUserMsg(String name, String address, HttpServletRequest request) {
        return userService.updateUserMsg((int) request.getAttribute("userid"), name, address);
    }

    @RequestMapping("/manager/banuser")
    public ResponseBean banUser(int userid) {
        return userService.banUser(userid);
    }

    @RequestMapping("/user/updatephone")
    public ResponseBean updatePhone(String phone, String phonecode, HttpServletRequest request) {
        return userService.updatePhone((int) request.getAttribute("userid"), phone, phonecode);
    }

    @RequestMapping("/manager/getusercount")
    public ResponseBean getUserCount(int state) {
        return userService.getUserCount(state);
    }

    @RequestMapping("/manager/getuserbyid")
    public ResponseBean getUserById(int userid) {
        return userService.getUserById(userid);
    }

    @RequestMapping("/user/refreshmsg")
    public ResponseBean refreshMsg(HttpServletRequest request) {
        return userService.refreshMsg((int)request.getAttribute("userid"));
    }

    @RequestMapping("/user/updatepassword")
    public ResponseBean updatePassword(String oldPassword, String newPassword, HttpServletRequest request) {
        return userService.updatePassword((int)request.getAttribute("userid"),oldPassword,newPassword);
    }

    @RequestMapping("/forgetpassword")
    public ResponseBean forgetPassword(String userphone, String phonecode, String newPassword) {
        return userService.forgetPassword(userphone,phonecode,newPassword);
    }

    @RequestMapping("/manager/getusers")
    public ResponseBean getUsers(
            @RequestParam(value = "state", required = false, defaultValue = "0") int state,
            @RequestParam(value = "currentpage", required = false, defaultValue = "0") int currentpage,
            @RequestParam(value = "numbers", required = false, defaultValue = "10") int numbers) {

        return userService.getUsers(currentpage, numbers, state);
    }

    @RequestMapping("/manager/updateuserstate")
    public ResponseBean updateUserState(int userid, int process) {
        return userService.updateUserState(userid,process);
    }

}
