package com.ats.webapi.repository.communication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.SuggestionDetail;

@Repository
public interface SuggestionDetailRepository extends JpaRepository<SuggestionDetail, Integer>{

	@Query(value="select token from m_franchise_sup where fr_id=(select fr_id from m_comm_suggestion where suggestion_id=:suggestionId) And del_status=0",nativeQuery=true)
	String findFrTokenBySuggestionId(@Param("suggestionId")int suggestionId);

	
}
