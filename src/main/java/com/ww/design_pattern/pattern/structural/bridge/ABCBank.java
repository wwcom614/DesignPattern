package com.ww.design_pattern.pattern.structural.bridge;

import lombok.extern.java.Log;

@Log
public class ABCBank extends Bank {
    public ABCBank(IDeposit deposit) {
        super(deposit);
    }

    @Override
    IDeposit openDeposit() {
        //抽象父类中组合了接口实现deposit的定义，继承子类可直接使用
        deposit.open();
        log.info("【ABCBank】：农业银行开立一笔存款！");
        return deposit;
    }


}
