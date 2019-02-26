package com.ww.design_pattern.pattern.creational.prototype;

public abstract class PrototypeParent implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
