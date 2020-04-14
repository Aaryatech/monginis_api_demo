package com.ats.webapi.service.spprod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.spprod.Employee;
import com.ats.webapi.model.spprod.EmployeeList;
import com.ats.webapi.model.spprod.GetAllocStationCk;
import com.ats.webapi.model.spprod.GetEmployee;
import com.ats.webapi.model.spprod.GetEmployeeList;
import com.ats.webapi.model.spprod.GetInstAllocToStation;
import com.ats.webapi.model.spprod.GetInstVerifDetail;
import com.ats.webapi.model.spprod.GetInstVerifHeader;
import com.ats.webapi.model.spprod.GetInstrVerifHeader;
import com.ats.webapi.model.spprod.GetSpStation;
import com.ats.webapi.model.spprod.GetStationAllocation;
import com.ats.webapi.model.spprod.InstAllocToStation;
import com.ats.webapi.model.spprod.InstAllocToStationList;
import com.ats.webapi.model.spprod.InstVerificationDetail;
import com.ats.webapi.model.spprod.InstVerificationHeader;
import com.ats.webapi.model.spprod.Instrument;
import com.ats.webapi.model.spprod.InstrumentList;
import com.ats.webapi.model.spprod.MDept;
import com.ats.webapi.model.spprod.MDeptList;
import com.ats.webapi.model.spprod.MType;
import com.ats.webapi.model.spprod.Shift;
import com.ats.webapi.model.spprod.ShiftList;
import com.ats.webapi.model.spprod.SpCkAllocDetail;
import com.ats.webapi.model.spprod.SpCkAllocHeader;
import com.ats.webapi.model.spprod.SpStation;
import com.ats.webapi.model.spprod.SpStationList;
import com.ats.webapi.model.spprod.StationAllocList;
import com.ats.webapi.model.spprod.StationAllocation;
import com.ats.webapi.model.spprod.StationSpCake;
import com.ats.webapi.model.spprod.StationSpCakeList;
import com.ats.webapi.model.spprod.StationWiseCkCount;
import com.ats.webapi.model.spprod.TypeList;
import com.ats.webapi.repository.EmployeeRepository;
import com.ats.webapi.repository.GetAllocStationCkRepository;
import com.ats.webapi.repository.GetEmployeeRepository;
import com.ats.webapi.repository.GetInstAllocToStRepository;
import com.ats.webapi.repository.GetInstVerifDetailRepository;
import com.ats.webapi.repository.GetInstVerifHeaderRepository;
import com.ats.webapi.repository.GetInstrVerifHeaderRepository;
import com.ats.webapi.repository.GetSpStationRepository;
import com.ats.webapi.repository.GetStationAllocRepository;
import com.ats.webapi.repository.InstAllocToStationRepository;
import com.ats.webapi.repository.InstVerifHeaderRepository;
import com.ats.webapi.repository.InstVerificationDetailRepository;
import com.ats.webapi.repository.InstrumentRepository;
import com.ats.webapi.repository.MDeptRepository;
import com.ats.webapi.repository.ProdStationAllocRepository;
import com.ats.webapi.repository.ShiftRepository;
import com.ats.webapi.repository.SpCakeOrdersRepository;
import com.ats.webapi.repository.SpCkAllocDetailRepository;
import com.ats.webapi.repository.SpCkAllocHeaderRepository;
import com.ats.webapi.repository.SpStationRepository;
import com.ats.webapi.repository.StationSpecialCakeRepository;
import com.ats.webapi.repository.StationWiseCkCountRepository;
import com.ats.webapi.repository.TypeRepository;

@Service
public class SpProdServiceImpl implements SpProdService{

	@Autowired
	ProdStationAllocRepository prodStationAllocRepository;
	
	@Autowired
	GetStationAllocRepository getStationAllocRepository;
	
	@Autowired
	SpStationRepository spStationRepository;
	
	@Autowired
	GetSpStationRepository getSpStationRepository;
	
	@Autowired
	InstrumentRepository instrumentRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	GetEmployeeRepository getEmployeeRepository;
	
	@Autowired
	private MDeptRepository mDeptRepository;
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Autowired
	InstAllocToStationRepository instAllocToStationRepository;
	
	@Autowired
	GetInstAllocToStRepository getInstAllocToStRepository;
	
