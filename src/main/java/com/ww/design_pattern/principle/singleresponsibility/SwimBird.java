package com.ww.design_pattern.principle.singleresponsibility;

import lombok.extern.java.Log;

@Log
public class SwimBird {
    public void mainMoveMode(String birdName){
        log.info(birdName+"用翅膀游泳");
    }
}
