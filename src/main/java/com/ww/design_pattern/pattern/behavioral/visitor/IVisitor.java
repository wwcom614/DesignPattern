package com.ww.design_pattern.pattern.behavioral.visitor;

//定义访问者接口。访问者模式的前提，要访问对象的操作是稳定的，此时才能封装访问者
public interface IVisitor {
    //要访问对象的操作稳定，每个访问者都是2种操作：查看支出账单、查看收入账单。
    void visit(ExpenseBill expenseBill);
    void visit(IncomeBill incomeBill);


}
