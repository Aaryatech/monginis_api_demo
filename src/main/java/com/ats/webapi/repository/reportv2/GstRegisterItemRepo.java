package com.ats.webapi.repository.reportv2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.reportv2.GstRegisterItem;

public interface GstRegisterItemRepo extends JpaRepository<GstRegisterItem, Integer> {

	// for m -ite hsn code

	@Query(value = " select t_bill_detail.bill_detail_no, t_bill_header.invoice_no,"
			+ "	  t_bill_header.bill_date, t_bill_header.party_name as fr_name, t_bill_header.party_gstin as fr_gst_no,"
			+ "	  t_bill_detail.bill_no, t_bill_detail.cgst_per, t_bill_detail.sgst_per,"
			+ "	  t_bill_detail.cgst_per+sgst_per as tax_per,"
			+ "	  ROUND(SUM(t_bill_detail.taxable_amt), 2) as taxable_amt,"
			+ "	  ROUND(SUM(t_bill_detail.cgst_rs), 2) as cgst_amt,"
			+ "	  ROUND(SUM(t_bill_detail.sgst_rs), 2) as sgst_amt,"
			+ "	  ROUND(SUM(t_bill_detail.total_tax), 2) as total_tax,"
			+ "	  ROUND(SUM(t_bill_detail.grand_total), 2) as grand_total," + "	  "
			+ "	  ROUND(SUM(t_bill_detail.bill_qty), 2) as bill_qty, t_bill_detail.hsn_code as "
			+ "	  hsn_code from t_bill_detail, t_bill_header, m_franchisee,m_item"
			+ "	  where t_bill_header.bill_no=t_bill_detail.bill_no AND " + "	  m_item.id=t_bill_detail.item_id AND "
			+ "	  t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_detail.cat_id!=5 and "
			+ "	  m_franchisee.fr_id=t_bill_header.fr_id and t_bill_header.del_status=0 and t_bill_detail.del_status=0 GROUP BY t_bill_detail.bill_no,hsn_code   order by t_bill_header.invoice_no", nativeQuery = true)

	List<GstRegisterItem> getGstRegisterAllFrItem(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = " select t_bill_detail.bill_detail_no, t_bill_header.invoice_no,"
			+ "	  t_bill_header.bill_date, t_bill_header.party_name as fr_name, t_bill_header.party_gstin as fr_gst_no,"
			+ "	  t_bill_detail.bill_no, t_bill_detail.cgst_per, t_bill_detail.sgst_per,"
			+ "	  t_bill_detail.cgst_per+sgst_per as tax_per,"
			+ "	  ROUND(SUM(t_bill_detail.taxable_amt), 2) as taxable_amt,"
			+ "	  ROUND(SUM(t_bill_detail.cgst_rs), 2) as cgst_amt,"
			+ "	  ROUND(SUM(t_bill_detail.sgst_rs), 2) as sgst_amt,"
			+ "	  ROUND(SUM(t_bill_detail.total_tax), 2) as total_tax,"
			+ "	  ROUND(SUM(t_bill_detail.grand_total), 2) as grand_total," + "	  "
			+ "	  ROUND(SUM(t_bill_detail.bill_qty), 2) as bill_qty, t_bill_detail.hsn_code as "
			+ "	  hsn_code from t_bill_detail, t_bill_header, m_franchisee,m_item "
			+ "	  where t_bill_header.bill_no=t_bill_detail.bill_no AND "
			+ "	  m_item.id=t_bill_detail.item_id AND t_bill_detail.cat_id!=5 and "
			+ "	  t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND "
			+ "	  m_franchisee.fr_id=t_bill_header.fr_id AND m_franchisee.fr_id IN (:frIdList)  and t_bill_header.del_status=0 and t_bill_detail.del_status=0 "
			+ "   GROUP BY t_bill_detail.bill_no,hsn_code  order by t_bill_header.invoice_no", nativeQuery = true)

