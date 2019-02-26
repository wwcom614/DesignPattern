package com.ww.design_pattern.pattern.behavioral.state;

import lombok.extern.java.Log;

//环境上下文类(Context)：定义客户端调用接口。维护一个VideoState实例，这个实例定义当前状态。
@Log
public class VideoContext {
    private VideoState videoState;

    public final static PlayState PLAY_STATE = new PlayState();
    public final static SpeedState SPEED_STATE = new SpeedState();
    public final static PauseState PAUSE_STATE = new PauseState();
    public final static StopState STOP_STATE = new StopState();

    public void setVideoState(VideoState videoState){
        this.videoState = videoState;
        //状态模式核心：将上下文VideoContext自身this，通过setVideoContext通知给各个状态videoState
        this.videoState.setVideoContext(this);
        log.info("【VideoContext】当前状态：" + videoState.getClass().getSimpleName());
    }

    public void play(){
        this.videoState.play();
    }

    public void speed(){
        this.videoState.speed();
    }

    public void pause(){
        this.videoState.pause();
    }

    public void stop(){
        this.videoState.stop();
    }
}
