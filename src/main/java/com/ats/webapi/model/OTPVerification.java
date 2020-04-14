package com.ats.webapi.model;

public class OTPVerification {
	
	
	public static String emailId;
	
	
	public static String conNumber;
	
	
	public static String otp;
	public static String pass;
	
public static int userId;




	public static int getUserId() {
	return userId;
}


public static void setUserId(int long1) {
	OTPVerification.userId = long1;
}


	public static String getEmailId() {
		return emailId;
	}


	public static void setEmailId(String emailId) {
		OTPVerification.emailId = emailId;
	}


	public static String getConNumber() {
		return conNumber;
	}


	public static void setConNumber(String conNumber) {
		OTPVerification.conNumber = conNumber;
	}


	public static String getOtp() {
		return otp;
	}


	public static void setOtp(String otp) {
		OTPVerification.otp = otp;
	}


	public static String getPass() {
		return pass;
	}


	public static void setPass(String pass) {
		OTPVerification.pass = pass;
	}


	@Override
	public String toString() {
		return "OTPVerification []";
	}



}
