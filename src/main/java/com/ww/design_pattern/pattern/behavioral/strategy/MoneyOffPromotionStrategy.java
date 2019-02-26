package com.ww.design_pattern.pattern.behavioral.strategy;

import lombok.extern.java.Log;

//商品促销--满减策略
@Log
public class MoneyOffPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        log.info("【MoneyOffPromotionStrategy】：该商品参加满减促销,满300元减20元。");
    }
}
