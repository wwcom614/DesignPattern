package com.ww.design_pattern.pattern.structural.decorator;

//核心对象煎饼实体类，继承煎饼抽象类。
public  class Pancake extends AbstractPancake{

    @Override
    protected String getDesc() {
        return "老板，来1个煎饼";
    }

    @Override
    protected int getPrice() {
        return 8;
    }
}
