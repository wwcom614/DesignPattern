package com.ww.design_pattern.pattern.behavioral.visitor;


import lombok.AllArgsConstructor;
import lombok.Data;

//IBill的具体收入实现类
@AllArgsConstructor
@Data
public class IncomeBill implements IBill {

    //收入项名称
    private String itemName;
    //收入项金额
    private Double incomeAmount;
    //收入项交税金额
    private Double taxAmount;

    //重写实现accept方法，以抽象访问者为入参，接受访问者对自身的访问。
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
