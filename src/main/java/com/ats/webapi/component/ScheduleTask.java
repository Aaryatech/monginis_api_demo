package com.ats.webapi.component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.ShopAnivData;
import com.ats.webapi.repository.FrAniversaryRepository;
import com.ats.webapi.repository.FranchiseSupRepository;

@Component
public class ScheduleTask {

	@Autowired
	FranchiseSupRepository franchiseSupRepository;

	@Autowired
	FrAniversaryRepository frAniversaryRepository;
	
	 private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
	    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Scheduled(cron = "0 0 7 * * *") 
	public void scheduleTaskWithCronExpression() {
	    logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	    
	    
	    List<String> frTokens=franchiseSupRepository.findTokensByBirthdate(new Date());
	    logger.info("frTokens"+frTokens);
	    List<ShopAnivData> frOPTokens=frAniversaryRepository.findTokensByFrOpeningDate(new Date());
	    logger.info("frOPTokens"+frOPTokens);
	  //-----------------------For Notification-----------------
	
		if(!frTokens.isEmpty()) {
		
	
		 try {
			 for(String token:frTokens) {
	          Firebase.sendPushNotifForCommunication(token,"HAPPY BIRTHDAY","Team Monginis wishes you a very happy birthday and many many happy returns of the day.","inbox");
			 }
	         }
	         catch(Exception e2)
	         {
		       e2.printStackTrace();
	         }
		 
		}
		if(!frOPTokens.isEmpty()) {
			
			
			 try {
				 for(ShopAnivData token:frOPTokens) {
		          Firebase.sendPushNotifForCommunication(token.getToken(),"Shop Anniversary","Congratulations on successful completion of "+token.getNoOfYears()+"years with Monginis. Thank you for being part of our family. Team Monginis","inbox");
				 }
		         }
		         catch(Exception e2)
		         {
			       e2.printStackTrace();
		         }
			 
			}
		//-----------------------------------------------------
	}
	@Scheduled(cron="0 0 6 1 * ?")
	public void scheduleTaskWithCronExpressionOnMonthStart() {
	    logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	    
	    List<String> frTokens=franchiseSupRepository.findTokens();
	    
	    if(!frTokens.isEmpty()) {
			
	    	
			 try {
				 for(String token:frTokens) {
		          Firebase.sendPushNotifForCommunication(token,"Close Your Month","Since today is first day of the month, please close the last month in your software.","inbox");
				 }
		         }
		         catch(Exception e2)
		         {
			       e2.printStackTrace();
		         }
			 
			}
	    
	}
	    
	    
	 
}
