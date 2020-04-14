package com.ats.webapi.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
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
import com.ats.webapi.service.communication.CommunicationService;

@RestController
@RequestMapping("communication")
public class CommunicationController {
	
	@Autowired
	CommunicationService communicationService;
	
	    //----------------------Save Notification------------------------------------
		@RequestMapping(value = { "/saveNotification" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveNotification(@RequestBody Notification notification)
		{

			try {
			Date date = new Date();
			notification.setDate(date);
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			String time=sdf.format(Calendar.getInstance().getTimeInMillis());
			
			notification.setTime(time);

			}
			catch (Exception e) {
             e.printStackTrace();
           }
			ErrorMessage errorMessage=communicationService.saveNotification(notification);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete Notification----------------------------------
		@RequestMapping(value = { "/deleteNotification" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteNotification(@RequestParam("notificationId")int notificationId)
		{
					
			ErrorMessage errorMessage=communicationService.deleteNotification(notificationId);
					
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		 //----------------------Save Suggestion------------------------------------
		@RequestMapping(value = { "/saveSuggestion" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveSuggestion(@RequestBody Suggestion suggestion)
		{
			try {
				Date date = new Date();
				suggestion.setDate(date);
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String time=sdf.format(Calendar.getInstance().getTimeInMillis());
				suggestion.setTime(time);
				}
				catch (Exception e) {
	             e.printStackTrace();
	           }
			ErrorMessage errorMessage=communicationService.saveSuggestion(suggestion);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete Suggestion----------------------------------
		@RequestMapping(value = { "/deleteSuggestion" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteSuggestion(@RequestParam("suggestionId")int suggestionId)
		{
							
			ErrorMessage errorMessage=communicationService.deleteSuggestion(suggestionId);
							
			return errorMessage;
	    }
	     //--------------------------END--------------------------------------------------
		 //----------------------Save Complaint------------------------------------
		@RequestMapping(value = { "/saveComplaint" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveComplaint(@RequestBody Complaint complaint)
		{
			try {
				Date date = new Date();
				complaint.setDate(date);
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String time=sdf.format(Calendar.getInstance().getTimeInMillis());
				complaint.setTime(time);
				}
				catch (Exception e) {
	             e.printStackTrace();
	           }
			ErrorMessage errorMessage=communicationService.saveComplaint(complaint);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete Complaint----------------------------------
		@RequestMapping(value = { "/deleteComplaint" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteComplaint(@RequestParam("complaintId")int complaintId)
		{
									
			ErrorMessage errorMessage=communicationService.deleteComplaint(complaintId);
									
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		 //----------------------Save Feedback------------------------------------
		@RequestMapping(value = { "/saveFeedback" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveFeedback(@RequestBody Feedback feedback)
		{
			try {
				Date date = new Date();
				feedback.setDate(date);
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String time=sdf.format(Calendar.getInstance().getTimeInMillis());
				feedback.setTime(time);
				}
				catch (Exception e) {
	             e.printStackTrace();
	           }	
			ErrorMessage errorMessage=communicationService.saveFeedback(feedback);
				
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete Complaint----------------------------------
		@RequestMapping(value = { "/deleteFeedback" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteFeedback(@RequestParam("feedbackId")int feedbackId)
		{
											
			ErrorMessage errorMessage=communicationService.deleteFeedback(feedbackId);
											
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//----------------------Save Suggestion Detail------------------------------------
		@RequestMapping(value = { "/saveSuggestionDetail" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveSuggestionDetail(@RequestBody SuggestionDetail suggestionDetail)
		{
			System.out.println("String.valueOf(new Timestamp(System.currentTimeMillis())"+String.valueOf(new Timestamp(System.currentTimeMillis())));
			try {
				Date date = new Date();
				suggestionDetail.setDate(date);
				
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String time=sdf.format(Calendar.getInstance().getTimeInMillis());
				suggestionDetail.setTime(time);
				}
				catch (Exception e) {
	             e.printStackTrace();
	           }		
			ErrorMessage errorMessage=communicationService.saveSuggestionDetail(suggestionDetail);
				
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		 //----------------------Save Complaint Detail------------------------------------
		@RequestMapping(value = { "/saveComplaintDetail" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveComplaintDetail(@RequestBody ComplaintDetail complaintDetail)
		{
			try {
				Date date = new Date();
				complaintDetail.setDate(date);
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String time=sdf.format(Calendar.getInstance().getTimeInMillis());
				complaintDetail.setTime(time);
				}
				catch (Exception e) {
	             e.printStackTrace();
	           }		
			ErrorMessage errorMessage=communicationService.saveComplaintDetail(complaintDetail);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//----------------------Save FeedbackDetail------------------------------------
		@RequestMapping(value = { "/saveFeedbackDetail" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveFeedbackDetail(@RequestBody FeedbackDetail feedbackDetail)
		{
			try {
				Date date = new Date();
				feedbackDetail.setDate(date);
				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
				String time=sdf.format(Calendar.getInstance().getTimeInMillis());
				feedbackDetail.setTime(time);
				}
				catch (Exception e) {
	             e.printStackTrace();
	           }		
			ErrorMessage errorMessage=communicationService.saveFeedbackDetail(feedbackDetail);
				
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		// ---------------------------Getting AllSuggestions-------------------------
		@RequestMapping(value = { "/getAllSuggestions" }, method = RequestMethod.GET)
		public @ResponseBody List<GetSuggestion> getAllSuggestions() {

			List<GetSuggestion> allSuggestions = communicationService.getAllSuggestions();

		    return allSuggestions;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting AllSuggestionHeaders-------------------------
				@RequestMapping(value = { "/getAllSuggHeaders" }, method = RequestMethod.POST)
				public @ResponseBody List<GetSuggestion> getAllSuggHeaders(@RequestParam("suggestionId")int suggestionId) {

					List<GetSuggestion> allSuggestions = communicationService.getAllSuggHeaders(suggestionId);

				    return allSuggestions;

				}
		//-----------------------------------------------------------------------------
				// ---------------------------Getting AllSuggestionDetails-------------------------
				@RequestMapping(value = { "/getAllSuggDetails" }, method = RequestMethod.POST)
				public @ResponseBody List<GetSuggestionDetail> getAllSuggDetails(@RequestParam("suggestionDetailId")int suggestionDetailId) {

					List<GetSuggestionDetail> allSuggestionsDetails = communicationService.getAllSuggDetails(suggestionDetailId);

				    return allSuggestionsDetails;

				}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting AllSuggestions By FrId-------------------------
			@RequestMapping(value = { "/getAllSuggestionsByFrId" }, method = RequestMethod.POST)
			public @ResponseBody List<GetSuggestion> getAllSuggestionsByFrId(@RequestParam("frId")int frId) {

				List<GetSuggestion> allSuggestions = communicationService.getAllSuggestionsByFrId(frId);

				return allSuggestions;

			}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting AllSuggHeaders By FrId-------------------------
		@RequestMapping(value = { "/getAllSuggHeadersByFrId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetSuggestion> getAllSuggHeadersByFrId(@RequestParam("frId")int frId,@RequestParam("suggestionId")int suggestionId) {

				List<GetSuggestion> allSuggestions = communicationService.getAllSuggHeadersByFrId(frId,suggestionId);

				return allSuggestions;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting AllSuggestionDetailsByFrId-------------------------
		@RequestMapping(value = { "/getAllSuggDetailsByFrId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetSuggestionDetail> getAllSuggDetailsByFrId(@RequestParam("frId")int frId,@RequestParam("suggestionDetailId")int suggestionDetailId) {

			List<GetSuggestionDetail> allSuggestionsDetails = communicationService.getAllSuggDetailsByFrId(frId,suggestionDetailId);

		    return allSuggestionsDetails;

		}
        //-----------------------------------------------------------------------------
		// ---------------------------Getting AllComplaints-------------------------
		@RequestMapping(value = { "/getAllComplaints" }, method = RequestMethod.GET)
		public @ResponseBody List<GetComplaint> getAllComplaints() {

			List<GetComplaint> allComplaint =communicationService.getAllComplaints();

			return allComplaint;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting getAllComplHeaders-------------------------
				@RequestMapping(value = { "/getAllComplHeaders" }, method = RequestMethod.POST)
				public @ResponseBody List<GetComplaint> getAllComplHeaders(@RequestParam("complaintId")int complaintId) {

					List<GetComplaint> allComplaint =communicationService.getAllComplHeaders(complaintId);

					return allComplaint;

				}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting getAllComplDetails-------------------------
				@RequestMapping(value = { "/getAllComplDetails" }, method = RequestMethod.POST)
				public @ResponseBody List<GetComplaintDetail> getAllComplDetails(@RequestParam("compDetailId")int compDetailId) {

					List<GetComplaintDetail> allComplaintDetails =communicationService.getAllComplDetails(compDetailId);

					return allComplaintDetails;

				}
		//-----------------------------------------------------------------------------
		
		// ---------------------------Getting AllComplaints By FrId-------------------------
		@RequestMapping(value = { "/getAllComplaintsByFrId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetComplaint> getAllComplaintsByFrId(@RequestParam("frId")int frId) {

			List<GetComplaint> allComplaint =communicationService.getAllComplaintsByFrId(frId);

			return allComplaint;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting AllComplaintsHeaders By FrId-------------------------
				@RequestMapping(value = { "/getAllCompHeadersByFrId" }, method = RequestMethod.POST)
				public @ResponseBody List<GetComplaint> getAllCompHeadersByFrId(@RequestParam("complaintId")int complaintId,@RequestParam("frId")int frId) {

					List<GetComplaint> allComplaint =communicationService.getAllCompHeadersByFrId(complaintId,frId);

					return allComplaint;

				}
	   //-----------------------------------------------------------------------------
		// ---------------------------Getting getAllComplDetails-------------------------
				@RequestMapping(value = { "/getAllComplDetailsByFrId" }, method = RequestMethod.POST)
				public @ResponseBody List<GetComplaintDetail> getAllComplDetailsByFrId(@RequestParam("frId")int frId,@RequestParam("compDetailId")int compDetailId) {

					List<GetComplaintDetail> allComplaintDetails =communicationService.getAllComplDetailsByFrId(frId,compDetailId);

					return allComplaintDetails;

				}
		//-----------------------------------------------------------------------------
		
		// ---------------------------Getting All Notifications-------------------------
		@RequestMapping(value = { "/getAllNotification" }, method = RequestMethod.GET)
		public @ResponseBody List<GetNotification> getAllNotification() {

				List<GetNotification> notificationRes=communicationService.getAllNotification();

				return notificationRes;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting All NotificationById-------------------------
		@RequestMapping(value = { "/getAllNotificationById" }, method = RequestMethod.POST)
		public @ResponseBody List<GetNotification> getAllNotificationById(@RequestParam("notificationId")int notificationId) {

				List<GetNotification> notificationRes=communicationService.getAllNotificationById(notificationId);

				return notificationRes;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting All Feedback-------------------------
		@RequestMapping(value = { "/getAllFeedback" }, method = RequestMethod.GET)
		public @ResponseBody List<GetFeedback> getAllFeedback() {

				List<GetFeedback> feedbackRes=communicationService.getAllFeedback();

				return feedbackRes;

		}
		//-----------------------------------------------------------------------------
		//---------------------------Getting All Feedback ById-------------------------
		@RequestMapping(value = { "/getAllFeedbackById" }, method = RequestMethod.POST)
		public @ResponseBody List<GetFeedback> getAllFeedbackById(@RequestParam("feedbackId")int feedbackId) {

				List<GetFeedback> feedbackRes=communicationService.getAllFeedbackById(feedbackId);

				return feedbackRes;

		}
		//-----------------------------------------------------------------------------
		//---------------------------Getting All FeedbackDetail ById-------------------------
				@RequestMapping(value = { "/getAllFeedbackDetailById" }, method = RequestMethod.POST)
				public @ResponseBody List<GetFeedbackDetail> getAllFeedbackDetailById(@RequestParam("feedbackDetailId")int feedbackDetailId) {

						List<GetFeedbackDetail> feedbackRes=communicationService.getAllFeedbackDetailById(feedbackDetailId);

						return feedbackRes;

				}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting All Feedback-------------------------
		@RequestMapping(value = { "/getAllFeedbackByFrId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetFeedback> getAllFeedbackByFrId(@RequestParam("frId")int frId) {

				List<GetFeedback> feedbackRes=communicationService.getAllFeedbackByFrId(frId);

				return feedbackRes;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting All Feedback By userId-------------------------
		@RequestMapping(value = { "/getAllFeedbackHeadersByUserId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetFeedback> getAllFeedbackHeadersByUserId(@RequestParam("userId")int userId,@RequestParam("feedbackId")int feedbackId) {

				List<GetFeedback> feedbackRes=communicationService.getAllFeedbackHeadersByUserId(userId,feedbackId);

				return feedbackRes;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting All Feedback By frId-------------------------
		@RequestMapping(value = { "/getAllFeedbackDetailsByFrId" }, method = RequestMethod.POST)
		public @ResponseBody List<GetFeedbackDetail> getAllFeedbackDetailsByFrId(@RequestParam("frId")int frId,@RequestParam("feedbackDetailId")int feedbackDetailId) {

				List<GetFeedbackDetail> feedbackRes=communicationService.getAllFeedbackDetailsByFrId(frId,feedbackDetailId);

				return feedbackRes;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Update userToken-------------------------
			@RequestMapping(value = { "/updateUserToken" }, method = RequestMethod.POST)
			public @ResponseBody ErrorMessage updateUserToken(@RequestParam("isAdmin")int isAdmin,@RequestParam("userId")int userId,@RequestParam("token")String token) {

				ErrorMessage errorMessage = communicationService.updateUserToken(isAdmin,userId,token);
						            
				return errorMessage;

			}
			//------------------------------------------------------------------------------------
			// ---------------------------Send Notification To Franchise's-------------------------
			@RequestMapping(value = { "/sendNotificationToFr" }, method = RequestMethod.POST)
			public @ResponseBody ErrorMessage sendNotificationToFr(@RequestParam("frIds")List<Integer> frIds,@RequestParam("title")String title,@RequestParam("message")String message) {

				ErrorMessage errorMessage = communicationService.sendNotificationToFr(frIds,title,message);
						            
				return errorMessage;

			}
			//------------------------------------------------------------------------------------
		
}
