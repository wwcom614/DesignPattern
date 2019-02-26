package com.ww.design_pattern.pattern.behavioral.observer;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObserverTest {
    @Test
    public void testObserver() throws Exception {
        Publish publishWW = new Publish("publishWW");
        BroadcastObject broadcastObject = new BroadcastObject();
        broadcastObject.setBroadcastObjectName("This is the Notice Content");
        Subscribe subscribe1 = new Subscribe("subscribe1", publishWW);
        Subscribe subscribe2 = new Subscribe("subscribe2", publishWW);


        publishWW.setPublishData("PublishData bala bala", broadcastObject);
        //【Subscribe-Observer】：[publishWW]的数据[PublishData bala bala]发生变更，发送通知给[subscribe2]，通知内容是[This is the Notice Content]！
        //【Subscribe-Observer】：[publishWW]的数据[PublishData bala bala]发生变更，发送通知给[subscribe1]，通知内容是[This is the Notice Content]！

        publishWW.setPublishData("PublishData bala bala", broadcastObject);
        //【Publish-Observable】：publishData未改变，不通知！
    }
}