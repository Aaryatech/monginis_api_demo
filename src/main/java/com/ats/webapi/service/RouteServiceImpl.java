package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Route;
import com.ats.webapi.model.User;
import com.ats.webapi.repository.RouteRepository;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class RouteServiceImpl implements RouteService {
	String jsonRoute = "{}";
	Route route = null;
	ErrorMessage errorMessage = new ErrorMessage();
	@Autowired
	RouteRepository routeRepository;

	@Override
	public String save(Route route) {
		if (route.getRouteName() != null && !route.getRouteName().trim().equals("")) {
			route = routeRepository.save(route);
			Info info = new Info();
			info.setError(false);
			info.setMessage("Route saved Successfully");
			System.out.println("exce" + route.toString());

			jsonRoute = JsonUtil.javaToJson(info);
		} else {
			route.setRouteName(route.getRouteName());
			Info info = new Info();
			info.setError(true);
			info.setMessage("Route insertion Failed ");

			jsonRoute = JsonUtil.javaToJson(info);
		}
		return jsonRoute;
	}

	@Override
	public List<Route> showAllRoute() {
		String jsonRouteList = "{}";
		List<Route> routeList = routeRepository.findByDelStatusOrderByRouteIdAsc(0);
		jsonRouteList = JsonUtil.javaToJson(routeList);
		return routeList;
	}

	@Override
	public List<Route> showAllRouteMgmt() {
		String jsonRouteList = "{}";
		List<Route> routeList = routeRepository.findRouteMgmt();
		jsonRouteList = JsonUtil.javaToJson(routeList);
		return routeList;
	}

	@Override
	public List<Route> showAllRouteMgmtByIsSameDay(int isSameDay) {
		String jsonRouteList = "{}";
		List<Route> routeList = routeRepository.findRouteMgmtByIsSameDay(isSameDay);
		jsonRouteList = JsonUtil.javaToJson(routeList);
		return routeList;
	}

	@Override
	public Route findRoute(int routeId) {
		Route route = routeRepository.findOne(routeId);
		return route;
	}

}
