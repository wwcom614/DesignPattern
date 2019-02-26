package com.ww.design_pattern.pattern.creational.singleton;


//懒汉单例模式，双重检测+volatile禁止指令重排序，保证线程安全
public class LazySingletonDoubleCheck {
    private volatile static LazySingletonDoubleCheck lazySingletonDoubleCheck = null;
    private LazySingletonDoubleCheck(){

    }
    public static LazySingletonDoubleCheck getInstance(){
        if(lazySingletonDoubleCheck == null){
            synchronized (LazySingletonDoubleCheck.class){
                if(lazySingletonDoubleCheck == null){
                    lazySingletonDoubleCheck = new LazySingletonDoubleCheck();
                    //1.分配内存给这个对象
//                  //3.设置lazyDoubleCheckSingleton 指向刚分配的内存地址
                    //2.初始化对象
//                    intra-thread semantics
//                    ---------------//3.设置lazyDoubleCheckSingleton 指向刚分配的内存地址
                }
            }
        }
        return lazySingletonDoubleCheck;
    }
}
