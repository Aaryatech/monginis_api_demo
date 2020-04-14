package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.GetComplaintDetail;

@Repository
public interface GetComplaintDetailRepository extends JpaRepository<GetComplaintDetail,Integer>{

	@Query(value="select d.comp_detail_id,d.complaint_id,d.message,d.is_admin,photo,d.fr_id,CASE WHEN d.is_admin=1 THEN  (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.date,d.time from m_comm_complaint_detail d where d.complaint_id=:complaintId",nativeQuery=true)
	List<GetComplaintDetail> findByComplaintId(@Param("complaintId")int complaintId);

	@Query(value="select d.comp_detail_id,d.complaint_id,d.message,d.is_admin,photo,d.fr_id,CASE WHEN d.is_admin=1 THEN  (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.date,d.time from m_comm_complaint_detail d where d.comp_detail_id>:compDetailId",nativeQuery=true)
	List<GetComplaintDetail> findByComplaintDetailId(@Param("compDetailId")int compDetailId);

	@Query(value="select d.comp_detail_id,d.complaint_id,d.message,d.is_admin,photo,d.fr_id,CASE WHEN d.is_admin=1 THEN  (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.date,d.time from m_comm_complaint_detail d,m_comm_complaint h where d.comp_detail_id>:compDetailId And d.complaint_id=h.complaint_id And h.fr_id=:frId",nativeQuery=true)
	List<GetComplaintDetail> findByComplaintDetailIdAndFrId(@Param("compDetailId")int compDetailId,@Param("frId") int frId);

}
