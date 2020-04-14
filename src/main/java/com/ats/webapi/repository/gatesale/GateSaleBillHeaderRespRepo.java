package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.gatesale.GateSaleBillHeaderRes;

@Repository
public interface GateSaleBillHeaderRespRepo extends JpaRepository<GateSaleBillHeaderRes, Integer>{


    @Query(value="select bill_id,bill_date,invoice_no,category,is_other,cust_name,t_gatesale_bill_header.emp_id,discount_per,bill_amt,discount_amt,round_off,bill_grant_amt,is_approved,approved_date,approved_user_id,amt_is_collected,collected_date,collected_user_id,is_bill_print,initiator_user_id,m_gatesale_user.user_name,t_gatesale_bill_header.del_status from  t_gatesale_bill_header,m_gatesale_user where m_gatesale_user.user_id=t_gatesale_bill_header.initiator_user_id And t_gatesale_bill_header.del_status=:delStatus And t_gatesale_bill_header.is_approved=:isApproved And t_gatesale_bill_header.amt_is_collected=:amtIsCollected",nativeQuery=true)
	List<GateSaleBillHeaderRes> findByIsApprovedAndAmtIsCollectedAndDelStatus(@Param("isApproved")int isApproved,@Param("amtIsCollected") int amtIsCollected,@Param("delStatus") int delStatus);

}
