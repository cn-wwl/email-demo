package com.wwl.email.base;

import java.util.List;

/**
 * @author long
 * @date 2021/7/21 16:38
 * @desc TODO
 */
public class EmailInfo {

    /**
     * 接收者邮件地址
     */
    private List<String> receiveAddress;

    /**
     * 主题
     */
    private String subject;

    /**
     * 消息
     */
    private String message;

    public List<String> getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(List<String> receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
