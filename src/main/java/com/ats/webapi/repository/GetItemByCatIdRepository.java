package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetItemByCatId;

public interface GetItemByCatIdRepository extends JpaRepository<GetItemByCatId, Integer> {

	@Query(value = " SELECT  m_item.item_name,m_item.id,m_item.item_id,m_item.item_grp1,m_item.item_grp1 as cat_id"
			+ " from m_item WHERE" + " m_item.item_grp1 =:catId and m_item.del_status=0 " + "", nativeQuery = true)

	List<GetItemByCatId> getItemByCategory(@Param("catId") int catId);

	@Query(value = " SELECT  m_item.item_name,m_item.id,m_item.item_id,m_item.item_grp1,m_item.item_grp2 as cat_id"
			+ " from m_item WHERE" + " m_item.item_grp2 =:subCatId and m_item.del_status=0 " + "", nativeQuery = true)

	List<GetItemByCatId> getItemByCategoryBySubCatId(@Param("subCatId") int subCatId);


	@Query(value = " SELECT  s.sp_name as item_name,s.sp_id as id,s.sp_code as item_id,5 as item_grp1,4 as cat_id"
			+ " from m_sp_cake s WHERE" + "  s.del_status=0 " + "", nativeQuery = true)
	List<GetItemByCatId> getSpByCategoryBySubCatId();

}
