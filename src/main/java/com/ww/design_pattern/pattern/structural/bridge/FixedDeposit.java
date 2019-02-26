package com.ww.design_pattern.pattern.structural.bridge;

import lombok.extern.java.Log;

@Log
public class FixedDeposit implements IDeposit {
    @Override
    public IDeposit open() {
        log.info("【FixedDeposit】：开立一笔定期存款！");
        return new FixedDeposit();
    }

    @Override
    public void getType() {
        log.info("【FixedDeposit】：这是一笔定期存款！");
    }
}
