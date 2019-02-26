package com.ww.design_pattern.principle.singleresponsibility;

//为商品的购买操作，定义了一个接口
public interface IBuyItem {
    void addShopCart();
    void queryStorage();
    void genOrder();
}
