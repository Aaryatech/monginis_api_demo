package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.GetComplaint;

@Repository
public interface GetComplaintRepository extends JpaRepository<GetComplaint, Integer>{

	@Query(value="select h.complaint_id,h.title,h.description,h.photo1,h.photo2,h.fr_id,f.fr_name,h.mobile_number,h.is_closed,date,h.time,h.customer_name from m_comm_complaint h,m_franchisee f WHERE  h.fr_id=f.fr_id And h.is_closed=:isClosed",nativeQuery=true)
	List<GetComplaint> getAllComplaints(@Param("isClosed")int isClosed);

	@Query(value="select h.complaint_id,h.title,h.description,h.photo1,h.photo2,h.fr_id,f.fr_name,h.mobile_number,h.is_closed,date,h.time,h.customer_name from m_comm_complaint h,m_franchisee f WHERE  h.fr_id=f.fr_id And h.is_closed=:isClosed AND h.fr_id=:frId",nativeQuery=true)
	List<GetComplaint> getAllComplaintsByFrId(@Param("isClosed")int isClosed,@Param("frId")int frId);

	@Query(value="select h.complaint_id,h.title,h.description,h.photo1,h.photo2,h.fr_id,f.fr_name,h.mobile_number,h.is_closed,date,h.time,h.customer_name from m_comm_complaint h,m_franchisee f WHERE  h.fr_id=f.fr_id And h.is_closed=0 And h.complaint_id>:complaintId",nativeQuery=true)
	List<GetComplaint> getAllComplHeaders(@Param("complaintId")int complaintId);

	@Query(value="select h.complaint_id,h.title,h.description,h.photo1,h.photo2,h.fr_id,f.fr_name,h.mobile_number,h.is_closed,date,h.time,h.customer_name from m_comm_complaint h,m_franchisee f WHERE  h.fr_id=f.fr_id And h.is_closed=0 And h.complaint_id>:complaintId And h.fr_id=:frId",nativeQuery=true)
	List<GetComplaint> getAllComplHeadersByFrId(@Param("complaintId")int complaintId,@Param("frId") int frId);


}
