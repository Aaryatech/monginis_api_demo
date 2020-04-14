package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.SpecialCake;


@Repository
public interface TallySpCakeRepository extends JpaRepository<SpecialCake, Integer>{

	
	@Query(value="SELECT\n" + 
			"        s.sp_id,\n" + 
			"        s.sp_name,\n" + 
			"        s.sp_tax1,\n" + 
			"        s.sp_tax2,\n" + 
			"        s.sp_tax3,\n" + 
			"        sup.sp_hsncd,\n" + 
			"        sup.sp_cess,\n" + 
			"        sup.sp_uom,\n" + 
			"        s.sp_code,\n" + 
			"        s.sp_rate1,\n" + 
			"        s.sp_rate2,\n" + 
			"        s.sp_rate3,\n" + 
			"        s.mrp_rate1,\n" + 
			"        s.mrp_rate2,\n" + 
			"        s.mrp_rate3,s.erp_link_code \n" + 
			"    from\n" + 
			"        m_sp_cake s,\n" + 
			"        m_spcake_sup sup \n" + 
			"    where\n" + 
			"        s.sp_id=sup.sp_id \n" + 
			"        AND sup.is_tally_sync=0 \n" + 
			"        AND s.del_status=0",nativeQuery=true)
	List<SpecialCake> findByIsTallySync();
	

}
