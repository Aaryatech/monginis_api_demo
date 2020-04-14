package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.GrnGvnReport; 

public interface GrnGvnReportRepository extends JpaRepository<GrnGvnReport, Integer>{
	
	@Query(value="  select\r\n" + 
			"        g.grn_gvn_id,\r\n" + 
			"        g.grn_gvn_date,\r\n" + 
			"        g.item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        g.sgst_per+g.cgst_per as tax_rate,\r\n" + 
			"        g.taxable_amt as taxable_amt,\r\n" + 
			"        g.total_tax as total_tax,\r\n" + 
			"        g.grn_gvn_amt as grn_gvn_amt,\r\n" + 
			"        g.apr_taxable_amt as apr_taxable_amt,\r\n" + 
			"        g.apr_sgst_rs as apr_sgst_rs,\r\n" + 
			"        g.apr_cgst_rs as apr_cgst_rs,\r\n" + 
			"        g.apr_igst_rs as apr_igst_rs,\r\n" + 
			"        g.apr_grand_total as apr_grand_total \r\n" + 
			"    from\r\n" + 
			"        t_grn_gvn g,\r\n" + 
			"        m_item i \r\n" + 
			"    where\r\n" + 
			"        g.grn_gvn_date between :fromDate and :toDate \r\n" + 
			"        and g.item_id=i.id \r\n" + 
			"        and g.is_grn in(:isGrn) \r\n" + 
			"        and g.fr_id=:frId  \r\n" + 
			" order by g.grn_gvn_header_id,tax_rate",nativeQuery=true)
	List<GrnGvnReport> grnGvnReportDateWise( @Param("frId")int frId,@Param("fromDate")String fromDate,@Param("toDate")String toDate,
			@Param("isGrn")String isGrn);

	@Query(value="  select\r\n" + 
			"        g.grn_gvn_id,\r\n" + 
			"        g.grn_gvn_date,\r\n" + 
			"        g.item_id,\r\n" + 
			"        i.item_name,\r\n" + 
			"        g.sgst_per+g.cgst_per as tax_rate,\r\n" + 
			"        g.taxable_amt as taxable_amt,\r\n" + 
			"        g.total_tax as total_tax,\r\n" + 
			"        g.grn_gvn_amt as grn_gvn_amt,\r\n" + 
			"        g.apr_taxable_amt as apr_taxable_amt,\r\n" + 
			"        g.apr_sgst_rs as apr_sgst_rs,\r\n" + 
			"        g.apr_cgst_rs as apr_cgst_rs,\r\n" + 
			"        g.apr_igst_rs as apr_igst_rs,\r\n" + 
			"        g.apr_grand_total as apr_grand_total \r\n" + 
			"    from\r\n" + 
			"        t_grn_gvn g,\r\n" + 
			"        m_item i \r\n" + 
			"    where\r\n" + 
			"        g.grn_gvn_date between :fromDate and :toDate\r\n" + 
			"        and g.item_id=i.id \r\n" + 
			"        and g.is_grn in(\r\n" + 
			"         :isGrn\r\n" + 
			"        ) \r\n" + 
			"        and g.fr_id=:frId and g.cat_id!=5\r\n" + 
			" order by g.grn_gvn_header_id,tax_rate",nativeQuery=true)
	List<GrnGvnReport> grnGvnReportDateWiseOfGvn(@Param("frId")int frId,@Param("fromDate")String fromDate,@Param("toDate")String toDate,
			@Param("isGrn")String isGrn);
	@Query(value="select\r\n" + 
			"			        g.grn_gvn_id,\r\n" + 
			"			        g.grn_gvn_date,\r\n" + 
			"			        g.item_id,\r\n" + 
			"			        s.sp_name as item_name,\r\n" + 
			"			        g.sgst_per+g.cgst_per as tax_rate,\r\n" + 
			"			        g.taxable_amt as taxable_amt,\r\n" + 
			"			        g.total_tax as total_tax,\r\n" + 
			"			        g.grn_gvn_amt as grn_gvn_amt,\r\n" + 
			"			        g.apr_taxable_amt as apr_taxable_amt,\r\n" + 
			"			        g.apr_sgst_rs as apr_sgst_rs,\r\n" + 
			"			        g.apr_cgst_rs as apr_cgst_rs,\r\n" + 
			"			        g.apr_igst_rs as apr_igst_rs,\r\n" + 
			"			        g.apr_grand_total as apr_grand_total \r\n" + 
			"			    from\r\n" + 
			"			        t_grn_gvn g,\r\n" + 
			"			        m_sp_cake s \r\n" + 
			"			    where\r\n" + 
			"			        g.grn_gvn_date between :fromDate and   :toDate \r\n" + 
			"			        and g.item_id=s.sp_id \r\n" + 
			"			        and g.is_grn in(\r\n" + 
			"			        :isGrn   \r\n" + 
			"			        ) \r\n" + 
			"			        and g.fr_id=:frId and g.cat_id=5\r\n" + 
			"			 order by g.grn_gvn_header_id,tax_rate	",nativeQuery=true)
	List<GrnGvnReport> grnGvnReportDateWiseOfGvnForSp(@Param("frId")int frId,@Param("fromDate")String fromDate,@Param("toDate")String toDate,
			@Param("isGrn")String isGrn);
}
