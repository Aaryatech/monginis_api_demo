package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.GetSuggestionDetail;

@Repository
public interface GetSuggestionDetailRepository extends JpaRepository<GetSuggestionDetail, Integer>{

	@Query(value="select d.suggestion_detail_id,d.suggestion_id,d.message,d.is_admin,d.fr_id,CASE WHEN d.is_admin=1 THEN (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.photo,d.date,d.time from m_comm_suggestion_detail d where d.suggestion_id=:suggestionId",nativeQuery=true)
	List<GetSuggestionDetail> findBySuggestionId(@Param("suggestionId")int suggestionId);

	@Query(value="select d.suggestion_detail_id,d.suggestion_id,d.message,d.is_admin,d.fr_id,CASE WHEN d.is_admin=1 THEN (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.photo,d.date,d.time from m_comm_suggestion_detail d where d.suggestion_detail_id>:suggestionDetailId",nativeQuery=true)
	List<GetSuggestionDetail> findBySuggestionDetailId(@Param("suggestionDetailId")int suggestionDetailId);

	@Query(value="select d.suggestion_detail_id,d.suggestion_id,d.message,d.is_admin,d.fr_id,CASE WHEN d.is_admin=1 THEN (select u.usr_name from m_user u where d.fr_id=u.usr_id) Else (select f.fr_name from m_franchisee f where f.fr_id=d.fr_id)END AS fr_name,d.photo,d.date,d.time from m_comm_suggestion_detail d,m_comm_suggestion h where d.suggestion_detail_id>:suggestionDetailId And d.suggestion_id=h.suggestion_id And h.fr_id=:frId",nativeQuery=true)
	List<GetSuggestionDetail> findBySuggestionDetailIdAndFrId(@Param("suggestionDetailId")int suggestionDetailId,@Param("frId") int frId);

}
