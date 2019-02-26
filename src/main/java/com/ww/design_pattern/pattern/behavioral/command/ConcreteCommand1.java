package com.ww.design_pattern.pattern.behavioral.command;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

//
@Log
@AllArgsConstructor
public class ConcreteCommand1 implements ICommand {
    private Receiver receiver = null;

    @Override
    public void excute() {
        receiver.doB();
        receiver.doA();
        log.info("【ConcreteCommand1】：B and A have been done!");
    }

    @Override
    public void undo() {
        receiver.unDoA();
        receiver.unDoB();
        log.info("【ConcreteCommand1】：A and B memento have been backout!");
    }
}
