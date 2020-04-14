package com.ats.webapi.repository.afe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.afe.AfeScoreDetail;

public interface AfeScoreDetailRepo extends JpaRepository<AfeScoreDetail, Integer> {
	
	AfeScoreDetail save(AfeScoreDetail detail);
	
	List<AfeScoreDetail> findByafeScoreHeaderIdAndDelStatus(int scoreHeaderId,int delStatus);
}
