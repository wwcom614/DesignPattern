package com.ww.design_pattern.pattern.structural.facade;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//礼物积分兑换的外观门面
//为外部调用者提供统一接口服务，封装了内部的库存校验服务、积分支付服务和物流服务的细节
@Log
@Service
public class GiftExchangeFacade {
    @Resource
    private StorageService storageService;
    @Resource
    private PointsPaymentService pointsPaymentService;
    @Resource
    private ShippingService shippingService;

    public void giftExchange(PointsGift pointsGift){
        if(storageService.isAvailable(pointsGift)){//该物品有库存

            if(pointsPaymentService.pay(pointsGift)){//用户积分足够兑换该物品，兑换后扣减用户积分
                //通知物流服务发货
                String shippingOrderNo = shippingService.shipGift(pointsGift);
                log.info("【物流订单】："+shippingOrderNo);
            }
        }
    }

}
