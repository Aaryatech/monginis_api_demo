package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.model.tally.MaterialReceiptNote;

@Repository
public interface MaterialRecNoteRepository extends JpaRepository<MaterialRecNote, Integer>{

	MaterialRecNote save(MaterialRecNote materialRecNote);

	
	@Query(value=" select * from t_material_receipt_note where status IN (:status) AND del_status=0",nativeQuery=true)
	List<MaterialRecNote> getMaterialByStatus(@Param("status") List<String> status);

	MaterialRecNote findByMrnId(int mrnId);



	@Transactional
	@Modifying
	@Query(" UPDATE MaterialRecNote SET isTallySync=:isTallySync WHERE mrnId=:mrnId")
	int updateInward(@Param("mrnId")int mrnId,@Param("isTallySync") int isTallySync);

	

}
