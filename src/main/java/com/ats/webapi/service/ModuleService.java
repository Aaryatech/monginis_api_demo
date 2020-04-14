package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.MainModuleWithSubModule;

public interface ModuleService {
	public List<MainModuleWithSubModule> findAll();

}
