package com.ww.design_pattern.pattern.behavioral.visitor;


import lombok.AllArgsConstructor;
import lombok.Data;

//IBill的具体支出实现类
@AllArgsConstructor
@Data
public class ExpenseBill implements IBill {

    //支出项名称
    private String itemName;
    //支出项金额
    private Double expenseAmount;
    //支出项返现金额
    private Double bonusAmount;

    //重写实现accept方法，以抽象访问者为入参，接受访问者对自身的访问。
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
