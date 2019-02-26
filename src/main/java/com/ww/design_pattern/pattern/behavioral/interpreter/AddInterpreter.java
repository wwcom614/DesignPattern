package com.ww.design_pattern.pattern.behavioral.interpreter;

//实现加法操作符的解释器具体类
public class AddInterpreter implements IInterpreter {

    private IInterpreter firstNumber, secondNumber;

    public AddInterpreter(IInterpreter firstNumber, IInterpreter secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int interpret() {
        return this.firstNumber.interpret() + this.secondNumber.interpret();
    }

    @Override
    public String toString(){
        return "+";
    }
}
