package com.ww.design_pattern.pattern.behavioral.templatemethod;

import lombok.extern.java.Log;

@Log
public class ChildClass2 extends TemplateMethod {

    //提供方法入参，转交给调用方决定是否使用父类TemplateMethod的钩子方法
    private boolean needHookMethodFlag = false;
    public ChildClass2(boolean needHookMethodFlag){
        this.needHookMethodFlag = needHookMethodFlag;
    }
    @Override
    protected boolean needHoodMethod(){
        return this.needHookMethodFlag;
    }

    @Override
    void variableMethod() {
        log.info("【ChildClass2】：variableMethod");
    }



}
