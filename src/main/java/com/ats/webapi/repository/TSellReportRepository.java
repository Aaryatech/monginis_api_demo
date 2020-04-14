package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.TSellReport; 

public interface TSellReportRepository extends JpaRepository<TSellReport, Integer>{
	
	@Query(value="select\r\n" + 
			"        d.item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        s.item_hsncd as hsn_no,\r\n" + 
			"        sum(d.cgst_rs-(d.igst_rs/2)) as cgst,\r\n" + 
			"        sum(d.sgst_rs-(d.igst_rs/2)) as sgst,\r\n" + 
			"        sum(d.igst_rs) as igst,\r\n" + 
			"        sum(d.total_tax) as total_tax,\r\n" + 
			"        sum(d.taxable_amt) as taxable_amt,\r\n" + 
			"        sum(d.grand_total) as grand_total \r\n" + 
			"    from\r\n" + 
			"        t_sell_bill_detail d ,\r\n" + 
			"        m_item i,\r\n" + 
			"        t_sell_bill_header h,\r\n" + 
			"        m_item_sup s \r\n" + 
			"    where\r\n" + 
			"        h.bill_date between :fromDate AND :toDate \r\n" + 
			"        and d.sell_bill_no=h.sell_bill_no \r\n" + 
			"        and d.item_id=i.id \r\n" + 
			"        and d.item_id=s.item_id \r\n" + 
			"        and h.fr_id=:frId \r\n" + 
			"    group by\r\n" + 
			"        hsn_no  \r\n" + 
			"    UNION\r\n" + 
			"    ALL  SELECT\r\n" + 
			"        t_sp_cake.sp_id,\r\n" + 
			"        m_sp_cake.sp_name AS item_name,\r\n" + 
			"        m_spcake_sup.sp_hsncd as hsn_no,\r\n" + 
			"        SUM(t_sp_cake.tax_1_amt) as cgst,\r\n" + 
			"        SUM(t_sp_cake.tax_2_amt) as sgst,\r\n" + 
			"        0 as igst,\r\n" + 
			"        SUM(t_sp_cake.tax_1_amt+t_sp_cake.tax_2_amt) as total_tax,\r\n" + 
			"        SUM(t_sp_cake.sp_grand_total-(t_sp_cake.tax_1_amt+t_sp_cake.tax_2_amt)) as taxable_amt,\r\n" + 
			"        sum(t_sp_cake.sp_grand_total) as grand_total                                                \r\n" + 
			"    FROM\r\n" + 
			"        t_sp_cake,\r\n" + 
			"        m_sp_cake,\r\n" + 
			"        m_spcake_sup                                                 \r\n" + 
			"    WHERE\r\n" + 
			"        t_sp_cake.fr_id IN(:frId)         \r\n" + 
			"        AND t_sp_cake.sp_id=m_sp_cake.sp_id \r\n" + 
			"        and m_sp_cake.sp_id=m_spcake_sup.sp_id \r\n" + 
			"        and  t_sp_cake.sp_delivery_date BETWEEN :fromDate AND :toDate     \r\n" + 
			"    GROUP BY\r\n" + 
			"        hsn_no",nativeQuery=true)
	List<TSellReport> hsnCodeWiseReport( @Param("frId")int frId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);

}
