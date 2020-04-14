package com.ats.webapi.repository.afe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.afe.AfeScoreHeader;

public interface AfeScoreHeaderRepo extends JpaRepository<AfeScoreHeader, Integer> {
	
	AfeScoreHeader save(AfeScoreHeader header);
	
	List<AfeScoreHeader> findByDelStatus(int delStatus);
	
}
