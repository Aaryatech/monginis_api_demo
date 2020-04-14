package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.gatesale.OtherItem;
import com.ats.webapi.model.gatesale.OtherItemRes;

@Repository
public interface GateOtherItemResRepository extends JpaRepository<OtherItemRes, Integer>{

	@Query(value="select i.item_id,i.supp_id,s.supp_name,i.item_name,i.item_qty,i.item_rate,i.del_status from m_gatesale_other_item \n" + 
			"i,m_gatesale_other_supplier s where i.supp_id=s.supp_id and i.del_status=:delStatus and s.supp_id=:suppId",nativeQuery=true)
	List<OtherItemRes> findOtherItemByDelStatusAndSuppId(@Param("delStatus")int delStatus,@Param("suppId") int suppId);

}
