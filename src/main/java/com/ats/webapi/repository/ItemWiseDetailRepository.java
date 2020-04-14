package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ItemWiseDetail;

@Repository
public interface ItemWiseDetailRepository extends JpaRepository<ItemWiseDetail, Long>{

	@Query(value="SELECT t_bill_detail.bill_detail_no, t_bill_header.invoice_no as bill_no ,t_bill_header.bill_date, t_bill_detail.item_id ,  m_item.item_name ,t_bill_detail.rate,COALESCE(SUM(bill_qty),0) AS qty, COALESCE(SUM(t_bill_detail.grand_total),0) AS total ,t_bill_detail.grn_type,t_bill_detail.expiry_date FROM t_bill_detail , m_item, t_bill_header WHERE  m_item.id= t_bill_detail.item_id AND t_bill_detail.bill_no IN(SELECT bill_no FROM t_bill_header WHERE bill_date BETWEEN :fromDate AND :toDate AND fr_id=:frId) AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_detail.cat_id=:catId and t_bill_header.del_status=0 and t_bill_detail.del_status=0 GROUP BY t_bill_detail.item_id, t_bill_detail.bill_no",nativeQuery=true)
	List<ItemWiseDetail> findItemWiseDetailReport(@Param("frId")int frId,@Param("catId")int catId,@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	@Query(value="SELECT t_bill_detail.bill_detail_no, t_bill_header.invoice_no as bill_no ,t_bill_header.bill_date, t_bill_detail.item_id ,  m_sp_cake.sp_name AS item_name ,t_bill_detail.rate,COALESCE(SUM(bill_qty),0) AS qty, COALESCE(SUM(t_bill_detail.grand_total),0) AS total ,t_bill_detail.grn_type,t_bill_detail.expiry_date FROM t_bill_detail , m_sp_cake, t_bill_header WHERE  m_sp_cake.sp_id= t_bill_detail.item_id AND t_bill_detail.bill_no IN(SELECT bill_no FROM t_bill_header WHERE bill_date BETWEEN :fromDate AND :toDate AND fr_id=:frId) AND t_bill_detail.bill_no=t_bill_header.bill_no AND t_bill_detail.cat_id=:catId and t_bill_header.del_status=0 and t_bill_detail.del_status=0 GROUP BY t_bill_detail.item_id, t_bill_detail.bill_no",nativeQuery=true)
	List<ItemWiseDetail> findSpecialCakeWiseDetailReport(@Param("frId")int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"        t_bill_detail.bill_detail_no,\n" + 
			"        t_bill_header.invoice_no as bill_no ,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_detail.item_id ,\n" + 
			"        m_item.item_name ,\n" + 
			"        t_bill_detail.rate,\n" + 
			"        COALESCE(SUM(bill_qty),\n" + 
			"        0) AS qty,\n" + 
			"        COALESCE(SUM(t_bill_detail.grand_total),\n" + 
			"        0) AS total ,\n" + 
			"        t_bill_detail.grn_type,t_bill_detail.expiry_date \n" + 
			"    FROM\n" + 
			"        t_bill_detail ,\n" + 
			"        m_item,\n" + 
			"        t_bill_header \n" + 
			"    WHERE\n" + 
			"        m_item.id= t_bill_detail.item_id \n" + 
			"        AND t_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                bill_no \n" + 
			"            FROM\n" + 
			"                t_bill_header \n" + 
			"            WHERE\n" + 
			"                bill_date BETWEEN :fromDate AND :toDate\n" + 
			"                AND fr_id=:frId\n" + 
			"        ) \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no  \n" + 
			"        AND t_bill_detail.item_id in (:itemIds) \n" + 
			"        and t_bill_header.del_status=0 \n" + 
			"        and t_bill_detail.del_status=0 \n" + 
			"    GROUP BY\n" + 
			"        t_bill_detail.item_id,\n" + 
			"        t_bill_detail.bill_no",nativeQuery=true)
	List<ItemWiseDetail> getItemWiseDetailReportByItemIds(@Param("frId")int frId,@Param("itemIds") List<Integer> itemIds,@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value=" SELECT\n" + 
			"        t_bill_detail.bill_detail_no,\n" + 
			"        t_bill_header.invoice_no as bill_no ,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_detail.item_id ,\n" + 
			"        m_sp_cake.sp_name as item_name ,\n" + 
			"        t_bill_detail.rate,\n" + 
			"        COALESCE(SUM(bill_qty),\n" + 
			"        0) AS qty,\n" + 
			"        COALESCE(SUM(t_bill_detail.grand_total),\n" + 
			"        0) AS total ,\n" + 
			"        t_bill_detail.grn_type,t_bill_detail.expiry_date      \n" + 
			"    FROM\n" + 
			"        t_bill_detail ,\n" + 
			"        m_sp_cake,\n" + 
			"        t_bill_header      \n" + 
			"    WHERE\n" + 
			"        m_sp_cake.sp_id= t_bill_detail.item_id          \n" + 
			"        AND t_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                bill_no              \n" + 
			"            FROM\n" + 
			"                t_bill_header              \n" + 
			"            WHERE\n" + 
			"                bill_date BETWEEN  :fromDate AND :toDate                  \n" + 
			"                AND fr_id=:frId         \n" + 
			"        )          \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no    and t_bill_detail.cat_id=:catId      \n" + 
			"        AND t_bill_detail.item_id in (\n" + 
			"          :itemIds \n" + 
			"        )          \n" + 
			"        and t_bill_header.del_status=0          \n" + 
			"        and t_bill_detail.del_status=0      \n" + 
			"    GROUP BY\n" + 
			"        t_bill_detail.item_id,\n" + 
			"        t_bill_detail.bill_no",nativeQuery=true)
	List<ItemWiseDetail> findSpecialCakeWiseDetailReportByItemIds(@Param("frId")int frId,@Param("catId")int catId,@Param("itemIds") List<Integer> itemIds,@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query(value="SELECT\n" + 
			"        t_bill_detail.bill_detail_no,\n" + 
			"        t_bill_header.invoice_no as bill_no ,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_detail.item_id ,\n" + 
			"        m_item.item_name ,\n" + 
			"        t_bill_detail.rate,\n" + 
			"        COALESCE(SUM(bill_qty),\n" + 
			"        0) AS qty,\n" + 
			"        COALESCE(SUM(t_bill_detail.grand_total),\n" + 
			"        0) AS total ,\n" + 
			"        t_bill_detail.grn_type,\n" + 
			"        t_bill_detail.expiry_date \n" + 
			"    FROM\n" + 
			"        t_bill_detail ,\n" + 
			"        m_item,\n" + 
			"        t_bill_header \n" + 
			"    WHERE\n" + 
			"        m_item.id= t_bill_detail.item_id \n" + 
			"        AND t_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                bill_no \n" + 
			"            FROM\n" + 
			"                t_bill_header \n" + 
			"            WHERE\n" + 
			"                bill_date BETWEEN :fromDate AND :toDate \n" + 
			"                AND fr_id=:frId\n" + 
			"        ) \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no \n" + 
			"        AND m_item.item_grp2=:catId \n" + 
			"        and t_bill_header.del_status=0 \n" + 
			"        and t_bill_detail.del_status=0 \n" + 
			"    GROUP BY\n" + 
			"        t_bill_detail.item_id,\n" + 
			"        t_bill_detail.bill_no",nativeQuery=true)
	List<ItemWiseDetail> findItemWiseDetailReportsubCatwise(@Param("frId")int frId,@Param("catId") int catId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
}
