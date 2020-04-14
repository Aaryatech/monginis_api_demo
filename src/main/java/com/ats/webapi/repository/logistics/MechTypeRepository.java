package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.logistics.MechType;

public interface MechTypeRepository extends JpaRepository<MechType, Integer>{

	List<MechType> findAllByDelStatus(int delStatus);

	List<MechType> findAllByTypeAndDelStatus(int type, int delStatus);
	
	

}
