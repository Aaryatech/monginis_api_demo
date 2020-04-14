package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.FrMenuConfigure;

@Repository
public interface FrMenuConfigureRepository extends JpaRepository<FrMenuConfigure, Integer>{

	@Transactional
	@Modifying
	@Query(" DELETE FROM FrMenuConfigure WHERE  settingId=:settingId")
	int deleteFrConfMenu(@Param("settingId")int settingId);

	//4 jan 2019
	FrMenuConfigure findByFrIdAndMenuIdAndIsDel(int frId, int menuId, int i);

}
