package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.SprGroup;

@Service
public interface SprGroupService {

	SprGroup postSprGroup(SprGroup sprGroup);

	Info deleteSprGroup(int groupId);

	List<SprGroup> getAllSprGroupList();

	SprGroup getSprGroupById(int groupId);

	List<SprGroup> getSprGroupListByTypeId(int typeId); 

}
