package com.ww.design_pattern.pattern.behavioral.command;

import lombok.extern.java.Log;

//Receiver接收者角色：该角色就是干活的角色，Command命令的实际执行者
@Log
public class Receiver {

    public void doA(){
        log.info("【Receiver】：doA");
    }

    public void unDoA(){
        log.info("【Receiver】：unDoA");
    }

    public void doB(){
        log.info("【Receiver】：doB");
    }

    public void unDoB(){
        log.info("【Receiver】：unDoB");
    }

    public void doC(){
        log.info("【Receiver】：doC");
    }

    public void unDoC(){
        log.info("【Receiver】：unDoC");
    }
}
