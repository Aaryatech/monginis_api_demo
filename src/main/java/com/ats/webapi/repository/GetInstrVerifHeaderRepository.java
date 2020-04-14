package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetInstVerifDetail;
import com.ats.webapi.model.spprod.GetInstrVerifHeader;

@Repository
public interface GetInstrVerifHeaderRepository extends JpaRepository<GetInstrVerifHeader, Integer>{

	@Query(value="Select inst_verif_h_id,inst_verif_date,user_id,station_id,shift_id,st_status,start_time,end_time from t_sp_inst_verif_h where inst_verif_h_id=:instVerifId",nativeQuery=true)
	GetInstrVerifHeader findGetInstrVerifHeaderByInstVerifHId(@Param("instVerifId")int instVerifId);

}
