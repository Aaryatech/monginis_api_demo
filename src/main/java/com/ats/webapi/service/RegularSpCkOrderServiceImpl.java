package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetRegSpCakeOrders;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.RegSpCkOrderResponse;
import com.ats.webapi.model.RegularSpCake;
import com.ats.webapi.model.RegularSpCkOrders;
import com.ats.webapi.repository.GetRegSpCakeOrdersRepository;
import com.ats.webapi.repository.RegularCkOrderDelRepository;
import com.ats.webapi.repository.RegularSpCkOrderAdminRepo;
import com.ats.webapi.repository.RegularSpCkOrderRepository;

@Service
public class RegularSpCkOrderServiceImpl implements RegularSpCkOrderService{

	
	@Autowired
	RegularSpCkOrderRepository regularSpCkOrderRepository;
	@Autowired
	RegularSpCkOrderAdminRepo regularSpCkOrderAdminRepo;
	
	@Autowired
	GetRegSpCakeOrdersRepository getRegSpCakeOrdersRepository;
	
	@Autowired
	RegularCkOrderDelRepository regularCkOrderDelRepository;
	
	@Override
	public RegularSpCake placeRegularSpCakeOrder(RegularSpCake regularSpCake) {
	  
		ErrorMessage errorMessage=new ErrorMessage();
		
		RegularSpCake regularSpCakeOrder=regularSpCkOrderRepository.save(regularSpCake);
		
		if(regularSpCakeOrder!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Regular Sp Cake Order Placed Successfully");
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Regular Sp Cake Order Failed to Insert");
			
		}
		
		return regularSpCakeOrder;
	}


	@Override
	public RegSpCkOrderResponse findRegularSpCkOrder(List<Integer> frId, String strDate) {
		
		RegSpCkOrderResponse regSpCkOrderResponse=new RegSpCkOrderResponse();
        ErrorMessage errorMessage=new ErrorMessage();

		List<RegularSpCkOrders> regularSpCkOrdersList=new ArrayList<RegularSpCkOrders>();
		/*try {*/
			System.out.println("sevice try " );
			regularSpCkOrdersList=regularSpCkOrderAdminRepo.findRegularSpCakeOrder(frId, strDate);
			if(regularSpCkOrdersList!=null)
			{System.out.println("sevice tryif " );
				regSpCkOrderResponse.setRegularSpCkOrdersList(regularSpCkOrdersList);
				errorMessage.setError(false);
				errorMessage.setMessage("Regular Special Cake Orders Found");
				regSpCkOrderResponse.setErrorMessage(errorMessage);
			}
			else
			{System.out.println("sevice try else" );
				errorMessage.setError(true);
				errorMessage.setMessage("Regular Special Cake Orders Not Found");
				regSpCkOrderResponse.setErrorMessage(errorMessage);
			}
		/*}
		catch(Exception e){
			System.out.println("sevice try exc" );
			errorMessage.setError(true);
			errorMessage.setMessage("Regular Special Cake Orders Not Found EXC");
			regSpCkOrderResponse.setErrorMessage(errorMessage);
		}
		*/
		return regSpCkOrderResponse;
	}
	


	@Override
	public RegSpCkOrderResponse findRegSpCakeOrderAllFr(String strDate) {

		RegSpCkOrderResponse regSpCkOrderResponse=new RegSpCkOrderResponse();
          ErrorMessage errorMessage=new ErrorMessage();
          
		List<RegularSpCkOrders> regularSpCkOrdersList=new ArrayList<RegularSpCkOrders>();
		try {
			regularSpCkOrdersList=regularSpCkOrderAdminRepo.findRegularSpCakeOrderAllFr(strDate);
		
			if(regularSpCkOrdersList!=null)
			{
				regSpCkOrderResponse.setRegularSpCkOrdersList(regularSpCkOrdersList);
				errorMessage.setError(false);
				errorMessage.setMessage("Regular Special Cake Orders Found");
				regSpCkOrderResponse.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Regular Special Cake Orders Not Found");
				regSpCkOrderResponse.setErrorMessage(errorMessage);
			}
		}
		catch(Exception e){
			errorMessage.setError(true);
			errorMessage.setMessage("Regular Special Cake Orders Not Found");
			regSpCkOrderResponse.setErrorMessage(errorMessage);
		}
		
		return regSpCkOrderResponse;
	}


	@Override
	public List<GetRegSpCakeOrders> getRegSpCakeOrder(List<String> orderNo) {
		 
		return getRegSpCakeOrdersRepository.getRegSpOrders(orderNo);
	}


	@Override
	public Info deleteRegularSpOrder(int rspId) {

		int isDeleted=regularCkOrderDelRepository.deleteRegularSpOrder(rspId);
		Info info=new Info();
		
		if(isDeleted==1)
		{
			info.setError(false);
			info.setMessage("Regular Sp Order Deleted Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Regular Sp Order Deletion Failed");

		}
		
		return info;
	}


	@Override
	public List<GetRegSpCakeOrders> getRegSpCakeOrderHistory(String spDeliveryDt, int frId,List<String> catId) {

		List<GetRegSpCakeOrders> regularSpCkOrdersList=null;
		try {
			regularSpCkOrdersList=getRegSpCakeOrdersRepository.findRegularCakeOrderHistory(spDeliveryDt,frId,catId);
		
		}catch (Exception e) {
			regularSpCkOrdersList=new ArrayList<GetRegSpCakeOrders>();
			e.printStackTrace();
		}
		
		return regularSpCkOrdersList;
	}

}
