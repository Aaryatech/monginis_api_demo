package com.ats.webapi.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Scheduler;
import com.ats.webapi.model.SchedulerList;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.SchedulerRepository;
import com.ats.webapi.repository.UserRepository;
import com.ats.webapi.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SchedulerServiceImpl implements SchedulerService {

	String jsonScheduler = "{}";
	Scheduler scheduler = null;

	@Autowired
	SchedulerRepository schedulerRepository;

	@Autowired
	FranchiseSupRepository franchiseSupRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public String save(Scheduler scheduler) {
		SchedulerList schedulerList = new SchedulerList();
		Info info = new Info();
		Scheduler schedularRes;
		try {
			if (scheduler.getSchMessage() != null && !scheduler.getSchMessage().trim().equals("")
					&& scheduler.getSchOccasionname() != null && !scheduler.getSchOccasionname().trim().equals("")) {
				schedularRes = schedulerRepository.save(scheduler);
				ObjectMapper om = new ObjectMapper();
				String jsonStr = om.writeValueAsString(schedularRes);
				if (scheduler.getDelStatus() == 0) {
					List<String> frTokens = franchiseSupRepository.findTokens();
					List<String> usrTokens = userRepository.findTokens();
					frTokens.addAll(usrTokens);
					System.out.println("usrTokens" + usrTokens.toString());

					try {
						for (String token : frTokens) {
							if (token != null) {
								Firebase.sendPushNotifForCommunication(token, scheduler.getSchOccasionname(), jsonStr,
										"news");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				info.setError(false);
				info.setMessage("Scheduler inserted Successfully");
				jsonScheduler = JsonUtil.javaToJson(info);
			} else {
				scheduler.setSchMessage(scheduler.getSchMessage());
				scheduler.setSchOccasionname(scheduler.getSchOccasionname());
				// schedulerList.setSchedulerList((List<Scheduler>) scheduler);
				info.setError(true);
				info.setMessage("Scheduler insertion Failed");
				jsonScheduler = JsonUtil.javaToJson(info);
			}

		} catch (Exception e) {
			System.out.println("SchedularServiceImpl Excep: " + e.getMessage());
			e.printStackTrace();
		}
		return jsonScheduler;
	}

	@Override
	public Scheduler findScheduler(int schId) {
		Scheduler scheduler = schedulerRepository.findOne(schId);
		return scheduler;

	}

	@Override
	public List<Scheduler> showAllScheduler() {
		List<Scheduler> schedulerList = schedulerRepository.findByDelStatus(0);
		return schedulerList;
	}

	@Override
	public List<Scheduler> showAllLatestNews(Date cDate) {

		List<Scheduler> schedulerList = schedulerRepository.findLatestNews(cDate);
		return schedulerList;

	}
}
