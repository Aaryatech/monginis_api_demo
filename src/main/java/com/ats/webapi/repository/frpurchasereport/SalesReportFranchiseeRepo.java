package com.ats.webapi.repository.frpurchasereport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.report.frpurchase.SalesReportFranchisee;

public interface SalesReportFranchiseeRepo extends JpaRepository<SalesReportFranchisee, Integer> {

	/*@Query(value = " SELECT\n" + 
			"         UUID() as id,\n" + 
			"        'RET' as type,\n" + 
			"        ch.crn_id as bill_no,\n" + 
			"        ch.crn_date as bill_date,\n" + 
			"        ch.crn_no as invoice_no,\n" + 
			"        ch.fr_id as fr_id,\n" + 
			"        ch.crn_taxable_amt as taxable_amt,\n" + 
			"        ch.crn_total_tax as total_tax,\n" + 
			"        ch.crn_grand_total as grand_total,\n" + 
			"        fr.fr_name as fr_name,\n" + 
			"        '--' as order_ref\n" + 
			"    FROM\n" + 
			"        m_franchisee fr,\n" + 
			"        t_credit_note_header ch\n" + 
			"    WHERE\n" + 
			"        ch.crn_date    BETWEEN :fromDate AND :toDate  and\n" + 
			"        ch.is_grn in(1)\n" + 
			"        AND fr.fr_id=ch.fr_id\n" + 
			" \n" + 
			"          UNION ALL\n" + 
			"       \n" + 
			"        SELECT\n" + 
			"         UUID() as id,\n" + 
			"        'VER' as type,\n" + 
			"        ch.crn_id as bill_no,\n" + 
			"        ch.crn_date as bill_date,\n" + 
			"        ch.crn_no as invoice_no,\n" + 
			"        ch.fr_id as fr_id,\n" + 
			"        ch.crn_taxable_amt as taxable_amt,\n" + 
			"        ch.crn_total_tax as total_tax,\n" + 
			"        ch.crn_grand_total as grand_total,\n" + 
			"        fr.fr_name as fr_name,\n" + 
			"        '--' as order_ref\n" + 
			"    FROM\n" + 
			"        m_franchisee fr,\n" + 
			"        t_credit_note_header ch\n" + 
			"    WHERE\n" + 
			"        ch.crn_date    BETWEEN :fromDate AND :toDate and\n" + 
			"        ch.is_grn in(0,2)\n" + 
			"        AND fr.fr_id=ch.fr_id\n" + 
			"UNION ALL\n" + 
			"SELECT\n" + 
			"        UUID() as id,\n" + 
			"        'INV' as type,\n" + 
			"        t_bill_header.bill_no,\n" + 
			"        t_bill_header.bill_date,\n" + 
			"        t_bill_header.invoice_no,\n" + 
			"        t_bill_header.fr_id,\n" + 
			"        sum(t_bill_detail.taxable_amt) as taxable_amt,\n" + 
			"        sum(t_bill_detail.total_tax) as total_tax,\n" + 
			"        SUM(t_bill_detail.grand_total) AS grand_total,\n" + 
			"         t_bill_header.party_name as fr_name,\n" + 
			"        '--' as order_ref\n" + 
			"    FROM\n" + 
			"        t_bill_header ,\n" + 
			"        t_bill_detail    \n" + 
			"    WHERE\n" + 
			"         t_bill_header.fr_id IN(:frIdList)  \n" + 
			"        AND t_bill_header.bill_date BETWEEN :fromDate AND :toDate     \n" + 
			"        AND t_bill_detail.bill_no=t_bill_header.bill_no                \n" + 
			"        AND t_bill_header.del_status=0\n" + 
			"        AND t_bill_detail.del_status=0    \n" + 
			"    GROUP BY\n" + 
			"        t_bill_header.bill_no", nativeQuery = true)*/

