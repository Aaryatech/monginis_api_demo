package com.ats.webapi.repository.communication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.communication.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Complaint c SET c.isClosed=1  WHERE c.complaintId=:complaintId")
	int deleteComplaint(@Param("complaintId")int complaintId);

}
