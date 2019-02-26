package com.ww.design_pattern.pattern.behavioral.iterator;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class IteratorTest {

    @Resource
    ICollection collection;

    @Test
    public void testIterator() throws Exception {
        Element element1 = new Element("name-1");
        Element element2 = new Element("name-2");
        Element element3 = new Element("name-3");

        collection.add(element1);
        collection.add(element2);
        collection.add(element3);

        log.info("---------------集合元素列表-------------------");
        collection.iteratorPrintElement();
        //【IteratorImpl】：返回元素，position==0
        //【CollectionImpl - iteratorPrintElement】：name-1
        //【IteratorImpl】：返回元素，position==1
        //【CollectionImpl - iteratorPrintElement】：name-2
        //【IteratorImpl】：返回元素，position==2
        //【CollectionImpl - iteratorPrintElement】：name-3

        collection.remove(element2);


        log.info("---------------删除元素2后的集合元素列表-------------------");
        collection.iteratorPrintElement();
        //【IteratorImpl】：返回元素，position==0
        //【CollectionImpl - iteratorPrintElement】：name-1
        //【IteratorImpl】：返回元素，position==1
        //【CollectionImpl - iteratorPrintElement】：name-3
    }

}