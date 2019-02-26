package com.ww.design_pattern.pattern.structural.proxy.dynamicproxy;


import com.ww.design_pattern.pattern.structural.proxy.db.DataSourceContextHolder;
import com.ww.design_pattern.pattern.structural.proxy.model.Order;
import lombok.extern.java.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//orderService的动态代理
@Log
public class OrderServiceDynamicProxy implements InvocationHandler {
    //要代理的对象
    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    //编写动态绑定对象方法：动态代理的核心--通过Proxy的newProxyInstance方法来创建动态代理对象
    //第1个参数 target.getClass().getClassLoader()，传入被代理对象的类加载器。
    //第2个参数target.getClass().getInterfaces()，传入代理需要实现的接口
    //第3个参数handler，传入调用处理器。
    public Object bind() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    //invoke的参数proxy很少使用。参数Method是要被增强的方法对象，args是Method的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //动态代理增加beforeMethod方法，增强被代理对象
        beforeMethod(args[0]);

        //动态代理保护被代理对象
        Object object = method.invoke(target, args);

        //动态代理增加afterMethod方法，增强被代理对象
        afterMethod();
        return object;
    }

    private void beforeMethod(Object obj) {
        int userId = 0;
        //动态代理类比静态代理灵活，一个动态代理可以代理多个被代理类，区分实例判断，然后针对性处理
        if (obj instanceof Order) {
            Order order = (Order) obj;
            userId = order.getUserId();
        }
        int dbRouter = userId % 2;
        //设置dataSource;
        DataSourceContextHolder.setDBSource("db" + String.valueOf(dbRouter));
        log.info("【OrderServiceDynamicProxy】：动态代理分配到【db" + dbRouter + "】处理数据");
        log.info("【OrderServiceDynamicProxy】：动态代理-before，code...");

    }

    private void afterMethod() {
        log.info("【OrderServiceDynamicProxy】：动代理-after，code...");
    }
}
