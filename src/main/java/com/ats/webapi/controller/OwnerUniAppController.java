package com.ats.webapi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ats.webapi.model.ownapp.OwnerAppUser;
import com.ats.webapi.model.ownapp.ResponseCode;
import com.ats.webapi.repo.ownapp.OwnerAppUserRepo;
import com.ats.webapi.repository.PostBillHeaderRepository;
import com.ats.webapi.repository.PostCreditNoteHeaderRepository;
import com.ats.webapi.commons.Firebase;
@RestController
public class OwnerUniAppController {

	@Autowired
	OwnerAppUserRepo ownerAppUserRepo;

	@RequestMapping(value = { "/checkAppLogin" }, method = RequestMethod.POST)
	public @ResponseBody OwnerAppUser checkAppLogin(@RequestParam("mobNo") String mobNo,
			@RequestParam("password") String password, @RequestParam("devToken") String devToken) {

		OwnerAppUser appUser = new OwnerAppUser();
		ResponseCode resCode = new ResponseCode();
		try {

			if (mobNo != null || mobNo != "") {

				appUser = ownerAppUserRepo.findByMobNo(mobNo);

				if (appUser != null) {
					System.err.println("mobNo  Found");

					if (appUser.getSecret().equals(password)) {
						System.err.println("password Matched");
						resCode.setStatusCode(2);

						int tokenUpdateRes = ownerAppUserRepo.updateDevToken(devToken, appUser.getOwnappUsrid());
						if (tokenUpdateRes > 0) {
							resCode.setMessage("Token Updated");
							resCode.setStatusCode(3);
							appUser.setDevToken(devToken);
						} else {
							resCode.setMessage("Token Not Updated");
							resCode.setStatusCode(-3);
						}

					} else {
						System.err.println("password Not Matched");
						resCode.setMessage("password Not Matched");
						resCode.setStatusCode(1);
					}
				} else {
					System.err.println("mobNo Not Found");
					resCode.setMessage("mobNo Not Found");
					resCode.setStatusCode(0);
				}
				appUser.setResCode(resCode);
			}
		} catch (Exception e) {
			appUser = new OwnerAppUser();

			appUser.setResCode(resCode);
		}
		return appUser;
	}

	@RequestMapping(value = { "/sendPushNotifApi" }, method = RequestMethod.POST)
	public @ResponseBody Object sendPushNotifApi(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("compId") int compId, @RequestParam("notType") int notType) {
		Integer total = 0;
		List<OwnerAppUser> appUserList = new ArrayList<OwnerAppUser>();
		try {
			appUserList = ownerAppUserRepo.findByCompId(compId);

			for (int i = 0; i < appUserList.size(); i++) {

				MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

				RestTemplate restTemplate = new RestTemplate();

				map.add("fromDate", fromDate);
				map.add("toDate", toDate);
				String msg=new String();
				String tag="1";
				if(notType==1) {
				total = restTemplate.postForObject(appUserList.get(i).getUrlLink() + "getBillTotal", map,
						Integer.class);
				tag="1";
				msg="Total sell between "+fromDate + "-"+toDate+": "+total;
				}else {
					
					total = restTemplate.postForObject(appUserList.get(i).getUrlLink() + "getCrnTotal", map,
							Integer.class);
					msg="Total Credit Note between "+fromDate + "-"+toDate+": "+total;
					tag="2";
				}
				System.err.println("total " + total);
				Firebase fb=new Firebase();
				
			String notifRes=fb.sendPushNotifForCommunication(appUserList.get(i).getDevToken(), "Owner App Notification", msg, tag);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return total;

	}

	@Autowired
	PostBillHeaderRepository billHeaderRepository;

	@RequestMapping(value = { "/getBillTotal" }, method = RequestMethod.POST)
	public @ResponseBody Object getBillTotal(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		
		Date d3 = sdf1.parse(fromDate);
		Date d4 = sdf1.parse(toDate);

		System.err.println("toDate " + toDate + "fromDate " + fromDate);
		int tot = 0;
		try {
			String d1 = sdf.format(d3);
			String d2 = sdf.format(d4);

			tot = billHeaderRepository.getTotalSellBetFdTd(d1, d2);
			System.err.println(tot + "tot");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tot;

	}
	
	@Autowired PostCreditNoteHeaderRepository creditNoteHeaderRepository;
	
	@RequestMapping(value = { "/getCrnTotal" }, method = RequestMethod.POST)
	public @ResponseBody Object getCrnTotal(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		
		Date d3 = sdf1.parse(fromDate);
		Date d4 = sdf1.parse(toDate);

		System.err.println("toDate " + toDate + "fromDate " + fromDate);
		int tot = 0;
		try {
			String d1 = sdf.format(d3);
			String d2 = sdf.format(d4);

			tot = creditNoteHeaderRepository.getTotalCrnBetFdTd(d1, d2);
			System.err.println(tot + "tot");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tot;

	}
	

}
