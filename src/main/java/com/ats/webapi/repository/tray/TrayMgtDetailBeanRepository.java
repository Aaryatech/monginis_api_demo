package com.ats.webapi.repository.tray;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.TrayMgtDetailBean;

@Repository
public interface TrayMgtDetailBeanRepository extends JpaRepository<TrayMgtDetailBean, Integer> {

	TrayMgtDetailBean findByTranDetailId(int tranStatus3);

	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET tray_status=:status WHERE tranDetailId =:tranStatus1")
	int updateTrayStatus(@Param("tranStatus1") int tranStatus1, @Param("status") int status);

	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET tray_status=:status WHERE tranId =:tranStatus1")
	int updateTrayStatusByTranId(@Param("tranStatus1") int tranStatus1, @Param("status") int status);

	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET del_status=1 WHERE tranId =:tranId")
	int updateDelStatus(@Param("tranId") int tranId);

	@Query(value = "SELECT SUM(balance_big) as balance_big,SUM(balance_small) as balance_small,SUM(balance_lead) "
			+ "as balance_lead ,SUM(balance_extra) as balance_extra ,tran_detail_id,tran_id,fr_id,outtray_date,"
			+ "outtray_big,outtray_small,outtray_lead,outtray_extra,intray_date,intray_big,intray_small,intray_lead,"
			+ "intray_extra,intray_date1 ,intray_big1 ,intray_small1 ,intray_lead1 ,intray_extra1 ,intray_big2 ,intray_small2 ,"
			+ " intray_lead2,intray_extra2,price_big,price_small,price_lead,price_extra,grand_total,tray_status,"
			+ "deposit_is_used,del_status,intray_date2,qty_big,qty_small,qty_lead,qty_extra,gst_per,gst_rs,taxable_amt,"
			+ "tax_amt,is_same_day    FROM t_tray_mgt_detail WHERE fr_id=:frId AND tray_status=:status AND del_status=0 "
			+ " ", nativeQuery = true)
	List<TrayMgtDetailBean> getDetailBeanSum(@Param("frId") int frId, @Param("status") int status);

	@Query(value = "SELECT * FROM t_tray_mgt_detail WHERE fr_id=:frId AND tray_status=:status AND del_status=0"
			+ " ", nativeQuery = true)
	List<TrayMgtDetailBean> getDetailBean(@Param("frId") int frId, @Param("status") int status);

	// neha

	@Modifying
	@Transactional
	@Query("Update TrayMgtDetailBean  SET balance_big=:balanceBig,balance_small=:balanceSmall,balance_lead=:balanceLead,"
			+ "tray_status=:trayStatus WHERE tranDetailId =:tranDetailId")
	int updateTrayAndUpdateForApp(@Param("trayStatus") int trayStatus, @Param("tranDetailId") int tranDetailId,
			@Param("balanceBig") int balanceBig, @Param("balanceSmall") int balanceSmall,
			@Param("balanceLead") int balanceLead);
}
