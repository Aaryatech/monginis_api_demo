package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.tally.RawMaterialResponse;

@Repository
public interface RawMaterialResTallyRepository extends JpaRepository<RawMaterialResponse, Integer>{

	@Query(value="select  m_rm.rm_id,\r\n" + 
			"            m_rm.rm_name,\r\n" + 
			"            m_rm.rm_code,\r\n" + 
			"            m_rm_item_group.grp_name,\r\n" + 
			"           m_rm_item_cat.cat_name,\r\n" + 
			"            m_rm_item_sub_cat.sub_cat_name,\r\n" + 
			"            m_rm_uom.uom,\r\n" + 
			"            m_rm.rm_specification,\r\n" + 
			"            m_rm.rm_icon,\r\n" + 
			"            m_rm.rm_weight,\r\n" + 
			"            m_rm.rm_pack_qty,\r\n" + 
			"            m_rm.rm_rate,\r\n" + 
			"            m_rm_tax.tax_desc,\r\n" + 
			"            m_rm_tax.cgst_per,\r\n" + 
			"            m_rm_tax.sgst_per,\r\n" + 
			"            m_rm_tax.igst_per,\r\n" + 
			"            m_rm.rm_min_qty,\r\n" + 
			"            m_rm.rm_max_qty,\r\n" + 
			"            m_rm.rm_rol_qty,\r\n" + 
			"            m_rm.rm_op_rate,\r\n" + 
			"            m_rm.rm_op_qty,\r\n" + 
			"            m_rm.rm_received_qty,\r\n" + 
			"            m_rm.rm_iss_qty,\r\n" + 
			"            m_rm.rm_rej_qty,\r\n" + 
			"            m_rm.rm_clo_qty,\r\n" + 
			"            m_rm.rm_is_critical,\r\n" + 
			"            m_rm.del_status,\r\n" + 
			"            m_rm.is_tally_sync from m_rm,m_rm_item_cat,m_rm_item_sub_cat,m_rm_item_group,m_rm_tax,m_rm_uom where m_rm.rm_uom_id=m_rm_uom.uom_id AND m_rm.sub_cat_id=m_rm_item_sub_cat.sub_cat_id And m_rm.cat_id=m_rm_item_cat.cat_id And m_rm.grp_id=m_rm_item_group.grp_id And m_rm.tax_id=m_rm_tax.tax_id AND m_rm.del_status=0 and m_rm.is_tally_sync=0",nativeQuery=true)
	List<RawMaterialResponse> findByDelStatusAndIsTallySync();
}
