package com.ww.design_pattern.pattern.creational.builder;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class Computer {

    //电脑组件的集合
    private List<String> parts = new ArrayList<>();

    //用于将需要的组件组装到电脑里
    public void add(String part){
        parts.add(part);
    }

    public void show(){
        for (int i = 0;i<parts.size();i++){
            log.info("【组件】"+parts.get(i)+"安装完成!");
        }
        log.info("电脑组装完成，请验收!");

    }


}
