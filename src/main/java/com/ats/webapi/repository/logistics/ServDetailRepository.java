package com.ats.webapi.repository.logistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.logistics.ServDetail;

public interface ServDetailRepository extends JpaRepository<ServDetail, Integer>{

	List<ServDetail> findByServIdAndDelStatus(int servId,int delStatus);

}
