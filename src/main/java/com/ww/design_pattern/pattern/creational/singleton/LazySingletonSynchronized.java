package com.ww.design_pattern.pattern.creational.singleton;

//懒汉单例模式，getInstance静态方法加锁，保证线程安全。相当于锁住整个类。性能不好。
public class LazySingletonSynchronized {
    private static LazySingletonSynchronized lazySingletonSynchronized = null;
    private LazySingletonSynchronized(){
        if(lazySingletonSynchronized != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }
    //getInstance静态方法加锁，保证线程安全。相当于锁住整个类。性能不好
    public synchronized static LazySingletonSynchronized getInstance(){
        if(lazySingletonSynchronized == null){
            lazySingletonSynchronized = new LazySingletonSynchronized();
        }
        return lazySingletonSynchronized;
    }

}
