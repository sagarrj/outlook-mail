package com.lti.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by sagar on 26/5/20.
 */
@Configuration
public class EmailConfig {

    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("metisdev@outlook.com");
//        message.setFrom("sagar.jaisinghani@outlook.com");

        return message;
    }
}
