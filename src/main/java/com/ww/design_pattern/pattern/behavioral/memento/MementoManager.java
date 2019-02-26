package com.ww.design_pattern.pattern.behavioral.memento;

import lombok.extern.java.Log;

import java.util.Stack;

@Log
public class MementoManager {
    //备忘者模式的核心：使用栈Stack后进先出push存储快照，pop实现撤销或后退操作
    private final Stack<DocumentMemento> DOCUMENT_MEMENTO_STACK = new Stack<>();

    public DocumentMemento getMemento(){
        DocumentMemento documentMemento = DOCUMENT_MEMENTO_STACK.pop();
        log.info("【MementoManager.getMemento】：快照出栈" + documentMemento);
        return documentMemento;
    }

    public void addMemento(DocumentMemento documentMemento){
        DOCUMENT_MEMENTO_STACK.push(documentMemento);
        log.info("【MementoManager.addMemento】：快照入栈" + documentMemento);
    }

}
