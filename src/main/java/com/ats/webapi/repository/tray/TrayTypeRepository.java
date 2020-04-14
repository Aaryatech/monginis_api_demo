package com.ats.webapi.repository.tray;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tray.TrayType;

@Repository
public interface TrayTypeRepository extends JpaRepository<TrayType, Integer>{

	List<TrayType> findAllByDelStatus(int i);

}
