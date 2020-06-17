package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.ConfigureFranchisee;

@Repository
public interface ConfigureFrRepository extends JpaRepository<ConfigureFranchisee, Integer> {
	public ConfigureFranchisee save(ConfigureFranchisee configureFranchisee);

	public ConfigureFranchisee findBySettingId(int setting_id);

	@Query(value = "select menu_id from m_fr_configure WHERE setting_id in (select menu_id from m_fr_menu_configure where fr_id=:frId) ", nativeQuery = true)
	public List<Integer> findConfiguredMenuId(@Param("frId") int frId);

	// 23 march
	@Transactional
	@Modifying
	@Query(" UPDATE ConfigureFranchisee  SET fromTime=:fromTime, toTime=:toTime "
			+ " WHERE frId IN(:frIdList) AND menuId =:menuId")
	int updateFrConfSelFr(@Param("frIdList") List<Integer> frIdList, @Param("menuId") int menuId,
			@Param("fromTime") String fromTime, @Param("toTime") String toTime);

	@Transactional
	@Modifying
	@Query(" UPDATE ConfigureFranchisee  SET fromTime=:fromTime, toTime=:toTime WHERE  menuId =:menuId")
	int updateFrConfAllFr(@Param("menuId") int menuId, @Param("fromTime") String fromTime,
			@Param("toTime") String toTime);
	ConfigureFranchisee findByFrIdAndMenuIdAndDelStatus(int frId, int menuId, int i);

	@Query(value = "SELECT c.* FROM m_fr_configure c WHERE c.is_del=0 AND c.setting_id IN(SELECT menu_id FROM m_fr_menu_configure WHERE is_del=0 AND fr_id=:frId)", nativeQuery = true)
	public List<ConfigureFranchisee> getAllFrConfByFrId(@Param("frId") int frId);
	
	@Query(value = "SELECT c.* FROM m_fr_configure c WHERE c.is_del=0 AND c.cat_id=:catId AND c.setting_id IN(SELECT menu_id FROM m_fr_menu_configure WHERE is_del=0 AND fr_id=:frId)", nativeQuery = true)
	public List<ConfigureFranchisee> getAllFrConfByFrIdAndCat(@Param("frId") int frId,@Param("catId") int catId);

}
