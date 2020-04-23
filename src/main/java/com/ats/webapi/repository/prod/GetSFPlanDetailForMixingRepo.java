package com.ats.webapi.repository.prod;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.prod.mixing.GetSFPlanDetailForMixing;

//New Repo Sachin
//All new Pune copy Sachin 23-04
public interface GetSFPlanDetailForMixingRepo extends JpaRepository<GetSFPlanDetailForMixing, Integer> {

	

	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN  " + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total,m_item_sf_detail.sf_id, m_item_sf_header.mul_factor  from m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail,m_item_sf_header,m_item_sf_detail "
			+ " where  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND m_item_sf_header.sf_id=m_item_sf_detail.sf_id AND  "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND m_item_detail.rm_type=2 AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	
	
	//  moved to other repo: ProdMixingReqP1Repo repository.prod
	*/
	// 2nd Query by Sumit Sir 30  JAn 2018 for Prod to mixing req
	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.item_id, m_item_detail.rm_name, "
			+ "m_item_detail.rm_type, t_production_plan_detail.plan_qty, t_production_plan_detail.order_qty,"
			+ "m_item_detail.rm_id, m_item_detail.no_pieces_per_item, m_item_detail.rm_qty,"
			+ "SUM((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)as total,m_rm_uom.uom, "
			+ "coalesce((Select m_item_sf_header.mul_factor From m_item_sf_header where m_item_sf_header.sf_id=m_item_detail.rm_id),0) "
			+ "FROM m_item_detail, t_production_plan_header, t_production_plan_detail,m_rm_uom "
			+ "WHERE t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId AND m_rm_uom.uom_id=m_item_detail.rm_uom_id and m_item_detail.rm_type=2"
			+ " GROUP BY m_item_detail.rm_id " + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSFAndPlanDetailForMixing(@Param("headerId") int headerId);
	*/
	
	

