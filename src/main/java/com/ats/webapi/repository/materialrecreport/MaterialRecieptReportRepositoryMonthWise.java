package com.ats.webapi.repository.materialrecreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; 
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportMonthWise;

public interface MaterialRecieptReportRepositoryMonthWise extends JpaRepository<GetMaterialRecieptReportMonthWise,Long>{
	
	@Query(value="select\r\n" + 
			"        mrn_id,\r\n" + 
			"        monthname(inv_book_date) as month,\r\n" + 
			"        sum(basic_value) as basic_value,\r\n" + 
			"        sum(disc_amt+disc_amt2+other1+other2) as disc_amt,\r\n" + 
			"        sum(freight_amt) as freight_amt,\r\n" + 
			"        sum(insurance_amt) as insurance_amt,\r\n" + 
			"        sum(other3+other4) as other,sum(cgst) as cgst,\r\n" + 
			"        sum(sgst) as sgst,\r\n" + 
			"        sum(igst) as igst,\r\n" + 
			"        sum(cess) as cess,\r\n" + 
			"        sum(bill_amount) as bill_amount   \r\n" + 
			"    from\r\n" + 
			"        t_material_receipt_note    \r\n" + 
			"    where\r\n" + 
			"        supplier_id in (:suppId)  \r\n" + 
			"        and  inv_book_date between :fromDate and :toDate   \r\n" + 
			"    group by\r\n" + 
			"        month",nativeQuery=true) 
	List<GetMaterialRecieptReportMonthWise> materialRecieptMonthWiseReport( @Param("suppId")List<String> suppId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);
 

}
