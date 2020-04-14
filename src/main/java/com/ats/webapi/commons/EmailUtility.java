package com.ats.webapi.commons ;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ats.webapi.model.Info;



public class EmailUtility {
	
	public static Info sendEmail(String senderEmail,String senderPassword,String recipientEmail,String mailsubject,
		String defUsrName,String defPass) {
		
		Info info=new Info();
		
		try {
			
		final String emailSMTPserver = "smtp.gmail.com";
		final String emailSMTPPort = "587";
		final String mailStoreType = "imaps";
		final String username = senderEmail;//"atsinfosoft@gmail.com";
		final String password =senderPassword;//"atsinfosoft@123";

		System.out.println("username" + username);
		System.out.println("password" + password);

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");


		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Store mailStore = session.getStore(mailStoreType);
			mailStore.connect(emailSMTPserver, username, password);

			String address =recipientEmail;// "atsinfosoft@gmail.com";// address of to

			String subject = mailsubject;//" Login Credentials For RUSA Login  ";

			Message mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(username));
			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(defUsrName + defPass);
			
		
			Transport.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("email_exce");
		}
			
			info.setError(false);
			info.setMessage("success_email");
		}catch (Exception e) {
			
			info.setError(true);
			info.setMessage("email_exce");
		}
		
		return info;
		
	}
	
	//OTP EMAIL
	public static Info sendEmailOTP(String senderEmail,String senderPassword,String recipientEmail,String mailsubject,
			String defUsrName,String defPass) {
			
			Info info=new Info();
			
			try {
				
			final String emailSMTPserver = "smtp.gmail.com";
			final String emailSMTPPort = "587";
			final String mailStoreType = "imaps";
			final String username = senderEmail;//"atsinfosoft@gmail.com";
			final String password =senderPassword;//"atsinfosoft@123";

			System.out.println("username" + username);
			System.out.println("password" + password);

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");


			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {
				Store mailStore = session.getStore(mailStoreType);
				mailStore.connect(emailSMTPserver, username, password);

				String address =recipientEmail;// "atsinfosoft@gmail.com";// address of to

				String subject = mailsubject;//" Login Credentials For RUSA Login  ";

				Message mimeMessage = new MimeMessage(session);
				mimeMessage.setFrom(new InternetAddress(username));
				mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
				mimeMessage.setSubject(subject);
				mimeMessage.setText("OTP Verification for  RUSA Software \n OTP is: " + defPass);
				
			
				Transport.send(mimeMessage);
			} catch (Exception e) {
				e.printStackTrace();
				info.setError(true);
				info.setMessage("email_exce");
			}
				
				info.setError(false);
				info.setMessage("success_email");
			}catch (Exception e) {
				
				info.setError(true);
				info.setMessage("email_exce");
			}
			
			return info;
			
		}
	
	public static Info sendMsg(String userName,String pass, String phoneNo) {
			
			Info info=new Info();
			
			try {
				   
				RestTemplate restTemplate = new RestTemplate();
				MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
				/*map.add("authkey", "74499AcqeCdljW5ae561dd");
				map.add("mobiles", phoneNo);
				map.add("message", "RUSA CREDENTIAL Your User Name :" + userName +" Your Password :" + pass +" Plz Dont Share To Any One ");
				map.add("sender", "ESYRTO");
				map.add("route", "4");
				map.add("country", "91");*/
				
				//
				
			/*
			 * map.add("senderID", "RUSAMH"); map.add("user",
			 * "spdrusamah@gmail.com:Cyber@mva"); map.add("receipientno", phoneNo.trim());
			 * map.add("dcs", "0"); map.add(
			 * "msgtxt","User Registration Successful for RUSA Software \n Username: " +
			 * userName + "\n Password: " + pass); map.add("state", "4");
			 * 
			 * 
			 * //String response =
			 * restTemplate.postForObject("http://control.bestsms.co.in/api/sendhttp.php",
			 * map, String.class);
			 * 
			 * String response = restTemplate.postForObject(
			 * "http://api.mVaayoo.com/mvaayooapi/MessageCompose", map, String.class);
			 */
				String msg="User Registration Successful for RUSA Software \n Username: " + userName + "\n Password: " + pass;
				
				map.add("username", "rusamah-wb");
				map.add("password", "Rus@@123456");
				map.add("senderid", "MHRUSA");
				map.add("mobileno", phoneNo.trim());
				map.add("content", msg); 
				map.add("smsservicetype", "singlemsg"); 
				String sms = restTemplate.postForObject("https://msdgweb.mgov.gov.in/esms/sendsmsrequest",
				map, String.class);
				 
				info.setError(false);
				info.setMessage(sms);
			  
			}catch (Exception e) {
				
				info.setError(true);
				info.setMessage("sendMsg");
			}
			
			return info;
		}

	
	public static Info sendOtp(String OTP, String phoneNo,String msg) {
		
		Info info=new Info();
		
		try {
			   
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
			
			
			/*
			 * map.add("senderID", "RUSAMH"); map.add("user",
			 * "spdrusamah@gmail.com:Cyber@mva"); map.add("receipientno", phoneNo.trim());
			 * map.add("dcs", "0"); map.add("msgtxt",msg + " " +OTP); map.add("state", "4");
			 * 
			 * String response = restTemplate.postForObject(
			 * "http://api.mVaayoo.com/mvaayooapi/MessageCompose", map, String.class);
			 */
			String message = msg+ " " +OTP;
			String mob = phoneNo.trim();
		
			String sms = restTemplate.getForObject("http://control.bestsms.co.in/api/sendhttp.php?authkey=314773AiTXKWgYX9R5e2aa5c1P1&mobiles="+mob+"&message="+message+"&sender=MONGII&route=4&country=91", String.class);
			
			
			info.setError(false);
			info.setMessage(sms);
		  
		}catch (Exception e) {
			
			info.setError(true);
			info.setMessage("sendMsg");
		}
		
		return info;
	}

}