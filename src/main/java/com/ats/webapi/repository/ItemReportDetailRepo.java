package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemReportDetail;

public interface ItemReportDetailRepo extends JpaRepository<ItemReportDetail, Integer> {

	@Query(value = "   SELECT d.bill_detail_no, h.bill_date, d.item_id,d.bill_qty, d.order_qty, i.item_name, h.bill_no,h.invoice_no "
			+ "  FROM t_bill_header h, t_bill_detail d, m_item i WHERE h.del_status=0 AND d.del_status=0 AND i.id=d.item_id   AND d.cat_id!=5  "
			+ "AND h.bill_no=d.bill_no  AND h.bill_date BETWEEN :fromDate AND :toDate  AND d.item_id=:itemId AND h.fr_id=:frId"
			+ "", nativeQuery = true)

	List<ItemReportDetail> getItemReportByItemId(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemId") int itemId, @Param("frId") int frId);

	@Query(value = "   SELECT d.bill_detail_no, h.bill_date, d.item_id,d.bill_qty, d.order_qty, i.item_name, h.bill_no,h.invoice_no "
			+ "  FROM t_bill_header h, t_bill_detail d, m_item i WHERE h.del_status=0 AND d.del_status=0 AND i.id=d.item_id  AND d.cat_id!=5  "
			+ "AND h.bill_no=d.bill_no  AND h.bill_date BETWEEN :fromDate AND :toDate  AND d.item_id=:itemId "
			+ "", nativeQuery = true)

	List<ItemReportDetail> getItemReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("itemId") int itemId);

}
