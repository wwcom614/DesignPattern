package com.ww.design_pattern.principle.dependencyreverse;

//应用上层面向接口编程方法2：接口使用构造器注入
public class Customer2 {
    private IBuyItem iBuyItem;

    public Customer2(IBuyItem iBuyItem){
        this.iBuyItem = iBuyItem;

    };
    public void buyItem(){
        iBuyItem.buyItem();
    }
}
