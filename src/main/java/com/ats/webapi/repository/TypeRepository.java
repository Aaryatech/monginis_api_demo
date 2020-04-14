package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.MType;
@Repository
public interface TypeRepository extends JpaRepository<MType, Integer>{

	List<MType> findMTypeByDelStatusAndSubType(int i, int typeId);

}
