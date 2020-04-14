package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.InstVerificationDetail;

@Repository
public interface InstVerificationDetailRepository extends JpaRepository<InstVerificationDetail, Integer>{

	List<InstVerificationDetail> findByInstVerifHId(int instVerifHId);

	InstVerificationDetail save(InstVerificationDetail instVerificationDetail);

}
