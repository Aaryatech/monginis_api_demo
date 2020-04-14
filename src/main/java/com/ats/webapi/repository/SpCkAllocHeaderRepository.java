package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.spprod.SpCkAllocHeader;

@Repository
public interface SpCkAllocHeaderRepository extends JpaRepository<SpCkAllocHeader, Integer>{

}
