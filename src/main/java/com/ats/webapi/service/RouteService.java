package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.Route;

public interface RouteService {

	public String save(Route route);

	public List<Route> showAllRoute();

	public Route findRoute(int routeId);

	public List<Route> showAllRouteMgmt();

	public List<Route> showAllRouteMgmtByIsSameDay(int isSameDay);
}
