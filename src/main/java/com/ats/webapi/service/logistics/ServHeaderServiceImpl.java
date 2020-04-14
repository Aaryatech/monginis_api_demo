package com.ats.webapi.service.logistics;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.ServDetail;
import com.ats.webapi.model.logistics.ServHeader; 
import com.ats.webapi.repository.logistics.ServDetailRepository;
import com.ats.webapi.repository.logistics.ServHeaderRepository; 

@Service
public class ServHeaderServiceImpl implements ServHeaderService{
	
	@Autowired 
	ServHeaderRepository servHeaderRepository;
	
	@Autowired 
	ServDetailRepository servDetailRepository;

	@Override
	public ServHeader postServHeader(ServHeader servHeader) {
		ServHeader insertservHeader = new ServHeader();
		List<ServDetail> insertServDetail = new ArrayList<ServDetail>();
		 try
		 {
			 insertservHeader = servHeaderRepository.save(servHeader);
			 if(insertservHeader!=null)
			 {
				 for(int i=0;i<servHeader.getServDetail().size();i++)
					 servHeader.getServDetail().get(i).setServId(insertservHeader.getServId());
				 
				 insertServDetail = servDetailRepository.save(servHeader.getServDetail());
				 insertservHeader.setServDetail(insertServDetail);
					 
			 }
			 
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return insertservHeader;
	}

	@Override
	public List<ServHeader> getAllServHeader() {
		List<ServHeader> getAllServHeader = new ArrayList<ServHeader>();
		try {
			  
			getAllServHeader = servHeaderRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllServHeader.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllServHeader;
	}

	@Override
	public ServHeader getServHeaderAndDetailById(int servId) {
		ServHeader getServHeaderAndDetailById = new ServHeader();
		try {
			  
			getServHeaderAndDetailById = servHeaderRepository.findByServId(servId);
			
			List<ServDetail> servDetailList = new ArrayList<ServDetail>();
			
			servDetailList = servDetailRepository.findByServIdAndDelStatus(servId,0);
			
			getServHeaderAndDetailById.setServDetail(servDetailList); 
			System.out.println(getServHeaderAndDetailById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getServHeaderAndDetailById;
	}

	@Override
	public List<ServHeader> showServicingListPendingAndCurrentDate() {
		List<ServHeader> showServicingListPendingAndCurrentDate = new ArrayList<ServHeader>();
		try {
			  
			Date date = new Date();


			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			String today = formatter.format(date); 

			System.out.println("today"+today);
			showServicingListPendingAndCurrentDate = servHeaderRepository.showServicingListPendingAndCurrentDate(today);
			 
			System.out.println(showServicingListPendingAndCurrentDate.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return showServicingListPendingAndCurrentDate;
	}

	@Override
	public List<ServHeader> showServicingListBetweenDate(String fromDate, String toDate, int type) {
		List<ServHeader> showServicingListBetweenDate = new ArrayList<ServHeader>();
		try {
			  
			  
			showServicingListBetweenDate = servHeaderRepository.showServicingListBetweenDate(fromDate,toDate,type);
			 
			System.out.println(showServicingListBetweenDate.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return showServicingListBetweenDate;
	}

	@Override
	public Info approvedServiceHeader(int servId) {
		Info info = new Info();
		
		try
		{
			int approved=1;
			int update = servHeaderRepository.approvedServiceHeader(servId,approved);
			if(update==0)
			{
				info.setError(false);
				info.setMessage("updated Successfully ");
			}
			else
			{
				info.setError(true);
				info.setMessage("failed to Update ");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public List<ServHeader> showServicingListBetweenDateAndFilter(String fromDate, String toDate, int type, int vehId) {
		List<ServHeader> showServicingListBetweenDateAndFilter = new ArrayList<ServHeader>();
		try {
			  
			  
			showServicingListBetweenDateAndFilter = servHeaderRepository.showServicingListBetweenDateAndFilter(fromDate,toDate,type,vehId);
			 
			System.out.println(showServicingListBetweenDateAndFilter.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return showServicingListBetweenDateAndFilter;
	}

	@Override
	public List<ServHeader> getServicingListBetweenDateByTypeId(String fromDate, String toDate, int typeId) {
		List<ServHeader> getServicingListBetweenDateByTypeId = new ArrayList<ServHeader>();
		try {
			  
			  
			getServicingListBetweenDateByTypeId = servHeaderRepository.getServicingListBetweenDateByTypeId(fromDate,toDate,typeId);
			 
			System.out.println(getServicingListBetweenDateByTypeId.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getServicingListBetweenDateByTypeId;
	}

}
