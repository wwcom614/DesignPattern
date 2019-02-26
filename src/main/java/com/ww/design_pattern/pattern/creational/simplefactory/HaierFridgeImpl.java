package com.ww.design_pattern.pattern.creational.simplefactory;

import lombok.extern.java.Log;

@Log
public class HaierFridgeImpl extends Fridge {
    @Override
    public void getFridge() {
        log.info("【Haier】：produceFridge！");
    }
}
