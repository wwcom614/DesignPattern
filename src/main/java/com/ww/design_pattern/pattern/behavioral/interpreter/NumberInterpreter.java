package com.ww.design_pattern.pattern.behavioral.interpreter;

//实现用户输入字符串转int的解释器具体类
public class NumberInterpreter implements IInterpreter {

    private int number;

    public NumberInterpreter(int number){
        this.number = number;
    }

    public NumberInterpreter(String number){
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret() {
        return this.number;
    }
}
