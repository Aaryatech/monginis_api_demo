package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.FrItemStockConfigurePost;
import com.ats.webapi.model.GetFrItemStockConfiguration;

public interface FrItemStockConfigurePostRepository extends JpaRepository<FrItemStockConfigurePost, Integer> {
	
	public FrItemStockConfigurePost save(List<FrItemStockConfigurePost> frItemStockConfigurePost);
	
	
	/*
	@Query(value=" SELECT m_fr_item_stock.*, m_item.item_name from m_fr_item_stock, m_item WHERE"
			+ " m_fr_item_stock.item_id IN(:itemId) AND m_fr_item_stock.item_id=m_item.id "
			+ "",nativeQuery=true)
	
	public List<GetFrItemStockConfiguration> findByItemId(@Param("itemId")List<String> itemId);*/
	

}
