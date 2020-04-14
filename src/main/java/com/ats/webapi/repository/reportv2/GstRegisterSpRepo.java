package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.GstRegisterSp;

public interface GstRegisterSpRepo extends JpaRepository<GstRegisterSp, Integer> {
	
	//for Sp Cake hsn code
	
		@Query(value = " select t_bill_header.invoice_no, t_bill_detail.bill_detail_no," + 
				"	  t_bill_header.bill_date, t_bill_header.party_name as fr_name, t_bill_header.party_gstin as fr_gst_no," + 
				"	  t_bill_detail.bill_no, t_bill_detail.cgst_per, t_bill_detail.sgst_per," + 
				"	  t_bill_detail.cgst_per+sgst_per as tax_per," + 
				"	  ROUND(SUM(t_bill_detail.taxable_amt), 2) as taxable_amt," + 
				"	  ROUND(SUM(t_bill_detail.cgst_rs), 2) as cgst_amt," + 
				"	  ROUND(SUM(t_bill_detail.sgst_rs), 2) as sgst_amt," + 
				"	  ROUND(SUM(t_bill_detail.total_tax), 2) as total_tax," + 
				"	  ROUND(SUM(t_bill_detail.grand_total), 2) as grand_total," + 
				"	  " + 
				"	  ROUND(SUM(t_bill_detail.bill_qty), 2) as bill_qty, t_bill_detail.hsn_code from t_bill_detail, t_bill_header," + 
				"	  m_franchisee,m_sp_cake where " + 
				"	  t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_detail.cat_id=5 and " + 
				"	  m_sp_cake.sp_id=t_bill_detail.item_id " + 
				"	  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND " + 
				"	  m_franchisee.fr_id=t_bill_header.fr_id and t_bill_header.del_status=0 and t_bill_detail.del_status=0 GROUP BY  t_bill_detail.bill_no,t_bill_detail.hsn_code  order by t_bill_header.invoice_no", nativeQuery = true)

		List<GstRegisterSp> getGstRegisterAllFrSp(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

		@Query(value = " select  t_bill_header.invoice_no ,t_bill_detail.bill_detail_no," + 
				"	  t_bill_header.bill_date,  t_bill_header.party_name as fr_name,  t_bill_header.party_gstin as fr_gst_no," + 
				"	  t_bill_detail.bill_no, t_bill_detail.cgst_per, t_bill_detail.sgst_per," + 
				"	  t_bill_detail.cgst_per+sgst_per as tax_per," + 
				"	  ROUND(SUM(t_bill_detail.taxable_amt), 2) as taxable_amt," + 
				"	  ROUND(SUM(t_bill_detail.cgst_rs), 2) as cgst_amt," + 
				"	  ROUND(SUM(t_bill_detail.sgst_rs), 2) as sgst_amt," + 
				"	  ROUND(SUM(t_bill_detail.total_tax), 2) as total_tax," + 
				"	  ROUND(SUM(t_bill_detail.grand_total), 2) as grand_total," + 
				"	  " + 
				"	  ROUND(SUM(t_bill_detail.bill_qty), 2) as bill_qty, t_bill_detail.hsn_code from t_bill_detail, t_bill_header," + 
				"	  m_franchisee,m_sp_cake where " + 
				"	  t_bill_header.bill_no=t_bill_detail.bill_no AND t_bill_detail.cat_id=5 and  " + 
				"	  m_sp_cake.sp_id=t_bill_detail.item_id   " + 
				"	  AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND " + 
				"	  m_franchisee.fr_id=t_bill_header.fr_id AND m_franchisee.fr_id IN (:frIdList) and t_bill_header.del_status=0 and t_bill_detail.del_status=0 "
				+ "   GROUP BY   t_bill_detail.bill_no,t_bill_detail.hsn_code  order by t_bill_header.invoice_no", nativeQuery = true)

		List<GstRegisterSp> getGstRegisterSpecFrSp(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
				 @Param("frIdList") List<Integer> frIdList);

	

}
