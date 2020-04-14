package com.ats.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.rawmaterial.GetUomAndTax;

public interface GetUomAndTaxRepository extends JpaRepository<GetUomAndTax, Integer>{

@Query(value="select r.rm_id, r.rm_uom_id, u.uom,t.tax_desc, r.tax_id from m_rm r, m_rm_uom u, m_rm_tax t where r.rm_id=:rmId AND t.tax_id=r.tax_id AND r.rm_uom_id=u.uom_id ",nativeQuery=true)
	GetUomAndTax getUomTax(@Param("rmId") int rmId);


@Query(value="select r.id as rm_id, s.uom_id as rm_uom_id,s.item_uom as uom,r.item_tax3 as tax_desc, (0) as tax_id from m_item r, m_item_sup s where r.id=:rmId AND s.item_id=r.id",nativeQuery=true)
GetUomAndTax getUomTaxForItem(@Param("rmId")int rmId);

}
