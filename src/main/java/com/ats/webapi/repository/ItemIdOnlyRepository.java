package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ItemIdOnly;
@Repository
public interface ItemIdOnlyRepository extends JpaRepository<ItemIdOnly, Integer> 
{
	@Query(value="SELECT m_item.id, m_item.item_name FROM m_item INNER JOIN m_fr_configure ON FIND_IN_SET (m_item.id , m_fr_configure.item_show) WHERE m_fr_configure.menu_id=:menuId AND m_item.del_status=:delStatus order by m_item.item_grp2,m_item.item_name",nativeQuery=true)
	public  List<ItemIdOnly> finditmsMenuIdIn(@Param("delStatus") int delStatus,@Param("menuId") int menuId);

	@Query(value="SELECT m_item.id, m_item.item_name FROM m_item INNER JOIN m_fr_configure ON FIND_IN_SET (m_item.id , m_fr_configure.item_show) WHERE m_fr_configure.menu_id IN(:menuId) AND m_item.del_status=:delStatus order by m_item.item_grp2,m_item.item_name",nativeQuery=true)
	public  List<ItemIdOnly> finditmsMenuIdInMultiple(@Param("delStatus") int delStatus,@Param("menuId") List<Integer> menuId);
}
