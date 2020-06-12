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
	
	
	
	
	@Query(value = " SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        t1.*,\n" + 
			"        COALESCE(t2.crn_qty, 0) + COALESCE(t3.crn_qty, 0) AS crn_qty,\n" + 
			"        COALESCE(t2.crn_taxable, 0) + COALESCE(t3.crn_taxable, 0) AS crn_taxable,\n" + 
			"        COALESCE(t2.cgst_per, 0) + COALESCE(t3.cgst_per, 0) AS cgst_per,\n" + 
			"        COALESCE(t2.sgst_per, 0) + COALESCE(t3.sgst_per, 0) AS sgst_per,\n" + 
			"        COALESCE(t2.igst_per, 0) + COALESCE(t3.igst_per, 0) AS igst_per,\n" + 
			"        COALESCE(t2.cgst_amt, 0) + COALESCE(t3.cgst_amt, 0) AS cgst_amt,\n" + 
			"        COALESCE(t2.sgst_amt, 0) + COALESCE(t3.sgst_amt, 0) AS sgst_amt,\n" + 
			"        COALESCE(t2.igst_amt, 0) + COALESCE(t3.igst_amt, 0) AS igst_amt,\n" + 
			"        COALESCE(t2.crn_amt, 0) + COALESCE(t3.crn_amt, 0) AS crn_amt\n" + 
			"    FROM\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            h.crn_id,\n" + 
			"            h.crn_date,\n" + 
			"            bh.invoice_no,\n" + 
			"            d.crnd_id,\n" + 
			"            bh.bill_date,\n" + 
			"            f.fr_name,\n" + 
			"            h.crn_no AS fr_code,\n" + 
			"            f.fr_gst_no,\n" + 
			"            d.hsn_code\n" + 
			"        FROM\n" + 
			"            t_credit_note_header h,\n" + 
			"            t_credit_note_details d,\n" + 
			"            t_bill_header bh,\n" + 
			"            m_franchisee f\n" + 
			"        WHERE\n" + 
			"            h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND h.fr_id = f.fr_id AND bh.bill_no = h.ex_int1 AND d.del_status = 0 AND bh.del_status = 0 AND f.del_status = 0\n" + 
			"        GROUP BY\n" + 
			"            h.crn_id,\n" + 
			"            d.hsn_code\n" + 
			"        ORDER BY\n" + 
			"            h.crn_no\n" + 
			"    ) t1\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        h.crn_id,\n" + 
			"        d.hsn_code,\n" + 
			"        SUM(d.grn_gvn_qty) crn_qty,\n" + 
			"        SUM(d.taxable_amt) crn_taxable,\n" + 
			"        d.cgst_per,\n" + 
			"        d.sgst_per,\n" + 
			"        d.igst_per,\n" + 
			"        SUM(d.sgst_rs) AS sgst_amt,\n" + 
			"        SUM(d.cgst_rs) AS cgst_amt,\n" + 
			"        SUM(d.igst_rs) AS igst_amt,\n" + 
			"        SUM(d.grn_gvn_amt) AS crn_amt\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        t_bill_header bh,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND h.fr_id = f.fr_id AND bh.bill_no = h.ex_int1 AND d.del_status = 0 AND bh.del_status = 0 AND d.cat_id != 5\n" + 
			"    GROUP BY\n" + 
			"        d.hsn_code,\n" + 
			"        d.crn_id\n" + 
			") t2\n" + 
			"ON\n" + 
			"    t1.crn_id = t2.crn_id AND t1.hsn_code = t2.hsn_code\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        h.crn_id,\n" + 
			"        d.hsn_code,\n" + 
			"        SUM(d.grn_gvn_qty) crn_qty,\n" + 
			"        SUM(d.taxable_amt) crn_taxable,\n" + 
			"        d.cgst_per,\n" + 
			"        d.sgst_per,\n" + 
			"        d.igst_per,\n" + 
			"        SUM(d.sgst_rs) AS sgst_amt,\n" + 
			"        SUM(d.cgst_rs) AS cgst_amt,\n" + 
			"        SUM(d.igst_rs) AS igst_amt,\n" + 
			"        SUM(d.grn_gvn_amt) AS crn_amt\n" + 
			"    FROM\n" + 
			"        t_credit_note_header h,\n" + 
			"        t_credit_note_details d,\n" + 
			"        t_bill_header bh,\n" + 
			"        m_franchisee f\n" + 
			"    WHERE\n" + 
			"        h.crn_id = d.crn_id AND h.crn_date BETWEEN :fromDate AND :toDate AND h.fr_id = f.fr_id AND bh.bill_no = h.ex_int1 AND d.del_status = 0 AND bh.del_status = 0 AND d.cat_id = 5\n" + 
			"    GROUP BY\n" + 
			"        d.hsn_code,\n" + 
			"        d.crn_id\n" + 
			") t3\n" + 
			"ON\n" + 
			"    t1.crn_id = t3.crn_id AND t1.hsn_code = t3.hsn_code\n" + 
			") t\n" + 
			"ORDER BY\n" + 
			"    fr_code", nativeQuery = true)

	List<CrNoteRegItem> getCrNoteRegItemNew(@Param("fromDate") String fromDate, @Param("toDate") String toDate);
	

}
