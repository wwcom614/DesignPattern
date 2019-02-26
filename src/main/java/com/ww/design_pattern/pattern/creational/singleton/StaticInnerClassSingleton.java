package com.ww.design_pattern.pattern.creational.singleton;

//静态内部类实现单例，线程安全。基于类初始化的延迟加载，Class对象初始化时JVM加锁了，只有一个线程可以做这个事情
public class StaticInnerClassSingleton {
    private static class InnerClass{
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }
    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.staticInnerClassSingleton;
    }
    private StaticInnerClassSingleton(){
        if(InnerClass.staticInnerClassSingleton != null){
            throw new RuntimeException("静态内部类单例构造方法禁止反射调用！");
        }
    }


}
