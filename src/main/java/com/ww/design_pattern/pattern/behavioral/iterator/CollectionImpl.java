package com.ww.design_pattern.pattern.behavioral.iterator;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//定义集合行为接口的实现类
@Log
@Component
public class CollectionImpl implements ICollection {

    private List elementList;

    public CollectionImpl(){
        this.elementList = new ArrayList();
    }

    @Override
    public void add(Element element) {
        elementList.add(element);
    }

    @Override
    public void remove(Element element) {
        elementList.remove(element);
    }

    @Override
    public IIterator getIterator() {
        return new IteratorImpl(elementList);
    }

    @Override
    public void iteratorPrintElement(){
        IIterator iterator = this.getIterator();
        while (!iterator.isLastElement()){
            log.info("【CollectionImpl - iteratorPrintElement】："+ iterator.nextElement().getName());
        }
    }
}