	@Query(value = "select\n" + 
			"        id,\n" + 
			"        type,\n" + 
			"        bill_no,\n" + 
			"        bill_date,\n" + 
			"        invoice_no,\n" + 
			"        fr_id,\n" + 
			"        round(coalesce(taxable_amt,\n" + 
			"        0),\n" + 
			"        2) as taxable_amt,\n" + 
			"        round(coalesce(total_tax,\n" + 
			"        0),\n" + 
			"        2) as total_tax,\n" + 
			"        round(coalesce(grand_total,\n" + 
			"        0),\n" + 
			"        2) as grand_total,\n" + 
			"        fr_name,\n" + 
			"        order_ref      \n" + 
			"    from\n" + 
			"        (SELECT\n" + 
			"            UUID() as id,\n" + 
			"            'RET' as type,\n" + 
			"            ch.crn_id as bill_no,\n" + 
			"            ch.crn_date as bill_date,\n" + 
			"            ch.crn_no as invoice_no,\n" + 
			"            ch.fr_id as fr_id,\n" + 
			"            ch.crn_taxable_amt as taxable_amt,\n" + 
			"            ch.crn_total_tax as total_tax,\n" + 
			"            ch.crn_grand_total as grand_total,\n" + 
			"            fr.fr_name as fr_name,\n" + 
			"            concat(ch.grn_gvn_sr_no_list,'(',ch.ex_varchar1,')') as order_ref                   \n" + 
			"        FROM\n" + 
			"            m_franchisee fr,\n" + 
			"            t_credit_note_header ch                   \n" + 
			"        WHERE\n" + 
			"            ch.crn_date    BETWEEN :fromDate  AND :toDate              \n" + 
			"            and  ch.is_grn in(\n" + 
			"                1\n" + 
			"            ) \n" + 
			"            and             ch.fr_id IN(:frIdList)                              \n" + 
			"            AND fr.fr_id=ch.fr_id                           \n" + 
			"        UNION\n" + 
			"        ALL      SELECT\n" + 
			"            UUID() as id,\n" + 
			"            'VER' as type,\n" + 
			"            ch.crn_id as bill_no,\n" + 
			"            ch.crn_date as bill_date,\n" + 
			"            ch.crn_no as invoice_no,\n" + 
			"            ch.fr_id as fr_id,\n" + 
			"            ch.crn_taxable_amt as taxable_amt,\n" + 
			"            ch.crn_total_tax as total_tax,\n" + 
			"            ch.crn_grand_total as grand_total,\n" + 
			"            fr.fr_name as fr_name,\n" + 
			"            concat(ch.grn_gvn_sr_no_list,'(',ch.ex_varchar1,')') as order_ref                   \n" + 
			"        FROM\n" + 
			"            m_franchisee fr,\n" + 
			"            t_credit_note_header ch                   \n" + 
			"        WHERE\n" + 
			"            ch.crn_date    BETWEEN :fromDate  AND :toDate                  \n" + 
			"            and  ch.is_grn in(\n" + 
			"                0,2\n" + 
			"            )               \n" + 
			"            and  ch.fr_id IN(:frIdList)                  \n" + 
			"            AND fr.fr_id=ch.fr_id               \n" + 
			"        UNION\n" + 
			"        ALL      SELECT\n" + 
			"            UUID() as id,\n" + 
			"            'INV' as type,\n" + 
			"            t_bill_header.bill_no,\n" + 
			"            t_bill_header.bill_date,\n" + 
			"            t_bill_header.invoice_no,\n" + 
			"            t_bill_header.fr_id,\n" + 
			"            sum(t_bill_detail.taxable_amt) as taxable_amt,\n" + 
			"            sum(t_bill_detail.total_tax) as total_tax,\n" + 
			"            SUM(t_bill_detail.grand_total) AS grand_total,\n" + 
			"            t_bill_header.party_name as fr_name,\n" + 
			"            '--' as order_ref                   \n" + 
			"        FROM\n" + 
			"            t_bill_header ,\n" + 
			"            t_bill_detail                       \n" + 
			"        WHERE\n" + 
			"            t_bill_header.fr_id IN(:frIdList)                                 \n" + 
			"            AND t_bill_header.bill_date BETWEEN :fromDate  AND :toDate                            \n" + 
			"            AND t_bill_detail.bill_no=t_bill_header.bill_no                                               \n" + 
			"            AND t_bill_header.del_status=0                               \n" + 
			"            AND t_bill_detail.del_status=0                       \n" + 
			"        GROUP BY\n" + 
			"            t_bill_header.bill_no     \n" + 
			"    ) a  \n" + 
			"order by\n" + 
			"    a.fr_name,\n" + 
			"    a.type,\n" + 
			"    a.bill_date ", nativeQuery = true)
	List<SalesReportFranchisee> getSaleReportBillwise(@Param("frIdList") List<String> frIdList,
			@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
