package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MainModule;
import com.ats.webapi.model.SubModule;

@Repository
public interface SubModuleRepository extends JpaRepository<SubModule, Integer>
{
   List<SubModule> findByModuleId(int mId);

	
}
