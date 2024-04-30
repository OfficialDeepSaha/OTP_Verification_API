package com.otp.verification;



public interface EmailService {

	
	public void sendOTP(String to , int otp) throws Exception;
	
	public Email verifyOTPById(Long id);
	
	
}
