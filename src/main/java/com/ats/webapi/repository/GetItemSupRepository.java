package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetItemSup;
@Repository
public interface GetItemSupRepository extends JpaRepository<GetItemSup, Integer>{

	@Query(value="Select s.id,s.short_name,s.item_id,s.item_cess,i.item_name,i.item_id as item_code ,s.cut_section,s.item_hsncd,s.uom_id,s.no_of_item_per_tray,s.tray_type,s.item_uom,s.actual_weight,s.base_weight,s.input_per_qty,s.is_gate_sale,s.is_gate_sale_disc,s.is_allow_bday,s.del_status from m_item_sup s,m_item i where s.item_id=i.id AND s.del_status=:delStatus order by i.item_name Asc",nativeQuery=true)
	List<GetItemSup> findAllByDelStatus(@Param("delStatus")int delStatus);
	
	@Query(value="Select s.id,s.short_name,s.item_id,s.item_cess,i.item_name,i.item_id as item_code ,s.cut_section,s.item_hsncd,s.no_of_item_per_tray,s.tray_type,s.uom_id,s.item_uom,s.actual_weight,s.base_weight,s.input_per_qty,s.is_gate_sale,s.is_gate_sale_disc,s.is_allow_bday,s.del_status from m_item_sup s,m_item i where s.item_id=i.id AND s.id=:id",nativeQuery=true)
	GetItemSup findGetItemSupById(@Param("id")int id);

	@Query(value="Select s.id,s.short_name,s.item_id,s.item_cess,i.item_name,i.item_id as item_code ,s.cut_section,s.item_hsncd,s.no_of_item_per_tray,s.tray_type,s.uom_id,s.item_uom,s.actual_weight,s.base_weight,s.input_per_qty,s.is_gate_sale,s.is_gate_sale_disc,s.is_allow_bday,s.del_status from m_item_sup s,m_item i where s.item_id=i.id AND s.item_id=:itemId",nativeQuery=true)
	GetItemSup findGetItemSupByItemId(@Param("itemId")int itemId);

}
