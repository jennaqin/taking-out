package com.keshe.luntan.controller;

import com.keshe.luntan.entity.Cart;
import com.keshe.luntan.entity.Ext_Cart;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/user/addcart")
    public ResponseBean addCart(int mealid, int count, HttpServletRequest request) {
        return cartService.addCart((int)request.getAttribute("userid"), mealid, count);
    }

    @RequestMapping("/user/updatecart")
    public ResponseBean updateCart(Cart cart) {
        return cartService.updateCart(cart);
    }

    @RequestMapping("/user/getcartlist")
    public ResponseBean getCartList(Cart cart,
                                    @RequestParam(value = "currentpage", required = false, defaultValue = "0") int currentpage,
                                    @RequestParam(value = "numbers", required = false, defaultValue = "10") int numbers,
                                    @RequestParam(value = "order", required = false, defaultValue = "0") int order) {

        return cartService.getCartList(currentpage,numbers,order,cart);
    }

    @RequestMapping("/user/getcartcount")
    public ResponseBean getCartCount(Cart cart) {
        return cartService.getCartCount(cart);
    }

    @RequestMapping("/user/deletecart")
    public ResponseBean deleteCart(int cartid) {
        return cartService.deleteCart(cartid);
    }

}
