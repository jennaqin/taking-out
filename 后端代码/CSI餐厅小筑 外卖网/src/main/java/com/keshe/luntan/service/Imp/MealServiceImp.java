package com.keshe.luntan.service.Imp;

import com.keshe.luntan.dao.MealDao;
import com.keshe.luntan.entity.Ext_Meal;
import com.keshe.luntan.entity.Meal;
import com.keshe.luntan.entity.Paging;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.MealService;
import com.keshe.luntan.utils.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MealServiceImp implements MealService {

    @Autowired
    private MealDao mealDao;

    @Override
    public ResponseBean addMeal(int typeid, String mealname, double mealprice, String mealphoto) {
        Meal meal = new Meal(0,typeid,mealname,mealprice,mealphoto,1);
        if(meal.getMealphoto() == null) {
            meal.setMealphoto("default.png");
        }
        mealDao.addMeal(meal);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean getMealList(int currentPage, int numbers, int orders, Meal meal) {
        int count = mealDao.getMealCount(meal);
        int totalPage = (int) Math.ceil((double)count/numbers);
        Paging paging = new Paging(totalPage,currentPage*numbers, numbers,orders,meal);
        List<Ext_Meal> mealList = mealDao.getMealList(paging);
        paging.setCurrentpage(currentPage);
        paging.setPojo(mealList);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), paging);
    }

    @Override
    public ResponseBean updateMeal(Meal meal) {
        mealDao.updateMeal(meal);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean getMealCount(Meal meal) {
        int count = mealDao.getMealCount(meal);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg(), count);
    }

    @Override
    public ResponseBean getMealMsg(int mealid) {
        Meal meal = mealDao.getMealMsg(mealid);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateMealState(int mealid, int state) {
        mealDao.updateMealState(mealid, state);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateMealPhoto(int mealid, String mealphoto) {
        mealDao.updateMealPhoto(mealid,mealphoto);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }

    @Override
    public ResponseBean updateMealPrice(int mealid, double mealprice) {
        mealDao.updateMealPrice(mealid,mealprice);
        return new ResponseBean(ResultEnum.RESULT_SUCCESS.getResultMsg());
    }
}