	@Autowired
	InstVerificationDetailRepository instVerificationDetailRepository;
	
	@Autowired
	InstVerifHeaderRepository instVerifHeaderRepository;
	
	@Autowired
	GetInstVerifHeaderRepository getInstVerifHeaderRepository;
	
	@Autowired
	GetInstrVerifHeaderRepository getInstrVerifHeaderRepository;
	
	@Autowired
	GetInstVerifDetailRepository getInstVerifDetailRepository;
	
	@Autowired
	SpCkAllocHeaderRepository spCkAllocHeaderRepository;
	
	@Autowired
	SpCkAllocDetailRepository spCkAllocDetailRepository;
	
	@Autowired
	StationSpecialCakeRepository stationSpecialCakeRepository;
	
	@Autowired
	GetAllocStationCkRepository getAllocStationCkRepository;
	
	@Autowired
	StationWiseCkCountRepository stationWiseCkCountRepository;
	
	@Autowired
	SpCakeOrdersRepository spCakeOrdersRepository;
	
	@Override
	public SpStation saveStation(SpStation spStation) {

		SpStation spStationRes=spStationRepository.save(spStation);
		
		return spStationRes;
	}
	
	@Override
	public Instrument saveInstrument(Instrument instrument) {

		Instrument instrumentRes=instrumentRepository.save(instrument);
		
		return instrumentRes;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {

		Employee employeeRes=employeeRepository.save(employee);
		
		return employeeRes;
	}

	@Override
	public SpStationList getSpStationList() {

		SpStationList spStationList=new SpStationList();
		Info info=new Info();
		
		List<GetSpStation> spStationListRes=getSpStationRepository.findGetSpStationByDelStatus();
		
		if(!spStationListRes.isEmpty())
		{
			info.setError(false);
            info.setMessage("SpStation List Found Successfully");
            spStationList.setSpStationList(spStationListRes);
            spStationList.setInfo(info);
		}
		else
		{
			info.setError(true);
            info.setMessage("SpStation List Not Found");
            spStationList.setInfo(info);
		}
		return spStationList;
	}

	@Override
	public EmployeeList getEmployeeList(int empType) {

		EmployeeList employeeList=new EmployeeList();
		Info info=new Info();
		
		List<GetEmployee> empListRes=getEmployeeRepository.findGetEmployeeByDelStatus(empType);
		
		if(!empListRes.isEmpty())
		{
			info.setError(false);
            info.setMessage("Employee List Found Successfully");
			employeeList.setEmployeeList(empListRes);
			employeeList.setInfo(info);
		}
		else
		{
			info.setError(true);
            info.setMessage("Employee List Not Found");
			employeeList.setInfo(info);
		}
		return employeeList;
	}

	@Override
	public InstrumentList getInstrumentList(int instType) {
		
		InstrumentList instrumentList=new InstrumentList();
		Info info=new Info();
		
		List<Instrument> instrumentRes=instrumentRepository.findAllByDelStatus(0,instType);
		
		if(!instrumentRes.isEmpty())
		{
			info.setError(false);
            info.setMessage("Instrument List Found Successfully");
            instrumentList.setInstrumentList(instrumentRes);
            instrumentList.setInfo(info);
		}
		else
		{
			info.setError(true);
            info.setMessage("Instrument List Not Found");
            instrumentList.setInfo(info);
		}
		return instrumentList;
	}

	@Override
	public SpStation getSpStationByStId(int stId) {

		SpStation spStation=spStationRepository.findSpStationByStId(stId);
		
		return spStation;
	}

	@Override
	public Employee getEmployeeByEmpId(int empId) {

		Employee employee=employeeRepository.findEmployeeByEmpId(empId);
		
		return employee;
	}

	@Override
	public Instrument getInstrumentByInstrumentId(int instrumentId) {

		Instrument instrument=instrumentRepository.findInstrumentByInstrumentId(instrumentId);
		return instrument;
	}
	
	@Override
	public ErrorMessage save(MDept MDept) {
		
		ErrorMessage errorMessage = new ErrorMessage();
		try {
				MDept dept = mDeptRepository.save(MDept);
					if (dept != null) 
					{
						errorMessage.setError(false);
						errorMessage.setMessage("Department Saved Successfully.");
					} 
					else 
					{
						errorMessage.setError(true);
						errorMessage.setMessage("Failed To Save Department.");
					}
		
			}catch(Exception e)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Failed To Save Department EXC");
			}
		return errorMessage;
	
	}


