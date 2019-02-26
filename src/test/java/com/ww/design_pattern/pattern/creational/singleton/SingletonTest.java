package com.ww.design_pattern.pattern.creational.singleton;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.lang.reflect.Constructor;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonTest {

    //测试饿汉单例模式解决序列化和反序列化时的破坏问题
    @Test
    public void testSequenceHungrySingleton() throws Exception {
        //单例模式创建对象实例
        HungrySingleton hungrySingletonInstance = HungrySingleton.getInstance();

        //将单例创建的对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(hungrySingletonInstance);

        //将单例创建的对象反序列化
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        HungrySingleton seDeSingletonInstance = (HungrySingleton) ois.readObject();

        log.info("【hungrySingletonInstance】：" + hungrySingletonInstance);
        //【hungrySingletonInstance】：com.ww.design_pattern.pattern.creational.singleton.HungrySingleton@62fad19

        log.info("【seDeSingletonInstance】：" + seDeSingletonInstance);
        //【seDeSingletonInstance】：com.ww.design_pattern.pattern.creational.singleton.HungrySingleton@62fad19
    }


    //测试饿汉单例模式防范反射攻击
    @Test
    public void testReflectHungrySingleton() throws Exception {
        //反射攻击饿汉单例模式
        Class hungrySingletonClass = HungrySingleton.class;
        Constructor constructor = hungrySingletonClass.getDeclaredConstructor();
        //反射解锁类的private权限
        constructor.setAccessible(true);

        //反射创建对象实例
        HungrySingleton reflectInstance = (HungrySingleton) constructor.newInstance();
        //Caused by: java.lang.RuntimeException: 饿汉单例构造方法禁止反射调用！

        //饿汉单例模式创建对象实例，在类加载时就先创建好了
        HungrySingleton hungrySingletonInstance = HungrySingleton.getInstance();
    }

    //测试静态内部类单例模式防范反射攻击
    @Test
    public void testReflectStaticInnerClassSingleton() throws Exception {
        //反射攻击静态内部类单例模式
        Class staticInnerClassSingletonClass = StaticInnerClassSingleton.class;
        Constructor constructor = staticInnerClassSingletonClass.getDeclaredConstructor();
        //反射解锁类的private权限
        constructor.setAccessible(true);

        //反射创建对象实例
        StaticInnerClassSingleton reflectInstance = (StaticInnerClassSingleton) constructor.newInstance();
        //Caused by: java.lang.RuntimeException: 静态内部类单例构造方法禁止反射调用！

        //静态内部类单例模式创建对象实例，在类加载时就先创建好了
        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
    }

    //测试单例模式解决序列化和反序列化时对枚举单例模式的破坏问题
    @Test
    public void testSequenceEnumSingleton() throws Exception {
        //单例模式创建对象实例
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        enumSingleton.setData(new Object());

        //将单例创建的对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(enumSingleton);

        //将单例创建的对象反序列化
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        EnumSingleton seDeSingletonInstance = (EnumSingleton) ois.readObject();

        log.info("【enumSingleton.getData()】：" + enumSingleton.getData());
        //【enumSingleton.getData()】：java.lang.Object@2756c0a7

        log.info("【seDeSingletonInstance.getData()】：" + seDeSingletonInstance.getData());
        //【seDeSingletonInstance.getData()】：java.lang.Object@2756c0a7
    }

    //测试静态内部类单例模式防范反射攻击
    @Test
    public void testReflectEnumSingleton() throws Exception {
        //反射攻击静态内部类单例模式
        Class enumSingletonClass = EnumSingleton.class;
        //Enum没有无参构造方法
        Constructor constructor = enumSingletonClass.getDeclaredConstructor(String.class, int.class);
        //反射解锁类的private权限
        constructor.setAccessible(true);

        //反射创建对象实例
        EnumSingleton reflectInstance = (EnumSingleton) constructor.newInstance("ww", 666);
        //java.lang.IllegalArgumentException: Cannot reflectively create enum objects

        //枚举单例模式创建对象实例，在类加载时就先创建好了
        EnumSingleton enumSingleton = EnumSingleton.getInstance();

    }
}