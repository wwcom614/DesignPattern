package com.ww.design_pattern.pattern.structural.decorator;

//加个香肠的装饰类，继承煎饼抽象类。以煎饼抽象类为入参，构造加好香肠的煎饼类。
public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(AbstractPancake abstractPancake) {
        super(abstractPancake);
    }

    @Override
    protected void commanChildenMustDoSomething() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加1个香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 3;
    }
}
