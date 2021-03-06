package com.ww.design_pattern.pattern.creational.abstractfactory;

import lombok.extern.java.Log;

@Log
public class HaierFridgeImpl extends Fridge {
    @Override
    public void getFridge() {
        log.info("【Haier】：produceFridge！");
    }
}
