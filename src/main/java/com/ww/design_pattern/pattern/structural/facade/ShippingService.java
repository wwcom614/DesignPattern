package com.ww.design_pattern.pattern.structural.facade;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class ShippingService {
    public String shipGift(PointsGift pointsGift){
        //物流系统的对接逻辑
        log.info("【物流发货】：" + pointsGift.getName() + "发货成功！");

        String shippingOrderNo = "12345";
        return shippingOrderNo;
    }
}
