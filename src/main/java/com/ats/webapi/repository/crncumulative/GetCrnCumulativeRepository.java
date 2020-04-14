package com.ats.webapi.repository.crncumulative;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.crncumulative.GetCrnCumulative;

@Repository
public interface GetCrnCumulativeRepository extends JpaRepository<GetCrnCumulative, Integer>{

	@Query(value="SELECT UUID() as id,ch.crn_date,ch.fr_id,SUM(ch.crn_taxable_amt) as crn_taxable_amt,SUM(ch.crn_total_tax) as crn_total_tax,SUM(ch.crn_grand_total) as crn_grand_total,SUM(ch.round_off) as round_off,GROUP_CONCAT(ch.crn_id) as crn_no,fr.fr_name,fr.fr_address,fr.fr_gst_no	FROM m_franchisee fr,t_credit_note_header ch WHERE ch.crn_date BETWEEN :fromDate  AND :toDate AND   ch.fr_id IN (:frIdList) AND  ch.fr_id=fr.fr_id group by ch.crn_date,ch.fr_id  order by ch.fr_id,ch.crn_date",nativeQuery=true)
	List<GetCrnCumulative> getCumulativeCrn(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("frIdList") List<String> frIdList);

}
