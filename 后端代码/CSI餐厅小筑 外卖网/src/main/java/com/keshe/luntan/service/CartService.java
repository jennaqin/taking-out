package com.keshe.luntan.service;

import com.keshe.luntan.entity.Cart;
import com.keshe.luntan.entity.Ext_Cart;
import com.keshe.luntan.entity.ResponseBean;

public interface CartService {
    ResponseBean addCart(int userid, int mealid, int count);

    ResponseBean updateCart(Cart cart);

    ResponseBean getCartList(int currentPage, int numbers, int orders, Cart cart);

    ResponseBean getCartCount(Cart cart);

    ResponseBean deleteCart(int cartid);
}
