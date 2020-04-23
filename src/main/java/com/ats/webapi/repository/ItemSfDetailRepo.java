package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.ItemSfDetail;
import com.ats.webapi.model.rawmaterial.SfItemDetailList;

public interface ItemSfDetailRepo extends JpaRepository<ItemSfDetail, Integer>{
	
	public ItemSfDetail save(ItemSfDetail itemSfDetail);
	
	List<ItemSfDetail> findByDelStatusAndSfId(int delStatus,int sfId);
	
	@Query(value="    SELECT\n" + 
			"        m_item_sf_detail.sf_did,\n" + 
			"        m_item_sf_detail.sf_id,\n" + 
			"         m_item_sf_detail.rm_id,\n" + 
			"        concat(m_item_sf_detail.rm_name,'#',m_rm_uom.uom) as rm_name,\n" + 
			"        m_item_sf_detail.rm_type,\n" + 
			"        m_item_sf_detail.rm_qty,\n" + 
			"        m_item_sf_detail.rm_weight,\n" + 
			"        m_item_sf_detail.del_status,\n" + 
			"        m_item_sf_detail.rm_unit,m_item_sf_detail.seq_no " + 
			"    FROM\n" + 
			"        m_item_sf_detail,m_rm_uom" + 
			"    WHERE\n" + 
			"        m_item_sf_detail.sf_id in(:sfId) and m_item_sf_detail.del_status=0 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit" + 
			"  ",nativeQuery=true)
	public List<ItemSfDetail> getSfItemDetailsForCreamPrep(@Param("sfId")List<Integer> sfId);
	
	
	@Query(value="select a.sf_did,a.seq_no,a.sf_id,a.rm_id,a.rm_name,a.rm_type,round(SUM((:rmQty*(a.rm_weight/rm_weight_per))/100),3) as rm_qty,SUM(a.rm_weight) as rm_weight,a.del_status,a.rm_unit\n" + 
			"from\n" + 
			"(SELECT\n" + 
			"		       m_item_sf_detail.sf_did,\n" + 
			"		       m_item_sf_detail.sf_id,\n" + 
			"		       m_item_sf_detail.rm_id,\n" + 
			"		       concat(m_item_sf_detail.rm_name,'#',m_rm_uom.uom) as rm_name, \n" + 
			"		       m_item_sf_detail.rm_type,\n" + 
			"		       m_item_sf_detail.rm_qty,\n" + 
			"		       m_item_sf_detail.rm_weight, \n" + 
			"		       m_item_sf_detail.del_status,\n" + 
			"		       m_item_sf_detail.rm_unit,m_item_sf_detail.seq_no " + 
			"		    FROM \n" + 
			"			       m_item_sf_detail,m_rm_uom\n" + 
			"		    WHERE\n" + 
			"			        m_item_sf_detail.sf_id in(:sfId) and m_item_sf_detail.del_status=0 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit ) a LEFT JOIN\n" + 
			"			        ( SELECT\n" + 
			"		       m_item_sf_detail.sf_id,\n" + 
			"		      \n" + 
			"		       SUM(m_item_sf_detail.rm_weight)/100 as rm_weight_per\n" + 
			"		    FROM \n" + 
			"			       m_item_sf_detail\n" + 
			"		    WHERE\n" + 
			"			        m_item_sf_detail.sf_id in(:sfId) and m_item_sf_detail.del_status=0 group by sf_id\n" + 
			"			) b on a.sf_id=b.sf_id group by rm_id,rm_type",nativeQuery=true)
	public List<ItemSfDetail> getSfItemDetailsApp(@Param("sfId")List<Integer> sfId,@Param("rmQty") float rmQty);


}
