package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.CreditNoteReport;

public interface CreditNoteReportRepo extends JpaRepository<CreditNoteReport, Integer>{

	@Query(value="select * from (select\n" + 
			"        cd.*,\n" + 
			"        ch.crn_date,\n" + 
			"        ch.crn_no,\n" + 
			"        i.item_name,\n" + 
			"        f.fr_name,\n" + 
			"        ch.fr_id,\n" + 
			"        coalesce((select\n" + 
			"            item_uom \n" + 
			"        from\n" + 
			"            m_item_sup \n" + 
			"        where\n" + 
			"            m_item_sup.item_id=i.id ),\n" + 
			"        '-') as item_uom     \n" + 
			"    from\n" + 
			"        t_credit_note_details cd,\n" + 
			"        t_credit_note_header ch,\n" + 
			"        t_grn_gvn g,\n" + 
			"        m_item i,\n" + 
			"        m_franchisee f      \n" + 
			"    where\n" + 
			"        ch.crn_date between :fromDate and :toDate          \n" + 
			"        and cd.crn_id=ch.crn_id          \n" + 
			"        and cd.grn_gvn_id=g.grn_gvn_id          \n" + 
			"        and cd.item_id=i.id          \n" + 
			"        and f.fr_id = ch.fr_id\n" + 
			"        and cd.cat_id!=5 \n" + 
			"union all \n" + 
			"select\n" + 
			"        cd.*,\n" + 
			"        ch.crn_date,\n" + 
			"        ch.crn_no,\n" + 
			"        i.sp_name,\n" + 
			"        f.fr_name,\n" + 
			"        ch.fr_id,\n" + 
			"        coalesce((select\n" + 
			"            sp_uom \n" + 
			"        from\n" + 
			"            m_spcake_sup \n" + 
			"        where\n" + 
			"            m_spcake_sup.sp_id=i.sp_id ),\n" + 
			"        '-') as item_uom     \n" + 
			"    from\n" + 
			"        t_credit_note_details cd,\n" + 
			"        t_credit_note_header ch,\n" + 
			"        t_grn_gvn g,\n" + 
			"        m_sp_cake i,\n" + 
			"        m_franchisee f      \n" + 
			"    where\n" + 
			"        ch.crn_date between :fromDate and :toDate          \n" + 
			"        and cd.crn_id=ch.crn_id          \n" + 
			"        and cd.grn_gvn_id=g.grn_gvn_id          \n" + 
			"        and cd.item_id=i.sp_id          \n" + 
			"        and f.fr_id = ch.fr_id\n" + 
			"        and cd.cat_id=5) a\n" + 
			"  order by\n" + 
			"         fr_name,\n" + 
			"         crn_id \n" + 
			"     \n" + 
			" \n" + 
			"\n" + 
			"",nativeQuery=true)
	List<CreditNoteReport> creditNoteReportBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value="select * from (select\n" + 
			"        cd.*,\n" + 
			"        ch.crn_date,\n" + 
			"        ch.crn_no,\n" + 
			"        i.item_name,\n" + 
			"        f.fr_name,\n" + 
			"        ch.fr_id,\n" + 
			"        coalesce((select\n" + 
			"            item_uom \n" + 
			"        from\n" + 
			"            m_item_sup \n" + 
			"        where\n" + 
			"            m_item_sup.item_id=i.id ),\n" + 
			"        '-') as item_uom     \n" + 
			"    from\n" + 
			"        t_credit_note_details cd,\n" + 
			"        t_credit_note_header ch,\n" + 
			"        t_grn_gvn g,\n" + 
			"        m_item i,\n" + 
			"        m_franchisee f      \n" + 
			"    where\n" + 
			"        ch.crn_date between :fromDate and :toDate          \n" + 
			"        and cd.crn_id=ch.crn_id          \n" + 
			"        and cd.grn_gvn_id=g.grn_gvn_id          \n" + 
			"        and cd.item_id=i.id          \n" + 
			"        and f.fr_id = ch.fr_id\n" + 
			"        and cd.cat_id!=5 and ch.fr_id=:frId\n" + 
			"union all \n" + 
			"select\n" + 
			"        cd.*,\n" + 
			"        ch.crn_date,\n" + 
			"        ch.crn_no,\n" + 
			"        i.sp_name,\n" + 
			"        f.fr_name,\n" + 
			"        ch.fr_id,\n" + 
			"        coalesce((select\n" + 
			"            sp_uom \n" + 
			"        from\n" + 
			"            m_spcake_sup \n" + 
			"        where\n" + 
			"            m_spcake_sup.sp_id=i.sp_id ),\n" + 
			"        '-') as item_uom     \n" + 
			"    from\n" + 
			"        t_credit_note_details cd,\n" + 
			"        t_credit_note_header ch,\n" + 
			"        t_grn_gvn g,\n" + 
			"        m_sp_cake i,\n" + 
			"        m_franchisee f      \n" + 
			"    where\n" + 
			"        ch.crn_date between :fromDate and :toDate          \n" + 
			"        and cd.crn_id=ch.crn_id          \n" + 
			"        and cd.grn_gvn_id=g.grn_gvn_id          \n" + 
			"        and cd.item_id=i.sp_id          \n" + 
			"        and f.fr_id = ch.fr_id\n" + 
			"        and cd.cat_id=5 and ch.fr_id=:frId) a\n" + 
			"  order by\n" + 
			"         fr_name,\n" + 
			"         crn_id \n" + 
			"     \n" + 
			" \n" + 
			"\n" + 
			"",nativeQuery=true)
	List<CreditNoteReport> creditNoteReportBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
			@Param("frId") int frId);

}