	//same Bean Used for Bom and Mixing
	
	
	
	
	/*@Query(value=" SELECT m_item_detail.item_detail_id, m_item_detail.rm_id,m_item_detail.rm_qty,m_item_detail.no_pieces_per_item,"
			+ "m_item_detail.item_id,m_item_detail.rm_name,"
			+ "m_item_detail.rm_type,m_rm_uom.uom ,t_production_plan_detail.plan_qty,t_production_plan_detail.order_qty," + 
			"CASE WHEN t_production_plan_header.is_planned=1 THEN  " + 
			"sum((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "ELSE " + 
			"sum((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item) "
			+ "END " + 
			" AS total,m_item_sf_detail.sf_id, m_item_sf_header.mul_factor  FROM m_item_detail,t_production_plan_header,m_rm_uom,t_production_plan_detail,m_item_sf_detail,m_item_sf_header "
			+ "WHERE  m_rm_uom.uom_id=m_item_detail.rm_uom_id AND m_item_sf_header.sf_id=m_item_sf_detail.sf_id AND "
			+ "t_production_plan_detail.item_id=m_item_detail.item_id AND "
			+ "t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id AND "
			+ "t_production_plan_header.production_header_id=:headerId GROUP BY rm_id" + 
			"",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId);
	*/
	// NEW query FOR bom fROM pROD SUMIT sIR 30 jan 2018
	@Query(value="          select    " + 
			"          a.item_detail_id, " + 
			"          a.item_id, " + 
			"          a.rm_name, " + 
			"          a.rm_type, " + 
			"          a.plan_qty, " + 
			"          a.order_qty, " + 
			"          a.rm_id, " + 
			"          a.no_pieces_per_item, " + 
			"          a.rm_qty, " + 
			"          a.uom, " + 
			"        coalesce((b.single_cut),0) as single_cut, " + 
			"        coalesce((c.double_cut),0) as double_cut,  coalesce((a.total),0) as total" + 
			"        from( " + 
			"       SELECT " + 
			"         m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_name, " + 
			"        m_item_detail.rm_type, " + 
			"        SUM(t_production_plan_detail.plan_qty) as plan_qty, " + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty, " + 
			"        m_item_detail.rm_id, " + 
			"        m_item_detail.no_pieces_per_item, " + 
			"        m_item_detail.rm_qty, " + 
			"        m_rm_uom.uom  ,"
			+ " CASE  " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))     " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))  " + 
			"        END as total" + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup     " + 
			"    WHERE " + 
			"        m_item_detail.del_status=0  " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  " + 
			"        AND m_item_sf_header.sf_id=m_item_detail.rm_id  " + 
			"        and m_item_sup.item_id=m_item_detail.item_id  " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id  " + 
			"        AND  m_item_sf_header.int_1=:deptId " + 
			"        and m_item_detail.rm_type=2  " + 
			"        and    t_production_plan_header.production_header_id =:headerId " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id  " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id) a LEFT JOIN  " + 
			"         " + 
			"        ( " + 
			"      SELECT " + 
			"               m_item_detail.rm_id, " + 
			"            CASE  " + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))     " + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))  " + 
			"            END      " + 
			"         as single_cut " + 
			"       " + 
			"       " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup     " + 
			"    WHERE " + 
			"        m_item_detail.del_status=0  " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  " + 
			"        AND m_item_sf_header.sf_id=m_item_detail.rm_id  " + 
			"        and m_item_sup.item_id=m_item_detail.item_id  " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id  " + 
			"        AND  m_item_sf_header.int_1=:deptId " + 
			"        and m_item_detail.rm_type=2  and m_item_sup.cut_section=1 " + 
			"        and    t_production_plan_header.production_header_id =:headerId " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id  " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id) b ON b.rm_id=a.rm_id  " + 
			"        LEFT JOIN " + 
			"        ( " + 
			"         " + 
			"      SELECT " + 
			"               m_item_detail.rm_id, " + 
			"            CASE  " + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))     " + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))  " + 
			"            END      " + 
			"         as double_cut " + 
			"       " + 
			"       " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup     " + 
			"    WHERE " + 
			"        m_item_detail.del_status=0  " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id  " + 
			"        AND m_item_sf_header.sf_id=m_item_detail.rm_id  " + 
			"        and m_item_sup.item_id=m_item_detail.item_id  " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id  " + 
			"        AND  m_item_sf_header.int_1=:deptId " + 
			"        and m_item_detail.rm_type=2  and m_item_sup.cut_section=2 " + 
			"        and    t_production_plan_header.production_header_id=:headerId " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id  " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id  ) c on c.rm_id=a.rm_id",nativeQuery=true)
	
	List<GetSFPlanDetailForMixing> getSfPlanDetailForBom(@Param("headerId") int headerId,@Param("deptId") int deptId);

	@Query(value="   select " + 
			"        a.item_detail_id, " + 
			"        a.item_id, " + 
			"        a.rm_name, " + 
			"        a.rm_type, " + 
			"        a.plan_qty, " + 
			"        a.order_qty, " + 
			"        a.rm_id, " + 
			"        a.no_pieces_per_item, " + 
			"        a.rm_qty, " + 
			"        a.uom, " + 
			"        coalesce((b.single_cut), " + 
			"        0) as single_cut, " + 
			"        coalesce((c.double_cut), " + 
			"        0) as double_cut, " + 
			"        coalesce((a.total), " + 
			"        0) as total         " + 
			"    from " + 
			"        (        SELECT " + 
			"            m_item_detail.item_detail_id, " + 
			"            m_item_detail.item_id, " + 
			"            m_item_detail.rm_name, " + 
			"            m_item_detail.rm_type, " + 
			"            SUM(t_production_plan_detail.plan_qty) as plan_qty, " + 
			"            SUM(t_production_plan_detail.order_qty) as order_qty, " + 
			"            m_item_detail.rm_id, " + 
			"            m_item_detail.no_pieces_per_item, " + 
			"            m_item_detail.rm_qty, " + 
			"            m_rm_uom.uom  , " + 
			"            CASE               " + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))                  " + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))           " + 
			"            END as total     " + 
			"        FROM " + 
			"            m_item_detail, " + 
			"            t_production_plan_header, " + 
			"            t_production_plan_detail, " + 
			"            m_rm_uom, " + 
			"            m_rm, " + 
			"            m_item_sup          " + 
			"        WHERE " + 
			"            m_item_detail.del_status=0           " + 
			"            and  t_production_plan_detail.item_id=m_item_detail.item_id           " + 
			"            AND ( m_rm.rm_id=m_item_detail.rm_id)   " + 
			"            and m_item_sup.item_id=m_item_detail.item_id           " + 
			"            and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"            AND  (m_rm.rm_op_rate=:deptId)        " + 
			"            and m_item_detail.rm_type=1           " + 
			"            and    t_production_plan_header.production_header_id=:headerId      " + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id       " + 
			"        GROUP by " + 
			"            m_item_detail.rm_id) a  " + 
			"    LEFT JOIN " + 
			"        ( " + 
			"            SELECT " + 
			"                m_item_detail.rm_id, " + 
			"                CASE                   " + 
			"                    WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))                      " + 
			"                    ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))               " + 
			"                END               as single_cut                    " + 
			"            FROM " + 
			"                m_item_detail, " + 
			"                t_production_plan_header, " + 
			"                t_production_plan_detail, " + 
			"                m_rm_uom, " + 
			"                 m_rm, " + 
			"                m_item_sup          " + 
			"            WHERE " + 
			"                m_item_detail.del_status=0           " + 
			"                and  t_production_plan_detail.item_id=m_item_detail.item_id           " + 
			"                AND ( m_rm.rm_id=m_item_detail.rm_id)          " + 
			"                and m_item_sup.item_id=m_item_detail.item_id           " + 
			"                and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"                AND  ( m_rm.rm_op_rate=:deptId)         " + 
			"                and m_item_detail.rm_type=1   " + 
			"                and m_item_sup.cut_section=1          " + 
			"                and    t_production_plan_header.production_header_id=:headerId      " + 
			"                AND m_rm_uom.uom_id=m_item_detail.rm_uom_id       " + 
			"            GROUP by " + 
			"                m_item_detail.rm_id " + 
			"        ) b  " + 
			"            ON b.rm_id=a.rm_id           " + 
			"    LEFT JOIN " + 
			"        ( " + 
			"            SELECT " + 
			"                m_item_detail.rm_id, " + 
			"                CASE                   " + 
			"                    WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))                      " + 
			"                    ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item))               " + 
			"                END               as double_cut                    " + 
			"            FROM " + 
			"                m_item_detail, " + 
			"                t_production_plan_header, " + 
			"                t_production_plan_detail, " + 
			"                m_rm_uom, " + 
			"                m_rm, " + 
			"                m_item_sup          " + 
			"            WHERE " + 
			"                m_item_detail.del_status=0           " + 
			"                and  t_production_plan_detail.item_id=m_item_detail.item_id           " + 
			"                AND (m_rm.rm_id=m_item_detail.rm_id)                 " + 
			"                and m_item_sup.item_id=m_item_detail.item_id           " + 
			"                and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"                AND (  m_rm.rm_op_rate=:deptId)              " + 
			"                and m_item_detail.rm_type=1   " + 
			"                and m_item_sup.cut_section=2          " + 
			"                and    t_production_plan_header.production_header_id=:headerId      " + 
			"                AND m_rm_uom.uom_id=m_item_detail.rm_uom_id       " + 
			"            GROUP by " + 
			"                m_item_detail.rm_id   " + 
			"        ) c  " + 
			"            on c.rm_id=a.rm_id " + 
			"",nativeQuery=true)
	List<GetSFPlanDetailForMixing> getSfPlanDetailForStoreBom(@Param("headerId") int headerId,@Param("deptId") int deptId);

	
	//Sac new for Temp prod Api 
	
	@Query(value=" select  s.item_detail_id, " + 
			"  s.item_id, " + 
			"  s.rm_id, " + 
			"  s.rm_name, " + 
			"  s.rm_type, " + 
			"  s.rm_qty, " + 
			"  s.single_cut, " + 
			"    coalesce(c.double_cut,0)as double_cut, " + 
			"  s.total, " + 
			"  s.uom, " + 
			"  s.plan_qty, " + 
			"  s.order_qty, " + 
			"  s.no_pieces_per_item " + 
			"  from ( SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_id, " + 
			"        m_item_detail.rm_name, " + 
			"        m_item_detail.rm_type, " + 
			"        m_item_detail.rm_qty, " + 
			"        m_item_sf_header.mul_factor as single_cut, " + 
			"        0 as double_cut, " + 
			"        CASE               " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                  " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)           " + 
			"        END as total, " + 
			"        m_rm_uom.uom, " + 
			"          SUM(t_production_plan_detail.plan_qty) as plan_qty, " + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty, " + 
			"        m_item_detail.no_pieces_per_item " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup          " + 
			"    WHERE " + 
			"        m_item_detail.del_status=0  " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and m_item_sup.item_id=m_item_detail.item_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId        " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id       " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id " + 
			"         " + 
			"        UNION ALL " + 
			"    select l.sf_did as item_detail_id,l.sf_id as item_id,l.rm_id,l.rm_name,l.rm_type,SUM(l.rm_qty) as rm_qty,1 as single_cut,SUM(l.rm_weight) as double_cut,SUM(round(((m.total*l.rm_weight_per)/100),0)) as total,l.rm_unit,0 as plan_qty,0 as order_qty,0 as no_pieces_per_item " + 
			" from  ( " + 
			"        select a.sf_did,a.sf_id,a.rm_id,a.rm_name,a.rm_type,a.rm_qty,a.rm_weight,a.del_status,a.rm_unit,round((a.rm_weight/b.rm_weight),2) as rm_weight_per " + 
			"from " + 
			"(SELECT       m_item_sf_detail.sf_did, " + 
			"    m_item_sf_detail.sf_id, " + 
			"       m_item_sf_detail.rm_id, " + 
			"  concat(m_item_sf_detail.rm_name) as rm_name, " + 
			"       m_item_sf_detail.rm_type, " + 
			"       m_item_sf_detail.rm_qty, " + 
			"       m_item_sf_detail.rm_weight, " + 
			"       m_item_sf_detail.del_status, " + 
			"       m_rm_uom.uom as rm_unit " + 
			"   FROM " + 
			"       m_item_sf_detail,m_rm_uom " + 
			"   WHERE " + 
			"       m_item_sf_detail.sf_id in (SELECT " + 
			"        m_item_detail.rm_id " + 
			"          FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    group by rm_id " + 
			"    ) and m_item_sf_detail.del_status=0  and m_item_sf_detail.rm_type=2 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit) a " + 
			"       LEFT JOIN " + 
			"       ( " + 
			"        " + 
			"SELECT       " + 
			"    m_item_sf_detail.sf_id, " + 
			"      " + 
			"       SUM(m_item_sf_detail.rm_weight)/100 as rm_weight " + 
			"   FROM " + 
			"       m_item_sf_detail " + 
			"   WHERE " + 
			"       m_item_sf_detail.sf_id in (SELECT " + 
			"        m_item_detail.rm_id " + 
			"          FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    group by rm_id " + 
			"    ) and m_item_sf_detail.del_status=0  group by  m_item_sf_detail.sf_id " + 
			"       ) b ON b.sf_id=a.sf_id " + 
			"        ) l " + 
			"        LEFT JOIN " + 
			"        " + 
			"        (SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_type, " + 
			"        m_item_detail.rm_id, " + 
			"        CASE               " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                 " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)           " + 
			"        END as total    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id) m on l.sf_id=m.rm_id group by l.rm_id ) s LEFT JOIN " + 
			"                (  select DISTINCT d.sf_id,1 as double_cut from t_mixing_detail d where   d.mixing_id IN( select  h.mix_id from t_mixing_header h where  h.Production_id=:headerId  order by h.mix_id DESC) ) c  ON s.rm_id=c.sf_id where FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='sf_cream_item' and del_status=0))",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForCp(@Param("headerId") int headerId,@Param("deptId") int deptId);

	
	@Query(value="select " + 
			"        s.item_detail_id, " + 
			"        s.item_id, " + 
			"        s.rm_id, " + 
			"        s.rm_name, " + 
			"        s.rm_type, " + 
			"        s.rm_qty, " + 
			"        s.single_cut, " + 
			"        s.double_cut, " + 
			"        s.total, " + 
			"        s.uom, " + 
			"        s.plan_qty, " + 
			"        s.order_qty, " + 
			"        s.no_pieces_per_item   " + 
			"    from " + 
			"        ( SELECT " + 
			"            m_item_detail.item_detail_id, " + 
			"            m_item_detail.item_id, " + 
			"            m_item_detail.rm_id, " + 
			"            m_item_detail.rm_name, " + 
			"            m_item_detail.rm_type, " + 
			"            m_item_detail.rm_qty, " + 
			"            m_item_sf_header.mul_factor as single_cut, " + 
			"            0 as double_cut, " + 
			"            SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                               " + 
			"             as total, " + 
			"            m_rm_uom.uom, " + 
			"            SUM(t_temp_prod.rm_qty) as plan_qty, " + 
			"            SUM(t_temp_prod.rm_qty) as order_qty, " + 
			"            m_item_detail.no_pieces_per_item     " + 
			"        FROM " + 
			"            m_item_detail, " + 
			" " + 
			"           t_temp_prod, " + 
			"            m_rm_uom, " + 
			"            m_item_sf_header, " + 
			"            m_item_sup               " + 
			"        WHERE " + 
			"            m_item_detail.del_status=0           " + 
			"            and          t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"            and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			"            and m_item_sup.item_id=m_item_detail.item_id                   " + 
			" " + 
			"            AND  m_item_sf_header.int_1=:deptId " + 
			"            and m_item_detail.rm_type=2                   " + 
			" " + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id           " + 
			"        GROUP by " + 
			"            m_item_detail.rm_id                   " + 
			"        UNION " + 
			"        ALL     select " + 
			"            l.sf_did as item_detail_id, " + 
			"            l.sf_id as item_id, " + 
			"            l.rm_id, " + 
			"            l.rm_name, " + 
			"            l.rm_type, " + 
			"            SUM(l.rm_qty) as rm_qty, " + 
			"            1 as single_cut, " + 
			"            SUM(l.rm_weight) as double_cut, " + 
			"            SUM(round(((m.total*l.rm_weight_per)/100), " + 
			"            0)) as total, " + 
			"            l.rm_unit, " + 
			"            0 as plan_qty, " + 
			"            0 as order_qty, " + 
			"            0 as no_pieces_per_item   " + 
			"        from " + 
			"            (         select " + 
			"                a.sf_did, " + 
			"                a.sf_id, " + 
			"                a.rm_id, " + 
			"                a.rm_name, " + 
			"                a.rm_type, " + 
			"                a.rm_qty, " + 
			"                a.rm_weight, " + 
			"                a.del_status, " + 
			"                a.rm_unit, " + 
			"                round((a.rm_weight/b.rm_weight), " + 
			"                2) as rm_weight_per " + 
			"            from " + 
			"                (SELECT " + 
			"                    m_item_sf_detail.sf_did, " + 
			"                    m_item_sf_detail.sf_id, " + 
			"                    m_item_sf_detail.rm_id, " + 
			"                    concat(m_item_sf_detail.rm_name) as rm_name, " + 
			"                    m_item_sf_detail.rm_type, " + 
			"                    m_item_sf_detail.rm_qty, " + 
			"                    m_item_sf_detail.rm_weight, " + 
			"                    m_item_sf_detail.del_status, " + 
			"                    m_rm_uom.uom as rm_unit     " + 
			"                FROM " + 
			"                    m_item_sf_detail, " + 
			"                    m_rm_uom     " + 
			"                WHERE " + 
			"                    m_item_sf_detail.sf_id in ( " + 
			"                        SELECT " + 
			"                            m_item_detail.rm_id           " + 
			"                        FROM " + 
			"                            m_item_detail, " + 
			" " + 
			"                          t_temp_prod," + 
			"                            m_item_sf_header     " + 
			"                        WHERE " + 
			"                            m_item_detail.del_status=0         " + 
			"                            and  t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"                            and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			" " + 
			"                            AND  m_item_sf_header.int_1=:deptId           " + 
			"                            and m_item_detail.rm_type=2                   " + 
			" " + 
			"                        group by " + 
			"                            rm_id     " + 
			"                    ) " + 
			"                    and m_item_sf_detail.del_status=0   " + 
			"                    and m_item_sf_detail.rm_type=2 " + 
			"                    and m_rm_uom.uom_id=m_item_sf_detail.rm_unit " + 
			"                ) a         " + 
			"            LEFT JOIN " + 
			"                ( " + 
			"                    SELECT " + 
			"                        m_item_sf_detail.sf_id, " + 
			"                        SUM(m_item_sf_detail.rm_weight)/100 as rm_weight     " + 
			"                    FROM " + 
			"                        m_item_sf_detail     " + 
			"                    WHERE " + 
			"                        m_item_sf_detail.sf_id in ( " + 
			"                            SELECT " + 
			"                                m_item_detail.rm_id           " + 
			"                            FROM " + 
			"                                m_item_detail, " + 
			" " + 
			"                               t_temp_prod, " + 
			"                                m_item_sf_header     " + 
			"                            WHERE " + 
			"                                m_item_detail.del_status=0         " + 
			"                                and  t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"                                and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			" " + 
			"                                AND  m_item_sf_header.int_1=:deptId            " + 
			"                                and m_item_detail.rm_type=2                   " + 
			" " + 
			"                            group by " + 
			"                                rm_id     " + 
			"                        ) " + 
			"                        and m_item_sf_detail.del_status=0   " + 
			"                    group by " + 
			"                        m_item_sf_detail.sf_id        ) b " + 
			"                            ON b.sf_id=a.sf_id         " + 
			"                    ) l         " + 
			"            LEFT JOIN " + 
			"                ( " + 
			"                    SELECT " + 
			"                        m_item_detail.item_detail_id, " + 
			"                        m_item_detail.item_id, " + 
			"                        m_item_detail.rm_type, " + 
			"                        m_item_detail.rm_id, " + 
			"                       SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                             " + 
			"                             as total     " + 
			"                    FROM " + 
			"                        m_item_detail, " + 
			" " + 
			"                     t_temp_prod, " + 
			"                        m_item_sf_header     " + 
			"                    WHERE " + 
			"                        m_item_detail.del_status=0         " + 
			"                        and t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"                        and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			" " + 
			"                        AND  m_item_sf_header.int_1=:deptId          " + 
			"                        and m_item_detail.rm_type=2                   " + 
			" " + 
			"                    GROUP by " + 
			"                        m_item_detail.rm_id " + 
			"                ) m " + 
			"                    on l.sf_id=m.rm_id " + 
			"            group by " + 
			"                l.rm_id ) s " + 
			"            where " + 
			"                !FIND_IN_SET( " + 
			"                    s.rm_id,( " + 
			"                        select " + 
			"                            setting_value1 " + 
			"                        from " + 
			"                            t_setting_new " + 
			"                        where " + 
			"                            setting_key='sf_cream_item' " + 
			"                            and del_status=0 " + 
			"                    ) " + 
			"                ) " + 
			"                and !FIND_IN_SET( " + 
			"                    s.rm_id,( " + 
			"                        select " + 
			"                            setting_value1 " + 
			"                        from " + 
			"                            t_setting_new " + 
			"                        where " + 
			"                            setting_key='rm_cream_item' " + 
			"                            and del_status=0 " + 
			"                    ) " + 
			"                )  ",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForManualProduction1(@Param("deptId")  int deptId);
	
	
	@Query(value="select " + 
			"        s.item_detail_id, " + 
			"        s.item_id, " + 
			"        s.rm_id, " + 
			"        s.rm_name, " + 
			"        s.rm_type, " + 
			"        s.rm_qty, " + 
			"        s.single_cut, " + 
			"        s.double_cut, " + 
			"        s.total, " + 
			"        s.uom, " + 
			"        s.plan_qty, " + 
			"        s.order_qty, " + 
			"        s.no_pieces_per_item   " + 
			"    from " + 
			"        ( SELECT " + 
			"            m_item_detail.item_detail_id, " + 
			"            m_item_detail.item_id, " + 
			"            m_item_detail.rm_id, " + 
			"            m_item_detail.rm_name, " + 
			"            m_item_detail.rm_type, " + 
			"            m_item_detail.rm_qty, " + 
			"            m_item_sf_header.mul_factor as single_cut, " + 
			"            0 as double_cut, " + 
			"            SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                               " + 
			"             as total, " + 
			"            m_rm_uom.uom, " + 
			"            SUM(t_temp_prod.rm_qty) as plan_qty, " + 
			"            SUM(t_temp_prod.rm_qty) as order_qty, " + 
			"            m_item_detail.no_pieces_per_item     " + 
			"        FROM " + 
			"            m_item_detail, " + 
			" " + 
			"           t_temp_prod, " + 
			"            m_rm_uom, " + 
			"            m_item_sf_header, " + 
			"            m_item_sup               " + 
			"        WHERE " + 
			"            m_item_detail.del_status=0           " + 
			"            and          t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"            and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			"            and m_item_sup.item_id=m_item_detail.item_id                   " + 
			" " + 
			"            AND  m_item_sf_header.int_1=:deptId " + 
			"            and m_item_detail.rm_type=2                   " + 
			" " + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id           " + 
			"        GROUP by " + 
			"            m_item_detail.rm_id                   " + 
			"        UNION " + 
			"        ALL     select " + 
			"            l.sf_did as item_detail_id, " + 
			"            l.sf_id as item_id, " + 
			"            l.rm_id, " + 
			"            l.rm_name, " + 
			"            l.rm_type, " + 
			"            SUM(l.rm_qty) as rm_qty, " + 
			"            1 as single_cut, " + 
			"            SUM(l.rm_weight) as double_cut, " + 
			"            SUM(round(((m.total*l.rm_weight_per)/100), " + 
			"            0)) as total, " + 
			"            l.rm_unit, " + 
			"            0 as plan_qty, " + 
			"            0 as order_qty, " + 
			"            0 as no_pieces_per_item   " + 
			"        from " + 
			"            (         select " + 
			"                a.sf_did, " + 
			"                a.sf_id, " + 
			"                a.rm_id, " + 
			"                a.rm_name, " + 
			"                a.rm_type, " + 
			"                a.rm_qty, " + 
			"                a.rm_weight, " + 
			"                a.del_status, " + 
			"                a.rm_unit, " + 
			"                round((a.rm_weight/b.rm_weight), " + 
			"                2) as rm_weight_per " + 
			"            from " + 
			"                (SELECT " + 
			"                    m_item_sf_detail.sf_did, " + 
			"                    m_item_sf_detail.sf_id, " + 
			"                    m_item_sf_detail.rm_id, " + 
			"                    concat(m_item_sf_detail.rm_name) as rm_name, " + 
			"                    m_item_sf_detail.rm_type, " + 
			"                    m_item_sf_detail.rm_qty, " + 
			"                    m_item_sf_detail.rm_weight, " + 
			"                    m_item_sf_detail.del_status, " + 
			"                    m_rm_uom.uom as rm_unit     " + 
			"                FROM " + 
			"                    m_item_sf_detail, " + 
			"                    m_rm_uom     " + 
			"                WHERE " + 
			"                    m_item_sf_detail.sf_id in ( " + 
			"                        SELECT " + 
			"                            m_item_detail.rm_id           " + 
			"                        FROM " + 
			"                            m_item_detail, " + 
			" " + 
			"                          t_temp_prod," + 
			"                            m_item_sf_header     " + 
			"                        WHERE " + 
			"                            m_item_detail.del_status=0         " + 
			"                            and  t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"                            and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			" " + 
			"                            AND  m_item_sf_header.int_1=:deptId           " + 
			"                            and m_item_detail.rm_type=2                   " + 
			" " + 
			"                        group by " + 
			"                            rm_id     " + 
			"                    ) " + 
			"                    and m_item_sf_detail.del_status=0   " + 
			"                    and m_item_sf_detail.rm_type=2 " + 
			"                    and m_rm_uom.uom_id=m_item_sf_detail.rm_unit " + 
			"                ) a         " + 
			"            LEFT JOIN " + 
			"                ( " + 
			"                    SELECT " + 
			"                        m_item_sf_detail.sf_id, " + 
			"                        SUM(m_item_sf_detail.rm_weight)/100 as rm_weight     " + 
			"                    FROM " + 
			"                        m_item_sf_detail     " + 
			"                    WHERE " + 
			"                        m_item_sf_detail.sf_id in ( " + 
			"                            SELECT " + 
			"                                m_item_detail.rm_id           " + 
			"                            FROM " + 
			"                                m_item_detail, " + 
			" " + 
			"                               t_temp_prod, " + 
			"                                m_item_sf_header     " + 
			"                            WHERE " + 
			"                                m_item_detail.del_status=0         " + 
			"                                and  t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"                                and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			" " + 
			"                                AND  m_item_sf_header.int_1=:deptId            " + 
			"                                and m_item_detail.rm_type=2                   " + 
			" " + 
			"                            group by " + 
			"                                rm_id     " + 
			"                        ) " + 
			"                        and m_item_sf_detail.del_status=0   " + 
			"                    group by " + 
			"                        m_item_sf_detail.sf_id        ) b " + 
			"                            ON b.sf_id=a.sf_id         " + 
			"                    ) l         " + 
			"            LEFT JOIN " + 
			"                ( " + 
			"                    SELECT " + 
			"                        m_item_detail.item_detail_id, " + 
			"                        m_item_detail.item_id, " + 
			"                        m_item_detail.rm_type, " + 
			"                        m_item_detail.rm_id, " + 
			"                       SUM(CEIL((t_temp_prod.rm_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                             " + 
			"                             as total     " + 
			"                    FROM " + 
			"                        m_item_detail, " + 
			" " + 
			"                     t_temp_prod, " + 
			"                        m_item_sf_header     " + 
			"                    WHERE " + 
			"                        m_item_detail.del_status=0         " + 
			"                        and t_temp_prod.sf_id=m_item_detail.item_id           " + 
			"                        and m_item_sf_header.sf_id=m_item_detail.rm_id                   " + 
			" " + 
			"                        AND  m_item_sf_header.int_1=:deptId          " + 
			"                        and m_item_detail.rm_type=2                   " + 
			" " + 
			"                    GROUP by " + 
			"                        m_item_detail.rm_id " + 
			"                ) m " + 
			"                    on l.sf_id=m.rm_id " + 
			"            group by " + 
			"                l.rm_id ) s " + 
			"            where " + 
			"                !FIND_IN_SET( " + 
			"                    s.rm_id,( " + 
			"                        select " + 
			"                            setting_value1 " + 
			"                        from " + 
			"                            t_setting_new " + 
			"                        where " + 
			"                            setting_key='sf_cream_item' " + 
			"                            and del_status=0 " + 
			"                    ) " + 
			"                ) " + 
			"                and FIND_IN_SET( " + 
			"                    s.rm_id,( " + 
			"                        select " + 
			"                            setting_value1 " + 
			"                        from " + 
			"                            t_setting_new " + 
			"                        where " + 
			"                            setting_key='rm_cream_item' " + 
			"                            and del_status=0 " + 
			"                    ) " + 
			"                )  ",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForManualProduction2(@Param("deptId")  int deptId);
	
	
	@Query(value=" select  s.item_detail_id, " + 
			"  s.item_id, " + 
			"  s.rm_id, " + 
			"  s.rm_name, " + 
			"  s.rm_type, " + 
			"  s.rm_qty, " + 
			"  s.single_cut, " + 
			"  s.double_cut, " + 
			"  s.total, " + 
			"  s.uom, " + 
			"  s.plan_qty, " + 
			"  s.order_qty, " + 
			"  s.no_pieces_per_item " + 
			"  from ( SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_id, " + 
			"        m_item_detail.rm_name, " + 
			"        m_item_detail.rm_type, " + 
			"        m_item_detail.rm_qty, " + 
			"        m_item_sf_header.mul_factor as single_cut, " + 
			"        0 as double_cut, " + 
			"        CASE               " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                  " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)           " + 
			"        END as total, " + 
			"        m_rm_uom.uom, " + 
			"          SUM(t_production_plan_detail.plan_qty) as plan_qty, " + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty, " + 
			"        m_item_detail.no_pieces_per_item " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup          " + 
			"    WHERE " + 
			"        m_item_detail.del_status=0  " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and m_item_sup.item_id=m_item_detail.item_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId        " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id       " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id " + 
			"         " + 
			"        UNION ALL " + 
			"    select l.sf_did as item_detail_id,l.sf_id as item_id,l.rm_id,l.rm_name,l.rm_type,SUM(l.rm_qty) as rm_qty,1 as single_cut,SUM(l.rm_weight) as double_cut,SUM(round(((m.total*l.rm_weight_per)/100),0)) as total,l.rm_unit,0 as plan_qty,0 as order_qty,0 as no_pieces_per_item " + 
			" from  ( " + 
			"        select a.sf_did,a.sf_id,a.rm_id,a.rm_name,a.rm_type,a.rm_qty,a.rm_weight,a.del_status,a.rm_unit,round((a.rm_weight/b.rm_weight),2) as rm_weight_per " + 
			"from " + 
			"(SELECT       m_item_sf_detail.sf_did, " + 
			"    m_item_sf_detail.sf_id, " + 
			"       m_item_sf_detail.rm_id, " + 
			"  concat(m_item_sf_detail.rm_name) as rm_name, " + 
			"       m_item_sf_detail.rm_type, " + 
			"       m_item_sf_detail.rm_qty, " + 
			"       m_item_sf_detail.rm_weight, " + 
			"       m_item_sf_detail.del_status, " + 
			"       m_rm_uom.uom as rm_unit " + 
			"   FROM " + 
			"       m_item_sf_detail,m_rm_uom " + 
			"   WHERE " + 
			"       m_item_sf_detail.sf_id in (SELECT " + 
			"        m_item_detail.rm_id " + 
			"          FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    group by rm_id " + 
			"    ) and m_item_sf_detail.del_status=0  and m_item_sf_detail.rm_type=2 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit) a " + 
			"       LEFT JOIN " + 
			"       ( " + 
			"        " + 
			"SELECT       " + 
			"    m_item_sf_detail.sf_id, " + 
			"      " + 
			"       SUM(m_item_sf_detail.rm_weight)/100 as rm_weight " + 
			"   FROM " + 
			"       m_item_sf_detail " + 
			"   WHERE " + 
			"       m_item_sf_detail.sf_id in (SELECT " + 
			"        m_item_detail.rm_id " + 
			"          FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    group by rm_id " + 
			"    ) and m_item_sf_detail.del_status=0  group by  m_item_sf_detail.sf_id " + 
			"       ) b ON b.sf_id=a.sf_id " + 
			"        ) l " + 
			"        LEFT JOIN " + 
			"        " + 
			"        (SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_type, " + 
			"        m_item_detail.rm_id, " + 
			"        CASE               " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                 " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)           " + 
			"        END as total    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id) m on l.sf_id=m.rm_id group by l.rm_id ) s where !FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='sf_cream_item' and del_status=0)) and !FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='rm_cream_item' and del_status=0))",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForLayering(@Param("headerId") int headerId,@Param("deptId") int deptId);

	
	@Query(value="select " + 
			"        n.item_detail_id, " + 
			"        n.item_id, " + 
			"        n.rm_id, " + 
			"        n.rm_name, " + 
			"        n.rm_type, " + 
			"        n.rm_qty, " + 
			"        n.single_cut, " + 
			"        n.total, " + 
			"        n.uom, " + 
			"        n.plan_qty, " + 
			"        n.order_qty, " + 
			"        n.no_pieces_per_item, " + 
			"        coalesce(m.double_cut,0) as double_cut " + 
			"    from (select " + 
			"        s.item_detail_id, " + 
			"        s.item_id, " + 
			"        s.rm_id, " + 
			"       i.item_name as rm_name, " + 
			"        s.rm_type, " + 
			"        s.rm_qty, " + 
			"        s.single_cut, " + 
			"        s.total, " + 
			"        s.uom, " + 
			"        s.plan_qty, " + 
			"        s.order_qty, " + 
			"        s.no_pieces_per_item    from " + 
			"        ( SELECT " + 
			"            m_item_detail.item_detail_id, " + 
			"            m_item_detail.item_id, " + 
			"            m_item_detail.rm_id, " + 
			"            m_item_detail.rm_name, " + 
			"            m_item_detail.rm_type, " + 
			"            m_item_detail.rm_qty, " + 
			"            m_item_sf_header.mul_factor as single_cut, " + 
			"            0 as double_cut, " + 
			"            CASE                            " + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                               " + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                    " + 
			"            END as total, " + 
			"            m_rm_uom.uom, " + 
			"            SUM(t_production_plan_detail.plan_qty) as plan_qty, " + 
			"            SUM(t_production_plan_detail.order_qty) as order_qty, " + 
			"            m_item_detail.no_pieces_per_item      " + 
			"        FROM " + 
			"            m_item_detail, " + 
			"            t_production_plan_header, " + 
			"            t_production_plan_detail, " + 
			"            m_rm_uom, " + 
			"            m_item_sf_header, " + 
			"            m_item_sup               " + 
			"        WHERE " + 
			"            m_item_detail.del_status=0           " + 
			"            and          t_production_plan_detail.item_id=m_item_detail.item_id            " + 
			"            and m_item_sf_header.sf_id=m_item_detail.rm_id                    " + 
			"            and m_item_sup.item_id=m_item_detail.item_id                    " + 
			"            and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                    " + 
			"            AND  m_item_sf_header.int_1=:deptId             " + 
			"            and m_item_detail.rm_type=2                    " + 
			"            and    t_production_plan_header.production_header_id =:headerId               " + 
			"            AND m_rm_uom.uom_id=m_item_detail.rm_uom_id            " + 
			"        GROUP by " + 
			"            m_item_detail.rm_id, m_item_detail.item_id                    " + 
			"        UNION " + 
			"        ALL     select " + 
			"            l.sf_did as item_detail_id, " + 
			"            l.sf_id as item_id, " + 
			"            l.rm_id, " + 
			"            l.rm_name, " + 
			"            l.rm_type, " + 
			"            SUM(l.rm_qty) as rm_qty, " + 
			"            1 as single_cut, " + 
			"            SUM(l.rm_weight) as double_cut, " + 
			"            SUM(round(((m.total*l.rm_weight_per)/100), " + 
			"            0)) as total, " + 
			"            l.rm_unit, " + 
			"            0 as plan_qty, " + 
			"            0 as order_qty, " + 
			"            0 as no_pieces_per_item   " + 
			"        from " + 
			"            (         select " + 
			"                a.sf_did, " + 
			"                a.sf_id, " + 
			"                a.rm_id, " + 
			"                a.rm_name, " + 
			"                a.rm_type, " + 
			"                a.rm_qty, " + 
			"                a.rm_weight, " + 
			"                a.del_status, " + 
			"                a.rm_unit, " + 
			"                round((a.rm_weight/b.rm_weight), " + 
			"                2) as rm_weight_per  " + 
			"            from " + 
			"                (SELECT " + 
			"                    m_item_sf_detail.sf_did, " + 
			"                    m_item_sf_detail.sf_id, " + 
			"                    m_item_sf_detail.rm_id, " + 
			"                    concat(m_item_sf_detail.rm_name) as rm_name, " + 
			"                    m_item_sf_detail.rm_type, " + 
			"                    m_item_sf_detail.rm_qty, " + 
			"                    m_item_sf_detail.rm_weight, " + 
			"                    m_item_sf_detail.del_status, " + 
			"                    m_rm_uom.uom as rm_unit     " + 
			"                FROM " + 
			"                    m_item_sf_detail, " + 
			"                    m_rm_uom     " + 
			"                WHERE " + 
			"                    m_item_sf_detail.sf_id in ( " + 
			"                        SELECT " + 
			"                            m_item_detail.rm_id            " + 
			"                        FROM " + 
			"                            m_item_detail, " + 
			"                            t_production_plan_header, " + 
			"                            t_production_plan_detail, " + 
			"                            m_item_sf_header     " + 
			"                        WHERE " + 
			"                            m_item_detail.del_status=0          " + 
			"                            and  t_production_plan_detail.item_id=m_item_detail.item_id            " + 
			"                            and m_item_sf_header.sf_id=m_item_detail.rm_id                    " + 
			"                            and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                    " + 
			"                            AND  m_item_sf_header.int_1=:deptId             " + 
			"                            and m_item_detail.rm_type=2                    " + 
			"                            and    t_production_plan_header.production_header_id =:headerId          " + 
			"                        group by " + 
			"                            rm_id      " + 
			"                    )  " + 
			"                    and m_item_sf_detail.del_status=0   " + 
			"                    and m_item_sf_detail.rm_type=2  " + 
			"                    and m_rm_uom.uom_id=m_item_sf_detail.rm_unit " + 
			"                ) a         " + 
			"            LEFT JOIN " + 
			"                ( " + 
			"                    SELECT " + 
			"                        m_item_sf_detail.sf_id, " + 
			"                        SUM(m_item_sf_detail.rm_weight)/100 as rm_weight     " + 
			"                    FROM " + 
			"                        m_item_sf_detail     " + 
			"                    WHERE " + 
			"                        m_item_sf_detail.sf_id in ( " + 
			"                            SELECT " + 
			"                                m_item_detail.rm_id            " + 
			"                            FROM " + 
			"                                m_item_detail, " + 
			"                                t_production_plan_header, " + 
			"                                t_production_plan_detail, " + 
			"                                m_item_sf_header     " + 
			"                            WHERE " + 
			"                                m_item_detail.del_status=0          " + 
			"                                and  t_production_plan_detail.item_id=m_item_detail.item_id            " + 
			"                                and m_item_sf_header.sf_id=m_item_detail.rm_id                    " + 
			"                                and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                    " + 
			"                                AND  m_item_sf_header.int_1=:deptId             " + 
			"                                and m_item_detail.rm_type=2                    " + 
			"                                and    t_production_plan_header.production_header_id =:headerId          " + 
			"                            group by " + 
			"                                rm_id      " + 
			"                        )  " + 
			"                        and m_item_sf_detail.del_status=0   " + 
			"                    group by " + 
			"                        m_item_sf_detail.sf_id        ) b  " + 
			"                            ON b.sf_id=a.sf_id          " + 
			"                    ) l          " + 
			"            LEFT JOIN " + 
			"                ( " + 
			"                    SELECT " + 
			"                        m_item_detail.item_detail_id, " + 
			"                        m_item_detail.item_id, " + 
			"                        m_item_detail.rm_type, " + 
			"                        m_item_detail.rm_id, " + 
			"                        CASE                            " + 
			"                            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                              " + 
			"                            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                    " + 
			"                        END as total     " + 
			"                    FROM " + 
			"                        m_item_detail, " + 
			"                        t_production_plan_header, " + 
			"                        t_production_plan_detail, " + 
			"                        m_item_sf_header     " + 
			"                    WHERE " + 
			"                        m_item_detail.del_status=0          " + 
			"                        and          t_production_plan_detail.item_id=m_item_detail.item_id            " + 
			"                        and m_item_sf_header.sf_id=m_item_detail.rm_id                    " + 
			"                        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                    " + 
			"                        AND  m_item_sf_header.int_1=:deptId             " + 
			"                        and m_item_detail.rm_type=2                    " + 
			"                        and    t_production_plan_header.production_header_id =:headerId          " + 
			"                    GROUP by " + 
			"                        m_item_detail.rm_id " + 
			"                ) m  " + 
			"                    on l.sf_id=m.rm_id  " + 
			"            group by " + 
			"                l.rm_id ) s ,m_item i " + 
			"            where " + 
			"                !FIND_IN_SET( " + 
			"                    s.rm_id,( " + 
			"                        select " + 
			"                            setting_value1  " + 
			"                        from " + 
			"                            t_setting_new  " + 
			"                        where " + 
			"                            setting_key='sf_cream_item'  " + 
			"                            and del_status=0 " + 
			"                    ) " + 
			"                )  " + 
			"                and !FIND_IN_SET( " + 
			"                    s.rm_id,( " + 
			"                        select " + 
			"                            setting_value1  " + 
			"                        from " + 
			"                            t_setting_new  " + 
			"                        where " + 
			"                            setting_key='rm_cream_item'  " + 
			"                            and del_status=0 " + 
			"                    ) " + 
			"                ) and i.id=s.item_id and  s.rm_id=:rmId) n " + 
			"LEFT JOIN " + 
			"(select id,1 as double_cut from m_item where m_item.del_status=0 and FIND_IN_SET(m_item.id,( " + 
			"select group_concat(ex_varchar1) as item_ids  from t_mixing_header where production_id=:headerId and del_status=0 and ex_int1=:deptId and ex_varchar1 !=\"\"))) m on m.id=n.item_id",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailItemLayering(@Param("headerId")int headerId,@Param("rmId") int rmId,@Param("deptId") int deptId);

	
	@Query(value="  select  s.item_detail_id, " + 
			"  s.item_id, " + 
			"  s.rm_id, " + 
			"  s.rm_name, " + 
			"  s.rm_type, " + 
			"  s.rm_qty, " + 
			"  s.single_cut, " + 
			"  coalesce(c.double_cut,0)as double_cut, " + 
			"  s.total, " + 
			"  s.uom, " + 
			"  s.plan_qty, " + 
			"  s.order_qty, " + 
			"  s.no_pieces_per_item " + 
			"  from ( SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_id, " + 
			"        m_item_detail.rm_name, " + 
			"        m_item_detail.rm_type, " + 
			"        m_item_detail.rm_qty, " + 
			"        m_item_sf_header.mul_factor as single_cut, " + 
			"        0 as double_cut, " + 
			"        CASE               " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                  " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)           " + 
			"        END as total, " + 
			"        m_rm_uom.uom, " + 
			"          SUM(t_production_plan_detail.plan_qty) as plan_qty, " + 
			"        SUM(t_production_plan_detail.order_qty) as order_qty, " + 
			"        m_item_detail.no_pieces_per_item " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup          " + 
			"    WHERE " + 
			"        m_item_detail.del_status=0  " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and m_item_sup.item_id=m_item_detail.item_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId        " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id       " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id " + 
			"         " + 
			"        UNION ALL " + 
			"    select l.sf_did as item_detail_id,l.sf_id as item_id,l.rm_id,l.rm_name,l.rm_type,SUM(l.rm_qty) as rm_qty,1 as single_cut,SUM(l.rm_weight) as double_cut,SUM(round(((m.total*l.rm_weight_per)/100),0)) as total,l.rm_unit,0 as plan_qty,0 as order_qty,0 as no_pieces_per_item " + 
			" from  ( " + 
			"        select a.sf_did,a.sf_id,a.rm_id,a.rm_name,a.rm_type,a.rm_qty,a.rm_weight,a.del_status,a.rm_unit,round((a.rm_weight/b.rm_weight),2) as rm_weight_per " + 
			"from " + 
			"(SELECT       m_item_sf_detail.sf_did, " + 
			"    m_item_sf_detail.sf_id, " + 
			"       m_item_sf_detail.rm_id, " + 
			"  concat(m_item_sf_detail.rm_name) as rm_name, " + 
			"       m_item_sf_detail.rm_type, " + 
			"       m_item_sf_detail.rm_qty, " + 
			"       m_item_sf_detail.rm_weight, " + 
			"       m_item_sf_detail.del_status, " + 
			"       m_rm_uom.uom as rm_unit " + 
			"   FROM " + 
			"       m_item_sf_detail,m_rm_uom " + 
			"   WHERE " + 
			"       m_item_sf_detail.sf_id in (SELECT " + 
			"        m_item_detail.rm_id " + 
			"          FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    group by rm_id " + 
			"    ) and m_item_sf_detail.del_status=0  and m_item_sf_detail.rm_type=2 and m_rm_uom.uom_id=m_item_sf_detail.rm_unit) a " + 
			"       LEFT JOIN " + 
			"       ( " + 
			"        " + 
			"SELECT       " + 
			"    m_item_sf_detail.sf_id, " + 
			"      " + 
			"       SUM(m_item_sf_detail.rm_weight)/100 as rm_weight " + 
			"   FROM " + 
			"       m_item_sf_detail " + 
			"   WHERE " + 
			"       m_item_sf_detail.sf_id in (SELECT " + 
			"        m_item_detail.rm_id " + 
			"          FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and  t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    group by rm_id " + 
			"    ) and m_item_sf_detail.del_status=0  group by  m_item_sf_detail.sf_id " + 
			"       ) b ON b.sf_id=a.sf_id " + 
			"        ) l " + 
			"        LEFT JOIN " + 
			"        " + 
			"        (SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_type, " + 
			"        m_item_detail.rm_id, " + 
			"        CASE               " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                 " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)           " + 
			"        END as total    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_item_sf_header    WHERE " + 
			"        m_item_detail.del_status=0 " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId     " + 
			"        and m_item_detail.rm_type=2           " + 
			"        and    t_production_plan_header.production_header_id =:headerId       " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id) m on l.sf_id=m.rm_id group by l.rm_id ) s   LEFT JOIN " + 
			"			               (  select DISTINCT d.sf_id,1 as double_cut from t_mixing_detail d where   d.mixing_id IN( select  h.mix_id from t_mixing_header h where  h.Production_id=:headerId  order by h.mix_id DESC) ) c  ON s.rm_id=c.sf_id    where FIND_IN_SET(s.rm_id,(select setting_value1 from t_setting_new where setting_key='rm_cream_item' and del_status=0))",nativeQuery=true)
	List<GetSFPlanDetailForMixing> showDetailsForCoating(@Param("headerId") int headerId,@Param("deptId") int deptId);

	
	@Query(value=" SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_name, " + 
			"        m_item_detail.rm_type, " + 
			"        SUM(t_production_plan_detail.plan_qty) plan_qty, " + 
			"        SUM(t_production_plan_detail.order_qty) order_qty, " + 
			"        m_item_detail.rm_id, " + 
			"        m_item_detail.no_pieces_per_item, " + 
			"        m_item_detail.rm_qty, " + 
			"        m_item_sf_header.mul_factor as single_cut, " + 
			"        CASE               " + 
			"            WHEN m_item_sup.cut_section=2 THEN  (CASE                   " + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                      " + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)               " + 
			"            END)               " + 
			"            ELSE 0            " + 
			"        END as  double_cut, " + 
			"        CASE               " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                  " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)           " + 
			"        END as total, " + 
			"        m_rm_uom.uom        " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup          " + 
			"    WHERE " + 
			"        m_item_detail.del_status=0  " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id   " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id           " + 
			"        and m_item_sup.item_id=m_item_detail.item_id           " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id           " + 
			"        AND  m_item_sf_header.int_1=:deptId " + 
			"        and    t_production_plan_header.production_header_id =:headerId        " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id  and m_item_detail.item_id IN(:itemId)   " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id " + 
			" ",nativeQuery=true)
	List<GetSFPlanDetailForMixing> getSfDetailsForIssue1(@Param("headerId") int headerId,@Param("deptId") int deptId,@Param("itemId") List<String> itemId);
	//To be changed for dept id getting only those in where clause to match based on condition 14-03-2020 Sac _mahe-Sumit evening
	
	
	
	@Query(value=" SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_name, " + 
			"        m_item_detail.rm_type, " + 
			"        SUM(t_production_plan_detail.plan_qty) plan_qty, " + 
			"        SUM(t_production_plan_detail.order_qty) order_qty, " + 
			"        m_item_detail.rm_id, " + 
			"        m_item_detail.no_pieces_per_item, " + 
			"        m_item_detail.rm_qty, " + 
			"        m_item_sf_header.mul_factor as single_cut, " + 
			"        CASE                            " + 
			"            WHEN m_item_sup.cut_section=2 THEN  (CASE                                    " + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                                       " + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                            " + 
			"            END)                            " + 
			"            ELSE 0                     " + 
			"        END as  double_cut, " + 
			"        CASE                            " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                               " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                    " + 
			"        END as total, " + 
			"        m_rm_uom.uom             " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup          " + 
			"    WHERE " + 
			"    " + 
			"        m_item_detail.del_status=0           " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id            " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id     " + 
			"        and m_item_sup.item_id=m_item_detail.item_id                    " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                    " + 
			"        AND  m_item_sf_header.int_1=:deptId      AND  m_item_detail.rm_type=2  " + 
			"        and    t_production_plan_header.production_header_id =:headerId                 " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id   " + 
			"        and m_item_detail.item_id IN( " + 
			"          :itemId " + 
			"        )        " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id " + 
			"           union all " + 
			"SELECT " + 
			"        m_item_detail.item_detail_id, " + 
			"        m_item_detail.item_id, " + 
			"        m_item_detail.rm_name, " + 
			"        m_item_detail.rm_type, " + 
			"        SUM(t_production_plan_detail.plan_qty) plan_qty, " + 
			"        SUM(t_production_plan_detail.order_qty) order_qty, " + 
			"        m_item_detail.rm_id, " + 
			"        m_item_detail.no_pieces_per_item, " + 
			"        m_item_detail.rm_qty, " + 
			"        m_item_sf_header.mul_factor as single_cut, " + 
			"        CASE                            " + 
			"            WHEN m_item_sup.cut_section=2 THEN  (CASE                                    " + 
			"                WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                                       " + 
			"                ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                            " + 
			"            END)                            " + 
			"            ELSE 0                     " + 
			"        END as  double_cut, " + 
			"        CASE                            " + 
			"            WHEN t_production_plan_header.is_planned=0 THEN SUM(CEIL((t_production_plan_detail.order_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                               " + 
			"            ELSE  SUM(CEIL((t_production_plan_detail.plan_qty* m_item_detail.rm_qty)/m_item_detail.no_pieces_per_item)*m_item_detail.varchar_1*m_item_sf_header.sf_weight)                    " + 
			"        END as total, " + 
			"        m_rm_uom.uom             " + 
			"    FROM " + 
			"        m_item_detail, " + 
			"        t_production_plan_header, " + 
			"        t_production_plan_detail, " + 
			"        m_rm_uom, " + 
			"        m_item_sf_header, " + 
			"        m_item_sup,m_rm          " + 
			"    WHERE " + 
			"     m_rm.rm_id=m_item_detail.rm_id and m_rm.rm_op_rate=:deptId and  " + 
			"        m_item_detail.del_status=0           " + 
			"        and          t_production_plan_detail.item_id=m_item_detail.item_id            " + 
			"        and m_item_sf_header.sf_id=m_item_detail.rm_id     " + 
			"        and m_item_sup.item_id=m_item_detail.item_id                    " + 
			"        and    t_production_plan_header.production_header_id=t_production_plan_detail.production_header_id                     and  m_item_detail.rm_type=1 " + 
			"        and    t_production_plan_header.production_header_id =:headerId                 " + 
			"        AND m_rm_uom.uom_id=m_item_detail.rm_uom_id   " + 
			"        and m_item_detail.item_id IN( " + 
			"          :itemId " + 
			"        )        " + 
			"    GROUP by " + 
			"        m_item_detail.rm_id " + 
			" ",nativeQuery=true)
	List<GetSFPlanDetailForMixing> getSfDetailsForIssue(@Param("headerId") int headerId,@Param("deptId") int deptId,@Param("itemId") List<String> itemId);

}
