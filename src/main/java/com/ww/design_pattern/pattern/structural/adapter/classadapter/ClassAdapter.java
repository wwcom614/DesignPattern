package com.ww.design_pattern.pattern.structural.adapter.classadapter;

//类适配器extends Adaptee implements ITarget，使用类继承实现。
// 使用Adaptee被适配者的方法，实现ITarget目标方法。
public class ClassAdapter extends Adaptee implements ITarget {
    @Override
    public void targetMethod() {
        super.adapteeMethod();
    }
}
