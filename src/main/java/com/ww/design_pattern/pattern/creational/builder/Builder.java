package com.ww.design_pattern.pattern.creational.builder;

//建造者：声明产品的公共部件建造方法(接口或抽象类)和获取组装好产品的方法。
// 定义电脑组装过程的抽象建造方法
public abstract class Builder {

    public abstract void buildCPU();
    public abstract void buildMem();
    public abstract void buildHardDisk();
    public abstract void buildMainboard();
    public abstract void buildKeyboardMouse();

    //获得组装好的电脑
    public abstract Computer GetComputer();

}
