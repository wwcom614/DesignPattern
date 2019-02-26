package com.ww.design_pattern.pattern.behavioral.observer;

import lombok.extern.java.Log;

import java.util.Observable;

@Log
public class Publish extends Observable {
    private String publishName;
    private String publishData = "";

    public Publish(String publishName){
        this.publishName = publishName;
    }

    public String getPublishName(){
        return publishName;
    }

    public String getPublishData(){
        return publishData;
    }

    public void setPublishData(String publishData, BroadcastObject broadcastObject){
        if(!this.publishData.equals(publishData)){
            this.publishData = publishData;
            //订阅者关心的publishData发生改变
            setChanged();
        }else {
            log.info("【Publish-Observable】：publishData未改变，不通知！");
        }
        //调用父类Observable方法，通知所有观察者，notifyObservers可以参数携带通知内容对象
        notifyObservers(broadcastObject);
    }
}
