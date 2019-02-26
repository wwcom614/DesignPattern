package com.ww.design_pattern.pattern.behavioral.chainresponsibility;

import lombok.extern.java.Log;

@Log
public class ConcreteHandler2 extends Handler {
    @Override
    public void requestHandle(int request) {
        if (request > 10 && request <= 20) {
            log.info("【ConcreteHandler2】：处理了请求：" + request);
        } else {
            this.nextHandler.requestHandle(request);
        }
    }
}
