package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.saledashboard.RouteWiseSaleForDash;

public interface RouteWiseSaleForDashRepo extends JpaRepository<RouteWiseSaleForDash, Integer> {

	@Query(value="SELECT\r\n" + 
			"    SUM(d.grand_total) AS sale,\r\n" + 
			"    SUM(d.order_qty) AS sale_qty,\r\n" + 
			"    r.route_id,\r\n" + 
			"    r.route_name\r\n" + 
			"FROM\r\n" + 
			"    t_bill_header h,\r\n" + 
			"    t_bill_detail d,\r\n" + 
			"    m_franchisee f,\r\n" + 
			"    m_fr_route r\r\n" + 
			"WHERE\r\n" + 
			"    h.bill_no = d.bill_no AND h.bill_date BETWEEN :fromDate AND :toDate AND h.del_status = 0 AND d.del_status = 0 AND h.fr_id = f.fr_id AND f.del_status = 0 AND f.fr_route_id = r.route_id AND r.del_status = 0\r\n" + 
			"GROUP BY\r\n" + 
			"    f.fr_route_id",nativeQuery=true)
	public List<RouteWiseSaleForDash> getRouteWiseSale( @Param("fromDate") String fromDate, @Param("toDate") String toDate);
	

}
