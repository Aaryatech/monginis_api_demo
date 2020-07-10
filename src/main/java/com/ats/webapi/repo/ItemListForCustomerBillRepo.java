package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GrandTotalBillWise;
import com.ats.webapi.model.bill.ItemListForCustomerBill;

public interface ItemListForCustomerBillRepo extends JpaRepository<ItemListForCustomerBill, Integer> {

	@Query(value = "SELECT\n" + "    t_adv_order_detail.item_id,\n" + "    t_adv_order_detail.rate,\n"
			+ "    t_adv_order_detail.mrp AS orignal_mrp,\n" + "    t_adv_order_detail.qty,\n"
			+ "    m_item.item_name,\n"
			+ "    m_item.item_tax1 as tax_per,m_item.ext_int2 as is_decimal,m_item_sup.item_uom as uom, 0 as taxable_amt,0 as tax_amt,0 as total\n"
			+ "FROM\n" + "    t_adv_order_detail,\n" + "    m_item,m_item_sup " + "WHERE "
			+ "  m_item_sup.item_id=m_item.id and  t_adv_order_detail.adv_header_id =:advHeadId AND t_adv_order_detail.item_id = m_item.id AND t_adv_order_detail.del_status = 0", nativeQuery = true)
	List<ItemListForCustomerBill> getItem(@Param("advHeadId") int advHeadId);

	@Query(value = "SELECT d.item_id, d.mrp_base_rate as rate, d.mrp AS orignal_mrp, d.qty, i.item_name, i.item_tax1 as tax_per,0 as is_decimal,s.item_uom as uom, 0 as taxable_amt,0 as tax_amt,0 as total FROM t_sell_bill_detail d, m_item i,m_item_sup s WHERE s.item_id=i.id and d.sell_bill_no =:sellBillNo AND d.item_id = i.id AND d.del_status = 0 ", nativeQuery = true)
	List<ItemListForCustomerBill> getItemByBill(@Param("sellBillNo") int sellBillNo);

}
