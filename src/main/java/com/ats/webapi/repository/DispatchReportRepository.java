package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.report.DispatchReport;

@Repository
public interface DispatchReportRepository extends JpaRepository<DispatchReport, Integer>{

	@Query(value="select t_bill_detail.bill_detail_no,t_bill_detail.bill_no,t_bill_detail.cat_id,m_category.cat_name,m_cat_sub.sub_cat_id,t_bill_header.fr_id,m_franchisee.fr_name,t_bill_detail.item_id,m_item.item_name,SUM(t_bill_detail.order_qty) as order_qty,SUM(t_bill_detail.bill_qty) as bill_qty \n" + 
			"from t_bill_detail,t_bill_header,m_category,m_franchisee,m_item,m_cat_sub\n" + 
			"where t_bill_detail.bill_no In(select bill_no from t_bill_header\n" + 
			"where bill_date=:billDateYMD and fr_id in(:frId)) And t_bill_detail.cat_id In(:categories) \n" + 
			"And t_bill_detail.cat_id=m_category.cat_id And t_bill_header.fr_id=m_franchisee.fr_id and t_bill_header.del_status=0 \n" + 
			"And m_item.id=t_bill_detail.item_id And m_cat_sub.sub_cat_id=m_item.item_grp2 And t_bill_header.bill_no=t_bill_detail.bill_no \n" + 
			"group by t_bill_detail.item_id,t_bill_header.fr_id order by t_bill_header.fr_id\n" + 
			"",nativeQuery=true)
	List<DispatchReport> findDispatchReportList(@Param("billDateYMD")String billDateYMD,@Param("frId") List<String> frId,@Param("categories") List<String> categories);

}
