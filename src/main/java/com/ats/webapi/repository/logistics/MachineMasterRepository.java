package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.MachineMaster;

public interface MachineMasterRepository extends JpaRepository<MachineMaster, Integer>{

	@Transactional
	@Modifying
	@Query(" UPDATE MachineMaster SET del_status=1 WHERE machine_id=:machineId")
	int deleteMachineMaster(@Param("machineId")int machineId);

	List<MachineMaster> findByDelStatus(int delStatus);

	MachineMaster findByMachineId(int machineId); 

}
