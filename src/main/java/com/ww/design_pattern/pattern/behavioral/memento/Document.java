package com.ww.design_pattern.pattern.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
@AllArgsConstructor
public class Document {
    private String title;
    private String content;

    //用户点击保存文档，实际是对当前文档生成一个快照DocumentMemento
    public DocumentMemento saveToMemento(){
        DocumentMemento documentMemento = new DocumentMemento(this.title, this.content);
        log.info("【Document.saveToMemento】：存档生成快照" + documentMemento);
        return documentMemento;
    }

    public void undoMemento(DocumentMemento documentMemento){
        this.title = documentMemento.getTitle();
        this.content = documentMemento.getContent();
        log.info("【Document.undoMemento】：撤销快照回写文档" + this);
    }
}
