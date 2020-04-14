package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.GetMCategory;

public interface MCatRepository extends JpaRepository<GetMCategory, Integer> {
	
	
	List<GetMCategory> findByDelStatus(int delStatus);
	

}
