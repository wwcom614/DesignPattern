package com.ww.design_pattern.principle.openclose;

import java.math.BigDecimal;

//IGetItemInfo的接口实现类
public class ItemInfoImpl implements IGetItemInfo {

    private Integer id;
    private String name;
    private BigDecimal price;

    public ItemInfoImpl(Integer id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }
}
