package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.report.SpKgSummaryDao;

@Repository
public interface SpKgSummaryRepository extends JpaRepository<SpKgSummaryDao, String>{

	@Query(value="select UUID() as uid,a.* from (select  t1.sp_id as id,  t1.sp_name,t1.sp_selected_weight,t1.sp_qty,t1.sp_value,coalesce((t2.crn_qty),0) as crn_qty,coalesce((t2.crn_selected_weight),0)as crn_selected_weight,coalesce((t2.grn_gvn_amt),0)as grn_gvn_amt from (Select t.sp_id,m.sp_name,t.sp_selected_weight,count(*) as sp_qty,SUM(t.sp_backend_rate) as sp_value from t_sp_cake t,m_sp_cake m where t.del_status=0 and m.sp_id=t.sp_id and t.is_bill_generated=2 and  t.fr_id IN(:frId) and t.sp_delivery_date between :fromDate and :toDate group by t.sp_id,t.sp_selected_weight order by t.sp_id,m.sp_name,t.sp_selected_weight) t1\n" + 
			"LEFT JOIN\n" + 
			"(select t_credit_note_details.item_id as sp_id,\n" + 
			"count(*) as crn_qty,\n" + 
			"\n" + 
			"(select t.sp_selected_weight from t_sp_cake t where t.sp_order_no=(select order_id from t_bill_detail where t_bill_detail.bill_detail_no=(\n" + 
			"select bill_detail_no from t_grn_gvn where t_grn_gvn.grn_gvn_id=t_credit_note_details.grn_gvn_id))) as crn_selected_weight,\n" + 
			"\n" + 
			"SUM(t_credit_note_details.grn_gvn_amt) as grn_gvn_amt\n" + 
			"\n" + 
			"from t_credit_note_details,t_credit_note_header where t_credit_note_details.cat_id=5 and t_credit_note_header.crn_date between :fromDate and  :toDate and t_credit_note_header.fr_id IN(:frId) and t_credit_note_header.crn_id=t_credit_note_details.crn_id  group by t_credit_note_details.item_id,crn_selected_weight)\n" + 
			"t2 ON t1.sp_id = t2.sp_id and t1.sp_selected_weight=t2.crn_selected_weight\n" + 
			"UNION\n" + 
			"select t2.sp_id as id,  t2.sp_name,t2.crn_selected_weight as sp_selected_weight,coalesce((t1.sp_qty),0) as sp_qty,coalesce((t1.sp_value),0)as sp_value,coalesce((t2.crn_qty),0) as crn_qty,coalesce((t2.crn_selected_weight),0) as crn_selected_weight,coalesce((t2.grn_gvn_amt),0) as grn_gvn_amt from (Select t.sp_id,m.sp_name,t.sp_selected_weight,count(*) as sp_qty,SUM(t.sp_backend_rate) as sp_value from t_sp_cake t,m_sp_cake m where t.del_status=0 and m.sp_id=t.sp_id and t.is_bill_generated=2 and  t.fr_id IN(:frId) and t.sp_delivery_date between :fromDate and :toDate group by t.sp_id,t.sp_selected_weight order by t.sp_id,m.sp_name,t.sp_selected_weight) t1\n" + 
			"RIGHT JOIN\n" + 
			"(select t_credit_note_details.item_id as sp_id,\n" + 
			"count(*) as crn_qty,\n" + 
			"m_sp_cake.sp_name,\n" + 
			"(select t.sp_selected_weight from t_sp_cake t where t.sp_order_no=(select order_id from t_bill_detail where t_bill_detail.bill_detail_no=(\n" + 
			"select bill_detail_no from t_grn_gvn where t_grn_gvn.grn_gvn_id=t_credit_note_details.grn_gvn_id))) as crn_selected_weight,\n" + 
			"SUM(t_credit_note_details.grn_gvn_amt) as grn_gvn_amt\n" + 
			"from t_credit_note_details,t_credit_note_header,m_sp_cake where t_credit_note_details.cat_id=5  and t_credit_note_header.fr_id IN(:frId) and t_credit_note_header.crn_date  between :fromDate and :toDate and t_credit_note_header.crn_id=t_credit_note_details.crn_id and m_sp_cake.sp_id=t_credit_note_details.item_id group by t_credit_note_details.item_id,crn_selected_weight)\n" + 
			"t2 ON t1.sp_id = t2.sp_id and t1.sp_selected_weight=t2.crn_selected_weight\n" + 
			") a order by sp_selected_weight",nativeQuery=true)
	List<SpKgSummaryDao> getSpKgSummaryReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frId") List<Integer> frId);

}
