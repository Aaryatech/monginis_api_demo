package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.FrMenus;

public interface FrMenusRepository extends CrudRepository<FrMenus, Integer> {

	//@Query(value = "SELECT m_fr_configure.setting_id,  m_fr_configure.fr_id,m_fr_configure.menu_id,m_fr_menu_show.cat_id, m_fr_configure.to_time  ,m_fr_configure.setting_type ,m_fr_configure.item_show ,m_fr_configure.from_time , m_fr_menu_show.menu_title, m_fr_menu_show.menu_image, m_fr_menu_show.selected_menu_image,m_fr_menu_show.is_same_day_applicable, m_fr_menu_show.menu_desc,m_fr_configure.day, m_fr_configure.date FROM m_fr_configure ,m_fr_menu_show WHERE m_fr_configure.menu_id = m_fr_menu_show.menu_id AND m_fr_configure.fr_id=:frId", nativeQuery = true)
	@Query(value = "SELECT m_fr_configure.setting_id, :frId fr_id,m_fr_configure.menu_id,m_fr_menu_show.cat_id, m_fr_configure.to_time  ,m_fr_configure.setting_type ,m_fr_configure.item_show ,m_fr_configure.from_time , m_fr_menu_show.menu_title, m_fr_menu_show.menu_image, m_fr_menu_show.selected_menu_image,m_fr_menu_show.is_same_day_applicable, m_fr_menu_show.menu_desc,m_fr_configure.day, m_fr_configure.date FROM m_fr_configure ,m_fr_menu_show  WHERE m_fr_configure.menu_id = m_fr_menu_show.menu_id AND m_fr_configure.setting_id in (select menu_id from m_fr_menu_configure where fr_id=:frId AND is_del=0)",nativeQuery=true)
	public List<FrMenus> findAllByFrId(@Param("frId") int frId);
	
	@Query(value = "SELECT m_fr_configure.setting_id, :frId fr_id,m_fr_configure.menu_id,m_fr_menu_show.cat_id, m_fr_configure.to_time  ,m_fr_configure.setting_type ,m_fr_configure.item_show ,m_fr_configure.from_time , m_fr_menu_show.menu_title, m_fr_menu_show.menu_image, m_fr_menu_show.selected_menu_image,m_fr_menu_show.is_same_day_applicable, m_fr_menu_show.menu_desc,m_fr_configure.day, m_fr_configure.date FROM m_fr_configure ,m_fr_menu_show  WHERE m_fr_configure.menu_id = m_fr_menu_show.menu_id AND m_fr_configure.setting_id in (select menu_id from m_fr_menu_configure where fr_id=:frId AND cat_id=:catId AND is_del=0)",nativeQuery=true)
	public List<FrMenus> findAllByFrIdAndCategory(@Param("frId") int frId,@Param("catId") int catId);

}
