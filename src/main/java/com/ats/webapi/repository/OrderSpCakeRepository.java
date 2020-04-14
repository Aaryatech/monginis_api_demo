package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.Orders;


public interface OrderSpCakeRepository extends JpaRepository<OrderSpecialCake, Integer>{
	@Query(value="SELECT m_sp_cake.*,m_sp_rates.spr_rate,m_sp_rates.spr_add_on_rate FROM m_sp_rates,m_sp_cake WHERE m_sp_cake.sp_code =:spCode AND m_sp_cake.spr_id=m_sp_rates.spr_id and m_sp_cake.del_status=0",nativeQuery=true)
	public OrderSpecialCake findBySpCode(@Param("spCode")String spCode);

	@Query(value="SELECT m_sp_cake.*,m_sp_rates.spr_rate,m_sp_rates.spr_add_on_rate FROM m_sp_rates,m_sp_cake WHERE m_sp_cake.sp_id =:spId AND m_sp_cake.spr_id=m_sp_rates.spr_id and m_sp_cake.del_status=0",nativeQuery=true)
	public OrderSpecialCake findBySpId(@Param("spId")int spId);

	/*@Query(value="SELECT  m.sp_code FROM m_sp_cake m , m_fr_configure f WHERE m.sp_id IN(:items) AND  m.del_status=0 AND f.menu_id=:menuId AND f.fr_id=:frId",nativeQuery=true)
	public List<String> findSpCode(@Param ("items") List<Integer>items,@Param("frId")int frId,@Param("menuId")int menuId);
*/
	
	
}


