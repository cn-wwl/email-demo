package com.wwl.email.service;

import com.wwl.email.base.EmailInfo;
import com.wwl.email.config.EmailConfig;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author long
 * @date 2021/7/21 16:31
 * @desc TODO
 */
@Service
public class EmailService {

    @Autowired
    private EmailConfig emailConfig;


    /**
     * 邮件服务
     * @param emailInfo
     * @return 成功/不成功
     */
    public Boolean sendEmail(EmailInfo emailInfo) {
        try {
            //创建一个HtmlEmail实例对象
            HtmlEmail email = new HtmlEmail();

            email.setHostName(emailConfig.getSmtp());

            email.setSmtpPort(emailConfig.getSmtpPort());

            //创建一个HtmlEmail实例对象
            email.setCharset(emailConfig.getCharset());

            //发送人的邮箱为自己的，用户名可以随便填
            email.setFrom(emailConfig.getSendEmailAddress(),emailConfig.getSendUserName());

            //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
            email.setAuthentication(emailConfig.getSendEmailAddress(),emailConfig.getAuthorizeCode());

            //设置收件人
            email.addTo(String.join(",", emailInfo.getReceiveAddress()));

            //设置发送主题
            email.setSubject(emailInfo.getSubject());

            //设置发送内容
            email.setMsg(emailInfo.getMessage());

            //进行发送
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
