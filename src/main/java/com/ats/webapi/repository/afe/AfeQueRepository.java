package com.ats.webapi.repository.afe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.afe.AfeQuestion;

public interface AfeQueRepository extends JpaRepository<AfeQuestion, Integer> {
	
	AfeQuestion save(AfeQuestion afeQue);
	
	List<AfeQuestion> findByDelStatus(int delStatus);
	
	
}
