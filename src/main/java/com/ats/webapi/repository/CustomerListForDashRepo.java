package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CustomerListForDash;

public interface CustomerListForDashRepo extends JpaRepository<CustomerListForDash, Integer> {

	@Query(value = "SELECT UUID() as id,sp_cust_name,sp_cust_mob_no,sp_grand_total,sp_book_for_mob_no,`sp_selected_weight` "
			+ "FROM `t_sp_cake` WHERE `fr_id` = :frId AND `sp_delivery_date` between :fromDate and :toDate", nativeQuery = true)
	List<CustomerListForDash> getListOfCustomer(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
