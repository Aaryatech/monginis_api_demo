package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetProductionDetail;

public interface GetProdQytRepository extends JpaRepository<GetProductionDetail, Integer>{

	@Query(value="SELECT d.production_detail_id, SUM(d.production_qty) as qty, d.item_id, t.item_name from t_production_plan_detail d,"
			+" t_production_plan_header h, m_item t WHERE h.production_date =:productionDate AND d.item_id=t.id AND"
			+" h.time_slot=:timeSlot AND h.cat_id IN(:catId) AND h.production_header_id=d.production_header_id Group By d.item_id",nativeQuery=true)
	List<GetProductionDetail> getProdQyt(@Param("catId")List<String> catId, @Param("productionDate") String productionDate, @Param("timeSlot") int timeSlot);
	
}
