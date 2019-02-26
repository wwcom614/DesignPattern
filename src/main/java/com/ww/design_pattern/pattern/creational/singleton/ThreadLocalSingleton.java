package com.ww.design_pattern.pattern.creational.singleton;

//ThreadLocal的单例模式，在每个Thread内部是单例
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance
             = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    private ThreadLocalSingleton(){

    }
    //ThreadLocalMap做线程间隔离
    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

}
