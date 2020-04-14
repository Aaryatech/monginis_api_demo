package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SectionMaster;

public interface SectionMasterRepository extends JpaRepository<SectionMaster, Integer>{

	SectionMaster save(SectionMaster sectionMaster);

	List<SectionMaster> findByDelStatus(int i);

	SectionMaster findBySectionIdAndDelStatus(int sectionId, int i);

	@Modifying
	@Transactional
	@Query("Update SectionMaster  SET del_status=1 WHERE section_id=:sectionId")
	int deleteSection(@Param("sectionId") int sectionId);
 

}
