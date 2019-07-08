package com.keshe.luntan.service.Imp;

import com.keshe.luntan.dao.CartDao;
import com.keshe.luntan.dao.OrderDao;
import com.keshe.luntan.entity.Ext_Order;
import com.keshe.luntan.entity.Order;
import com.keshe.luntan.entity.Paging;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.OrderService;
import com.keshe.luntan.utils.ResultEnum;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CartDao cartDao;

    @Override
    public ResponseBean addOrder(int[] cartIdList, int userid) {
        double totalprice = cartDao.getTatalPrice(cartIdList);
        Order order = new Order(0,userid,new Timestamp(System.currentTimeMillis()),1,totalprice);
        orderDao.addOrder(order);
        cartDao.updateOrderid(order.getOrderid(), cartIdList);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateOrder(Order order) {
        orderDao.updateOrder(order);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateOrderState(int orderid, int orderstate) {
        orderDao.updateOrderState(orderid,orderstate);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean getOrderCount(Order order) {
        int count = orderDao.getOrderCount(order);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(),count);
    }

    @Override
    public ResponseBean getOrderList(int currentPage, int numbers, int orders, Order order) {
        int count = orderDao.getOrderCount(order);
        int totalPage = (int) Math.ceil((double)count/numbers);
        Paging paging = new Paging(totalPage,currentPage*numbers, numbers,orders,order);
        List<Ext_Order> orderList = orderDao.getOrderList(paging);
        paging.setCurrentpage(currentPage);
        paging.setPojo(orderList);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(),paging);
    }

    @Override
    public ResponseBean getOrderMsg(int orderid, int userid) {
        Ext_Order ext_order = orderDao.getOrderMsg(orderid,userid);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(),ext_order);
    }

    @Override
    public ResponseBean getOrderMsg(int orderid) {
        Ext_Order ext_order = orderDao.getOrderById(orderid);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(),ext_order);
    }
}
