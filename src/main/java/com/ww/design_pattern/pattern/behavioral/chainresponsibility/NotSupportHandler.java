package com.ww.design_pattern.pattern.behavioral.chainresponsibility;

import lombok.extern.java.Log;

@Log
public class NotSupportHandler extends Handler {
    @Override
    public void requestHandle(int request) {
        if (request < 0 || request > 20) {
            log.info("【NotSupportHandler】：无法处理：" + request);
        }
    }
}
