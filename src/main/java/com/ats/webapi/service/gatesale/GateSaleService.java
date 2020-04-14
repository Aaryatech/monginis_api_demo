package com.ats.webapi.service.gatesale;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.gatesale.GateEmployee;
import com.ats.webapi.model.gatesale.GateSaleBillHeader;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderRes;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderResp;
import com.ats.webapi.model.gatesale.GateSaleDiscList;
import com.ats.webapi.model.gatesale.GateSaleDiscount;
import com.ats.webapi.model.gatesale.GateSaleUser;
import com.ats.webapi.model.gatesale.GateSaleUserList;
import com.ats.webapi.model.gatesale.GetGateSaleEmp;
import com.ats.webapi.model.gatesale.GetGateSaleEmpList;
import com.ats.webapi.model.gatesale.OtherItem;
import com.ats.webapi.model.gatesale.OtherItemList;
import com.ats.webapi.model.gatesale.OtherSupplier;
import com.ats.webapi.model.gatesale.OtherSupplierList;

public interface GateSaleService {

	ErrorMessage saveGateSaleUser(GateSaleUser gateSaleUser);

	ErrorMessage deleteGateSaleUser(int userId);

	GateSaleUserList getGateSaleUserList();

	GateSaleUser getGateSaleUserByUserId(int userId);

	ErrorMessage saveGateSaleDiscount(GateSaleDiscount gateSaleDiscount);

	ErrorMessage deleteGateSaleDiscount(int discountId);

	GateSaleDiscList getGateSaleDiscList();

	GateSaleDiscount getGateSaleDiscByDiscId(int discountId);

	ErrorMessage saveGateEmployee(GateEmployee gateEmployee);

	ErrorMessage deleteGateEmployee(int empId);

	GetGateSaleEmpList getGateEmpList();

	GetGateSaleEmp getGateEmpByEmpId(int empId);

	GateSaleDiscList getGateSaleDiscListByCatId(int catId);

	GateSaleUser loginUser(String mobile, String password);

	ErrorMessage saveGateSaleBill(GateSaleBillHeader gateSaleBillHeader);

	List<GateSaleBillHeaderResp> gateBillHeaderAndDetails(String fromDate, String toDate, int isApproved,
			int approvedUserId, int amtIsCollected, int collectorUserId);

	ErrorMessage approveGetSaleBill(int billId, int isApproved, String approvedDate, int approvedUserId);

	ErrorMessage collectGetSaleAmt(String collectedDate, int collectedUserId);

	ErrorMessage updateUserToken(int userId, String token);

	ErrorMessage saveGateOtherSupplier(OtherSupplier otherSupplier);

	ErrorMessage saveGateOtherItem(OtherItem otherItem);

	ErrorMessage deleteGateOtherItem(int itemId);

	ErrorMessage deleteGateOtherSupplier(int suppId);

	OtherSupplierList getGateOtherSuppList();

	OtherItemList getGateOtherItemBySuppId(int suppId);

	OtherItem getGateOtherItemByItemId(int itemId);

	OtherSupplier getGateOtherSupplierBySuppId(int suppId);

	List<GateSaleBillHeaderRes> gateBillDetailsAmtPending();

	List<GateSaleDiscount> getGateSaleDiscByUsrType(int userType);

	ErrorMessage collectGetSaleAmtOfBill(String collectedDate, int collectedUserId, int amtIsCollected, List<Integer> billIds);

	List<GateSaleBillHeaderRes> gateBillDetailAmtPending(int isApproved, int amtIsCollected);

	List<GateSaleBillHeaderResp> gateBillHeaderAndDetailsByInitiator(String fromDate, String toDate, int isApproved,
			int initiatorUserId);

}
