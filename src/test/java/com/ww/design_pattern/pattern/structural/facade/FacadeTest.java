package com.ww.design_pattern.pattern.structural.facade;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTest {

    @Resource
    private GiftExchangeFacade giftExchangeFacade;

    @Test
    public void giftExchange() throws Exception {
        PointsGift pointsGift = new PointsGift("iPad");
        giftExchangeFacade.giftExchange(pointsGift);
    }
    /*
facade.StorageService          : 【库存校验】：兑换礼物iPad库存充足！
facade.PointsPaymentService    : 【积分支付】：兑换礼物iPad支付积分成功！
facade.ShippingService         : 【物流发货】：iPad发货成功！
facade.GiftExchangeFacade      : 【物流订单】：12345
    */

}