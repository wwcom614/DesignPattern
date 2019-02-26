package com.ww.design_pattern.principle.dependencyreverse;

//应用上层面向接口编程方法1：接口作为入参方法注入
public class Customer1 {
    public void buyItem(IBuyItem iBuyItem){
        iBuyItem.buyItem();
    }
}
