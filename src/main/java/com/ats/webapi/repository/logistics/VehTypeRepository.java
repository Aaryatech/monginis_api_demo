package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.VehicalType;

public interface VehTypeRepository extends JpaRepository<VehicalType, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE VehicalType SET del_status=1 WHERE vehi_type_id=:vehId")
	int deleteVehType(@Param("vehId")int vehId);

	List<VehicalType> findAllByDelStatus(int delStatus);

	VehicalType findByVehiTypeId(int vehiTypeId);

	List<VehicalType> findByMakeIdAndDelStatus(int makeId,int delStatus); 
	
	

}
