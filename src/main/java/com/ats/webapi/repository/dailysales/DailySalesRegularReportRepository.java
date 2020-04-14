package com.ats.webapi.repository.dailysales;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.dailysales.DailySalesRegular;


@Repository
public interface DailySalesRegularReportRepository extends JpaRepository<DailySalesRegular, Integer> {

	@Query(value=" select cat_id,coalesce((SELECT COALESCE(SUM(t_bill_detail.bill_qty),0) FROM t_bill_detail \n" + 
			"    WHERE\n" + 
			"	t_bill_detail.cat_id=m_category.cat_id\n" + 
			"	AND t_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                t_bill_header.bill_no \n" + 
			"            FROM\n" + 
			"                t_bill_header \n" + 
			"            WHERE\n" + 
			"                t_bill_header.fr_id=:frId\n" + 
			"                AND t_bill_header.status=2  \n" + 
			"                AND t_bill_header.bill_date=:date\n" + 
			"        )),0) as bill_qty,\n" + 
			"       coalesce((SELECT COALESCE(SUM(t_bill_detail.bill_qty*m_item.item_rate1),0) FROM t_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_bill_detail.cat_id=m_category.cat_id and t_bill_detail.item_id=m_item.id\n" + 
			"	AND t_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                t_bill_header.bill_no \n" + 
			"            FROM\n" + 
			"                t_bill_header \n" + 
			"            WHERE\n" + 
			"                t_bill_header.fr_id=:frId\n" + 
			"                AND t_bill_header.status=2  \n" + 
			"                AND t_bill_header.bill_date=:date\n" + 
			"        )),0) as bill_qty_rate,\n" + 
			" coalesce((SELECT COALESCE(SUM(t_bill_detail.bill_qty*m_item.item_mrp1),0) FROM t_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_bill_detail.cat_id=m_category.cat_id and t_bill_detail.item_id=m_item.id\n" + 
			"	AND t_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                t_bill_header.bill_no \n" + 
			"            FROM\n" + 
			"                t_bill_header \n" + 
			"            WHERE\n" + 
			"                t_bill_header.fr_id=:frId \n" + 
			"                AND t_bill_header.status=2  \n" + 
			"                AND t_bill_header.bill_date=:date\n" + 
			"        )),0) as bill_qty_mrp,\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_grn_gvn.grn_gvn_qty),0) \n" + 
			"    FROM\n" + 
			"        t_grn_gvn \n" + 
			"    WHERE\n" + 
			"        t_grn_gvn.fr_id=1 and t_grn_gvn.cat_id=m_category.cat_id\n" + 
			"        AND t_grn_gvn.grn_gvn_date=:date),0) as grn_gvn_qty,\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_grn_gvn.grn_gvn_amt),0) \n" + 
			"    FROM\n" + 
			"        t_grn_gvn \n" + 
			"    WHERE\n" + 
			"        t_grn_gvn.fr_id=1 and t_grn_gvn.cat_id=m_category.cat_id\n" + 
			"        AND t_grn_gvn.grn_gvn_date=:date),0) as grn_gvn_amt,\n" + 
			"\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_sell_bill_detail.qty),0)\n" + 
			"    FROM\n" + 
			"        t_sell_bill_detail \n" + 
			"    WHERE\n" + 
			"	t_sell_bill_detail.cat_id=m_category.cat_id\n" + 
			"        AND t_sell_bill_detail.sell_bill_no IN (\n" + 
			"            SELECT\n" + 
			"                t_sell_bill_header.sell_bill_no \n" + 
			"            FROM\n" + 
			"                t_sell_bill_header \n" + 
			"            WHERE\n" + 
			"                t_sell_bill_header.fr_id=:frId\n" + 
			"                AND t_sell_bill_header.bill_date=:date\n" + 
			"        )\n" + 
			"),0) as sell_qty,\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_sell_bill_detail.qty*m_item.item_rate1),0)\n" + 
			"    FROM\n" + 
			"        t_sell_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_sell_bill_detail.cat_id=m_category.cat_id and t_sell_bill_detail.item_id=m_item.id\n" + 
			"        AND t_sell_bill_detail.sell_bill_no IN (\n" + 
			"            SELECT\n" + 
			"                t_sell_bill_header.sell_bill_no \n" + 
			"            FROM\n" + 
			"                t_sell_bill_header \n" + 
			"            WHERE\n" + 
			"                t_sell_bill_header.fr_id=:frId\n" + 
			"                AND t_sell_bill_header.bill_date=:date\n" + 
			"        )\n" + 
			"),0) as sell_qty_rate,\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_sell_bill_detail.qty*m_item.item_mrp1),0)\n" + 
			"    FROM\n" + 
			"        t_sell_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_sell_bill_detail.cat_id=m_category.cat_id and t_sell_bill_detail.item_id=m_item.id\n" + 
			"        AND t_sell_bill_detail.sell_bill_no IN (\n" + 
			"            SELECT\n" + 
			"                t_sell_bill_header.sell_bill_no \n" + 
			"            FROM\n" + 
			"                t_sell_bill_header \n" + 
			"            WHERE\n" + 
			"                t_sell_bill_header.fr_id=:frId\n" + 
			"                AND t_sell_bill_header.bill_date=:date\n" + 
			"        )\n" + 
			"),0) as sell_qty_mrp,\n" + 
			"coalesce((\n" + 
			"SELECT\n" + 
			"        SUM(m_fr_opening_stock_detail.reg_opening_stock)\n" + 
			"    FROM\n" + 
			"        m_fr_opening_stock_detail  \n" + 
			"    WHERE\n" + 
			"         m_fr_opening_stock_detail.opening_stock_header_id  IN(\n" + 
			"            SELECT\n" + 
			"                m_fr_opening_stock_header.opening_stock_header_id \n" + 
			"            FROM\n" + 
			"                m_fr_opening_stock_header \n" + 
			"            WHERE\n" + 
			"                m_fr_opening_stock_header.fr_id=:frId \n" + 
			"                AND m_fr_opening_stock_header.month=:currentMonth \n" + 
			"                AND m_fr_opening_stock_header.year=:year \n" + 
			"                AND m_fr_opening_stock_header.cat_id=m_category.cat_id\n" + 
			"        )\n" + 
			"),0) as reg_opening_stock,\n" + 
			"coalesce((\n" + 
			"SELECT\n" + 
			"        SUM(m_fr_opening_stock_detail.reg_opening_stock*m_item.item_rate1)\n" + 
			"    FROM\n" + 
			"        m_fr_opening_stock_detail,m_item\n" + 
			"    WHERE\n" + 
			"        m_item.id=m_fr_opening_stock_detail.item_id\n" + 
			"        AND m_fr_opening_stock_detail.opening_stock_header_id  IN(\n" + 
			"            SELECT\n" + 
			"                m_fr_opening_stock_header.opening_stock_header_id \n" + 
			"            FROM\n" + 
			"                m_fr_opening_stock_header \n" + 
			"            WHERE\n" + 
			"                m_fr_opening_stock_header.fr_id=:frId \n" + 
			"                AND m_fr_opening_stock_header.month=:currentMonth  \n" + 
			"                AND m_fr_opening_stock_header.year=:year \n" + 
			"                AND m_fr_opening_stock_header.cat_id=m_category.cat_id\n" + 
			"        )\n" + 
			"),0) as reg_opening_stock_rate,\n" + 
			"coalesce((\n" + 
			"SELECT\n" + 
			"        SUM(m_fr_opening_stock_detail.reg_opening_stock*m_item.item_mrp1)\n" + 
			"    FROM\n" + 
			"        m_fr_opening_stock_detail,m_item\n" + 
			"    WHERE\n" + 
			"         m_item.id=m_fr_opening_stock_detail.item_id\n" + 
			"        AND m_fr_opening_stock_detail.opening_stock_header_id  IN(\n" + 
			"            SELECT\n" + 
			"                m_fr_opening_stock_header.opening_stock_header_id \n" + 
			"            FROM\n" + 
			"                m_fr_opening_stock_header \n" + 
			"            WHERE\n" + 
			"                m_fr_opening_stock_header.fr_id=:frId \n" + 
			"                AND m_fr_opening_stock_header.month=:currentMonth \n" + 
			"                AND m_fr_opening_stock_header.year=:year \n" + 
			"                AND m_fr_opening_stock_header.cat_id=m_category.cat_id\n" + 
			"        )\n" + 
			"),0) as reg_opening_stock_mrp\n" + 
			"\n" + 
			" from m_category where m_category.del_status=0 and m_category.cat_id!=5 and m_category.cat_id!=7",nativeQuery=true)
	List<DailySalesRegular> getDailySalesData(@Param("frId")int frId,@Param("date") String date,@Param("currentMonth") int currentMonth,@Param("year") int year);

