package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.DispatchStationItem;
import com.ats.webapi.model.tally.Franchisee;

public interface TallyFranchiseeRepository extends JpaRepository<Franchisee, Integer> {

	@Query(value = "SELECT\n" + "        f.fr_id as customer_id,\n" + "        f.fr_name,\n" + "        f.fr_address,\n"
			+ "        f.fr_city,\n" + "        f.fr_rate_cat,\n" + "        s.fr_state,\n" + "        f.fr_gst_no,\n"
			+ "        f.fr_code,\n" + "        s.fr_country,\n" + "        s.is_tally_sync \n" + "    FROM\n"
			+ "        m_franchisee f,\n" + "        m_franchise_sup s \n" + "    WHERE\n"
			+ "        f.fr_id=s.fr_id \n" + "        AND s.is_tally_sync=0 \n"
			+ "        AND f.del_status=0", nativeQuery = true)
	List<Franchisee> findByIsTallySync();

	@Query(value = "SELECT\n" + "   f.fr_id as customer_id,\n" + "	        f.fr_name, \n"
			+ "			        f.fr_address, \n" + "			      f.fr_city,\n" + "		       f.fr_rate_cat,\n"
			+ "			       s.fr_state, \n" + "		      f.fr_gst_no,\n" + "		      f.fr_code,\n"
			+ "		      s.fr_country,\n" + "		       s.is_tally_sync \n" + "			   FROM\n"
			+ "			       m_franchisee f,\n" + "			      m_franchise_sup s \n" + "		    WHERE\n"
			+ "			       f.fr_id=s.fr_id \n" + "			       AND f.fr_id IN(:frIdList)\n"
			+ "			       \n" + "			       AND f.del_status=0 " + "", nativeQuery = true)
	List<Franchisee> getFranchisee(@Param("frIdList") List<Integer> frIdList);

}
