package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.communication.GetNotification;

@Repository
public interface GetNotificationRepository extends JpaRepository<GetNotification, Integer>{

	@Query(value="select\n" + 
			"  n.notification_id,\n" + 
			"  n.subject,\n" + 
			"  n.description,\n" + 
			"  n.photo,\n" + 
			"  n.date,\n" + 
			"  n.time,\n" + 
			"  n.is_closed,\n" + 
			"  n.user_id,u.usr_name as user_name from m_comm_notification n,m_user u where n.user_id=u.usr_id AND n.is_closed=:isClosed",nativeQuery=true)
	List<GetNotification> findByIsClosed(@Param("isClosed")int isClosed);

	@Query(value="select\n" + 
			"  n.notification_id,\n" + 
			"  n.subject,\n" + 
			"  n.description,\n" + 
			"  n.photo,\n" + 
			"  n.date,\n" + 
			"  n.time,\n" + 
			"  n.is_closed,\n" + 
			"  n.user_id,u.usr_name as user_name from m_comm_notification n,m_user u where n.user_id=u.usr_id AND n.is_closed=0 And n.notification_id>:notificationId",nativeQuery=true)
	List<GetNotification> findByNotificationId(@Param("notificationId")int notificationId);

}
