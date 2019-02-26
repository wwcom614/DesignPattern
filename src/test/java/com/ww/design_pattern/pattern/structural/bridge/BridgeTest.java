package com.ww.design_pattern.pattern.structural.bridge;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class BridgeTest {

    @Test
    public void testBridge() throws Exception {
        Bank abcBank = new ABCBank(new CurrentDeposit());
        IDeposit abcDeposit = abcBank.openDeposit();
        abcDeposit.getType();
        //【ABCBank】：农业银行开立一笔存款！
        //【CurrentDeposit】：这是一笔活期存款！

        Bank icbcBank = new ICBCBank(new FixedDeposit());
        IDeposit icbcDeposit = icbcBank.openDeposit();
        icbcDeposit.getType();
        //【ICBCBank】：工商银行开立一笔存款！
        //【FixedDeposit】：这是一笔定期存款！
    }

}