package com.ats.webapi.repository.tally;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.tally.TallyItem;

@Repository
public interface TallyItemRepository extends JpaRepository<TallyItem, Long>{

	@Query(value="SELECT\n" + 
			"        i.id,\n" + 
			"        i.item_name,\n" + 
			"        i.del_status,\n" + 
			"        c.cat_name AS item_group,\n" + 
			"        s.sub_cat_name AS sub_group ,\n" + 
			"        i.item_grp3,\n" + 
			"        i.item_tax1,\n" + 
			"        i.item_tax2,\n" + 
			"        i.item_tax3,\n" + 
			"        i.item_rate1,\n" + 
			"        i.item_rate2,\n" + 
			"        i.item_rate3,\n" + 
			"        sup.item_hsncd,\n" + 
			"        sup.item_cess,\n" + 
			"        sup.item_uom,\n" + 
			"        i.item_mrp1,\n" + 
			"        i.item_mrp2,\n" + 
			"        i.item_mrp3,\n" + 
			"        i.item_id as item_code\n" + 
			"    from\n" + 
			"        m_item i,\n" + 
			"        m_category c ,\n" + 
			"        m_cat_sub s ,\n" + 
			"        m_item_sup sup      \n" + 
			"    where\n" + 
			"        i.id=sup.item_id          \n" + 
			"        AND i.item_grp1=c.cat_id          \n" + 
			"        AND i.item_grp2=s.sub_cat_id          \n" + 
			"        AND sup.is_tally_sync=0          \n" + 
			"        AND i.del_status=0",nativeQuery=true)
	List<TallyItem> findByIsTallySync();
}
