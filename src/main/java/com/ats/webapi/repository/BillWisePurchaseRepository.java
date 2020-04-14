package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.BillWisePurchase;
import com.ats.webapi.model.BillWiseTaxReport;

@Repository
public interface BillWisePurchaseRepository extends JpaRepository<BillWisePurchase,Long>{
	
	@Query(value="select h.bill_no,h.invoice_no,h.bill_date,h.taxable_amt,SUM(d.igst_rs) as igst_rs,SUM(d.cgst_rs) as cgst_rs,SUM(d.sgst_rs) as sgst_rs,h.grand_total from t_bill_header h,t_bill_detail d where h.bill_no=d.bill_no AND h.fr_id=:frId AND  h.del_status=0 and d.del_status=0 AND h.bill_date BETWEEN :fromDate AND :toDate group by d.bill_no",nativeQuery=true)
	List<BillWisePurchase> findBillWisePurchaseReport(@Param("frId")int frId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
