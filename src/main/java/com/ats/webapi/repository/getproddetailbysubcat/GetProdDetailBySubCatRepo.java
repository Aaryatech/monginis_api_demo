package com.ats.webapi.repository.getproddetailbysubcat;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ats.webapi.model.prod.GetProdDetailBySubCat;

public interface GetProdDetailBySubCatRepo extends JpaRepository<GetProdDetailBySubCat, Integer> {
	
	@Query(value=" SELECT  subCat.sub_cat_name,subCat.sub_cat_id,item.item_grp2, CASE WHEN ph.is_planned=1 THEN SUM(pd.plan_qty) " + 
			"ELSE SUM(pd.order_qty) END as total_qty from m_cat_sub subCat,m_item item," + 
			"t_production_plan_header ph,t_production_plan_detail pd " + 
			" WHERE  ph.production_header_id=:prodHeaderId and ph.cat_id=subCat.cat_id and item.item_grp2=subCat.sub_cat_id " + 
			" and ph.production_header_id=pd.production_header_id and item.id=pd.item_id group by item.item_grp2",nativeQuery=true)
	List<GetProdDetailBySubCat> getProdDetailBySubCat(@Param("prodHeaderId")int prodHeaderId);

}
