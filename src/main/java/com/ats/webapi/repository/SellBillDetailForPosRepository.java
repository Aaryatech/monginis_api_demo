package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SellBillDetailForPos;

public interface SellBillDetailForPosRepository extends JpaRepository<SellBillDetailForPos, Integer>{

	@Query(value="select sd.*,i.item_name,sp.item_uom,0 as is_decimal,sp.item_hsncd,c.cat_name from t_sell_bill_detail sd, m_item i,m_item_sup sp,m_category c "
			+ "where sell_bill_no=:billId and sd.item_id=i.id and sp.item_id=i.id and c.cat_id=sd.cat_id and sd.del_status=0",nativeQuery=true)
	List<SellBillDetailForPos> getSellBillDetailForPos(@Param("billId") int billId);

	@Query(value="select sd.*,i.item_name,sp.item_uom,0 as is_decimal,sp.item_hsncd,c.cat_name from t_sell_bill_detail sd, m_item i,m_item_sup sp,m_category c "
			+ "where sell_bill_detail_no IN (:billDetailNoList) and sd.item_id=i.id and sp.item_id=i.id and c.cat_id=sd.cat_id and sd.del_status=0",nativeQuery=true)
	List<SellBillDetailForPos> getSellBillDetailForPosDetail(@Param("billDetailNoList")List<Integer> billDetailNoList);

}
