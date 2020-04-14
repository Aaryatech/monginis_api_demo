package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.prod.mixing.TempMixing;

public interface TempMixingRepo extends JpaRepository<TempMixing, Integer> {
	
	TempMixing save(TempMixing tempMixing);
	
	List<TempMixing> findByProdHeaderId(int prodHeaderId);
	

}
