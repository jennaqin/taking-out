package com.keshe.luntan.service;

import com.keshe.luntan.entity.ResponseBean;

public interface MealTypeService {
    ResponseBean getMealTypeList();

    ResponseBean addMealType(String typename);

    ResponseBean updateMealType(int typeid, String typename);

    ResponseBean getMealTypeCount();

}
