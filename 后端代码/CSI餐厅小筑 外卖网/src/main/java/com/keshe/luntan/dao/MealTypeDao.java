package com.keshe.luntan.dao;

import com.keshe.luntan.entity.MealType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MealTypeDao {

    List<MealType> getMealTypeList();

    void addMealType(String typename);

    void updateMealType(int typeid, String typename);

    int getMealTypeCount();
}
