package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.GetCustBillTax;


public interface GetCustBillTaxRepository extends JpaRepository<GetCustBillTax, Integer>{

	
	@Query(value="select sell_bill_detail_no, cgst_per, sgst_per, sum(taxable_amt) as taxable_amt, sum(cgst_rs) as cgst_rs,"
			+" sum(sgst_rs)as sgst_rs from t_sell_bill_detail where sell_bill_no=:billNo group by cgst_per, sgst_per",nativeQuery=true)
	List<GetCustBillTax> getCustBill(@Param("billNo") int billNo);
}
