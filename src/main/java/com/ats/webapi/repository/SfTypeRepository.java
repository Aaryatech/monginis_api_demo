package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.rawmaterial.GetSfType;

public interface SfTypeRepository extends JpaRepository<GetSfType, Integer> {
	
	List<GetSfType> findByDelStatus(int delStatus);

}
