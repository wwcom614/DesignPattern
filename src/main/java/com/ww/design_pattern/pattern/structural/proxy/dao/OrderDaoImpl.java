package com.ww.design_pattern.pattern.structural.proxy.dao;


import com.ww.design_pattern.pattern.structural.proxy.model.Order;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;

@Repository
@Log
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        log.info("【OrderDaoImpl】：Dao层insert Order成功");
        return 1;
    }
}
