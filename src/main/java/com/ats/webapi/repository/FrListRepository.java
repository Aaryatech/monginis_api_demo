package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.FrList;

public interface FrListRepository extends JpaRepository<FrList, Integer> {

	@Query(value = "select @rownum \\:= @rownum + 1 AS id,f.fr_id,f.fr_name,r.abc_type from m_franchisee f ,m_franchise_sup s,m_fr_route r, (SELECT @rownum \\:=:frIndex) b where fr_route_id in "
			+ "(select route_id from m_fr_route where del_status=0 and abc_type in (:abcTypeList)) and f.del_status=0 and f.fr_route_id=r.route_id and f.fr_id=s.fr_id order by r.abc_type,r.seq_no,s.no_in_route", nativeQuery = true)
	List<FrList> findByAbcType(@Param("abcTypeList") List<Integer> abcTypeList, @Param("frIndex") int frIndex);

	@Query(value = "select @rownum \\:= @rownum + 1 AS id,f.fr_id,f.fr_name,r.abc_type from m_franchisee f,m_fr_route r,m_franchise_sup s, (SELECT @rownum \\:=:frIndex) b where fr_route_id in "
			+ "(select route_id from m_fr_route where del_status=0 and abc_type in (:abcTypeList)) and f.del_status=0 and f.fr_route_id=r.route_id and r.route_id=:routId and f.fr_id=s.fr_id order by r.abc_type,r.seq_no,s.no_in_route", nativeQuery = true)
	List<FrList> findByAbcType(@Param("abcTypeList") List<Integer> abcTypeList, @Param("frIndex") int frIndex,
			@Param("routId") int routId);

	@Query(value = "select f.fr_id from m_franchisee f,m_fr_route r where fr_route_id in"
			+ "(select route_id from m_fr_route where del_status=0 and abc_type in (:abcTypeList)) and f.del_status=0 and f.fr_route_id=r.route_id", nativeQuery = true)
	List<Integer> findByAbcTypeMin(@Param("abcTypeList") List<Integer> abcTypeList);

	@Query(value = "select f.fr_id from m_franchisee f,m_fr_route r  where fr_route_id in"
			+ "(select route_id from m_fr_route where del_status=0 and abc_type in (:abcTypeList)) and f.del_status=0 and f.fr_route_id=r.route_id and r.route_id=:routId", nativeQuery = true)
	List<Integer> findByAbcTypeMin(@Param("abcTypeList") List<Integer> abcTypeList, @Param("routId") int routId);

	// neha

	@Query(value = "select @rownum \\:= @rownum + 1 AS id,f.fr_id,f.fr_name,r.abc_type from m_franchisee f ,m_franchise_sup s,m_fr_route r, (SELECT @rownum \\:=:frIndex) b where fr_route_id in "
			+ "(select route_id from m_fr_route where del_status=0 and abc_type in (:abcTypeList)) and f.del_status=0 and f.fr_route_id=r.route_id and f.fr_id=s.fr_id AND s.pass5=1 order by r.abc_type,r.seq_no,s.no_in_route", nativeQuery = true)
	List<FrList> findByAbcTypeByPass5(@Param("abcTypeList") List<Integer> abcTypeList, @Param("frIndex") int frIndex);

	@Query(value = "select @rownum \\:= @rownum + 1 AS id,f.fr_id,f.fr_name,r.abc_type from m_franchisee f,m_fr_route r,m_franchise_sup s, (SELECT @rownum \\:=:frIndex) b where fr_route_id in "
			+ "(select route_id from m_fr_route where del_status=0 and abc_type in (:abcTypeList)) and f.del_status=0 and f.fr_route_id=r.route_id and r.route_id=:routId and f.fr_id=s.fr_id AND s.pass5=1 order by r.abc_type,r.seq_no,s.no_in_route", nativeQuery = true)
	List<FrList> findByAbcTypeByPass5(@Param("abcTypeList") List<Integer> abcTypeList, @Param("frIndex") int frIndex,
			@Param("routId") int routId);

}
