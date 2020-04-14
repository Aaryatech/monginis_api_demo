package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.OtherBillDetail;

public interface OtherBillDetailRepository extends JpaRepository<OtherBillDetail, Integer>{

	List<OtherBillDetail> findByBillNoAndDelStatus(int billNo, int delStatus);

}
