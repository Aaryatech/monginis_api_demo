package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.logistics.GetServHeader;

public interface GetServHeaderRepo extends JpaRepository<GetServHeader, Integer> {

	@Query(value = "SELECT h.serv_id,h.serv_date,h.type_id,h.dealer_id,h.serv_type,h.serv_type2,h.bill_no,h.bill_date,h.veh_id,h.veh_no ,SUM(h.tax_amt) AS "
			+ "tax_amt,SUM(h.taxable_amt) AS taxable_amt,SUM(h.total) AS total  FROM m_logis_serv h WHERE h.del_status=0 AND h.serv_date BETWEEN :fromDate "
			+ "AND :toDate AND h.serv_type2=:typeId AND h.serv_type IN(:servType) AND h.veh_id IN(:vehIdList)   GROUP BY h.veh_id", nativeQuery = true)
	List<GetServHeader> findByBetweenDateAndVehIdListAndServType(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("typeId") int typeId, @Param("vehIdList") List<String> vehIdList,
			@Param("servType") List<String> servType);

	@Query(value = "SELECT h.serv_id,h.serv_date,h.type_id,h.dealer_id,h.serv_type,h.serv_type2,h.bill_no,h.bill_date,h.veh_id,h.veh_no ,h.tax_amt "
			+ " ,h.taxable_amt,h.total  FROM m_logis_serv h WHERE h.del_status=0 AND h.serv_date BETWEEN :fromDate "
			+ "AND :toDate  AND h.veh_id =:vehIdList  ", nativeQuery = true)
	List<GetServHeader> findByBetweenDateAndVehIdList(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("vehIdList") int vehIdList);

}
