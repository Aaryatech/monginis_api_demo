package com.ats.webapi.repository.storestock;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.stock.StoreStockHeader;

public interface StoreStockHeaderRepository extends JpaRepository<StoreStockHeader, Integer>{

	StoreStockHeader findByExInt1AndStoreStockStatus(int subCatId,int status);

}
