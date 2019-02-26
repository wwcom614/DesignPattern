package com.ww.design_pattern.pattern.behavioral.chainresponsibility;

import lombok.extern.java.Log;

@Log
public class ConcreteHandler1 extends Handler {
    @Override
    public void requestHandle(int request) {
        if (request >= 0 && request <= 10) {
            log.info("【ConcreteHandler1】：处理了请求：" + request);
        } else {
            this.nextHandler.requestHandle(request);
        }
    }
}
