package com.ww.design_pattern.pattern.behavioral.mediator;

import lombok.extern.java.Log;

//中介者：定义封装一个User对象与多个User对象如何交互的对象。
//将一对多转化为一对一，降低程序复杂度
@Log
public class Chat {
    public static void sendMsg(User user, String message) {
        log.info("【Chat】：[" + user.getName() + "]sendGroupMsg[" + message + "]");
    }
}
