package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.GateSaleBillHeader;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderRes;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderResp;

@Repository
public interface GateSaleBillHeaderResRepository extends JpaRepository<GateSaleBillHeaderResp, Integer>{


    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0 And bill_date Between :fromDate And :toDate order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findByBillDateBetween(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0  And is_approved=:isApproved order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findGateSaleBillHeaderResByIsApproved(@Param("isApproved")int isApproved);
    
    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0 And bill_date Between :fromDate And :toDate  AND is_approved=:isApproved And approved_user_id=:approvedUserId order by bill_id DESC" ,nativeQuery=true)
   	List<GateSaleBillHeaderResp> findByIsApprovedAndApprovedUserIdAndBillDateBetween(@Param("isApproved")int isApproved,
   			@Param("approvedUserId")int approvedUserId,@Param("fromDate") String fromDate, @Param("toDate")String toDate);

    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0  AND is_approved=:isApproved AND amt_is_collected=:amtIsCollected order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findByIsApprovedAndAmtIsCollected(@Param("isApproved")int isApproved,@Param("amtIsCollected")int amtIsCollected);

    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0 And bill_date Between :fromDate And :toDate AND is_approved=:isApproved AND amt_is_collected=:amtIsCollected AND collected_user_id=:collectorUserId order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findByIsApprovedAndAmtIsCollectedAndCollectedUserIdAndBillDateBetween(@Param("isApproved")int isApproved, @Param("amtIsCollected")int amtIsCollected,
			@Param("collectorUserId")int collectorUserId, @Param("fromDate")String fromDate,@Param("toDate") String toDate);

    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0 And bill_date Between :fromDate And :toDate And" + 
    		" amt_is_collected=:amtIsCollected order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findAmtIsCollectedAndByBillDateBetween(@Param("amtIsCollected")int amtIsCollected,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0 And bill_date Between :fromDate And :toDate And" + 
    		"  is_approved=:isApproved order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findByIsApprovedAndBillDateBetween(@Param("isApproved")int isApproved,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0  And is_approved=:isApproved And initiator_user_id=:initiatorUserId order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findHeaderByInitiatorId(@Param("isApproved")int isApproved,@Param("initiatorUserId") int initiatorUserId);
  
    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,del_status from  t_gatesale_bill_header where del_status=0  And is_approved=:isApproved And bill_date Between :fromDate And :toDate And initiator_user_id=:initiatorUserId order by bill_id DESC",nativeQuery=true)
	List<GateSaleBillHeaderResp> findHeaderByInitiatorIdAndDate(@Param("isApproved")int isApproved,@Param("initiatorUserId") int initiatorUserId, @Param("fromDate") String fromDate,@Param("toDate") String toDate);

   
}
