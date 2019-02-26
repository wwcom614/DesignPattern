package com.ww.design_pattern.pattern.behavioral.state;

import lombok.extern.java.Log;

@Log
public class SpeedState extends VideoState {
    @Override
    public void play() {
        super.videoContext.setVideoState(VideoContext.PLAY_STATE);
        log.info("【SpeedState】：从加速播放状态切换到正常播放状态！");
    }

    @Override
    public void speed() {
        log.info("【SpeedState】：加速播放状态！");
    }

    @Override
    public void pause() {
        super.videoContext.setVideoState(VideoContext.PAUSE_STATE);
        log.info("【SpeedState】：从加速播放状态切换到暂停播放状态！");
    }

    @Override
    public void stop() {
        super.videoContext.setVideoState(VideoContext.STOP_STATE);
        log.info("【SpeedState】：从加速播放状态切换到停止播放状态！");
    }
}
