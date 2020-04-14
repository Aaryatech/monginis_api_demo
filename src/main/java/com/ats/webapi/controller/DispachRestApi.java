package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.DispatchStationItem;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrList;
import com.ats.webapi.model.FranchiseForDispatch;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemListForDispatchReport;
import com.ats.webapi.model.SectionMaster;
import com.ats.webapi.model.StaionListWithFranchiseeList;
import com.ats.webapi.repository.DispatchReportRepositoryForItemwiseMin;
import com.ats.webapi.repository.FrListRepository;
import com.ats.webapi.repository.FranchiseForDispatchRepository;
import com.ats.webapi.repository.ItemListForDispatchReportRepository;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.repository.MainMenuConfigurationRepository;
import com.ats.webapi.repository.RouteMasterRepository;
import com.ats.webapi.repository.SectionMasterRepository;

@RestController
public class DispachRestApi {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	RouteMasterRepository routeMasterRepository;

	@Autowired
	FrListRepository frListRepository;

	@Autowired
	ItemListForDispatchReportRepository itemListForDispatchReportRepository;

	@Autowired
	SectionMasterRepository sectionMasterRepository;

	@Autowired
	MainMenuConfigurationRepository mainMenuConfigurationRepository;

	@Autowired
	FranchiseForDispatchRepository franchiseForDispatchRepository;

	@Autowired
	DispatchReportRepositoryForItemwiseMin dispatchReportRepositoryForItemwiseMin;

