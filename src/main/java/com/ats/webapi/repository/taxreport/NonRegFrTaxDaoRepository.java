package com.ats.webapi.repository.taxreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.taxreport.NonRegFrTaxDao;

@Repository
public interface NonRegFrTaxDaoRepository extends JpaRepository<NonRegFrTaxDao, String>{

	@Query(value="select UUID() as uid,f.fr_id,f.fr_name, \n" + 
			" a.tax_per,round(coalesce((SELECT SUM(t_bill_detail.taxable_amt) FROM t_bill_header,t_bill_detail WHERE t_bill_header.bill_date BETWEEN :fromDate and :toDate AND\n" + 
			"t_bill_header.fr_id=f.fr_id and t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+t_bill_detail.sgst_per=a.tax_per and t_bill_header.del_status=0 and t_bill_detail.del_status=0),0),2) AS bill_taxable_amt,round(coalesce((SELECT SUM(t_bill_detail.sgst_rs) FROM t_bill_header,t_bill_detail WHERE t_bill_header.bill_date BETWEEN :fromDate and :toDate AND\n" + 
			"t_bill_header.fr_id=f.fr_id and t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+t_bill_detail.sgst_per=a.tax_per and t_bill_header.del_status=0 and t_bill_detail.del_status=0),0),2) AS bill_sgst_amt,round(coalesce((SELECT SUM(t_bill_detail.cgst_rs) FROM t_bill_header,t_bill_detail WHERE t_bill_header.bill_date BETWEEN :fromDate and :toDate AND\n" + 
			"t_bill_header.fr_id=f.fr_id and t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+t_bill_detail.sgst_per=a.tax_per and t_bill_header.del_status=0 and t_bill_detail.del_status=0),0),2) AS bill_cgst_amt,0 as bill_igst_amt,round(coalesce((SELECT SUM(t_bill_detail.grand_total) FROM t_bill_header,t_bill_detail WHERE t_bill_header.bill_date BETWEEN :fromDate and :toDate AND\n" + 
			"t_bill_header.fr_id=f.fr_id and t_bill_header.bill_no=t_bill_detail.bill_no and t_bill_detail.cgst_per+t_bill_detail.sgst_per=a.tax_per and t_bill_header.del_status=0 and t_bill_detail.del_status=0),0),2) AS bill_grand_amt,\n" + 
			"round(coalesce((SELECT\n" + 
			"        SUM(t_credit_note_details.taxable_amt) \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id  and t_credit_note_header.fr_id=f.fr_id\n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate and :toDate\n" + 
			"        And t_credit_note_details.cgst_per+t_credit_note_details.sgst_per=a.tax_per and t_credit_note_details.del_status=0),0),2) AS crn_taxable_amt,\n" + 
			"round(coalesce((SELECT\n" + 
			"        SUM(t_credit_note_details.sgst_rs) \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id  and t_credit_note_header.fr_id=f.fr_id\n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate and :toDate\n" + 
			"        And t_credit_note_details.cgst_per+t_credit_note_details.sgst_per=a.tax_per and t_credit_note_details.del_status=0),0),2) AS crn_sgst_amt,\n" + 
			"round(coalesce((SELECT\n" + 
			"        SUM(t_credit_note_details.cgst_rs) \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id  and t_credit_note_header.fr_id=f.fr_id\n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate and :toDate\n" + 
			"        And t_credit_note_details.cgst_per+t_credit_note_details.sgst_per=a.tax_per and t_credit_note_details.del_status=0),0),2) AS crn_cgst_amt,0 as crn_igst_amt," + 
			"round(coalesce((SELECT\n" + 
			"        SUM(t_credit_note_details.grn_gvn_amt) \n" + 
			"    FROM\n" + 
			"        t_credit_note_header,\n" + 
			"        t_credit_note_details\n" + 
			"    WHERE\n" + 
			"        t_credit_note_header.crn_id=t_credit_note_details.crn_id  and t_credit_note_header.fr_id=f.fr_id\n" + 
			"        AND t_credit_note_header.crn_date BETWEEN :fromDate and :toDate\n" + 
			"        And t_credit_note_details.cgst_per+t_credit_note_details.sgst_per=a.tax_per and t_credit_note_details.del_status=0),0),2) AS crn_grand_amt\n" + 
			" from  (select 0 as tax_per from dual UNION  select 5 as tax_per from dual UNION select 12 as tax_per from dual UNION select 18 as tax_per from dual UNION select 28 as tax_per from dual)  a, m_franchisee f where f.del_status=0 and f.fr_gst_type=0 order by f.fr_id,a.tax_per",nativeQuery=true)
	List<NonRegFrTaxDao> getNonRegFrTaxReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}
