package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.BillWiseTaxReport;

@Repository
public interface BillWiseTaxReportRepository  extends JpaRepository<BillWiseTaxReport, Long>{

	@Query(value="select d.bill_detail_no, h.invoice_no as bill_no,h.bill_date,SUM(d.taxable_amt) as taxable_amt,d.sgst_per+d.cgst_per as tax_rate,SUM(d.igst_rs) as igst_rs,SUM(d.cgst_rs) as cgst_rs,SUM(d.sgst_rs) as sgst_rs,SUM(d.grand_total) as grand_total from t_bill_header h,t_bill_detail d where h.bill_no=d.bill_no AND h.fr_id=:frId and h.del_status=0 and d.del_status=0 AND h.bill_date BETWEEN :fromDate AND :toDate group by d.sgst_per+d.cgst_per",nativeQuery=true)
	List<BillWiseTaxReport> findBillWiseTaxReport(@Param("frId")int frId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value=" select\n" + 
			"        d.crnd_id as bill_detail_no,\n" + 
			"        h.crn_id as bill_no,\n" + 
			"        h.crn_date as bill_date,\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\n" + 
			"        d.sgst_per+d.cgst_per as tax_rate,\n" + 
			"       CASE \n" + 
			"            WHEN f.is_same_state=0          THEN             SUM(d.igst_rs)          \n" + 
			"            ELSE            0         \n" + 
			"        END AS igst_rs,\n" + 
			"        CASE \n" + 
			"            WHEN f.is_same_state=0          THEN             0           \n" + 
			"            ELSE           SUM(d.cgst_rs)          \n" + 
			"        END AS cgst_rs,\n" + 
			"        CASE \n" + 
			"            WHEN f.is_same_state=0          THEN             0           \n" + 
			"            ELSE           SUM(d.sgst_rs)          \n" + 
			"        END AS sgst_rs,\n" + 
			"        SUM(d.grn_gvn_amt) as grand_total \n" + 
			"    from\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"         m_franchisee f\n" + 
			"    where\n" + 
			"        h.crn_id=d.crn_id \n" + 
			"        AND h.fr_id=:frId  \n" + 
			"        and d.del_status=0 \n" + 
			"        AND h.crn_date BETWEEN :fromDate AND :toDate \n" + 
			"        and f.fr_id=h.fr_id \n" + 
			"    group by\n" + 
			"        d.sgst_per+d.cgst_per",nativeQuery=true)
	List<BillWiseTaxReport> findBillWiseTaxReportGrn(@Param("frId")int frId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
