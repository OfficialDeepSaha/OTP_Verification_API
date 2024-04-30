package com.otp.verification;

public class VerificationRequest {
	
	
	

	private int userOTP;

	public VerificationRequest() {
		
	}

	public VerificationRequest(int userOTP) {
		super();
		this.userOTP = userOTP;
	}
	
	
	
	public int getUserOTP() {
		return userOTP;
	}

	public void setUserOTP(int userOTP) {
		this.userOTP = userOTP;
	}
	

}
