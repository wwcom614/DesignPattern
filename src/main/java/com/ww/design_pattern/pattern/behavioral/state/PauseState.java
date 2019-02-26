package com.ww.design_pattern.pattern.behavioral.state;

import lombok.extern.java.Log;

@Log
public class PauseState extends VideoState {
    @Override
    public void play() {
        super.videoContext.setVideoState(VideoContext.PLAY_STATE);
        log.info("【PauseState】：从暂停播放状态切换到正常播放状态！");
    }

    @Override
    public void speed() {
        super.videoContext.setVideoState(VideoContext.SPEED_STATE);
        log.info("【PauseState】：从暂停播放状态切换到加速播放状态！");
    }

    @Override
    public void pause() {
        log.info("【PauseState】：暂停播放状态！");
    }

    @Override
    public void stop() {
        super.videoContext.setVideoState(VideoContext.STOP_STATE);
        log.info("【PauseState】：从暂停播放状态切换到停止播放状态！");
    }
}
