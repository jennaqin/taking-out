package com.keshe.luntan.entity;

import java.io.Serializable;

public class Cart implements Serializable {

    private int cartid;
    private int userid;
    private int mealid;
    private int orderid;
    private int count;

    public Cart(int cartid, int userid, int mealid, int orderid, int count) {
        this.cartid = cartid;
        this.userid = userid;
        this.mealid = mealid;
        this.orderid = orderid;
        this.count = count;
    }

    public Cart() {
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMealid() {
        return mealid;
    }

    public void setMealid(int mealid) {
        this.mealid = mealid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartid=" + cartid +
                ", userid=" + userid +
                ", mealid=" + mealid +
                ", orderid=" + orderid +
                ", count=" + count +
                '}';
    }
}

