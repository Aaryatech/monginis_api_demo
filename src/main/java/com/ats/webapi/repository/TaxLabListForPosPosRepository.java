package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.TaxLabListForPos;

public interface TaxLabListForPosPosRepository extends JpaRepository<TaxLabListForPos, Integer>{

	@Query(value="select\n" + 
			"        sd.sell_bill_detail_no,\n" + 
			"        sum(sd.taxable_amt) as taxable_amt,\n" + 
			"        sd.cgst_per,\n" + 
			"        sd.igst_per,\n" + 
			"        sd.sgst_per,\n" + 
			"        sum(sd.cgst_rs) as cgst_rs,\n" + 
			"        sum(sd.sgst_rs) as sgst_rs,\n" + 
			"        sum(sd.igst_rs) as igst_rs\n" + 
			"    from\n" + 
			"        t_sell_bill_detail sd \n" + 
			"    where\n" + 
			"        sell_bill_no=:billId  \n" + 
			"        and sd.del_status=0\n" + 
			"    group by (sd.igst_per+sd.sgst_per)",nativeQuery=true)
	List<TaxLabListForPos> taxLabListForPosList(@Param("billId") int billId);
	@Query(value="select\n" + 
			"        sd.sell_bill_detail_no,\n" + 
			"        sum(sd.taxable_amt) as taxable_amt,\n" + 
			"        sd.cgst_per,\n" + 
			"        sd.igst_per,\n" + 
			"        sd.sgst_per,\n" + 
			"        sum(sd.cgst_rs) as cgst_rs,\n" + 
			"        sum(sd.sgst_rs) as sgst_rs,\n" + 
			"        sum(sd.igst_rs) as igst_rs\n" + 
			"    from\n" + 
			"        t_sell_bill_detail sd \n" + 
			"    where\n" + 
			"        sell_bill_detail_no in(:billDetailNoList)  \n" + 
			"        and sd.del_status=0\n" + 
			"    group by (sd.igst_per+sd.sgst_per)",nativeQuery=true)
	List<TaxLabListForPos> taxLabDetailsListForPosList(@Param("billDetailNoList")List<Integer> billDetailNoList);
}
