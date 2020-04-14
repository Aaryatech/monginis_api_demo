package com.ats.webapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.pettycash.SellBillDetailAdv;


public interface SellBillDetailAdvRepo extends JpaRepository<SellBillDetailAdv, Integer> {

	@Query(value="select\n" + 
			"        UUID() as id,       \n" + 
			"        sum(coalesce((SELECT\n" + 
			"            COALESCE(SUM(t_sell_bill_detail.qty*m_item.item_mrp1),\n" + 
			"            0)     \n" + 
			"        FROM\n" + 
			"            t_sell_bill_detail,\n" + 
			"            m_item     \n" + 
			"        WHERE\n" + 
			"            t_sell_bill_detail.cat_id=m_category.cat_id \n" + 
			"            and t_sell_bill_detail.item_id=m_item.id         \n" + 
			"            AND t_sell_bill_detail.sell_bill_no IN (             SELECT\n" + 
			"                t_sell_bill_header.sell_bill_no              \n" + 
			"            FROM\n" + 
			"                t_sell_bill_header              \n" + 
			"            WHERE\n" + 
			"                t_sell_bill_header.fr_id=:frId                \n" + 
			"                AND t_sell_bill_header.bill_date=:date) ),0)) as sell_qty_mrp\n" + 
			"           \n" + 
			"    from\n" + 
			"        m_category \n" + 
			"    where\n" + 
			"        m_category.del_status=0 \n" + 
			"        and m_category.cat_id!=5 \n" + 
			"       ",nativeQuery=true)
	public SellBillDetailAdv getSellBillDetailAdv(@Param("frId") int frId, @Param("date") String date);
}
