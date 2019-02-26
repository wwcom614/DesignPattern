package com.ww.design_pattern.pattern.behavioral.visitor;

//一个比较稳定的对象结构，例如账单Bill稳定的只有收入Income和支出Expense两个功能
public interface IBill {
    //拥有一个accept方法，该方法以一个抽象访问者IVisitor作为参数，用来接受访问者对象的访问。
    void accept(IVisitor visitor);
}
