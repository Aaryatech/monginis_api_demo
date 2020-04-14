package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetRegularSpCkItems;

public interface RegularSpCkItemsRepository extends JpaRepository<GetRegularSpCkItems, Integer> {

	 @Query(value = "SELECT id,item_name,item_image,item_rate1,item_rate2,item_rate3,item_mrp1,item_mrp2,item_mrp3,item_shelf_life,Item_tax1,Item_tax2,Item_tax3 FROM `m_item` WHERE item_grp2 =:itemGrp2 and id IN(:items)",nativeQuery=true)
	List<GetRegularSpCkItems> findRegularSpCkItems(@Param("items")List<Integer> items,@Param("itemGrp2") int itemGrp2);

	
	
}
