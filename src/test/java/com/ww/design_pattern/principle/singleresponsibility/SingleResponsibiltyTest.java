package com.ww.design_pattern.principle.singleresponsibility;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingleResponsibiltyTest {

    //类的单一职责拆分，每个类中有自己特有的方法。
    @Test
    public void testClassSingleResponsibilty() throws Exception {
        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("麻雀");

        SwimBird walkBird = new SwimBird();
        walkBird.mainMoveMode("企鹅");
    }




}