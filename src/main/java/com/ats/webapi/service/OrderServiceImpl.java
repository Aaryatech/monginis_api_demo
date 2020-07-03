package com.ats.webapi.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.AllFrIdName;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.ItemOrderHis;
import com.ats.webapi.model.ItemOrderList;
import com.ats.webapi.model.OrderDelete;
import com.ats.webapi.model.Orders;
import com.ats.webapi.repository.AllFrIdNameRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.ItemOrderHisRepository;
import com.ats.webapi.repository.OrderDeleteRepository;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

	String jsonResult;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemOrderHisRepository itemOrderHisRepository;

	@Autowired
	AllFrIdNameRepository allFrIdNameRepository;
	 
	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	
	@Autowired
	OrderDeleteRepository deleteRepository;
	
	
	@Override
	public List<Orders> placeOrder(List<Orders> list) {
		List<Orders> returnList = new ArrayList();
		
		for (Orders o : list) {

			Orders prevOrder = orderRepository.findPreviousOrder(o.getItemId(), o.getFrId(), o.getProductionDate(),
					o.getMenuId());

			try {

				System.out.println("prev order orderId " + prevOrder.getOrderId());

				if (prevOrder.getItemId().equalsIgnoreCase("") || prevOrder.getItemId().equalsIgnoreCase(null)) {

				} else {
					System.out.println("Updating order with qty " + o.getOrderQty());

					Orders updatedOrder = null;
					if (o.getOrderQty() == 0) {

						System.out.println("Deleteing order");
						
						OrderDelete delete=new OrderDelete();
						
						delete.setFrId(o.getFrId());
						delete.setOrderId(prevOrder.getOrderId());
						
						deleteRepository.save(delete); 
						

						Long result = orderRepository.deleteByOrderDateAndFrIdAndMenuIdAndItemId(o.getOrderDate(),o.getFrId(),
								o.getMenuId(), o.getItemId());

						System.out.println("Order Deleted ? = " + result);
					} else {
						prevOrder.setOrderQty(o.getOrderQty());
						prevOrder.setEditQty(o.getOrderQty());//21-July-change-for editQty
						prevOrder.setIsPositive(o.getIsPositive());//10-jan-19-change-for editQty
						updatedOrder = orderRepository.save(prevOrder);
						
					}
					
					returnList.add(updatedOrder);
				}

			} catch (Exception e) {

				System.out.println("Prev Order Exception " + e.getMessage());
				
				if (e.getMessage() == null) {
					System.out.println("Saving new order");

					Orders newOrder = orderRepository.save(o);
			
					returnList.add(newOrder);
				}
			}

			// Orders order=orderRepository.save(o);
			// returnList.add(prevOrder);
		}
		
		return returnList;
	}

	@Override
	public ItemOrderList searchOrderHistory(List<String> catId, Date deliveryDate, int frId) {
		List<ItemOrderHis> orderList = null;
		ErrorMessage errorMessage;
		ItemOrderList itemOrderList;
		try {
			
			if(catId.contains("-1")) {
				orderList = itemOrderHisRepository.findByMenuIdInAndDeliveryDateAll(deliveryDate, frId);

			}else {
			orderList = itemOrderHisRepository.findByMenuIdInAndDeliveryDate(catId, deliveryDate, frId);
			}
			if (orderList == null) {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(true);
				errorMessage.setMessage("Orders Not Found");

				itemOrderList.setErrorMessage(errorMessage);
			} else {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(false);
				errorMessage.setMessage("Orders found Successfully");

				itemOrderList.setItemOrderList(orderList);
				itemOrderList.setErrorMessage(errorMessage);

			}

		} catch (Exception e) {
			itemOrderList = new ItemOrderList();
			errorMessage = new ErrorMessage();

			errorMessage.setError(true);
			errorMessage.setMessage("Orders Not Found(EXC)");

			itemOrderList.setErrorMessage(errorMessage);
		}
		return itemOrderList;
	}
	

	
	
	@Override
	public ItemOrderList searchAdvOrderHistory(int advHeadId, Date deliveryDate, int frId) {
		List<ItemOrderHis> orderList = null;
		ErrorMessage errorMessage;
		ItemOrderList itemOrderList;
		try {
			
			 
				orderList = itemOrderHisRepository.findByMenuIdInAndDeliveryDateAllForAdv(advHeadId,deliveryDate, frId);

			 
			if (orderList == null) {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(true);
				errorMessage.setMessage("Orders Not Found");

				itemOrderList.setErrorMessage(errorMessage);
			} else {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(false);
				errorMessage.setMessage("Orders found Successfully");

				itemOrderList.setItemOrderList(orderList);
				itemOrderList.setErrorMessage(errorMessage);

			}

		} catch (Exception e) {
			itemOrderList = new ItemOrderList();
			errorMessage = new ErrorMessage();

			errorMessage.setError(true);
			errorMessage.setMessage("Orders Not Found(EXC)");

			itemOrderList.setErrorMessage(errorMessage);
		}
		return itemOrderList;
	}
	
	
	@Override
	public ItemOrderList searchAdvOrderHistoryForAdmin(int advHeadId) {
		List<ItemOrderHis> orderList = null;
		ErrorMessage errorMessage;
		ItemOrderList itemOrderList;
		try {
			
			 
				orderList = itemOrderHisRepository.findByMenuIdInAndDeliveryDateAllForAdv(advHeadId);
				
				System.err.println("orderList------------------------------------- "+orderList);

			 
			if (orderList == null) {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(true);
				errorMessage.setMessage("Orders Not Found");

				itemOrderList.setErrorMessage(errorMessage);
			} else {
				errorMessage = new ErrorMessage();
				itemOrderList = new ItemOrderList();

				errorMessage.setError(false);
				errorMessage.setMessage("Orders found Successfully");

				itemOrderList.setItemOrderList(orderList);
				itemOrderList.setErrorMessage(errorMessage);

			}

		} catch (Exception e) {
			itemOrderList = new ItemOrderList();
			errorMessage = new ErrorMessage();

			errorMessage.setError(true);
			errorMessage.setMessage("Orders Not Found(EXC)");

			itemOrderList.setErrorMessage(errorMessage);
		}
		return itemOrderList;
	}
	
	 
	

	// new Update order method for billing
	@Override
	public int  updateBillStatus(int orderId,int status) {
	
	int x=	orderRepository.updateBillStatus(orderId,status);
		
		
		return x;
		
		
	}

	@Override
	public List<Orders> placePustDumpOrder(List<Orders> list) {
	
		
		List<Orders> returnList = new ArrayList();
		for (Orders o : list) {

					System.out.println("Saving new order");

					Orders newOrder = orderRepository.save(o);
					
					returnList.add(newOrder);
				
						 try {
							 
							  String frToken=franchiseSupRepository.findTokenByFrId(o.getFrId());
					          Firebase.sendPushNotifForCommunication(frToken,"Order Pushed","Your savories/ cakes and pastries order not recived. A standing order has been put, against which no GVN-GRN will be given.","inbox");
							
					         }
					         catch(Exception e2)
					         {
						       e2.printStackTrace();
					         }
					
			}

		return returnList;
	}

	@Override
	public List<Orders> placeManualOrder(List<Orders> list) {
    List<Orders> returnList = new ArrayList();
		
		for (Orders o : list) {
			try {
			Orders newOrder = orderRepository.save(o);
			returnList.add(newOrder);

			} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return returnList;
	}
}
