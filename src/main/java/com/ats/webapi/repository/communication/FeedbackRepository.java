package com.ats.webapi.repository.communication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.communication.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

	
	@Transactional
	@Modifying
	@Query("UPDATE Feedback f SET f.isClosed=1  WHERE f.feedbackId=:feedbackId")
	int deleteFeedback(@Param("feedbackId")int feedbackId);

}
