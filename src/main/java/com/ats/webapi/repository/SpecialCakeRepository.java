package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.SpecialCake;

public interface SpecialCakeRepository extends JpaRepository<SpecialCake, Integer>{

	public SpecialCake save(SpecialCake specialcake);
	//@Query(value="select * from m_sp_cake where m_sp_cake.sp_id=:spId",nativeQuery=true)
	public SpecialCake findOne(int spId);
	//@Query(value="select * from m_sp_cake where m_sp_cake.del_status=:delStatus",nativeQuery=true)
	public List<SpecialCake> findByDelStatus(int i);
	//@Query(value="select * from m_sp_cake where m_sp_cake.del_status=:delStatus order by sp_name Asc",nativeQuery=true)
	public List<SpecialCake> findByDelStatusOrderBySpNameAsc(int i);
	
	//@Query(value="select * from m_sp_cake where m_sp_cake.sp_id IN(:spId)",nativeQuery=true)
	public List<SpecialCake> findBySpIdIn(List<Integer> spId);
	
	//@Query(value="select * from m_sp_cake where m_sp_cake.del_status=:delStatus and m_sp_cake.sp_id IN(:itemids)",nativeQuery=true)
	public List<SpecialCake> findByDelStatusAndSpIdIn(int i, List<Integer> itemids);
	
	//@Query(value="select * from m_sp_cake where m_sp_cake.del_status=:delStatus order by sp_code asc",nativeQuery=true)
	public List<SpecialCake> findByDelStatusOrderBySpCodeAsc(int i);
	
	
	
	
	

}
