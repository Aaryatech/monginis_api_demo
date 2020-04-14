package com.ats.webapi.service.tray;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.TrayMgtDetailList;
import com.ats.webapi.model.tray.FrOutTrays;
import com.ats.webapi.model.tray.FranchiseInRoute;
import com.ats.webapi.model.tray.GetInTrays;
import com.ats.webapi.model.tray.GetTrayMgtHeader;
import com.ats.webapi.model.tray.GetTrayMgtReport;
import com.ats.webapi.model.tray.TrayMgtDetail;
import com.ats.webapi.model.tray.TrayMgtDetailBean;
import com.ats.webapi.model.tray.TrayMgtHeader;

@Service
public interface TrayMgtService {

	TrayMgtHeader saveTrayMgtHeader(TrayMgtHeader trayMgtHeader);

	TrayMgtDetailBean saveTrayMgtDetail(TrayMgtDetailBean trayMgtDetails);


	List<FrOutTrays> getOutTraysForFr(int frId, String billDate);

	Info updateExtraOutTrays(int tranId, int extraOutTrays);


	Info updateVehicleOutData(int tranId, String vehOuttime, float vehOutKm);

	Info updateInVehicleData(int tranId, String vehIntime, float vehInkm, float vehRunningkm);


	TrayMgtDetail getTrayMgtDetailByFrId(int frId, int tranId);

	GetTrayMgtHeader getTrayMgtHeader(int tranId);

	List<GetTrayMgtHeader> getLoadedVehicles(String date, int vehStatus);

	Info updateDieselForTransaction(int tranId, float diesel);

	Info updateExtraInTrays(int tranId, int extraInTrays);

	TrayMgtDetail getTrayDetailByStatus(int frId, int trayStatus, int isSameDay);

	TrayMgtDetailBean getTrayDetailByDetailId(int tranStatus3);

	int updateTrayStatus(int tranStatus1,int status);

	TrayMgtHeader getTrayMgtHeaderByTranId(int tranId);

	List<TrayMgtDetail> getTrayMgtDetailByTranId(int tranId);

	List<TrayMgtDetail> getTrayDetailForTrayIn(int frId, int isSameDay);

	List<GetTrayMgtHeader> getAllVehicles(String date);

	List<FranchiseInRoute> getFranchiseInRoute(int routeId, int tranId);

	List<TrayMgtDetail> getTrayMgtDetailsForBill();

	List<TrayMgtDetailBean> saveTrayMgtDetailForBill(List<TrayMgtDetailBean> trayMgtDetails);

	List<TrayMgtDetail> getTrayMgtBillDetails(String fromDate, String toDate, List<String> frIds);

	ErrorMessage deleteTrayMgtHeader(int tranId);

	List<GetTrayMgtHeader> getLoadedVehiclesByStatus(int vehStatus);

	List<TrayMgtDetail> getTrayMgtDetailList(String fromDate, String toDate, int frId, int isDepositUsed);

//	List<TrayMgtDetailList> getTrayMgtDetailsByTranId(int tranId);

	List<TrayMgtDetailList> getTrayMgtDetailsByTranIdAndDate(int tranId, String date);
	
	List<FranchiseInRoute> getFranchiseInRouteMgmt(int routeId, int tranId);
	
	
	List<TrayMgtDetail> getTrayDetailForBalanceByFr(int frId);
	
	
	List<GetTrayMgtHeader> getTrayMgtHeaderByRouteId(int routeId);

	List<GetTrayMgtReport> getTrayMgtBalanceTrayList(int tranId, List<Integer> frIdList);

	List<GetInTrays> getTrayMgtInTrayList(int tranId, List<Integer> frIdList);
}
