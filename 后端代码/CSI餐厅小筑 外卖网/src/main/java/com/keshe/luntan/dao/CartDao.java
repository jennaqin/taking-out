package com.keshe.luntan.dao;

import com.keshe.luntan.entity.Cart;
import com.keshe.luntan.entity.Ext_Cart;
import com.keshe.luntan.entity.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDao {

    void addCart(Cart cart);

    double getTatalPrice(int[] cartIdList);

    void updateCountByUseridAndMealid(int userid, int mealid, int count);

    Integer getMealCount(int userid, int mealid);

    Ext_Cart getCartMsg(int cartid);

    void updateCart(Cart cart);

    int getCartCount(Cart cart);

    List<Ext_Cart> getCartList(Paging paging);

    void updateOrderid(int orderid, int[] cartidArr);

    void deleteCart(int cartid);

    void getTotalMoney(int[] cartidArr);
}
