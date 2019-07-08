package com.keshe.luntan.service;

import com.keshe.luntan.entity.Meal;
import com.keshe.luntan.entity.ResponseBean;

public interface MealService {

    ResponseBean addMeal(int typeid, String mealname, double mealprice, String mealphoto);

    ResponseBean getMealList(int currentPage, int numbers, int orders, Meal meal);

    ResponseBean updateMeal(Meal meal);

    ResponseBean getMealCount(Meal meal);

    ResponseBean getMealMsg(int mealid);

    ResponseBean updateMealState(int mealid, int state);

    ResponseBean updateMealPhoto(int mealid, String mealphoto);

    ResponseBean updateMealPrice(int mealid, double mealprice);
}
