package com.ww.design_pattern.pattern.behavioral.visitor;

import lombok.extern.java.Log;

//访问者的具体实现类，模拟财务查看每笔交易情况
@Log
public class ListVisitor implements IVisitor {
    private String item;
    private Double income = 0.0;
    private Double tax = 0.0;
    private Double expense = 0.0;
    private Double bonus = 0.0;

    @Override
    public void visit(ExpenseBill expenseBill) {
        item = expenseBill.getItemName();
        expense = expenseBill.getExpenseAmount();
        bonus = expenseBill.getBonusAmount();
        this.getList(expenseBill);
    }

    @Override
    public void visit(IncomeBill incomeBill) {
        item = incomeBill.getItemName();
        income = incomeBill.getIncomeAmount();
        tax = incomeBill.getTaxAmount();
        this.getList(incomeBill);
    }

    public void getList(IBill bill) {
        if(bill instanceof IncomeBill){
            log.info("【ListVisitor】收入项：" + item + "，收入(元)：" + income + "，交税(元)：" + tax);
        }else if(bill instanceof ExpenseBill){
            log.info("【ListVisitor】支出项：" + item + "，支出(元)：" + expense + "，返现(元)：" + bonus);
        }else {
            log.info("【ListVisitor】:账单格式非法！");
        }


    }
}
