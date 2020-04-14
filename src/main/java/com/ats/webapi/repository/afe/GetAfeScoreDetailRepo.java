package com.ats.webapi.repository.afe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.afe.GetAfeScoreDetail;

public interface GetAfeScoreDetailRepo extends JpaRepository<GetAfeScoreDetail, Integer>{
	
	@Query(value=" SELECT d.*,q.question from t_afe_score_detail d,m_afe_question q WHERE "
			+ "d.afe_score_header_id=:scoreHeaderId AND d.que_id=q.que_id AND d.del_status=:delStatus" + 
			"",nativeQuery=true)

	List<GetAfeScoreDetail> getAfeScoreDetail(@Param("scoreHeaderId") int scoreHeaderId,@Param("delStatus") int delStatus);

}
