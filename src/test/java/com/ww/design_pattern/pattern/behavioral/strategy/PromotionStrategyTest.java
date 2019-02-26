package com.ww.design_pattern.pattern.behavioral.strategy;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionStrategyTest {

    @Test
    public void testReturnCashPromotionStrategy() throws Exception {
        String itemPromotionType = "ReturnCashItems";
        PromotionCampaign promotionCampaign = new PromotionCampaign(PromotionStrategyFactory.getPromotionStrategy(itemPromotionType));
        promotionCampaign.executePromotionStrategy();
    }//【ReturnCashPromotionStrategy】：该商品参加返现促销,返现将存放到您的账户余额中。

    @Test
    public void testMoneyOffPromotionStrategy() throws Exception {
        String itemPromotionType = "MoneyOffItems";
        PromotionCampaign promotionCampaign = new PromotionCampaign(PromotionStrategyFactory.getPromotionStrategy(itemPromotionType));
        promotionCampaign.executePromotionStrategy();
    }//【MoneyOffPromotionStrategy】：该商品参加满减促销,满300元减20元

    @Test
    public void testNoPromotionStrategy() throws Exception {
        String itemPromotionType = "show me the money";
        PromotionCampaign promotionCampaign = new PromotionCampaign(PromotionStrategyFactory.getPromotionStrategy(itemPromotionType));
        promotionCampaign.executePromotionStrategy();
    }//【NoPromotionStrategy】：该商品不参加本次促销活动。

}