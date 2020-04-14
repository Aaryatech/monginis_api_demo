package com.ats.webapi.repository.dailysales;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.dailysales.SpDailySales;


public interface DailySpSalesRepository extends JpaRepository<SpDailySales, Integer>{

	@Query(value="select 1 as id,coalesce((select count(*) from t_sp_cake where fr_id=:frId and order_date=:date and del_status=0),0) as qty,coalesce((select SUM(sp_backend_rate) from t_sp_cake where fr_id=:frId and order_date=:date and del_status=0),0) as rate,coalesce((select SUM(sp_grand_total) from t_sp_cake where fr_id=:frId and order_date=:date and del_status=0),0) as mrp,coalesce((select SUM(sp_advance) from t_sp_cake where fr_id=:frId and order_date=:date and del_status=0),0) as advance from dual   UNION ALL  select 2 as id,coalesce((select count(*) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as qty,coalesce((select SUM(sp_backend_rate) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as rate,coalesce((select SUM(sp_grand_total) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as mrp,coalesce((select SUM(sp_advance) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as advance from dual",nativeQuery=true)
	List<SpDailySales> getSpSalesSpOrder(@Param("frId")int frId,@Param("date") String date);

	//@Query(value="select 2 as id,coalesce((select count(*) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as qty,coalesce((select SUM(sp_backend_rate) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as rate,coalesce((select SUM(sp_grand_total) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as mrp,coalesce((select SUM(sp_advance) from t_sp_cake where fr_id=:frId and sp_delivery_date=:date and del_status=0),0) as advance from dual",nativeQuery=true)
	//SpDailySales getSpSalesSpBill(@Param("frId")int frId,@Param("date") String date);

}
