package com.ww.design_pattern.pattern.creational.singleton;

//枚举类型单例模式
public enum EnumSingleton {
    INSTANCE{
    };

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
