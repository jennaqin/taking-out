package com.keshe.luntan.dao;

import com.keshe.luntan.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MealDao {

    int getMealCount(Meal meal);

    List<Ext_Meal> getMealList(Paging paging);

    void addMeal(Meal meal);

    void updateMeal(Meal meal);

    void updateMealState(int mealid, int state);

    Meal getMealMsg(int mealid);

    void updateMealPhoto(int mealid, String mealphoto);

    void updateMealPrice(int mealid, double mealprice);
}
