package com.ww.design_pattern.pattern.behavioral.strategy;

import lombok.extern.java.Log;

//商品促销--返现策略
@Log
public class ReturnCashPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        log.info("【ReturnCashPromotionStrategy】：该商品参加返现促销,返现将存放到您的账户余额中。");
    }
}
