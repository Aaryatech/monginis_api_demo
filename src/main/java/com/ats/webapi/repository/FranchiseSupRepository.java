package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.FranchiseSup;

@Repository
public interface FranchiseSupRepository extends JpaRepository<FranchiseSup, Integer>{

	@Modifying
	@Transactional
	@Query("Update FranchiseSup  SET del_status=1 WHERE fr_id=:frId")
	int deleteFranchiseSup(@Param("frId")int frId);

	FranchiseSup findFranchiseSupById(int id);

	FranchiseSup findFranchiseSupByFrId(int frId);

	@Modifying
	@Transactional
	@Query("Update FranchiseSup  SET pass2=:pass2,pass3=:pass3 WHERE fr_id=:frId")
	public int updateFranchiseSupUserPwd(@Param("frId")int frId,@Param("pass2") String pass2,@Param("pass3") String pass3);

	@Modifying
	@Transactional
	@Query("Update FranchiseSup  SET token=:token WHERE fr_id=:frId")
	int updateUserToken(@Param("frId")int userId,@Param("token") String token);

	@Query(value="select token from m_franchise_sup where del_status=0",nativeQuery=true)
	List<String> findTokens();
	
	@Query(value="select token from m_franchise_sup where fr_id=:frId",nativeQuery=true)
	String findTokenByFrId(@Param("frId")int frId);

	@Query(value="select m_franchise_sup.token from m_franchisee,m_franchise_sup where m_franchisee.fr_id=m_franchise_sup.fr_id And DATE_FORMAT(owner_birth_date,'%m-%d')=DATE_FORMAT(:date,'%m-%d')",nativeQuery=true)
	List<String> findTokensByBirthdate(@Param("date")Date date);

	@Query(value="select token from m_franchise_sup where fr_id In(:frIds)",nativeQuery=true)
	List<String> findFrTokenByFrId(@Param("frIds")List<Integer> frIds);
	
	@Modifying
	@Transactional
	@Query(value="Update m_franchise_sup SET pass1=:adminPwd WHERE fr_id=:frId and del_status=0",nativeQuery=true)
	public Integer updateFrPwd(@Param("frId")int frId,@Param("adminPwd") String adminPwd);

	@Modifying
	@Transactional
	@Query(value="Update m_franchise_sup SET pass1=:newPass WHERE fr_id=:frId and del_status=0",nativeQuery=true)
	int updatePOSFrPwd(@Param("frId")int frId,@Param("newPass") String newPass);

	List<FranchiseSup> findByDelStatus(int del);

	/************************************************************************************/
	@Modifying
	@Transactional
	@Query(value="UPDATE m_franchise_sup SET pass2=:weighingScale1Date, pass3=:weighingScale2Date, pass4=:shopEstbLicsDate, pest_control_date=:frAgreementDate, remainder_date=:profTaxDate WHERE fr_id=:frId",nativeQuery=true)
	int updateFrSupLicsDates(@Param("frId") int frId, @Param("frAgreementDate") String frAgreementDate, @Param("weighingScale1Date") String weighingScale1Date, @Param("weighingScale2Date") String weighingScale2Date,
			@Param("shopEstbLicsDate") String shopEstbLicsDate, @Param("profTaxDate") String profTaxDate);

	
}
