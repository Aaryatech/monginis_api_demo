package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.logistics.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{

	
	@Transactional
	@Modifying
	@Query(" UPDATE Document SET del_status=1 WHERE doc_id=:docId") 
	int deleteDocument(@Param("docId")int docId);

	List<Document> findAllByDelStatus(int delStatus);

	Document findByDocId(int docId); 

}
