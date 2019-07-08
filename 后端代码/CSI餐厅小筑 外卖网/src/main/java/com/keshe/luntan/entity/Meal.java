package com.keshe.luntan.entity;

import java.io.Serializable;

public class Meal implements Serializable {

    private int mealid;
    private int typeid;
    private String mealname;
    private double mealprice;
    private String mealphoto;
    private int mealstate;

    public Meal(int mealid, int typeid, String mealname, double mealprice, String mealphoto, int mealstate) {
        this.mealid = mealid;
        this.typeid = typeid;
        this.mealname = mealname;
        this.mealprice = mealprice;
        this.mealphoto = mealphoto;
        this.mealstate = mealstate;
    }

    public Meal() {
    }

    public int getMealid() {
        return mealid;
    }

    public void setMealid(int mealid) {
        this.mealid = mealid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public double getMealprice() {
        return mealprice;
    }

    public void setMealprice(double mealprice) {
        this.mealprice = mealprice;
    }

    public String getMealphoto() {
        return mealphoto;
    }

    public void setMealphoto(String mealphoto) {
        this.mealphoto = mealphoto;
    }

    public int getMealstate() {
        return mealstate;
    }

    public void setMealstate(int mealstate) {
        this.mealstate = mealstate;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealid=" + mealid +
                ", typeid=" + typeid +
                ", mealname='" + mealname + '\'' +
                ", mealprice='" + mealprice + '\'' +
                ", mealphoto='" + mealphoto + '\'' +
                ", mealstate=" + mealstate +
                '}';
    }
}
