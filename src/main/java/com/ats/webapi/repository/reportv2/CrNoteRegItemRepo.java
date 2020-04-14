package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.CrNoteRegItem;

public interface CrNoteRegItemRepo extends JpaRepository<CrNoteRegItem, Integer> {

	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt"
			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id "
			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 and t_credit_note_details.del_status=0 and t_bill_header.del_status=0 "
			+ "	GROUP by t_credit_note_details.hsn_code,t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItem(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt"
			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id "
			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 AND m_franchisee.fr_id=:frId "
			+ "	GROUP by t_credit_note_details.hsn_code,t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt"
			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id"
			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 and t_credit_note_details.del_status=0 and t_bill_header.del_status=0 and t_credit_note_header.is_grn = :CreditNoteType"
			+ "	GROUP BY (t_credit_note_details.cgst_per+t_credit_note_details.sgst_per),t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemDone(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("CreditNoteType") String CreditNoteType);

	@Query(value = " SELECT t_credit_note_header.crn_id,t_credit_note_header.crn_date,t_bill_header.invoice_no,"
			+ " t_credit_note_details.crnd_id ,"
			+ " t_bill_header.bill_date,m_franchisee.fr_name,t_credit_note_header.crn_no as fr_code,m_franchisee.fr_gst_no,t_credit_note_details.hsn_code,"
			+ "	SUM(t_credit_note_details.grn_gvn_qty)crn_qty,SUM(t_credit_note_details.taxable_amt)crn_taxable,"
			+ " t_credit_note_details.cgst_per,t_credit_note_details.sgst_per,t_credit_note_details.igst_per,SUM(t_credit_note_details.sgst_rs) "
			+ " AS sgst_amt ,SUM(t_credit_note_details.cgst_rs) as cgst_amt,"
			+ " SUM(t_credit_note_details.igst_rs) as igst_amt,"
			+ "	SUM(t_credit_note_details.grn_gvn_amt) as crn_amt"
			+ "	FROM t_credit_note_header,t_credit_note_details,t_bill_header,m_franchisee"
			+ "	WHERE t_credit_note_header.crn_id=t_credit_note_details.crn_id AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate "
			+ "	AND t_credit_note_header.fr_id=m_franchisee.fr_id "
			+ "	AND t_bill_header.bill_no=t_credit_note_header.ex_int1 AND m_franchisee.fr_id=:frId  "
			+ "	GROUP BY (t_credit_note_details.cgst_per+t_credit_note_details.sgst_per),t_credit_note_details.crn_id  order by t_credit_note_header.crn_no", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemDoneByFrId(@Param("frId") int frId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
