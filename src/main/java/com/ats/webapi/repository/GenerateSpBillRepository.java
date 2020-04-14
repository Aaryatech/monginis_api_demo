package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GenerateSpBill;


public interface GenerateSpBillRepository extends JpaRepository<GenerateSpBill, Integer> {
	
    @Query(value="SELECT t_sp_cake.sp_order_no,coalesce((select sp_hsncd from  m_spcake_sup where m_spcake_sup.sp_id=m_sp_cake.sp_id and m_spcake_sup.del_status=0),'-') as hsn_code, coalesce((select disc_per from m_fr_discount where is_active=1 and category_id=5  and FIND_IN_SET(t_sp_cake.sp_id,item_id) and FIND_IN_SET(t_sp_cake.fr_id,franch_id) order by disc_id desc limit 1),0) as disc,t_sp_cake.fr_id, t_sp_cake.sp_id,t_sp_cake.menu_id, t_sp_cake.sp_backend_rate, t_sp_cake.sp_grand_total, t_sp_cake.fr_code,t_sp_cake.sp_delivery_date ,"
			+ " m_franchisee.fr_name, m_franchisee.is_same_state,m_franchisee.fr_rate_cat, m_fr_menu_show.menu_title,m_fr_menu_show.cat_id , m_sp_cake.sp_tax1, m_sp_cake.sp_tax2,m_sp_cake.sp_tax3, m_sp_cake.sp_name ,m_cat_sub.sub_cat_id,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin "
			+ "FROM t_sp_cake , m_franchisee , m_fr_menu_show , m_sp_cake,m_cat_sub WHERE t_sp_cake.fr_id IN (:frId) AND  t_sp_cake.menu_id IN (:menuId) AND  t_sp_cake.sp_delivery_date = :delDate "
			+ "AND m_franchisee.fr_id=t_sp_cake.fr_id AND m_fr_menu_show.menu_id=t_sp_cake.menu_id AND m_sp_cake.sp_id=t_sp_cake.sp_id AND m_cat_sub.cat_id=m_fr_menu_show.cat_id AND t_sp_cake.is_bill_generated IN(0,1) "
			+ "ORDER BY m_franchisee.fr_id,m_sp_cake.sp_name   ",nativeQuery=true)
	List<GenerateSpBill> generateSpBill(@Param("frId")List<String> frId,@Param("menuId")List<String> menuId,@Param("delDate")String delDate);
  
	
	
	@Query(value="SELECT t_sp_cake.sp_order_no,coalesce((select sp_hsncd from  m_spcake_sup where m_spcake_sup.sp_id=m_sp_cake.sp_id and m_spcake_sup.del_status=0),'-') as hsn_code,coalesce((select disc_per from m_fr_discount where is_active=1 and category_id=5  and FIND_IN_SET(t_sp_cake.sp_id,item_id) and FIND_IN_SET(t_sp_cake.fr_id,franch_id) order by disc_id desc limit 1),0) as disc,t_sp_cake.fr_id, t_sp_cake.sp_id,t_sp_cake.menu_id, t_sp_cake.sp_backend_rate, t_sp_cake.sp_grand_total, t_sp_cake.fr_code,t_sp_cake.sp_delivery_date ,"
			+ " m_franchisee.fr_name, m_franchisee.fr_rate_cat,m_franchisee.is_same_state, m_fr_menu_show.menu_title,m_fr_menu_show.cat_id , m_sp_cake.sp_tax1, m_sp_cake.sp_tax2,m_sp_cake.sp_tax3, m_sp_cake.sp_name ,m_cat_sub.sub_cat_id,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin "
			+ "FROM t_sp_cake , m_franchisee , m_fr_menu_show , m_sp_cake,m_cat_sub WHERE t_sp_cake.menu_id IN (:menuId) AND t_sp_cake.sp_delivery_date = :delDate "
			+ "AND m_franchisee.fr_id=t_sp_cake.fr_id AND m_fr_menu_show.menu_id=t_sp_cake.menu_id AND m_sp_cake.sp_id=t_sp_cake.sp_id AND m_cat_sub.cat_id=m_fr_menu_show.cat_id  AND t_sp_cake.is_bill_generated IN(0,1)  "
			+ "ORDER BY m_franchisee.fr_id,m_sp_cake.sp_name ",nativeQuery=true)
	List<GenerateSpBill> generateSpBillForAllFr(@Param("menuId")List<String> menuId,@Param("delDate")String delDate);

	
	
