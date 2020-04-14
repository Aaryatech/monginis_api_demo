package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.GetInstVerifDetail;

@Repository
public interface GetInstVerifDetailRepository extends JpaRepository<GetInstVerifDetail, Integer>{

	@Query(value="select d.inst_verif_d_id,d.inst_verif_h_id,d.inst_id,i.instrument_name,d.bef,d.aft from t_sp_inst_verif_d d,m_instrument i where d.inst_id=i.instrument_id AND d.inst_verif_h_id=:instVerifHId",nativeQuery=true)
	List<GetInstVerifDetail> findAllByInstVerifHId(@Param("instVerifHId")int instVerifHId);


}
