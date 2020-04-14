package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OtherBillHeader;

public interface OtherBillHeaderRepository extends JpaRepository<OtherBillHeader, Integer>{

	List<OtherBillHeader> findAllByDelStatus(int delStatus);

	OtherBillHeader findByBillNoAndDelStatus(int billNo, int delStatus);

	@Query(value=" select * from t_other_bill_header where (bill_date between :fromDate and :toDate) and fr_id=:frId and del_status=0 ",nativeQuery=true) 
	List<OtherBillHeader> getOtherBillHeaderList( @Param("fromDate")String fromDate, @Param("toDate") String toDate, @Param("frId") String frId);

	@Query(value=" select * from t_other_bill_header where (bill_date between :fromDate and :toDate) and fr_id=:frId and supp_id=:suppId and del_status=0 ",nativeQuery=true) 
	List<OtherBillHeader> getOtherBillHeaderList( @Param("fromDate")String fromDate, @Param("toDate") String toDate, @Param("frId") String frId,
			@Param("suppId") int suppId);
 
	

}
