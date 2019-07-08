package com.keshe.luntan.entity;

import java.io.Serializable;

public class ResponseBean implements Serializable{

    private ResultMsg resultMsg;
    private Object bean;

    public ResponseBean(ResultMsg resultMsg, Object bean) {
        this.resultMsg = resultMsg;
        this.bean = bean;
    }

    public ResponseBean(ResultMsg resultMsg) {
        this.resultMsg = resultMsg;
    }

    public ResultMsg getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(ResultMsg resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "resultMsg=" + resultMsg +
                ", bean=" + bean +
                '}';
    }
}
