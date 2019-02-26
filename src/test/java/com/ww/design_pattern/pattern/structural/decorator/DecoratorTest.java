package com.ww.design_pattern.pattern.structural.decorator;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class DecoratorTest {
//装饰类以核心抽象类为参数，以核心抽象类为入参，构造方法装饰处理后，实例化出装饰好的核心抽象类。
    @Test
    public void testDecorator() throws Exception {
        AbstractPancake abstractPancake;
        abstractPancake = new Pancake();
        abstractPancake = new SausageDecorator(abstractPancake);
        abstractPancake = new EggDecorator(abstractPancake);
        abstractPancake = new SausageDecorator(abstractPancake);


        log.info("【Decorator】：" + abstractPancake.getDesc()
                + "【Price(¥)】：" + abstractPancake.getPrice());
        //【Decorator】：老板，来1个煎饼 加1个香肠 加1个鸡蛋 加1个香肠【Price(¥)】：16
    }
}