package com.ats.webapi.service.communication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.AllFrIdName;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.User;
import com.ats.webapi.model.communication.Complaint;
import com.ats.webapi.model.communication.ComplaintDetail;
import com.ats.webapi.model.communication.Feedback;
import com.ats.webapi.model.communication.FeedbackDetail;
import com.ats.webapi.model.communication.GetComplaint;
import com.ats.webapi.model.communication.GetComplaintDetail;
import com.ats.webapi.model.communication.GetFeedback;
import com.ats.webapi.model.communication.GetFeedbackDetail;
import com.ats.webapi.model.communication.GetNotification;
import com.ats.webapi.model.communication.GetSuggestion;
import com.ats.webapi.model.communication.GetSuggestionDetail;
import com.ats.webapi.model.communication.Notification;
import com.ats.webapi.model.communication.Suggestion;
import com.ats.webapi.model.communication.SuggestionDetail;
import com.ats.webapi.repository.AllFrIdNameRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.repository.communication.ComplaintDetailRepository;
import com.ats.webapi.repository.communication.ComplaintRepository;
import com.ats.webapi.repository.communication.FeedbackDetailRepository;
import com.ats.webapi.repository.communication.FeedbackRepository;
import com.ats.webapi.repository.communication.GetComplaintDetailRepository;
import com.ats.webapi.repository.communication.GetComplaintRepository;
import com.ats.webapi.repository.communication.GetFeedbackDetailRepository;
import com.ats.webapi.repository.communication.GetFeedbackRepository;
import com.ats.webapi.repository.communication.GetNotificationRepository;
import com.ats.webapi.repository.communication.GetSuggestionDetailRepository;
import com.ats.webapi.repository.communication.GetSuggestionRepository;
import com.ats.webapi.repository.communication.NotificationRepository;
import com.ats.webapi.repository.communication.SuggestionDetailRepository;
import com.ats.webapi.repository.communication.SuggestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CommunicationServiceImpl implements CommunicationService{

	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	SuggestionRepository suggestionRepository;
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	@Autowired
	ComplaintDetailRepository complaintDetailRepository;
	
	@Autowired
	SuggestionDetailRepository suggestionDetailRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	FeedbackDetailRepository feedbackDetailRepository;
	
	@Autowired
	GetComplaintRepository getComplaintRepository;
	
	@Autowired
	GetComplaintDetailRepository getComplaintDetailRepository;
	
	@Autowired
	GetFeedbackRepository getFeedbackRepository;
	
	@Autowired
	GetFeedbackDetailRepository getFeedbackDetailRepository;
	
	@Autowired
	GetSuggestionRepository getSuggestionRepository;
	
	@Autowired
	GetSuggestionDetailRepository getSuggestionDetailRepository;
	
	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	
	@Autowired
	UserRepository userRepository;
	
    @Autowired
    GetNotificationRepository getNotificationRepository;
    
    @Autowired
	AllFrIdNameRepository allFrIdNameRepository;
	@Override
	public ErrorMessage saveNotification(Notification notification) {

		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
		Notification notificationRes=notificationRepository.saveAndFlush(notification);
 
        ObjectMapper om = new ObjectMapper();
        String jsonStr = om.writeValueAsString(notificationRes);
		if(notificationRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Notification.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Notification Saved Successfully.");
			
			User userRes=userRepository.findById(notificationRes.getUserId());
			List<String> usrTokens=userRepository.findTokensNotIn(notificationRes.getUserId());

			List<String> frTokens=franchiseSupRepository.findTokens();

			frTokens.addAll(usrTokens);
			 try {
		    	 for(String token:frTokens)
		    	 {
		    	  if(token!=null)
		    	  {
		          Firebase.sendPushNotifForCommunication(token,notificationRes.getSubject()+"#"+userRes.getUsername(),jsonStr,"nf");
		    	  }
		    	 }
		         }
		         catch(Exception e)
		         {
			       e.printStackTrace();
		         }
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Notification.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteNotification(int notificationId) {
      
		  ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=notificationRepository.deleteNotification(notificationId);
		
			if(isUpdated>=1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("Notification Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Notification Deletion Failed");
				
			}
			return errorMessage;

	}

	@Override
	public ErrorMessage saveSuggestion(Suggestion suggestion) {
		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
			Suggestion suggestionRes=suggestionRepository.saveAndFlush(suggestion);
			 ObjectMapper om = new ObjectMapper();
		     String jsonStr = om.writeValueAsString(suggestionRes);
		if(suggestionRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Suggestion.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Suggestion Saved Successfully.");
			AllFrIdName allFrIdName=allFrIdNameRepository.findByFrId(suggestionRes.getFrId());
			List<String> usrTokens=userRepository.findTokens();
			
			 try {
		    	 for(String token:usrTokens)
		    	 {
		    	
		          Firebase.sendPushNotifForCommunication(token,suggestionRes.getTitle()+"#"+allFrIdName.getFrName(),jsonStr,"s");
		    	 }
		         }
		         catch(Exception e)
		         {
			       e.printStackTrace();
		         }
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Suggestion.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteSuggestion(int suggestionId) {
	
		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=suggestionRepository.deleteSuggestion(suggestionId);
		
			if(isUpdated>=1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("Suggestion Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Suggestion Deletion Failed");
				
			}
			return errorMessage;
	}

	@Override
	public ErrorMessage saveComplaint(Complaint complaint) {
		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
			Complaint complaintRes=complaintRepository.saveAndFlush(complaint);
			 ObjectMapper om = new ObjectMapper();
		     String jsonStr = om.writeValueAsString(complaintRes);
		if(complaintRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Complaint.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Complaint Saved Successfully.");
			AllFrIdName allFrIdName=allFrIdNameRepository.findByFrId(complaintRes.getFrId());

			List<String> usrTokens=userRepository.findTokens();
			
			 try {
		    	 for(String token:usrTokens)
		    	 {
		    	
		          Firebase.sendPushNotifForCommunication(token,complaintRes.getTitle()+"#"+allFrIdName.getFrName(),jsonStr,"c");
		    	 }
		         }
		         catch(Exception e)
		         {
			       e.printStackTrace();
		         }
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Complaint.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteComplaint(int complaintId) {
		
		    ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=complaintRepository.deleteComplaint(complaintId);
		
			if(isUpdated>=1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("Complaint Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Complaint Deletion Failed");
				
			}
			return errorMessage;
		
	}

	@Override
	public ErrorMessage saveFeedback(Feedback feedback) {
		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
			Feedback feedbackRes=feedbackRepository.saveAndFlush(feedback);
			 ObjectMapper om = new ObjectMapper();
		     String jsonStr = om.writeValueAsString(feedbackRes);
		if(feedbackRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Feedback.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Feedback Saved Successfully.");
			
			List<String> usrTokens=userRepository.findTokensNotIn(feedbackRes.getUserId());
			User userRes=new User();
			try {
			 userRes=userRepository.findById(feedbackRes.getUserId());
			 System.out.println("UserRes:"+userRes.toString());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			List<String> frTokens=franchiseSupRepository.findTokens();
			frTokens.addAll(usrTokens);
			
			 try {
		    	 for(String token:frTokens)
		    	 {
		    	
		          Firebase.sendPushNotifForCommunication(token,feedbackRes.getTitle()+"#"+userRes.getUsername(),jsonStr,"f");
		    	 }
		         }
		         catch(Exception e)
		         {
			       e.printStackTrace();
		         }
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Feedback.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteFeedback(int feedbackId) {
		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=feedbackRepository.deleteFeedback(feedbackId);
		
			if(isUpdated>=1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("Feedback Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Feedback Deletion Failed");
				
			}
			return errorMessage;
	}

	@Override
	public ErrorMessage saveSuggestionDetail(SuggestionDetail suggestionDetail) {
		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
			SuggestionDetail suggestionDetailRes=suggestionDetailRepository.saveAndFlush(suggestionDetail);
			 ObjectMapper om = new ObjectMapper();
		     String jsonStr = om.writeValueAsString(suggestionDetailRes);
		if(suggestionDetailRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save SuggestionDetail.");
			
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("SuggestionDetail Saved Successfully.");
			
			if(suggestionDetailRes.getIsAdmin()==0)
			{
			   //if sender is fr,then Send Notification to All Admin
				List<String> usrTokens=userRepository.findTokens();
				AllFrIdName allFrIdName=new AllFrIdName();
				try {
				 allFrIdName=allFrIdNameRepository.findByFrId(suggestionDetail.getFrId());
               System.out.println("allFrIdName"+allFrIdName.getFrName());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				 try {
			    	 for(String token:usrTokens)
			    	 {
			    	
			          Firebase.sendPushNotifForCommunication(token,"Suggestion"+"#"+allFrIdName.getFrName(),jsonStr,"sd");
			    	 }
			         }
			         catch(Exception e)
			         {
				       e.printStackTrace();
			         }
				
				
			}
			else if(suggestionDetailRes.getIsAdmin()==1)
			{
				   List<String> usrTokens=userRepository.findTokensNotIn(suggestionDetailRes.getFrId());
					User userRes=userRepository.findById(suggestionDetailRes.getFrId());

				   String frToken=suggestionDetailRepository.findFrTokenBySuggestionId(suggestionDetailRes.getSuggestionId());
				
				   usrTokens.add(frToken);
				   
				      try {
				    	 for(String token:usrTokens)
				    	 {
				    	
				          Firebase.sendPushNotifForCommunication(token,"Suggestion"+"#"+userRes.getUsername(),jsonStr,"sd");
				    	 }
				         }
				         catch(Exception e)
				         {
					       e.printStackTrace();
				         }
				   
			}
				
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save SuggestionDetail.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage saveComplaintDetail(ComplaintDetail complaintDetail) {
		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
			ComplaintDetail complaintDetailRes=complaintDetailRepository.saveAndFlush(complaintDetail);
			 ObjectMapper om = new ObjectMapper();
		     String jsonStr = om.writeValueAsString(complaintDetailRes);
		if(complaintDetailRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save ComplaintDetail.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("ComplaintDetail Saved Successfully.");
			
			if(complaintDetailRes.getIsAdmin()==0)
			{
			   //if sender is fr,then Send Notification to All Admin
				List<String> usrTokens=userRepository.findTokens();
				AllFrIdName allFrIdName=allFrIdNameRepository.findByFrId(complaintDetail.getFrId());

				 try {
			    	 for(String token:usrTokens)
			    	 {
			    	
			          Firebase.sendPushNotifForCommunication(token,complaintDetailRes.getMessage()+"#"+allFrIdName.getFrName(),jsonStr,"cd");
			    	 }
			         }
			         catch(Exception e)
			         {
				       e.printStackTrace();
			         }
				
				
			}
			else if(complaintDetailRes.getIsAdmin()==1)
			{
				   List<String> usrTokens=userRepository.findTokensNotIn(complaintDetailRes.getFrId());
					User userRes=userRepository.findById(complaintDetailRes.getFrId());

				   String frToken=complaintDetailRepository.findFrTokenByComplaintId(complaintDetailRes.getComplaintId());
				
				   usrTokens.add(frToken);
				   
				      try {
				    	 for(String token:usrTokens)
				    	 {
				    	
				          Firebase.sendPushNotifForCommunication(token,complaintDetailRes.getMessage()+"#"+userRes.getUsername(),jsonStr,"cd");
				    	 }
				         }
				         catch(Exception e)
				         {
					       e.printStackTrace();
				         }
				   
			}
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save ComplaintDetail.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage saveFeedbackDetail(FeedbackDetail feedbackDetail) {
		ErrorMessage errorMessage=new ErrorMessage();
		try {
			
			FeedbackDetail feedbackDetailRes=feedbackDetailRepository.saveAndFlush(feedbackDetail);
			 ObjectMapper om = new ObjectMapper();
		     String jsonStr = om.writeValueAsString(feedbackDetailRes);
		if(feedbackDetailRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save FeedbackDetail.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("FeedbackDetail Saved Successfully.");
			
			if(feedbackDetailRes.getIsAdmin()==0)
			{
			   //if sender is fr,then Send Notification to All Admin
				List<String> usrTokens=userRepository.findTokens();
				AllFrIdName allFrIdName=allFrIdNameRepository.findByFrId(feedbackDetail.getFrId());

				 try {
			    	 for(String token:usrTokens)
			    	 {
			    	
			          Firebase.sendPushNotifForCommunication(token,feedbackDetailRes.getMessage()+"#"+allFrIdName.getFrName(),jsonStr,"fd");
			    	 }
			         }
			         catch(Exception e)
			         {
				       e.printStackTrace();
			         }
				
				
			}
			else if(feedbackDetailRes.getIsAdmin()==1)
			{
				   List<String> usrTokens=userRepository.findTokensNotIn(feedbackDetailRes.getFrId());
					List<String> frTokens=franchiseSupRepository.findTokens();
					User userRes=userRepository.findById(feedbackDetailRes.getFrId());
                    System.out.println("userRes"+userRes.toString());
					usrTokens.addAll(frTokens);
				      try {
				    	 for(String token:usrTokens)
				    	 {
				    	
				          Firebase.sendPushNotifForCommunication(token,feedbackDetailRes.getMessage()+"#"+userRes.getUsername(),jsonStr,"fd");
				    	 }
				         }
				         catch(Exception e)
				         {
					       e.printStackTrace();
				         }
				   
			}
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save FeedbackDetail.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public List<GetSuggestion> getAllSuggestions() {

		List<GetSuggestion> allSuggestions=new ArrayList<GetSuggestion>();
		
		try {
			 allSuggestions=getSuggestionRepository.findAllGetSuggestions();
			 
			 for(int i=0;i<allSuggestions.size();i++)
				{
					List<GetSuggestionDetail> suggestionDetails=getSuggestionDetailRepository.findBySuggestionId(allSuggestions.get(i).getSuggestionId());
					allSuggestions.get(i).setSuggestionDetails(suggestionDetails);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allSuggestions;
	}
	@Override
	public List<GetComplaint> getAllComplaints() {
		List<GetComplaint> allComplaints=new ArrayList<GetComplaint>();
		try {
       allComplaints=getComplaintRepository.getAllComplaints(0);
		
		for(int i=0;i<allComplaints.size();i++)
		{
			List<GetComplaintDetail> complaintDetails=getComplaintDetailRepository.findByComplaintId(allComplaints.get(i).getComplaintId());
			allComplaints.get(i).setGetComplaintDetailList(complaintDetails);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return allComplaints;
	}

	@Override
	public List<GetNotification> getAllNotification() {
      
		List<GetNotification> notificationList=new ArrayList<GetNotification>();
		try {
		notificationList=getNotificationRepository.findByIsClosed(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return notificationList;
	}

	@Override
	public List<GetFeedback> getAllFeedback() {

		List<GetFeedback> feedbackList=new ArrayList<GetFeedback>();
		try {
		 feedbackList=getFeedbackRepository.findByIsClosed(0);
		
		for(int i=0;i<feedbackList.size();i++)
		{
			List<GetFeedbackDetail> feedbackDetailList=getFeedbackDetailRepository.getAllDetailsByFeedbackId(feedbackList.get(i).getFeedbackId());
			feedbackList.get(i).setGetFeedbackDetails(feedbackDetailList);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return feedbackList;
	}

	@Override
	public List<GetComplaint> getAllComplaintsByFrId(int frId) {
		List<GetComplaint> allComplaints=new ArrayList<GetComplaint>();
		try {
       allComplaints=getComplaintRepository.getAllComplaintsByFrId(0,frId);
		
		for(int i=0;i<allComplaints.size();i++)
		{
			List<GetComplaintDetail> complaintDetails=getComplaintDetailRepository.findByComplaintId(allComplaints.get(i).getComplaintId());
			allComplaints.get(i).setGetComplaintDetailList(complaintDetails);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return allComplaints;
	}

	@Override
	public List<GetFeedback> getAllFeedbackByFrId(int frId) {
		List<GetFeedback> feedbackList=new ArrayList<GetFeedback>();
		try {
		 feedbackList=getFeedbackRepository.findByIsClosed(0);
		
		for(int i=0;i<feedbackList.size();i++)
		{
			List<GetFeedbackDetail> feedbackDetailList=getFeedbackDetailRepository.getAllDetailsByFrIdAndFeedbackId(frId,feedbackList.get(i).getFeedbackId());
			feedbackList.get(i).setGetFeedbackDetails(feedbackDetailList);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return feedbackList;
	}

	@Override
	public ErrorMessage updateUserToken(int isAdmin, int userId, String token) {

		ErrorMessage errorMessage=new ErrorMessage();
        if(isAdmin==0)
        {
        	int isUpdated=franchiseSupRepository.updateUserToken(userId,token);
    		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("User Token Updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("User Token updation Failed");
				
			}
        }
        else if(isAdmin==1)
        {
          int isUpdated=userRepository.updateUserToken(userId,token);
    		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("User Token Updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("User Token updation Failed");
				
			}
        }
		
		return errorMessage;
	}

	@Override
	public List<GetSuggestion> getAllSuggestionsByFrId(int frId) {
    List<GetSuggestion> allSuggestions=new ArrayList<GetSuggestion>();
		
		try {
			 allSuggestions=getSuggestionRepository.findAllGetSuggestionsByFrId(frId);
			 
			 for(int i=0;i<allSuggestions.size();i++)
				{
					List<GetSuggestionDetail> suggestionDetails=getSuggestionDetailRepository.findBySuggestionId(allSuggestions.get(i).getSuggestionId());
					allSuggestions.get(i).setSuggestionDetails(suggestionDetails);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allSuggestions;
	}

	@Override
	public List<GetSuggestion> getAllSuggHeaders(int suggestionId) {

		 List<GetSuggestion> allSuggestions=new ArrayList<GetSuggestion>();
			
			try {
				 allSuggestions=getSuggestionRepository.findAllGetSuggestionsBySuggestionId(suggestionId);
				 
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return allSuggestions;
	}

	@Override
	public List<GetSuggestionDetail> getAllSuggDetails(int suggestionDetailId) {

		List<GetSuggestionDetail> suggestionDetails=new ArrayList<GetSuggestionDetail>();
	try {	
		 suggestionDetails=getSuggestionDetailRepository.findBySuggestionDetailId(suggestionDetailId);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return suggestionDetails;
	}

	@Override
	public List<GetSuggestion> getAllSuggHeadersByFrId(int frId, int suggestionId) {
		 List<GetSuggestion> allSuggestions=new ArrayList<GetSuggestion>();

		try {
			 allSuggestions=getSuggestionRepository.findAllGetSuggHeadersByFrIdAndSuggestionId(frId,suggestionId);
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allSuggestions;
	}

	@Override
	public List<GetSuggestionDetail> getAllSuggDetailsByFrId(int frId, int suggestionDetailId) {

		List<GetSuggestionDetail> suggestionDetails=new ArrayList<GetSuggestionDetail>();
		try {	
			 suggestionDetails=getSuggestionDetailRepository.findBySuggestionDetailIdAndFrId(suggestionDetailId,frId);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return suggestionDetails;
	}

	@Override
	public List<GetComplaint> getAllComplHeaders(int complaintId) {
		List<GetComplaint> allComplaints=new ArrayList<GetComplaint>();
		try {
       allComplaints=getComplaintRepository.getAllComplHeaders(complaintId);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return allComplaints;
	}

	@Override
	public List<GetComplaintDetail> getAllComplDetails(int compDetailId) {

		List<GetComplaintDetail> complaintDetails=new ArrayList<GetComplaintDetail>();
		try {
		 complaintDetails=getComplaintDetailRepository.findByComplaintDetailId(compDetailId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return complaintDetails;
	}

	@Override
	public List<GetNotification> getAllNotificationById(int notificationId) {
		
		List<GetNotification> notificationList=new ArrayList<GetNotification>();
		try {
		notificationList=getNotificationRepository.findByNotificationId(notificationId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return notificationList; 
		
	}

	@Override
	public List<GetComplaint> getAllCompHeadersByFrId(int complaintId, int frId) {
	
		List<GetComplaint> allComplaints=new ArrayList<GetComplaint>();
		try {
       allComplaints=getComplaintRepository.getAllComplHeadersByFrId(complaintId,frId);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return allComplaints;
	}

	@Override
	public List<GetComplaintDetail> getAllComplDetailsByFrId(int frId, int compDetailId) {

		List<GetComplaintDetail> complaintDetails=new ArrayList<GetComplaintDetail>();
		try {
		 complaintDetails=getComplaintDetailRepository.findByComplaintDetailIdAndFrId(compDetailId,frId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return complaintDetails;
	}

	@Override
	public List<GetFeedback> getAllFeedbackById(int feedbackId) {

		List<GetFeedback> feedbackList=new ArrayList<GetFeedback>();
		try {
		 feedbackList=getFeedbackRepository.findByFeedbackId(feedbackId);
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return feedbackList;
	}

	@Override
	public List<GetFeedbackDetail> getAllFeedbackDetailById(int feedbackDetailId) {

		List<GetFeedbackDetail> feedbackDetailList=new ArrayList<GetFeedbackDetail>();
		try {
			feedbackDetailList=getFeedbackDetailRepository.getAllFeedbackDetailById(feedbackDetailId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return feedbackDetailList;
	}

	@Override
	public List<GetFeedback> getAllFeedbackHeadersByUserId(int userId, int feedbackId) {
		List<GetFeedback> feedbackList=new ArrayList<GetFeedback>();
		try {
		 feedbackList=getFeedbackRepository.findByUserIdAndFeedbackId(userId,feedbackId);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return feedbackList;
	}

	@Override
	public List<GetFeedbackDetail> getAllFeedbackDetailsByFrId(int frId, int feedbackDetailId) {
	
		List<GetFeedbackDetail> feedbackDetailList=new ArrayList<GetFeedbackDetail>();
		try {
			feedbackDetailList=getFeedbackDetailRepository.getAllFeedbackDetailsByFrId(frId,feedbackDetailId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return feedbackDetailList;
		
	}

	@Override
	public ErrorMessage sendNotificationToFr(List<Integer> frIds, String title, String message) {
		ErrorMessage eMessage=new ErrorMessage();

		try {
		List<String> frToken=franchiseSupRepository.findFrTokenByFrId(frIds);
			
		   if(!frToken.isEmpty()) {
		      try {
		    	 for(String token:frToken)
		    	 {
		    	
		          Firebase.sendPushNotifForCommunication(token,title,message,"inbox");
		    	 }
		         }
		         catch(Exception e)
		         {
			       e.printStackTrace();
		         }
		      eMessage.setError(false);
		      eMessage.setMessage("Notification Send Successfully");
		   }
		}catch (Exception e) {
			e.printStackTrace();
			  eMessage.setError(true);
		      eMessage.setMessage("Notification Failed to Send");
		}
		      return eMessage;
	}


}
