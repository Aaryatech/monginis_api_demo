package com.ats.webapi.service.tray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.TrayMgtDetailList;
import com.ats.webapi.model.route.RouteMgmt;
import com.ats.webapi.model.route.RouteMgmtRepo;
import com.ats.webapi.model.tray.FrOutTrays;
import com.ats.webapi.model.tray.FranchiseInRoute;
import com.ats.webapi.model.tray.GetInTrays;
import com.ats.webapi.model.tray.GetTrayMgtHeader;
import com.ats.webapi.model.tray.GetTrayMgtReport;
import com.ats.webapi.model.tray.TrayMgtDetail;
import com.ats.webapi.model.tray.TrayMgtDetailBean;
import com.ats.webapi.model.tray.TrayMgtHeader;
import com.ats.webapi.repository.tray.FrOutTrayRepository;
import com.ats.webapi.repository.tray.FranchiseInRouteRepository;
import com.ats.webapi.repository.tray.GetInTraysRepository;
import com.ats.webapi.repository.tray.GetTrayMgtHeaderRepository;
import com.ats.webapi.repository.tray.GetTrayMgtReportRepo;
import com.ats.webapi.repository.tray.TrayMgtDetailBeanRepository;
import com.ats.webapi.repository.tray.TrayMgtDetailRepository;
import com.ats.webapi.repository.tray.TrayMgtHeaderRepository;

@Service
public class TrayMgtServiceImpl implements TrayMgtService {

	@Autowired
	TrayMgtHeaderRepository trayMgtHeaderRepository;

	@Autowired
	TrayMgtDetailRepository trayMgtDetailRepository;

	@Autowired
	FrOutTrayRepository frOutTraysRepository;

	@Autowired
	GetTrayMgtHeaderRepository getTrayMgtHeaderRepository;

	@Autowired
	TrayMgtDetailBeanRepository trayMgtDetailBeanRepository;

	@Autowired
	FranchiseInRouteRepository franchiseInRouteRepository;
	@Autowired
	GetTrayMgtReportRepo getTrayMgtReportRepo;
	
	@Autowired
	GetInTraysRepository getInTraysRepository;
	@Override
	public TrayMgtHeader saveTrayMgtHeader(TrayMgtHeader trayMgtHeader) {

		TrayMgtHeader trayMgtHeaderRes = trayMgtHeaderRepository.saveAndFlush(trayMgtHeader);

		return trayMgtHeaderRes;
	}

	@Override
	public TrayMgtDetailBean saveTrayMgtDetail(TrayMgtDetailBean trayMgtDetail) {

		TrayMgtDetailBean trayMgtDetailsRes = trayMgtDetailBeanRepository.saveAndFlush(trayMgtDetail);

		return trayMgtDetailsRes;
	}

	@Override
	public List<FrOutTrays> getOutTraysForFr(int frId, String billDate) {

		List<FrOutTrays> frOutTrays;
		try {
			frOutTrays = frOutTraysRepository.findOutTrays(frId, billDate);
		} catch (Exception e) {
			frOutTrays = new ArrayList<>();
			e.printStackTrace();
		}
		return frOutTrays;
	}

