package com.keshe.luntan.entity;

import java.io.Serializable;
import java.util.List;

public class Ext_Order extends Order implements Serializable {

    private String username;
    private String usericon;

    public Ext_Order(String username, String usericon) {
        this.username = username;
        this.usericon = usericon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsericon() {
        return usericon;
    }

    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    @Override
    public String toString() {
        return "Ext_Order{" +
                "username='" + username + '\'' +
                ", usericon='" + usericon + '\'' +
                '}';
    }
}
