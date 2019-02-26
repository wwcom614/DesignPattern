package com.ww.design_pattern.pattern.creational.builder;

//指挥者：调用者与建造者之间的桥梁，与调用者沟通建造需求，根据建造需求依赖调用建造者builder组装产品
public class Director {

    public void ConstructComputer(Builder builder){
        builder.buildCPU();
        builder.buildMem();
        builder.buildHardDisk();
        builder.buildMainboard();
        builder.buildKeyboardMouse();
    }

}
