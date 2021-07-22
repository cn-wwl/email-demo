package com.wwl.email;

import com.wwl.email.base.EmailInfo;
import com.wwl.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author long
 * @date 2021/7/21 15:47
 * @desc 邮件服务
 */
@SpringBootApplication
public class EmailApplication implements ApplicationRunner {

    @Autowired
    private EmailService emailService;

    /**
     * 随机对象
     */
    private static final Random RANDOM = new SecureRandom();
    private static final String NUMBER = "0123456789";


    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class,args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        EmailInfo emailInfo = new EmailInfo();

        List<String> receives=new ArrayList<String>(){{add("2281335340@qq.com");}};

        emailInfo.setReceiveAddress(receives);
        emailInfo.setSubject("【注册验证码】");
        emailInfo.setMessage("感谢您注册，您的验证码为 \n" + randSendCode() + "\n请注意保存，此验证码有效期为 10分钟 。");
        Boolean flag = emailService.sendEmail(emailInfo);
        System.out.println("是否成功：" + flag);

    }

    /**
     * 六位数验证码
     */
    public static String randSendCode(){
        char[] nonceChars = new char[6];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = NUMBER.charAt(RANDOM.nextInt(10));
        }
        return new String(nonceChars);
    }
}
