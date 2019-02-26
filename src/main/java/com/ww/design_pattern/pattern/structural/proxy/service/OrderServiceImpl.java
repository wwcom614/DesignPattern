package com.ww.design_pattern.pattern.structural.proxy.service;

import com.ww.design_pattern.pattern.structural.proxy.dao.IOrderDao;
import com.ww.design_pattern.pattern.structural.proxy.model.Order;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Log
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        log.info("【OrderServiceImpl】：Service层调用Dao层insert Order");
        return iOrderDao.insert(order);
    }

}
