package com.keshe.luntan.service.Imp;

import com.keshe.luntan.dao.CartDao;
import com.keshe.luntan.entity.Cart;
import com.keshe.luntan.entity.Ext_Cart;
import com.keshe.luntan.entity.Paging;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.CartService;
import com.keshe.luntan.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImp implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public ResponseBean addCart(int userid, int mealid, int count) {
        Integer mealCount = cartDao.getMealCount(userid, mealid);
        if(mealCount == null) {
            Cart cart = new Cart(0,userid,mealid,0,count);
            cartDao.addCart(cart);
        }else {
            cartDao.updateCountByUseridAndMealid(userid,mealid,mealCount+count);
        }

        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateCart(Cart cart) {
        cartDao.updateCart(cart);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean getCartList(int currentPage, int numbers, int orders, Cart cart) {
        int count = cartDao.getCartCount(cart);
        int totalPage = (int) Math.ceil((double)count/numbers);
        Paging paging = new Paging(totalPage,currentPage*numbers, numbers,orders,cart);
        List<Ext_Cart> orderList = cartDao.getCartList(paging);
        paging.setCurrentpage(currentPage);
        paging.setPojo(orderList);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), paging);
    }

    @Override
    public ResponseBean getCartCount(Cart cart) {
        int count = cartDao.getCartCount(cart);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), count);
    }

    @Override
    public ResponseBean deleteCart(int cartid) {
        cartDao.deleteCart(cartid);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }
}
