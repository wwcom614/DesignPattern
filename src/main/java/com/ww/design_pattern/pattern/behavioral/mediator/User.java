package com.ww.design_pattern.pattern.behavioral.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;

    public void sendMessage(String message) {
        Chat.sendMsg(this, message);
    }
}
