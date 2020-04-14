package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ItemWithSubCat;

public interface GetFrItemRepository extends  CrudRepository<ItemWithSubCat, Long>{
		

	 @Query(value = " SELECT m_item.* , m_cat_sub.sub_cat_name FROM m_item , m_cat_sub WHERE m_item.id IN(:items) AND m_cat_sub.sub_cat_id = m_item.item_grp2 AND m_item.del_status=0 and item_is_used IN(:itemIsUsed) order by m_item.item_grp1,m_item.item_grp2,m_item.item_name", nativeQuery = true)
	    List<ItemWithSubCat> findFrItems(@Param ("itemIsUsed") List<Integer> itemIsUsed,@Param ("items") List<Integer>items);
	
	
}



