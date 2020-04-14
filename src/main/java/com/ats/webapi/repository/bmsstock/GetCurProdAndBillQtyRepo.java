package com.ats.webapi.repository.bmsstock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.stock.GetCurProdAndBillQty;

public interface GetCurProdAndBillQtyRepo extends JpaRepository<GetCurProdAndBillQty, Integer> {
	// Prev Query
	/*@Query(value = " SELECT m_item.id,m_item.item_name, \n"
			+ "coalesce((Select SUM(t_production_plan_detail.production_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate "
			+ "AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id "
			+ "AND m_item.id=t_production_plan_detail.item_id),0) AS prod_qty, \n" + "\n"
			+ "coalesce((Select SUM(t_production_plan_detail.rejected_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate AND"
			+ " t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND"
			+ " m_item.id=t_production_plan_detail.item_id),0) AS rejected_qty,\n" + "\n"
			+ "coalesce((Select SUM( t_bill_detail.bill_qty) FROM t_bill_header,t_bill_detail"
			+ " WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no "
			+ "AND m_item.id=t_bill_detail.item_id),0) AS bill_qty,"

			+ "coalesce((Select SUM(t_production_plan_detail.int5) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate AND"
			+ " t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND"
			+ " m_item.id=t_production_plan_detail.item_id),0) AS damaged_qty \n" + "\n"
			+ "FROM m_item where m_item.item_grp1=:catId AND m_item.del_status=:delStatus " + "", nativeQuery = true)*/
	
	@Query(value=" Select a.id,a.item_name, \n" + 
			"			                                coalesce((b.prod_qty),0) AS prod_qty,  \n" + 
			"						        coalesce((c.rejected_qty),0) AS rejected_qty,  \n" + 
			"						        coalesce((e.bill_qty),0) AS bill_qty,  \n" + 
			"						        coalesce((d.damaged_qty),0) AS damaged_qty     \n" + 
			"			                               from  \n" + 
			"			                             (SELECT \n" + 
			"						        m_item.id,  \n" + 
			"						        m_item.item_name			       \n" + 
			"						    FROM  \n" + 
			"						        m_item   \n" + 
			"						    where  \n" + 
			"						        m_item.item_grp1=:catId \n" + 
			"						        AND m_item.del_status=:delStatus) a \n" + 
			"			                      left join  \n" + 
			"			                               (Select  t_production_plan_detail.item_id, \n" + 
			"			                                     SUM(t_production_plan_detail.production_qty)  prod_qty \n" + 
			"						        FROM  \n" + 
			"						            t_production_plan_detail,  \n" + 
			"						            t_production_plan_header   \n" + 
			"						        where  \n" + 
			"						            t_production_plan_header.production_date=:prodDate  and             t_production_plan_header.del_status=0  \n" + 
			"						            AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id   \n" + 
			"						              group by t_production_plan_detail.item_id) b  \n" + 
			"			                      on a.id=b.item_id   left join  \n" + 
			"							( Select t_production_plan_detail.item_id,SUM(t_production_plan_detail.rejected_qty)   rejected_qty \n" + 
			"						        FROM  \n" + 
			"						            t_production_plan_detail,  \n" + 
			"						            t_production_plan_header   \n" + 
			"						        where  \n" + 
			"						            t_production_plan_header.production_date=:prodDate and t_production_plan_header.del_status=0   \n" + 
			"						            AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id   \n" + 
			"						            group by t_production_plan_detail.item_id) c  \n" + 
			"			                      on a.id=c.item_id left join  \n" + 
			"			                                (Select t_production_plan_detail.item_id,SUM(t_production_plan_detail.int5)  damaged_qty \n" + 
			"						        FROM  \n" + 
			"						            t_production_plan_detail,  \n" + 
			"						            t_production_plan_header   \n" + 
			"						        where  \n" + 
			"						            t_production_plan_header.production_date=:prodDate  and t_production_plan_header.del_status=0  \n" + 
			"						            AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id   \n" + 
			"						            group by t_production_plan_detail.item_id ) d  \n" + 
			"			                      on a.id=d.item_id left join  \n" + 
			"							(Select t_bill_detail.item_id,SUM( t_bill_detail.bill_qty) bill_qty FROM t_bill_header,t_bill_detail \n" + 
			"						 WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no  \n" + 
			"						group by t_bill_detail.item_id) e  \n" + 
			"			                      on a.id=e.item_id ",nativeQuery=true)
	List<GetCurProdAndBillQty> getCurProdAndBillQty(@Param("prodDate") String prodDate, @Param("catId") int catId,
			@Param("delStatus") int delStatus, @Param("timestamp") String timestamp,
			@Param("curTimeStamp") String curTimeStamp);

//New Query

