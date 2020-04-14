package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetProductionDetail;
import com.ats.webapi.model.GetProductionItemQty;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.MaxTimeSlot;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.PostProdPlanHeader;
import com.ats.webapi.model.PostProductionHeader;
import com.ats.webapi.model.PostProductionPlanDetail;
import com.ats.webapi.model.prod.UpdateOrderStatus;

public interface ProductionService {

	
	public List<PostProductionHeader> saveProductionHeader(PostProductionHeader postProductionHeader);

	public List<GetProductionDetail> getProdQty(List<String> catId, String productionDate, int timeSlot);

	public List<Integer> getMenuIdsByCatId(int catId);

	public List<GetProductionItemQty> getProdQty(String strDate, int catId);

	public PostProdPlanHeader saveProductionPlanHeader(PostProdPlanHeader postProdPlanHeader);

	public PostProdPlanHeader getMaxTimeSlot(String strDate, int catId);


	public Info updateProdQty(List<PostProductionPlanDetail> getProductionDetailList);
	
	public int updateisMixing(int productionId,int flag);

	List<PostProdPlanHeader> planVariationList();

	 

	public int updateProductionStatus(int productionId, int prodStatus);

	public Info updateBillStatus(UpdateOrderStatus updateOrderStatus);

	public List<GetProductionItemQty> getOrderuItemQty(String strDate, int catId);
	
	
	
	}
