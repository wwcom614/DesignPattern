package com.ww.design_pattern.principle.openclose;


import java.math.BigDecimal;

//为一个商品常用操作，定义了一个接口
public interface IGetItemInfo {
    Integer getId();
    String getName();
    BigDecimal getPrice();
}
