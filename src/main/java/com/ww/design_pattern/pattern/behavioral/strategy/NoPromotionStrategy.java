package com.ww.design_pattern.pattern.behavioral.strategy;

import lombok.extern.java.Log;

//商品促销--不参加商品促销
@Log
public class NoPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        log.info("【NoPromotionStrategy】：该商品不参加本次促销活动。");
    }
}
