package com.keshe.luntan.controller;

import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.service.MealTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealTypeController {

    @Autowired
    private MealTypeService mtService;

    @RequestMapping("/getmealtypelist")
    public ResponseBean getMealTypeList() {
        return mtService.getMealTypeList();
    }

    @RequestMapping("/manager/addmealtype")
    public ResponseBean addMealType(String typename) {

        System.out.println(typename);
        return mtService.addMealType(typename);
    }

    @RequestMapping("/manager/updatemealtype")
    public ResponseBean updateMealType(int typeid, String typename) {
        return mtService.updateMealType(typeid,typename);
    }

    @RequestMapping("/getmealtypecount")
    public ResponseBean getMealTypeCount() {
        return mtService.getMealTypeCount();
    }

}