	@RequestMapping(value = { "/saveSection" }, method = RequestMethod.POST)
	public @ResponseBody SectionMaster saveSection(@RequestBody SectionMaster sectionMaster) {

		SectionMaster save = new SectionMaster();
		try {

			save = sectionMasterRepository.save(sectionMaster);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

	@RequestMapping(value = { "/deleteSection" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteSection(@RequestParam("sectionId") int sectionId) {

		int isDeleted = sectionMasterRepository.deleteSection(sectionId);
		ErrorMessage infoRes = new ErrorMessage();
		if (isDeleted >= 1) {
			infoRes.setError(false);
			infoRes.setMessage("deleteSection Deleted");
		} else {
			infoRes.setError(true);
			infoRes.setMessage("deleteSection Deletion Failed");
		}
		return infoRes;
	}

	@RequestMapping(value = { "/getSectionList" }, method = RequestMethod.GET)
	public @ResponseBody List<SectionMaster> getSectionList() {

		List<SectionMaster> sectionList = new ArrayList<>();
		try {

			sectionList = sectionMasterRepository.findByDelStatus(0);

			for (int i = 0; i < sectionList.size(); i++) {

				try {

					String[] menuIds = sectionList.get(i).getMenuIds().split(",");
					List<AllMenus> menus = new ArrayList<AllMenus>();
					menus = mainMenuConfigurationRepository.findByMenuIdIn(menuIds);
					sectionList.get(i).setMenuList(menus);

				} catch (Exception e) {

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sectionList;
	}

	@RequestMapping(value = { "/getSectionListOnly" }, method = RequestMethod.GET)
	public @ResponseBody List<SectionMaster> getSectionListOnly() {

		List<SectionMaster> sectionList = new ArrayList<>();
		try {

			sectionList = sectionMasterRepository.findByDelStatus(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sectionList;
	}

	@RequestMapping(value = { "/getSectionById" }, method = RequestMethod.POST)
	public @ResponseBody SectionMaster getSectionById(@RequestParam("sectionId") int sectionId) {

		SectionMaster getSectionById = new SectionMaster();
		try {

			getSectionById = sectionMasterRepository.findBySectionIdAndDelStatus(sectionId, 0);
			try {

				String[] menuIds = getSectionById.getMenuIds().split(",");
				List<AllMenus> menus = mainMenuConfigurationRepository.findByMenuIdIn(menuIds);
				getSectionById.setMenuList(menus);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return getSectionById;
	}

	@RequestMapping(value = { "/itemListGroupByStationNo" }, method = RequestMethod.GET)
	public @ResponseBody List<Double> itemListGroupByStationNo() {

		List<Double> items = new ArrayList<Double>();
		try {

			items = itemRepository.itemListGroupByStationNo(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return items;
	}

	@RequestMapping(value = { "/getItemListForDispatchReport" }, method = RequestMethod.GET)
	public @ResponseBody List<Item> getItemListForDispatchReport() {

		List<Item> items = new ArrayList<Item>();
		try {

			items = itemRepository.findByDelStatusOrderByItemGrp2AscItemSortIdAsc(0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return items;
	}

	@RequestMapping(value = { "/showRouteListNewByabcType" }, method = RequestMethod.POST)
	@ResponseBody
	public List<RouteMaster> showRouteListNew(@RequestParam("abcType") int abcType) {

		List<RouteMaster> routeList = new ArrayList<>();
		try {

			if (abcType == 0) {
				routeList = routeMasterRepository.findByDelStatusOrderByRouteNameAsc(0);
			} else {
				routeList = routeMasterRepository.findByDelStatusAndAbcTypeOrderByRouteNameAsc(0, abcType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return routeList;
	}

	@RequestMapping(value = { "/getAbcDepatchReport" }, method = RequestMethod.POST)
	@ResponseBody
	public List<StaionListWithFranchiseeList> getAbcDepatchReport(@RequestParam("date") String date,
			@RequestParam("abcType") List<Integer> abcTypeList, @RequestParam("stationNos") List<Integer> stationNos,
			@RequestParam("routId") int routId, @RequestParam("menuIds") List<Integer> menuIds) {

		List<StaionListWithFranchiseeList> stnList = new ArrayList<>();
		try {

			int index = 0;
			int frIndex = 0;
			for (int i = 0; i < stationNos.size(); i++) {

				StaionListWithFranchiseeList staionListWithFranchiseeList = new StaionListWithFranchiseeList();
				staionListWithFranchiseeList.setStationNo(stationNos.get(i));
				int count = itemListForDispatchReportRepository.getcount(stationNos.get(i));

				List<FrList> list = new ArrayList<>();
				if (routId == 0) {
					list = frListRepository.findByAbcTypeByPass5(abcTypeList, frIndex);
				} else {
					list = frListRepository.findByAbcTypeByPass5(abcTypeList, frIndex, routId);
				}

				try {

					frIndex = list.get(list.size() - 1).getId();

				} catch (Exception e) {

				}

				for (int j = 0; j < list.size(); j++) {

					System.err.println("index " + index);

					List<ItemListForDispatchReport> itemList = itemListForDispatchReportRepository
							.getItemByFrIdAndDate(list.get(j).getFrId(), date, index, stationNos.get(i), menuIds);
					list.get(j).setItemList(itemList);

					try {

						index = itemList.get(itemList.size() - 1).getId();

					} catch (Exception e) {

					}
				}
				staionListWithFranchiseeList.setItemCount(count);
				staionListWithFranchiseeList.setList(list);
				stnList.add(staionListWithFranchiseeList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stnList;
	}

	@RequestMapping(value = { "/getAbcDepatchReportMin" }, method = RequestMethod.POST)
	@ResponseBody
	public List<StaionListWithFranchiseeList> getAbcDepatchReportMin(@RequestParam("date") String date,
			@RequestParam("abcType") List<Integer> abcTypeList, @RequestParam("stationNos") List<Integer> stationNos,
			@RequestParam("routId") int routId, @RequestParam("menuIds") List<Integer> menuIds) {

		List<StaionListWithFranchiseeList> stnList = new ArrayList<>();
		try {
			List<Integer> frList = new ArrayList<>();
			if (routId == 0) {
				frList = frListRepository.findByAbcTypeMin(abcTypeList);
			} else {
				frList = frListRepository.findByAbcTypeMin(abcTypeList, routId);
			}
			List<DispatchStationItem> allItemList = dispatchReportRepositoryForItemwiseMin
					.getItemByFrIdAndDateMin(stationNos, date, frList, menuIds);
			int index = 0;
			int frIndex = 0;
			for (int i = 0; i < stationNos.size(); i++) {

				StaionListWithFranchiseeList staionListWithFranchiseeList = new StaionListWithFranchiseeList();
				staionListWithFranchiseeList.setStationNo(stationNos.get(i));
				int count = itemListForDispatchReportRepository.getcount(stationNos.get(i));

				List<FrList> list;
				if (routId == 0) {
					list = new ArrayList<>();
					list = frListRepository.findByAbcType(abcTypeList, frIndex);
					System.out.println("List2222" + list);
				} else {

					list = frListRepository.findByAbcType(abcTypeList, frIndex, routId);
					System.out.println("List333" + list);
				}

				try {

					frIndex = frIndex + list.size();

				} catch (Exception e) {

				}

				for (int k = 0; k < list.size(); k++) {

					List<ItemListForDispatchReport> itemList = new ArrayList<>();

					for (int j = 0; j < allItemList.size(); j++) {

						if (allItemList.get(j).getFrId() == list.get(k).getFrId()
								&& allItemList.get(j).getItemMrp2() == Integer.parseInt("" + stationNos.get(i))) {

							ItemListForDispatchReport dRport = new ItemListForDispatchReport();
							dRport.setId(allItemList.get(j).getId());
							dRport.setItemId(allItemList.get(j).getItemId());
							dRport.setItemMrp2((double) stationNos.get(i));
							dRport.setItemName(allItemList.get(j).getItemName());
							dRport.setOrderQty(allItemList.get(j).getOrderQty());
							dRport.setEditQty(allItemList.get(j).getOrderQty());
							itemList.add(dRport);
						}
					}
					list.get(k).setItemList(itemList);

				}
				/*
				 * for(int j=0 ; j<list.size();j++) {
				 * 
				 * System.err.println("index " + index);
				 * 
				 * 
				 * List<ItemListForDispatchReport> itemList =
				 * itemListForDispatchReportRepository.getItemByFrIdAndDate(list.get(j).getFrId(
				 * ),date,index,stationNos.get(i),menuIds); list.get(j).setItemList(itemList);
				 * 
				 * try {
				 * 
				 * index=itemList.get(itemList.size()-1).getId();
				 * 
				 * }catch (Exception e) {
				 * 
				 * } }
				 */
				staionListWithFranchiseeList.setItemCount(count);
				staionListWithFranchiseeList.setList(list);
				stnList.add(staionListWithFranchiseeList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stnList;
	}

	@RequestMapping(value = { "/getAbcDepatchReportMin1" }, method = RequestMethod.POST)
	@ResponseBody
	public List<StaionListWithFranchiseeList> getAbcDepatchReportMin1(@RequestParam("date") String date,
			@RequestParam("abcType") List<Integer> abcTypeList, @RequestParam("stationNos") List<Integer> stationNos,
			@RequestParam("routId") int routId, @RequestParam("menuIds") List<Integer> menuIds) {

		List<StaionListWithFranchiseeList> stnList = new ArrayList<>();
		try {
			List<Integer> frList = new ArrayList<>();
			// List<FrList> frList1 = new ArrayList<>();
			if (routId == 0) {
				frList = frListRepository.findByAbcTypeMin(abcTypeList);
			} else {
				frList = frListRepository.findByAbcTypeMin(abcTypeList, routId);
			}

			int index = 0;
			int frIndex = 0;
			/*
			 * if(routId==0) {
			 * 
			 * frList1=frListRepository.findByAbcType(abcTypeList,frIndex); }else { frList1
			 * = frListRepository.findByAbcType(abcTypeList,frIndex,routId); }
			 */

			List<Item> items = new ArrayList<Item>();
			try {

				items = itemRepository.findByDelStatusOrderByItemGrp2AscItemSortIdAsc(0);

			} catch (Exception e) {
				e.printStackTrace();
			}

			List<DispatchStationItem> allItemList = dispatchReportRepositoryForItemwiseMin
					.getItemByFrIdAndDateMin1(stationNos, date, frList, menuIds);

			for (int i = 0; i < stationNos.size(); i++) {

				StaionListWithFranchiseeList staionListWithFranchiseeList = new StaionListWithFranchiseeList();

				int count = itemListForDispatchReportRepository.getcount(stationNos.get(i));

				List<FrList> frList1;
				if (routId == 0) {
					frList1 = new ArrayList<>();
					frList1 = frListRepository.findByAbcType(abcTypeList, frIndex);
					System.out.println("List2222" + frList1);
				} else {
					frList1 = new ArrayList<>();
					frList1 = frListRepository.findByAbcType(abcTypeList, frIndex, routId);
					System.out.println("List333" + frList1);
				}

				try {

					frIndex = frIndex + frList1.size();

				} catch (Exception e) {

				}

				System.out.println("frList1" + frList1.toString());
				System.out.println("items" + items.toString());
				System.out.println("allItemList" + allItemList.toString());

				for (int k = 0; k < frList1.size(); k++) {

					int frid11 = frList1.get(k).getFrId();
					List<ItemListForDispatchReport> itemList = new ArrayList<>();

					for (int m = 0; m < items.size(); m++) {
						int flag = 0;

						for (int j = 0; j < allItemList.size(); j++) {

							if ((allItemList.get(j).getFrId() == frList1.get(k).getFrId())
									&& (allItemList.get(j).getItemId() == items.get(m).getId())
									&& (items.get(m).getItemMrp2() == (Integer.parseInt("" + stationNos.get(i))))) {
								// System.out.println("items.get(m).getItemMrp2" + items.get(m).getItemMrp2());
								// System.out.println("(Integer.parseInt(\"\"+stationNos.get(i)))"
								// + (Integer.parseInt("" + stationNos.get(i))));
								// System.out.println("Flag 1");
								flag = 1;
								ItemListForDispatchReport dRport = new ItemListForDispatchReport();
								dRport.setId(allItemList.get(j).getId());
								dRport.setItemId(allItemList.get(j).getItemId());
								dRport.setItemMrp2(items.get(m).getItemMrp2());
								dRport.setItemName(allItemList.get(j).getItemName());
								dRport.setOrderQty(allItemList.get(j).getOrderQty());
								dRport.setEditQty(allItemList.get(j).getOrderQty());
								itemList.add(dRport);
							}
						}

						if (flag == 0) {
							// System.out.println("items.get(m).getItemMrp2" + items.get(m).getItemMrp2());
							// System.out.println("(Integer.parseInt(\"\"+stationNos.get(i)))"
							// + (Integer.parseInt("" + stationNos.get(i))));
							if (items.get(m).getItemMrp2() == (Integer.parseInt("" + stationNos.get(i)))) {
								// System.out.println("Flag 0");
								ItemListForDispatchReport dRport = new ItemListForDispatchReport();

								String concat = Integer.toString(items.get(m).getId())
										+ Integer.toString(frList1.get(k).getFrId())
										+ Integer.parseInt("" + stationNos.get(i));
								int combined = Integer.parseInt(concat);
								dRport.setId(combined);
								dRport.setItemId(items.get(m).getId());
								dRport.setItemMrp2(items.get(m).getItemMrp2());
								System.out.println("(double)stationNos.get(i) IN" + (double) stationNos.get(i));
								dRport.setItemName(items.get(m).getItemName());
								dRport.setOrderQty(0);
								dRport.setEditQty(0);
								itemList.add(dRport);
							}
						}

					}

					frList1.get(k).setItemList(itemList);
				}

				/*
				 * for(int j=0 ; j<list.size();j++) {
				 * 
				 * System.err.println("index " + index);
				 * 
				 * 
				 * List<ItemListForDispatchReport> itemList =
				 * itemListForDispatchReportRepository.getItemByFrIdAndDate(list.get(j).getFrId(
				 * ),date,index,stationNos.get(i),menuIds); list.get(j).setItemList(itemList);
				 * 
				 * try {
				 * 
				 * index=itemList.get(itemList.size()-1).getId();
				 * 
				 * }catch (Exception e) {
				 * 
				 * } }
				 */
				staionListWithFranchiseeList.setItemCount(count);
				staionListWithFranchiseeList.setStationNo(stationNos.get(i));
				staionListWithFranchiseeList.setList(frList1);
				stnList.add(staionListWithFranchiseeList);
				System.out.println("stnList" + stnList.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("stnList" + stnList.toString());
		return stnList;
	}

	@RequestMapping(value = { "/getFranchiseForDispatchRouteID" }, method = RequestMethod.POST)
	@ResponseBody
	public List<FranchiseForDispatch> getFranchiseForDispatchRouteID(@RequestParam("routeId") List<Integer> routeId) {

		List<FranchiseForDispatch> routeList = new ArrayList<>();
		try {

			System.err.println(routeId);
			routeList = franchiseForDispatchRepository.getFranchiseForDispatchRouteID(routeId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return routeList;
	}

	// neha 13 June
	@RequestMapping(value = { "/getFranchiseForDispatchRouteIDByPass5" }, method = RequestMethod.POST)
	@ResponseBody
	public List<FranchiseForDispatch> getFranchiseForDispatchRouteIDByPass5(
			@RequestParam("routeId") List<Integer> routeId) {

		List<FranchiseForDispatch> routeList = new ArrayList<>();
		try {

			System.err.println(routeId);
			routeList = franchiseForDispatchRepository.getFranchiseForDispatchRouteIDByPass5(routeId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return routeList;
	}

}
