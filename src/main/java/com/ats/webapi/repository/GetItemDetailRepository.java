package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.rawmaterial.GetItemDetail;

@Repository
public interface GetItemDetailRepository extends JpaRepository<GetItemDetail, Integer>{

	@Query(value="select d.item_detail_id,d.item_id, d.rm_id, d.rm_name, i.item_name, d.no_pieces_per_item, d.rm_type, d.rm_uom_id, d.rm_qty,d.rm_weight,d.del_status from m_item_detail d,m_item i where i.id=d.item_id  AND d.item_id=:itemId AND d.del_status=0;",nativeQuery=true)
	List<GetItemDetail> findAllItemDetailByDelStatus(@Param("itemId")int itemId);

	
}
