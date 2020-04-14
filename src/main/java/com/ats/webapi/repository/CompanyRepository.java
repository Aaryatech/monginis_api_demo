package com.ats.webapi.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.bill.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	@Query(value="select * from m_company where from_date<=:billDate and to_date>=:billDate and del_status=0",nativeQuery=true)
	Company findByBillDate(@Param("billDate")String billDate);

	 @Transactional
	 @Modifying
	 @Query("UPDATE Company SET ex_var5=(ex_var5+1) WHERE comp_id=:compId")
	 int updatePBStatus(@Param("compId")int compId);

}
