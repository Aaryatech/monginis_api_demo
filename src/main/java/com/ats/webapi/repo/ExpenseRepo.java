package com.ats.webapi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Integer> {

	@Transactional
	@Modifying
	@Query(" UPDATE Expense SET del_status=1 WHERE exp_id=:suppId")
	int deleteExpense(@Param("suppId") int suppId);


	@Transactional
	@Modifying
	@Query(" UPDATE Expense SET status=2 WHERE exp_id=:expId")
	int updateExpStatus(@Param("expId") int expId);
	
	//Check Bill Receipt
		@Query(value = "SELECT m_expense.exp_id,\n" + 
				"    m_expense.chalan_no,\n" + 
				"    m_expense.exp_type,\n" + 
				"    m_expense.img_name,\n" + 
				"    m_expense.ch_amt,\n" + 
				"    m_expense.fr_id,\n" + 
				"    m_expense.del_status,\n" + 
				"    m_expense.remark,\n" + 
				"    m_expense.status,\n" + 
				"    m_expense.exp_date,\n" + 
				"    m_expense.ex_int1,\n" + 
				"    m_expense.ex_int2,\n" + 
				"    CASE WHEN (SELECT COUNT(*) FROM t_bill_receipt_header h WHERE h.exp_id=m_expense.exp_id)>0 THEN 1 ELSE 0 END as ex_int3,\n" + 
				"    m_expense.ex_int4,\n" + 
				"    m_expense.ex_var1,\n" + 
				"    m_expense.ex_var2,\n" + 
				"    m_expense.ex_var3,\n" + 
				"    m_expense.ex_var4\n" + 
				" from m_expense where   m_expense.del_status=0 AND m_expense.fr_id=:frId", nativeQuery = true)
	 	List<Expense> getExpenseListChkBillRec(@Param("frId") int frId);
		
		
		//Check Bill Receipt
		@Query(value = "SELECT m_expense.exp_id,\n" + 
				"    m_expense.chalan_no,\n" + 
				"    m_expense.exp_type,\n" + 
				"    m_expense.img_name,\n" + 
				"    m_expense.ch_amt,\n" + 
				"    m_expense.fr_id,\n" + 
				"    m_expense.del_status,\n" + 
				"    m_expense.remark,\n" + 
				"    m_expense.status,\n" + 
				"    m_expense.exp_date,\n" + 
				"    m_expense.ex_int1,\n" + 
				"    m_expense.ex_int2,\n" + 
				"    CASE WHEN (SELECT COUNT(*) FROM t_bill_receipt_header h WHERE h.exp_id=m_expense.exp_id)>0 THEN 1 ELSE 0 END as ex_int3,\n" + 
				"    m_expense.ex_int4,\n" + 
				"    m_expense.ex_var1,\n" + 
				"    m_expense.ex_var2,\n" + 
				"    m_expense.ex_var3,\n" + 
				"    m_expense.ex_var4\n" + 
				" from m_expense where   m_expense.del_status=0 AND  m_expense.fr_id=:frId AND m_expense.exp_type=:type AND m_expense.exp_date BETWEEN :fromDate AND :toDate  ", nativeQuery = true)
	 	List<Expense> getExpenseListChkBillRec(@Param("frId") int frId,@Param("type") int type,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	 	
		@Query(value = "SELECT m_expense.exp_id,\n" + 
				"    m_expense.chalan_no,\n" + 
				"    m_expense.exp_type,\n" + 
				"    m_expense.img_name,\n" + 
				"    m_expense.ch_amt,\n" + 
				"    m_expense.fr_id,\n" + 
				"    m_expense.del_status,\n" + 
				"    m_expense.remark,\n" + 
				"    m_expense.status,\n" + 
				"    m_expense.exp_date,\n" + 
				"    m_expense.ex_int1,\n" + 
				"    m_expense.ex_int2,\n" + 
				"    m_expense.ex_int3,\n" + 
				"    m_expense.ex_int4,\n" + 
				"    m_expense.ex_var1,\n" + 
				"    m_fr_emp.fr_emp_name as ex_var2,\n" + 
				"    m_expense.ex_var3,\n" + 
				"    m_expense.ex_var4\n" + 
				" from m_expense, m_fr_emp where   m_expense.del_status=0 AND m_expense.ex_int2 = m_fr_emp.fr_emp_id  AND m_expense.fr_id=:frId AND m_expense.exp_type=:type AND m_expense.exp_date BETWEEN :fromDate AND :toDate  ", nativeQuery = true)
	 	List<Expense> getExpenseList(@Param("frId") int frId,@Param("type") int type,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	 	
		@Query(value = "SELECT m_expense.exp_id,\n" + 
				"    m_expense.chalan_no,\n" + 
				"    m_expense.exp_type,\n" + 
				"    m_expense.img_name,\n" + 
				"    m_expense.ch_amt,\n" + 
				"    m_expense.fr_id,\n" + 
				"    m_expense.del_status,\n" + 
				"    m_expense.remark,\n" + 
				"    m_expense.status,\n" + 
				"    m_expense.exp_date,\n" + 
				"    m_expense.ex_int1,\n" + 
				"    m_expense.ex_int2,\n" + 
				"    m_expense.ex_int3,\n" + 
				"    m_expense.ex_int4,\n" + 
				"    m_expense.ex_var1,\n" + 
				"    m_fr_emp.fr_emp_name as ex_var2,\n" + 
				"    m_expense.ex_var3,\n" + 
				"    m_expense.ex_var4\n" + 
				" from m_expense, m_fr_emp where   m_expense.del_status=0 AND m_expense.ex_int2 = m_fr_emp.fr_emp_id  AND m_expense.fr_id=:frId", nativeQuery = true)
	 	List<Expense> getExpenseList(@Param("frId") int frId);
		
		@Query(value = "SELECT m_expense.exp_id,\n" + 
				"    m_expense.chalan_no,\n" + 
				"    m_expense.exp_type,\n" + 
				"    m_expense.img_name,\n" + 
				"    m_expense.ch_amt,\n" + 
				"    m_expense.fr_id,\n" + 
				"    m_expense.del_status,\n" + 
				"    m_expense.remark,\n" + 
				"    m_expense.status,\n" + 
				"    m_expense.exp_date,\n" + 
				"    m_expense.ex_int1,\n" + 
				"    m_expense.ex_int2,\n" + 
				"    m_expense.ex_int3,\n" + 
				"    m_expense.ex_int4,\n" + 
				"    m_expense.ex_var1,\n" + 
				"    m_fr_emp.fr_emp_name as ex_var2,\n" + 
				"    m_expense.ex_var3,\n" + 
				"    m_expense.ex_var4\n" + 
				" from m_expense, m_fr_emp where  m_expense.del_status=0 AND m_expense.ex_int2 = m_fr_emp.fr_emp_id   AND m_expense.exp_date BETWEEN :fromDate AND :toDate AND exp_type=:type AND m_expense.ex_int1=0", nativeQuery = true)
		List<Expense> getAllExpenseList(@Param("type") int type,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
		
		
		@Query(value = "SELECT m_expense.exp_id,\n" + 
				"    m_expense.chalan_no,\n" + 
				"    m_expense.exp_type,\n" + 
				"    m_expense.img_name,\n" + 
				"    m_expense.ch_amt,\n" + 
				"    m_expense.fr_id,\n" + 
				"    m_expense.del_status,\n" + 
				"    m_expense.remark,\n" + 
				"    m_expense.status,\n" + 
				"    m_expense.exp_date,\n" + 
				"    m_expense.ex_int1,\n" + 
				"    m_expense.ex_int2,\n" + 
				"    m_expense.ex_int3,\n" + 
				"    m_expense.ex_int4,\n" + 
				"    m_expense.ex_var1,\n" + 
				"    m_fr_emp.fr_emp_name as ex_var2,\n" + 
				"    m_expense.ex_var3,\n" + 
				"    m_expense.ex_var4\n" + 
				" from m_expense, m_fr_emp where  m_expense.del_status=0 AND m_expense.ex_int2 = m_fr_emp.fr_emp_id   AND m_expense.exp_date BETWEEN :fromDate AND :toDate AND exp_type=:type AND m_expense.fr_id IN(:frIdList) AND m_expense.ex_int1=0 ", nativeQuery = true)
		List<Expense> getAllExpenseList(@Param("type") int type,@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("frIdList") List<String> frIdList);
		
		
		Expense findByExpId(int expId);
}
