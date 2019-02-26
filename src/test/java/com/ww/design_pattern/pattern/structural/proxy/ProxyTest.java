package com.ww.design_pattern.pattern.structural.proxy;

import com.ww.design_pattern.pattern.structural.proxy.dynamicproxy.OrderServiceDynamicProxy;
import com.ww.design_pattern.pattern.structural.proxy.model.Order;
import com.ww.design_pattern.pattern.structural.proxy.service.IOrderService;
import com.ww.design_pattern.pattern.structural.proxy.service.OrderServiceImpl;
import com.ww.design_pattern.pattern.structural.proxy.staticproxy.OrderServiceStaticProxy;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxyTest {

    @Resource
    OrderServiceStaticProxy orderServiceStaticProxy;

    @Test
    public void testStaticProxyUserId1() throws Exception {
        Order order = new Order();
        order.setUserId(1);
        orderServiceStaticProxy.saveOrder(order);
        //【OrderServiceStaticProxy】：静态代理分配到【db1】处理数据
        //【OrderServiceStaticProxy】：静态代理-before，code...
        //【OrderServiceImpl】：Service层调用Dao层insert Order
        //【OrderDaoImpl】：Dao层insert Order成功
        //【OrderServiceStaticProxy】：静态代理-after，code...
    }

    @Test
    public void testStaticProxyUserId2() throws Exception {
        Order order = new Order();
        order.setUserId(2);
        orderServiceStaticProxy.saveOrder(order);
        //【OrderServiceStaticProxy】：静态代理分配到【db0】处理数据
        //【OrderServiceStaticProxy】：静态代理-before，code...
        //【OrderServiceImpl】：Service层调用Dao层insert Order
        //【OrderDaoImpl】：Dao层insert Order成功
        //【OrderServiceStaticProxy】：静态代理-after，code...
    }

    @Test
    public void testDynamicProxyUserId1() throws Exception {
        Order order = new Order();
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderServiceDynamicProxy.saveOrder(order);
    }
}