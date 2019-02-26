package com.ww.design_pattern.principle.singleresponsibility;

//为商品的退订操作，定义了一个接口
public interface IRefundItem {
    void cancelOrder();
    void refundMoney();
}
