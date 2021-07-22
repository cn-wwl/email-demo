package com.wwl.email.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author long
 * @date 2021/7/21 16:12
 * @desc 邮件配置
 */
@Configuration
public class EmailConfig {

    /**
     * 发送邮件服务器
     */
    @Value("${com.wwl.email.smtp}")
    private String smtp;

    /**
     * 发送邮件服务器端口
     */
    @Value("${com.wwl.email.smtp.port}")
    private Integer smtpPort;

    /**
     * 发送的字符集类型
     */
    @Value("${com.wwl.email.charset}")
    private String charset;

    /**
     * 发送者邮箱用户
     */
    @Value("${com.wwl.email.send.username}")
    private String sendUserName;

    /**
     * 发送者邮箱地址
     */
    @Value("${com.wwl.email.send.address}")
    private String sendEmailAddress;

    /**
     * 发送者邮箱授权码
     */
    @Value("${com.wwl.email.send.authorize.code}")
    private String authorizeCode;

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public Integer getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(Integer smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getSendEmailAddress() {
        return sendEmailAddress;
    }

    public void setSendEmailAddress(String sendEmailAddress) {
        this.sendEmailAddress = sendEmailAddress;
    }

    public String getAuthorizeCode() {
        return authorizeCode;
    }

    public void setAuthorizeCode(String authorizeCode) {
        this.authorizeCode = authorizeCode;
    }
}
