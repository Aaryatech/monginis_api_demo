package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SellBillHeader;

@Repository
public interface SellBillHeaderRepository extends JpaRepository<SellBillHeader, Long>{
	
	@SuppressWarnings("unchecked")
	public SellBillHeader save (SellBillHeader sellBillHeaderList);
}
