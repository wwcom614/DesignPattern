package com.ww.design_pattern.pattern.creational.factorymethod;

public class HisenseFactoryMethodImpl extends FactoryMethod {
    @Override
    public Fridge produceFridge() {
        return new HisenseFridgeImpl();
    }
}
