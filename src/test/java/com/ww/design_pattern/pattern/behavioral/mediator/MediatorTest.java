package com.ww.design_pattern.pattern.behavioral.mediator;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class MediatorTest {
    @Test
    public void testMediator() throws Exception {
        User li_lei = new User("Li Lei");
        User han_mei_mei = new User("Han Meimei");

        li_lei.sendMessage("How are you?");
        //【Chat】：[Li Lei]sendGroupMsg[How are you?]

        han_mei_mei.sendMessage("Fine, thank you! And you?");
        //【Chat】：[Han Meimei]sendGroupMsg[Fine, thank you! And you?]

        li_lei.sendMessage("I'm fine, too!");
        //Chat】：[Li Lei]sendGroupMsg[I'm fine, too!]
    }

}