package io.renren.modules.generator.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import io.renren.modules.generator.entity.CodeEntity;
import io.renren.modules.generator.service.CodeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

public class MailUtil {
    @Autowired
    private CodeService codeService;
    public static String sendMail(String username) throws MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session
        // 创建参数配置, 用于连接邮件服务器的参数配置

        Properties javaMailProperties = new Properties();// 参数配置
        javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.setProperty("mail.smtp.socketFactory.port", "465");
        javaMailProperties.setProperty("mail.smtp.port", "465");

        javaMailProperties.setProperty("mail.transport.protocol", "SMTP");// 使用的协议（JavaMail规范要求）
        javaMailProperties.setProperty("mail.host", "smtp.163.com");// // 发件人的邮箱的 SMTP 服务器地址
        javaMailProperties.setProperty("mail.smtp.auth", "true");//请求认证，参数名称与具体实现有关 指定验证为true

        // 创建验证器
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("gsd0513@163.com", "dxc.0513");
            }
        };

        Session session = Session.getInstance(javaMailProperties, auth);

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("gsd0513@163.com")); // 设置发送者

        message.setRecipient(RecipientType.TO, new InternetAddress(username)); // 设置发送方式与接收者

        message.setSubject("注册验证码");

        String emailcode = "" + (int)((Math.random() * 9 + 1) * 100000);

//        CodeEntity entity = new CodeEntity();
//
//        entity.setEmailCode(emailcode);

//        .insert(code);
//
        message.setText("你的验证码为"+emailcode);

        Transport.send(message);

        return  emailcode;
    }

}
