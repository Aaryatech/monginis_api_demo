package com.ats.webapi.repository.logistics;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.ServHeader;

public interface ServHeaderRepository extends JpaRepository<ServHeader, Integer>{

	List<ServHeader> findAllByDelStatus(int delStatus);

	ServHeader findByServId(int servId);

	
	@Query(value="select * from m_logis_serv where is_approved=0 or bill_date=:today",nativeQuery=true)
	List<ServHeader> showServicingListPendingAndCurrentDate(@Param("today")String today);

	@Query(value="select * from m_logis_serv where (bill_date between :fromDate and :toDate) and serv_type2=:type",nativeQuery=true)
	List<ServHeader> showServicingListBetweenDate(@Param("fromDate")String fromDate, @Param("toDate")String toDate,@Param("type")int type);

	
	@Transactional
	@Modifying
	@Query(" UPDATE ServHeader SET is_approved=:approved WHERE serv_id=:servId") 
	int approvedServiceHeader(@Param("servId")int servId,@Param("approved")int approved);

	@Query(value="select * from m_logis_serv where (bill_date between :fromDate and :toDate) and serv_type2=:type and veh_id=:vehId",nativeQuery=true)
	List<ServHeader> showServicingListBetweenDateAndFilter(@Param("fromDate")String fromDate, @Param("toDate")String toDate,@Param("type") int type,@Param("vehId") int vehId);

	@Query(value="select * from m_logis_serv where (bill_date between :fromDate and :toDate) and type_id=:typeId",nativeQuery=true)
	List<ServHeader> getServicingListBetweenDateByTypeId(@Param("fromDate")String fromDate, @Param("toDate")String toDate,@Param("typeId")int typeId); 

}
