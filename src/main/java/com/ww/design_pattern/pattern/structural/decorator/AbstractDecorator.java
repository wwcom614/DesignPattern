package com.ww.design_pattern.pattern.structural.decorator;

//核心：装饰类也继承煎饼抽象类。。
public abstract class AbstractDecorator extends AbstractPancake {
    private AbstractPancake abstractPancake;

    public AbstractDecorator(AbstractPancake abstractPancake){
        this.abstractPancake = abstractPancake;
    }

    //如果装饰类有想让子类都实现的方法，定义一个抽象方法，那么装饰类要定义为抽象类。
    protected abstract void commanChildenMustDoSomething();

    @Override
    protected String getDesc() {
        return this.abstractPancake.getDesc();
    }

    @Override
    protected int getPrice() {
        return this.abstractPancake.getPrice();
    }
}
