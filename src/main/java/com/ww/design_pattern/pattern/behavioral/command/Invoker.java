package com.ww.design_pattern.pattern.behavioral.command;

//Invoker调用者角色：接收到命令，并执行命令，是命令模式中最重要的角色。
// 这个角色用来对各个命令进行控制
public class Invoker {
    private ICommand command = new NoCommand();

    public void setCommand(ICommand command){
        this.command = command;
    }

    //执行命令
    public void excuteCommand(){
        command.excute();
    }

    //撤销命令
    public void undoCommand(){
        command.undo();
    }

}
