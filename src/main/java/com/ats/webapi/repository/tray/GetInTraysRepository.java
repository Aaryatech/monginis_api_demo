package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.tray.GetInTrays;

public interface GetInTraysRepository  extends JpaRepository<GetInTrays, Integer>{

	@Query(value="     Select intray_id,fr_id,'' as outtray_date,0 as outtray_big,  \n" + 
			"0 as outtray_small,  \n" + 
			"0 as outtray_lead,  \n" + 
			"sum(intray_big) as intray_big, \n" + 
			"sum(intray_lead) as intray_lead, \n" + 
			"sum(intray_small) as intray_small,0 as balance_big,0 as balance_lead,0 as balance_small,'' as fr_code,'' as fr_name " + 
			"         from t_tray_mgmt_detail_intray where tran_intray_id=:tranId and fr_id IN(:frIdList) group by fr_id,tran_intray_id",nativeQuery=true)
	List<GetInTrays> getTrayMgtInTrayList(@Param("tranId")int tranId,@Param("frIdList") List<Integer> frIdList);

}
