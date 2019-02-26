package com.ww.design_pattern.pattern.structural.proxy.service;


import com.ww.design_pattern.pattern.structural.proxy.model.Order;

public interface IOrderService {
    int saveOrder(Order order);
}
