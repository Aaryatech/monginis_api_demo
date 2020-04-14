package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.Shift;
@Repository
public interface ShiftRepository extends JpaRepository<Shift, Integer>{

	Shift findShiftByShiftId(int shiftId);

	List<Shift> findShiftByDelStatus(int i);
	 
	@Transactional
	 @Modifying
	 @Query("UPDATE Shift SET del_status=1 WHERE shift_id=:shiftId")
	int deleteByShiftId(@Param("shiftId")int shiftId);

}
