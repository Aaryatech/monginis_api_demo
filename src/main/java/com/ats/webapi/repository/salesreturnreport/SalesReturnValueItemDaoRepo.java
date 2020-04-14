package com.ats.webapi.repository.salesreturnreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesvaluereport.SalesReturnValueDao;
import com.ats.webapi.model.salesvaluereport.SalesReturnValueItemDao;

public interface SalesReturnValueItemDaoRepo extends JpaRepository<SalesReturnValueItemDao, Integer> {

	@Query(value = "select\n" + "        CONCAT(:month,\n" + "        \"\",\n" + "        id) as id,\n"
			+ "        id as item_id,\n" + "        coalesce((SELECT\n"
			+ "            SUM(t_bill_detail.grand_total) as grand_total  \n" + "        FROM\n"
			+ "            t_bill_detail,\n" + "            t_bill_header\n" + "        WHERE\n"
			+ "            DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month\n"
			+ "            AND t_bill_header.del_status=0\n"
			+ "            And t_bill_header.bill_no=t_bill_detail.bill_no\n"
			+ "            and t_bill_detail.cat_id!=5\n" + "            and m_item.id=t_bill_detail.item_id),\n"
			+ "        0) as grand_total,\n" + "        coalesce((select\n"
			+ "            SUM(grn_gvn_amt) as grn_qty\n" + "        from\n" + "            t_credit_note_header,\n"
			+ "            t_credit_note_details\n" + "           \n" + "        where\n"
			+ "            t_credit_note_header.crn_id=t_credit_note_details.crn_id\n"
			+ "            and t_credit_note_header.is_grn=1\n"
			+ "            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month\n"
			+ "            and t_credit_note_details.cat_id!=5\n"
			+ "            and m_item.id=t_credit_note_details.item_id\n" + "            ),\n"
			+ "        0) as grn_qty,\n" + "        coalesce((select\n" + "            SUM(grn_gvn_amt) as gvn_qty\n"
			+ "        from\n" + "            t_credit_note_header,\n" + "            t_credit_note_details\n"
			+ "           \n" + "        where\n"
			+ "            t_credit_note_header.crn_id=t_credit_note_details.crn_id  \n"
			+ "            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month\n"
			+ "            and t_credit_note_header.is_grn=0\n" + "            and t_credit_note_details.cat_id!=5\n"
			+ "            and m_item.id=t_credit_note_details.item_id\n" + "            ),\n"
			+ "        0) as gvn_qty  \n" + "    from\n" + "        m_item\n" + "    where\n"
			+ "        m_item.item_grp2 IN (:subCatId)\n" + "        and m_item.del_status=0  ", nativeQuery = true)
	List<SalesReturnValueItemDao> getSalesReturnValueItemReport1(@Param("month") String month,
			@Param("subCatId") List<Integer> subCatId);

	@Query(value = "select  CONCAT(:month,\"\",sp_id) as id,\n" + 
			"        sp_id as item_id,\n" + 
			"        coalesce((SELECT SUM(t_bill_detail.grand_total) as grand_total FROM t_bill_detail,t_bill_header WHERE\n" + 
			"			            DATE_FORMAT(t_bill_header.bill_date,'%Y-%m')=:month" + 
			"			            AND t_bill_header.del_status=0" + 
			"			            And t_bill_header.bill_no=t_bill_detail.bill_no" + 
			"			            and t_bill_detail.cat_id=5 and m_sp_cake.sp_id=t_bill_detail.item_id),\n" + 
			"			        0) as grand_total," + 
			"         coalesce((select SUM(grn_gvn_amt) as grn_qty from t_credit_note_header, t_credit_note_details where\n" + 
			"			            t_credit_note_header.crn_id=t_credit_note_details.crn_id" + 
			"			            and t_credit_note_header.is_grn=1" + 
			"			            and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month" + 
			"			            and t_credit_note_details.cat_id=5" + 
			"			            and m_sp_cake.sp_id=t_credit_note_details.item_id)," + 
			"			        0) as grn_qty," + 
			"         coalesce((select  SUM(grn_gvn_amt) as gvn_qty" + 
			"	 from  t_credit_note_header,t_credit_note_details where" + 
			"	 t_credit_note_header.crn_id=t_credit_note_details.crn_id " + 
			"	 and DATE_FORMAT(t_credit_note_header.crn_date,'%Y-%m')=:month" + 
			"	 and t_credit_note_header.is_grn=0  and t_credit_note_details.cat_id=5" + 
			"	 and m_sp_cake.sp_id=t_credit_note_details.item_id ),0) as gvn_qty" + 
			" from m_sp_cake where\n" + 
			"	  m_sp_cake.del_status=0", nativeQuery = true)
	List<SalesReturnValueItemDao> getSalesReturnValueSpReport1(@Param("month") String month);

}
