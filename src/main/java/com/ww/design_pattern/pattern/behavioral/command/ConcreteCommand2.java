package com.ww.design_pattern.pattern.behavioral.command;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public class ConcreteCommand2 implements ICommand {
    private Receiver receiver = null;

    @Override
    public void excute() {
        receiver.doC();
        receiver.doA();
        receiver.doB();
        log.info("【ConcreteCommand2】：C, A and B have been done!");
    }

    @Override
    public void undo() {
        receiver.unDoB();
        receiver.unDoA();
        receiver.unDoC();
        log.info("【ConcreteCommand2】：B, A and C memento have been backout!");
    }
}
