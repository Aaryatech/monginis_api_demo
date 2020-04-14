package com.ats.webapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetOrderDataForPushOrder;
import com.ats.webapi.model.GetOrderDataForPushOrderList;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.GetOrderDataForPushOrderRepo;

@Service
public class GetOrderDataForPushOrderServiceImpl implements GetOrderDataForPushOrderService {

	@Autowired
	GetOrderDataForPushOrderRepo getOrderDataForPushOrderRepo;

	@Override
	public GetOrderDataForPushOrderList getOrderDataForPushOrder(Date cDate, int grnType, List<String> frIdList) {

		GetOrderDataForPushOrderList getOrderDataForPushOrderList = new GetOrderDataForPushOrderList();
		Info info = new Info();

		try {
			List<GetOrderDataForPushOrder> orderData = getOrderDataForPushOrderRepo.getOrderData(cDate, grnType,
					frIdList);

			if (!orderData.isEmpty()) {

				getOrderDataForPushOrderList.setOrderDataForPushOrder(orderData);
				info.setError(false);
				info.setMessage("order data received successfully. size= "+orderData.size());

			} else {

				info.setError(true);
				info.setMessage("Error: order data not received ");

			}

			getOrderDataForPushOrderList.setInfo(info);

		} catch (Exception e) {
			
			System.out.println("Exce in getting Order Data for Push Order " + e.getMessage());
			e.printStackTrace();

		}

		return getOrderDataForPushOrderList;

	}

}
