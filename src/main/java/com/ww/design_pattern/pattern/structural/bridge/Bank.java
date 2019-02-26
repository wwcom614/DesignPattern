package com.ww.design_pattern.pattern.structural.bridge;

public abstract class Bank {
    //桥接模式核心：在抽象类(抽象)中组合接口(实现)，子类拿起来就用
    protected IDeposit deposit;

    public Bank(IDeposit deposit){
        this.deposit = deposit;
    }

    abstract IDeposit openDeposit();

}
