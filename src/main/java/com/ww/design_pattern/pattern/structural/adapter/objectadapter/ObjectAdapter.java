package com.ww.design_pattern.pattern.structural.adapter.objectadapter;

//对象适配器implements ITarget，使用组合实现，符合组合-复用原则，使用委托机制。
// 内部实例化一个Adaptee对象，实现ITarget目标方法。
public class ObjectAdapter implements ITarget {
    //组合被适配者
    private Adaptee adaptee = new Adaptee();

    @Override
    public void targetMethod() {
        adaptee.adapteeMethod();
    }
}
