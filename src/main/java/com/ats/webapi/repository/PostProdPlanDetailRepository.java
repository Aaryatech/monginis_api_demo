package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.PostProductionPlanDetail;

@Repository
public interface PostProdPlanDetailRepository extends JpaRepository<PostProductionPlanDetail, Integer>{
	
	
	PostProductionPlanDetail save(PostProductionPlanDetail postProductionPlanDetail);
	
	@Query(value = "select * from t_production_plan_detail Where production_header_id=:planHeaderId", nativeQuery = true)
	List<PostProductionPlanDetail> getlistbyproductiondetaildlist(@Param("planHeaderId") int planHeaderId);

	List<PostProductionPlanDetail> findByProductionHeaderId(int productionHeaderId);
	

}
