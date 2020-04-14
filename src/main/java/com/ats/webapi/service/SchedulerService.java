package com.ats.webapi.service;

import java.util.Date;
import java.util.List;

import com.ats.webapi.model.Scheduler;

public interface SchedulerService {
	public String save(Scheduler scheduler);
	public List<Scheduler> showAllScheduler();
	public Scheduler findScheduler(int schId);
	public List<Scheduler> showAllLatestNews(Date cDate);

}
