package com.ww.design_pattern.pattern.behavioral.iterator;

//定义迭代器行为接口
public interface IIterator {
    Element nextElement();
    Boolean isLastElement();
}
