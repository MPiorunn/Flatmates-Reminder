package com.piorun.app.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailSenderProvider {

    @Bean
    public JavaMailSender create() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(25);

        mailSender.setUsername("stanislawwysylka@gmail.com");
        mailSender.setPassword("WyslijMiMaila8374");

        Properties props = mailSender.getJavaMailProperties();
        props.put("com.piorun.app.mail.transport.protocol", "smtp");
        props.put("com.piorun.app.mail.smtp.auth", "true");
        props.put("com.piorun.app.mail.smtp.starttls.enable", "true");
        props.put("com.piorun.app.mail.debug", "true");

        return mailSender;
    }
}
