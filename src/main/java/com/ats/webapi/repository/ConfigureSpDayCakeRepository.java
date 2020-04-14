package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.SpDayConfigure;

@Repository
public interface ConfigureSpDayCakeRepository extends JpaRepository<SpDayConfigure, Long>{

	SpDayConfigure save(SpDayConfigure spDayConfigure);

	SpDayConfigure findBySpdayId(int spdayId);

}
