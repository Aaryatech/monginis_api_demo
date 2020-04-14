package com.ats.webapi.repository.communication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.communication.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Notification n SET n.isClosed=1  WHERE n.notificationId=:notificationId")
	int deleteNotification(@Param("notificationId")int notificationId);

	List<Notification> findByIsClosed(int i);

}
