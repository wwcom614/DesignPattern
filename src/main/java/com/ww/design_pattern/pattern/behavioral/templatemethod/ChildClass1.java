package com.ww.design_pattern.pattern.behavioral.templatemethod;

import lombok.extern.java.Log;

@Log
public class ChildClass1 extends TemplateMethod {
    //继承子类直接定义是否使用父类TemplateMethod的钩子方法
    @Override
    protected boolean needHoodMethod(){
        return true;
    }

    @Override
    void variableMethod() {
        log.info("【ChildClass1】：variableMethod");
    }

}
