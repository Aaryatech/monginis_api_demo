package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.webapi.model.GetMenuShow;

public interface GetMenuShowRepo extends JpaRepository<GetMenuShow, Integer> {

	@Query(value = " SELECT m.*,c.cat_name FROM m_fr_menu_show m ,m_category c WHERE m.del_status=0 AND c.cat_id=m.cat_id", nativeQuery = true)
	List<GetMenuShow> getMenuListData();

}
