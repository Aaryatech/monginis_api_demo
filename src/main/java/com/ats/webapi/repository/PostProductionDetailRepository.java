package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetProductionDetail;
import com.ats.webapi.model.PostProductionDetail;
import com.ats.webapi.model.PostProductionPlanDetail;

public interface PostProductionDetailRepository extends JpaRepository<PostProductionDetail, Integer>{
	
	PostProductionDetail save(PostProductionDetail postProductionDetail);

	List<PostProductionPlanDetail> save(List<PostProductionPlanDetail> postProductionPlanDetail);

	

	 

}
