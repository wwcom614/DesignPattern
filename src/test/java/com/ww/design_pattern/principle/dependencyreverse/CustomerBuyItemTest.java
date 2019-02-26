package com.ww.design_pattern.principle.dependencyreverse;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerBuyItemTest {

    //应用上层面向接口编程方法1，接口作为入参注入。
    @Test
    public void testCustomer1() throws Exception {
        Customer1 customer1 = new Customer1();
        log.info("---------------------------------");
        log.info("【custom1】:");
        customer1.buyItem(new ItemKeyboard());
        customer1.buyItem(new ItemMouse());
        log.info("---------------------------------");
    }

    //应用上层面向接口编程方法2：接口使用构造器注入
    @Test
    public void testCustomer2() throws Exception {
        Customer2 customer2 = new Customer2(new ItemKeyboard());
        log.info("---------------------------------");
        log.info("【custom2】:");
        customer2.buyItem();
        log.info("---------------------------------");
    }

    //应用上层面向接口编程方法3：接口使用setter方法注入
    @Test
    public void testCustomer3() throws Exception {
        Customer3 customer3 = new Customer3();
        log.info("---------------------------------");
        log.info("【custom3】:");
        customer3.setiBuyItem(new ItemKeyboard());
        customer3.buyItem();
        customer3.setiBuyItem(new ItemMouse());
        customer3.buyItem();
        log.info("---------------------------------");
    }

}