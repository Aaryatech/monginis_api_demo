package com.ats.webapi.repository.communication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.ComplaintDetail;

@Repository
public interface ComplaintDetailRepository extends JpaRepository<ComplaintDetail, Integer>{

	@Query(value="select token from m_franchise_sup where fr_id=(select fr_id from m_comm_complaint where complaint_id=:complaintId)",nativeQuery=true)
	String findFrTokenByComplaintId(@Param("complaintId")int complaintId);

}
