package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.rawmaterial.RmItemGroup;

public interface RmItemGroupRepostitory extends JpaRepository<RmItemGroup, Integer>{
	
	List<RmItemGroup> findByDelStatus(int delStatus);

}
