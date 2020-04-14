package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.ShopAnivData;

@Repository
public interface FrAniversaryRepository extends JpaRepository<ShopAnivData, Integer>{

	@Query(value="select m_franchise_sup.fr_id,DATEDIFF(:date,m_franchisee.fr_opening_date)/365 AS no_of_years,m_franchise_sup.token from m_franchisee,m_franchise_sup where m_franchisee.fr_id=m_franchise_sup.fr_id And DATE_FORMAT(m_franchisee.fr_opening_date,'%m-%d')=DATE_FORMAT(:date,'%m-%d')",nativeQuery=true)
	List<ShopAnivData> findTokensByFrOpeningDate(@Param("date")Date date);


	
}
