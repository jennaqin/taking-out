package com.keshe.luntan.dao;

import com.keshe.luntan.entity.Ext_Order;
import com.keshe.luntan.entity.Order;
import com.keshe.luntan.entity.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    void addOrder(Order order);

    void updateOrder(Order order);

    void updateOrderState(int orderid, int orderstate);

    int getOrderCount(Order order);

    List<Ext_Order> getOrderList(Paging paging);

    Ext_Order getOrderMsg(int orderid, int userid);

    Ext_Order getOrderById(int orderid);
}
