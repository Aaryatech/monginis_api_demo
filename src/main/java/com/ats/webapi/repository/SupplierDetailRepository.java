package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.SupplierMaster.SupplierDetails;

public interface SupplierDetailRepository extends JpaRepository<SupplierDetails, Integer>{
	
	SupplierDetails save(SupplierDetails supplierDetails);
	

	SupplierDetails findBySuppId(int suppId);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE SupplierDetails SET delStatus=1 WHERE suppId=:suppId ")
	int deleteSupplier(@Param("suppId") int suppId);


	List<SupplierDetails> findByDelStatus(int delStatus);


	List<SupplierDetails> findByIsTallySyncAndDelStatus(int i, int j);

	@Transactional
	@Modifying
	@Query(" UPDATE SupplierDetails SET isTallySync=:isTallySync WHERE suppId=:suppId ")
	int updateSupplier(@Param("suppId") int suppId,@Param("isTallySync") int isTallySync);

	@Query(value="select  m.supp_id,m.supp_name,m.supp_addr,m.supp_city,m.supp_state,m.supp_country,m.supp_mob1,m.supp_mob2,m.supp_mob3,m.supp_email1,m.supp_email2,m.supp_email3,m.supp_email4,m.supp_email5,m.supp_gstin,m.supp_pan_no,m.supp_fda_lic,m.supp_pay_id,m.del_status,m.supp_credit_days,m.supp_c_person,m.is_tally_sync,r.rate_tax_extra as supp_phone1,r.rate_tax_incl as  supp_phone2 from m_supplier m,m_rm_rate_verif r where  r.supp_id=m.supp_id and r.rm_id=:itemId and r.grp_id=:grpId and m.del_status=0\r\n" + 
			"\r\n" + 
			"",nativeQuery=true)
	List<SupplierDetails> getSupplierByItemId(@Param("itemId")int itemId,@Param("grpId")int grpId); /* FIND_IN_SET(:itemId,m.supp_email4) and*/



}
