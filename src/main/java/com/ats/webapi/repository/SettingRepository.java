package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.webapi.model.Setting;

public interface SettingRepository extends JpaRepository<Setting, Integer> {

	@Transactional
	@Modifying
	@Query(" UPDATE Setting SET setting_value=:newvalue WHERE setting_key='mrn_no'")
	int udatekeyvalue(@Param("newvalue") int newvalue);

	List<Setting> findBySettingValue(int i);

}
