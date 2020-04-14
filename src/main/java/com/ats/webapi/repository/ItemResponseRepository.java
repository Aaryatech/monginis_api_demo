package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ItemRes;
@Repository
public interface ItemResponseRepository extends JpaRepository<ItemRes, Integer>{

	@Query(value="Select m_item.*,m_item_sup.item_uom,m_item_sup.uom_id from m_item,m_item_sup where m_item.del_status=:delStatus and m_item.item_grp2=:subCatId and m_item.id=m_item_sup.item_id order by m_item.item_grp2,m_item.item_name Asc",nativeQuery=true)
	List<ItemRes> findByItemGrp2AndDelStatusOrderByItemGrp2AscItemNameAsc(@Param("subCatId")String subCatId,@Param("delStatus") int i);

}
