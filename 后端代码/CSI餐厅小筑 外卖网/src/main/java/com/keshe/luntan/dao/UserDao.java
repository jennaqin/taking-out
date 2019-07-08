package com.keshe.luntan.dao;

import com.keshe.luntan.entity.Paging;
import com.keshe.luntan.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    User login(String userphone, String password);

    void addUser(User user);

    User getUserByID(int userid);

    User getUserByPhone(String userphone);

    void updateUser(User u);

    void updateIcon(int userid, String userIcon);

    void updateState(int userid, int process);

    void updatePhone(int userid, String phone);

    void updateUserMsg(int userid, String name, String address);

    void updatePasswordById(int userid, String password);

    void updatePasswordByPhone(String userphone, String password);

    int checkPassword(int userid, String password);

    int getUserCount(int state);

    List<User> getUsers(Paging paging);
}
