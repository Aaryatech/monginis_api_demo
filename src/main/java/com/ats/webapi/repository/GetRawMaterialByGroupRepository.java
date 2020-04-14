package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.GetRawMaterialByGroup;

public interface GetRawMaterialByGroupRepository extends JpaRepository<GetRawMaterialByGroup, Integer>{
	
	@Query(value="select r.rm_id, r.rm_name, r.tax_id, r.grp_id, g.grp_name, r.cat_id, c.cat_name, r.sub_cat_id," + 
			"s.sub_cat_name, r.rm_pack_qty, r.rm_rate, r.rm_is_critical,r.rm_rol_qty as bms_rol_qty,r.rm_received_qty as store_rol_qty,t.sgst_per,t.cgst_per,t.igst_per from m_rm r, m_rm_item_cat c, m_rm_item_group g," + 
			"m_rm_item_sub_cat s,m_rm_tax t where t.tax_id=r.tax_id AND r.grp_id=g.grp_id AND r.cat_id=c.cat_id AND s.sub_cat_id=r.sub_cat_id AND r.grp_id=:grpId AND r.del_status=0 ",nativeQuery=true)
	List<GetRawMaterialByGroup> getRmByGroup(@Param("grpId") int grpId);

}
