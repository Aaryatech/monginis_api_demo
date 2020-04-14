package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.OtherItem;

@Repository
public interface GateOtherItemRepository extends JpaRepository<OtherItem, Integer>{


	@Transactional
	@Modifying
	@Query("UPDATE OtherItem i SET i.delStatus=1  WHERE i.itemId=:itemId")
	int deleteGateOtherItem(@Param("itemId")int itemId);

	List<OtherItem> findOtherItemByDelStatusAndSuppId(int i, int suppId);

	OtherItem findOtherItemByItemId(int itemId);

}
