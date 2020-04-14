package com.ats.webapi.repo.salesreport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.salesreport.SubCatCreditGrnFrRep;

public interface SubCatCreditGrnFrRepRepo extends JpaRepository<SubCatCreditGrnFrRep, Integer> {

	@Query(value = " SELECT  UUID() as id," + 
			"			        t_credit_note_details.crnd_id,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name,  \n" + 
			"			        f.fr_id\n" + 
			"			     \n" + 
			"			    FROM  \n" + 
			"			        t_credit_note_header,  \n" + 
			"			        t_credit_note_details,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_item        \n" + 
			"			    WHERE  \n" + 
			"			        t_credit_note_header.crn_id=t_credit_note_details.crn_id            \n" + 
			"			        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate          \n" + 
			"			        AND f.fr_id=t_credit_note_header.fr_id            \n" + 
			"			        AND m_item.id=t_credit_note_details.item_id            \n" + 
			"			        AND m_item.item_grp2=sc.sub_cat_id            \n" + 
			"			        AND t_credit_note_details.cat_id !=5             \n" + 
			"			        AND t_credit_note_header.fr_id IN(  \n" + 
			"			           :frIdList   \n" + 
			"			        )            \n" + 
			"			        AND sc.sub_cat_id IN(  \n" + 
			"			           :subCatIdList     \n" + 
			"			        )            \n" + 
			"			        AND t_credit_note_details.is_grn=0                \n" + 
			"			    GROUP BY  \n" + 
			"			       t_credit_note_header.fr_id,m_item.item_grp1,m_item.item_grp2\n" + 
			"			          \n" + 
			"			        UNION  \n" + 
			"			    ALL     \n" + 
			"			      \n" + 
			"			     SELECT  UUID() as id," + 
			"			        t_credit_note_details.crnd_id,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name,  \n" + 
			"			        f.fr_id     \n" + 
			"			    FROM  \n" + 
			"			        t_credit_note_header,  \n" + 
			"			        t_credit_note_details,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_sp_cake        \n" + 
			"			    WHERE  \n" + 
			"			        t_credit_note_header.crn_id=t_credit_note_details.crn_id            \n" + 
			"			        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate          \n" + 
			"			        AND f.fr_id=t_credit_note_header.fr_id            \n" + 
			"			        AND m_sp_cake.sp_id=t_credit_note_details.item_id      \n" + 
			"			          AND t_credit_note_details.cat_id=5        \n" + 
			"			        AND t_credit_note_header.fr_id IN(  \n" + 
			"			            :frIdList    \n" + 
			"			        )     AND sc.cat_id=5        \n" + 
			"			        AND sc.sub_cat_id IN(  \n" + 
			"			          :subCatIdList    \n" + 
			"			        )            \n" + 
			"			        AND t_credit_note_details.is_grn=0                \n" + 
			"			    GROUP BY  \n" + 
			"			        t_credit_note_header.fr_id,sc.sub_cat_id", nativeQuery = true)
	List<SubCatCreditGrnFrRep> getDataGVN(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

	@Query(value = "\n" + 
			" SELECT  UUID() as id," + 
			"			        t_credit_note_details.crnd_id,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name,  \n" + 
			"			        f.fr_id\n" + 
			"			     \n" + 
			"			    FROM  \n" + 
			"			        t_credit_note_header,  \n" + 
			"			        t_credit_note_details,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_item        \n" + 
			"			    WHERE  \n" + 
			"			        t_credit_note_header.crn_id=t_credit_note_details.crn_id            \n" + 
			"			        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate          \n" + 
			"			        AND f.fr_id=t_credit_note_header.fr_id            \n" + 
			"			        AND m_item.id=t_credit_note_details.item_id            \n" + 
			"			        AND m_item.item_grp2=sc.sub_cat_id            \n" + 
			"			        AND t_credit_note_details.cat_id !=5             \n" + 
			"			        AND t_credit_note_header.fr_id IN(  \n" + 
			"			           :frIdList   \n" + 
			"			        )            \n" + 
			"			        AND sc.sub_cat_id IN(  \n" + 
			"			           :subCatIdList     \n" + 
			"			        )            \n" + 
			"			        AND t_credit_note_details.is_grn=1                \n" + 
			"			    GROUP BY  \n" + 
			"			       t_credit_note_header.fr_id,m_item.item_grp2\n" + 
			"			          \n" + 
			"			        UNION  \n" + 
			"			    ALL     \n" + 
			"			      \n" + 
			"			     SELECT  UUID() as id," + 
			"			        t_credit_note_details.crnd_id,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_amt) AS var_amt,  \n" + 
			"			        SUM(t_credit_note_details.grn_gvn_qty) AS var_qty ,  \n" + 
			"			        f.fr_name,  \n" + 
			"			        sc.sub_cat_id,  \n" + 
			"			        sc.sub_cat_name,  \n" + 
			"			        f.fr_id     \n" + 
			"			    FROM  \n" + 
			"			        t_credit_note_header,  \n" + 
			"			        t_credit_note_details,  \n" + 
			"			        m_franchisee f ,  \n" + 
			"			        m_cat_sub sc ,  \n" + 
			"			        m_sp_cake        \n" + 
			"			    WHERE  \n" + 
			"			        t_credit_note_header.crn_id=t_credit_note_details.crn_id            \n" + 
			"			        AND t_credit_note_header.crn_date BETWEEN :fromDate AND :toDate          \n" + 
			"			        AND f.fr_id=t_credit_note_header.fr_id            \n" + 
			"			        AND m_sp_cake.sp_id=t_credit_note_details.item_id      \n" + 
			"			          AND t_credit_note_details.cat_id=5        \n" + 
			"			        AND t_credit_note_header.fr_id IN(  \n" + 
			"			            :frIdList    \n" + 
			"			        )     AND sc.cat_id=5        \n" + 
			"			        AND sc.sub_cat_id IN(  \n" + 
			"			          :subCatIdList    \n" + 
			"			        )            \n" + 
			"			        AND t_credit_note_details.is_grn=1                \n" + 
			"			    GROUP BY  \n" + 
			"			        t_credit_note_header.fr_id,sc.sub_cat_id", nativeQuery = true)
	List<SubCatCreditGrnFrRep> getDataGRN(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frIdList") List<Integer> frIdList, @Param("subCatIdList") List<Integer> subCatIdList);

}
