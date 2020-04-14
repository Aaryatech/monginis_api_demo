package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetBillsForFr;

public interface GetBillsForFrRepository extends JpaRepository<GetBillsForFr, Integer> {
	
	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ "FROM t_bill_header WHERE t_bill_header.fr_id =:frId AND t_bill_header.bill_date BETWEEN :back15Days AND :curDate "
			+ " AND t_bill_header.del_status=0 AND t_bill_header.status=2 ORDER BY  t_bill_header.bill_no DESC  " + 
			"",nativeQuery=true)
	
	List<GetBillsForFr> getBillForSelectedFr(@Param("frId") int frId, @Param("back15Days") Date back15Days,@Param("curDate") Date curDate);

	
	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ "FROM t_bill_header WHERE t_bill_header.fr_id =:frId AND t_bill_header.bill_date=:billDate "
			+ " AND t_bill_header.del_status=0 AND t_bill_header.status=2 ORDER BY  t_bill_header.bill_no DESC" + 
			"",nativeQuery=true)
	
	List<GetBillsForFr> getBillForSelectedFrByDate(@Param("frId") int frId, @Param("billDate") Date billDate);
	
	
	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ "FROM t_bill_header WHERE t_bill_header.fr_id =:frId  "
			+ " AND t_bill_header.del_status=0 AND t_bill_header.status=2 ORDER BY  t_bill_header.bill_no DESC  " + 
			"",nativeQuery=true)
	
	List<GetBillsForFr> getAllBillForManGrn(@Param("frId") int frId);

}
