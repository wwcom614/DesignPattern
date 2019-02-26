package com.ww.design_pattern.pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

//编写工厂方法，内部使用了策略模式封装不同的营销策略PromotionStrategy
public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    private static final PromotionStrategy NO_PROMOTION_STRATEGY = new NoPromotionStrategy();

    static {
        PROMOTION_STRATEGY_MAP.put("ReturnCashItems", new ReturnCashPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put("MoneyOffItems", new MoneyOffPromotionStrategy());
    }

    //不想对外暴露构造方法
    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String itemPromotionStrategy) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(itemPromotionStrategy);
        return promotionStrategy == null ? NO_PROMOTION_STRATEGY : promotionStrategy;
    }
}
