package com.ww.design_pattern.pattern.behavioral.templatemethod;

import lombok.extern.java.Log;

@Log
public abstract class TemplateMethod {

    //固化不变的行为--final方法1
    final void fixedMethod1() {
        log.info("【TemplateMethod】：fixedMethod1");
    }

    //固化不变的行为--final方法2
    final void fixedMethod2() {
        log.info("【TemplateMethod】：fixedMethod2");
    }

    //可选固化行为--钩子方法
    protected boolean needHoodMethod(){
        return false;
    }
    final void hookMethod(){
        log.info("【TemplateMethod】：hookMethod");
    }

    //非模板方法，允许继承子类自行实现
    abstract void variableMethod();

    //定义模板方法：将不变的行为(方法)和流程(方法执行顺序)固化为模板(final类型)
    protected final void makeTemplate(){
        this.fixedMethod1();
        if(needHoodMethod()){
            this.hookMethod();
        }
        this.fixedMethod2();

        this.variableMethod();
    }



}
