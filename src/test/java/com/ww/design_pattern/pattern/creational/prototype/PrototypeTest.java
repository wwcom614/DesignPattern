package com.ww.design_pattern.pattern.creational.prototype;

import com.ww.design_pattern.pattern.creational.singleton.HungrySingleton;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.Date;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrototypeTest {

    //测试原型模式的clone
    @Test
    public void testPrototype() throws Exception {
        Mail mail = new Mail();
        mail.setContent("原型的mail内容");
        log.info("【mail prototype】:" + mail);

        //克隆原型mail后发送
        for (int i = 0; i < 5; i++) {
            Mail mailClone = (Mail) mail.clone();
            mailClone.setEmailAddress("name" + i + "@ww.com");
            mailClone.setTitle("to dear name" + i);
            mailClone.setContent("恭喜发财！");
            MailUtil.sendMail(mailClone);
            log.info("【mail clone】:" + mailClone);
        }
        //保存原型mail
        MailUtil.saveOriginMailRecord(mail);
    }

    //测试浅拷贝
    @Test
    public void testShallowClonePerson() throws Exception {

        Date birthday = new Date(0L);
        ShallowClonePerson person = new ShallowClonePerson("ww", birthday);
        ShallowClonePerson shallowClonePerson = (ShallowClonePerson) person.clone();

        log.info("【person】：" + person);
//【person】：Person{name='ww', birthday=Thu Jan 01 08:00:00 CST 1970}com.ww.design_pattern.pattern.creational.prototype.ShallowClonePerson@350ec41e
        log.info("【shallowClonePerson】：" + shallowClonePerson);
//【shallowClonePerson】：Person{name='ww', birthday=Thu Jan 01 08:00:00 CST 1970}com.ww.design_pattern.pattern.creational.prototype.ShallowClonePerson@69637b10
        person.getBirthday().setTime(666666666666L);

        //person进行了浅拷贝，person.clone()将不会对其内部的引用变量date进行拷贝，导致原型对象person和浅拷贝克隆对象shallowClonePerson使用了相同的引用变量date
        //那么此时对原型对象person的引用变量date赋值，浅拷贝克隆对象shallowClonePerson的引用变量date也被相同赋值了
        log.info("【person】：" + person);
//【person】：Person{name='ww', birthday=Sat Feb 16 09:11:06 CST 1991}com.ww.design_pattern.pattern.creational.prototype.ShallowClonePerson@350ec41e
        log.info("【shallowClonePerson】：" + shallowClonePerson);
//【shallowClonePerson】：Person{name='ww', birthday=Sat Feb 16 09:11:06 CST 1991}com.ww.design_pattern.pattern.creational.prototype.ShallowClonePerson@69637b10
    }

    //测试深拷贝
    @Test
    public void testDeepClonePerson() throws Exception {

        Date birthday = new Date(0L);
        DeepClonePerson person = new DeepClonePerson("ww", birthday);
        DeepClonePerson deepClonePerson = (DeepClonePerson) person.clone();

        log.info("【person】：" + person);
//【person】：Person{name='ww', birthday=Thu Jan 01 08:00:00 CST 1970}com.ww.design_pattern.pattern.creational.prototype.DeepClonePerson@878452d
        log.info("【deepClonePerson】：" + deepClonePerson);
//【deepClonePerson】：Person{name='ww', birthday=Thu Jan 01 08:00:00 CST 1970}com.ww.design_pattern.pattern.creational.prototype.DeepClonePerson@426b6a74
        person.getBirthday().setTime(666666666666L);

        //person进行了深拷贝，person.clone()将其内部的引用变量date也进行了拷贝，原型对象person和浅拷贝克隆对象shallowClonePerson使用的是不同的引用变量date
        //那么此时对原型对象person的引用变量date赋值，浅拷贝克隆对象shallowClonePerson的引用变量date不受影响
        log.info("【person】：" + person);
//person】：Person{name='ww', birthday=Sat Feb 16 09:11:06 CST 1991}com.ww.design_pattern.pattern.creational.prototype.DeepClonePerson@878452d
        log.info("【deepClonePerson】：" + deepClonePerson);
//【deepClonePerson】：Person{name='ww', birthday=Thu Jan 01 08:00:00 CST 1970}com.ww.design_pattern.pattern.creational.prototype.DeepClonePerson@426b6a74
    }

    //测试克隆破坏单例
    @Test
    public void testCloneDestroySingleton() throws Exception {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();

        //反射获取饿汉单例模式内部定义的克隆方法
        Method cloneMethod = hungrySingleton.getClass().getDeclaredMethod("clone");
        cloneMethod.setAccessible(true);
        HungrySingleton cloneHungrySingleton = (HungrySingleton) cloneMethod.invoke(hungrySingleton);

        log.info("【hungrySingleton】："+hungrySingleton);
        log.info("【cloneHungrySingleton】："+cloneHungrySingleton);
    }
}