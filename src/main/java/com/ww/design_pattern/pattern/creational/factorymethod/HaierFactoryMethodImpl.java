package com.ww.design_pattern.pattern.creational.factorymethod;

public class HaierFactoryMethodImpl extends FactoryMethod {
    @Override
    public Fridge produceFridge() {
        return new HaierFridgeImpl();
    }
}
