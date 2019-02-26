package com.ww.design_pattern.pattern.behavioral.state;

import lombok.extern.java.Log;

@Log
public class PlayState extends VideoState {
    @Override
    public void play() {
        log.info("【PlayState】：正常播放状态！");
    }

    @Override
    public void speed() {
        super.videoContext.setVideoState(VideoContext.SPEED_STATE);
        log.info("【PlayState】：从正常播放状态切换到加速播放状态！");
    }

    @Override
    public void pause() {
        super.videoContext.setVideoState(VideoContext.PAUSE_STATE);
        log.info("【PlayState】：从正常播放状态切换到暂停播放状态！");
    }

    @Override
    public void stop() {
        super.videoContext.setVideoState(VideoContext.STOP_STATE);
        log.info("【PlayState】：从正常播放状态切换到停止播放状态！");
    }
}
