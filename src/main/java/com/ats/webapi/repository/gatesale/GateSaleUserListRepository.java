package com.ats.webapi.repository.gatesale;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.gatesale.GateSaleUser;
import com.ats.webapi.model.gatesale.GetGateSaleUser;

@Repository
public interface GateSaleUserListRepository extends JpaRepository<GetGateSaleUser, Integer>{

	@Query(value="Select u.user_id,u.user_name,u.user_type,u.mobile_number,u.token,u.email_id,u.password,u.del_status,u.emp_id,e.emp_name from m_gatesale_user u,m_emp e where u.emp_id=e.emp_id AND u.del_status=0",nativeQuery=true)
	List<GetGateSaleUser> findGateSaleUserByDelStatus();

}
