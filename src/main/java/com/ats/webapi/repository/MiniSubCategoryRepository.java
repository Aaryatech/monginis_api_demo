package com.ats.webapi.repository;

import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.MiniSubCategory;

public interface MiniSubCategoryRepository extends JpaRepository<MiniSubCategory, Integer>{

	@Query(value="select m.*,'-' as sub_cat_name,'-' as cat_name from m_cat_sub2 m where  m.del_status=0",nativeQuery=true)
	List<MiniSubCategory> showMiniSubCatList();

	@Query(value="select m.*,s.sub_cat_name,c.cat_name from m_cat_sub2 m,m_cat_sub s,m_category c where m.sub_cat_id=s.sub_cat_id and s.cat_id=c.cat_id and s.del_status=0"
			+ " and m.sub_cat_id=:subCatId",nativeQuery=true)
	List<MiniSubCategory> showMiniSubCatListBySubCatId(@Param("subCatId") int subCatId);

}
