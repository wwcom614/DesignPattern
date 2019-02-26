package com.ww.design_pattern.pattern.creational.singleton;

import java.io.Serializable;


public class HungrySingleton implements Serializable,Cloneable{

    //类加载时候就初始化，可以直接定义为final，在类加载完成时完成赋值且不可更改。
    // 饿汉单例模式缺点是如果不用就浪费资源了
    private final static HungrySingleton hungrySingleton;

    static{
        hungrySingleton = new HungrySingleton();
    }

    //防范反射攻击
    private HungrySingleton(){
        if(hungrySingleton != null){
            throw new RuntimeException("饿汉单例构造方法禁止反射调用！");
        }
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    //单例模式需要解决序列化和反序列化时的破坏问题。
    //原因是序列化和反序列化时会反射生成新的对象，
    //定义一个readResolve方法，return自己已实例化的单例对象，而不是返回反射生成新的对象。
    private Object readResolve(){
        return hungrySingleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }
}
