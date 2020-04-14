package com.ats.webapi.repository.getcreditnote;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvn.GetCreditNoteHeaders;
import com.ats.webapi.model.grngvn.GrnGvnHeader;

public interface GetCreditNoteHeaderRepo extends JpaRepository<GetCreditNoteHeaders, Integer> {

	@Query(value = " SELECT ch.crn_id,ch.ex_int1,ch.grn_gvn_sr_no_list,ch.ex_varchar1,ch.crn_date,ch.fr_id,ch.crn_taxable_amt,ch.crn_total_tax,ch.crn_grand_total,ch.round_off,ch.is_tally_sync, "
			+ "ch.crn_no,ch.grn_gvn_sr_no_list,ch.is_deposited,fr.fr_name,ch.created_date_time,fr.fr_address,fr.fr_gst_no,fr.is_same_state,ch.is_grn "
			+ "FROM m_franchisee fr, t_credit_note_header ch " + "WHERE  ch.crn_date BETWEEN  :fromDate AND  :toDate "
			+ "AND fr.fr_id=ch.fr_id order by ch.fr_id ", nativeQuery = true)

	List<GetCreditNoteHeaders> getCreditHeadersAllFr(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = " SELECT ch.crn_id,ch.ex_int1,ch.grn_gvn_sr_no_list,ch.ex_varchar1,ch.crn_date,ch.fr_id,ch.crn_taxable_amt,ch.crn_total_tax,ch.crn_grand_total,ch.round_off,ch.is_tally_sync,"
			+ "ch.crn_no,ch.grn_gvn_sr_no_list,ch.is_deposited,fr.fr_name,ch.created_date_time,fr.fr_address,fr.fr_gst_no,fr.is_same_state,ch.is_grn "
			+ "FROM m_franchisee fr, t_credit_note_header ch "
			+ "WHERE ch.crn_date BETWEEN  :fromDate AND  :toDate AND "
			+ "  ch.fr_id IN (:frIdList) AND  ch.fr_id =fr.fr_id order by ch.fr_id", nativeQuery = true)

	List<GetCreditNoteHeaders> getCreditHeadersSelectedFr(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate, @Param("frIdList") List<String> frIdList);

	@Query(value = " SELECT ch.crn_id,ch.ex_int1,ch.grn_gvn_sr_no_list,ch.ex_varchar1,ch.crn_date,ch.fr_id,ch.crn_taxable_amt,ch.crn_total_tax,ch.crn_grand_total,ch.round_off,ch.is_tally_sync, "
			+ "ch.crn_no,ch.grn_gvn_sr_no_list,ch.is_deposited,fr.fr_name,ch.created_date_time,fr.fr_address,fr.fr_gst_no,fr.is_same_state,ch.is_grn "
			+ "FROM m_franchisee fr, t_credit_note_header ch " + "WHERE  ch.crn_id IN (:crnIdList) "
			+ "AND fr.fr_id=ch.fr_id order by ch.fr_id ", nativeQuery = true)

	List<GetCreditNoteHeaders> getCreditHeadersByHeaderIds(@Param("crnIdList") List<String> crnIdList);

	@Query(value = "SELECT ch.crn_id,ch.ex_int1,ch.grn_gvn_sr_no_list,ch.ex_varchar1,ch.crn_date,ch.fr_id,ch.crn_taxable_amt,ch.crn_total_tax,ch.crn_grand_total,ch.round_off,ch.is_tally_sync,  \n"
			+ "		ch.crn_no,ch.grn_gvn_sr_no_list,ch.is_deposited,fr.fr_name,ch.created_date_time,fr.fr_address,fr.fr_gst_no,fr.is_same_state,ch.is_grn \n"
			+ "			FROM m_franchisee fr, t_credit_note_header ch \n"
			+ "			WHERE 	FIND_IN_SET(ch.crn_no, (select credit_note_id from t_grn_gvn_header where grn_gvn_header_id=:grnGvnHeaderId)  )\n"
			+ "			AND fr.fr_id=ch.fr_id order by ch.fr_id", nativeQuery = true)
	List<GetCreditNoteHeaders> getCrnHeadersByGrnGvnHeaderId(@Param("grnGvnHeaderId") int grnGvnHeaderId);

	@Query(value = " SELECT ch.crn_id,ch.ex_int1,ch.grn_gvn_sr_no_list,ch.ex_varchar1,ch.crn_date,ch.fr_id,ch.crn_taxable_amt,ch.crn_total_tax,ch.crn_grand_total,ch.round_off,ch.is_tally_sync, "
			+ "ch.crn_no,ch.grn_gvn_sr_no_list,ch.is_deposited,fr.fr_name,ch.created_date_time,fr.fr_address,fr.fr_gst_no,fr.is_same_state,ch.is_grn "
			+ "FROM m_franchisee fr, t_credit_note_header ch "
			+ "WHERE  ch.crn_date BETWEEN  :fromDate AND  :toDate  AND ch.is_grn=:isGrn "
			+ "AND fr.fr_id=ch.fr_id order by ch.fr_id ", nativeQuery = true)

	List<GetCreditNoteHeaders> getCreditHeadersAllFrIsGRN(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate, @Param("isGrn") int isGrn);

	@Query(value = " SELECT ch.crn_id,ch.ex_int1,ch.grn_gvn_sr_no_list,ch.ex_varchar1,ch.crn_date,ch.fr_id,ch.crn_taxable_amt,ch.crn_total_tax,ch.crn_grand_total,ch.round_off,ch.is_tally_sync,"
			+ "ch.crn_no,ch.grn_gvn_sr_no_list,ch.is_deposited,fr.fr_name,ch.created_date_time,fr.fr_address,fr.fr_gst_no,fr.is_same_state,ch.is_grn "
			+ "FROM m_franchisee fr, t_credit_note_header ch "
			+ "WHERE ch.crn_date BETWEEN  :fromDate AND  :toDate AND ch.is_grn=:isGrn AND "
			+ "  ch.fr_id IN (:frIdList) AND  ch.fr_id =fr.fr_id order by ch.fr_id", nativeQuery = true)

	List<GetCreditNoteHeaders> getCreditHeadersSelectedFrIsGrn(@Param("fromDate") Date fromDate,
			@Param("toDate") Date toDate, @Param("frIdList") List<String> frIdList, @Param("isGrn") int isGrn);

	/*
	 * @Query(
	 * value="SELECT ch.crn_id,ch.ex_int1,ch.grn_gvn_sr_no_list,ch.ex_varchar1,ch.crn_date,ch.fr_id,ch.crn_taxable_amt,ch.crn_total_tax,ch.crn_grand_total,ch.round_off,ch.is_tally_sync,"
	 * +
	 * "			ch.crn_no,ch.grn_gvn_sr_no_list,ch.is_deposited,fr.fr_name,ch.created_date_time,fr.fr_address,fr.fr_gst_no,fr.is_same_state,ch.is_grn "
	 * + "			FROM m_franchisee fr, t_credit_note_header ch " +
	 * "			WHERE  ch.crn_date BETWEEN  :fromDate AND  :toDate " +
	 * "			AND fr.fr_id=ch.fr_id order by ch.fr_id ",nativeQuery=true)
	 * List<GetCreditNoteHeaders>
	 * getCumulativeCreditHeadersAllFr(@Param("fromDate")Date fDate,@Param("tDate")
	 * Date tDate);
	 */

}