	@Override
	public MDeptList allListMDept() {
		
		MDeptList mDeptList = new MDeptList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<MDept> mDeptListRes = mDeptRepository.findMDeptByDelStatus(0);
			
			if(!mDeptListRes.isEmpty())
			{
			  mDeptList.setList(mDeptListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("MDept List Found Successfully.");
			  mDeptList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("MDept List Not Found.");
				mDeptList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("MDepts List Not Found");
			mDeptList.setErrorMessage(errorMessage);
		}
		return mDeptList;
	}

	@Override
	public ErrorMessage deleteMdeptById(int deptId) {

		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = mDeptRepository.deleteById(deptId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("MDept Deletion Failed");
						}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("MDept Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("MDept Deletion Failed EXC");
		}
		return errorMessage;
		
	}

	@Override
	public ErrorMessage deleteInstrument(int instrumentId) {
		
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = instrumentRepository.deleteByInstrumentId(instrumentId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Instrument Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Instrument Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Instrument Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteEmployee(int empId) {
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = employeeRepository.deleteByEmpId(empId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Employee Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Employee Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Employee Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteSPStation(int spId) {
	
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int delete = spStationRepository.deleteBySpId(spId);
			if(delete==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("SPStation Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("SPStation Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("SPStation Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public MDept getDepartment(int deptId) {

		MDept mDept=mDeptRepository.findMDeptByDeptId(deptId);
		return mDept;
	}

	@Override
	public Shift saveShift(Shift shift) {

		Shift shiftRes=shiftRepository.save(shift);
		return shiftRes;
	}

	@Override
	public Shift getShift(int shiftId) {

		Shift shiftRes=shiftRepository.findShiftByShiftId(shiftId);
		return shiftRes;
	}

	@Override
	public ShiftList getShiftList() {

		ShiftList shiftList = new ShiftList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<Shift> shiftListRes = shiftRepository.findShiftByDelStatus(0);
			
			if(!shiftListRes.isEmpty())
			{
				shiftList.setShiftList(shiftListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("ShiftList Found Successfully.");
			       shiftList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("ShiftList Not Found.");
				shiftList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("ShiftList Not Found");
			shiftList.setErrorMessage(errorMessage);
		}
		return shiftList;
	}

	@Override
	public ErrorMessage deleteShift(int shiftId) {
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int deleteRes = shiftRepository.deleteByShiftId(shiftId);
			if(deleteRes==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Shift Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Shift Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Shift Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public TypeList getTypeList(int typeId) {

		TypeList typeList = new TypeList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<MType> typeListRes = typeRepository.findMTypeByDelStatusAndSubType(0,typeId);
			
			if(!typeListRes.isEmpty())
			{
				   typeList.setTypeList(typeListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("TypeList Found Successfully.");
			       typeList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("TypeList Not Found.");
				typeList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("TypeList Not Found");
			typeList.setErrorMessage(errorMessage);
		}
		return typeList;
	}

	@Override
	public StationAllocation saveProdStationAllocation(StationAllocation stationAllocation) {

		StationAllocation sTAllocation=prodStationAllocRepository.save(stationAllocation);
		
		return sTAllocation;
	}

	@Override
	public ErrorMessage deleteStationAllocation(int allocationId) {
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int deleteRes = prodStationAllocRepository.deleteByAllocationId(allocationId);
			if(deleteRes==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("StationAllocation Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("StationAllocation Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("StationAllocation Deletion Failed EXC");
		}
		return errorMessage;
	}

	@Override
	public StationAllocList getStationAllocList() {

		StationAllocList stationAllocList = new StationAllocList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<GetStationAllocation> stationListRes = getStationAllocRepository.findStationAllocations();
			
			if(!stationListRes.isEmpty())
			{
				stationAllocList.setStationAllocationList(stationListRes);
			       errorMessage.setError(false);
			       errorMessage.setMessage("StationAllocList Found Successfully.");
			       stationAllocList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("StationAllocList Not Found.");
				stationAllocList.setErrorMessage(errorMessage);
			}
			
		}catch(Exception e)
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("StationAllocList Not Found");
			stationAllocList.setErrorMessage(errorMessage);
		}
		return stationAllocList;
	}

	@Override
	public StationAllocation getStationAlloc(int allocationId) {

		StationAllocation stationAllocationRes = prodStationAllocRepository.findStationAllocationByAllocationId(allocationId);
		return stationAllocationRes;
	}

	@Override
	public GetEmployeeList getEmployeesByType(int empType) {
		
		GetEmployeeList employeeList=new GetEmployeeList();
		ErrorMessage errorMessage=new ErrorMessage();
		
		List<Employee> empListRes=employeeRepository.findEmployeeByEmpTypeAndDelStatus(empType,0);
		
		if(!empListRes.isEmpty())
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Employee List Found Successfully");
			employeeList.setGetEmpList(empListRes);
			employeeList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Employee List Not Found");
			employeeList.setErrorMessage(errorMessage);
		}
		
		
		return employeeList;
	}

	@Override
	public InstAllocToStation saveInstAllocToStation(InstAllocToStation instAllocToStation) {

		InstAllocToStation instAllocToStationRes=instAllocToStationRepository.save(instAllocToStation);
		
		return instAllocToStationRes;
	}

	@Override
	public ErrorMessage deleteInstAllocToStation(int instAllocId) {

		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int deleteRes = instAllocToStationRepository.deleteByInstAllocId(instAllocId);
			if(deleteRes==0)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("InstAllocToStation Deletion Failed");
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("InstAllocToStation Successfully Deleted");
			}
			
		}catch(Exception e)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("InstAllocToStation Deletion Failed EXC");
		}
		return errorMessage;
		
	}

	@Override
	public InstAllocToStationList getInstAllocToStationList() {
		
		InstAllocToStationList instAllocToStList = new InstAllocToStationList();
		Info info = new Info();
		try
		{
			List<GetInstAllocToStation> instAllocList = getInstAllocToStRepository.findInstAllocToStationByDelStatus();
			
			if(!instAllocList.isEmpty())
			{
				instAllocToStList.setInstAllocList(instAllocList);
				info.setError(false);
				info.setMessage("instAllocList Found Successfully.");
			    instAllocToStList.setInfo(info);
			}
			else
			{
				info.setError(false);
				info.setMessage("instAllocList Not Found.");
				instAllocToStList.setInfo(info);
			}
			
		}catch(Exception e)
		{
			
			info.setError(false);
			info.setMessage("instAllocList Not Found.");
			instAllocToStList.setInfo(info);
		}
		return instAllocToStList;
	}

	@Override
	public InstAllocToStation getInstAllocToStation(int instAllocId) {

		InstAllocToStation instAllocToStationRes=instAllocToStationRepository.findInstAllocToStationByInstAllocId(instAllocId);
		
		return instAllocToStationRes;
	}

	@Override
	public InstVerificationHeader getStationStatus(int stationId) {
		InstVerificationHeader instVerificationHeader=null;
		try
		{
		 instVerificationHeader=instVerifHeaderRepository.findByStationIdAndStStatusAndDelStatus(stationId,1,0);
		
		 if(instVerificationHeader!=null)
		 {
		   int instVerifHId=instVerificationHeader.getInstVerifHId();
		
		   List<InstVerificationDetail> instVerifDetailList=instVerificationDetailRepository.findByInstVerifHId(instVerifHId); 
		
		   instVerificationHeader.setInstVerificationDetailList(instVerifDetailList);
		
		   instVerificationHeader.setError(false);
		   instVerificationHeader.setMessage("InstVerificationHeader Found Successfully");
		 }
		 else
		 {
			 instVerificationHeader=new InstVerificationHeader();
			 instVerificationHeader.setError(true);
			 instVerificationHeader.setMessage("InstVerificationHeader Not Found");
		 }
		}
		catch(Exception e)
		{
			 instVerificationHeader=new InstVerificationHeader();
			 instVerificationHeader.setError(true);
			 instVerificationHeader.setMessage("InstVerificationHeader Not Found");
		}
		
		return instVerificationHeader;
	} 

	@Override
	public InstVerificationHeader saveInstVerificationHeader(InstVerificationHeader instVerificationHeader) {

		InstVerificationHeader instVerificationHeaderRes=instVerifHeaderRepository.save(instVerificationHeader);
		
		int hId=instVerificationHeaderRes.getInstVerifHId();
		
		List<InstVerificationDetail> instVerificationDetailList=instVerificationHeader.getInstVerificationDetailList();
		for(int i=0;i<instVerificationDetailList.size();i++)
		{
			InstVerificationDetail instVerificationDetailRes =instVerificationDetailList.get(i);
			instVerificationDetailRes.setInstVerifHId(hId);
			
			 instVerificationDetailRes=instVerificationDetailRepository.saveAndFlush(instVerificationDetailRes);
		}
		
		return instVerificationHeaderRes;
	}

	@Override
	public List<GetInstVerifHeader> getInstVerHeaders() {

		List<GetInstVerifHeader> instVerificationHeaderRes=getInstVerifHeaderRepository.findAllByDelStatus();
		
		return instVerificationHeaderRes;
	}

	@Override
	public GetInstrVerifHeader getInstVerifHDetails(int instVerifId) {
		GetInstrVerifHeader instVerificationHeaderRes=null;
		try
		{
		 instVerificationHeaderRes=getInstrVerifHeaderRepository.findGetInstrVerifHeaderByInstVerifHId(instVerifId);
		
		 List<GetInstVerifDetail> getInstVerifDetailRes=getInstVerifDetailRepository.findAllByInstVerifHId(instVerifId);
		
		instVerificationHeaderRes.setInstVerificationDetailList(getInstVerifDetailRes);
		if(instVerificationHeaderRes!=null)
		{
			instVerificationHeaderRes.setError(false);
			instVerificationHeaderRes.setMessage("InstVerfHeader Found Successfully");
		}
		}
		catch(Exception e)
		{
			instVerificationHeaderRes=new GetInstrVerifHeader();
			instVerificationHeaderRes.setError(true);
			instVerificationHeaderRes.setMessage("Exception In Getting Header With Provided Id");
			System.out.println("Exception In /getInstVerifHDetails"+e.getMessage());
		}
		return instVerificationHeaderRes;
	}

	@Override
	public SpCkAllocHeader saveSpCkAllocHeader(SpCkAllocHeader spCkAllocHeader) {

		SpCkAllocHeader spCakeHeaderRes=spCkAllocHeaderRepository.saveAndFlush(spCkAllocHeader);
		
		int spCakeAllocId=spCakeHeaderRes.getSpCkAllocId();
		
		List<SpCkAllocDetail> spCkAllocDetailList=spCkAllocHeader.getSpCkAllocDetailList();
		
		for(int i=0;i<spCkAllocDetailList.size();i++)
		{  
			SpCkAllocDetail spCkAllocDetailRes=spCkAllocDetailList.get(i);
			spCkAllocDetailRes.setSpCkAllocId(spCakeAllocId);
			int updateIsAllocated=spCakeOrdersRepository.updateSpCkAllocDId(spCkAllocDetailList.get(i).gettSpCakeId());
					
			SpCkAllocDetail spCkAllocDetail=spCkAllocDetailRepository.saveAndFlush(spCkAllocDetailRes);
		} 
		return spCakeHeaderRes;
	}

	@Override
	public StationSpCakeList getStationSpCakeList() {

		List<StationSpCake> stationSpCakeRes=stationSpecialCakeRepository.findStationSpCake();
		StationSpCakeList stationSpCakeList=new StationSpCakeList();
		
		if(!stationSpCakeRes.isEmpty())
		{
			Info info=new Info();
			info.setError(false);
			info.setMessage("Station SpCake Found Successfully");
			stationSpCakeList.setStationSpCakeList(stationSpCakeRes);
			stationSpCakeList.setInfo(info);
		}
		else
		{
			Info info=new Info();
			info.setError(true);
			info.setMessage("Station SpCake Not Found");
			
			stationSpCakeList.setInfo(info);

		}
		return stationSpCakeList;
	}

	@Override
	public List<GetAllocStationCk> getAllocStationCk(List<String> stationId, String fromDate, String toDate) {

		List<GetAllocStationCk> getAllocStationCkList=getAllocStationCkRepository.findStationwiseAllocCk(stationId,fromDate,toDate);
		
		return getAllocStationCkList;
	}

	@Override
	public List<StationWiseCkCount> getStationwiseCkCount() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		List<StationWiseCkCount> stationWiseCkCount=stationWiseCkCountRepository.findStationwiseCkCount(dateFormat.format(date));
		return stationWiseCkCount;
	}


}
