package com.keshe.luntan.entity;

import java.io.Serializable;

public class User implements Serializable{

    private int userid;
    private String userphone;
    private String password;
    private String name;
    private String icon;
    private String address;
    int state;

    public User(int userid, String userphone, String password, String name, String icon, String address, int state) {
        this.userid = userid;
        this.userphone = userphone;
        this.password = password;
        this.name = name;
        this.icon = icon;
        this.address = address;
        this.state = state;
    }

    public User() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", userphone='" + userphone + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                '}';
    }
}
