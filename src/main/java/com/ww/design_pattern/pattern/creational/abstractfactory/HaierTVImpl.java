package com.ww.design_pattern.pattern.creational.abstractfactory;

import lombok.extern.java.Log;

@Log
public class HaierTVImpl extends TV {
    @Override
    public void getTV() {
        log.info("【Haier】：produceTV！");
    }
}
