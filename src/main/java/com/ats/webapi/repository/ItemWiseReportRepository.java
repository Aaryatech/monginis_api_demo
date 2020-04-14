package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ItemWiseReport;

@Repository
public interface ItemWiseReportRepository extends JpaRepository<ItemWiseReport, Long>{
	
	@Query(value="SELECT t_bill_detail.bill_detail_no, t_bill_detail.item_id ,'-' as grn_type,  m_sp_cake.sp_name as item_name ,t_bill_detail.rate,COALESCE(SUM(bill_qty),0) AS qty, COALESCE(SUM(t_bill_detail.grand_total),0) AS total  FROM t_bill_detail , m_sp_cake, t_bill_header WHERE  m_sp_cake.sp_id= t_bill_detail.item_id AND t_bill_detail.bill_no IN(SELECT bill_no FROM t_bill_header WHERE bill_date BETWEEN :fromDate AND :toDate AND fr_id=:frId) AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_detail.cat_id=:catId and t_bill_header.del_status=0 and t_bill_detail.del_status=0 GROUP BY t_bill_detail.item_id order by item_name",nativeQuery=true)
	List<ItemWiseReport> findSpecialCakeWiseReport(@Param("frId")int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	@Query(value="SELECT t_bill_detail.bill_detail_no, t_bill_detail.item_id ,'-' as grn_type,  m_item.item_name ,t_bill_detail.rate,COALESCE(SUM(bill_qty),0) AS qty, COALESCE(SUM(t_bill_detail.grand_total),0) AS total  FROM t_bill_detail , m_item, t_bill_header WHERE  m_item.id= t_bill_detail.item_id AND t_bill_detail.bill_no IN(SELECT bill_no FROM t_bill_header WHERE bill_date BETWEEN  :fromDate AND :toDate  AND fr_id=:frId) AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_detail.cat_id=:catId  and t_bill_header.del_status=0 and t_bill_detail.del_status=0 GROUP BY t_bill_detail.item_id order by m_item.item_grp1,m_item.item_grp2,m_item.item_name",nativeQuery=true)
	List<ItemWiseReport> findItemWiseReport(@Param("frId")int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"        t_credit_note_details.crnd_id as bill_detail_no,\n" + 
			"        t_credit_note_details.item_id ,\n" + 
			"        m_item.item_name ,\n" + 
			"        ((t_credit_note_details.igst_per/100)*t_credit_note_details.base_rate)+t_credit_note_details.base_rate as rate,\n" + 
			"        COALESCE(SUM(t_credit_note_details.grn_gvn_qty),\n" + 
			"        0) AS qty,\n" + 
			"        COALESCE(SUM(t_credit_note_details.grn_gvn_amt),\n" + 
			"        0) AS total,case when grn_type=0 then 'GRN 1'\n" + 
			"        when grn_type=1 then 'GRN 2'\n" + 
			"        when grn_type=2 then 'GRN 3'\n" + 
			"        else '-'\n" + 
			"        end as grn_type  \n" + 
			"    FROM\n" + 
			"        t_credit_note_details ,\n" + 
			"        m_item,\n" + 
			"        t_credit_note_header \n" + 
			"    WHERE\n" + 
			"        m_item.id= t_credit_note_details.item_id \n" + 
			"        AND t_credit_note_details.crn_id IN(\n" + 
			"            SELECT\n" + 
			"                crn_id \n" + 
			"            FROM\n" + 
			"                t_credit_note_header \n" + 
			"            WHERE\n" + 
			"                crn_date BETWEEN  :fromDate AND :toDate  \n" + 
			"                AND fr_id=:frId\n" + 
			"        ) \n" + 
			"        AND t_credit_note_details.crn_id=t_credit_note_header.crn_id \n" + 
			"        AND m_item.item_grp1=:catId   \n" + 
			"        and t_credit_note_details.del_status=0 \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_details.item_id order by m_item.item_grp1,m_item.item_grp2,m_item.item_name",nativeQuery=true)
	List<ItemWiseReport> findItemWiseReportGrn(@Param("frId")int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"        t_credit_note_details.crnd_id as bill_detail_no,\n" + 
			"        t_credit_note_details.item_id ,\n" + 
			"        m_sp_cake.sp_name as item_name ,\n" + 
			"        0 as rate,\n" + 
			"        COALESCE(SUM(t_credit_note_details.grn_gvn_qty),\n" + 
			"        0) AS qty,\n" + 
			"        COALESCE(SUM(t_credit_note_details.grn_gvn_amt),\n" + 
			"        0) AS total,case when grn_type=0 then 'GRN 1'\n" + 
			"        when grn_type=1 then 'GRN 2'\n" + 
			"        when grn_type=2 then 'GRN 3'\n" + 
			"        else '-'\n" + 
			"        end as grn_type  \n" + 
			"    FROM\n" + 
			"        t_credit_note_details ,\n" + 
			"        m_sp_cake,\n" + 
			"        t_credit_note_header \n" + 
			"    WHERE\n" + 
			"       m_sp_cake.sp_id= t_credit_note_details.item_id \n" + 
			"        AND t_credit_note_details.crn_id IN(\n" + 
			"            SELECT\n" + 
			"                crn_id \n" + 
			"            FROM\n" + 
			"                t_credit_note_header \n" + 
			"            WHERE\n" + 
			"                crn_date BETWEEN  :fromDate AND :toDate  \n" + 
			"                AND fr_id=:frId\n" + 
			"        ) \n" + 
			"        AND t_credit_note_details.crn_id=t_credit_note_header.crn_id  and t_credit_note_details.cat_id=5 \n" + 
			"        and t_credit_note_details.del_status=0 \n" + 
			"    GROUP BY\n" + 
			"        t_credit_note_details.item_id  order by item_name ",nativeQuery=true)
	List<ItemWiseReport> findSpecialCakeWiseReportGrn(@Param("frId")int frId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