	@Query(value=" select cat_id,coalesce((SELECT COALESCE(SUM(t_other_bill_detail.bill_qty),0) FROM t_other_bill_detail \n" + 
			"    WHERE\n" + 
			"	t_other_bill_detail.cat_id=m_category.cat_id\n" + 
			"	AND t_other_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                t_other_bill_header.bill_no \n" + 
			"            FROM\n" + 
			"                t_other_bill_header \n" + 
			"            WHERE\n" + 
			"                t_other_bill_header.fr_id=:frId \n" + 
			"                AND t_other_bill_header.bill_date=:date\n" + 
			"        )),0) as bill_qty,\n" + 
			"       coalesce((SELECT COALESCE(SUM(t_other_bill_detail.bill_qty*m_item.item_rate1),0) FROM t_other_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_other_bill_detail.cat_id=m_category.cat_id and t_other_bill_detail.item_id=m_item.id\n" + 
			"	AND t_other_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                t_other_bill_header.bill_no \n" + 
			"            FROM\n" + 
			"                t_other_bill_header \n" + 
			"            WHERE\n" + 
			"                t_other_bill_header.fr_id=:frId\n" + 
			"                AND t_other_bill_header.bill_date=:date\n" + 
			"        )),0) as bill_qty_rate,\n" + 
			" coalesce((SELECT COALESCE(SUM(t_other_bill_detail.bill_qty*m_item.item_mrp1),0) FROM t_other_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_other_bill_detail.cat_id=m_category.cat_id and t_other_bill_detail.item_id=m_item.id\n" + 
			"	AND t_other_bill_detail.bill_no IN(\n" + 
			"            SELECT\n" + 
			"                t_other_bill_header.bill_no \n" + 
			"            FROM\n" + 
			"                t_other_bill_header \n" + 
			"            WHERE\n" + 
			"                t_other_bill_header.fr_id=:frId \n" + 
			"                AND t_other_bill_header.bill_date=:date\n" + 
			"        )),0) as bill_qty_mrp,\n" + 
			"0 as grn_gvn_qty,\n" + 
			"0 as grn_gvn_amt,\n" + 
			"\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_sell_bill_detail.qty),0)\n" + 
			"    FROM\n" + 
			"        t_sell_bill_detail \n" + 
			"    WHERE\n" + 
			"	t_sell_bill_detail.cat_id=m_category.cat_id\n" + 
			"        AND t_sell_bill_detail.sell_bill_no IN (\n" + 
			"            SELECT\n" + 
			"                t_sell_bill_header.sell_bill_no \n" + 
			"            FROM\n" + 
			"                t_sell_bill_header \n" + 
			"            WHERE\n" + 
			"                t_sell_bill_header.fr_id=:frId\n" + 
			"                AND t_sell_bill_header.bill_date=:date\n" + 
			"        )\n" + 
			"),0) as sell_qty,\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_sell_bill_detail.qty*m_item.item_rate1),0)\n" + 
			"    FROM\n" + 
			"        t_sell_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_sell_bill_detail.cat_id=m_category.cat_id and t_sell_bill_detail.item_id=m_item.id\n" + 
			"        AND t_sell_bill_detail.sell_bill_no IN (\n" + 
			"            SELECT\n" + 
			"                t_sell_bill_header.sell_bill_no \n" + 
			"            FROM\n" + 
			"                t_sell_bill_header \n" + 
			"            WHERE\n" + 
			"                t_sell_bill_header.fr_id=:frId\n" + 
			"                AND t_sell_bill_header.bill_date=:date\n" + 
			"        )\n" + 
			"),0) as sell_qty_rate,\n" + 
			"coalesce((SELECT  COALESCE(SUM(t_sell_bill_detail.qty*m_item.item_mrp1),0)\n" + 
			"    FROM\n" + 
			"        t_sell_bill_detail,m_item\n" + 
			"    WHERE\n" + 
			"	t_sell_bill_detail.cat_id=m_category.cat_id and t_sell_bill_detail.item_id=m_item.id\n" + 
			"        AND t_sell_bill_detail.sell_bill_no IN (\n" + 
			"            SELECT\n" + 
			"                t_sell_bill_header.sell_bill_no \n" + 
			"            FROM\n" + 
			"                t_sell_bill_header \n" + 
			"            WHERE\n" + 
			"                t_sell_bill_header.fr_id=:frId\n" + 
			"                AND t_sell_bill_header.bill_date=:date\n" + 
			"        )\n" + 
			"),0) as sell_qty_mrp,\n" + 
			"coalesce((\n" + 
			"SELECT\n" + 
			"        SUM(other_item_stock_detail.opening_stock)\n" + 
			"    FROM\n" + 
			"        other_item_stock_detail  \n" + 
			"    WHERE\n" + 
			"         other_item_stock_detail.other_stock_header_id  IN(\n" + 
			"            SELECT\n" + 
			"                other_item_stock_header.other_stock_header_id \n" + 
			"            FROM\n" + 
			"                other_item_stock_header \n" + 
			"            WHERE\n" + 
			"                other_item_stock_header.fr_id=:frId \n" + 
			"                AND other_item_stock_header.month=:currentMonth \n" + 
			"                AND other_item_stock_header.year=:year \n" + 
			"        )\n" + 
			"),0) as reg_opening_stock,\n" + 
			"coalesce((\n" + 
			"SELECT\n" + 
			"        SUM(other_item_stock_detail.opening_stock*m_item.item_rate1)\n" + 
			"    FROM\n" + 
			"        other_item_stock_detail,m_item\n" + 
			"    WHERE\n" + 
			"        m_item.id=other_item_stock_detail.other_item_id\n" + 
			"        AND other_item_stock_detail.other_stock_header_id  IN(\n" + 
			"            SELECT\n" + 
			"                other_item_stock_header.other_stock_header_id \n" + 
			"            FROM\n" + 
			"                other_item_stock_header \n" + 
			"            WHERE\n" + 
			"                other_item_stock_header.fr_id=:frId \n" + 
			"                AND other_item_stock_header.month=:currentMonth \n" + 
			"                AND other_item_stock_header.year=:year  \n" + 
			"        )\n" + 
			"),0) as reg_opening_stock_rate,\n" + 
			"coalesce((\n" + 
			"SELECT\n" + 
			"        SUM(other_item_stock_detail.opening_stock*m_item.item_mrp1)\n" + 
			"    FROM\n" + 
			"        other_item_stock_detail,m_item\n" + 
			"    WHERE\n" + 
			"         m_item.id=other_item_stock_detail.other_item_id\n" + 
			"        AND other_item_stock_detail.other_stock_header_id  IN(\n" + 
			"            SELECT\n" + 
			"                other_item_stock_header.other_stock_header_id \n" + 
			"            FROM\n" + 
			"                other_item_stock_header \n" + 
			"            WHERE\n" + 
			"                other_item_stock_header.fr_id=:frId\n" + 
			"                AND other_item_stock_header.month=:currentMonth\n" + 
			"                AND other_item_stock_header.year=:year \n" + 
			"        )\n" + 
			"),0) as reg_opening_stock_mrp\n" + 
			"\n" + 
			" from m_category where m_category.del_status=0 and  m_category.cat_id=7",nativeQuery=true)
	DailySalesRegular getDailySalesOtherData(@Param("frId")int frId,@Param("date") String date,@Param("currentMonth") int currentMonth,@Param("year") int year);

}
