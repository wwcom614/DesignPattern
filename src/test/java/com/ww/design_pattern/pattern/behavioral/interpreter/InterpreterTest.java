package com.ww.design_pattern.pattern.behavioral.interpreter;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class InterpreterTest {

    @Test
    public void testInterpret() throws Exception {
        String inputStr = "2 3 4 + *";
        CustomizedExpressionParser wwExpressionParser = new CustomizedExpressionParser();
        int result = wwExpressionParser.parse(inputStr);
        log.info("【解释器执行】2 3 4 + * 结果是：" + result);
    }
    //【CustomizedExpressionParser】：入栈数字2
    //【CustomizedExpressionParser】：入栈数字3
    //【CustomizedExpressionParser】：入栈数字4
    //【CustomizedExpressionParser】：运算符+
    //【CustomizedExpressionParser】：出栈数字4
    //【CustomizedExpressionParser】：出栈数字3
    //【CustomizedExpressionParser】：3+4=7，阶段性计算结果入栈
    //【CustomizedExpressionParser】：运算符*
    //【CustomizedExpressionParser】：出栈数字7
    //【CustomizedExpressionParser】：出栈数字2
    //【CustomizedExpressionParser】：2*7=14，阶段性计算结果入栈
    //【解释器执行】2 3 4 + * 结果是：14


    @Test
    public void testSpelExpressionParser() throws Exception {

        String calStr = "2 + 3 * 4";
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(calStr);
        Integer result = (Integer) expression.getValue();
        log.info("【SpelExpression Result】:" + result);
        //【SpelExpression Result】:14
    }

}