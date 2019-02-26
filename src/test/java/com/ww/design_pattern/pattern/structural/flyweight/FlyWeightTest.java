package com.ww.design_pattern.pattern.structural.flyweight;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class FlyWeightTest {

    private static final String outerStateConCreteList[] = {"os1", "os2", "os3", "os4"};

    @Test
    public void testFlyWeight() throws Exception {
        for (int i = 0; i < 10; i++) {
            //随机得到一个outerStateConCrete名称
            String outerStateConCrete = outerStateConCreteList[(int) (Math.random() * outerStateConCreteList.length)];
            FlyWeight flyWeight = (FlyWeight) FlyWeightFactoryMethod.getFlyWeight(outerStateConCrete);
            flyWeight.doSomething();
        }
    }

    //JDK中的Integer类的valueOf方法，内部的IntegerCache就是享元对象，默认-128~127会缓存，没有才new；而如果范围之外直接new。
    @Test
    public void testIntegerCacheFlyWeight() throws Exception {
        Integer aCache = Integer.valueOf(127);
        Integer a = 127;
        log.info("【aCache == a】：" + (aCache == a));
        //【aCache == a】：true

        Integer bNoCache = Integer.valueOf(128);
        Integer b = 128;
        log.info("【bNoCache == b】：" + (bNoCache == b));
        //【bNoCache == b】：false
    }
}