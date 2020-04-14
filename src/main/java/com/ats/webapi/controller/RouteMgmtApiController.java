package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.calculatetray.CalCulateTray;
import com.ats.webapi.model.calculatetray.CalculateTrayRepo;
import com.ats.webapi.model.route.GetRouteMgmt;
import com.ats.webapi.model.route.GetRouteMgmtRepo;
import com.ats.webapi.model.route.RouteMgmt;
import com.ats.webapi.model.route.RouteMgmtRepo;
import com.ats.webapi.model.route.RouteTime;
import com.ats.webapi.model.route.RouteTimeRepo;
import com.ats.webapi.model.tally.Franchisee;
import com.ats.webapi.model.tally.GetFranchiseeList;
import com.ats.webapi.repository.tally.TallyFranchiseeRepository;

@RestController
public class RouteMgmtApiController {

	@Autowired
	RouteMgmtRepo routeMgmtRepo;

	@Autowired
	GetRouteMgmtRepo getRouteMgmtRepo;

	@Autowired
	TallyFranchiseeRepository tallyFranchiseeRepository;

	@Autowired
	CalculateTrayRepo calculateTrayRepo;

	@Autowired
	RouteTimeRepo routeTimeRepo;

	@RequestMapping(value = { "/getAllRouteMgmtTimeList" }, method = RequestMethod.GET)
	public @ResponseBody List<RouteTime> getAllRouteMgmtTimeList() {

		List<RouteTime> routeList = new ArrayList<RouteTime>();

		try {

			routeList = routeTimeRepo.findByDelStatus(0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeList;

	}

	@RequestMapping(value = { "/getRouteTimeByTimeRouteId" }, method = RequestMethod.POST)
	public @ResponseBody RouteTime getRouteTimeByTimeRouteId(@RequestParam("timeRouteId") int timeRouteId) {
		System.out.println("timeRouteId" + timeRouteId);

		RouteTime routeMgmt = new RouteTime();

		try {
			routeMgmt = routeTimeRepo.findByTimeRouteIdAndDelStatus(timeRouteId, 0);
			System.out.println("routeMgmt" + routeMgmt.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeMgmt;

	}

	// --------------------------------------Route Mgmt-------------------------

	@RequestMapping(value = { "/saveRouteManagement" }, method = RequestMethod.POST)
	public @ResponseBody RouteMgmt saveRouteManagement(@RequestBody RouteMgmt routeMgmt) {

		RouteMgmt res = new RouteMgmt();

		try {

			res = routeMgmtRepo.saveAndFlush(routeMgmt);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllRouteMgmtList" }, method = RequestMethod.GET)
	public @ResponseBody List<RouteMgmt> getAllRouteMgmtList() {

		List<RouteMgmt> routeList = new ArrayList<RouteMgmt>();

		try {

			routeList = routeMgmtRepo.findByDelStatusAndIsActive(0, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeList;

	}

	@RequestMapping(value = { "/getAllRouteMgmtListByDelType" }, method = RequestMethod.POST)
	public @ResponseBody List<RouteMgmt> getAllRouteMgmtListByDelType(@RequestParam("isSameDay") int isSameDay) {

		List<RouteMgmt> routeList = new ArrayList<RouteMgmt>();

		try {

			routeList = routeMgmtRepo.findByIsSameDayAndDelStatusAndIsActive(isSameDay, 0, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeList;

	}

	@RequestMapping(value = { "/getAllCalTrayReport" }, method = RequestMethod.POST)
	public @ResponseBody List<CalCulateTray> getAllCalTrayReport(@RequestParam("deliveryDate") String deliveryDate,
			@RequestParam("frIdList") List<Integer> frIdList, @RequestParam("menuIdList") List<Integer> menuIdList,
			@RequestParam("routeIdList") List<Integer> routeIdList) {

		List<CalCulateTray> list = new ArrayList<CalCulateTray>();

		try {

			System.out.println("frIdList" + frIdList);
			System.out.println("menuIdList" + menuIdList);
			System.out.println("routeIdList" + routeIdList);

			list = calculateTrayRepo.getCalculateTray(deliveryDate, frIdList, menuIdList, routeIdList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getFranByMultipleRouteTrayId" }, method = RequestMethod.POST)
	public @ResponseBody List<RouteMgmt> getFranByMultipleRouteTrayId(
			@RequestParam("routeIdList") List<Integer> routeIdList) {

		List<RouteMgmt> list = new ArrayList<RouteMgmt>();

		try {

			list = routeMgmtRepo.findByRouteTrayIdInAndDelStatus(routeIdList, 0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getFranByMultipleRouteTrayIdNew" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRouteMgmt> getFranByMultipleRouteTrayIdNew(
			@RequestParam("routeIdList") List<Integer> routeIdList) {

		List<GetRouteMgmt> list = new ArrayList<GetRouteMgmt>();

		try {

			list = getRouteMgmtRepo.getAllRouteMgmtByRouteIdList(routeIdList);
			List<Franchisee> franchiseeList = tallyFranchiseeRepository.findByIsTallySync();

			for (int i = 0; i < list.size(); i++) {

				List<GetFranchiseeList> frListNew = new ArrayList<GetFranchiseeList>();

				List<Integer> frIdList = Stream.of(list.get(i).getFrIds().split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());

				franchiseeList = tallyFranchiseeRepository.getFranchisee(frIdList);

				String frName = "";

				for (int j = 0; j < franchiseeList.size(); j++) {

					frName = franchiseeList.get(j).getCustomerName() + "," + frName;

					for (int k = 0; k < frIdList.size(); k++) {

						if (franchiseeList.get(j).getCustomerId() == frIdList.get(k)) {
							GetFranchiseeList getFranchiseeList = new GetFranchiseeList();
							getFranchiseeList.setFrId(franchiseeList.get(j).getCustomerId());

							getFranchiseeList.setFrName(franchiseeList.get(j).getCustomerName());
							getFranchiseeList.setId(Integer.parseInt(
									list.get(i).getRouteTrayId() + "" + franchiseeList.get(j).getCustomerId()));

							frListNew.add(getFranchiseeList);
						}

					}

				}
				list.get(i).setGetFranchiseeList(frListNew);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}
	@RequestMapping(value = { "/getFranByRouteTrayId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetFranchiseeList> getFranByRouteTrayId(
			@RequestParam("routeId")int routeId) {

		List<GetFranchiseeList> list = new ArrayList<GetFranchiseeList>();

		try {

			GetRouteMgmt getRouteMgmt = getRouteMgmtRepo.findByRouteId(routeId);
			List<Franchisee> franchiseeList = tallyFranchiseeRepository.findByIsTallySync();


				List<Integer> frIdList = Stream.of(getRouteMgmt.getFrIds().split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());

				franchiseeList = tallyFranchiseeRepository.getFranchisee(frIdList);

				for (int j = 0; j < franchiseeList.size(); j++) {

					for (int k = 0; k < frIdList.size(); k++) {

						if (franchiseeList.get(j).getCustomerId() == frIdList.get(k)) {
							GetFranchiseeList getFranchiseeList = new GetFranchiseeList();
							getFranchiseeList.setFrId(franchiseeList.get(j).getCustomerId());

							getFranchiseeList.setFrName(franchiseeList.get(j).getCustomerName());
							getFranchiseeList.setId(Integer.parseInt(
									getRouteMgmt.getRouteTrayId() + "" + franchiseeList.get(j).getCustomerId()));

							list.add(getFranchiseeList);
						}

					}

				}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}
	@RequestMapping(value = { "/getRouteByRouteDetailId" }, method = RequestMethod.POST)
	public @ResponseBody RouteMgmt getRouteByRouteDetailId(@RequestParam("routeTrayId") int routeTrayId) {
		System.out.println("routeTrayIdrouteTrayId" + routeTrayId);

		RouteMgmt routeMgmt = new RouteMgmt();

		try {
			routeMgmt = routeMgmtRepo.findByRouteTrayIdAndDelStatus(routeTrayId, 0);
			System.out.println("routeMgmt" + routeMgmt.toString());

		} catch (Exception e) {

			e.printStackTrace();

		}
		return routeMgmt;

	}

	@RequestMapping(value = { "/deleteRouteMgmt" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRouteMgmt(@RequestParam("routeTrayId") int routeTrayId) {

		Info info = new Info();

		try {
			int delete = routeMgmtRepo.deleteRouteMgmt(routeTrayId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/getRouteMgmtList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetRouteMgmt> getRouteMgmtList() {

		List<GetRouteMgmt> list = new ArrayList<GetRouteMgmt>();
		try {

			list = getRouteMgmtRepo.getAllRouteMgmt();

			for (int i = 0; i < list.size(); i++) {

				List<Integer> frIdList = Stream.of(list.get(i).getFrIds().split(",")).map(Integer::parseInt)
						.collect(Collectors.toList());
				List<Franchisee> franchiseeList = tallyFranchiseeRepository.findByIsTallySync();

				franchiseeList = tallyFranchiseeRepository.getFranchisee(frIdList);

				String frName = "";
				int x = 0;
				for (int j = 0; j < franchiseeList.size(); j++) {

					frName = franchiseeList.get(j).getCustomerName() + "," + frName;
					if (franchiseeList.size() > 1)
						x = 1;

				}
				if (x == 1)
					list.get(i).setFrName(frName.substring(0, frName.length() - 1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getRouteMgmtByRouteTrayId" }, method = RequestMethod.POST)
	public @ResponseBody GetRouteMgmt getRouteMgmtByRouteTrayId(@RequestParam("routeTrayId") int routeTrayId) {

		GetRouteMgmt getRouteMgmt = new GetRouteMgmt();
		try {

			getRouteMgmt = getRouteMgmtRepo.getAllRouteMgmtByRoutId(routeTrayId);

			List<Integer> frIdList = Stream.of(getRouteMgmt.getFrIds().split(",")).map(Integer::parseInt)
					.collect(Collectors.toList());
			List<Franchisee> franchiseeList = tallyFranchiseeRepository.findByIsTallySync();

			franchiseeList = tallyFranchiseeRepository.getFranchisee(frIdList);

			String frName = "";
			int x = 0;
			for (int j = 0; j < franchiseeList.size(); j++) {

				frName = franchiseeList.get(j).getCustomerName() + "," + frName;
				if (franchiseeList.size() > 1)
					x = 1;

			}
			if (x == 1)
				getRouteMgmt.setFrName(frName.substring(0, frName.length() - 1));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return getRouteMgmt;

	}
}
