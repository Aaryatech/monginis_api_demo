package com.ats.webapi.service.gatesale;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.gatesale.GateEmployee;
import com.ats.webapi.model.gatesale.GateSaleBillDetail;
import com.ats.webapi.model.gatesale.GateSaleBillDetailRes;
import com.ats.webapi.model.gatesale.GateSaleBillHeader;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderRes;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderResp;
import com.ats.webapi.model.gatesale.GateSaleDiscList;
import com.ats.webapi.model.gatesale.GateSaleDiscount;
import com.ats.webapi.model.gatesale.GateSaleUser;
import com.ats.webapi.model.gatesale.GateSaleUserList;
import com.ats.webapi.model.gatesale.GetGateSaleEmp;
import com.ats.webapi.model.gatesale.GetGateSaleEmpList;
import com.ats.webapi.model.gatesale.GetGateSaleUser;
import com.ats.webapi.model.gatesale.OtherItem;
import com.ats.webapi.model.gatesale.OtherItemList;
import com.ats.webapi.model.gatesale.OtherItemRes;
import com.ats.webapi.model.gatesale.OtherSupplier;
import com.ats.webapi.model.gatesale.OtherSupplierList;
import com.ats.webapi.repository.UpdateSeetingForPBRepo;
import com.ats.webapi.repository.gatesale.GateEmployeeRepository;
import com.ats.webapi.repository.gatesale.GateOtherItemRepository;
import com.ats.webapi.repository.gatesale.GateOtherItemResRepository;
import com.ats.webapi.repository.gatesale.GateOtherSupplierRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillDetailRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillDetailResRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillHeaderRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillHeaderResRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillHeaderRespRepo;
import com.ats.webapi.repository.gatesale.GateSaleDiscountRepository;
import com.ats.webapi.repository.gatesale.GateSaleRepository;
import com.ats.webapi.repository.gatesale.GateSaleUserListRepository;
import com.ats.webapi.repository.gatesale.GetGateEmployeeRepository;
@Service
public class GateSaleServiceImpl implements GateSaleService{

	@Autowired
	GateSaleRepository gateSaleUserRepository;
	
	@Autowired
	GateSaleUserListRepository gateSaleUserListRepository;
	
	@Autowired
	GateSaleDiscountRepository gateSaleDiscountRepository;
	
	@Autowired
	GateEmployeeRepository gateEmployeeRepository;
	
	@Autowired
	GetGateEmployeeRepository getGateEmployeeRepository;
	
	@Autowired
	GateSaleBillDetailRepository gateSaleBillDetailRepository;
	
	@Autowired
	GateSaleBillDetailResRepository gateSaleBillDetailsRepository;
	
	@Autowired
	GateSaleBillHeaderResRepository gateSaleBillHeaderResRepository;
	
	@Autowired
	GateSaleBillHeaderRepository gateSaleBillHeaderRepository;
	
	@Autowired
	GateOtherSupplierRepository gateOtherSupplierRepository;
	
	@Autowired
	GateOtherItemRepository gateOtherItemRepository;
	
	@Autowired
	GateOtherItemResRepository gateOtherItemResRepository;
	@Autowired
	UpdateSeetingForPBRepo updateSeetingForPBRepo;
	
	@Autowired
	GateSaleBillHeaderRespRepo gateSaleBillHeaderRespRepo;
	
