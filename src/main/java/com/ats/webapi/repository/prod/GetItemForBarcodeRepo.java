package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.ProdItemBarcode;

public interface GetItemForBarcodeRepo extends JpaRepository<ProdItemBarcode,Integer> {
	
	
	
@Query(value="SELECT d.item_id, d.production_qty ,i.item_id as item_code , i.item_name FROM t_production_plan_detail as d,"
		+ " m_item as i WHERE production_header_id=(SELECT production_header_id FROM t_production_plan_header"
		+ " WHERE production_date=:date AND production_status > 3 AND cat_id=:catId) AND d.item_id=i.id",nativeQuery=true)
	
List<ProdItemBarcode> getItemForBarcode(@Param("date") String date,@Param("catId") int catId);





}
