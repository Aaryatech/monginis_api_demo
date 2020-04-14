package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetProductionDetail;
import com.ats.webapi.model.GetProductionItemQty;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.MaxTimeSlot;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.PostProdPlanHeader;
import com.ats.webapi.model.PostProductionDetail;
import com.ats.webapi.model.PostProductionHeader;
import com.ats.webapi.model.PostProductionPlanDetail;
import com.ats.webapi.model.prod.UpdateOrderStatus;
import com.ats.webapi.repository.GetProdQytRepository;
import com.ats.webapi.repository.GetProductionItemQtyRepository;
import com.ats.webapi.repository.MainMenuConfigurationRepository;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.PostPoductionHeaderRepository;
import com.ats.webapi.repository.PostProdPlanDetailRepository;
import com.ats.webapi.repository.PostProdPlanHeaderRepository;
import com.ats.webapi.repository.PostProductionDetailRepository;
import com.ats.webapi.repository.RegularSpCkOrderRepository;

@Service
public class ProductionServiceImpl implements ProductionService{

	@Autowired
	PostPoductionHeaderRepository postPoductionHeaderRepository;
	
	@Autowired
	PostProductionDetailRepository postProductionDetailRepository;
	
	@Autowired
	GetProdQytRepository getProdQytRepository;
	
	@Autowired 
	MainMenuConfigurationRepository menuRepository;

	@Autowired
	GetProductionItemQtyRepository getProductionItemQtyRepository;
	
	@Autowired
	PostProdPlanDetailRepository postProdPlanDetailRepository;
	
	@Autowired
	PostProdPlanHeaderRepository postProdPlanHeaderRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RegularSpCkOrderRepository regularSpCkOrderRepository;
	
	@Override
	public List<PostProductionHeader> saveProductionHeader(PostProductionHeader postProductionHeader) {
		PostProductionHeader postProductionHeaders=new PostProductionHeader();
		List<PostProductionHeader> postProductionHeaderList=new ArrayList<PostProductionHeader>();
		
			
			
		postProductionHeaders=postPoductionHeaderRepository.save(postProductionHeader);
		postProductionHeaderList.add(postProductionHeaders);
			int headerId=postProductionHeader.getProductionHeaderId();
			
			
			List<PostProductionDetail> postProductionDetailList=postProductionHeader.getPostProductionDetail();
			
			for(int j=0;j<postProductionDetailList.size();j++) {
				
				PostProductionDetail postProductionDetail=postProductionDetailList.get(j);
				
				postProductionDetail.setProductionHeaderId(headerId);
				
				
				postProductionDetailRepository.save(postProductionDetail);
				
			
			}
			
		
		return postProductionHeaderList;
	}
	
	
	@Override
	public List<GetProductionDetail> getProdQty(List<String> catId, String productionDate, int timeSlot) {
		
		System.out.println("In Menthod");
		
		List<GetProductionDetail> getProductionDetailList=getProdQytRepository.getProdQyt(catId, productionDate, timeSlot);
		
		
		return getProductionDetailList;
	}


	@Override
	public List<Integer> getMenuIdsByCatId(int catId) {

		List<Integer> menuList=menuRepository.findMenuIdByMainCatId(catId);
		
		return menuList;
	}


	@Override
	public List<GetProductionItemQty> getProdQty(String strDate, int catId) {

		List<GetProductionItemQty> prodItemQty=getProductionItemQtyRepository.findProdItemQty(strDate,catId);
		
		return prodItemQty;
	}


	@Override
	public PostProdPlanHeader saveProductionPlanHeader(PostProdPlanHeader postProdPlanHeader) {

		PostProdPlanHeader postProductionHeaders=new PostProdPlanHeader();
	
			
			
		postProductionHeaders=postProdPlanHeaderRepository.save(postProdPlanHeader);
			int headerId=postProductionHeaders.getProductionHeaderId();
			
			
			List<PostProductionPlanDetail> postProductionDetailList=postProdPlanHeader.getPostProductionPlanDetail();
			
			for(int j=0;j<postProductionDetailList.size();j++) {
				
				PostProductionPlanDetail postProductionPlanDetail=postProductionDetailList.get(j);
			if(postProdPlanHeader.getIsPlanned()==1)
			{
				if(postProductionPlanDetail.getPlanQty()>0)
				{
					System.err.println("***----inserted----***id_="+postProductionPlanDetail.getProductionDetailId());
				    postProductionPlanDetail.setProductionHeaderId(headerId);
				
				    postProductionPlanDetail.setProductionBatch(postProdPlanHeader.getProductionBatch());
				
				    postProductionPlanDetail.setProductionDate(postProdPlanHeader.getProductionDate());
				
				    postProdPlanDetailRepository.save(postProductionPlanDetail);
				}
				else if(postProductionPlanDetail.getPlanQty()==0 && postProductionPlanDetail.getProductionDetailId()!=0)
				{
					System.err.println("***----deleted----***id_="+postProductionPlanDetail.getProductionDetailId());
					postProdPlanDetailRepository.delete(postProductionPlanDetail.getProductionDetailId());
					
				}
			}else
			{
				if(postProductionPlanDetail.getOrderQty()>0)
				{
				    postProductionPlanDetail.setProductionHeaderId(headerId);
					
				    postProductionPlanDetail.setProductionBatch(postProdPlanHeader.getProductionBatch());
				
				    postProductionPlanDetail.setProductionDate(postProdPlanHeader.getProductionDate());
				
				    postProdPlanDetailRepository.save(postProductionPlanDetail);
				}
			}
			}
			
		
		return postProductionHeaders;
	}


