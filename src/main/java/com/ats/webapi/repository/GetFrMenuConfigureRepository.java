package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetFrMenuConfigure;
@Repository
public interface GetFrMenuConfigureRepository extends JpaRepository<GetFrMenuConfigure, Integer>{

	@Query(value="select c.setting_id,c.fr_id,cf.menu_id,cf.cat_id,cf.sub_cat_id,cf.from_time,cf.to_time,cf.setting_type,cf.day,cf.date, f.fr_name, m.menu_title,c.is_del,cat.cat_name from m_fr_menu_configure c,m_franchisee f,m_fr_menu_show m,m_fr_configure cf,m_category cat where c.fr_id=f.fr_id and c.menu_id=cf.setting_id and m.menu_id=cf.menu_id and cat.cat_id=cf.cat_id and  c.is_del=0",nativeQuery=true)
	List<GetFrMenuConfigure> getFrMenuConfigureList();

}
