package com.ats.webapi.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.webapi.model.OtherItemStockHeader;

public interface OtherStockHeadRepo extends JpaRepository<OtherItemStockHeader, Integer> {

	public List<OtherItemStockHeader> findAllByFrIdAndStatus(int frId, int i);

	
	public  List<OtherItemStockHeader> findAllByOtherStockHeaderIdAndStatus(int herderId, int i);


	

	
}