	@Override
	public Info updateExtraOutTrays(int tranId, int extraOutTrays) {

		int isUpdated = trayMgtHeaderRepository.updateExtraOutTrays(tranId, extraOutTrays);
		Info info = new Info();
		if (isUpdated >= 1) {
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		} else {
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public List<GetTrayMgtHeader> getLoadedVehicles(String date, int vehStatus) {

		List<GetTrayMgtHeader> trayMgtHeaders;
		try {

			trayMgtHeaders = getTrayMgtHeaderRepository.getLoadedVehicles(date, vehStatus);
		} catch (Exception e) {
			trayMgtHeaders = new ArrayList<GetTrayMgtHeader>();
			e.printStackTrace();
		}
		return trayMgtHeaders;
	}

	@Override
	public Info updateVehicleOutData(int tranId, String vehOuttime, float vehOutKm) {

		int isUpdated = trayMgtHeaderRepository.updateVehicleOutData(tranId, vehOuttime, vehOutKm);
		int updateStatus = trayMgtDetailBeanRepository.updateTrayStatusByTranId(tranId, 1);

		Info info = new Info();
		if (isUpdated >= 1 && updateStatus >= 1) {
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		} else {
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public Info updateInVehicleData(int tranId, String vehIntime, float vehInkm, float vehRunningkm) {

		int isUpdated = trayMgtHeaderRepository.updateInVehicleData(tranId, vehIntime, vehInkm, vehRunningkm);
		Info info = new Info();
		if (isUpdated >= 1) {
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		} else {
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public List<FranchiseInRoute> getFranchiseInRoute(int routeId, int tranId) {

		List<FranchiseInRoute> frInRoute = null;
		try {
			frInRoute = franchiseInRouteRepository.findFrInRoute(routeId, tranId);
		} catch (Exception e) {
			frInRoute = new ArrayList<FranchiseInRoute>();
			e.printStackTrace();
		}
		return frInRoute;
	}

	@Autowired
	RouteMgmtRepo routeMgmtRepo;

	@Override
	public List<FranchiseInRoute> getFranchiseInRouteMgmt(int routeId, int tranId) {

		List<FranchiseInRoute> frInRoute = null;
		try {

			RouteMgmt routeMgmt = new RouteMgmt();

			routeMgmt = routeMgmtRepo.findByRouteTrayIdAndDelStatus(routeId, 0);

			List<Integer> frIdList = Stream.of(routeMgmt.getFrIds().split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());

			frInRoute = franchiseInRouteRepository.findFrInFranchisee(frIdList, tranId);
		} catch (Exception e) {
			frInRoute = new ArrayList<FranchiseInRoute>();
			e.printStackTrace();
		}
		return frInRoute;
	}

	@Override
	public TrayMgtDetail getTrayMgtDetailByFrId(int frId, int tranId) {

		TrayMgtDetail trayMgtDetailRes = trayMgtDetailRepository.findByFrIdAndTranIdAndDelStatus(frId, tranId, 0);
		return trayMgtDetailRes;
	}

	@Override
	public GetTrayMgtHeader getTrayMgtHeader(int tranId) {

		GetTrayMgtHeader trayMgtHeaderRes;
		try {

			trayMgtHeaderRes = getTrayMgtHeaderRepository.getTrayMgtHeader(tranId);
		} catch (Exception e) {
			trayMgtHeaderRes = new GetTrayMgtHeader();
			e.printStackTrace();
		}
		return trayMgtHeaderRes;
	}

	@Override
	public List<GetTrayMgtHeader> getTrayMgtHeaderByRouteId(int routeId) {

		List<GetTrayMgtHeader> trayMgtHeaderRes;
		try {

			trayMgtHeaderRes = getTrayMgtHeaderRepository.getTrayMgtHeaderByRouteId(routeId);
		} catch (Exception e) {
			trayMgtHeaderRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtHeaderRes;
	}

	@Override
	public Info updateDieselForTransaction(int tranId, float diesel) {
		int isUpdated = trayMgtHeaderRepository.updateDieselForTransaction(tranId, diesel);
		Info info = new Info();
		if (isUpdated >= 1) {
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		} else {
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public Info updateExtraInTrays(int tranId, int extraInTrays) {
		int isUpdated = trayMgtHeaderRepository.updateExtraInTrays(tranId, extraInTrays);
		Info info = new Info();
		if (isUpdated >= 1) {
			info.setError(false);
			info.setMessage("TrayMgtHeader Updated Successfully.");
		} else {
			info.setError(true);
			info.setMessage("TrayMgtHeader Updatation Failed.");
		}
		return info;
	}

	@Override
	public TrayMgtDetail getTrayDetailByStatus(int frId, int trayStatus, int isSameDay) {
		TrayMgtDetail trayMgtDetailRes;
		try {

			trayMgtDetailRes = trayMgtDetailRepository.findByFrIdAndTrayStatusAndIsSameDayAndDelStatus(frId, trayStatus,
					isSameDay, 0);
		} catch (Exception e) {
			trayMgtDetailRes = new TrayMgtDetail();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public TrayMgtDetailBean getTrayDetailByDetailId(int tranStatus3) {
		TrayMgtDetailBean trayMgtDetailRes;
		try {

			trayMgtDetailRes = trayMgtDetailBeanRepository.findByTranDetailId(tranStatus3);
		} catch (Exception e) {
			trayMgtDetailRes = new TrayMgtDetailBean();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public int updateTrayStatus(int tranStatus1, int status) {

		int isUpdated = trayMgtDetailBeanRepository.updateTrayStatus(tranStatus1, status);

		return isUpdated;
	}

	@Override
	public TrayMgtHeader getTrayMgtHeaderByTranId(int tranId) {

		TrayMgtHeader trayMgtHeaderRes = trayMgtHeaderRepository.findByTranId(tranId);

		return trayMgtHeaderRes;
	}

	@Override
	public List<TrayMgtDetail> getTrayMgtDetailByTranId(int tranId) {
		List<TrayMgtDetail> trayMgtDetailRes;
		try {

			trayMgtDetailRes = trayMgtDetailRepository.findByTranId(tranId);
		} catch (Exception e) {
			trayMgtDetailRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public List<TrayMgtDetail> getTrayDetailForTrayIn(int frId, int isSameDay) {
		List<TrayMgtDetail> trayMgtDetailRes;
		try {

			trayMgtDetailRes = trayMgtDetailRepository.findByFrIdAndIsSameDayAndDelStatusAndTrayStatusIn(frId,
					isSameDay, 0);
		} catch (Exception e) {
			trayMgtDetailRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public List<TrayMgtDetail> getTrayDetailForBalanceByFr(int frId) {
		List<TrayMgtDetail> trayMgtDetailRes;
		try {

			trayMgtDetailRes = trayMgtDetailRepository.findByFrIdAndDelStatus(frId, 0);
		} catch (Exception e) {
			trayMgtDetailRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public List<GetTrayMgtHeader> getAllVehicles(String date) {
		List<GetTrayMgtHeader> trayMgtHeaders;
		try {

			trayMgtHeaders = getTrayMgtHeaderRepository.getAllVehicles(date);
		} catch (Exception e) {
			trayMgtHeaders = new ArrayList<GetTrayMgtHeader>();
			e.printStackTrace();
		}
		return trayMgtHeaders;
	}

	@Override
	public List<TrayMgtDetail> getTrayMgtDetailsForBill() {
		List<TrayMgtDetail> trayMgtDetailRes;
		try {

			trayMgtDetailRes = trayMgtDetailRepository.getTrayMgtDetailsForBill();
		} catch (Exception e) {
			trayMgtDetailRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public List<TrayMgtDetailBean> saveTrayMgtDetailForBill(List<TrayMgtDetailBean> trayMgtDetails) {
		List<TrayMgtDetailBean> trayMgtDetailRes;
		try {

			trayMgtDetailRes = trayMgtDetailBeanRepository.save(trayMgtDetails);
		} catch (Exception e) {
			trayMgtDetailRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public List<TrayMgtDetail> getTrayMgtBillDetails(String fromDate, String toDate, List<String> frIds) {
		List<TrayMgtDetail> trayMgtDetailRes;
		try {
			if (frIds.contains("-1")) {
				trayMgtDetailRes = trayMgtDetailRepository.findTrayMgtBillDetailsByDate(fromDate, toDate);

			} else {

				trayMgtDetailRes = trayMgtDetailRepository.findTrayMgtBillDetailsByDateAndFr(fromDate, toDate, frIds);
			}
		} catch (Exception e) {
			trayMgtDetailRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public ErrorMessage deleteTrayMgtHeader(int tranId) {

		ErrorMessage errorMessage = new ErrorMessage();
		try {
			int updateStatus = trayMgtHeaderRepository.updateHeaderStatus(tranId);

			int updateDetailStatus = trayMgtDetailBeanRepository.updateDelStatus(tranId);

			if (updateStatus > 0 || updateDetailStatus > 0) {
				errorMessage = new ErrorMessage();
				errorMessage.setError(false);
				errorMessage.setMessage("Header with Details Deleted Successfully.");
			}
		} catch (Exception e) {
			errorMessage = new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("Header with Details Deletion Successfully.");
			e.printStackTrace();

		}
		return errorMessage;
	}

	@Override
	public List<GetTrayMgtHeader> getLoadedVehiclesByStatus(int vehStatus) {

		List<GetTrayMgtHeader> trayMgtHeaders;
		try {

			trayMgtHeaders = getTrayMgtHeaderRepository.getLoadedVehiclesByStatus(vehStatus);
		} catch (Exception e) {
			trayMgtHeaders = new ArrayList<GetTrayMgtHeader>();
			e.printStackTrace();
		}
		return trayMgtHeaders;
	}

	@Override
	public List<TrayMgtDetail> getTrayMgtDetailList(String fromDate, String toDate, int frId, int isDepositUsed) {
		List<TrayMgtDetail> trayMgtDetailRes;
		try {
			if (isDepositUsed <= 1) {
				trayMgtDetailRes = trayMgtDetailRepository.findAllTrayMgtBillDetails(fromDate, toDate, frId,
						isDepositUsed);

			} else {

				trayMgtDetailRes = trayMgtDetailRepository.findTrayMgtBillDetails(fromDate, toDate, frId);
			}
		} catch (Exception e) {
			trayMgtDetailRes = new ArrayList<>();
			e.printStackTrace();
		}
		return trayMgtDetailRes;
	}

	@Override
	public List<TrayMgtDetailList> getTrayMgtDetailsByTranIdAndDate(int tranId, String date) {
		List<TrayMgtDetail> trayMgtDetailRes;
		List<TrayMgtDetailList> trayMgtDetailList = new ArrayList<TrayMgtDetailList>();
		try {
			// String date=(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			trayMgtDetailRes = trayMgtDetailRepository.findByTranId(tranId);
			for (int i = 0; i < trayMgtDetailRes.size(); i++) {
				TrayMgtDetailList trayMgtDetail = new TrayMgtDetailList();

				List<TrayMgtDetail> trayDetailList = new ArrayList<TrayMgtDetail>();
				trayDetailList.add(trayMgtDetailRes.get(i));

				List<TrayMgtDetail> trayMgtDetails = trayMgtDetailRepository
						.findByIntrayDate(trayMgtDetailRes.get(i).getFrId(), date);
				trayDetailList.addAll(trayMgtDetails);

				trayMgtDetail.setFrId(trayMgtDetailRes.get(i).getFrId());
				trayMgtDetail.setTrayMgtDetailsList(trayDetailList);

				trayMgtDetailList.add(trayMgtDetail);
				System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
		} catch (Exception e) {
			trayMgtDetailList = new ArrayList<TrayMgtDetailList>();
			e.printStackTrace();
		}
		return trayMgtDetailList;
	}

	@Override
	public List<GetTrayMgtReport> getTrayMgtBalanceTrayList(int tranId, List<Integer> frIdList) {
		List<GetTrayMgtReport> getTrayMgtBalanceTrayList= getTrayMgtReportRepo.getTrayMgtBalanceTrayList(tranId, frIdList);;

		return getTrayMgtBalanceTrayList;
	}

	@Override
	public List<GetInTrays> getTrayMgtInTrayList(int tranId, List<Integer> frIdList) {
		List<GetInTrays> getTrayMgtInTrayList= getInTraysRepository.getTrayMgtInTrayList(tranId, frIdList);;

		return getTrayMgtInTrayList;
	}

}
