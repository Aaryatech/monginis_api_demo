package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.spprod.Instrument;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer>{

	Instrument findInstrumentByInstrumentId(int instrumentId);

	 @Transactional
	 @Modifying
	 @Query("UPDATE Instrument SET del_status=1 WHERE instrument_id=:instrumentId")
	int deleteByInstrumentId(@Param("instrumentId")int instrumentId);
	
	@Query(value="select i.instrument_id,i.instrument_name,i.instrument_opqty,i.instrument_clqty,i.instrument_is_used,i.instrument_status,i.stock_qty,i.inst_type,i.del_status from m_instrument i,m_emp_type t where t.sub_type=:instType AND i.del_status=:delStatus",nativeQuery=true)
	List<Instrument> findAllByDelStatus(@Param("delStatus")int delStatus,@Param("instType")int instType);

}
