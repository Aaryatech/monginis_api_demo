package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.OrderSpecialCake;


public interface ConfiSpCodeRepository extends JpaRepository<OrderSpecialCake, Long>{
	
	@Query(value="SELECT  CONCAT(m.sp_code,'~~~',m.sp_name) FROM m_sp_cake m "
			+ " WHERE m.sp_id IN(:items) AND  m.del_status=0"
			+ "  and m.is_used=1",nativeQuery=true)  //AND f.menu_id=:menuId AND f.fr_id=:frId  777 ,@Param("frId")int frId,@Param("menuId")int menuId
	public List<String> findSpCode(@Param ("items") List<Integer>items);

	
	
}