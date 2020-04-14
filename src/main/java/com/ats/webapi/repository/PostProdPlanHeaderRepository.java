package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.PostProdPlanHeader;

@Repository
public interface PostProdPlanHeaderRepository extends JpaRepository<PostProdPlanHeader, Integer>{

	
	@Query(value="SELECT production_header_id,production_date,cat_id,MAX(time_slot) as time_slot,production_batch,production_status,production_date,is_mixing,is_bom,del_status FROM t_production_plan_header  "
			+ "WHERE production_date=:strDate And cat_id=:catId ",nativeQuery=true)
	PostProdPlanHeader findTopTimeSlotByProductionDateAndCatId(@Param("strDate")String strDate,@Param("catId") int catId);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE PostProdPlanHeader SET is_mixing=1 WHERE production_header_id=:productionId")
	int updateisMixing(@Param("productionId")int productionId);
	
	@Transactional
	@Modifying
	@Query(" UPDATE PostProdPlanHeader SET is_bom=1, production_status=3 WHERE production_header_id=:productionId")
	int updateisBom(@Param("productionId")int productionId);

	
	@Query(value="select * from t_production_plan_header where is_planned=1 and production_status IN(3,4) ",nativeQuery=true)
	List<PostProdPlanHeader> planVariationList();
	
	@Query(value="select * from t_production_plan_header where production_header_id=:planHeaderId",nativeQuery=true)
	PostProdPlanHeader planVariationList(@Param("planHeaderId") int planHeaderId);
	 
	

	@Transactional
	@Modifying
	@Query(" UPDATE PostProdPlanHeader SET production_status=:prodStatus WHERE production_header_id=:productionId")
	int updateProductionStatus(@Param("productionId")int productionId,@Param("prodStatus") int prodStatus);

	@Transactional
	@Modifying
	@Query(" UPDATE PostProdPlanHeader SET del_status=1 WHERE production_header_id=:productionHeaderId")
	int deleteProductionPlan(@Param("productionHeaderId")int productionHeaderId);

	@Query(value="select * from t_production_plan_header where production_date=:productionDate and cat_id=:catId and production_status In(1) and del_status=0",nativeQuery=true)
	PostProdPlanHeader findByProductionDateAndCatId(@Param("productionDate")String productionDate,@Param("catId") int catId);
}
