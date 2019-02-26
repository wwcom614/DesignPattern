package com.ww.design_pattern.pattern.behavioral.observer;

import lombok.extern.java.Log;

import java.util.Observable;
import java.util.Observer;

@Log
public class Subscribe implements Observer {
    private String subscribeName;

    //构造方法，将订阅者放入观察者Vector中
    public Subscribe(String subscribeName, Observable o) {
        o.addObserver(this);
        this.subscribeName = subscribeName;
    }

    //重写Observer的update方法，入参中的Observable o是被观察者对象， Object arg是被观察者notifyObservers的入参对象。
    @Override
    public void update(Observable o, Object arg) {
        String publishName = ((Publish) o).getPublishName();
        String publishData = ((Publish) o).getPublishData();
        String broadcastObjectName = ((BroadcastObject) arg).getBroadcastObjectName();
        log.info("【Subscribe-Observer】：[" + publishName + "]的数据["
                + publishData + "]发生变更，发送通知给[" + subscribeName
                + "]，通知内容是[" + broadcastObjectName + "]！");
    }
}
