package com.ww.design_pattern.pattern.creational.prototype;

import lombok.extern.java.Log;

//假设该对象很大且需要复制
@Log
public class Mail implements Cloneable{
    private String title;
    private String emailAddress;
    private String content;
    public Mail(){
        //看看克隆是否会调用构造方法。验证结果：不会
        log.info("Construct mail object！");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "title='" + title + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}'+super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        log.info("Clone mail object！");
        return super.clone();
    }
}
