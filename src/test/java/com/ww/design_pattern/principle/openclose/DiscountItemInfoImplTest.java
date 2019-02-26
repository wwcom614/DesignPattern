package com.ww.design_pattern.principle.openclose;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountItemInfoImplTest {

    @Test
    public void getDiscountPrice() throws Exception {
        IGetItemInfo iGetItemInfo = new DiscountItemInfoImpl(1, "保温杯", BigDecimal.valueOf(250.83));
        DiscountItemInfoImpl discountItem = (DiscountItemInfoImpl) iGetItemInfo;
        log.info("【商品ID】：" + discountItem.getId()
                + "，【商品名称】：" + discountItem.getName()
                +"，【商品原价】：" + discountItem.getPrice()
                +"，【商品打折价】：" + discountItem.getDiscountPrice() );
        //【商品ID】：1，【商品名称】：保温杯，【商品原价】：250.83，【商品打折价】：200.664
    }

}