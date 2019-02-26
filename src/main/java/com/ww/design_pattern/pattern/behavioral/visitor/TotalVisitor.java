package com.ww.design_pattern.pattern.behavioral.visitor;

import lombok.extern.java.Log;

//访问者的具体实现类，模拟BOSS查看总的盈亏情况
@Log
public class TotalVisitor implements IVisitor {

    private Double totalIncome = 0.0;
    private Double totalTax = 0.0;
    private Double totalExpense = 0.0;
    private Double totalBonus = 0.0;

    @Override
    public void visit(ExpenseBill expenseBill) {
        totalExpense += expenseBill.getExpenseAmount();
        totalBonus += expenseBill.getBonusAmount();
    }

    @Override
    public void visit(IncomeBill incomeBill) {
        totalIncome += incomeBill.getIncomeAmount();
        totalTax += incomeBill.getTaxAmount();
    }

    public void getTotal() {
        log.info("【TotalVisitor】总支出：" + totalExpense);
        log.info("【TotalVisitor】总返现：" + totalBonus);
        log.info("【TotalVisitor】总收入：" + totalIncome);
        log.info("【TotalVisitor】总交税；" + totalTax);
        Double profitLoss = totalIncome - totalTax - totalExpense + totalBonus;
        log.info("【TotalVisitor】总盈亏；" + profitLoss);
    }
}
