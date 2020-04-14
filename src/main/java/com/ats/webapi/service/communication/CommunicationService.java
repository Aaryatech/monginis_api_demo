package com.ats.webapi.service.communication;

import java.util.List;

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

public interface CommunicationService {

	ErrorMessage saveNotification(Notification notification);

	ErrorMessage deleteNotification(int notificationId);

	ErrorMessage saveSuggestion(Suggestion suggestion);

	ErrorMessage deleteSuggestion(int suggestionId);

	ErrorMessage saveComplaint(Complaint complaint);

	ErrorMessage deleteComplaint(int complaintId);

	ErrorMessage saveFeedback(Feedback feedback);

	ErrorMessage deleteFeedback(int feedbackId);

	ErrorMessage saveSuggestionDetail(SuggestionDetail suggestionDetail);

	ErrorMessage saveComplaintDetail(ComplaintDetail complaintDetail);

	ErrorMessage saveFeedbackDetail(FeedbackDetail feedbackDetail);

	List<GetSuggestion> getAllSuggestions();

	List<GetComplaint> getAllComplaints();

	List<GetNotification> getAllNotification();

	List<GetFeedback> getAllFeedback();

	List<GetComplaint> getAllComplaintsByFrId(int frId);

	List<GetFeedback> getAllFeedbackByFrId(int frId);

	ErrorMessage updateUserToken(int isAdmin, int userId, String token);

	List<GetSuggestion> getAllSuggestionsByFrId(int frId);

	List<GetSuggestion> getAllSuggHeaders(int suggestionId);

	List<GetSuggestionDetail> getAllSuggDetails(int suggestionDetailId);

	List<GetSuggestion> getAllSuggHeadersByFrId(int frId, int suggestionId);

	List<GetSuggestionDetail> getAllSuggDetailsByFrId(int frId, int suggestionDetailId);

	List<GetComplaint> getAllComplHeaders(int complaintId);

	List<GetComplaintDetail> getAllComplDetails(int compDetailId);

	List<GetNotification> getAllNotificationById(int notificationId);

	List<GetComplaint> getAllCompHeadersByFrId(int complaintId, int frId);

	List<GetComplaintDetail> getAllComplDetailsByFrId(int frId, int compDetailId);

	List<GetFeedback> getAllFeedbackById(int feedbackId);

	List<GetFeedbackDetail> getAllFeedbackDetailById(int feedbackDetailId);

	List<GetFeedback> getAllFeedbackHeadersByUserId(int userId, int feedbackId);

	List<GetFeedbackDetail> getAllFeedbackDetailsByFrId(int frId, int feedbackDetailId);

	ErrorMessage sendNotificationToFr(List<Integer> frIds, String title, String message);

}
