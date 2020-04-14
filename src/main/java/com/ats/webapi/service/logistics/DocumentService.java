package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.Document;

@Service
public interface DocumentService {

	Document postDocument(Document document);

	List<Document> getAllDocumentList();

	Info deleteDocument(int docId);

	Document getDocById(int docId);

}
