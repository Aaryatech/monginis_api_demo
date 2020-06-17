package com.ats.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.frsetting.FrSetting;
import com.ats.webapi.repository.frsetting.FrSettingRepo;

@RestController // created on 15 Feb Sachin
public class FrSettingController {

	@Autowired
	FrSettingRepo frSettingRepo;

	// used in grngvnController front End and for exBill,CustBill

	@RequestMapping(value = { "/getFrSettingValue" }, method = RequestMethod.POST)
	public @ResponseBody FrSetting getFrSetting(@RequestParam("frId") int frId) {

		FrSetting frSetting = new FrSetting();

		try {

			System.out.println(" /getFrSetingValue : input para  FR ID " + frId);
			frSetting = frSettingRepo.findByFrId(frId);
			System.out.println("/getFrSettingValue output " + frSetting.toString());

		} catch (Exception e) {

			System.out.println("Exce in Getting fr Setting /FrSettingController " + e.getMessage());
			e.printStackTrace();
		}

		return frSetting;

	}
	
	// to be used in Ex Bill and Customer Bill

	@RequestMapping(value = { "/updateFrSettingBillNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateFrSettingBillNo(@RequestParam("frId") int frId,
			@RequestParam("sellBillNo") int sellBillNo) {

		Info info = new Info();
		int updateResponse = 0;
		try {

			System.out.println(
					"Fr setting Para Received for Update /updateFrSetting BillNo " + frId + "billNo " + sellBillNo);
			updateResponse = frSettingRepo.updateFrSettingBillNo(sellBillNo, frId);

			if (updateResponse > 0) {

				info.setError(false);
				info.setMessage("success Updating fr seting sell bill no ");

			} else {
				info.setError(true);
				info.setMessage("failure");
			}

		} catch (Exception e) {

			System.out.println(
					" /updateFrSettingBillNo Exce in Saving/Update fr Setting /FrSettingController " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}
	
	// used in frontEnd grnGvn Insert

	@RequestMapping(value = { "/updateFrSettingGrnGvnNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateFrSettingGrnGvnNo(@RequestParam("frId") int frId,
			@RequestParam("grnGvnNo") int grnGvnNo) {

		Info info = new Info();

		int updateResponse = 0;

		try {

			System.out.println(
					"Fr setting Para Received for Update /updateFrSettingGrnGvnNo " + frId + "grnGvnNo " + grnGvnNo);
			updateResponse = frSettingRepo.updateFrSettingGrnGvnNo(grnGvnNo, frId);

			if (updateResponse > 0) {

				info.setError(false);
				info.setMessage("success Updating fr seting sell bill no ");

			} else {

				info.setError(true);
				info.setMessage("failure");
			}

		} catch (Exception e) {
			System.out.println(
					" /updateFrSettingGrnGvnNo Exce in Update fr Setting /FrSettingController " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}
	@RequestMapping(value = { "/updateFrSettingSpNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateFrSettingSpNo(@RequestParam("frId") int frId) {

		Info info = new Info();

		int updateResponse = 0;

		try {

			System.out.println(
					"Fr setting Para Received for Update /updateFrSettingSpNo " + frId );
			updateResponse = frSettingRepo.updateFrSettingSpNo( frId);

			if (updateResponse > 0) {

				info.setError(false);
				info.setMessage("success Updating fr seting Sp  no ");

			} else {

				info.setError(true);
				info.setMessage("failure");
			}

		} catch (Exception e) {
			System.out.println(
					" /updateFrSettingGrnGvnNo Exce in Update fr Setting /FrSettingController " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}
	
	@RequestMapping(value = { "/updateFrSettingCount" }, method = RequestMethod.POST)
	public @ResponseBody Info updateFrSettingCount(@RequestParam("frId") int frId,
			@RequestParam("chSeq") int chSeq) {

		Info info = new Info();
		int updateResponse = 0;
		try {

			System.out.println(
					"Fr setting Para Received for Update /updateFrSetting BillNo " + frId + "billNo " + chSeq);
			updateResponse = frSettingRepo.updateFrSettingCount(chSeq, frId);

			if (updateResponse > 0) {

				info.setError(false);
				info.setMessage("success Updating fr seting sell bill no ");

			} else {
				info.setError(true);
				info.setMessage("failure");
			}

		} catch (Exception e) {

			System.out.println(
					" /updateFrSettingBillNo Exce in Saving/Update fr Setting /FrSettingController " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}

}
