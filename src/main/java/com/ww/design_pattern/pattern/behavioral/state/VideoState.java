package com.ww.design_pattern.pattern.behavioral.state;

//抽象状态类(State0：定义一个接口以封装与Context的一个特定状态相关的行为。
public abstract class VideoState {
    //外部只能通过向状态类使用context来改变状态
    protected VideoContext videoContext;

    public void setVideoContext(VideoContext videoContext){
        this.videoContext = videoContext;
    }

    //正常播放视频
    public abstract void play();

    //加速播放视频
    public abstract void speed();

    //暂停播放视频
    public abstract void pause();

    //停止播放视频
    public abstract void stop();


}
