package com.keshe.luntan.controller;


import com.keshe.luntan.entity.ResponseBean;
import com.keshe.luntan.entity.ResultMsg;
import com.keshe.luntan.utils.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 * <h3>全局异常处理Controller</h3>
 * @author 燕富成
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /***
     * <p>处理自定义的异常</p>
     * @param e
     * @return bean
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseBean customHandler(ServiceException e) {
        System.out.println("异常处理");
        e.printStackTrace();
        System.out.println(e.getResultMsg());
        return new ResponseBean(e.getResultMsg());
    }

    /***
     * <p>处理其他异常</p>
     * @param e
     * @return bean
     */
    @ExceptionHandler(Exception.class)
    public ResponseBean exceptionHandler(Exception e) {
        e.printStackTrace();
        return new ResponseBean(new ResultMsg(2100,"不好意思，好像有点小问题"));
    }
}