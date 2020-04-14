package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.bill.GetItemHsnCode;

public interface GetItemHsnCodeRepository extends JpaRepository< GetItemHsnCode, Integer>{

	
	@Query(value=" SELECT s.item_id, t.item_name, s.item_hsncd from m_item t, m_item_sup s where s.item_id=t.id AND s.item_id=:itemId" + 
			"",nativeQuery=true)
	GetItemHsnCode getHsnCode(@Param("itemId")int itemId);

	
	
}
