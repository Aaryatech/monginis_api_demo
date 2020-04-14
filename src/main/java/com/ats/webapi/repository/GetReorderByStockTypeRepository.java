package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetReorderByStockType;

public interface GetReorderByStockTypeRepository extends JpaRepository<GetReorderByStockType, Integer>{
	
	
	@Query(value=" select * from m_fr_item_stock where item_id in (:itemId) and type=:stockType",nativeQuery=true)
	List<GetReorderByStockType> GetRegSpCakeOrderQty(@Param("itemId")List<String> itemId, @Param("stockType")int stockType);

}
