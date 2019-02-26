package com.ww.design_pattern.pattern.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class BillList {

    private List<IBill> billList = new ArrayList<>();

    public void addBill(IBill bill){
        billList.add(bill);
    }

    public void traverseBill(IVisitor visitor){
        for(IBill bill : billList){
            bill.accept(visitor);
        }
    }
}
