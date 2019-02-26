package com.ww.design_pattern.pattern.behavioral.visitor;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorTest {

    @Test
    public void testVisitor() throws Exception {

        BillList billList = new BillList();
        billList.addBill(new IncomeBill("商品A销售", 20500.57, 10.32));
        billList.addBill(new IncomeBill("商品B销售", 30600.32, 15.69));

        billList.addBill(new ExpenseBill("材料M采购", 9999.66, 5.17));
        billList.addBill(new ExpenseBill("材料N采购", 6854.21, 1.43));

        TotalVisitor boss = new TotalVisitor();
        billList.traverseBill(boss);
        boss.getTotal();
        //【TotalVisitor】总支出：16853.87
        //【TotalVisitor】总返现：6.6
        //【TotalVisitor】总收入：51100.89
        //【TotalVisitor】总交税；26.01
        //【TotalVisitor】总盈亏；34227.61

        ListVisitor accountant = new ListVisitor();
        billList.traverseBill(accountant);
        //【ListVisitor】收入项：商品A销售，收入(元)：20500.57，交税(元)：10.32
        //【ListVisitor】收入项：商品B销售，收入(元)：30600.32，交税(元)：15.69
        //【ListVisitor】支出项：材料M采购，支出(元)：9999.66，返现(元)：5.17
        //【ListVisitor】支出项：材料N采购，支出(元)：6854.21，返现(元)：1.43
    }

}