package com.ww.design_pattern.pattern.behavioral.templatemethod;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateMethodTest {
    @Test
    public void testChildClass1() throws Exception {
        TemplateMethod childClass1 = new ChildClass1();
        childClass1.makeTemplate();
        //【TemplateMethod】：fixedMethod1
        //【TemplateMethod】：hookMethod
        //【TemplateMethod】：fixedMethod2
        //【ChildClass1】：variableMethod
    }


    @Test
    public void testChildClass2() throws Exception {
        TemplateMethod childClass2 = new ChildClass2(true);
        childClass2.makeTemplate();
        //【TemplateMethod】：fixedMethod1
        //【TemplateMethod】：hookMethod
        //【TemplateMethod】：fixedMethod2
        //【ChildClass2】：variableMethod
    }

}