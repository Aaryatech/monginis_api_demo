package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.UpdateGrnGvn;

public interface UpdateGrnGvnRepository extends JpaRepository<UpdateGrnGvn, Integer> {
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateGrnGvn  SET approvedLoginGate =:approvedLoginGate,aprQtyGate=:aprQtyGate ,"
			+ "approveimedDateTimeGate=:approveimedDateTimeGate,approvedRemarkGate=:approvedRemarkGate ,"
			+ "grnGvnStatus=:grnGvnStatus WHERE grnGvnId =:grnGvnId ")
	
		int updateGateGrn(@Param("approvedLoginGate") int approvedLoginGate,@Param("aprQtyGate") int aprQtyGate,@Param("approveimedDateTimeGate") 
		String approveimedDateTimeGate,@Param("approvedRemarkGate") String approvedRemarkGate,@Param("grnGvnStatus") 
		int grnGvnStatus,@Param("grnGvnId") int grnGvnId);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateGrnGvn  SET approvedLoginAcc =:approvedLoginAcc,aprQtyAcc=:aprQtyAcc ,"
			+ "approvedDateTimeAcc=:approvedDateTimeAcc,approvedRemarkAcc=:approvedRemarkAcc ,"
			+ "grnGvnStatus=:grnGvnStatus,"
			+ "aprTaxableAmt =:aprTaxableAmt,aprTotalTax =:aprTotalTax,aprSgstRs =:aprSgstRs,aprCgstRs =:aprCgstRs,aprIgstRs=:aprIgstRs, "
			+ "aprGrandTotal =:aprGrandTotal,aprROff=:aprROff"
			+ " WHERE grnGvnId =:grnGvnId ")
	
		int updateAccGrn(@Param("approvedLoginAcc") int approvedLoginAcc,@Param("aprQtyAcc") int aprQtyAcc,@Param("approvedDateTimeAcc") 
		String approvedDateTimeAcc,@Param("approvedRemarkAcc") String approvedRemarkAcc,@Param("grnGvnStatus") 
		int grnGvnStatus,@Param("aprTaxableAmt") float aprTaxableAmt,@Param("aprTotalTax") float aprTotalTax,@Param("aprSgstRs") float aprSgstRs,
		@Param("aprCgstRs") float aprCgstRs,@Param("aprIgstRs") float aprIgstRs,@Param("aprGrandTotal")float aprGrandTotal,
		@Param("aprROff") float aprROff,@Param("grnGvnId") int grnGvnId);
	
	
	@Transactional
	@Modifying
	@Query(" UPDATE UpdateGrnGvn  SET approvedLoginStore =:approvedLoginStore,aprQtyStore=:aprQtyStore ,"
			+ "approvedDateTimeStore=:approvedDateTimeStore,approvedRemarkStore=:approvedRemarkStore ,"
			+ "grnGvnStatus=:grnGvnStatus WHERE grnGvnId =:grnGvnId ")
	
		int updateStoreGvn(@Param("approvedLoginStore") int approvedLoginStore,@Param("aprQtyStore") int aprQtyStore,@Param("approvedDateTimeStore") 
		String approvedDateTimeStore,@Param("approvedRemarkStore") String approvedRemarkStore,@Param("grnGvnStatus") 
		int grnGvnStatus,@Param("grnGvnId") int grnGvnId);
	

}
