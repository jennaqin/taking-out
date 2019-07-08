package com.keshe.luntan.service;

import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.entity.User;

public interface UserService {

    ResponseBean login(String userphone, String password);

    ResponseBean register(String userphone, String password);

    ResponseBean updateUser(User u);

    ResponseBean updateIcon(int userid, String userIcon);

    ResponseBean banUser(int userid);

    ResponseBean updatePhone(int userid, String userphone, String phonecode);

    ResponseBean getUserCount(int state);

    ResponseBean getUsers(int currentPage, int numbers, int state);

    ResponseBean getUserById(int userid);

    ResponseBean refreshMsg(int userid);

    ResponseBean updatePassword(int userid, String oldPassword, String newPassword);

    ResponseBean forgetPassword(String userphone, String phonecode, String newPassword);

    ResponseBean updateUserState(int userid, int process);

    ResponseBean updateUserMsg(int userid, String name, String address);
}
