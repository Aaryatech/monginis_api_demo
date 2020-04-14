package com.ats.webapi.repository.gatesale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.gatesale.GateSaleBillDetail;

@Repository
public interface GateSaleBillDetailRepository extends JpaRepository<GateSaleBillDetail, Integer>{

}
