package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.Document; 
import com.ats.webapi.repository.logistics.DocumentRepository;


@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired 
	DocumentRepository documentRepository;

	@Override
	public Document postDocument(Document dealer) {
		Document response = new Document();
		 try
		 {
			 response = documentRepository.save(dealer);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public List<Document> getAllDocumentList() {
		List<Document> getAllDocumentList = new ArrayList<Document>();
		try {
			  
			getAllDocumentList = documentRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllDocumentList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllDocumentList;
	}

	@Override
	public Info deleteDocument(int docId) {
		Info info = new Info();
		try {
			  
			int delete = documentRepository.deleteDocument(docId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("deleted successfully");
			}
			else
			{
				info.setError(true);
				info.setMessage("failed to delete");
			}
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return info;
	}

	@Override
	public Document getDocById(int docId) {
		Document getDocById = new Document();
		try {
			  
			getDocById = documentRepository.findByDocId(docId);
			 
			System.out.println(getDocById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getDocById;
	}

}
