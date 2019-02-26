package com.ww.design_pattern.pattern.behavioral.interpreter;

public class OperatorUtil {
    //实现的操作符只支持加法和乘法
    public static boolean isOperator(String symbol) {
        return symbol.equals("+") || symbol.equals("*");
    }

    public static IInterpreter getExpressionResult(IInterpreter firstNumber, IInterpreter secondNumber, String symbol) {
        if (symbol.equals("+")) {//如果用户输入+，调用AddInterpreter构造方法
            return new AddInterpreter(firstNumber, secondNumber);
        } else if (symbol.equals("*")) {//如果用户输入+，调用MultiInterpreter构造方法
            return new MultiInterpreter(firstNumber, secondNumber);
        } else {//其他运算符不支持。简化起见返回null，会引起空指针异常。生产环境应该定义一个空解释器处理。
            return null;
        }
    }
}
