package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.GetSfData;

@Repository
public interface GetSfDataRepository extends JpaRepository<GetSfData, Integer>{

}
