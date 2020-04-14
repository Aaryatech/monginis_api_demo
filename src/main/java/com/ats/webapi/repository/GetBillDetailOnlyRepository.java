package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.PostBillDetail;

public interface GetBillDetailOnlyRepository extends JpaRepository<PostBillDetail, Integer> {
	
	PostBillDetail getByBillDetailNo(int billDetailNo);
	

}
