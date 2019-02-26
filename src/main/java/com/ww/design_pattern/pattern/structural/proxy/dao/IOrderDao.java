package com.ww.design_pattern.pattern.structural.proxy.dao;


import com.ww.design_pattern.pattern.structural.proxy.model.Order;

public interface IOrderDao {
    int insert(Order order);

}
