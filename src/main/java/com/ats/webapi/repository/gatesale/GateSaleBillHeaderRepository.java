package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.GateSaleBillHeader;
@Repository
public interface GateSaleBillHeaderRepository extends JpaRepository<GateSaleBillHeader, Integer>{

	GateSaleBillHeader saveAndFlush(GateSaleBillHeader gateSaleBillHeader);

	    @Transactional
		@Modifying
		@Query("UPDATE GateSaleBillHeader SET is_approved =:isApproved,approved_date=:approvedDate,approved_user_id=:approvedUserId  WHERE bill_id=:billId")
		int approveGetSaleBill(@Param("billId")int billId,@Param("isApproved") int isApproved,@Param("approvedDate") String approvedDate, @Param("approvedUserId")int approvedUserId);
	   
	    @Transactional
		@Modifying
		@Query("UPDATE GateSaleBillHeader  SET amt_is_collected=2,collected_date=:collectedDate,collected_user_id=:collectedUserId where is_approved=2")
		int updateCollectGetSaleAmt(@Param("collectedDate")String collectedDate,@Param("collectedUserId") int collectedUserId);

	    @Query(value="select token from m_gatesale_user where user_id=(select initiator_user_id from t_gatesale_bill_header where bill_id=:billId)",nativeQuery=true)
		String findUserTokenByBillId(@Param("billId")int billId);

	    @Query(value="select token from m_gatesale_user where user_type=2 and del_status=0",nativeQuery=true)
		List<String> findUserTokensByBillId();

	    @Query(value="select user_type from m_gatesale_user where user_id=:initiatorUserId",nativeQuery=true)
		int findUserTypeById(@Param("initiatorUserId")int initiatorUserId);

	    @Transactional
		@Modifying
		@Query("UPDATE GateSaleBillHeader  SET amt_is_collected=:amtIsCollected,collected_date=:collectedDate,collected_user_id=:collectedUserId where is_approved=2 And bill_id In (:billIds)")
		int updateCollectGetSaleAmtOfBill(@Param("collectedDate")String collectedDate,@Param("collectedUserId") int collectedUserId,@Param("amtIsCollected") int amtIsCollected,
				@Param("billIds")List<Integer> billIds);

	    
}
