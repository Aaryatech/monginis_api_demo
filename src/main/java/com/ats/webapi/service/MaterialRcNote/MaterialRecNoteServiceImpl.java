package com.ats.webapi.service.MaterialRcNote;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage; 
import com.ats.webapi.model.GetMaterialRecNoteList;
import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.model.MaterialRecNoteDetails;
import com.ats.webapi.model.tally.MaterialRecNoteDetail;
import com.ats.webapi.model.tally.MaterialRecNoteList;
import com.ats.webapi.model.tally.MaterialReceiptNote;
import com.ats.webapi.repository.MaterialRNoteDetailRepository;
import com.ats.webapi.repository.MaterialRecNoteRepository;
import com.ats.webapi.repository.tally.MaterialRecNoteDetailRepository;
import com.ats.webapi.repository.tally.MaterialReceiptNoteRepository;

@Service
public class MaterialRecNoteServiceImpl implements MaterialRecNoteService{

	@Autowired
	MaterialRecNoteRepository materialRecNoteRepository;
	
	@Autowired
	MaterialRNoteDetailRepository materialRNoteDetailRepository;

	@Autowired
	MaterialReceiptNoteRepository materialReceiptNoteRepository;

	@Autowired
	MaterialRecNoteDetailRepository materialRecNoteDetailRepository;
	
	@Override
	public MaterialRecNote postMaterialRecNote(MaterialRecNote materialRecNote) {
		ErrorMessage errorMessage = null;
        MaterialRecNote materialRec=new MaterialRecNote();
        try {
        	//SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        	//Date utilCurrentDate = sf.parse(sf.format(new Date()));
			// SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			// Date now = new Date();
            
      //  if(materialRecNote.getStatus()==1)
      //  {
       // 	materialRecNote.setMrnStoreDate(now);
        	System.out.println("podate in service imp "+materialRecNote.getPoDate());
			 materialRec=materialRecNoteRepository.save(materialRecNote);
			    
       // }
       // if(materialRec.getStatus()==0)
       // {
      //  	materialRec.setGateEntryDate(now);
        //    materialRec=materialRecNoteRepository.save(materialRecNote);
       // }
        
        int mrnId=materialRec.getMrnId();
        System.out.println(materialRec.getGateEntryDate());
        List<MaterialRecNoteDetails> materialRecNoteDetailsList=new ArrayList<MaterialRecNoteDetails>();
        for(int i=0;i<materialRecNote.getMaterialRecNoteDetails().size();i++)
        {
            MaterialRecNoteDetails materialRecNoteDetail=materialRecNote.getMaterialRecNoteDetails().get(i);
            materialRecNoteDetail.setMrnId(mrnId);
            MaterialRecNoteDetails materialRecNoteDetailRes=materialRNoteDetailRepository.save(materialRecNoteDetail);
             
            materialRecNoteDetailsList.add(materialRecNoteDetailRes);
        }
        materialRec.setMaterialRecNoteDetails(materialRecNoteDetailsList);
        
          if(materialRec!=null)
          {
              errorMessage=new ErrorMessage();
              errorMessage.setError(false);
              errorMessage.setMessage("MaterialRecNote Inserted Successfully.");
              
          }
         
           
        }
        catch(Exception e)
        {
            System.out.println("Exception In Saving Material Rec Note.");
             errorMessage=new ErrorMessage();
               errorMessage.setError(true);
               errorMessage.setMessage("MaterialRecNote Insertion Failed.");
        }
        return materialRec;
        
        
    }
	@Override
	public GetMaterialRecNoteList getMaterialRecNote(List<String> status) {

		GetMaterialRecNoteList getMaterialRecNoteList=new GetMaterialRecNoteList();
		 
		ErrorMessage errorMessage;
		try
		{
			List<MaterialRecNote> materialRecNoteList=materialRecNoteRepository.getMaterialByStatus(status);
			 
		
		if(materialRecNoteList!=null) {
			
			errorMessage=new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("Material Rec Note List Found Successfully");
			}
		else {
					
					errorMessage=new ErrorMessage();
					errorMessage.setError(true);
					errorMessage.setMessage("Material Rec Note List Found Failed");
		}
			getMaterialRecNoteList.setErrorMessage(errorMessage);
			getMaterialRecNoteList.setMaterialRecNoteList(materialRecNoteList);
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in getting all MaterialRecNote.");
			errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("Material Rec Note List Not Found");
			
			getMaterialRecNoteList.setErrorMessage(errorMessage);

		}
		return getMaterialRecNoteList;
	}
	@Override
	public MaterialRecNote getMaterialRecNotesHeaderDetails(int mrnId) {
		

		MaterialRecNote materialRecNote=materialRecNoteRepository.findByMrnId(mrnId);
		
		//int mrnId=materialRecNote.getMrnId();
		
		List<MaterialRecNoteDetails> materialRecNoteDetailsList=materialRNoteDetailRepository.getByMrnId(mrnId);
		materialRecNote.setMaterialRecNoteDetails(materialRecNoteDetailsList);
		return materialRecNote;
	}
	@Override
	public MaterialRecNote getMaterialRecNotesHeaderDetailsNew(int mrnId) {
		

		MaterialRecNote materialRecNote=materialRecNoteRepository.findByMrnId(mrnId);
		
		//int mrnId=materialRecNote.getMrnId();
		
		List<MaterialRecNoteDetails> materialRecNoteDetailsList=materialRNoteDetailRepository.getByMrnIdNew(mrnId);
		materialRecNote.setMaterialRecNoteDetails(materialRecNoteDetailsList);
		return materialRecNote;
	}
	@Override
	public MaterialRecNoteList getAllInwards() {

		MaterialRecNoteList materialRecNoteList=new MaterialRecNoteList();
		List<MaterialReceiptNote> materialRecNoteResList=materialReceiptNoteRepository.getAllInwards();
		if(!materialRecNoteResList.isEmpty())
		{
			
		  ErrorMessage errorMessage=new ErrorMessage();
		  errorMessage.setError(false);
		  errorMessage.setMessage("Material Receipt Notes Found");
		  materialRecNoteList.setMaterialRecNoteResList(materialRecNoteResList);
		  materialRecNoteList.setErrorMessage(errorMessage);
		}
		else
		{
			 ErrorMessage errorMessage=new ErrorMessage();
			  errorMessage.setError(false);
			  errorMessage.setMessage("Material Receipt Notes Found");
			  materialRecNoteList.setErrorMessage(errorMessage);
		}
		return materialRecNoteList;
	}
	@Override
	public ErrorMessage updateInward(int mrnId, int isTallySync) {

		ErrorMessage errorMessage=new ErrorMessage();
		
		int i=materialRecNoteRepository.updateInward(mrnId,isTallySync);
	
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Inward Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Inward Updation Failed");
			
		}
		return errorMessage;
	}
	
	

}
