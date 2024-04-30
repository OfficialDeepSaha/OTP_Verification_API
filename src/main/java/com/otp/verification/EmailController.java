package com.otp.verification;

import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmailController {
	
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailRepository emailRepository;
	
	
	
	
	//Generating OTP
	Random oneTimePasswoed = new Random();
    int otpv = oneTimePasswoed.nextInt(1111 , 9999);
	


	@PostMapping("/send/otp")
	public String sendOTPForVerification(@RequestBody Email email) throws Exception{
		
		
		Email sendEmail = new Email();
		
		sendEmail.setId(email.getId());
		sendEmail.setEmail(email.getEmail());
		sendEmail.setOtp(otpv);
		emailService.sendOTP(email.getEmail(), otpv);
		
		
		System.out.print("OTP Sent to the User👍");
		
		emailRepository.save(sendEmail);
		return "OTP Sent to the User👍";
	}
	
	
	@PostMapping("/verify/otp/{id}")
	public String verifyOTP(@RequestBody VerificationRequest verificationRequest , @PathVariable Long id) {
		
		Email verify = emailService.verifyOTPById(id);
		int OTP =  verify.getOtp();
		
		if(OTP == verificationRequest.getUserOTP()) {
			
			System.out.print("OTP Verification Successful !!");
		
			
			return "OTP Verification Successful✅";
			
		}
		
		
	else {
		
		System.out.print("OTP Verification Failed !!");
		
		return "OTP Verification Failed❌!";
	}	
	
		
		
	}
	
	
	
	

}
