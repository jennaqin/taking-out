package com.keshe.luntan.controller;

import com.keshe.luntan.entity.Order;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/user/addorder")
    public ResponseBean addOrder(int[] cartIdList, HttpServletRequest request) {
        return orderService.addOrder(cartIdList, (int)request.getAttribute("userid"));
    }

    @RequestMapping("/manager/updateorder")
    public ResponseBean updateOrder(Order order) {
        return orderService.updateOrder(order);
    }

    @RequestMapping("/manager/updateorderstate")
    public ResponseBean updateOrderState(int orderid, int orderstate) {
        return orderService.updateOrderState(orderid, orderstate);
    }

    @RequestMapping("/user/getordercount")
    public ResponseBean getOrderCount(Order order) {
        return orderService.getOrderCount(order);
    }

    @RequestMapping("/user/getordermsg")
    public ResponseBean getOrderMsg(int orderid, HttpServletRequest request) {
        return orderService.getOrderMsg(orderid,(int)request.getAttribute("userid"));
    }

    @RequestMapping("/manager/getordermsg")
    public ResponseBean getOrderMsg(int orderid) {
        return orderService.getOrderMsg(orderid);
    }
    @RequestMapping("/user/getorderlist")
    public ResponseBean getOrderList(Order o,
            @RequestParam(value="currentpage",required=false,defaultValue="0")int currentpage,
            @RequestParam(value="numbers",required=false,defaultValue="10")int numbers,
            @RequestParam(value="order",required=false,defaultValue="0")int order) {

        return orderService.getOrderList(currentpage,numbers,order,o);
    }
}
