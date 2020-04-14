package com.ats.webapi.repository.grngvnheader;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.grngvn.GrnGvnHeader;

public interface GrnGvnHeaderRepo extends JpaRepository<GrnGvnHeader, Integer> {
	
	GrnGvnHeader save(GrnGvnHeader header); //Insert Method
	
	List<GrnGvnHeader> findByfrIdAndGrngvnSrnoAndIsGrn(int frId,String grnGvnSrNo,int isGrn);//Front End getGrnHeader using grnSrNo
	
	@Query(value="SELECT * FROM  t_grn_gvn_header WHERE grngvn_date BETWEEN"
			+ ":fromDate AND :toDate AND fr_id IN (:frIdList) AND is_grn IN(:isGrn) ",nativeQuery=true)
	List<GrnGvnHeader> findGrnGvnHeader(@Param("fromDate")Date fromDate,@Param("toDate") Date toDate,@Param("frIdList")List<String> frIdList,@Param("isGrn")List<String> isGrn);
	
	
	GrnGvnHeader findByGrnGvnHeaderId(int headerId);
	
	
	/*@Query(value=" SELECT * FROM  t_grn_gvn_header WHERE grngvn_date BETWEEN"
			+ ":fromDate AND :toDate  AND is_grn=:isGrn AND t_grn_gvn_header.grngvn_status IN (:statusList) AND approved_datetime  BETWEEN "
			+ ":initTime AND :curTime",nativeQuery=true)
	List<GrnGvnHeader> findGrnGvnHeaderOnLoad(@Param("fromDate")Date fromDate,@Param("toDate") Date toDate,@Param("isGrn")int isGrn,@Param("statusList") List<String> statusList,
			@Param("initTime") String initTime,@Param("curTime") String curTime	);
	
	*/
	/*@Query(value=" SELECT" + 
			"        * " + 
			"    FROM" + 
			"        t_grn_gvn_header " + 
			"    WHERE" + 
			"        is_grn=:isGrn AND is_credit_note=0"  + 
			"        AND ((grngvn_date BETWEEN :fromDate AND :toDate" + 
		
			"        ) OR (t_grn_gvn_header.grngvn_status IN (:statusList) AND grngvn_date!=:fromDate))",nativeQuery=true)
	List<GrnGvnHeader> findGrnGvnHeaderOnLoad(@Param("fromDate")Date fromDate,@Param("toDate") Date toDate,@Param("isGrn")int isGrn,@Param("statusList") List<String> statusList);
	*/
	
	

	@Query(value="  SELECT * FROM t_grn_gvn_header WHERE is_grn IN(:isGrn) AND is_credit_note=0 AND t_grn_gvn_header.grngvn_status "
			+ "IN (:statusList) ",nativeQuery=true)
	List<GrnGvnHeader> findGrnGvnHeaderOnLoad(@Param("isGrn")List<String> isGrn,@Param("statusList") List<String> statusList);
	
	
	
	
	@Query(value=" SELECT * FROM  t_grn_gvn_header WHERE grngvn_date BETWEEN "
			+ ":fromDate AND :toDate AND is_grn IN (:isGrn) ",nativeQuery=true)
	List<GrnGvnHeader> findGrnGvnHeaderAllFr(@Param("fromDate")Date fromDate,@Param("toDate") Date toDate,@Param("isGrn")List<String> isGrn);

	@Transactional
	@Modifying
	@Query(value="update t_grn_gvn_header inner join t_grn_gvn on t_grn_gvn_header.grn_gvn_header_id = t_grn_gvn.grn_gvn_header_id \n" + 
			"   set t_grn_gvn_header.grngvn_date=:grnGvnDate ," + 
			"       t_grn_gvn.grn_gvn_date=:grnGvnDate" + 
			"  where t_grn_gvn_header.grn_gvn_header_id=:grnGvnHeaderId",nativeQuery=true)
	int updateGrnGvnDate(@Param("grnGvnHeaderId")int grnGvnHeaderId,@Param("grnGvnDate")String grnGvnDate);
	
}
