package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CreditNotePosHeaderDisp;

public interface CreditNotePosHeaderDispRepo extends JpaRepository<CreditNotePosHeaderDisp, Integer>{

	@Query(value="SELECT c.crn_detail_no, c.crn_no, c.crn_invoice_no, c.bill_invoice, c.crn_date, SUM(c.taxable_amt) AS taxable_amt, SUM(c.grand_total) AS grand_total, c.cust_id, c.user_id, c.is_stockable, cm.cust_name, e.fr_emp_name as user_name FROM t_credit_note_pos c, m_customer cm, m_fr_emp e WHERE c.del_status = 0 AND c.crn_date BETWEEN :fromDate AND :toDate AND c.cust_id =:custId AND c.cust_id = cm.cust_id AND c.user_id = e.fr_emp_id AND c.ex_int1=:frId GROUP BY c.crn_no ORDER BY c.crn_no DESC",nativeQuery=true)
	List<CreditNotePosHeaderDisp> getCrnPosHeader(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("custId") int custId, @Param("frId") int frId);

	@Query(value="SELECT c.crn_detail_no, c.crn_no, c.crn_invoice_no, c.bill_invoice, c.crn_date, SUM(c.taxable_amt) AS taxable_amt, SUM(c.grand_total) AS grand_total, c.cust_id, c.user_id, c.is_stockable, cm.cust_name, e.fr_emp_name as user_name FROM t_credit_note_pos c, m_customer cm, m_fr_emp e WHERE c.del_status = 0 AND c.crn_date BETWEEN :fromDate AND :toDate AND c.cust_id = cm.cust_id AND c.user_id = e.fr_emp_id AND c.ex_int1=:frId GROUP BY c.crn_no ORDER BY c.crn_no DESC",nativeQuery=true)
	List<CreditNotePosHeaderDisp> getCrnPosHeaderAllCust(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
