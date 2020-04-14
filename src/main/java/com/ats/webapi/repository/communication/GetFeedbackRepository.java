package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.GetFeedback;

@Repository
public interface GetFeedbackRepository extends JpaRepository<GetFeedback, Integer>{

	@Query(value="select f.feedback_id,f.title,user_id,u.usr_name as user_name,f.photo,f.description,f.date,f.time,f.is_closed from m_comm_feedback f,m_user u where f.user_id=u.usr_id And f.is_closed=:isClosed",nativeQuery=true)
	List<GetFeedback> findByIsClosed(@Param("isClosed")int isClosed);

	@Query(value="select f.feedback_id,f.title,user_id,u.usr_name as user_name,f.photo,f.description,f.date,f.time,f.is_closed from m_comm_feedback f,m_user u where f.user_id=u.usr_id And f.is_closed=0 And f.feedback_id>:feedbackId",nativeQuery=true)
	List<GetFeedback> findByFeedbackId(@Param("feedbackId")int feedbackId);

	@Query(value="select f.feedback_id,f.title,user_id,u.usr_name as user_name,f.photo,f.description,f.date,f.time,f.is_closed from m_comm_feedback f,m_user u where f.user_id=u.usr_id And f.is_closed=0 And f.feedback_id>:feedbackId And f.user_id=:userId",nativeQuery=true)
	List<GetFeedback> findByUserIdAndFeedbackId(@Param("userId")int userId,@Param("feedbackId") int feedbackId);

}
