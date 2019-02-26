package com.ww.design_pattern.pattern.structural.adapter.classadapter;

import lombok.extern.java.Log;

@Log
public class Adaptee {
//被适配者及其已有方法
    public void adapteeMethod(){
        log.info("【Adaptee】：被适配者的方法");
    }
}
