package com.ww.design_pattern.pattern.creational.prototype;

import lombok.extern.java.Log;

@Log
public class MailUtil {
    public static void sendMail(Mail mail) {

        log.info("【EmailAddress】:" + mail.getEmailAddress()
                + "【Title】：" + mail.getTitle()
                + "【Content】：" + mail.getContent());
    }

    public static void saveOriginMailRecord(Mail mail) {
        log.info("保存克隆前的原始邮件" + mail.getContent());
    }
}
