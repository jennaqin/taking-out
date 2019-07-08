package com.keshe.luntan.entity;

import java.io.Serializable;

public class Ext_Cart extends Cart implements Serializable {

    private String mealname;
    private double mealprice;
    private String mealphoto;

    public Ext_Cart(int orderid, int cartid, int userid, int mealid, int count, String mealname, double mealprice, String mealphoto) {
        super(cartid, userid, mealid, orderid, count);
        this.mealname = mealname;
        this.mealprice = mealprice;
        this.mealphoto = mealphoto;
    }

    public Ext_Cart() {
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

    @Override
    public String toString() {
        return "Ext_Cart{" +
                ", mealname=" + mealname +
                ", mealprice=" + mealprice +
                ", mealphoto=" + mealphoto +
                '}';
    }
}
