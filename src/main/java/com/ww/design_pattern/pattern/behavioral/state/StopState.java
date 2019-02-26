package com.ww.design_pattern.pattern.behavioral.state;

import lombok.extern.java.Log;

@Log
public class StopState extends VideoState {
    @Override
    public void play() {
        super.videoContext.setVideoState(VideoContext.PLAY_STATE);
        log.info("【StopState】：从停止播放状态切换到正常播放状态！");
    }

    @Override
    public void speed() {
        log.warning("【StopState】：停止播放状态无法直接切换到加速播放状态！");
    }

    @Override
    public void pause() {
        log.warning("【StopState】：停止播放状态无法直接切换到暂停播放状态！");
    }

    @Override
    public void stop() {
        log.info("【StopState】：停止播放状态！");
    }
}
