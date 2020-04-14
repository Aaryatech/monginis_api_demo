package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GetBillHeader;
import com.ats.webapi.model.bill.FrBillHeaderForPrint;

public interface GetBillHeaderForPrintRepo extends JpaRepository<FrBillHeaderForPrint, Integer> {
	
	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ ",t_bill_header.fr_id,t_bill_header.fr_code,t_bill_header.veh_no,t_bill_header.bill_time,t_bill_header.ex_varchar1,t_bill_header.ex_varchar2,"
			+ " t_bill_header.tax_applicable,t_bill_header.grand_total,t_bill_header.taxable_amt, "
			+ " t_bill_header.total_tax,t_bill_header.status,t_bill_header.remark,t_bill_header.del_status,t_bill_header.party_name,t_bill_header.party_gstin,t_bill_header.party_address, "
			+ " m_franchisee.fr_name,m_franchisee.fr_address,m_franchisee.is_same_state FROM t_bill_header,m_franchisee WHERE "
			+ " t_bill_header.bill_date BETWEEN :fromDate AND :toDate "
			+ " AND t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.del_status=0 order by t_bill_header.ex_varchar1,t_bill_header.invoice_no" + 
			"",nativeQuery=true)
	
	List<FrBillHeaderForPrint> getFrBillHeaderForPrint(@Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ ",t_bill_header.fr_id,t_bill_header.fr_code,t_bill_header.veh_no,t_bill_header.bill_time,t_bill_header.ex_varchar1,t_bill_header.ex_varchar2,"
			+ " t_bill_header.tax_applicable,t_bill_header.grand_total,t_bill_header.taxable_amt, "
			+ " t_bill_header.total_tax,t_bill_header.status,t_bill_header.remark,t_bill_header.del_status,t_bill_header.party_name,t_bill_header.party_gstin,t_bill_header.party_address, "
			+ " m_franchisee.fr_name,m_franchisee.fr_address,m_franchisee.is_same_state FROM t_bill_header,m_franchisee WHERE "
			+ " t_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_bill_header.fr_id IN (:frIdList) "
			+ " AND t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.del_status=0 order by t_bill_header.ex_varchar1,t_bill_header.invoice_no" + 
			"",nativeQuery=true)
	
	List<FrBillHeaderForPrint> getFrBillHeaderForPrintByFrIds(@Param("fromDate")String fromDate, @Param("toDate")String toDate,
			@Param("frIdList") List<String> frIdList);
	
	
	
	//new Code for Print getting Header for Selected Bills
	

	@Query(value=" SELECT t_bill_header.bill_no ,t_bill_header.invoice_no, t_bill_header.bill_date "
			+ ",t_bill_header.fr_id,t_bill_header.fr_code,t_bill_header.veh_no,t_bill_header.bill_time,t_bill_header.ex_varchar1,t_bill_header.ex_varchar2,"
			+ " t_bill_header.tax_applicable,t_bill_header.grand_total,t_bill_header.taxable_amt, "
			+ " t_bill_header.total_tax,t_bill_header.status,t_bill_header.remark,t_bill_header.del_status,t_bill_header.party_name,t_bill_header.party_gstin,t_bill_header.party_address, "
			+ " CONCAT(m_franchisee.fr_name, ' [GSTIN-' ,m_franchisee.fr_gst_no,']') as fr_name,m_franchisee.fr_address,m_franchisee.is_same_state FROM t_bill_header,m_franchisee WHERE "
			+ "  "
			+ " t_bill_header.fr_id=m_franchisee.fr_id AND t_bill_header.bill_no IN (:billNoList) AND  t_bill_header.del_status=0 order by t_bill_header.ex_varchar1,t_bill_header.invoice_no" + 
			"",nativeQuery=true)
	
	List<FrBillHeaderForPrint> getFrBillHeaderForPrintSelectedBill(@Param("billNoList") List<String> billNoList);

}
