package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.gatesale.GateSaleUser;
@Repository
public interface GateSaleRepository extends JpaRepository<GateSaleUser, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE GateSaleUser u SET u.delStatus=1  WHERE u.userId=:userId")
	int deleteGateSaleUser(@Param("userId")int userId);

	GateSaleUser findGateSaleUserByUserId(int userId);

	GateSaleUser findGateSaleUserByMobileNumberAndPassword(String mobileNumber,String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE GateSaleUser u SET u.token=:token  WHERE u.userId=:userId")
	int updateUserToken(@Param("userId")int userId,@Param("token") String token);

}
