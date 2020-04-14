package com.ats.webapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ItemWithSubCat;
import com.ats.webapi.model.Rates;


@Repository("rateRepository")
public interface RateRepository extends JpaRepository<Rates, Integer> {
	 
		
		
		Rates save(Rates rate);
	
		List<Rates> findByDelStatus(int i);

		Rates findOne(int sprId);

		List<Rates> findByDelStatusOrderBySprNameAsc(int i);
	}

