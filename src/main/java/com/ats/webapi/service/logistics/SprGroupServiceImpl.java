package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.SprGroup; 
import com.ats.webapi.repository.logistics.SprGroupRepository;

@Service
public class SprGroupServiceImpl implements SprGroupService{
	
	
	@Autowired 
	SprGroupRepository sprGroupRepository;

	@Override
	public SprGroup postSprGroup(SprGroup sprGroup) {
		SprGroup response = new SprGroup();
		 try
		 {
			 response = sprGroupRepository.save(sprGroup);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteSprGroup(int groupId) {
		Info info = new Info();
		try {
			  
			int delete = sprGroupRepository.deleteSprGroup(groupId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("deleted successfully");
			}
			else
			{
				info.setError(true);
				info.setMessage("failed to delete");
			}
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return info;
	}

	@Override
	public List<SprGroup> getAllSprGroupList() {
		List<SprGroup> getAllSprGroupList = new ArrayList<SprGroup>();
		try {
			  
			getAllSprGroupList = sprGroupRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllSprGroupList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllSprGroupList;
	}

	@Override
	public SprGroup getSprGroupById(int groupId) {
		SprGroup getSprGroupById = new SprGroup();
		try {
			  
			getSprGroupById = sprGroupRepository.findByGroupId(groupId);
			 
			System.out.println(getSprGroupById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getSprGroupById;
	}

	@Override
	public List<SprGroup> getSprGroupListByTypeId(int typeId) {
		List<SprGroup> getSprGroupListByTypeId = new ArrayList<SprGroup>();
		try {
			  
			getSprGroupListByTypeId = sprGroupRepository.findAllByTypeIdAndDelStatus(typeId,0);
			 
			System.out.println(getSprGroupListByTypeId.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getSprGroupListByTypeId;
	}

}
