package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SupplierMaster.Transporter;

@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long>{

	List<Transporter> findTransporterByDelStatus(int delStatus);

	Transporter findTransporterByTranId(int tranId);

}
