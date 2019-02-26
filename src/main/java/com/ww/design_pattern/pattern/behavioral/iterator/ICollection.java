package com.ww.design_pattern.pattern.behavioral.iterator;

//定义集合行为接口
public interface ICollection {
    void add(Element element);
    void remove(Element element);

    //集合的获取迭代器操作
    IIterator getIterator();
    //使用迭代器打印集合全部元素
    void iteratorPrintElement();
}
