package com.ww.design_pattern.pattern.structural.decorator;

//加个蛋的装饰类，继承煎饼抽象类。以煎饼抽象类为入参，构造加好蛋的煎饼类。
public class EggDecorator extends AbstractDecorator {

    public EggDecorator(AbstractPancake abstractPancake) {
        super(abstractPancake);
    }

    @Override
    protected void commanChildenMustDoSomething() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
