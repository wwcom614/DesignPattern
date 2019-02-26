package com.ww.design_pattern.principle.dependencyreverse;

//应用上层面向接口编程方法3：接口使用setter方法注入
public class Customer3 {
    private IBuyItem iBuyItem;

    public void setiBuyItem(IBuyItem iBuyItem){
        this.iBuyItem = iBuyItem;
    }

    public void buyItem(){
        iBuyItem.buyItem();
    }
}
