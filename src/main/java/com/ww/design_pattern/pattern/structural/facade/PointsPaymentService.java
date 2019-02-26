package com.ww.design_pattern.pattern.structural.facade;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        //校验用户积分充足，扣减积分
        log.info("【积分支付】：兑换礼物" + pointsGift.getName() + "支付积分成功！");
        return true;
    }

}
