package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.rawmaterial.ItemSfHeader;

public interface ItemSfHeaderRawRepo  extends JpaRepository<ItemSfHeader, Integer>{
	
	List<ItemSfHeader>  findItemSfHeaderByDelStatus(int delStatus);

}
