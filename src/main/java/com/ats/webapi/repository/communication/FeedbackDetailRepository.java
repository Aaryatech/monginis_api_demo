package com.ats.webapi.repository.communication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.FeedbackDetail;

@Repository
public interface FeedbackDetailRepository extends JpaRepository<FeedbackDetail, Integer>{

}
