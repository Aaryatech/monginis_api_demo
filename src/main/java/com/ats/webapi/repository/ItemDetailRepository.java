package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.rawmaterial.ItemDetail;


@Repository
public interface ItemDetailRepository extends JpaRepository<ItemDetail, Integer>{



	@Transactional
	@Modifying
	@Query(" UPDATE ItemDetail SET delStatus=1 WHERE itemDetailId=:itemDetailId")
	int updateItemDetail(@Param("itemDetailId")int itemDetailId);

	ItemDetail findByItemDetailId(int itemDetailId);

}
