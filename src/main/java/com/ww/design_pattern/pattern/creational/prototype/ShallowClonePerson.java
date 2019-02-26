package com.ww.design_pattern.pattern.creational.prototype;

import java.util.Date;

public class ShallowClonePerson implements Cloneable{
    public ShallowClonePerson(String name, Date birthday) {
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

    //浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
