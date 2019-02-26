package com.ww.design_pattern.pattern.creational.abstractfactory;

public class HisenseAbstractFactoryImpl implements AbstractFactory {
    @Override
    public Fridge produceFridge() {
        return new HisenseFridgeImpl();
    }

    @Override
    public TV produceTV() {
        return new HisenseTVImpl();
    }
}
