package com.keshe.luntan.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {

    private int orderid;
    private int userid;
    private Timestamp tradingtime;
    private int orderstate;
    private double totalprice;

    public Order(int orderid, int userid, Timestamp tradingtime, int orderstate, double totalprice) {
        this.orderid = orderid;
        this.userid = userid;
        this.tradingtime = tradingtime;
        this.orderstate = orderstate;
        this.totalprice = totalprice;
    }

    public Order() {
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getTradingtime() {
        return tradingtime;
    }

    public void setTradingtime(Timestamp tradingtime) {
        this.tradingtime = tradingtime;
    }

    public int getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(int orderstate) {
        this.orderstate = orderstate;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", tradingtime=" + tradingtime +
                ", orderstate=" + orderstate +
                ", totalprice=" + totalprice +
                '}';
    }
}
