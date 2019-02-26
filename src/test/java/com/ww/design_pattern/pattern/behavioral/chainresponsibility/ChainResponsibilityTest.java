package com.ww.design_pattern.pattern.behavioral.chainresponsibility;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChainResponsibilityTest {
    @Test
    public void testChainResponsibility() throws Exception {
        //创建责任链的处理者Handler
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler notSupportHandle = new NotSupportHandler();
        //客户端创建处理者的关联，形成责任链
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(notSupportHandle);
        //创建多种请求，每个请求模拟为一个数字，不同大小，归属相应正确的责任链Handler处理
        int[] requests = {0, 10, 11, 20, 21, -1};
        //调用处理器处理
        for (int request : requests) {
            handler1.requestHandle(request);
        }
        //【ConcreteHandler1】：处理了请求：0
        //【ConcreteHandler1】：处理了请求：10
        //【ConcreteHandler2】：处理了请求：11
        //【ConcreteHandler2】：处理了请求：20
        //【NotSupportHandler】：无法处理：21
        //【NotSupportHandler】：无法处理：-1
    }

}