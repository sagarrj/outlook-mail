package com.lti.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by sagar on 26/5/20.
 */
@RestController
public class MailController
{

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @GetMapping("/sendMail")
    public String sendMail(@RequestParam(required=false, name="to") String  toMail){

        try{
            String to = Optional.ofNullable(toMail).orElse("metisuser1@outlook.com");
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject("Sample Test email");
            simpleMailMessage.setText("Hello User!!!\nMail implementation successful.");
            mailSender.send(simpleMailMessage);
            return "Success: Mail sent." ;

        }catch (Exception e){
            return "Failed: " + e.getMessage();
        }
    }



}
