package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.GetSuggestion;

@Repository
public interface GetSuggestionRepository extends JpaRepository<GetSuggestion, Integer>{

	@Query(value="select m_comm_suggestion.suggestion_id,\n" + 
			"  m_comm_suggestion.title,\n" + 
			"  m_comm_suggestion.photo,\n" + 
			"  m_comm_suggestion.description,\n" + 
			"  m_comm_suggestion.date,\n" + 
			"  m_comm_suggestion.time,\n" + 
			" m_comm_suggestion.fr_id,\n" + 
			" m_franchisee.fr_name,\n" + 
			"  m_comm_suggestion.is_closed\n" + 
			"  from m_comm_suggestion,m_franchisee where m_comm_suggestion.fr_id=m_franchisee.fr_id AND m_comm_suggestion.is_closed=0",nativeQuery=true)
	List<GetSuggestion> findAllGetSuggestions();

	@Query(value="select m_comm_suggestion.suggestion_id,\n" + 
			"  m_comm_suggestion.title,\n" + 
			"  m_comm_suggestion.photo,\n" + 
			"  m_comm_suggestion.description,\n" + 
			"  m_comm_suggestion.date,\n" + 
			"  m_comm_suggestion.time,\n" + 
			" m_comm_suggestion.fr_id,\n" + 
			" m_franchisee.fr_name,\n" + 
			"  m_comm_suggestion.is_closed\n" + 
			"  from m_comm_suggestion,m_franchisee where m_comm_suggestion.fr_id=m_franchisee.fr_id AND m_comm_suggestion.is_closed=0 And m_comm_suggestion.fr_id=:frId",nativeQuery=true)
	List<GetSuggestion> findAllGetSuggestionsByFrId(@Param("frId")int frId);

	@Query(value="select m_comm_suggestion.suggestion_id,m_comm_suggestion.title,m_comm_suggestion.photo,m_comm_suggestion.description,m_comm_suggestion.date,m_comm_suggestion.time,m_comm_suggestion.fr_id,m_franchisee.fr_name,m_comm_suggestion.is_closed  from m_comm_suggestion,m_franchisee where m_comm_suggestion.fr_id=m_franchisee.fr_id AND m_comm_suggestion.is_closed=0 And m_comm_suggestion.suggestion_id>:suggestionId",nativeQuery=true)
	List<GetSuggestion> findAllGetSuggestionsBySuggestionId(@Param("suggestionId")int suggestionId);

	@Query(value="select m_comm_suggestion.suggestion_id,m_comm_suggestion.title,m_comm_suggestion.photo,m_comm_suggestion.description,m_comm_suggestion.date,m_comm_suggestion.time,m_comm_suggestion.fr_id,m_franchisee.fr_name,m_comm_suggestion.is_closed  from m_comm_suggestion,m_franchisee where m_comm_suggestion.fr_id=m_franchisee.fr_id AND m_comm_suggestion.is_closed=0 And m_comm_suggestion.fr_id=:frId And m_comm_suggestion.suggestion_id>:suggestionId",nativeQuery=true)
	List<GetSuggestion> findAllGetSuggHeadersByFrIdAndSuggestionId(@Param("frId")int frId,@Param("suggestionId") int suggestionId);

}
