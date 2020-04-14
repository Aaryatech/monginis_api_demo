package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.InstVerificationDetail;
import com.ats.webapi.model.spprod.InstVerificationHeader;

@Repository
public interface InstVerifHeaderRepository extends JpaRepository<InstVerificationHeader, Integer> {

	InstVerificationHeader findByStationIdAndStStatusAndDelStatus(int stationId, int status, int delStatus);

	
}