	// changed for getting All Items without catIds 27 Jan 2018

	/*@Query(value = " SELECT m_item.id,m_item.item_name, \n"
			+ "coalesce((Select SUM(t_production_plan_detail.production_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate "
			+ "AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id "
			+ "AND m_item.id=t_production_plan_detail.item_id),0) AS prod_qty, \n" + "\n"
			+ "coalesce((Select SUM(t_production_plan_detail.rejected_qty) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate AND"
			+ " t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND"
			+ " m_item.id=t_production_plan_detail.item_id),0) AS rejected_qty,\n" + "\n"
			+ "coalesce((Select SUM( t_bill_detail.bill_qty) FROM t_bill_header,t_bill_detail"
			+ " WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no "
			+ "AND m_item.id=t_bill_detail.item_id),0) AS bill_qty,"

			+ "coalesce((Select SUM(t_production_plan_detail.int5) FROM t_production_plan_detail,"
			+ "t_production_plan_header where t_production_plan_header.production_date=:prodDate AND"
			+ " t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND"
			+ " m_item.id=t_production_plan_detail.item_id),0) AS damaged_qty \n" + "\n"
			+ "FROM m_item where m_item.del_status=:delStatus " + "", nativeQuery = true)*/
	@Query(value = "   Select a.id,a.item_name, \n" + 
			"			                                coalesce((b.prod_qty),0) AS prod_qty,  \n" + 
			"						        coalesce((c.rejected_qty),0) AS rejected_qty,  \n" + 
			"						        coalesce((e.bill_qty),0) AS bill_qty,  \n" + 
			"						        coalesce((d.damaged_qty),0) AS damaged_qty     \n" + 
			"			                               from  \n" + 
			"			                             (SELECT \n" + 
			"						        m_item.id,  \n" + 
			"						        m_item.item_name			       \n" + 
			"						    FROM  \n" + 
			"						        m_item   \n" + 
			"						    where  \n" + 
			"						     m_item.del_status=:delStatus) a \n" + 
			"			                      left join  \n" + 
			"			                               (Select  t_production_plan_detail.item_id, \n" + 
			"			                                     SUM(t_production_plan_detail.production_qty)  prod_qty \n" + 
			"						        FROM  \n" + 
			"						            t_production_plan_detail,  \n" + 
			"						            t_production_plan_header   \n" + 
			"						        where  \n" + 
			"						            t_production_plan_header.production_date=:prodDate  and             t_production_plan_header.del_status=0  \n" + 
			"						            AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id   \n" + 
			"						              group by t_production_plan_detail.item_id) b  \n" + 
			"			                      on a.id=b.item_id   left join  \n" + 
			"							( Select t_production_plan_detail.item_id,SUM(t_production_plan_detail.rejected_qty)   rejected_qty \n" + 
			"						        FROM  \n" + 
			"						            t_production_plan_detail,  \n" + 
			"						            t_production_plan_header   \n" + 
			"						        where  \n" + 
			"						            t_production_plan_header.production_date=:prodDate and t_production_plan_header.del_status=0   \n" + 
			"						            AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id   \n" + 
			"						            group by t_production_plan_detail.item_id) c  \n" + 
			"			                      on a.id=c.item_id left join  \n" + 
			"			                                (Select t_production_plan_detail.item_id,SUM(t_production_plan_detail.int5)  damaged_qty \n" + 
			"						        FROM  \n" + 
			"						            t_production_plan_detail,  \n" + 
			"						            t_production_plan_header   \n" + 
			"						        where  \n" + 
			"						            t_production_plan_header.production_date=:prodDate  and t_production_plan_header.del_status=0  \n" + 
			"						            AND t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id   \n" + 
			"						            group by t_production_plan_detail.item_id ) d  \n" + 
			"			                      on a.id=d.item_id left join  \n" + 
			"							(Select t_bill_detail.item_id,SUM( t_bill_detail.bill_qty) bill_qty FROM t_bill_header,t_bill_detail \n" + 
			"						 WHERE t_bill_header.remark BETWEEN :timestamp AND :curTimeStamp  AND t_bill_header.bill_no=t_bill_detail.bill_no  \n" + 
			"						group by t_bill_detail.item_id) e  \n" + 
			"			                      on a.id=e.item_id ", nativeQuery = true)
	List<GetCurProdAndBillQty> getCurProdAndBillQtyAllCat(@Param("prodDate") String prodDate,
			@Param("delStatus") int delStatus, @Param("timestamp") String timestamp,
			@Param("curTimeStamp") String curTimeStamp);

}
