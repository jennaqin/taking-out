package com.keshe.luntan.entity;

import java.io.Serializable;

public class MealType implements Serializable{

    private int typeid;
    private String typename;

    public MealType(int typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public MealType() {
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "MealTypeService{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
