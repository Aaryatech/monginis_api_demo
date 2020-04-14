package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.POrder;

@Repository
public interface DispatchOrderRepository extends JpaRepository<POrder, Integer>{

}
