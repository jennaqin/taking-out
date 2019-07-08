package com.keshe.luntan.entity;

import java.io.Serializable;

public class Ext_Meal extends Meal implements Serializable {

    String typename;

    public Ext_Meal(int mealid, int typeid, String mealname, double mealprice, String mealphoto, int mealstate, String typename) {
        super(mealid, typeid, mealname, mealprice, mealphoto, mealstate);
        this.typename = typename;
    }

    public Ext_Meal() {
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Ext_Meal{" + super.toString() + " "+
                "typename='" + typename + '\'' +
                '}';
    }
}