	@Override
	public ErrorMessage saveGateSaleUser(GateSaleUser gateSaleUser) {

		ErrorMessage errorMessage=new ErrorMessage();

		try {
			GateSaleUser gateSaleUserRes=gateSaleUserRepository.save(gateSaleUser);
		
		if(gateSaleUserRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Gate Sale User.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate Sale User Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Gate Sale User.");
			return errorMessage;
		}
		return errorMessage;
		
		
	}

	@Override
	public ErrorMessage deleteGateSaleUser(int userId) {

    ErrorMessage errorMessage=new ErrorMessage();
		
		int isUpdated=gateSaleUserRepository.deleteGateSaleUser(userId);
	
		if(isUpdated==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("GateSaleUser Deleted Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleUser Deletion Failed");
			
		}
		return errorMessage;
	}

	@Override
	public GateSaleUserList getGateSaleUserList() {

		List<GetGateSaleUser> gateSaleUserListRes=gateSaleUserListRepository.findGateSaleUserByDelStatus(); 
		ErrorMessage errorMessage=new ErrorMessage();
		GateSaleUserList gateSaleUserList=new GateSaleUserList();

		if(gateSaleUserListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleUser List Not Found.");
			gateSaleUserList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleUser List Found Successfully.");
			
			gateSaleUserList.setErrorMessage(errorMessage);
			gateSaleUserList.setGateSaleUserList(gateSaleUserListRes);
			
		}
		return gateSaleUserList;
	}

	@Override
	public GateSaleUser getGateSaleUserByUserId(int userId) {

		GateSaleUser gateSaleUserRes=gateSaleUserRepository.findGateSaleUserByUserId(userId); 
		
		if(gateSaleUserRes==null)
		{
			gateSaleUserRes=new GateSaleUser();
			gateSaleUserRes.setError(true);
			gateSaleUserRes.setMessage("GateSaleUser Not Found");
			
		}
		else
		{
			gateSaleUserRes.setError(false);
			gateSaleUserRes.setMessage("GateSaleUser Found Successfully");
		}
		
		return gateSaleUserRes;
	}

	@Override
	public ErrorMessage saveGateSaleDiscount(GateSaleDiscount gateSaleDiscount) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
			GateSaleDiscount gateSaleDiscountRes=gateSaleDiscountRepository.save(gateSaleDiscount);
		
		if(gateSaleDiscountRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Gate Sale Discount.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate Sale Discount Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Gate Sale Discount.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteGateSaleDiscount(int discountId) {

	        ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleDiscountRepository.deleteGateSaleDiscount(discountId);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleDiscount Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GateSaleDiscount Deletion Failed");
				
			}
			return errorMessage;
	}

	@Override
	public GateSaleDiscList getGateSaleDiscList() {
		
		List<GateSaleDiscount> gateSaleDiscListRes=gateSaleDiscountRepository.findGateSaleDiscountByDelStatus(0); 
		ErrorMessage errorMessage=new ErrorMessage();
		GateSaleDiscList gateSaleDiscList=new GateSaleDiscList();

		if(gateSaleDiscListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleDiscount List Not Found.");
			gateSaleDiscList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleDiscount List Found Successfully.");
			
			gateSaleDiscList.setErrorMessage(errorMessage);
			gateSaleDiscList.setGateSaleDiscountList(gateSaleDiscListRes);
			
		}
		return gateSaleDiscList;
	}

	@Override
	public GateSaleDiscount getGateSaleDiscByDiscId(int discountId) {

		GateSaleDiscount gateSaleDiscRes=gateSaleDiscountRepository.findGateSaleDiscountByDiscountId(discountId); 
		
		if(gateSaleDiscRes==null)
		{
			gateSaleDiscRes=new GateSaleDiscount();
			gateSaleDiscRes.setError(true);
			gateSaleDiscRes.setMessage("GateSaleDiscount Not Found");
			
		}
		else
		{
			gateSaleDiscRes.setError(false);
			gateSaleDiscRes.setMessage("GateSaleDiscount Found Successfully");
		}
		
		return gateSaleDiscRes;
	}

	@Override
	public ErrorMessage saveGateEmployee(GateEmployee gateEmployee) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
			GateEmployee gateEmployeeRes=gateEmployeeRepository.save(gateEmployee);
		
		if(gateEmployeeRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save Employee.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Employee Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save Employee.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteGateEmployee(int empId) {
		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateEmployeeRepository.deleteGateEmployee(empId);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GateEmployee Deleted Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GateEmployee Deletion Failed");
				
			}
			return errorMessage;
	}

	@Override
	public GetGateSaleEmpList getGateEmpList() {
	
		     Date today = new Date();  

	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(today);  

	        calendar.add(Calendar.MONTH, 1);  
	        calendar.set(Calendar.DAY_OF_MONTH, 1);  
	        calendar.add(Calendar.DATE, -1);  

	        Date lastDayOfMonth = calendar.getTime();  
	        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));  

