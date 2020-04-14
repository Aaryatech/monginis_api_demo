package com.ats.webapi.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Order;


public interface OrdersRepository extends JpaRepository<Order,Long> {

	Order save(Order order);

	

	
}
