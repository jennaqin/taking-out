package com.keshe.luntan.service;

import com.keshe.luntan.entity.Order;
import com.keshe.luntan.entity.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;

public interface OrderService {
    ResponseBean addOrder(int[] cartIdList, int userid);

    ResponseBean updateOrder(Order order);

    ResponseBean updateOrderState(int orderid, int orderstate);

    ResponseBean getOrderCount(Order order);

    ResponseBean getOrderList(int currentPage, int numbers, int orders, Order order);

    ResponseBean getOrderMsg(int orderid, int userid);

    ResponseBean getOrderMsg(int orderid);
}

