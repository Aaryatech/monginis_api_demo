package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.controller.RouteMaster;

public interface RouteMasterRepository extends JpaRepository<RouteMaster, Integer>{

	List<RouteMaster> findByDelStatusOrderByRouteNameAsc(int i);

	RouteMaster findByRouteId(int routeId);

	List<RouteMaster> findByDelStatusAndAbcTypeOrderByRouteNameAsc(int i, int abcType);

}
