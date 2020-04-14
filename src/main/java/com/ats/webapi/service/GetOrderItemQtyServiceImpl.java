package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetOrderItemQty;
import com.ats.webapi.model.GetRegSpCakeOrderQty;
import com.ats.webapi.repository.GetOrderItemRepository;
import com.ats.webapi.repository.GetRegSpCakeOrderQtyRepository;

@Service
public class GetOrderItemQtyServiceImpl implements GetOrderItemQtyService{
	@Autowired
	GetOrderItemRepository getOrderItemRepository;
	@Autowired
	GetRegSpCakeOrderQtyRepository getRegSpCakeOrderQtyRepository;
	private List<GetRegSpCakeOrderQty> getRegSpCakeOrderItemQtyList;
	
	/*@Override
	public GetOrderItemQty getOrderQty(int itemId, String orderDate, int menuId) {
		GetOrderItemQty getOrderItemQty=getOrderItemRepository.getOrderItemQty(itemId, orderDate, menuId);
		
		System.out.println("inside service impl "+getOrderItemQty);
		
		return getOrderItemQty;
	}*/

	/*@Override
	public GetRegSpCakeOrderQty getRegSpCakeOrderQty(int itemId, String orderDate, int menuId) {
		GetRegSpCakeOrderQty getRegSpCakeOrderItemQty=getRegSpCakeOrderQtyRepository.getRegSpCakeOrderItemQty(itemId, orderDate, menuId);
		
		System.out.println("inside service impl "+getRegSpCakeOrderItemQty);
		
		return getRegSpCakeOrderItemQty;
	}
*/
	@Override
	public List<GetRegSpCakeOrderQty> getRegSpCakeOrderQty(String productionDate, List<String> menuId) {
		
		try
		{
			System.out.println("productionDate "+productionDate+"         menuId"+menuId);
			  getRegSpCakeOrderItemQtyList=getRegSpCakeOrderQtyRepository.getRegSpCakeOrderAllItemQty(productionDate, menuId);
			
			System.out.println("getRegSpCakeOrderQty "+getRegSpCakeOrderItemQtyList);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		
		return getRegSpCakeOrderItemQtyList;
	}

	@Override
	public List<GetOrderItemQty> getOrderQty(String productionDate, List<String> menuId) {
List<GetOrderItemQty> getOrderItemQtyList=getOrderItemRepository.getOrderAllItemQty(productionDate, menuId);
		
		System.out.println("getOrderQty  "+getOrderItemQtyList);
		
		return getOrderItemQtyList;
	}
	

}
