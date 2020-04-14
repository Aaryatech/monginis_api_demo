package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.regcakeasspreport.RegCakeAsSpDispatchReport;

public interface GetRegCakeAsSpRepo extends JpaRepository<RegCakeAsSpDispatchReport, Integer> {
	
	@Query(value=" SELECT " + 
			" t_regular_sp_cake.rsp_id,t_regular_sp_cake.fr_id,t_regular_sp_cake.item_id,t_regular_sp_cake.rsp_delivery_dt,m_franchisee.fr_name,t_regular_sp_cake.qty,m_item.item_name FROM t_regular_sp_cake,m_franchisee,m_item WHERE t_regular_sp_cake.fr_id IN(:frIdList)"
			+ " AND t_regular_sp_cake.fr_id=m_franchisee.fr_id AND "
			+ " t_regular_sp_cake.rsp_delivery_dt BETWEEN :fromDate AND :toDate AND " + 
			" m_item.id=t_regular_sp_cake.item_id and t_regular_sp_cake.del_status=0",nativeQuery=true)
	List<RegCakeAsSpDispatchReport> getRegcakeAsSpForDispatch(@Param("frIdList") List<String> frIdList,@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	
	@Query(value=" SELECT " + 
			" t_regular_sp_cake.rsp_id,t_regular_sp_cake.fr_id,t_regular_sp_cake.item_id,t_regular_sp_cake.rsp_delivery_dt,m_franchisee.fr_name,t_regular_sp_cake.qty,m_item.item_name FROM t_regular_sp_cake,m_franchisee,m_item WHERE "
			+ "  t_regular_sp_cake.fr_id=m_franchisee.fr_id AND "
			+ " t_regular_sp_cake.rsp_delivery_dt BETWEEN :fromDate AND :toDate AND " + 
			" m_item.id=t_regular_sp_cake.item_id and t_regular_sp_cake.del_status=0",nativeQuery=true)
	List<RegCakeAsSpDispatchReport> getRegcakeAsSpForDispatchAllFr(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);
	
	

}
