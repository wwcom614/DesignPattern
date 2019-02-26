package com.ww.design_pattern.pattern.creational.abstractfactory;

public class HaierAbstractFactoryImpl implements AbstractFactory {
    @Override
    public Fridge produceFridge() {
        return new HaierFridgeImpl();
    }

    @Override
    public TV produceTV() {
        return new HaierTVImpl();
    }
}
