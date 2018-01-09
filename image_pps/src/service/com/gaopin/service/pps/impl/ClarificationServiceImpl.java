/* This file ClarificationServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.gaopin.entity.Clarification;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.ClarificationService;
import com.gaopin.utils.StrUtils;
@Service("clarificationService")
public class ClarificationServiceImpl extends BaseServiceImpl implements
		ClarificationService {
	
	private static Map<String, List<Clarification>> _map_list = new HashMap<String, List<Clarification>>();
	private static Map<Integer, Clarification> _map = new HashMap<Integer, Clarification>();
	
	@PostConstruct
	public void init(){
		loadAll();
	}
	
	public void loadAll(){
		_map_list.clear();
		List<Clarification> list = controller.getAll(Clarification.class);
		for(Clarification cla : list){
			if(cla.getName()==null) continue;
			List<Clarification> subList = _map_list.get(cla.getName().toLowerCase());
			if(subList==null){
				subList = new ArrayList<Clarification>();
				_map_list.put(cla.getName().toLowerCase(), subList);
			}
			subList.add(cla);
			_map.put(cla.getId(), cla);
		}
		list = null;
	}
	
	public List<Clarification> getListByName(String name){
		return _map_list.get(name.toLowerCase());
	}
	
	public Clarification getClarification(Integer id){
		if(id==null || id<=0) return null;
		return _map.get(id.intValue());
	}

	@Override
	public List<Clarification> getClarification(String ids) {
		try{
			if(StrUtils.isBlank(ids)) return null;
			String[] eles = ids.split(",");
			List<Clarification> list = new ArrayList<Clarification>();
			for(String s : eles){
				Clarification cla = getClarification(StrUtils.getIntValue(s, 0));
				if(cla!=null){
					list.add(cla);
				}
			}
			return list;
		}
		catch (Exception e) {
			logger.error("根据ids查询澄清列表异常[ids="+ids+"]：", e);
		}
		return null;
	}
	
}
