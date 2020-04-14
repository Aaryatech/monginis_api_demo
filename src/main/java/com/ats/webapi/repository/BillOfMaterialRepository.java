package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.bom.BillOfMaterialHeader;

public interface BillOfMaterialRepository extends JpaRepository<BillOfMaterialHeader, Integer>{
	
	BillOfMaterialHeader save(BillOfMaterialHeader billOfMaterialHeader);
	
	@Query(value="select * from t_req_bom where req_date BETWEEN :frmdate and :todate and del_status=0 "
			+ "and from_dept_id=:bmsDeptId or from_dept_id=:mixDeptId",nativeQuery=true)
	List<BillOfMaterialHeader> getAlllist(@Param("frmdate")String frmdate,@Param("todate")String todate, @Param("bmsDeptId")int bmsDeptId, @Param("mixDeptId")int mixDeptId );
	
	@Query(value=" select * from t_req_bom where  req_id=:reqId and del_status=0",nativeQuery=true)
	BillOfMaterialHeader getByReqstId(@Param("reqId")int reqId);

	//@Query(value=" select * from t_req_bom where del_status=0",nativeQuery=true)
	List<BillOfMaterialHeader> findBillOfMaterialHeaderByDelStatusOrderByReqIdDesc(int delStatus);

	
	@Query(value=" select * from t_req_bom where  req_date BETWEEN :frmdate and :todate and from_dept_id=:fromDept and to_dept_id=:toDept and del_status=0",nativeQuery=true)
	List<BillOfMaterialHeader> getAlllist(@Param("fromDept")int fromDept, @Param("toDept")int toDept, @Param("frmdate")String frmdate, @Param("todate")String todate);

	@Query(value=" select * from t_req_bom where  status IN(:status) and from_dept_id=:fromDept and to_dept_id=:toDept and del_status=0 order by req_id DESC",nativeQuery=true)
	List<BillOfMaterialHeader> getAlllist(@Param("fromDept")int fromDept, @Param("toDept")int toDept, @Param("status")List<String> status);

	
	@Transactional
	 @Modifying
	 @Query("UPDATE BillOfMaterialHeader SET status=4 WHERE production_id=:prodId and is_production=:isProduction")
	int updateStatusWhileCompletProd(@Param("prodId")int prodId,@Param("isProduction")int isProduction);
	
	/*@Query(value=" update BillOfMaterialHeader set status=3 and req_id=:reqId")
	int updatestatus(@Param("reqId")int reqId);*/

	
	
}
