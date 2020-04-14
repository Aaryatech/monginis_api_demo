package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SupplierMaster.SupPaymentTerms;

@Repository
public interface SupPaymentTermsRepository extends JpaRepository<SupPaymentTerms, Long>{

	List<SupPaymentTerms> findSupPaymentTermsByDelStatus(int i);

	SupPaymentTerms findSupPaymentTermsByPayId(int payId);

}
