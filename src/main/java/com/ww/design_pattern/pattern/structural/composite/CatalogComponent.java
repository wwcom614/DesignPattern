package com.ww.design_pattern.pattern.structural.composite;

//定义组合模式的顶层抽象构件类，是所有容器类和叶子类的公共父类。
//Leaf(叶子构件)和Composite(容器构件)都继承extends CatalogComponent，
//客户端作为调用方法只需要面向Component进行编程
public abstract class CatalogComponent {
    //因为如下方法Leaf或Composite不一定适用，所以要定义不被继承的默认处理。
    public void add(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持增加");
    }

    public void remove(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除");
    }

    public String getName(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取名称");
    }

    public double getPrice(CatalogComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取价格");
    }

    public void print(){
        throw new UnsupportedOperationException("不支持打印输出");
    }
}
