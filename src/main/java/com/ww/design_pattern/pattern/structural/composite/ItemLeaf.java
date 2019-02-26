package com.ww.design_pattern.pattern.structural.composite;

import lombok.extern.java.Log;

@Log
//商品Item是该组合模式的Leaf(叶子构件)
public class ItemLeaf extends CatalogComponent {

    private String name;
    private Double price;

    public ItemLeaf(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    //可以获取商品名称
    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    //可以获取商品价格
    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    //商品支持打印输出
    @Override
    public void print() {
        log.info("【Item Name】：" + name + " 【Item Price】：" + price);
    }

}
