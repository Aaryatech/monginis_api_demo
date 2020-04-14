package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ats.webapi.model.ItemWithSubCat;
import com.ats.webapi.repository.GetFrItemRepository;

@Service("GetFrItemsService")

public class GetFrItemsServiceImpl implements GetFrItemsService {

	@Autowired
	private GetFrItemRepository getFrItemRepository;

	
	@Override
	public List<ItemWithSubCat> findFrItems(List<Integer> items) {
		List<ItemWithSubCat> list=null;
		
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.err.println("dayOfWeek"+dayOfWeek);
		if(dayOfWeek==1)
		{
			 List<Integer> arrList=new ArrayList<>();
			 arrList.add(1);
			 arrList.add(11);
				 list=getFrItemRepository.findFrItems(arrList,items);
		}else if(dayOfWeek==2)
		{
			 List<Integer> arrList=new ArrayList<>();
			 arrList.add(1);
			 arrList.add(12);
				 list=getFrItemRepository.findFrItems(arrList,items);
		}else if(dayOfWeek==3)
		{
			 List<Integer> arrList=new ArrayList<>();
			 arrList.add(1);
			 arrList.add(13);
				 list=getFrItemRepository.findFrItems(arrList,items);
		}else if(dayOfWeek==4)
		{
			List<Integer> arrList=new ArrayList<>();
			 arrList.add(1);
			 arrList.add(14);
				 list=getFrItemRepository.findFrItems(arrList,items);
		}else if(dayOfWeek==5)
		{
			List<Integer> arrList=new ArrayList<>();
			 arrList.add(1);
			 arrList.add(15);
				 list=getFrItemRepository.findFrItems(arrList,items);
		}else if(dayOfWeek==6)
		{
			List<Integer> arrList=new ArrayList<>();
			arrList.add(1);
			arrList.add(16);
			list=getFrItemRepository.findFrItems(arrList,items);
		}else if(dayOfWeek==7)
		{
			List<Integer> arrList=new ArrayList<>();
			arrList.add(1);
			arrList.add(17);
			list=getFrItemRepository.findFrItems(arrList,items);
		}
		
		return list;
	}

}
