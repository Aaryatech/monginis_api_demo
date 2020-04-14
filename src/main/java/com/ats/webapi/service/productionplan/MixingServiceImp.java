package com.ats.webapi.service.productionplan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetMixingList;
import com.ats.webapi.model.MixingDetailed;
import com.ats.webapi.model.MixingHeader;
import com.ats.webapi.repository.MixingHeaderRepository;
import com.ats.webapi.repository.MixingDetailedRepository;

@Service
public class MixingServiceImp implements MixingService {
	
	@Autowired
	MixingHeaderRepository mixingRepository;
	@Autowired
	MixingDetailedRepository  mixingDetailedRepository;

	@Override
	public MixingHeader insertMixingHeaderndDetailed(MixingHeader mixingHeader) {
		
		MixingHeader mixingdata = new MixingHeader();
		try
		{
			if(mixingHeader.getMixId()==0)
			{
				Date Mixdate = new Date();
				System.out.println("date "+Mixdate);
				mixingHeader.setMixDate(Mixdate);
				
				mixingdata = mixingRepository.save(mixingHeader);
				
				System.out.println("mixingdata  "+mixingdata.toString());
			//	List<MixingDetailed> mixingDetailedlist = new ArrayList<MixingDetailed>();
				//mixingDetailedlist = mixingHeader.getMixingDetailed();
				int mixId=mixingdata.getMixId();
				
				for(int i=0;i<mixingHeader.getMixingDetailed().size();i++)
					mixingHeader.getMixingDetailed().get(i).setMixingId(mixId);
				
				
				 mixingDetailedRepository.save(mixingHeader.getMixingDetailed());
					 
		 
				
				if(mixingdata!=null)
				{
					System.out.println("successfullyinsertted");
				}
				
			}
			else
			{
				
				mixingdata = mixingRepository.save(mixingHeader);
				
				System.out.println("mixingdata  "+mixingdata.toString());
			//	List<MixingDetailed> mixingDetailedlist = new ArrayList<MixingDetailed>();
				//mixingDetailedlist = mixingHeader.getMixingDetailed();
				int mixId=mixingdata.getMixId();
				
				for(int i=0;i<mixingHeader.getMixingDetailed().size();i++)
				{ 
					  
						MixingDetailed mixingDetailed = mixingHeader.getMixingDetailed().get(i);
						mixingDetailed.setMixingId(mixId);
						mixingDetailed=mixingDetailedRepository.save(mixingDetailed);
					 
				}
				
				if(mixingdata!=null)
				{
					System.out.println("successfullyinsertted");
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mixingdata;
		
	}

	@Override
	public GetMixingList gettMixingHeaderndDetailed(String frmdate,String todate) {
		
		GetMixingList getMixingList = new GetMixingList();
		ErrorMessage errorMessage = new ErrorMessage();
		
		List<MixingHeader> mixingHeaderlist=new ArrayList<MixingHeader>();
		try
		{
			/*String frdate=Common.convertToYMD(frmdate);
			String tdate=Common.convertToYMD(todate);*/
			
			System.out.println("from date "+frmdate+"  todate  :"+todate);
			mixingHeaderlist=mixingRepository.getAlllist(frmdate,todate);
			
			/*for(int i=0;i<mixingHeaderlist.size();i++)
			{
				List<MixingDetailed> mixingDetailed= new ArrayList<MixingDetailed>();
				int mixId=mixingHeaderlist.get(i).getMixId();
				mixingDetailed=mixingDetailedRepository.gemixdetailedListById(mixId);
				mixingHeaderlist.get(i).setMixingDetailed(mixingDetailed);
				System.out.println(mixingDetailed.toString());
			}*/
			
			getMixingList.setMixingHeaderList(mixingHeaderlist);
			errorMessage.setError(false);
			errorMessage.setMessage("success");
			getMixingList.setErrorMessage(errorMessage);
			
		}catch(Exception e)
		{
			System.out.println("erorrrrr: "+e.getMessage());
			errorMessage.setError(true);
			errorMessage.setMessage("unsuccess");
			getMixingList.setErrorMessage(errorMessage);
		}
		
		
		
		return getMixingList;
	
	}

	@Override
	public MixingHeader gettMixingdetaildwithId(int mixId) {
		
		MixingHeader mixingdata = new MixingHeader();
		try
		{
			mixingdata=mixingRepository.getBymixId(mixId);
			
			
				List<MixingDetailed> mixingDetailed= new ArrayList<MixingDetailed>();
				mixingDetailed=mixingDetailedRepository.gemixdetailedListById(mixId);
				mixingdata.setMixingDetailed(mixingDetailed);
				
			
					
		}catch(Exception e)
		{
			System.out.println("in Implementation  "+e.getMessage());
		}
		return mixingdata;
		
	}

	@Override
	public int updateisBom(int mixId) {
		int updateisBom=0;
		
		try
		{
			updateisBom=mixingRepository.updateisBom(mixId);
		}catch(Exception e)
		{
			System.out.println("int updateIsbom "+e.getMessage());
		}
		return updateisBom;
		
		
	}

}
