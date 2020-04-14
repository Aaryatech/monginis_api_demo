package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.MRule; 

public interface MRuleRepository extends JpaRepository<MRule, Integer>{

	List<MRule> findAllByStatus(int delStatus);

}
