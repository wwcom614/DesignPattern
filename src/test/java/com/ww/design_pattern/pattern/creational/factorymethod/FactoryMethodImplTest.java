package com.ww.design_pattern.pattern.creational.factorymethod;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryMethodImplTest {

    @Test
    public void testHaierFactoryMethod() throws Exception {
        FactoryMethod factoryMethod = new HaierFactoryMethodImpl();
        Fridge fridge = factoryMethod.produceFridge();
        fridge.getFridge();
    }
    //【Haier】：produceFridge！

    @Test
    public void testHisenseFactoryMethod() throws Exception {
        FactoryMethod factoryMethod = new HisenseFactoryMethodImpl();
        Fridge fridge = factoryMethod.produceFridge();
        fridge.getFridge();
    }
    //【Hisense】：produceFridge！

}