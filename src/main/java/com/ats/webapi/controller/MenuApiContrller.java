package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.GetMenuShow;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.MenuShow;
import com.ats.webapi.repository.GetMenuShowRepo;
import com.ats.webapi.repository.MenuShowRepo;

@RestController
public class MenuApiContrller {

	@Autowired
	MenuShowRepo menuShowRepo;

	@Autowired
	GetMenuShowRepo getMenuShowRepo;

	// ---------------------------------------saveMenuShow------------------------

	@RequestMapping(value = { "/saveMenuShow" }, method = RequestMethod.POST)
	public @ResponseBody MenuShow saveMenuShow(@RequestBody MenuShow menuShow) {

		MenuShow res = new MenuShow();

		try {

			res = menuShowRepo.saveAndFlush(menuShow);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getMenuShowByMenuId" }, method = RequestMethod.POST)
	public @ResponseBody MenuShow getMenuShowByMenuId(@RequestParam("menuId") int menuId) {

		MenuShow bankDetail = new MenuShow();

		try {
			bankDetail = menuShowRepo.findByMenuIdAndDelStatus(menuId, 0);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return bankDetail;

	}

	@RequestMapping(value = { "/getMenuShowList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetMenuShow> getMenuShowList() {

		List<GetMenuShow> list = new ArrayList<GetMenuShow>();

		try {
			list = getMenuShowRepo.getMenuListData();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/deleteMenuShow" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMenuShow(@RequestParam("menuId") int menuId) {

		Info info = new Info();

		try {
			int delete = menuShowRepo.deleteMenuShow(menuId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

}
