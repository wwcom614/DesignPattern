package com.ww.design_pattern.pattern.creational.prototype;

public class PrototypeChild extends PrototypeParent{

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeChild prototypeChild = new PrototypeChild();
        prototypeChild.clone();
    }
}
