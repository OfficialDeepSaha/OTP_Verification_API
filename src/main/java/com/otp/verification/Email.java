package com.otp.verification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emails")
public class Email {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int otp;
	
	private String email;
	
	
	public Email() {
		
		
	}


	public Email(Long id, int otp, String email) {
		super();
		this.id = id;
		this.otp = otp;
		this.email = email;
	}

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getOtp() {
		return otp;
	}


	public void setOtp(int otp) {
		this.otp = otp;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
