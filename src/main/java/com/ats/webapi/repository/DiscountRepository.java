package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

	@Query(value="select d.disc_id,d.franch_id,d.item_id,d.disc_per,d.is_active,d.category_id,d.del_status,d.sub_category_id,d.var_1,d.var_2,c.cat_name as var_3,d.int_1,d.int_2,d.int_3 from m_fr_discount d,m_category c where d.del_status=:delStatus and c.cat_id=d.category_id ",nativeQuery=true)
	List<Discount> findAllByDelStatus(@Param("delStatus") int delStatus);

	/*@Transactional
	@Modifying
	@Query(value="update m_fr_discount set del_status = 1 where disc_id=:id",nativeQuery=true)
	Discount findByDiscIdAndDelStatus(@Param("id") int id);*/
	@Transactional
	@Modifying
	@Query(value="update m_fr_discount set del_status = 1 where disc_id=:id",nativeQuery=true)
	int deleteDiscId(@Param("id") int id);

	Discount findByDiscIdAndDelStatus(int id, int i);
	
	
/*	Discount findByDiscIdAndDelStatus(int id, int i);
	
	@Transactional
	@Modifying
	@Query(value="update m_fr_discount set del_status = 1 where disc_id=:id",nativeQuery=true)
	int deleteDiscId(@Param ("id")int id);
	
	
	@Transactional
	@Modifying
	@Query(value="update m_fr_discount set del_status = 1 where disc_id IN(:discId)",nativeQuery=true)
	int deleteDiscount(@Param ("discId") List<Integer> discId);
*/
}
