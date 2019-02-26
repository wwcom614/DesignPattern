package com.ww.design_pattern.pattern.behavioral.interpreter;

import lombok.extern.java.Log;

import java.util.Stack;

@Log
public class CustomizedExpressionParser {

    //使用栈(先进后出)来存放用户每次输入
    private Stack<IInterpreter> stack = new Stack<>();

    public int parse(String input) {
        //用户输入字符串，约定空格作为分隔符，分隔为每个解释器需要解释的字符，存入StringList。
        String[] symbolList = input.split(" ");
        for (String symbol : symbolList) {//循环遍历该StringList
            if (!OperatorUtil.isOperator(symbol)) {//如果字符不是加法或乘法符号，按约定用户输入的是数字
                //构造出对应的数字解释器，压入栈中
                IInterpreter numberInterpreter = new NumberInterpreter(symbol);
                stack.push(numberInterpreter);
                log.info("【CustomizedExpressionParser】：入栈数字" + symbol);
            } else {//否则，按约定用户输入的是加法或乘法运算符，把前面2个数字解释器先从栈里pop出来
                IInterpreter firstNumber = stack.pop();
                IInterpreter secondNumber = stack.pop();
                log.info("【CustomizedExpressionParser】：运算符" + symbol);
                log.info("【CustomizedExpressionParser】：出栈数字" + firstNumber.interpret());
                log.info("【CustomizedExpressionParser】：出栈数字" + secondNumber.interpret());

                //调用OperatorUtil执行相应的加法或乘法运算，计算出的阶段性结果，NumberInterpreter构造为解释器入栈。
                int result = OperatorUtil.getExpressionResult(firstNumber, secondNumber, symbol).interpret();
                NumberInterpreter resultNumberInterpreter = new NumberInterpreter(result);
                stack.push(resultNumberInterpreter);
                log.info("【CustomizedExpressionParser】："
                        + secondNumber.interpret() + symbol + firstNumber.interpret() + "="
                        + result + "，阶段性计算结果入栈");
            }
        }
        //用户输入字符遍历完成，输出最终结果(栈内唯一的值)
        int result = stack.pop().interpret();
        return result;
    }
}
