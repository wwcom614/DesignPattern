package com.ww.design_pattern.pattern.behavioral.command;

//将多种变化的命令抽象为接口，需要执行的所有命令都在这里声明
public interface ICommand {
    void excute();
    void undo();
}