	@Override
	public PostProdPlanHeader getMaxTimeSlot(String strDate, int catId) {

		PostProdPlanHeader maxTimeSlot=postProdPlanHeaderRepository.findTopTimeSlotByProductionDateAndCatId(strDate,catId);
		
		return maxTimeSlot;
	}


	@Override
	public Info updateProdQty(List<PostProductionPlanDetail> getProductionDetailList) {

		Info info=new Info();
		List<PostProductionPlanDetail> getProductionDetails=new ArrayList<PostProductionPlanDetail>();
		
		for(PostProductionPlanDetail getProductionDetail:getProductionDetailList)
		{
			PostProductionPlanDetail getProductionDetailRes=postProdPlanDetailRepository.save(getProductionDetail);
			
			getProductionDetails.add(getProductionDetailRes);
		}
	
		if(getProductionDetails.isEmpty())
		{
			info.setError(true);
			info.setMessage("Production Details Not Updated");
		}
		else
		{
			info.setError(false);
			info.setMessage("Production Details Updated Successfully");
		}

		return info;
	}

	@Override
	public int updateisMixing(int productionId,int flag) {
		int update = 0;
		try
		{
			if(flag==0)
			{
				System.out.println("flag 0 in if");
				update=postProdPlanHeaderRepository.updateisMixing(productionId);
			}
			else if(flag==1)
			{
				System.out.println("flag 1 in if else");
				update=postProdPlanHeaderRepository.updateisBom(productionId);	
			}
			 
		}catch(Exception e)
		{
			System.out.println("in implementation "+e.getMessage());
		}
		return update;
	}


	@Override
	public List<PostProdPlanHeader> planVariationList() {
		List<PostProdPlanHeader> PostProdPlanHeaderVariationlist = new ArrayList<PostProdPlanHeader>();
		try
		{
			PostProdPlanHeaderVariationlist=postProdPlanHeaderRepository.planVariationList();
				  
			 
		}catch(Exception e)
		{
			System.out.println("in implementation "+e.getMessage());
		}
		return PostProdPlanHeaderVariationlist;
	}


	@Override
	public Info updateBillStatus(UpdateOrderStatus updateOrderStatus) {
		int res=0,res2=0;
		Info info=new Info();
		
		//if(updateOrderStatus.getOrderId()!=null || !updateOrderStatus.getOrderId().isEmpty())
		 res2=  orderRepository.updateStatus(updateOrderStatus.getOrderItemId(), updateOrderStatus.getProdDate());
		
		//if(updateOrderStatus.getRegOrderId()!=null || !updateOrderStatus.getRegOrderId().isEmpty())
			res=regularSpCkOrderRepository.updateRegSpCakeBillStatus(updateOrderStatus.getRegOrderItemId(), updateOrderStatus.getProdDate());
		
		if(res>0 || res2>0)
		{
			info.setError(false);
			info.setMessage("success");
		}
		else
		{
			info.setError(false);
			info.setMessage("success");
		}
		return info;
	}


	@Override
	public int updateProductionStatus(int productionId, int prodStatus) {
		int update = 0;
		try
		{
				update=postProdPlanHeaderRepository.updateProductionStatus(productionId,prodStatus);
		
			
		}catch(Exception e)
		{
			System.out.println("updateProductionStatus "+e.getMessage());
		}
		return update;
	}


	@Override
	public List<GetProductionItemQty> getOrderuItemQty(String strDate, int catId) {
		List<GetProductionItemQty> prodItemQty=getProductionItemQtyRepository.getOrderuItemQty(strDate,catId);
		return prodItemQty;
	}
	

}
