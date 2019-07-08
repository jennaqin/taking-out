package com.keshe.luntan.controller;

import com.keshe.luntan.entity.Meal;
import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @RequestMapping("/manager/addmeal")
    public ResponseBean addMeal(int typeid, String mealname, double mealprice, String mealphoto ) {
        return mealService.addMeal(typeid,mealname,mealprice,mealphoto);
    }

    @RequestMapping("/getmeallist")
    public ResponseBean getMealList(Meal meal,
            @RequestParam(value="currentpage",required=false,defaultValue="0")int currentpage,
            @RequestParam(value="numbers",required=false,defaultValue="10")int numbers,
            @RequestParam(value="order",required=false,defaultValue="0")int order) {

        return mealService.getMealList(currentpage,numbers,order,meal);
    }

    @RequestMapping("/manager/updatemeal")
    public ResponseBean updateMeal(Meal meal) {
        return mealService.updateMeal(meal);
    }

    @RequestMapping("/manager/updatemealprice")
    public ResponseBean updateMealPrice(int mealid, double mealprice) {
        return mealService.updateMealPrice(mealid,mealprice);
    }

    @RequestMapping("/manager/updatemealphoto")
    public ResponseBean updateMealPhoto(int mealid, String mealphoto) {
        return mealService.updateMealPhoto(mealid, mealphoto);
    }

    @RequestMapping("/getmealcount")
    public ResponseBean getMealCount(Meal meal) {
        return mealService.getMealCount(meal);
    }

    @RequestMapping("/getmealmsg")
    public ResponseBean getMealMsg(int mealid) {
        return mealService.getMealMsg(mealid);
    }

    @RequestMapping("/manager/updatemealstate")
    public ResponseBean updateMealState(int mealid, int state) {
        return mealService.updateMealState(mealid,state);
    }

}
