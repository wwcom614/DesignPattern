package com.ww.design_pattern.pattern.behavioral.command;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandTest {

    @Test
    public void testCommand() throws Exception {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();
        invoker.setCommand(new ConcreteCommand1(receiver));
        invoker.excuteCommand();
        //【Receiver】：doB
        //【Receiver】：doA
        //【ConcreteCommand1】：B and A have been done!
        invoker.undoCommand();
        //【Receiver】：unDoA
        //【Receiver】：unDoB
        //【ConcreteCommand1】：A and B memento have been backout!

        invoker.setCommand(new ConcreteCommand2(receiver));
        invoker.excuteCommand();
        //【Receiver】：doC
        //【Receiver】：doA
        //【Receiver】：doB
        //【ConcreteCommand2】：C, A and B have been done!
        invoker.undoCommand();
        //【Receiver】：unDoB
        //【Receiver】：unDoA
        //【Receiver】：unDoC
        //【ConcreteCommand2】：B, A and C memento have been backout!
    }

}