	@Query(value="SELECT t_sp_cake.sp_order_no,coalesce((select sp_hsncd from  m_spcake_sup where m_spcake_sup.sp_id=m_sp_cake.sp_id and m_spcake_sup.del_status=0),'-') as hsn_code,coalesce((select disc_per from m_fr_discount where is_active=1 and category_id=5  and FIND_IN_SET(t_sp_cake.sp_id,item_id) and FIND_IN_SET(t_sp_cake.fr_id,franch_id) order by disc_id desc limit 1),0) as disc,t_sp_cake.fr_id, t_sp_cake.sp_id,t_sp_cake.menu_id, t_sp_cake.sp_backend_rate, t_sp_cake.sp_grand_total, t_sp_cake.fr_code,t_sp_cake.sp_delivery_date ,"
			+ " m_franchisee.fr_name, m_franchisee.fr_rate_cat,m_franchisee.is_same_state, m_fr_menu_show.menu_title,m_fr_menu_show.cat_id , m_sp_cake.sp_tax1, m_sp_cake.sp_tax2,m_sp_cake.sp_tax3, m_sp_cake.sp_name ,m_cat_sub.sub_cat_id,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin "
			+ "FROM t_sp_cake , m_franchisee , m_fr_menu_show , m_sp_cake,m_cat_sub WHERE t_sp_cake.sp_delivery_date = :delDate "
			+ "AND m_franchisee.fr_id=t_sp_cake.fr_id AND m_fr_menu_show.menu_id=t_sp_cake.menu_id AND m_sp_cake.sp_id=t_sp_cake.sp_id AND m_cat_sub.cat_id=m_fr_menu_show.cat_id AND t_sp_cake.is_bill_generated IN(0,1)  "
			+ "ORDER BY m_franchisee.fr_id,m_sp_cake.sp_name  ",nativeQuery=true)
	List<GenerateSpBill> generateSpBillForAllFrAllMenu(@Param("delDate")String delDate);

	
	
	@Query(value="SELECT t_sp_cake.sp_order_no,coalesce((select sp_hsncd from  m_spcake_sup where m_spcake_sup.sp_id=m_sp_cake.sp_id and m_spcake_sup.del_status=0),'-') as hsn_code,coalesce((select disc_per from m_fr_discount where is_active=1 and category_id=5  and FIND_IN_SET(t_sp_cake.sp_id,item_id) and FIND_IN_SET(t_sp_cake.fr_id,franch_id) order by disc_id desc limit 1),0) as disc,t_sp_cake.fr_id, t_sp_cake.sp_id,t_sp_cake.menu_id, t_sp_cake.sp_backend_rate, t_sp_cake.sp_grand_total, t_sp_cake.fr_code,t_sp_cake.sp_delivery_date ,"
			+ " m_franchisee.fr_name, m_franchisee.fr_rate_cat, m_franchisee.is_same_state, m_fr_menu_show.menu_title,m_fr_menu_show.cat_id , m_sp_cake.sp_tax1, m_sp_cake.sp_tax2,m_sp_cake.sp_tax3, m_sp_cake.sp_name ,m_cat_sub.sub_cat_id,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin "
			+ "FROM t_sp_cake , m_franchisee , m_fr_menu_show , m_sp_cake,m_cat_sub WHERE t_sp_cake.fr_id IN (:frId) AND t_sp_cake.sp_delivery_date = :delDate "
			+ "AND m_franchisee.fr_id=t_sp_cake.fr_id AND m_fr_menu_show.menu_id=t_sp_cake.menu_id AND m_sp_cake.sp_id=t_sp_cake.sp_id AND m_cat_sub.cat_id=m_fr_menu_show.cat_id AND t_sp_cake.is_bill_generated IN(0,1)  "
			+ "ORDER BY m_franchisee.fr_id,m_sp_cake.sp_name ",nativeQuery=true)
	List<GenerateSpBill> generateSpBillForAllMenu(@Param("frId")List<String> frId,@Param("delDate")String delDate);

	
	
	
	
	
}
