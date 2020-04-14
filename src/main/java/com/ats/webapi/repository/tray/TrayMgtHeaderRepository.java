package com.ats.webapi.repository.tray;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.FranchiseInRoute;
import com.ats.webapi.model.tray.GetTrayMgtHeader;
import com.ats.webapi.model.tray.TrayMgtHeader;

@Repository
public interface TrayMgtHeaderRepository extends JpaRepository<TrayMgtHeader, Integer> {

	@Modifying
	@Transactional
	@Query("Update TrayMgtHeader  SET extra_tray_out=:extraOutTrays WHERE tran_id =:tranId")
	int updateExtraOutTrays(@Param("tranId") int tranId, @Param("extraOutTrays") int extraOutTrays);

	@Modifying
	@Transactional
	@Query("Update TrayMgtHeader  SET veh_outtime=:vehOuttime,veh_outkm=:vehOutKm,veh_status=1 WHERE tran_id=:tranId")
	int updateVehicleOutData(@Param("tranId") int tranId, @Param("vehOuttime") String vehOuttime,
			@Param("vehOutKm") float vehOutKm);

	@Modifying
	@Transactional
	@Query("Update TrayMgtHeader  SET veh_intime=:vehIntime,veh_inkm=:vehInkm,veh_running_km=:vehRunningkm,veh_status=2 WHERE tran_id=:tranId")
	int updateInVehicleData(@Param("tranId") int tranId, @Param("vehIntime") String vehIntime,
			@Param("vehInkm") float vehInkm, @Param("vehRunningkm") float vehRunningkm);

	@Modifying
	@Transactional
	@Query("Update TrayMgtHeader  SET diesel=:diesel WHERE tran_id =:tranId")
	int updateDieselForTransaction(@Param("tranId") int tranId, @Param("diesel") float diesel);

	@Modifying
	@Transactional
	@Query("Update TrayMgtHeader  SET extra_tray_in=:extraInTrays WHERE tran_id =:tranId")
	int updateExtraInTrays(@Param("tranId") int tranId, @Param("extraInTrays") int extraInTrays);

	TrayMgtHeader findByTranId(int tranId);

	@Modifying
	@Transactional
	@Query("Update TrayMgtHeader  SET del_status=1 WHERE tran_id =:tranId")
	int updateHeaderStatus(@Param("tranId") int tranId);

	@Query(value = "select * from t_tray_mgt_header where tran_date=:date And veh_id=:vehId And del_status=:delStatus AND veh_status IN(1,0)", nativeQuery = true)
	TrayMgtHeader findByTranDateAndVehIdAndDelStatus(@Param("date") String date, @Param("vehId") int vehId,
			@Param("delStatus") int delStatus);

}
