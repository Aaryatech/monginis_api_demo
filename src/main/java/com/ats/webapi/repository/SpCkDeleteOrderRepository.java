package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.SpCakeOrder;


@Repository
public interface SpCkDeleteOrderRepository extends JpaRepository<SpCakeOrder, Integer>{

	@Transactional
	@Modifying
	@Query(" DELETE FROM SpCakeOrder WHERE  spOrderNo=:spOrderNo")
	int deleteSpCkOrder(@Param("spOrderNo") int spOrderNo);

}
