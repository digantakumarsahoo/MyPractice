package com.test.spring.security.jwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
    private JavaMailSender javaMailSender;
	

	void sendEmail(String toMail,String otp) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toMail);

        msg.setSubject("Your ForgotPassword Details");
        msg.setText("Your OTP for Reseting password : "+"1234");

        javaMailSender.send(msg);

    }
}