		List<GetGateSaleEmp> gateEmpListRes=getGateEmployeeRepository.getGateEmpList(sdf.format(lastDayOfMonth)); 
		ErrorMessage errorMessage=new ErrorMessage();
		GetGateSaleEmpList getGateSaleEmpList=new GetGateSaleEmpList();

		if(gateEmpListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Gate Employee List Not Found.");
			getGateSaleEmpList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate Employee List Found Successfully.");
			
			getGateSaleEmpList.setErrorMessage(errorMessage);
			getGateSaleEmpList.setGetGateSaleEmpList(gateEmpListRes);
			
		}
		return getGateSaleEmpList;
	}

	@Override
	public GetGateSaleEmp getGateEmpByEmpId(int empId) {
		GetGateSaleEmp getGateSaleEmpRes=getGateEmployeeRepository.getGateEmpByEmpId(empId); 
		
		if(getGateSaleEmpRes==null)
		{
			getGateSaleEmpRes=new GetGateSaleEmp();
			getGateSaleEmpRes.setError(true);
			getGateSaleEmpRes.setMessage("Gate Employee Not Found");
			
		}
		else
		{
			getGateSaleEmpRes.setError(false);
			getGateSaleEmpRes.setMessage("Gate Employee Found Successfully");
		}
		
		return getGateSaleEmpRes; 
	}

	@Override
	public GateSaleDiscList getGateSaleDiscListByCatId(int catId) {
	
		List<GateSaleDiscount> gateSaleDiscListRes=gateSaleDiscountRepository.findGateSaleDiscountByCatIdAndDelStatus(catId,0); 
		ErrorMessage errorMessage=new ErrorMessage();
		GateSaleDiscList gateSaleDiscList=new GateSaleDiscList();

		if(gateSaleDiscListRes==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleDiscount List Not Found.");
			gateSaleDiscList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("GateSaleDiscount List Found Successfully.");
			
			gateSaleDiscList.setErrorMessage(errorMessage);
			gateSaleDiscList.setGateSaleDiscountList(gateSaleDiscListRes);
			
		}
		return gateSaleDiscList;
	}

	@Override
	public GateSaleUser loginUser(String mobile, String password) {

		GateSaleUser gateSaleUserRes=gateSaleUserRepository.findGateSaleUserByMobileNumberAndPassword(mobile,password); 
		
		if(gateSaleUserRes==null)
		{
			gateSaleUserRes=new GateSaleUser();
			gateSaleUserRes.setError(true);
			gateSaleUserRes.setMessage("Invalid Credentials");
			
		}
		else
		{
			gateSaleUserRes.setError(false);
			gateSaleUserRes.setMessage("Login Successful");
		}
		
		return gateSaleUserRes;
	}

	@Override
	public ErrorMessage saveGateSaleBill(GateSaleBillHeader gateSaleBillHeader) {
         
		GateSaleBillHeader gateSaleBillHeaderRes=gateSaleBillHeaderRepository.saveAndFlush(gateSaleBillHeader);
		ErrorMessage errorMessage=new ErrorMessage();
try {
			int initiatorUserType=gateSaleBillHeaderRepository.findUserTypeById(gateSaleBillHeader.getInitiatorUserId());
		if(gateSaleBillHeaderRes!=null)
		{
		 int billId=gateSaleBillHeaderRes.getBillId();
		 for(GateSaleBillDetail gateSaleBillDetail:gateSaleBillHeader.getGateSaleBillDetailList())
		 {
			gateSaleBillDetail.setBillId(billId);
			GateSaleBillDetail gateSaleBillDetailRes=gateSaleBillDetailRepository.saveAndFlush(gateSaleBillDetail);
			
		 }
		 errorMessage.setError(false);
		 errorMessage.setMessage("GateSaleBill Inserted Successfully.");
         int isUpdated=updateSeetingForPBRepo.updateSettingValue();

		 List<String> userTokens=gateSaleBillHeaderRepository.findUserTokensByBillId();
		
		 if(initiatorUserType==1)
		 {
		    if(gateSaleBillHeaderRes.getCategory()!=1&&gateSaleBillHeaderRes.getCategory()!=6)
		    {	
		     try {
		    	 for(String approverToken:userTokens)
		    	 {
		          Firebase.sendPushNotification(approverToken,"hsdd","ahjhfda",1);
		    	 }
		         }
		         catch(Exception e)
		         {
			       e.printStackTrace();
		         }
		    }
		 }
	   }
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleBill Insertion Failed.");
		}
	}catch(Exception e)
	{       e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("GateSaleBill Insertion Failed.Exc");
	}
		return errorMessage;
}

	@Override
	public List<GateSaleBillHeaderResp> gateBillHeaderAndDetails(String fromDate, String toDate, int isApproved,
			int approvedUserId, int amtIsCollected, int collectorUserId) {
		List<GateSaleBillHeaderResp> gateSaleBillHeaderRes=new ArrayList<GateSaleBillHeaderResp>();
		
		if(isApproved==2&&approvedUserId!=0&amtIsCollected==2&collectorUserId==0)
			{
				gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findAmtIsCollectedAndByBillDateBetween(2,fromDate,toDate);
				for(int i=0;i<gateSaleBillHeaderRes.size();i++)
				{
				List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
				gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
				}
			}
		 else
		 if(isApproved==1&&approvedUserId==0&amtIsCollected==0&collectorUserId==0)
		{
			gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findGateSaleBillHeaderResByIsApproved(isApproved);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}
		else if(isApproved==2&&approvedUserId!=0&amtIsCollected==0&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndApprovedUserIdAndBillDateBetween(2,approvedUserId,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}else if(isApproved>1&&approvedUserId==0&amtIsCollected==0&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndBillDateBetween(isApproved,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}
		else if(isApproved==3&&approvedUserId!=0&amtIsCollected==0&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndApprovedUserIdAndBillDateBetween(3,approvedUserId,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}else if(isApproved==2&&approvedUserId!=0&amtIsCollected==1&collectorUserId==0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndAmtIsCollected(isApproved,amtIsCollected);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}else if(isApproved==2&&approvedUserId!=0&amtIsCollected==2&collectorUserId!=0)
		{

			 gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findByIsApprovedAndAmtIsCollectedAndCollectedUserIdAndBillDateBetween(isApproved,amtIsCollected,collectorUserId,fromDate,toDate);
			for(int i=0;i<gateSaleBillHeaderRes.size();i++)
			{
			List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
			gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
			}
		}
		
		return gateSaleBillHeaderRes;
	}

	@Override
	public ErrorMessage approveGetSaleBill(int billId, int isApproved, String approvedDate, int approvedUserId) {

		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleBillHeaderRepository.approveGetSaleBill(billId,isApproved,approvedDate,approvedUserId);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GetSaleBill updated Successfully");
			
			String userToken=gateSaleBillHeaderRepository.findUserTokenByBillId(billId);
			
			if(isApproved==2)
			{
			try {
				Firebase.sendPushNotification(userToken, "Approved", "hfbsffgggggggggggggggggggdaffrsfrfsfs",2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			else if(isApproved==3)
			{
				try {
					Firebase.sendPushNotification(userToken, "Rejected", "Approved",3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GetSaleBill updation Failed");
				
			}
			return errorMessage;
		
	}

	@Override
	public ErrorMessage collectGetSaleAmt(String collectedDate, int collectedUserId) {

		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleBillHeaderRepository.updateCollectGetSaleAmt(collectedDate,collectedUserId);
		
			if(isUpdated>0) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GetSaleBill updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GetSaleBill updation Failed");
				
			}
			return errorMessage;
		
	}

	@Override
	public ErrorMessage updateUserToken(int userId, String token) {

		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleUserRepository.updateUserToken(userId,token);
		
			if(isUpdated==1) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("User Token Updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("User Token updation Failed");
				
			}
			return errorMessage;
		
	}

	@Override
	public ErrorMessage saveGateOtherSupplier(OtherSupplier otherSupplier) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
			OtherSupplier otherSupplierRes=gateOtherSupplierRepository.saveAndFlush(otherSupplier);
		
		if(otherSupplierRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save OtherSupplier.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("OtherSupplier Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save OtherSupplier.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage saveGateOtherItem(OtherItem otherItem) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
			OtherItem otherItemRes=gateOtherItemRepository.saveAndFlush(otherItem);
		
		if(otherItemRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed To Save otherItem.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("otherItem Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Exception:Failed To Save otherItem.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteGateOtherItem(int itemId) {
	    ErrorMessage errorMessage=new ErrorMessage();
		
				int isUpdated=gateOtherItemRepository.deleteGateOtherItem(itemId);
			
				if(isUpdated==1) {
				
				errorMessage.setError(false);
				errorMessage.setMessage("GateOtherItem Deleted Successfully");
				}
				else
				{
					errorMessage.setError(false);
					errorMessage.setMessage("GateOtherItem Deletion Failed");
					
				}
				return errorMessage;
	}

	@Override
	public ErrorMessage deleteGateOtherSupplier(int suppId) {
	    ErrorMessage errorMessage=new ErrorMessage();
		
				int isUpdated=gateOtherSupplierRepository.deleteGateOtherSupplier(suppId);
			
				if(isUpdated==1) {
				
				errorMessage.setError(false);
				errorMessage.setMessage("GateOtherSupplier Deleted Successfully");
				}
				else
				{
					errorMessage.setError(false);
					errorMessage.setMessage("GateOtherSupplier Deletion Failed");
					
				}
				return errorMessage;
	}

	@Override
	public OtherSupplierList getGateOtherSuppList() {
		
		List<OtherSupplier> otherSupplierRes=gateOtherSupplierRepository.findOtherSupplierByDelStatus(0); 
		ErrorMessage errorMessage=new ErrorMessage();
		OtherSupplierList otherSupplierList=new OtherSupplierList();

		if(otherSupplierRes.isEmpty()) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Gate OtherSupplier List Not Found.");
			otherSupplierList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate OtherSupplier List Found Successfully.");
			
			otherSupplierList.setErrorMessage(errorMessage);
			otherSupplierList.setOtherSupplierList(otherSupplierRes);
			
		}
		return otherSupplierList;
		
	}

	@Override
	public OtherItemList getGateOtherItemBySuppId(int suppId) {

		List<OtherItemRes> otherItemRes=gateOtherItemResRepository.findOtherItemByDelStatusAndSuppId(0,suppId); 
		ErrorMessage errorMessage=new ErrorMessage();
		OtherItemList otherItemList=new OtherItemList();

		if(otherItemRes.isEmpty()) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Gate OtherItem List Not Found.");
			otherItemList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Gate OtherItem List Found Successfully.");
			
			otherItemList.setErrorMessage(errorMessage);
			otherItemList.setOtherItemList(otherItemRes);
			
		}
		return otherItemList;
	}

	@Override
	public OtherItem getGateOtherItemByItemId(int itemId) {
		OtherItem otherItemRes=gateOtherItemRepository.findOtherItemByItemId(itemId); 
		
		if(otherItemRes==null)
		{
			otherItemRes=new OtherItem();
			otherItemRes.setError(true);
			otherItemRes.setMessage("Gate OtherItem Not Found");
			
		}
		else
		{
			otherItemRes.setError(false);
			otherItemRes.setMessage("Gate OtherItem Found Successfully");
		}
		
		return otherItemRes; 

	}

	@Override
	public OtherSupplier getGateOtherSupplierBySuppId(int suppId) {
		OtherSupplier getGateOtherSupplierRes=gateOtherSupplierRepository.findOtherSupplierBySuppId(suppId); 
		
		if(getGateOtherSupplierRes==null)
		{
			getGateOtherSupplierRes=new OtherSupplier();
			getGateOtherSupplierRes.setError(true);
			getGateOtherSupplierRes.setMessage("Gate OtherSupplier Not Found");
			
		}
		else
		{
			getGateOtherSupplierRes.setError(false);
			getGateOtherSupplierRes.setMessage("Gate OtherSupplier Found Successfully");
		}
		
		return getGateOtherSupplierRes; 
		

	}

	@Override
	public List<GateSaleBillHeaderRes> gateBillDetailsAmtPending() {
		List<GateSaleBillHeaderRes> gateSaleBillHeaderRes=gateSaleBillHeaderRespRepo.findByIsApprovedAndAmtIsCollectedAndDelStatus(2,1,0);
		for(int i=0;i<gateSaleBillHeaderRes.size();i++)
		{
		List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
		gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
		}
		
		return gateSaleBillHeaderRes;
	}
	@Override
	public List<GateSaleBillHeaderRes> gateBillDetailAmtPending(int isApproved,int amtIsCollected) {
		List<GateSaleBillHeaderRes> gateSaleBillHeaderRes=gateSaleBillHeaderRespRepo.findByIsApprovedAndAmtIsCollectedAndDelStatus(isApproved,amtIsCollected,0);
		for(int i=0;i<gateSaleBillHeaderRes.size();i++)
		{
		List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
		gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
		}
		
		return gateSaleBillHeaderRes;
	}
	@Override
	public List<GateSaleDiscount> getGateSaleDiscByUsrType(int userType) {
		
		List<GateSaleDiscount> gateSaleDiscRes=null;
		try {
		 gateSaleDiscRes=gateSaleDiscountRepository.findGateSaleDiscountByUserTypeAndDelStatus(userType,0); 
		
		if(gateSaleDiscRes==null)
		{
			gateSaleDiscRes=new ArrayList<>();
			
		}
		}catch(Exception e)
		{
			gateSaleDiscRes=new ArrayList<>();
			e.printStackTrace();
		}
		
		return gateSaleDiscRes;
	}

	@Override
	public ErrorMessage collectGetSaleAmtOfBill(String collectedDate, int collectedUserId, int amtIsCollected,
			List<Integer> billIds) {
		 ErrorMessage errorMessage=new ErrorMessage();
			
			int isUpdated=gateSaleBillHeaderRepository.updateCollectGetSaleAmtOfBill(collectedDate,collectedUserId,amtIsCollected,billIds);
		
			if(isUpdated>0) {
			
			errorMessage.setError(false);
			errorMessage.setMessage("GetSaleBill updated Successfully");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("GetSaleBill updation Failed");
				
			}
			return errorMessage;
		
	}

	@Override
	public List<GateSaleBillHeaderResp> gateBillHeaderAndDetailsByInitiator(String fromDate, String toDate,
			int isApproved, int initiatorUserId) {
		
	List<GateSaleBillHeaderResp> gateSaleBillHeaderRes=new ArrayList<GateSaleBillHeaderResp>();
		
		if(isApproved==1&&initiatorUserId!=0)
			{
				gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findHeaderByInitiatorId(isApproved,initiatorUserId);
				for(int i=0;i<gateSaleBillHeaderRes.size();i++)
				{
				List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
				gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
				}
			}
		else {
				gateSaleBillHeaderRes=gateSaleBillHeaderResRepository.findHeaderByInitiatorIdAndDate(isApproved,initiatorUserId,fromDate,toDate);
				for(int i=0;i<gateSaleBillHeaderRes.size();i++)
				{
				List<GateSaleBillDetailRes> gateSaleBillDetailList=gateSaleBillDetailsRepository.findGateSaleBillDetailByBillId(gateSaleBillHeaderRes.get(i).getBillId());
				gateSaleBillHeaderRes.get(i).setGateSaleBillDetailList(gateSaleBillDetailList);
				}
		}
		
		return gateSaleBillHeaderRes;
	}

}
