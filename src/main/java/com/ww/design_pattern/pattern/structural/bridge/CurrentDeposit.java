package com.ww.design_pattern.pattern.structural.bridge;

import lombok.extern.java.Log;

@Log
public class CurrentDeposit implements IDeposit {
    @Override
    public IDeposit open() {
        log.info("【CurrentDeposit】：开立一笔活期存款！");
        return new CurrentDeposit();
    }

    @Override
    public void getType() {
        log.info("【CurrentDeposit】：这是一笔活期存款！");
    }
}
