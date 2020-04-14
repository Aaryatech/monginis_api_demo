package com.ats.webapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.pettycash.SpCakeAdv;
@Repository
public interface SpCakeAdvRepo extends JpaRepository<SpCakeAdv, Integer> {

	@Query(value="select\n" + 
			"        1 as id,\n" + 
			"       \n" + 
			"        coalesce((select\n" + 
			"            SUM(sp_grand_total) \n" + 
			"        from\n" + 
			"            t_sp_cake \n" + 
			"        where\n" + 
			"            fr_id=:frId\n" + 
			"            and order_date=:date\n" + 
			"            and del_status=0),\n" + 
			"        0) as mrp,\n" + 
			"        coalesce((select\n" + 
			"            SUM(sp_advance) \n" + 
			"        from\n" + 
			"            t_sp_cake \n" + 
			"        where\n" + 
			"            fr_id=:frId\n" + 
			"            and order_date=:date\n" + 
			"            and del_status=0),\n" + 
			"        0) as advance \n" + 
			"    from\n" + 
			"        dual   \n" + 
			"    UNION   ALL  select\n" + 
			"        2 as id,\n" + 
			"       \n" + 
			"        \n" + 
			"        coalesce((select\n" + 
			"            SUM(sp_grand_total) \n" + 
			"        from\n" + 
			"            t_sp_cake \n" + 
			"        where\n" + 
			"            fr_id=:frId \n" + 
			"            and sp_delivery_date=:date\n" + 
			"            and del_status=0 and sp_book_for_mob_no!=0 ),\n" + 
			"        0) as mrp,\n" + 
			"        coalesce((select\n" + 
			"            SUM(sp_advance) \n" + 
			"        from\n" + 
			"            t_sp_cake \n" + 
			"        where\n" + 
			"            fr_id=:frId\n" + 
			"            and sp_delivery_date=:date\n" + 
			"            and del_status=0 and sp_book_for_mob_no!=0 ),\n" + 
			"        0) as advance \n" + 
			"    from\n" + 
			"        dual",nativeQuery=true)
	public List<SpCakeAdv>  getSpCakeAdv(@Param("frId") int frId, @Param("date") String date);
}
