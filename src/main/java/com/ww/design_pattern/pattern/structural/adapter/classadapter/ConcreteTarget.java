package com.ww.design_pattern.pattern.structural.adapter.classadapter;

import lombok.extern.java.Log;

//已有的实现目标接口的类和目标方法
@Log
public class ConcreteTarget implements ITarget {
    @Override
    public void targetMethod() {
        log.info("【concreteTarget】：目标方法");
    }
}
