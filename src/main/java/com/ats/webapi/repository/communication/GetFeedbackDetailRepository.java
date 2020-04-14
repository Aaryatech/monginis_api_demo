package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.GetFeedbackDetail;

@Repository
public interface GetFeedbackDetailRepository extends JpaRepository<GetFeedbackDetail, Integer>{

	@Query(value="select d.feedback_detail_id,d.feedback_id,d.fr_id,d.message,d.is_admin,CASE WHEN d.is_admin=1 THEN (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.photo,d.date,d.time from m_comm_feedback_detail d where d.feedback_id=:feedbackId",nativeQuery=true)
	List<GetFeedbackDetail> getAllDetailsByFeedbackId(@Param("feedbackId")int feedbackId);
	
	@Query(value="select d.feedback_detail_id,d.feedback_id,d.fr_id,d.message,d.is_admin,CASE WHEN d.is_admin=1 THEN (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.photo,d.date,d.time from m_comm_feedback_detail d  where d.fr_id=:frId And d.feedback_id=:feedbackId",nativeQuery=true)
	List<GetFeedbackDetail> getAllDetailsByFrIdAndFeedbackId(@Param("frId")int frId,@Param("feedbackId")int feedbackId);

	@Query(value="select d.feedback_detail_id,d.feedback_id,d.fr_id,d.message,d.is_admin,CASE WHEN d.is_admin=1 THEN (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.photo,d.date,d.time from m_comm_feedback_detail d  where d.feedback_detail_id>:feedbackDetailId",nativeQuery=true)
	List<GetFeedbackDetail> getAllFeedbackDetailById(@Param("feedbackDetailId")int feedbackDetailId);

	@Query(value="select d.feedback_detail_id,d.feedback_id,d.fr_id,d.message,d.is_admin,CASE WHEN d.is_admin=1 THEN (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.photo,d.date,d.time from m_comm_feedback_detail d  where d.feedback_detail_id>:feedbackDetailId And d.fr_id=:frId",nativeQuery=true)
	List<GetFeedbackDetail> getAllFeedbackDetailsByFrId(@Param("frId")int frId,@Param("feedbackDetailId") int feedbackDetailId);


}
