package com.ats.webapi.service;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SupplierMaster.SupPaymentTerms;
import com.ats.webapi.model.SupplierMaster.SupPaymentTermsList;
import com.ats.webapi.model.SupplierMaster.SupplierDetails;
import com.ats.webapi.model.SupplierMaster.Transporter;
import com.ats.webapi.model.SupplierMaster.TransporterList;
import com.ats.webapi.model.tally.SuppliersList;
import com.ats.webapi.repository.SupPaymentTermsRepository;
import com.ats.webapi.repository.SupplierDetailRepository;
import com.ats.webapi.repository.TransporterRepository;

@Service
public class SuppilerMasterServiceImpl implements SuppilerMasterService{

	@Autowired
	SupplierDetailRepository supplierDetailRepository;
	
	@Autowired
	TransporterRepository transporterRepository;
	
	@Autowired
	SupPaymentTermsRepository supPaymentTermsRepository;
	
	@Override
	public SupplierDetails addSuppler(SupplierDetails supplierDetails) {
		
		SupplierDetails supplier=supplierDetailRepository.save(supplierDetails);
		return supplier;
	}

	@Override
	public SupplierDetails getSupplier(int suppId) {
		 
		
		SupplierDetails supplierDetails=supplierDetailRepository.findBySuppId(suppId);
		return supplierDetails;
	}

	@Override
	public int deleteSupplier(int suppId) {

		int result=supplierDetailRepository.deleteSupplier(suppId);
		return result;
	}

	@Override
	public List<SupplierDetails> getAllSupplier() {
		
		int delStatus=0;
		List<SupplierDetails> supplierDetailsList=supplierDetailRepository.findByDelStatus(delStatus);
		return supplierDetailsList;
	}

	@Override
	public TransporterList showAllTransporter() {
		
		TransporterList transporterList=new TransporterList();
		try
		{
		ErrorMessage errorMessage=new ErrorMessage();
		
			List<Transporter> transporterListRes=transporterRepository.findTransporterByDelStatus(0);
			
			if(transporterListRes==null)
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Transporter List Note Found");
				transporterList.setErrorMessage(errorMessage);
				
			}else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("Transporter List Found Successfully.");
				transporterList.setErrorMessage(errorMessage);
				transporterList.setTransporterList(transporterListRes);

			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in getting Transporter List.");
			
		}
		return transporterList;
	}

	@Override
	public SupPaymentTermsList showPaymentTerms() {
		
		SupPaymentTermsList supPaymentTermsList=new SupPaymentTermsList();
		ErrorMessage errorMessage=new ErrorMessage();
		
		List<SupPaymentTerms> supPaymentTermsListRes=supPaymentTermsRepository.findSupPaymentTermsByDelStatus(0);
		
		if(supPaymentTermsListRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("SupPaymentTerms List Note Found");
			supPaymentTermsList.setErrorMessage(errorMessage);
			
		}else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("SupPaymentTerms List Found Successfully.");
			supPaymentTermsList.setErrorMessage(errorMessage);
			supPaymentTermsList.setSupPaymentTermsList(supPaymentTermsListRes);

		}
	
	return supPaymentTermsList;
	}

	@Override
	public ErrorMessage saveTransporter(Transporter transporter) {

		ErrorMessage errorMessage=new ErrorMessage();
		Transporter transporterRes=transporterRepository.save(transporter);

		if(transporterRes!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Transposter Data Saved Successfully.");
			
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Transporter Data Failed to Save.");
			
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage saveSupPaymentTerms(SupPaymentTerms supPaymentTerms) {

		ErrorMessage errorMessage=new ErrorMessage();
		SupPaymentTerms supPaymentTermsRes=supPaymentTermsRepository.save(supPaymentTerms);

		if(supPaymentTermsRes!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("SupPaymentTerms Data Saved Successfully.");
			
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("SupPaymentTerms Data Failed to Save.");
			
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteTransporter(int tranId) {

		Transporter transporter=transporterRepository.findTransporterByTranId(tranId);
		
		transporter.setDelStatus(1);
		
		Transporter TransporterRes=transporterRepository.save(transporter);
		
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(TransporterRes!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Transporter deleted Successfully.");
			
		}
		else
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("Transporter Deletion Failed.");
			
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteSupPaymentTerm(int payId) {

		SupPaymentTerms supPaymentTerms=supPaymentTermsRepository.findSupPaymentTermsByPayId(payId);
		
		supPaymentTerms.setDelStatus(1);
		
		SupPaymentTerms supPaymentTermsRes=supPaymentTermsRepository.save(supPaymentTerms);
		
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(supPaymentTermsRes!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("SupPaymentTerms deleted Successfully.");
			
		}
		else
		{
			
			errorMessage.setError(true);
			errorMessage.setMessage("SupPaymentTerms Deletion Failed.");
			
		}
		return errorMessage;
	}

	@Override
	public SupPaymentTerms getSupPaymentTerm(int payId) {
		SupPaymentTerms supPaymentTerms=null;
		try {
			 supPaymentTerms=supPaymentTermsRepository.findSupPaymentTermsByPayId(payId);
		}
		catch(Exception e)
		{
			supPaymentTerms=new SupPaymentTerms();
		}
		
		return supPaymentTerms;
	}

	@Override
	public Transporter getTransporter(int tranId) {
		Transporter transporter=null;
		try {
			transporter=transporterRepository.findTransporterByTranId(tranId);
		}
		catch(Exception e)
		{
			transporter=new Transporter();
		}
		
		return transporter;
	}

	@Override
	public SuppliersList getAllSupplierForTally() {
        ErrorMessage eMessage=new ErrorMessage();
        SuppliersList supplierList=new SuppliersList();

		try
		{
			List<SupplierDetails> supplierDetailsList=supplierDetailRepository.findByIsTallySyncAndDelStatus(0,0);
            
			if(!supplierDetailsList.isEmpty())
			{
				eMessage.setError(false);
				eMessage.setMessage("Suppliers Found Successfully");
				supplierList.setSupplierList(supplierDetailsList);
				supplierList.setErrorMessage(eMessage);
				
			}
			else
			{
				eMessage.setError(true);
				eMessage.setMessage("Suppliers Not Found");
				supplierList.setErrorMessage(eMessage);
			}
		}
		catch(Exception e)
		{
			eMessage.setError(true);
			eMessage.setMessage("Suppliers Not Found:Exc");
			supplierList.setErrorMessage(eMessage);
		}
		return supplierList;
	}

	@Override
	public ErrorMessage updateSupplier(int suppId, int isTallySync) {
		ErrorMessage errorMessage=new ErrorMessage();
	
			int i=supplierDetailRepository.updateSupplier(suppId,isTallySync);
		
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Supplier Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Supplier Updation Failed");
			
		}
		return errorMessage;
	}

}
