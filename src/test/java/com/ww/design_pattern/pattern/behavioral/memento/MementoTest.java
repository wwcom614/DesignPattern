package com.ww.design_pattern.pattern.behavioral.memento;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class MementoTest {

    @Test
    public void testMemento() throws Exception {
        MementoManager mementoManager = new MementoManager();

        Document document = new Document("title_1", "content_1");
        DocumentMemento documentMemento = document.saveToMemento();
        //【Document.saveToMemento】：存档生成快照DocumentMemento(title=title_1, content=content_1)
        mementoManager.addMemento(documentMemento);
        //【MementoManager.addMemento】：快照入栈DocumentMemento(title=title_1, content=content_1)

        document.setTitle("title_2");
        document.setContent("content_2");
        documentMemento = document.saveToMemento();
        //【Document.saveToMemento】：存档生成快照DocumentMemento(title=title_2, content=content_2)
        mementoManager.addMemento(documentMemento);
        //【MementoManager.addMemento】：快照入栈DocumentMemento(title=title_2, content=content_2)

        document.setTitle("title_3");
        document.setContent("content_3");
        documentMemento = document.saveToMemento();
        //【Document.saveToMemento】：存档生成快照DocumentMemento(title=title_3, content=content_3)
        mementoManager.addMemento(documentMemento);
        //【MementoManager.addMemento】：快照入栈DocumentMemento(title=title_3, content=content_3)

        documentMemento = mementoManager.getMemento();
        //【MementoManager.getMemento】：快照出栈DocumentMemento(title=title_3, content=content_3)
        document.undoMemento(documentMemento);
        //【Document.undoMemento】：撤销快照回写文档Document(title=title_3, content=content_3)

        documentMemento = mementoManager.getMemento();
        //【MementoManager.getMemento】：快照出栈DocumentMemento(title=title_2, content=content_2)
        document.undoMemento(documentMemento);
        //【Document.undoMemento】：撤销快照回写文档Document(title=title_2, content=content_2)
    }

}