	List<GstRegisterItem> getGstRegisterSpecFrItem(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList);
	
	
	@Query(value = " SELECT\n" + 
			"    *\n" + 
			"FROM\n" + 
			"    (\n" + 
			"    SELECT\n" + 
			"        t1.*,\n" + 
			"        COALESCE(t2.taxable_amt, 0) + COALESCE(t3.taxable_amt, 0) AS taxable_amt,\n" + 
			"        COALESCE(t2.total_tax, 0) + COALESCE(t3.total_tax, 0) AS total_tax,\n" + 
			"        COALESCE(t2.cgst_amt, 0) + COALESCE(t3.cgst_amt, 0) AS cgst_amt,\n" + 
			"        COALESCE(t2.sgst_amt, 0) + COALESCE(t3.sgst_amt, 0) AS sgst_amt,\n" + 
			"        COALESCE(t2.grand_total, 0) + COALESCE(t3.grand_total, 0) AS grand_total,\n" + 
			"        COALESCE(t2.bill_qty, 0) + COALESCE(t3.bill_qty, 0) AS bill_qty\n" + 
			"    FROM\n" + 
			"        (\n" + 
			"        SELECT\n" + 
			"            d.bill_detail_no,\n" + 
			"            h.invoice_no,\n" + 
			"            h.bill_date,\n" + 
			"            h.party_name AS fr_name,\n" + 
			"            h.party_gstin AS fr_gst_no,\n" + 
			"            h.bill_no,\n" + 
			"            d.cgst_per,\n" + 
			"            d.sgst_per,\n" + 
			"            d.cgst_per + d.sgst_per AS tax_per,\n" + 
			"            d.hsn_code\n" + 
			"        FROM\n" + 
			"            t_bill_header h,\n" + 
			"            t_bill_detail d\n" + 
			"        WHERE\n" + 
			"            h.bill_no = d.bill_no AND h.del_status = 0 AND d.del_status = 0 AND h.bill_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIdList)\n" + 
			"        GROUP BY\n" + 
			"            h.bill_no,\n" + 
			"            d.hsn_code\n" + 
			"    ) t1\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.bill_detail_no,\n" + 
			"        h.bill_no,\n" + 
			"        ROUND(SUM(d.taxable_amt),\n" + 
			"        2) AS taxable_amt,\n" + 
			"        ROUND(SUM(d.cgst_rs),\n" + 
			"        2) AS cgst_amt,\n" + 
			"        ROUND(SUM(d.sgst_rs),\n" + 
			"        2) AS sgst_amt,\n" + 
			"        ROUND(SUM(d.total_tax),\n" + 
			"        2) AS total_tax,\n" + 
			"        ROUND(SUM(d.grand_total),\n" + 
			"        2) AS grand_total,\n" + 
			"        ROUND(SUM(d.bill_qty),\n" + 
			"        2) AS bill_qty,\n" + 
			"        d.hsn_code AS hsn_code\n" + 
			"    FROM\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d\n" + 
			"    WHERE\n" + 
			"        h.bill_no = d.bill_no AND h.del_status = 0 AND d.del_status = 0 AND h.bill_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIdList) AND d.cat_id != 5\n" + 
			"    GROUP BY\n" + 
			"        h.bill_no,\n" + 
			"        d.hsn_code\n" + 
			") t2\n" + 
			"ON\n" + 
			"    t1.bill_no = t2.bill_no AND t1.hsn_code = t2.hsn_code\n" + 
			"LEFT JOIN(\n" + 
			"    SELECT\n" + 
			"        d.bill_detail_no,\n" + 
			"        h.bill_no,\n" + 
			"        ROUND(SUM(d.taxable_amt),\n" + 
			"        2) AS taxable_amt,\n" + 
			"        ROUND(SUM(d.cgst_rs),\n" + 
			"        2) AS cgst_amt,\n" + 
			"        ROUND(SUM(d.sgst_rs),\n" + 
			"        2) AS sgst_amt,\n" + 
			"        ROUND(SUM(d.total_tax),\n" + 
			"        2) AS total_tax,\n" + 
			"        ROUND(SUM(d.grand_total),\n" + 
			"        2) AS grand_total,\n" + 
			"        ROUND(SUM(d.bill_qty),\n" + 
			"        2) AS bill_qty,\n" + 
			"        d.hsn_code AS hsn_code\n" + 
			"    FROM\n" + 
			"        t_bill_header h,\n" + 
			"        t_bill_detail d\n" + 
			"    WHERE\n" + 
			"        h.bill_no = d.bill_no AND h.del_status = 0 AND d.del_status = 0 AND h.bill_date BETWEEN :fromDate AND :toDate AND h.fr_id IN(:frIdList) AND d.cat_id = 5\n" + 
			"    GROUP BY\n" + 
			"        h.bill_no,\n" + 
			"        d.hsn_code\n" + 
			") t3\n" + 
			"ON\n" + 
			"    t1.bill_no = t3.bill_no AND t1.hsn_code = t3.hsn_code\n" + 
			") t\n" + 
			"ORDER BY\n" + 
			"    invoice_no", nativeQuery = true)

	List<GstRegisterItem> getGstRegisterNew(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList);

}
