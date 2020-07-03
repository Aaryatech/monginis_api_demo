package com.ats.webapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.pettycash.FrEmpMaster;
@Repository
public interface FrEmpMasterRepo extends JpaRepository<FrEmpMaster, Integer> {

	public List<FrEmpMaster> findByFrIdAndDelStatus(int frId, int del);
	
	public List<FrEmpMaster> findByFrId(int frId);
	
@Query(value="SELECT\n" + 
		"    *\n" + 
		"FROM\n" + 
		"    m_fr_emp\n" + 
		"WHERE\n" + 
		"    fr_emp_contact LIKE :mobNo AND fr_id=:frId  AND del_status =0 AND password LIKE :empPass",nativeQuery=true)
	public FrEmpMaster findByEmpData(@Param("mobNo") String mobNo, @Param("empPass") String empPass,@Param("frId") int frId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_fr_emp SET del_status=1 WHERE fr_emp_id=:empId",nativeQuery=true)
	public int deleteEmpByfrEmpId(@Param("empId") int empId);
	
	public FrEmpMaster findByFrIdAndFrEmpContactAndPasswordAndDelStatus(int frId, String mobNo, String empPass, int del);

	public FrEmpMaster findByFrEmpId(int empId);
	
	public FrEmpMaster findByFrIdAndFrEmpContactAndDelStatus(int frId, String mobNo, int del);



	public FrEmpMaster findByFrIdAndFrEmpIdAndDelStatus(int frId, int empId, int i);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE m_fr_emp SET password=:pass WHERE fr_emp_id=:empId",nativeQuery=true)
	public int updateEmpPass(@Param("empId") int empId, @Param("pass") String pass);

	

	public FrEmpMaster findByFrEmpContact(String mob);

	public FrEmpMaster findByfrEmpContactAndFrEmpId(String mob, int empId);

	public FrEmpMaster findByFrEmpIdAndDelStatus(int userId, int i);

}
