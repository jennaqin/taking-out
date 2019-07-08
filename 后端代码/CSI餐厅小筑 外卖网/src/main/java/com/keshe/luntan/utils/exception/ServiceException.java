package com.keshe.luntan.utils.exception;


import com.keshe.luntan.entity.ResultMsg;

public class ServiceException extends RuntimeException{

    //发送给用户的处理结果
    private final ResultMsg resultMsg;

    public ServiceException(int code, String message, Throwable cause) {
        super(cause);
        this.resultMsg = new ResultMsg(code,message);
    }

    public ServiceException(ResultMsg resultMsg, Throwable cause) {
        super(resultMsg.getMessage(), cause);
        this.resultMsg = resultMsg;
    }

    public ServiceException(ResultMsg resultMsg) {
        super(resultMsg.getMessage());
        this.resultMsg = resultMsg;
    }

    public ResultMsg getResultMsg() {
        return resultMsg;
    }

    public void printResultMsg() {
        System.out.println(resultMsg);
    }
}
