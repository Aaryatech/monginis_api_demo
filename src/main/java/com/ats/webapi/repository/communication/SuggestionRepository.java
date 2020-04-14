package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.communication.Suggestion;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Suggestion s SET s.isClosed=1  WHERE s.suggestionId=:suggestionId")
	int deleteSuggestion(@Param("suggestionId")int suggestionId);

	List<Suggestion> findByIsClosed(int i);

}
