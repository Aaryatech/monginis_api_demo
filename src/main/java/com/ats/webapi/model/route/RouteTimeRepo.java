package com.ats.webapi.model.route;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteTimeRepo extends JpaRepository<RouteTime, Integer> {

	List<RouteTime> findByDelStatus(int i);

	RouteTime findByTimeRouteIdAndDelStatus(int timeRouteId, int i);

}
