package com.ww.design_pattern.pattern.structural.proxy.staticproxy;

import com.ww.design_pattern.pattern.structural.proxy.db.DataSourceContextHolder;
import com.ww.design_pattern.pattern.structural.proxy.model.Order;
import com.ww.design_pattern.pattern.structural.proxy.service.IOrderService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//orderService的静态代理
@Log
@Component
public class OrderServiceStaticProxy {

    @Resource
    private IOrderService orderService;

    public int saveOrder(Order order){

        //静态代理增加beforeMethod方法，增强被代理对象
        beforeMethod(order);

        //静态代理保护被代理对象
        int result = orderService.saveOrder(order);

        //静态代理增加afterMethod方法，增强被代理对象
        afterMethod();

        return result;
    }

    //代理增强原功能，模拟AOP的beforeAdvice
    private void beforeMethod(Order order){
        int userId = order.getUserId();

        //根据用户ID选择相应的DB
        int dbRouter = userId % 2;
        //设置dataSource;
        DataSourceContextHolder.setDBSource("db"+String.valueOf(dbRouter));
        log.info("【OrderServiceStaticProxy】：静态代理分配到【db"+dbRouter+"】处理数据");
        log.info("【OrderServiceStaticProxy】：静态代理-before，code...");
    }

    //代理增强原功能，模拟AOP的afterAdvice
    private void afterMethod(){
        log.info("【OrderServiceStaticProxy】：静态代理-after，code...");
    }
}
