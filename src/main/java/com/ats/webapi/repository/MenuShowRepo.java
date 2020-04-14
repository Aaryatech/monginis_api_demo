package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.MenuShow;

public interface MenuShowRepo extends JpaRepository<MenuShow, Integer> {

	MenuShow findByMenuIdAndDelStatus(int menuId, int i);

	@Transactional
	@Modifying
	@Query("UPDATE MenuShow SET delStatus=1  WHERE menuId=:menuId")
	int deleteMenuShow(@Param("menuId") int menuId);

}
