package com.ww.design_pattern.pattern.creational.abstractfactory;

//抽象工厂，接口或抽象方法，用于一个系列的产品族统一创建
public interface AbstractFactory {
    Fridge produceFridge();
    TV produceTV();
}
