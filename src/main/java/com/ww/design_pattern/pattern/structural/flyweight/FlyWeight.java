package com.ww.design_pattern.pattern.structural.flyweight;

import lombok.extern.java.Log;

@Log
public class FlyWeight implements IFlyWeight {
    //享元内部状态：在享元对象内部，享元对象的固定属性，不会随着环境改变而改变的共享部分。
    private String innerState = "享元内部状态";

    //享元外部状态：在享元对象外部，作为享元对象的构造方法入参传入的外部对象，会随着环境改变而改变的部分。
    private String outerStateConCrete;

    //享元外部状态：在享元对象外部，作为享元对象的set方法入参传入的外部对象，会随着环境改变而改变的部分。
    private String outerStateSetMethod;

    public void setOuterStateConCrete(String outerStateSetMethod) {
        this.outerStateSetMethod = outerStateSetMethod;
    }

    //享元模式有参构造方法，外部状态作为入参
    public FlyWeight(String outerStateConCrete) {
        this.outerStateConCrete = outerStateConCrete;
    }

    @Override
    public void doSomething() {
        log.info("【FlyWeight-innerState-doSomething】：" + innerState);
        log.info("【FlyWeight-OuterState-doSomething】：" + outerStateConCrete +"， "+ outerStateSetMethod);
    }
}
