package com.ats.webapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.Message;
import com.ats.webapi.model.Route;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> { 
	Message save(Message message);
	List<Message> findAll();
	Message findOne(int id);
	List<Message> findByDelStatus(int i);
	
@Query(value="SELECT * from t_message WHERE  :cDate BETWEEN msg_frdt AND msg_todt AND is_active=1 AND del_status=0 order by msg_id Desc "
			
			
			,nativeQuery=true)
	
		List<Message> findMessage(@Param("cDate")java.util.Date cDate);

        List<Message> findByMsgIdIn(List<Integer> id);

	

}
