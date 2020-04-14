package com.ats.webapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.otheritems.Otheritems;

public interface OtheritemsRepo extends JpaRepository<Otheritems, Integer> {
	public List<Otheritems> findAllByDelStatusAndIsActive(int i, int status);
	
	@Query(value = "SELECT * FROM other_item WHERE item_id = :id AND is_active = 1 AND del_status = 0",nativeQuery=true)
	public Otheritems findByItemIdDelStatusAndIsActive(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE other_item SET del_status=1 WHERE item_id=:id ",nativeQuery=true)
	public int deleteItemByItemIdAndDelStatus(@Param("id") int id);

	public List<Otheritems> findByFrIdAndDelStatus(int frId, int i);
}
