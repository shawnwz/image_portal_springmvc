/* This file IndexPageServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.entity.ImageSets;
import com.gaopin.entity.IndexBigview;
import com.gaopin.entity.IndexMenu;
import com.gaopin.entity.SystemVariables;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.IndexPageService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.JsonFormat;

@Service("indexPageService")
public class IndexPageServiceImpl extends BaseServiceImpl implements
	IndexPageService {

	@Resource
	private CacheService cacheService;
	@Resource
	private VariablesService variablesService;
	@PostConstruct
	public void init(){
		loadAll();
	}
	
	@Override
	public void loadAll() {
		List<IndexBigview> list = controller.loadAll(IndexBigview.class);
		cacheService.putLocalLong(SystemVariables.class.getName()+"all", list);
		
		List<IndexMenu> list1 = controller.loadAll(IndexMenu.class);
		cacheService.putLocalLong(IndexMenu.class.getName()+"all", list1);
		
		List<IndexMenu> list2 = controller.findBy(IndexMenu.class, "type", 1, "sequence", false);
		cacheService.putLocalLong(IndexMenu.class.getName()+"type1", list2);
		

		List<IndexMenu> list3 = controller.findBy(IndexMenu.class, "type", 2, "sequence", false);
		cacheService.putLocalLong(IndexMenu.class.getName()+"type2", list3);
		
		List<ImageSets> list4 = controller.loadAll(ImageSets.class);
		cacheService.putLocalLong(ImageSets.class.getName()+"all", list4);
		
	}
	
	
	@Override
	public List<IndexBigview> getIndexBigviews() {
		Integer index=GetNowTimeSpan();
		List<IndexBigview> variables =(List<IndexBigview>)cacheService.getLocalShort(IndexBigview.class.getName()+"all"+index);
		if(variables==null){
			List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
			expressions.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
			//expressions.add(new CompareExpression("type", index, CompareType.Equal));
			variables =  controller.findBy(IndexBigview.class, "seq", false,expressions);
			if(variables!=null){
				cacheService.putLocalShort(IndexBigview.class.getName()+"all"+index, variables);
			}
		}
		return variables;
	}
	
	
	private HashMap<Integer, Integer> indexTimespans;
	
	private Integer GetNowTimeSpan()
	{
		List<Map<String, Object>> list = null;
		try{
			if(indexTimespans==null||indexTimespans.size()==0)
			{
				//{"param":[{"name":"08:00-16:00" ,"value":1},{"name": "16:00-24:00" ,"value":2},{"name": "00:00-8:00" ,"value":3}]}
				String indexTimespan= variablesService.getVariables("indexBigview_type").getValue();
				Map<String, Object> map = JsonFormat.toMap(indexTimespan);
				if(map!=null){
					list = (List<Map<String, Object>>)map.get("param");
				}
			}
			if(list!=null && list.size()>0){
				for(Map<String, Object> subMap : list){
					String name = (String)subMap.get("name");
					if(DateUtils.betweenTime(new Date(), name)){
						return (Integer)subMap.get("value");
					}
				}
			}
			else{
				return 1;
			}
		}catch (Exception e) {
			return 1;
		}
		return 1;
	}

	@Override
	public List<IndexMenu> IndexMenus(Integer type) {
		List<IndexMenu> variables = (List<IndexMenu>)cacheService.getLocalLong(IndexMenu.class.getName()+"type"+type);
		if(variables==null){
			variables =  controller.findBy(IndexMenu.class, "type", 1, "sequence", false);
			if(variables!=null){
				cacheService.putLocalLong(IndexMenu.class.getName()+"type"+type, variables);
			}
		}
		return variables;
	}

	@Override
	public IndexMenu IndexMenu(Integer id) {
		IndexMenu variables = (IndexMenu)cacheService.getLocalLong(IndexMenu.class.getName()+id);
		if(variables==null){
			variables =  controller.get(IndexMenu.class, id);
			if(variables!=null){
				cacheService.putLocalLong(IndexMenu.class.getName()+id, variables);
			}
		}
		return variables;
	}
	
	
	@Override
	public Integer GetIndexDelay() {
		try{
		return Integer.parseInt(variablesService.getVariables("IndexDelay").getValue());
		}catch (Exception e) {
			return 2000;
		}
	}

	@Override
	public Integer GetIndexDuration() {
		try{
			return Integer.parseInt(variablesService.getVariables("IndexDuration").getValue());
			}catch (Exception e) {
				return 2000;
			}
	}


}
