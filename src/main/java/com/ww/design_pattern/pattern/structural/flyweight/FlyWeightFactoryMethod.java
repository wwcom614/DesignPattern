package com.ww.design_pattern.pattern.structural.flyweight;

import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

@Log
public class FlyWeightFactoryMethod {

    //建立存放享元的容器池。
    // 如果不涉及线程安全可以使用HashMap，
    // 如果涉及线程安全得使用ConcurrentHashMap，同时内部方法得加锁
    private static final Map<String, IFlyWeight> FLY_WEIGHT_MAP = new HashMap<>();

    public static IFlyWeight getFlyWeight(String outerStateConCrete) {
        //享元模式关键：判断该对象在容器池中是否已有
        if (FLY_WEIGHT_MAP.containsKey(outerStateConCrete)) {//如果该对象在容器池中已有，直接取出使用
            return FLY_WEIGHT_MAP.get(outerStateConCrete);
        } else {//如果该对象在容器池中没有，创建该对象并放入容器池
            FlyWeight flyWeight = new FlyWeight(outerStateConCrete);
            log.info("【FlyWeightFactoryMethod】：创建享元对象flyWeight成功。外部状态" + outerStateConCrete + "作为享元对象构造方法入参");

            String outerStateSetMethod = "【FlyWeightFactoryMethod】：外部状态" + outerStateConCrete + "作为享元对象set方法入参";
            flyWeight.setOuterStateConCrete(outerStateSetMethod);
            flyWeight.doSomething();
            FLY_WEIGHT_MAP.put(outerStateConCrete, flyWeight);
            return flyWeight;
        }
    }


}
