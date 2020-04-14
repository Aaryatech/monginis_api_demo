package com.ats.webapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetConfiguredSpDayCk;

@Repository
public interface GetConfSpDayCakeRepository extends JpaRepository<GetConfiguredSpDayCk, Long>{


	List<GetConfiguredSpDayCk> findAllByDelStatus(int delStatus);

	GetConfiguredSpDayCk findBySpdayId(int spdayId);

    @Query(value="SELECT * from m_spday_configure where :cDate BETWEEN order_from_date AND order_to_date  AND del_status=0 And fr_id Like %:frId% ",nativeQuery=true)
	List<GetConfiguredSpDayCk> findAllSpDayCake(@Param("cDate")java.util.Date cDate,@Param("frId") int frId);

}
