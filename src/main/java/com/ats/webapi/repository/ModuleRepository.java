package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.MainModule;
import com.ats.webapi.model.SubModule;

@Repository
public interface ModuleRepository extends JpaRepository<MainModule, Integer>
{
    public List<MainModule> findAll();

	public List<MainModule> findByDelStatus(int i);





}
