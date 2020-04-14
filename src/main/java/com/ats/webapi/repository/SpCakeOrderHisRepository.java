package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpCkOrderHis;


public interface SpCakeOrderHisRepository extends JpaRepository<SpCkOrderHis, Long> {
	@Query(value="select t_sp_cake.*,m_sp_flavour.spf_name,m_sp_cake.sp_name from t_sp_cake,m_sp_flavour,m_sp_cake where t_sp_cake.sp_delivery_date=:spDeliveryDate AND  t_sp_cake.fr_code=:frCode AND t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id AND t_sp_cake.sp_id=m_sp_cake.sp_id",nativeQuery=true)
	List<SpCkOrderHis> findByMenuIdInAndSpDeliveryDt(@Param("spDeliveryDate")String spDeliveryDate,@Param("frCode")String frCode);

	@Query(value="select t_sp_cake.*,m_sp_flavour.spf_name,m_sp_cake.sp_name from t_sp_cake,m_sp_flavour,m_sp_cake where sp_order_no=:orderNo And t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id AND t_sp_cake.sp_id=m_sp_cake.sp_id",nativeQuery=true)
	SpCkOrderHis findByOrderNo(@Param("orderNo")int orderNo);

	@Query(value="select t_sp_cake.*,m_sp_flavour.spf_name,m_sp_cake.sp_name from t_sp_cake,m_sp_flavour,m_sp_cake where sp_delivery_place=:orderNo And t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id AND t_sp_cake.sp_id=m_sp_cake.sp_id",nativeQuery=true)
	List<SpCkOrderHis> findByOrderNoForEx(@Param("orderNo")String orderNo);

	@Query(value="select t_sp_cake.*,m_sp_flavour.spf_name,m_sp_cake.sp_name from t_sp_cake,m_sp_flavour,m_sp_cake where t_sp_cake.sp_delivery_date=:date and t_sp_cake.fr_id=:frId And  t_sp_cake.menu_id In(:menuId) and t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id AND t_sp_cake.sp_id=m_sp_cake.sp_id",nativeQuery=true)
	List<SpCkOrderHis> findByOrdersForExBill(@Param("date")String date,@Param("menuId")List<String> menuId,@Param("frId") int frId);

	@Query(value="select t_sp_cake.*,m_sp_flavour.spf_name,m_sp_cake.sp_name from t_sp_cake,m_sp_flavour,m_sp_cake where t_sp_cake.sp_delivery_date=:spDeliveryDt AND t_sp_cake.menu_id IN(:menuList) AND  t_sp_cake.fr_code=:frCode AND t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id AND t_sp_cake.sp_id=m_sp_cake.sp_id",nativeQuery=true)
	List<SpCkOrderHis> findByMenuIdInAndSpDeliveryDtByMenu(@Param("menuList")List<String> menuList,@Param("spDeliveryDt") String spDeliveryDt,@Param("frCode") String frCode);

	@Query(value="select t_sp_cake.*,m_sp_flavour.spf_name,m_sp_cake.sp_name from t_sp_cake,m_sp_flavour,m_sp_cake where sp_order_no=:spOrderNo And t_sp_cake.sp_flavour_id=m_sp_flavour.spf_id AND t_sp_cake.sp_id=m_sp_cake.sp_id",nativeQuery=true)
	SpCkOrderHis findByOrderNoForExBillPrint(@Param("spOrderNo")int spOrderNo);
}
