package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.ConfigureFrBean;


public interface ConfigureFrListRepository extends JpaRepository<ConfigureFrBean, Integer>{ 
	
	
	
	/*changed on 3-01-19
	@Query(value=" select m_fr_configure.*,m_franchisee.fr_name,m_fr_menu_show.menu_title,m_category.cat_name "
			+ " from m_fr_configure,m_franchisee,m_fr_menu_show,m_category "
			+ " where m_franchisee.fr_id=m_fr_configure.fr_id and m_fr_menu_show.menu_id=m_fr_configure.menu_id "
			+ " AND m_category.cat_id=m_fr_configure.cat_id  order by fr_name ASC,setting_id ASC"
			,nativeQuery=true)*/
	

	@Query(value=" select m_fr_configure.*,'NA' as fr_name,m_fr_menu_show.menu_title,m_category.cat_name from m_fr_configure,m_fr_menu_show,m_category	where  m_fr_menu_show.menu_id=m_fr_configure.menu_id AND m_category.cat_id=m_fr_configure.cat_id  ",nativeQuery=true)

	List<ConfigureFrBean> findConfiFrList();
	
	@Query(value=" select m_fr_configure.*,'NA' as fr_name,m_fr_menu_show.menu_title,m_category.cat_name from m_fr_configure,m_fr_menu_show,m_category	where  m_fr_menu_show.menu_id=m_fr_configure.menu_id AND m_category.cat_id=m_fr_configure.cat_id  ",nativeQuery=true)
	List<ConfigureFrBean> findConfiguredMenuFrList();
}
