package com.ww.design_pattern.pattern.structural.facade;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class StorageService {
    //校验用户要积分兑换的礼物库存
    public boolean isAvailable(PointsGift pointsGift) {
        log.info("【库存校验】：兑换礼物" + pointsGift.getName() + "库存充足！");
        return true;
    }
}
