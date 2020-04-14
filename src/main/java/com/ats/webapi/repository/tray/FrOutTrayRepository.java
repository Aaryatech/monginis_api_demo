package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.FrOutTrays;

@Repository
public interface FrOutTrayRepository extends JpaRepository<FrOutTrays, Integer>{

	@Query(value="select s.tray_type,t.type_name,coalesce(SUM(d.bill_qty/s.no_of_item_per_tray),0) as no_of_tray from t_bill_detail d ,m_item_sup s,m_tray_type t where bill_no In(select bill_no from t_bill_header where bill_date=:billDate And fr_id=:frId) And d.item_id=s.item_id And s.tray_type=t.type_id group by s.tray_type",nativeQuery=true)
	List<FrOutTrays> findOutTrays(@Param("frId") int frId,@Param("billDate")  String billDate);
/*select s.tray_type,coalesce(SUM(d.bill_qty/s.no_of_item_per_tray),0) as no_of_tray from t_bill_detail d ,m_item_sup s where bill_no In(select bill_no from t_bill_header where bill_date=:billDate And fr_id=:frId) And d.item_id=s.item_id group by s.tray_type*/
}
