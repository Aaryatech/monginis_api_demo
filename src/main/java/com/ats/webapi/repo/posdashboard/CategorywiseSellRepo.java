package com.ats.webapi.repo.posdashboard;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

 import com.ats.webapi.model.posdashboard.CategorywiseSell;

public interface CategorywiseSellRepo  extends JpaRepository<CategorywiseSell, Integer>{

	
	
	@Query(value = "SELECT\n" + 
			"    t_sell_bill_detail.cat_id,\n" + 
			"    SUM(\n" + 
			"        t_sell_bill_detail.grand_total\n" + 
			"    ) AS Cat_total,\n" + 
			"    m_category.cat_name\n" + 
			"FROM\n" + 
			"    t_sell_bill_detail,\n" + 
			"    t_sell_bill_header,\n" + 
			"    m_category\n" + 
			"WHERE\n" + 
			"    t_sell_bill_header.sell_bill_no = t_sell_bill_detail.sell_bill_no AND t_sell_bill_header.bill_date BETWEEN :fromDate AND :toDate AND t_sell_bill_detail.del_status = 0 AND t_sell_bill_header.del_status = 0 AND t_sell_bill_header.fr_id =:frId AND m_category.cat_id = t_sell_bill_detail.cat_id\n" + 
			"GROUP BY\n" + 
			"    m_category.cat_id", nativeQuery = true)
	List<CategorywiseSell> getCategorywiseSell(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("frId") int  frId);
	
	
	
}
