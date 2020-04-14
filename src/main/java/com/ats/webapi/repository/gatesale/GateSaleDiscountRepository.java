package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.GateSaleDiscount;
@Repository
public interface GateSaleDiscountRepository extends JpaRepository<GateSaleDiscount, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE GateSaleDiscount d SET d.delStatus=1  WHERE d.discountId=:discountId")
	int deleteGateSaleDiscount(@Param("discountId")int discountId);

	List<GateSaleDiscount> findGateSaleDiscountByDelStatus(int i);

	GateSaleDiscount findGateSaleDiscountByDiscountId(int discountId);

	List<GateSaleDiscount> findGateSaleDiscountByCatIdAndDelStatus(int catId, int delStatus);

	List<GateSaleDiscount> findGateSaleDiscountByUserTypeAndDelStatus(int userType, int i);

}
