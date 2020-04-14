package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.FrTarget;

@Repository
public interface FrTargetRepository extends JpaRepository<FrTarget, Integer>{


	List<FrTarget> findFrTargetByFrIdAndFrTargetYearAndDelStatus(int frId, int year, int i);

}
