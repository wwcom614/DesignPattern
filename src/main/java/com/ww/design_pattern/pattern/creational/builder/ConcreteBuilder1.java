package com.ww.design_pattern.pattern.creational.builder;

//具体建造者1：具体实现建造者builder接口
public class ConcreteBuilder1 extends Builder {
    //创建产品实例
    Computer computer = new Computer();

    //将组件组装成产品
    @Override
    public void buildCPU() {
        computer.add("Intel i7 CPU");
    }

    @Override
    public void buildMem() {
        computer.add("SamSung 8GB Memory");
    }

    @Override
    public void buildHardDisk() {
        computer.add("14TB Seagate harddisk");;
    }

    @Override
    public void buildMainboard() {
        computer.add("ASUS mainboard");;
    }

    @Override
    public void buildKeyboardMouse() {
        computer.add("Logitech keyboard and mouse");;
    }

    @Override
    public Computer GetComputer() {
        return computer;
    }
}
