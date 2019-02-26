package com.ww.design_pattern.pattern.behavioral.state;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class StateTest {
    @Test
    public void testState() throws Exception {
        VideoContext videoContext = new VideoContext();

        //打开影片，播放器默认自动正常播放
        videoContext.setVideoState(new PlayState());
        //【VideoContext】当前状态：PlayState

        videoContext.pause();
        //【VideoContext】当前状态：PauseState
        //【PlayState】：从正常播放状态切换到暂停播放状态！

        videoContext.speed();
        //【VideoContext】当前状态：SpeedState
        //【PauseState】：从暂停播放状态切换到加速播放状态！

        videoContext.stop();
        //【VideoContext】当前状态：StopState
        //【SpeedState】：从加速播放状态切换到停止播放状态！

        videoContext.speed();
        //【SpeedState】：从加速播放状态切换到停止播放状态！

        videoContext.pause();
        //【StopState】：停止播放状态无法直接切换到暂停播放状态！

        videoContext.play();
        //【VideoContext】当前状态：PlayState
        //【StopState】：从停止播放状态切换到正常播放状态！
    }

}