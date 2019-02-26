package com.ww.design_pattern.pattern.creational.builder;

//具体建造者2：具体实现建造者builder接口
public class ConcreteBuilder2 extends Builder {
    //创建产品实例
    Computer computer = new Computer();

    //将组件组装成产品
    @Override
    public void buildCPU() {
        computer.add("AMD CPU");
    }

    @Override
    public void buildMem() {
        computer.add("King 16GB Memory");
    }

    @Override
    public void buildHardDisk() {
        computer.add("8TB WestData harddisk");;
    }

    @Override
    public void buildMainboard() {
        computer.add("GIGA mainboard");;
    }

    @Override
    public void buildKeyboardMouse() {
        computer.add("Razer keyboard and mouse");;
    }

    @Override
    public Computer GetComputer() {
        return computer;
    }
}
