package com.ats.webapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.LoginDriverResponse;
import com.ats.webapi.model.LoginResponse;
import com.ats.webapi.model.User;
import com.ats.webapi.model.logistics.AlertAmcRecord;
import com.ats.webapi.model.logistics.AlertMachineServicingRecord;
import com.ats.webapi.model.logistics.AlertVeihcleServicing;
import com.ats.webapi.model.logistics.Dealer;
import com.ats.webapi.model.logistics.Document;
import com.ats.webapi.model.logistics.DriverMaster;
import com.ats.webapi.model.logistics.GetServHeader;
import com.ats.webapi.model.logistics.LogisAmc;
import com.ats.webapi.model.logistics.MachineMaster;
import com.ats.webapi.model.logistics.MachineServicing;
import com.ats.webapi.model.logistics.Make;
import com.ats.webapi.model.logistics.MechType;
import com.ats.webapi.model.logistics.ServHeader;
import com.ats.webapi.model.logistics.SparePart;
import com.ats.webapi.model.logistics.SprGroup;
import com.ats.webapi.model.logistics.TrayManagementReport;
import com.ats.webapi.model.logistics.Variant;
import com.ats.webapi.model.logistics.VehicalMaster;
import com.ats.webapi.model.logistics.VehicalType;
import com.ats.webapi.model.logistics.VehicleDcoument;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.repository.logistics.AlertAmcRecordRepository;
import com.ats.webapi.repository.logistics.AlertMachineServicingRepository;
import com.ats.webapi.repository.logistics.AlertVeihcleServicingRepository;
import com.ats.webapi.repository.logistics.DriverMasterRepository;
import com.ats.webapi.repository.logistics.GetServHeaderRepo;
import com.ats.webapi.repository.logistics.LogisAmcRepository;
import com.ats.webapi.repository.logistics.MachineServicingRepository;
import com.ats.webapi.repository.logistics.MechTypeRepository;
import com.ats.webapi.repository.logistics.TrayManagementReportRepository;
import com.ats.webapi.service.UserService;
import com.ats.webapi.service.logistics.DealerService;
import com.ats.webapi.service.logistics.DocumentService;
import com.ats.webapi.service.logistics.DriverMasterService;
import com.ats.webapi.service.logistics.MachineMasterService;
import com.ats.webapi.service.logistics.VehicalMasterService;
import com.ats.webapi.service.logistics.VehicleDcoumentService;
import com.ats.webapi.service.logistics.MakeService;
import com.ats.webapi.service.logistics.ServHeaderService;
import com.ats.webapi.service.logistics.SparePartService;
import com.ats.webapi.service.logistics.SprGroupService;
import com.ats.webapi.service.logistics.VariantService;
import com.ats.webapi.service.logistics.VehTypeService;

@RestController
public class LogisticsApiController {

	@Autowired
	DriverMasterService driverMasterService;

	@Autowired
	VehicalMasterService vehicalMasterService;

	@Autowired
	MakeService makeService;

	@Autowired
	DealerService dealerService;

	@Autowired
	DocumentService documentService;

	@Autowired
	VariantService variantService;

	@Autowired
	VehTypeService vehTypeService;

	@Autowired
	SprGroupService sprGroupService;

	@Autowired
	SparePartService sparePartService;

	@Autowired
	ServHeaderService servHeaderService;

	@Autowired
	VehicleDcoumentService vehicleDcoumentService;

	@Autowired
	MachineMasterService machineMasterService;

	@Autowired
	LogisAmcRepository logisAmcRepository;

	@Autowired
	MechTypeRepository mechTypeRepository;

	@Autowired
	MachineServicingRepository machineServicingRepository;

	@Autowired
	AlertAmcRecordRepository alertAmcRecordRepository;

	@Autowired
	AlertMachineServicingRepository alertMachineServicingRepository;

	@Autowired
	AlertVeihcleServicingRepository alertVeihcleServicingRepository;

	@Autowired
	TrayManagementReportRepository trayManagementReportRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	DriverMasterRepository driverMasterRepository;
	@Autowired
	GetServHeaderRepo getServHeaderRepo;

