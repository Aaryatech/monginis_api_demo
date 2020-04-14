package com.ats.webapi.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Common {

	
 	

	
	// To convert string to ymd format date
	public static String convertToYMD(String date) {
		
		String convertedDate=null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");
			Date dmyDate = dmySDF.parse(date);
			
			convertedDate=ymdSDF.format(dmyDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}
	
public static String convertToDMY(String date) {
		
		String convertedDate=null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-mm-dd");
			SimpleDateFormat ymdSDF2 = new SimpleDateFormat("yyyy-mm-dd");

			
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd-mm-yyyy");

			Date ymdDate = ymdSDF2.parse(date);
			
			convertedDate=dmySDF.format(ymdDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}
	
public static java.sql.Date convertToSqlDate(String date) {
		
		java.sql.Date convertedDate=null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-mm-dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("dd-MM-yyyy");

			Date dmyDate = dmySDF.parse(date);
			
			System.out.println("converted util date commons "+dmyDate);

			
			

			convertedDate=new java.sql.Date(dmyDate.getTime());
			System.out.println("converted sql date commons "+convertedDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}


public  static String getAlphaNumericString(int n) 
{ 

	// chose a Character random from this String 
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
								+ "0123456789"
								+ "abcdefghijklmnopqrstuvxyz"; 

	// create StringBuffer size of AlphaNumericString 
	StringBuilder sb = new StringBuilder(n); 

	for (int i = 0; i < n; i++) { 

		// generate a random number between 
		// 0 to AlphaNumericString variable length 
		int index 
			= (int)(AlphaNumericString.length() 
					* Math.random()); 

		// add Character one by one in end of sb 
		sb.append(AlphaNumericString 
					.charAt(index)); 
	} 

	return sb.toString(); 
}



 public static char[] OTP(int len) 
    { 
	 char[] otp = new char[len]; 
	 try {
        System.out.println("Generating OTP using random() : "); 
  
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
       
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
	 }catch (Exception e) {
		System.err.println("ex in comm OTP gen " +e.getMessage());
		e.printStackTrace();
	}
        return otp; 
    } 

	

}