package com.ww.design_pattern.pattern.behavioral.chainresponsibility;

//Handler处理者，定义了处理请求的接口，handler知道，下一个处理者是谁，如果自己无法处理请求，就转给下一个处理者。
public abstract class Handler {
    //nextHandler为protected，方便子类继承
    protected Handler nextHandler;

    //责任链核心：为当前Handler设置下一级Handler
    public void setNextHandler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    //定义抽象方法，对请求request的是自身处理还是交由下一个handler处理的判断逻辑让具体子类实现
    public abstract void requestHandle(int request);


}
