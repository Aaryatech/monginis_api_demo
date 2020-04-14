package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.PostBillDetail;

public interface PostBillDetailRepository extends JpaRepository<PostBillDetail, Integer> {
	
	PostBillDetail save(PostBillDetail postBillDetail);
	
	
}
