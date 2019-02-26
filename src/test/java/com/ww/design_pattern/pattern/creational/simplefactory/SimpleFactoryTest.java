package com.ww.design_pattern.pattern.creational.simplefactory;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleFactoryTest {
    @Test
    public void testSimpleFactoryBySwitch() throws Exception {
        SimpleFactory simpleFactory = new SimpleFactory();
        Fridge fridge = simpleFactory.produceFridge("Haier");
        if(fridge == null){
            log.info("未找到产品类型！");
        }else {
            fridge.getFridge();
        }//【Haier】：produceFridge！
    }


    @Test
    public void testSimpleFactoryByReflection() throws Exception {
        SimpleFactory simpleFactory = new SimpleFactory();
        Fridge fridge = simpleFactory.produceFridge(HisenseFridgeImpl.class);
        if(fridge == null){
            log.info("未找到产品类型！");
        }else {
            fridge.getFridge();
        }//【Hisense】：produceFridge！
    }


}