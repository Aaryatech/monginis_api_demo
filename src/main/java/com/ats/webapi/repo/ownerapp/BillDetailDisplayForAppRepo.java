package com.ats.webapi.repo.ownerapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ownerapp.BillDetailDisplayForApp;

public interface BillDetailDisplayForAppRepo extends JpaRepository<BillDetailDisplayForApp, Integer> {
	
	@Query(value="SELECT\r\n" + 
			"    d.*,\r\n" + 
			"    c.cat_name,\r\n" + 
			"    CASE WHEN d.menu_id NOT IN(\r\n" + 
			"    SELECT\r\n" + 
			"        menu_id\r\n" + 
			"    FROM\r\n" + 
			"        m_fr_menu_show\r\n" + 
			"    WHERE\r\n" + 
			"        del_status = 0 AND cat_id = 5 AND is_same_day_applicable = 4\r\n" + 
			") THEN CASE WHEN d.cat_id = 5 THEN(\r\n" + 
			"    SELECT\r\n" + 
			"        CONCAT(\r\n" + 
			"            m_sp_cake.sp_name,\r\n" + 
			"            '-',\r\n" + 
			"            m_sp_cake.sp_code\r\n" + 
			"        )\r\n" + 
			"    FROM\r\n" + 
			"        m_sp_cake\r\n" + 
			"    WHERE\r\n" + 
			"        m_sp_cake.sp_id = d.item_id\r\n" + 
			") ELSE(\r\n" + 
			"    SELECT\r\n" + 
			"        m_item.item_name\r\n" + 
			"    FROM\r\n" + 
			"        m_item\r\n" + 
			"    WHERE\r\n" + 
			"        d.item_id = m_item.id\r\n" + 
			")\r\n" + 
			"END ELSE(\r\n" + 
			"    SELECT\r\n" + 
			"        SUBSTRING_INDEX(t_sp_cake.item_id, '#', -1)\r\n" + 
			"    FROM\r\n" + 
			"        t_sp_cake\r\n" + 
			"    WHERE\r\n" + 
			"        sp_order_no = d.order_id AND d.cat_id = 5\r\n" + 
			")\r\n" + 
			"END AS item_name\r\n" + 
			"FROM\r\n" + 
			"    t_bill_header h,\r\n" + 
			"    t_bill_detail d,\r\n" + 
			"    m_category c\r\n" + 
			"WHERE\r\n" + 
			"    h.del_status = 0 AND h.bill_no = d.bill_no AND d.cat_id = c.cat_id AND h.fr_id IN(:frIds) AND h.bill_date BETWEEN :fromDate AND :toDate ",nativeQuery=true)
	List<BillDetailDisplayForApp> getBillDetailByDateAndFr(@Param ("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frIds") ArrayList<Integer> frIds);


}