	@RequestMapping(value = { "/getLogistiocsDataBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetServHeader> getLogistiocsDataBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("typeId") int typeId,
			@RequestParam("servType") List<String> servType, @RequestParam("vehIdList") List<String> vehIdList) {
		System.out.println("fromDate " + fromDate);
		System.out.println("toDate " + toDate);
		System.out.println("servType " + servType);
		System.out.println("typeId " + typeId);
		System.out.println("vehId " + vehIdList);
		List<GetServHeader> servList = new ArrayList<GetServHeader>();
		try {

			servList = getServHeaderRepo.findByBetweenDateAndVehIdListAndServType(fromDate, toDate, typeId, vehIdList,
					servType);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return servList;
	}

	@RequestMapping(value = { "/getLogistiocsDetailDataBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetServHeader> getLogistiocsDetailDataBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("vehIdList") int vehIdList) {
		System.out.println("fromDate " + fromDate);
		System.out.println("toDate " + toDate);

		System.out.println("vehId " + vehIdList);
		List<GetServHeader> servList = new ArrayList<GetServHeader>();
		try {

			servList = getServHeaderRepo.findByBetweenDateAndVehIdList(fromDate, toDate, vehIdList);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return servList;
	}

	@RequestMapping(value = { "/loginDriverOrUser" }, method = RequestMethod.POST)
	public @ResponseBody LoginDriverResponse loginDriverOrUser(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {

		LoginDriverResponse loginResponse = new LoginDriverResponse();
		try {

			DriverMaster dv = driverMasterRepository.findByString1AndString2AndDelStatus(userName, password, 0);

			if (dv == null) {
				loginResponse.setError(true);
				loginResponse.setMsg("Driver is Not registered");

				User mu = userRepository.findByUsernameAndPasswordAndDelStatus(userName, password, 0);

				loginResponse.setUser(mu);

			} else {
				loginResponse.setError(false);
				loginResponse.setMsg("login successfully");
				loginResponse.setDriver(dv);
			}

		} catch (Exception e) {

			e.printStackTrace();
			loginResponse.setError(true);
			loginResponse.setMsg("login Failed");
		}

		return loginResponse;
	}

	@RequestMapping(value = { "/postDriverMaster" }, method = RequestMethod.POST)
	public @ResponseBody DriverMaster postDriverMaster(@RequestBody DriverMaster driverMaster) {
		System.out.println("driverMaster :" + driverMaster.toString());
		DriverMaster response = new DriverMaster();
		try {

			response = driverMasterService.postDriverMaster(driverMaster);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteDriverMaster" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDriverMaster(@RequestParam("driverId") int driverId) {
		System.out.println("driverId " + driverId);
		Info info = new Info();
		try {

			info = driverMasterService.deleteDriverMaster(driverId);
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllDriverList" }, method = RequestMethod.GET)
	public @ResponseBody List<DriverMaster> getAllDriverList() {

		List<DriverMaster> getalldriverList = new ArrayList<DriverMaster>();
		try {

			getalldriverList = driverMasterService.getAllDriverList();
			System.out.println(getalldriverList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getalldriverList;

	}

	@RequestMapping(value = { "/getDriverById" }, method = RequestMethod.POST)
	public @ResponseBody DriverMaster getDriverById(@RequestParam("driverId") int driverId) {
		System.out.println("driverId" + driverId);
		DriverMaster getDriverById = new DriverMaster();
		try {

			getDriverById = driverMasterService.getDriverById(driverId);
			System.out.println(getDriverById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getDriverById;

	}

	// ---------------------------------------vehicale
	// Master------------------------------------------

	@RequestMapping(value = { "/postVehicalMaster" }, method = RequestMethod.POST)
	public @ResponseBody VehicalMaster postVehicalMaster(@RequestBody VehicalMaster vehicalMaster) {
		System.out.println("vehicalMaster :" + vehicalMaster.toString());
		VehicalMaster response = new VehicalMaster();
		try {

			response = vehicalMasterService.postVehicalMaster(vehicalMaster);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteVehicalMaster" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteVehicalMaster(@RequestParam("vehicalId") int vehicalId) {
		System.out.println("vehicalId " + vehicalId);
		Info info = new Info();
		try {

			info = vehicalMasterService.deleteVehicalMaster(vehicalId);
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllVehicalList" }, method = RequestMethod.GET)
	public @ResponseBody List<VehicalMaster> getAllVehicalList() {

		List<VehicalMaster> getAllVehicalList = new ArrayList<VehicalMaster>();
		try {

			getAllVehicalList = vehicalMasterService.getAllVehicalList();
			System.out.println(getAllVehicalList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllVehicalList;

	}

	@RequestMapping(value = { "/getVehicalById" }, method = RequestMethod.POST)
	public @ResponseBody VehicalMaster getVehicalById(@RequestParam("vehicalId") int vehicalId) {
		System.out.println("vehicalId" + vehicalId);
		VehicalMaster getVehicalById = new VehicalMaster();
		try {

			getVehicalById = vehicalMasterService.getVehicalById(vehicalId);
			System.out.println(getVehicalById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getVehicalById;

	}

//------------------------------------------------------make-------------------------------------
	@RequestMapping(value = { "/postMake" }, method = RequestMethod.POST)
	public @ResponseBody Make postMake(@RequestBody Make make) {
		System.out.println("make :" + make.toString());
		Make response = new Make();
		try {

			response = makeService.postMake(make);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteMake" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMake(@RequestParam("makeId") int makeId) {
		System.out.println("makeId " + makeId);
		Info info = new Info();
		try {

			info = makeService.deleteMake(makeId);
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllMakeList" }, method = RequestMethod.GET)
	public @ResponseBody List<Make> getAllMakeList() {

		List<Make> getAllMakeList = new ArrayList<Make>();
		try {

			getAllMakeList = makeService.getAllMakeList();
			System.out.println(getAllMakeList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllMakeList;

	}

	@RequestMapping(value = { "/getMakeById" }, method = RequestMethod.POST)
	public @ResponseBody Make getMakeById(@RequestParam("makeId") int makeId) {
		System.out.println("makeId" + makeId);
		Make getMakeById = new Make();
		try {

			getMakeById = makeService.getMakeById(makeId);
			System.out.println(getMakeById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getMakeById;

	}

	// ---------------------------------------------Dealer--------------------------------------------------------

	@RequestMapping(value = { "/postDealer" }, method = RequestMethod.POST)
	public @ResponseBody Dealer postDealer(@RequestBody Dealer dealer) {
		System.out.println("dealer :" + dealer.toString());
		Dealer response = new Dealer();
		try {

			response = dealerService.postDealer(dealer);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteDealer" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDealer(@RequestParam("dealerId") int dealerId) {
		System.out.println("dealerId " + dealerId);
		Info info = new Info();
		try {

			info = dealerService.deleteDealer(dealerId);
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllDealerList" }, method = RequestMethod.GET)
	public @ResponseBody List<Dealer> getAllDealerList() {

		List<Dealer> getAllDealerList = new ArrayList<Dealer>();
		try {

			getAllDealerList = dealerService.getAllDealerList();
			System.out.println(getAllDealerList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllDealerList;

	}

	@RequestMapping(value = { "/getDealerById" }, method = RequestMethod.POST)
	public @ResponseBody Dealer getDealerById(@RequestParam("dealerId") int dealerId) {
		System.out.println("dealerId" + dealerId);
		Dealer getDealerById = new Dealer();
		try {

			getDealerById = dealerService.getDealerById(dealerId);
			System.out.println(getDealerById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getDealerById;

	}

	@RequestMapping(value = { "/getDealerByMakeId" }, method = RequestMethod.POST)
	public @ResponseBody List<Dealer> getDealerByMakeId(@RequestParam("makeId") int makeId) {
		System.out.println("makeId" + makeId);
		List<Dealer> getDealerByMakeId = new ArrayList<Dealer>();
		try {

			getDealerByMakeId = dealerService.getDealerByMakeId(makeId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getDealerByMakeId;

	}
	// -------------------------------------------Document------------------------------------

	@RequestMapping(value = { "/postDocument" }, method = RequestMethod.POST)
	public @ResponseBody Document postDocument(@RequestBody Document document) {
		System.out.println("document :" + document.toString());
		Document response = new Document();
		try {

			response = documentService.postDocument(document);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteDocument" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteDocument(@RequestParam("docId") int docId) {
		System.out.println("docId " + docId);
		Info info = new Info();
		try {

			info = documentService.deleteDocument(docId);
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllDocumentList" }, method = RequestMethod.GET)
	public @ResponseBody List<Document> getAllDocumentList() {

		List<Document> getAllDocumentList = new ArrayList<Document>();
		try {

			getAllDocumentList = documentService.getAllDocumentList();
			System.out.println(getAllDocumentList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllDocumentList;

	}

	@RequestMapping(value = { "/getDocById" }, method = RequestMethod.POST)
	public @ResponseBody Document getDocById(@RequestParam("docId") int docId) {
		System.out.println("docId" + docId);
		Document getDocById = new Document();
		try {

			getDocById = documentService.getDocById(docId);
			System.out.println(getDocById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getDocById;

	}

	// --------------------------------------------Variant-------------------------

	@RequestMapping(value = { "/postVariant" }, method = RequestMethod.POST)
	public @ResponseBody Variant postVariant(@RequestBody Variant variant) {
		System.out.println("variant :" + variant.toString());
		Variant response = new Variant();
		try {

			response = variantService.postVariant(variant);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteVariant" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteVariant(@RequestParam("variantId") int variantId) {
		System.out.println("variantId " + variantId);
		Info info = new Info();
		try {

			info = variantService.deleteVariant(variantId);
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllVariantList" }, method = RequestMethod.GET)
	public @ResponseBody List<Variant> getAllVariantList() {

		List<Variant> getAllVariantList = new ArrayList<Variant>();
		try {

			getAllVariantList = variantService.getAllVariantList();
			System.out.println(getAllVariantList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllVariantList;

	}

	@RequestMapping(value = { "/getVariantById" }, method = RequestMethod.POST)
	public @ResponseBody Variant getVariantById(@RequestParam("variantId") int variantId) {
		System.out.println("variantId" + variantId);
		Variant getVariantById = new Variant();
		try {

			getVariantById = variantService.getVariantById(variantId);
			System.out.println(getVariantById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getVariantById;

	}

	@RequestMapping(value = { "/getVariantByMakeIdAndTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<Variant> getVariantByMakeIdAndTypeId(@RequestParam("makeId") int makeId,
			@RequestParam("typeId") int typeId) {
		System.out.println("makeId" + makeId);
		System.out.println("typeId" + typeId);
		List<Variant> getVariantByMakeIdAndTypeId = new ArrayList<Variant>();
		try {

			getVariantByMakeIdAndTypeId = variantService.getVariantByMakeIdAndTypeId(makeId, typeId);
			System.out.println(getVariantByMakeIdAndTypeId.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getVariantByMakeIdAndTypeId;

	}

	// -------------------------------------vehType------------------------------------

	@RequestMapping(value = { "/postVahType" }, method = RequestMethod.POST)
	public @ResponseBody VehicalType postVahType(@RequestBody VehicalType vehicalType) {
		System.out.println("vehicalType :" + vehicalType.toString());
		VehicalType response = new VehicalType();
		try {

			response = vehTypeService.postVahType(vehicalType);
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteVehType" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteVehType(@RequestParam("vehId") int vehId) {
		System.out.println("vehId " + vehId);
		Info info = new Info();
		try {

			info = vehTypeService.deleteVehType(vehId);
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllVehicalTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<VehicalType> getAllVehicalTypeList() {

		List<VehicalType> getAllVehicalTypeList = new ArrayList<VehicalType>();
		try {

			getAllVehicalTypeList = vehTypeService.getAllVehicalTypeList();
			System.out.println(getAllVehicalTypeList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllVehicalTypeList;

	}

	@RequestMapping(value = { "/getVehTypeById" }, method = RequestMethod.POST)
	public @ResponseBody VehicalType getVehTypeById(@RequestParam("vehiTypeId") int vehiTypeId) {
		System.out.println("vehiTypeId" + vehiTypeId);
		VehicalType getVehTypeById = new VehicalType();
		try {

			getVehTypeById = vehTypeService.getVehTypeById(vehiTypeId);
			System.out.println(getVehTypeById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getVehTypeById;

	}

	@RequestMapping(value = { "/typeByMakeId" }, method = RequestMethod.POST)
	public @ResponseBody List<VehicalType> typeByMakeId(@RequestParam("makeId") int makeId) {
		System.out.println("makeId" + makeId);
		List<VehicalType> typeByMakeId = new ArrayList<VehicalType>();
		try {

			typeByMakeId = vehTypeService.typeByMakeId(makeId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return typeByMakeId;

	}

	// -------------------------------------------SpareGroup---------------------------------------

	@RequestMapping(value = { "/postSprGroup" }, method = RequestMethod.POST)
	public @ResponseBody SprGroup postSprGroup(@RequestBody SprGroup sprGroup) {
		System.out.println("SprGroup :" + sprGroup.toString());
		SprGroup response = new SprGroup();
		try {

			response = sprGroupService.postSprGroup(sprGroup);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteSprGroup" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSprGroup(@RequestParam("groupId") int groupId) {
		System.out.println("groupId " + groupId);
		Info info = new Info();
		try {

			info = sprGroupService.deleteSprGroup(groupId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllSprGroupList" }, method = RequestMethod.GET)
	public @ResponseBody List<SprGroup> getAllSprGroupList() {

		List<SprGroup> getAllSprGroupList = new ArrayList<SprGroup>();
		try {

			getAllSprGroupList = sprGroupService.getAllSprGroupList();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllSprGroupList;

	}

	@RequestMapping(value = { "/getSprGroupById" }, method = RequestMethod.POST)
	public @ResponseBody SprGroup getSprGroupById(@RequestParam("groupId") int groupId) {
		System.out.println("groupId" + groupId);
		SprGroup getSprGroupById = new SprGroup();
		try {

			getSprGroupById = sprGroupService.getSprGroupById(groupId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getSprGroupById;

	}

	@RequestMapping(value = { "/getSprGroupListByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<SprGroup> getSprGroupListByTypeId(@RequestParam("typeId") int typeId) {
		System.out.println("typeId" + typeId);
		List<SprGroup> getSprGroupListByTypeId = new ArrayList<SprGroup>();
		try {

			getSprGroupListByTypeId = sprGroupService.getSprGroupListByTypeId(typeId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getSprGroupListByTypeId;

	}

	// --------------------------------------------SparePart-------------------------------

	@RequestMapping(value = { "/postSparePart" }, method = RequestMethod.POST)
	public @ResponseBody SparePart postSparePart(@RequestBody SparePart sparePart) {
		System.out.println("sparePart :" + sparePart.toString());
		SparePart response = new SparePart();
		try {

			response = sparePartService.postSparePart(sparePart);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteSparePart" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSparePart(@RequestParam("sprId") int sprId) {
		System.out.println("sprId " + sprId);
		Info info = new Info();
		try {

			info = sparePartService.deleteSparePart(sprId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllSparePart" }, method = RequestMethod.GET)
	public @ResponseBody List<SparePart> getAllSparePart() {

		List<SparePart> getAllSparePart = new ArrayList<SparePart>();
		try {

			getAllSparePart = sparePartService.getAllSparePart();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllSparePart;

	}

	@RequestMapping(value = { "/getSparePartById" }, method = RequestMethod.POST)
	public @ResponseBody SparePart getSparePartById(@RequestParam("sprId") int sprId) {
		System.out.println("sprId" + sprId);
		SparePart getSparePartById = new SparePart();
		try {

			getSparePartById = sparePartService.getSparePartById(sprId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getSparePartById;

	}

	@RequestMapping(value = { "/sparePartByGroupId" }, method = RequestMethod.POST)
	public @ResponseBody List<SparePart> sparePartByGroupId(@RequestParam("groupId") int groupId) {

		List<SparePart> sparePartByGroupId = new ArrayList<SparePart>();
		try {

			sparePartByGroupId = sparePartService.sparePartByGroupId(groupId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return sparePartByGroupId;

	}

	// ---------------------------------------------------servicing-------------------------

	@RequestMapping(value = { "/postServHeader" }, method = RequestMethod.POST)
	public @ResponseBody ServHeader postServHeader(@RequestBody ServHeader servHeader) {
		System.out.println("servHeader :" + servHeader.toString());
		ServHeader response = new ServHeader();
		try {

			response = servHeaderService.postServHeader(servHeader);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/getAllServHeader" }, method = RequestMethod.GET)
	public @ResponseBody List<ServHeader> getAllServHeader() {

		List<ServHeader> getAllServHeader = new ArrayList<ServHeader>();
		try {

			getAllServHeader = servHeaderService.getAllServHeader();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllServHeader;

	}

	@RequestMapping(value = { "/getServHeaderAndDetailById" }, method = RequestMethod.POST)
	public @ResponseBody ServHeader getServHeaderAndDetailById(@RequestParam("servId") int servId) {
		System.out.println("servId" + servId);
		ServHeader getServHeaderAndDetailById = new ServHeader();
		try {

			getServHeaderAndDetailById = servHeaderService.getServHeaderAndDetailById(servId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getServHeaderAndDetailById;

	}

	@RequestMapping(value = { "/getServicingListPendingAndCurrentDate" }, method = RequestMethod.GET)
	public @ResponseBody List<ServHeader> showServicingListPendingAndCurrentDate() {

		List<ServHeader> showServicingListPendingAndCurrentDate = new ArrayList<ServHeader>();
		try {

			showServicingListPendingAndCurrentDate = servHeaderService.showServicingListPendingAndCurrentDate();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return showServicingListPendingAndCurrentDate;

	}

	@RequestMapping(value = { "/getServicingListBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<ServHeader> showServicingListBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("type") int type, @RequestParam("vehId") int vehId) {

		List<ServHeader> showServicingListBetweenDate = new ArrayList<ServHeader>();
		try {
			if (vehId == 0) {
				showServicingListBetweenDate = servHeaderService.showServicingListBetweenDate(fromDate, toDate, type);
			} else {
				showServicingListBetweenDate = servHeaderService.showServicingListBetweenDateAndFilter(fromDate, toDate,
						type, vehId);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return showServicingListBetweenDate;

	}

	@RequestMapping(value = { "/getServicingListBetweenDateByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<ServHeader> getServicingListBetweenDateByTypeId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("typeId") int typeId) {

		List<ServHeader> showServicingListBetweenDate = new ArrayList<ServHeader>();
		try {

			showServicingListBetweenDate = servHeaderService.getServicingListBetweenDateByTypeId(fromDate, toDate,
					typeId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return showServicingListBetweenDate;

	}

	@RequestMapping(value = { "/approvedServiceHeader" }, method = RequestMethod.POST)
	public @ResponseBody Info approvedServiceHeader(@RequestParam("servId") int servId) {

		Info info = new Info();
		try {

			info = servHeaderService.approvedServiceHeader(servId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	// ----------------------------------------------vehDocument-----------------------------------

	@RequestMapping(value = { "/postVehicleDocument" }, method = RequestMethod.POST)
	public @ResponseBody VehicleDcoument postVehicleDocument(@RequestBody VehicleDcoument vehicleDcoument) {
		System.out.println("vehicleDcoument :" + vehicleDcoument.toString());
		VehicleDcoument response = new VehicleDcoument();
		try {

			response = vehicleDcoumentService.postVehicleDocument(vehicleDcoument);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteVehicleDcoument" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteVehicleDcoument(@RequestParam("vehDocId") int vehDocId) {
		System.out.println("vehDocId " + vehDocId);
		Info info = new Info();
		try {

			info = vehicleDcoumentService.deleteVehicleDcoument(vehDocId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllVehicleDcoument" }, method = RequestMethod.GET)
	public @ResponseBody List<VehicleDcoument> getAllVehicleDcoument() {

		List<VehicleDcoument> getAllVehicleDcoument = new ArrayList<VehicleDcoument>();
		try {

			getAllVehicleDcoument = vehicleDcoumentService.getAllVehicleDcoument();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllVehicleDcoument;

	}

	@RequestMapping(value = { "/getVehicleDcoumentById" }, method = RequestMethod.POST)
	public @ResponseBody VehicleDcoument getVehicleDcoumentById(@RequestParam("vehDocId") int vehDocId) {
		System.out.println("vehDocId" + vehDocId);
		VehicleDcoument getVehicleDcoumentById = new VehicleDcoument();
		try {

			getVehicleDcoumentById = vehicleDcoumentService.getVehicleDcoumentById(vehDocId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getVehicleDcoumentById;

	}

	// -------------------------------------Machine
	// Master------------------------------------------------------

	@RequestMapping(value = { "/postMachineMaster" }, method = RequestMethod.POST)
	public @ResponseBody MachineMaster postMachineMaster(@RequestBody MachineMaster machineMaster) {
		System.out.println("machineMaster :" + machineMaster.toString());
		MachineMaster response = new MachineMaster();
		try {

			response = machineMasterService.postMachineMaster(machineMaster);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteMachineMaster" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMachineMaster(@RequestParam("machineId") int machineId) {
		System.out.println("machineId " + machineId);
		Info info = new Info();
		try {

			info = machineMasterService.deleteMachineMaster(machineId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllMachineMaster" }, method = RequestMethod.GET)
	public @ResponseBody List<MachineMaster> getAllMachineMaster() {

		List<MachineMaster> getAllMachineMaster = new ArrayList<MachineMaster>();
		try {

			getAllMachineMaster = machineMasterService.getAllMachineMaster();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllMachineMaster;
	}

	@RequestMapping(value = { "/getMachineMasterById" }, method = RequestMethod.POST)
	public @ResponseBody MachineMaster getMachineMasterById(@RequestParam("machineId") int machineId) {
		System.out.println("machineId" + machineId);
		MachineMaster getMachineMasterById = new MachineMaster();
		try {

			getMachineMasterById = machineMasterService.getMachineMasterById(machineId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getMachineMasterById;

	}

	// -------------------------------------Logis
	// Amc--------------------------------

	@RequestMapping(value = { "/postLogisAmc" }, method = RequestMethod.POST)
	public @ResponseBody LogisAmc postLogisAmc(@RequestBody LogisAmc logisAmc) {
		System.out.println("logisAmc :" + logisAmc.toString());
		LogisAmc response = new LogisAmc();
		try {

			response = logisAmcRepository.save(logisAmc);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/deleteLogisAmc" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteLogisAmc(@RequestParam("amcId") int amcId) {
		System.out.println("amcId " + amcId);
		Info info = new Info();
		try {

			int delete = logisAmcRepository.deleteLogisAmc(amcId);
			if (delete == 1) {
				info.setError(false);
				info.setMessage("deleted successfully");
			} else {
				info.setError(true);
				info.setMessage("failed to delete");
			}
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getLogisAmcById" }, method = RequestMethod.POST)
	public @ResponseBody LogisAmc getLogisAmcById(@RequestParam("amcId") int amcId) {
		System.out.println("amcId" + amcId);
		LogisAmc getLogisAmcById = new LogisAmc();
		try {

			getLogisAmcById = logisAmcRepository.findByAmcId(amcId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getLogisAmcById;

	}

	@RequestMapping(value = { "/getLogisAmcListByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody List<LogisAmc> getLogisAmcListByTypeId(@RequestParam("typeId") int typeId) {

		List<LogisAmc> getLogisAmcListByTypeId = new ArrayList<LogisAmc>();
		try {

			getLogisAmcListByTypeId = logisAmcRepository.findAllByTypeId(typeId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getLogisAmcListByTypeId;
	}

	@RequestMapping(value = { "/getLogisAmcListByTypeIdAndMechId" }, method = RequestMethod.POST)
	public @ResponseBody List<LogisAmc> getLogisAmcListByTypeIdAndMechId(@RequestParam("typeId") int typeId,
			@RequestParam("mechId") int mechId) {

		List<LogisAmc> getLogisAmcListByTypeIdAndMechId = new ArrayList<LogisAmc>();
		try {

			getLogisAmcListByTypeIdAndMechId = logisAmcRepository.findAllByTypeIdAndMechId(typeId, mechId);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getLogisAmcListByTypeIdAndMechId;
	}

	// -------------------------------------------mechType------------------------------------

	@RequestMapping(value = { "/getTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<MechType> getTypeList() {

		List<MechType> getTypeList = new ArrayList<MechType>();
		try {

			getTypeList = mechTypeRepository.findAllByDelStatus(0);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getTypeList;
	}

	@RequestMapping(value = { "/getTypeListByType" }, method = RequestMethod.POST)
	public @ResponseBody List<MechType> getTypeListByType(@RequestParam("type") int type) {

		List<MechType> getTypeListByType = new ArrayList<MechType>();
		try {

			getTypeListByType = mechTypeRepository.findAllByTypeAndDelStatus(type, 0);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getTypeListByType;
	}

	// ---------------------------------------MachineServincing----------------------------------------
	@RequestMapping(value = { "/postMachineServicing" }, method = RequestMethod.POST)
	public @ResponseBody MachineServicing postMachineServicing(@RequestBody MachineServicing machineServicing) {
		System.out.println("machineServicing :" + machineServicing.toString());
		MachineServicing response = new MachineServicing();
		try {

			response = machineServicingRepository.save(machineServicing);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;

	}

	@RequestMapping(value = { "/approveMachineServicing" }, method = RequestMethod.POST)
	public @ResponseBody Info approveMachineServicing(@RequestBody List<MachineServicing> machineServicingList) {
		System.out.println("machineServicingList :" + machineServicingList.toString());
		List<MachineServicing> response = new ArrayList<MachineServicing>();
		Info info = new Info();
		try {

			response = machineServicingRepository.save(machineServicingList);
			if (response != null) {
				info.setError(false);
				info.setMessage("approved");
			} else {
				info.setError(true);
				info.setMessage("failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getAllMachineServicing" }, method = RequestMethod.GET)
	public @ResponseBody List<MachineServicing> getAllMachineServicing() {

		List<MachineServicing> getAllMachineServicing = new ArrayList<MachineServicing>();
		try {

			getAllMachineServicing = machineServicingRepository.findAllByIsApprovedAndDelStatus(0, 0);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllMachineServicing;
	}

	@RequestMapping(value = { "/getMachineServicingWithDate" }, method = RequestMethod.POST)
	public @ResponseBody List<MachineServicing> getMachineServicingWithDate(@RequestParam("machineId") int machineId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<MachineServicing> getAllMachineServicing = new ArrayList<MachineServicing>();
		try {
			if (machineId == 0) {
				getAllMachineServicing = machineServicingRepository.findByBetweenDate(fromDate, toDate);
				System.out.println("getAllMachineServicing " + getAllMachineServicing);
			} else {
				getAllMachineServicing = machineServicingRepository.findByBetweenDateByMachineId(fromDate, toDate,
						machineId);
				System.out.println("getAllMachineServicing " + getAllMachineServicing);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAllMachineServicing;

	}

	// -----------------------------------------------ForDashboard---------------------------------------------------

	@RequestMapping(value = { "/getAlertMachineAmcRecord" }, method = RequestMethod.GET)
	public @ResponseBody List<AlertAmcRecord> getAlertAmcRecord() {

		List<AlertAmcRecord> getAlertMachineAmcRecord = new ArrayList<AlertAmcRecord>();
		try {
			Date date = new Date();
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String today = formate.format(date);
			System.out.println("todays " + today);
			getAlertMachineAmcRecord = alertAmcRecordRepository.getAlertAmcRecord(today);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAlertMachineAmcRecord;
	}

	@RequestMapping(value = { "/getAlertvehicleAmcRecord" }, method = RequestMethod.GET)
	public @ResponseBody List<AlertAmcRecord> getAlertvehicleAmcRecord() {

		List<AlertAmcRecord> getAlertvehicleAmcRecord = new ArrayList<AlertAmcRecord>();
		try {
			Date date = new Date();
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String today = formate.format(date);
			System.out.println("todays " + today);
			getAlertvehicleAmcRecord = alertAmcRecordRepository.getAlertvehicleAmcRecord(today);
			System.out.println("getAlertvehicleAmcRecord " + getAlertvehicleAmcRecord);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAlertvehicleAmcRecord;
	}

	@RequestMapping(value = { "/getAlertDriverRecord" }, method = RequestMethod.GET)
	public @ResponseBody List<DriverMaster> getAlertDriverRecord() {

		List<DriverMaster> getAlertDriverRecord = new ArrayList<DriverMaster>();
		try {
			Date date = new Date();
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String today = formate.format(date);
			System.out.println("todays " + today);
			getAlertDriverRecord = driverMasterService.getAlertDriverRecord(today);
			System.out.println("getAlertDriverRecord " + getAlertDriverRecord);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAlertDriverRecord;
	}

	@RequestMapping(value = { "/getAlertDocumentRecord" }, method = RequestMethod.GET)
	public @ResponseBody List<VehicleDcoument> getAlertDocumentRecord() {

		List<VehicleDcoument> getAlertDocumentRecord = new ArrayList<VehicleDcoument>();
		try {

			Date date = new Date();
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String today = formate.format(date);
			System.out.println("todays " + today);
			getAlertDocumentRecord = vehicleDcoumentService.getAlertDocumentRecord(today);
			System.out.println("getAlertDocumentRecord " + getAlertDocumentRecord);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAlertDocumentRecord;
	}

	@RequestMapping(value = { "/getAlertMachineServicingRecord" }, method = RequestMethod.GET)
	public @ResponseBody List<AlertMachineServicingRecord> getAlertMachineServicingRecord() {

		List<AlertMachineServicingRecord> getAlertMachineServicingRecord = new ArrayList<AlertMachineServicingRecord>();
		try {
			Date date = new Date();
			SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
			String today = formate.format(date);
			System.out.println("todays " + today);
			getAlertMachineServicingRecord = alertMachineServicingRepository.getAlertMachineServicingRecord(today);
			System.out.println("getAlertMachineServicingRecord " + getAlertMachineServicingRecord);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAlertMachineServicingRecord;
	}

	@RequestMapping(value = { "/getAlertVeihcleServicingRecord" }, method = RequestMethod.GET)
	public @ResponseBody List<AlertVeihcleServicing> getAlertVeihcleServicingRecord() {

		List<AlertVeihcleServicing> getAlertVeihcleServicingRecord = new ArrayList<AlertVeihcleServicing>();
		try {

			getAlertVeihcleServicingRecord = alertVeihcleServicingRepository.getAlertVeihcleServicingRecord();
			System.out.println("getAlertVeihcleServicingRecord " + getAlertVeihcleServicingRecord);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getAlertVeihcleServicingRecord;
	}

	// -----------------------------------------alertVehicle-----------------------------------------

	@RequestMapping(value = { "/postAlertVeihcleServicing" }, method = RequestMethod.POST)
	public @ResponseBody AlertVeihcleServicing postAlertVeihcleServicing(
			@RequestBody AlertVeihcleServicing alertVeihcleServicing) {
		System.out.println("alertVeihcleServicing :" + alertVeihcleServicing.toString());
		AlertVeihcleServicing response = new AlertVeihcleServicing();
		try {

			response = alertVeihcleServicingRepository.save(alertVeihcleServicing);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = { "/getAlertVeihcleServicingByVehIdAndType" }, method = RequestMethod.POST)
	public @ResponseBody AlertVeihcleServicing getAlertVeihcleServicingByVehIdAndType(@RequestParam("vehId") int vehId,
			@RequestParam("typeId") int typeId) {
		System.out.println("vehId " + vehId);
		System.out.println("typeId " + typeId);
		AlertVeihcleServicing getVehicleAlert = null;
		try {

			getVehicleAlert = alertVeihcleServicingRepository.findByVehIdAndTypeId(vehId, typeId);
			// System.out.println(getVehicleAlert.toString());
			if (getVehicleAlert == null) {
				getVehicleAlert = new AlertVeihcleServicing();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getVehicleAlert;

	}

	@RequestMapping(value = { "/getTrayManagementReport" }, method = RequestMethod.POST)
	public @ResponseBody List<TrayManagementReport> getTrayManagementReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("routeId") int routeId,
			@RequestParam("vehId") int vehId) {
		System.out.println("fromDate " + fromDate);
		System.out.println("toDate " + toDate);
		System.out.println("routeId " + routeId);
		System.out.println("vehId " + vehId);
		List<TrayManagementReport> getTrayManagementReport = new ArrayList<TrayManagementReport>();
		try {
			if (routeId != 0 && vehId == 0)
				getTrayManagementReport = trayManagementReportRepository.getTrayManagementReportRouteWise(fromDate,
						toDate, routeId);
			else if (routeId == 0 && vehId != 0)
				getTrayManagementReport = trayManagementReportRepository.getTrayManagementReportVehId(fromDate, toDate,
						vehId);
			else if (routeId != 0 && vehId != 0)
				getTrayManagementReport = trayManagementReportRepository
						.getTrayManagementReportRouteWiseAndVehId(fromDate, toDate, routeId, vehId);
			else
				getTrayManagementReport = trayManagementReportRepository.getTrayManagementReport(fromDate, toDate);

			System.out.println("getTrayManagementReport " + getTrayManagementReport);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return getTrayManagementReport;
	}
}
