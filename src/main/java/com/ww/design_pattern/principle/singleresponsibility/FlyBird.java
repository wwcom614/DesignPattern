package com.ww.design_pattern.principle.singleresponsibility;

import lombok.extern.java.Log;

@Log
public class FlyBird {
    public void mainMoveMode(String birdName){
        log.info(birdName+"用翅膀飞");
    }
}
