package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GenerateRegSpBill;


public interface GenerateRegSpBillRepository extends JpaRepository<GenerateRegSpBill, Integer> {
	
	
	@Query(value="SELECT t_regular_sp_cake.rsp_id,coalesce((select item_hsncd from m_item_sup where m_item_sup.item_id=m_item.id and m_item_sup.del_status=0),'-') as hsn_code, t_regular_sp_cake.fr_id, t_regular_sp_cake.fr_code ,t_regular_sp_cake.menu_id, t_regular_sp_cake.item_id,t_regular_sp_cake.qty, t_regular_sp_cake.rate,"
			+ " t_regular_sp_cake.mrp, t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rate_cat, m_franchisee.fr_name, m_franchisee.is_same_state, m_fr_menu_show.menu_title, m_item.item_name, m_item.item_grp1,m_item.item_grp2 ,"
			+ " m_item.item_tax1 ,m_item.item_tax2, m_item.item_tax3, m_item.item_shelf_life,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin FROM t_regular_sp_cake , m_franchisee , m_fr_menu_show, m_item"
			+ " WHERE t_regular_sp_cake.fr_id IN(:frId) AND t_regular_sp_cake.menu_id IN(:menuId) AND t_regular_sp_cake.rsp_delivery_dt =:delDate AND m_franchisee.fr_id=t_regular_sp_cake.fr_id AND"
			+ " m_fr_menu_show.menu_id=t_regular_sp_cake.menu_id AND m_item.id=t_regular_sp_cake.item_id  AND t_regular_sp_cake.is_bill_generated IN(0,1) AND t_regular_sp_cake.qty>0 ORDER BY m_franchisee.fr_id,m_item.item_grp1,m_item.item_grp2,m_item.item_name " ,nativeQuery=true)
	List<GenerateRegSpBill> generateRegSpBill(@Param("frId")List<String> frId,@Param("menuId")List<String> menuId,@Param("delDate")String delDate);

	  
	
	@Query(value="SELECT t_regular_sp_cake.rsp_id,coalesce((select item_hsncd from m_item_sup where m_item_sup.item_id=m_item.id and m_item_sup.del_status=0),'-') as hsn_code, t_regular_sp_cake.fr_id, t_regular_sp_cake.fr_code ,t_regular_sp_cake.menu_id, t_regular_sp_cake.item_id,t_regular_sp_cake.qty, t_regular_sp_cake.rate,"
			+ " t_regular_sp_cake.mrp, t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rate_cat, m_franchisee.fr_name, m_franchisee.is_same_state, m_fr_menu_show.menu_title, m_item.item_name, m_item.item_grp1,m_item.item_grp2 ,"
			+ " m_item.item_tax1 ,m_item.item_tax2, m_item.item_tax3, m_item.item_shelf_life,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin FROM t_regular_sp_cake , m_franchisee , m_fr_menu_show, m_item"
			+ " WHERE t_regular_sp_cake.menu_id IN(:menuId) AND t_regular_sp_cake.rsp_delivery_dt =:delDate AND m_franchisee.fr_id=t_regular_sp_cake.fr_id AND"
			+ " m_fr_menu_show.menu_id=t_regular_sp_cake.menu_id AND m_item.id=t_regular_sp_cake.item_id  AND t_regular_sp_cake.is_bill_generated IN(0,1) AND t_regular_sp_cake.qty>0 ORDER BY m_franchisee.fr_id,m_item.item_grp1,m_item.item_grp2,m_item.item_name " ,nativeQuery=true)
	List<GenerateRegSpBill> generateRegSpBillForAllFr(@Param("menuId")List<String> menuId,@Param("delDate")String delDate);

	
	
	@Query(value="SELECT t_regular_sp_cake.rsp_id,coalesce((select item_hsncd from m_item_sup where m_item_sup.item_id=m_item.id and m_item_sup.del_status=0),'-') as hsn_code, t_regular_sp_cake.fr_id, t_regular_sp_cake.fr_code ,t_regular_sp_cake.menu_id, t_regular_sp_cake.item_id,t_regular_sp_cake.qty, t_regular_sp_cake.rate,"
			+ " t_regular_sp_cake.mrp, t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rate_cat, m_franchisee.fr_name,m_franchisee.is_same_state,  m_fr_menu_show.menu_title, m_item.item_name, m_item.item_grp1,m_item.item_grp2 ,"
			+ " m_item.item_tax1 ,m_item.item_tax2, m_item.item_tax3, m_item.item_shelf_life,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin FROM t_regular_sp_cake , m_franchisee , m_fr_menu_show, m_item"
			+ " WHERE t_regular_sp_cake.rsp_delivery_dt =:delDate AND m_franchisee.fr_id=t_regular_sp_cake.fr_id AND"
			+ " m_fr_menu_show.menu_id=t_regular_sp_cake.menu_id AND m_item.id=t_regular_sp_cake.item_id  AND t_regular_sp_cake.is_bill_generated IN(0,1) AND t_regular_sp_cake.qty>0 ORDER BY m_franchisee.fr_id,m_item.item_grp1,m_item.item_grp2,m_item.item_name " ,nativeQuery=true)
	List<GenerateRegSpBill> generateRegSpBillForAllFrAllMenu(@Param("delDate")String delDate);

	
	
	
	@Query(value="SELECT t_regular_sp_cake.rsp_id,coalesce((select item_hsncd from m_item_sup where m_item_sup.item_id=m_item.id and m_item_sup.del_status=0),'-') as hsn_code, t_regular_sp_cake.fr_id, t_regular_sp_cake.fr_code ,t_regular_sp_cake.menu_id, t_regular_sp_cake.item_id,t_regular_sp_cake.qty, t_regular_sp_cake.rate,"
			+ " t_regular_sp_cake.mrp, t_regular_sp_cake.rsp_delivery_dt, t_regular_sp_cake.rate_cat, m_franchisee.fr_name,m_franchisee.is_same_state,  m_fr_menu_show.menu_title, m_item.item_name, m_item.item_grp1,m_item.item_grp2 ,"
			+ " m_item.item_tax1 ,m_item.item_tax2, m_item.item_tax3, m_item.item_shelf_life,m_franchisee.fr_name as party_name,m_franchisee.fr_address as party_address,m_franchisee.fr_gst_no as party_gstin FROM t_regular_sp_cake , m_franchisee , m_fr_menu_show, m_item"
			+ " WHERE t_regular_sp_cake.fr_id IN(:frId)  AND t_regular_sp_cake.rsp_delivery_dt =:delDate AND m_franchisee.fr_id=t_regular_sp_cake.fr_id AND"
			+ " m_fr_menu_show.menu_id=t_regular_sp_cake.menu_id AND m_item.id=t_regular_sp_cake.item_id  AND t_regular_sp_cake.is_bill_generated IN(0,1) AND t_regular_sp_cake.qty>0 ORDER BY m_franchisee.fr_id,m_item.item_grp1,m_item.item_grp2,m_item.item_name " ,nativeQuery=true)
	List<GenerateRegSpBill> generateRegSpBillForAllMenu(@Param("frId")List<String> frId,@Param("delDate")String delDate);


}
