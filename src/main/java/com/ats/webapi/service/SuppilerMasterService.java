package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.SupplierMaster.SupPaymentTerms;
import com.ats.webapi.model.SupplierMaster.SupPaymentTermsList;
import com.ats.webapi.model.SupplierMaster.SupplierDetails;
import com.ats.webapi.model.SupplierMaster.Transporter;
import com.ats.webapi.model.SupplierMaster.TransporterList;
import com.ats.webapi.model.tally.SuppliersList;

public interface SuppilerMasterService {
	
	SupplierDetails addSuppler(SupplierDetails supplierDetails);

	SupplierDetails getSupplier(int suppId);

	int deleteSupplier(int suppId);

	List<SupplierDetails> getAllSupplier();

	TransporterList showAllTransporter();

	SupPaymentTermsList showPaymentTerms();

	ErrorMessage saveTransporter(Transporter transporter);

	ErrorMessage saveSupPaymentTerms(SupPaymentTerms supPaymentTerms);

	ErrorMessage deleteTransporter(int tranId);

	ErrorMessage deleteSupPaymentTerm(int payId);

	SupPaymentTerms getSupPaymentTerm(int payId);

	Transporter getTransporter(int tranId);

	SuppliersList getAllSupplierForTally();

	ErrorMessage updateSupplier(int suppId, int isTallySync);
}
