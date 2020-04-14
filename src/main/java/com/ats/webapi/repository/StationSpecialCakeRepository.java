package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.StationSpCake;

@Repository
public interface StationSpecialCakeRepository extends JpaRepository<StationSpCake, Integer>{

	@Query(value="select t.sp_order_no,t.fr_id,t.sp_id,s.sp_code,s.sp_name from t_sp_cake t,m_sp_cake s WHERE t.sp_id=s.sp_id AND t.is_allocated=0",nativeQuery=true)
	List<StationSpCake> findStationSpCake();

}
