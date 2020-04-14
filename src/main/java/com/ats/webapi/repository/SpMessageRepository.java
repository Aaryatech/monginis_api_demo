package com.ats.webapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SpMessage;

public interface SpMessageRepository extends JpaRepository<SpMessage, Integer>
{
	SpMessage save(SpMessage spmsg);

	List<SpMessage> findByDelStatus(int i);

	SpMessage findOne(int spMsgId);

	List<SpMessage> findByDelStatusOrderBySpMsgTextAsc(int i);

	List<SpMessage> findBySpMsgIdIn(List<Integer> spMsgId);
}
