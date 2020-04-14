package com.ats.webapi.service;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.FrItemStockConfigureList;
import com.ats.webapi.model.PostBillDetail;
import com.ats.webapi.model.PostBillHeader;
import com.ats.webapi.model.bill.Company;
import com.ats.webapi.repository.CompanyRepository;
import com.ats.webapi.repository.FrItemStockConfigureRepository;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.PostBillDetailRepository;
import com.ats.webapi.repository.PostBillHeaderRepository;
import com.ats.webapi.repository.RegularSpCkOrderRepository;
import com.ats.webapi.repository.SpCakeOrdersRepository;
import com.ats.webapi.repository.UpdateBillDetailForGrnGvnRepository;
import com.ats.webapi.repository.UpdateSeetingForPBRepo;

@Service
public class PostBillDataServiceImpl implements PostBillDataService {

	@Autowired
	PostBillHeaderRepository postBillHeaderRepository;

	@Autowired
	PostBillDetailRepository postBillDetailRepository;

	@Autowired
	OrderRepository orderRepository;
 
	@Autowired
	SpCakeOrdersRepository spCakeOrdersRepository;
	
	@Autowired
	RegularSpCkOrderRepository  regularSpCkOrderRepository;
	
	
	@Autowired
	UpdateBillDetailForGrnGvnRepository updateBillDetailForGrnGvnRepository;
	
	@Autowired//added here on 3 march
	UpdateSeetingForPBRepo updateSeetingForPBRepo;
	
	@Autowired// added here 3 march
	FrItemStockConfigureRepository frItemStockConfRepo;

	
	
	/*
	 * @Override public List<PostBillDetail> saveBillDetails(List<PostBillDetail>
	 * postBillDetail) {
	 * 
	 * List<PostBillDetail> billDetail=new ArrayList<PostBillDetail>();
	 * for(PostBillDetail pBDetails:postBillDetail) {
	 * 
	 * billDetail=postBillDataService.saveBillDetails(postBillDetail);
	 * 
	 * }
	 * 
	 * return billDetail; }
	 */
	@Autowired
	CompanyRepository companyRepository;
	@Override
	public List<PostBillHeader> saveBillHeader(List<PostBillHeader> postBillHeader) {
		
		List<PostBillHeader> pbHeaderList=new ArrayList<>();
		
		PostBillHeader postBillHeaders = new PostBillHeader();
		for (int i = 0; i < postBillHeader.size(); i++) {
			String invoiceNo = null;
			int settingValue=0;
			Company company=new Company();
			try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(postBillHeader.get(i).getBillDate());
		
			 company=companyRepository.findByBillDate(date);
			
			invoiceNo=company.getExVar4();
			//settingValue=Integer.parseInt(company.getExVar5());
			}catch (Exception e) {
				// TODO: handle exception
			}
            settingValue=frItemStockConfRepo.findBySettingKey("PB");
			
			System.out.println("Setting Value Received " + settingValue);
	

			int length = String.valueOf(settingValue).length();
			
			invoiceNo =invoiceNo+""+String.format("%06d" , settingValue);

			/*if (length == 1)
			{
				invoiceNo =invoiceNo+"/0000"+settingValue;
			}
			else
			if (length == 2)
			{

				invoiceNo =invoiceNo+"/000"+settingValue;
			}else
			if (length == 3)
			{
				invoiceNo =invoiceNo+"/00"+settingValue; 
			}else
			if (length == 4)
			{
				invoiceNo =invoiceNo+"/0"+settingValue;
			}
			else
			{

				invoiceNo =invoiceNo+"/"+settingValue;
			}
*/
			System.out.println(invoiceNo+"*** settingValue= " + settingValue);
			
			
			postBillHeader.get(i).setInvoiceNo(invoiceNo);
			

			postBillHeaders = postBillHeaderRepository.save(postBillHeader.get(i));
			
			if(postBillHeaders!=null && postBillHeaders.getBillNo()>0 ) {
				
				settingValue=settingValue+1;
				int result = updateSeetingForPBRepo.updateSeetingForPurBill(settingValue, "PB");

				System.err.println("PB setting value updated "+ result);
				
			}

			int billNo = postBillHeader.get(i).getBillNo();

			List<PostBillDetail> postBillDetailList = postBillHeader.get(i).getPostBillDetailsList();

			for (int j = 0; j < postBillDetailList.size(); j++) {

				PostBillDetail billDetail = postBillDetailList.get(j);

				billDetail.setBillNo(billNo);
				
				
				if(billDetail.getOrderQty()==0) {
					
					System.out.println("order qty 0 received ");
					
					int  updateOrderStatus = orderRepository.updateBillStatus(billDetail.getOrderId(), 1);
					
				}
				
				else {

				postBillDetailRepository.save(billDetail);
				
				int res=0;
				if (billDetail.getCatId() != 5) { 
					
					if(billDetail.getMenuId()!= 42 && billDetail.getMenuId()!= 80 && billDetail.getMenuId()!= 30) {
						
					 res = orderRepository.updateBillStatus(billDetail.getOrderId(), 2);
					
					}else { // regular sp cake
						regularSpCkOrderRepository.updateRegSpCakeBillStatus(billDetail.getOrderId(), 2);
					}
					
				} else if (billDetail.getCatId() == 5){ //special cake
					 res = spCakeOrdersRepository.updateSpBillStatus(billDetail.getOrderId(), 2);
				}
				
				

				System.out.println("Result set for" + billDetail.getOrderId() + " status " + res);

			}
			// postBillDetail.get(i).setBillNo(billNo);
			// postBillDetailRepository.save(postBillDetail);

		}
			pbHeaderList.add(postBillHeaders);
		}

		return pbHeaderList;
	}




	@Override
	public List<PostBillHeader> updateBillHeader(List<PostBillHeader> postBillHeader) {
		
		
		List<PostBillHeader> postBillHeaders = new ArrayList<PostBillHeader>();
		for (int i = 0; i < postBillHeader.size(); i++) {

			postBillHeaders = postBillHeaderRepository.save(postBillHeader);

			int billNo = postBillHeader.get(i).getBillNo();

			List<PostBillDetail> postBillDetailList = postBillHeader.get(i).getPostBillDetailsList();

			for (int j = 0; j < postBillDetailList.size(); j++) {

				PostBillDetail billDetail = postBillDetailList.get(j);

				billDetail.setBillNo(billNo);

				postBillDetailRepository.save(billDetail);
				
	           if (billDetail.getCatId() != 5) { 
					
					if(billDetail.getMenuId()!= 42 && billDetail.getMenuId()!= 80 && billDetail.getMenuId()!= 30) {//item
						
					    orderRepository.updateBillStatus(billDetail.getOrderId(), 2);
					
					}else { // regular sp cake
						regularSpCkOrderRepository.updateRegSpCakeBillStatus(billDetail.getOrderId(), 2);
					}
					
				}
			}
			// postBillDetail.get(i).setBillNo(billNo);
			// postBillDetailRepository.save(postBillDetail);

		}

		return postBillHeaders;
		
		
	}

}
