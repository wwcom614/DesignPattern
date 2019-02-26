package com.ww.design_pattern.pattern.creational.prototype;

import java.util.Date;

public class DeepClonePerson implements Cloneable{
    public DeepClonePerson(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    private String name;
    private Date birthday;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}'+super.toString();
    }

    //深拷贝，常用，重要！
    @Override
    protected Object clone() throws CloneNotSupportedException{
        DeepClonePerson deepClonePerson = (DeepClonePerson) super.clone();
        deepClonePerson.birthday = (Date) deepClonePerson.birthday.clone();
        return deepClonePerson;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
