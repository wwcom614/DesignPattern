package com.ww.design_pattern.pattern.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//每次保存Document对象时，生成一个快照
//注意快照只允许构造生成，不允许set修改
@Getter
@ToString
@AllArgsConstructor
public class DocumentMemento {
    private String title;
    private String content;
}
