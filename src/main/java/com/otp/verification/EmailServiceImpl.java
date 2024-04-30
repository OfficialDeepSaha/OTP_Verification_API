package com.otp.verification;

import java.awt.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private EmailRepository emailRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendOTP(String to, int otp) throws Exception {
		
		

		// For Sending Mail
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(to);
		helper.setFrom("Hr.SCS.in", "Hr-Deep@SCS.in");
		helper.setSubject("One Time Password->");
		helper.setText("Your OTP is- " + otp);
		

		javaMailSender.send(message);
		;
	}
	
	
	public Email verifyOTPById(Long id) {
		
		return emailRepo.findById(id).get();
	}
	
	
	
	

}
