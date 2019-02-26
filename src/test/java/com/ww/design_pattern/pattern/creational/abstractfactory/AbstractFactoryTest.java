package com.ww.design_pattern.pattern.creational.abstractfactory;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class AbstractFactoryTest {
    @Test
    public void testHaierAbstractFactory() throws Exception {
        AbstractFactory haierFactory = new HaierAbstractFactoryImpl();
        Fridge haierFridge = haierFactory.produceFridge();

        haierFridge.getFridge();
        //【Haier】：produceFridge！

        TV haierTV = haierFactory.produceTV();
        haierTV.getTV();
        //【Haier】：produceTV！
    }

    @Test
    public void testHisenseAbstractFactory() throws Exception {
        AbstractFactory hisenseFactory = new HisenseAbstractFactoryImpl();
        Fridge hisenseFridge = hisenseFactory.produceFridge();

        hisenseFridge.getFridge();
        //【Hisense】：produceFridge！

        TV hisenseTV = hisenseFactory.produceTV();
        hisenseTV.getTV();
        //【Hisense】：produceTV！
    }
}