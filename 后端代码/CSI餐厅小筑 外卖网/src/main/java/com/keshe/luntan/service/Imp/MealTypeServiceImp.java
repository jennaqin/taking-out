package com.keshe.luntan.service.Imp;

import com.keshe.luntan.dao.MealDao;
import com.keshe.luntan.dao.MealTypeDao;
import com.keshe.luntan.entity.MealType;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.MealTypeService;
import com.keshe.luntan.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MealTypeServiceImp implements MealTypeService {

    @Autowired
    private MealTypeDao mealTypeDao;

    @Override
    public ResponseBean getMealTypeList() {
        List<MealType> mealTypeList = mealTypeDao.getMealTypeList();
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), mealTypeList);
    }

    @Override
    public ResponseBean addMealType(String typename) {
        mealTypeDao.addMealType(typename);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateMealType(int typeid, String typename) {
        mealTypeDao.updateMealType(typeid,typename);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean getMealTypeCount() {
        int count = mealTypeDao.getMealTypeCount();
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(),count);
    }
}
