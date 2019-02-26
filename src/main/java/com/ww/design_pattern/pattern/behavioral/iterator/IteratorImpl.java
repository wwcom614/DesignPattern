package com.ww.design_pattern.pattern.behavioral.iterator;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.List;

@Log
@Component
public class IteratorImpl implements IIterator {

    private List elementList;
    private int position;
    private Element element;

    public IteratorImpl(List elementList) {
        this.elementList = elementList;
    }

    @Override
    public Element nextElement() {
        element = (Element) elementList.get(position);
        log.info("【IteratorImpl】：返回元素，position==" + position);
        position++;
        return element;
    }

    @Override
    public Boolean isLastElement() {
        if (position < elementList.size()) {
            return false;
        } else {
            return true;
        }
    }
}
