package com.ats.webapi.repository.logistics;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.logistics.MachineServicing;
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportBillWise;

public interface MachineServicingRepository extends JpaRepository<MachineServicing, Integer>{

	List<MachineServicing> findAllByIsApprovedAndDelStatus(int isApproved, int delStatus);

	
	@Query(value= "select * from m_logis_machine_serv where date between :fromDate and :toDate",nativeQuery=true) 
	List<MachineServicing> findByBetweenDate(@Param("fromDate")String fromDate,@Param("toDate")String toDate);

	@Query(value= "select * from m_logis_machine_serv where (date between :fromDate and :toDate) and machine_id=:machineId",nativeQuery=true)
	List<MachineServicing> findByBetweenDateByMachineId(@Param("fromDate")String fromDate,@Param("toDate")String toDate,@Param("machineId") int machineId);
 

}
