package com.ww.design_pattern.pattern.behavioral.command;

//在开始初始化时，对每个命令初始化成了NoCommand，也就是什么都不执行。避免空指针异常
public class NoCommand implements ICommand {
    @Override
    public void excute() {

    }

    @Override
    public void undo() {

    }
}
