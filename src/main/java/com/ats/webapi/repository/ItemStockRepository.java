package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.StockItem;

@Repository
public interface ItemStockRepository extends JpaRepository<StockItem, Integer>{
	
    @Query(value="select m_item.* ,coalesce((select s.fr_stock_id from m_fr_item_stock s where s.item_id=m_item.id and s.type=:type),0)as fr_stock_id,coalesce((select s.min_qty from m_fr_item_stock s where s.item_id=m_item.id and s.type=:type),0)as min_qty_stock,coalesce((select s.max_qty from m_fr_item_stock s where s.item_id=m_item.id and s.type=:type),0)as max_qty,coalesce((select s.reorder_qty from m_fr_item_stock s where s.item_id=m_item.id and s.type=:type),0)as reorder_qty,(:type) as type  from m_item where   m_item.del_status=0 and m_item.item_grp2=:subCatId",nativeQuery=true)
	List<StockItem> findBySubCatIdAndType(@Param("subCatId")int subCatId,@Param("type") int type);
	
	

}
