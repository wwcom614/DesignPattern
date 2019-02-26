package com.ww.design_pattern.pattern.behavioral.strategy;

//某次营销活动类
public class PromotionCampaign {
    private PromotionStrategy promotionStrategy;

    public PromotionCampaign(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionStrategy(){
        promotionStrategy.doPromotion();
    }

}
