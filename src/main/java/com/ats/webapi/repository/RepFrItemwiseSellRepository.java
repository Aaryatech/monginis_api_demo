package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.GetRepItemwiseSell;

public interface RepFrItemwiseSellRepository extends JpaRepository<GetRepItemwiseSell, Integer>{
	
	@Query(value="select d.sell_bill_detail_no, d.item_id, h.fr_id, f.fr_name, t.item_name, c.cat_name, d.cat_id, h.bill_date, sum(d.qty) as qty,"
			+" sum(d.mrp*d.qty) as amount from t_sell_bill_detail d, t_sell_bill_header h, m_category c,"
			+" m_item t, m_franchisee f WHERE h.bill_date BETWEEN :fromDate AND :toDate AND d.cat_id IN(:catId)"
			+" AND c.cat_id=d.cat_id AND d.item_id=t.id AND h.sell_bill_no=d.sell_bill_no AND h.fr_id IN(:frId) AND"
			+" h.fr_id=f.fr_id GROUP BY d.item_id, h.fr_id "
,nativeQuery=true)
	List<GetRepItemwiseSell> getRepFrItemwiseSell(@Param("fromDate") String fromDate,@Param("toDate") String toDate, @Param("frId") List<String> frId, @Param("catId") List<String> catId);
	
                 
                 @Query(value="SELECT t_sp_cake.sp_order_no As sell_bill_detail_no," + 
                 		"    t_sp_cake.sp_id as item_id," + 
                 		"    t_sp_cake.fr_id," + 
                 		"    m_franchisee.fr_name," + 
                 		"    m_sp_cake.sp_name as item_name," + 
                 		"    'Speacial Cake' as cat_name," + 
                 		"    5 as cat_id," + 
                 		"    t_sp_cake.sp_delivery_date as bill_date," + 
                 		"    COUNT(t_sp_cake.sp_order_no) AS qty ," + 
                 		"    SUM(t_sp_cake.sp_grand_total) as amount" + 
                 		"    FROM t_sp_cake," + 
                 		"    m_sp_cake," + 
                 		"    m_franchisee " + 
                 		"    WHERE " + 
                 		"    t_sp_cake.sp_id=m_sp_cake.sp_id AND" + 
                 		"     t_sp_cake.sp_delivery_date BETWEEN :fromDate AND :toDate" + 
                 		"			        AND t_sp_cake.fr_id IN(:frId)" + 
                 		"			        AND m_franchisee.fr_id=t_sp_cake.fr_id and t_sp_cake.sp_book_for_mob_no != '0' " + 
                 		"                 GROUP by t_sp_cake.sp_id,m_franchisee.fr_id"
             ,nativeQuery=true)
             	List<GetRepItemwiseSell> getRepFrItemwiseSellCatId5(@Param("fromDate") String fromDate,@Param("toDate") String toDate, @Param("frId") List<String> frId);
	
	@Query(value="select d.sell_bill_detail_no, d.item_id, h.fr_id, f.fr_name, t.item_name, c.cat_name, d.cat_id, h.bill_date, sum(d.qty) as qty,"
			+" sum(d.mrp*d.qty) as amount from t_sell_bill_detail d, t_sell_bill_header h, m_category c,"
			+" m_item t, m_franchisee f WHERE h.bill_date BETWEEN :fromDate AND :toDate AND d.cat_id IN(:catId)"
			+" AND c.cat_id=d.cat_id AND d.item_id=t.id AND h.sell_bill_no=d.sell_bill_no AND h.fr_id IN(:frId) AND"
			+" h.fr_id=f.fr_id GROUP BY h.bill_date, d.item_id, h.fr_id order by bill_date,t.item_name",nativeQuery=true)
	List<GetRepItemwiseSell> getRepFrDateItemwiseSell(@Param("fromDate") String fromDate,@Param("toDate") String toDate, @Param("frId") List<String> frId, @Param("catId") List<String> catId);

	
	  
    @Query(value="SELECT t_sp_cake.sp_order_no As sell_bill_detail_no," + 
    		"    t_sp_cake.sp_id as item_id," + 
    		"    t_sp_cake.fr_id," + 
    		"    m_franchisee.fr_name," + 
    		"    m_sp_cake.sp_name as item_name," + 
    		"    'Speacial Cake' as cat_name," + 
    		"    5 as cat_id," + 
    		"    t_sp_cake.sp_delivery_date as bill_date," + 
    		"    COUNT(t_sp_cake.sp_order_no) AS qty ," + 
    		"    SUM(t_sp_cake.sp_grand_total) as amount" + 
    		"    FROM t_sp_cake," + 
    		"    m_sp_cake," + 
    		"    m_franchisee " + 
    		"    WHERE " + 
    		"    t_sp_cake.sp_id=m_sp_cake.sp_id AND" + 
    		"     t_sp_cake.sp_delivery_date BETWEEN :fromDate AND :toDate" + 
    		"			        AND t_sp_cake.fr_id IN(:frId)" + 
    		"			        AND m_franchisee.fr_id=t_sp_cake.fr_id" + 
    		"                 GROUP by t_sp_cake.sp_delivery_date, t_sp_cake.sp_id,m_franchisee.fr_id "
,nativeQuery=true)
	List<GetRepItemwiseSell> getRepFrDateItemwiseSellCatId5(@Param("fromDate") String fromDate,@Param("toDate") String toDate, @Param("frId") List<String> frId);

	
	@Query(value="select d.sell_bill_detail_no, d.item_id, h.fr_id, f.fr_name, t.item_name, c.cat_name, d.cat_id, h.bill_date, sum(d.qty) as qty,"
			+" sum(d.mrp*d.qty) as amount from t_sell_bill_detail d, t_sell_bill_header h, m_category c,"
			+" m_item t, m_franchisee f WHERE h.bill_date BETWEEN :fromDate AND :toDate AND d.cat_id IN(:catId)"
			+" AND c.cat_id=d.cat_id AND d.item_id=t.id AND h.sell_bill_no=d.sell_bill_no AND h.fr_id IN(:frId) AND"
			+" h.fr_id=f.fr_id GROUP BY h.bill_date,  h.fr_id ",nativeQuery=true)
	List<GetRepItemwiseSell> getRepFrDateCatwiseSell(@Param("fromDate") String fromDate,@Param("toDate") String toDate, @Param("frId") List<String> frId, @Param("catId") List<String> catId);

	
}
