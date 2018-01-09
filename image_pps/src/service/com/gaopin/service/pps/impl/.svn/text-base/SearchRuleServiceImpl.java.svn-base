/* This file SearchRuleServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.gaopin.entity.SearchRule;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.SearchRuleService;
@Service("searchRuleService")
public class SearchRuleServiceImpl extends BaseServiceImpl implements
		SearchRuleService {

	private Map<String, SearchRule> _map = new HashMap<String, SearchRule>();
	
	@PostConstruct
	public void init(){
		loadAll();
	}
	
	@Override
	public SearchRule getSearchRule(String key) {
		if(key==null) return null;
		return _map.get(key.toLowerCase());
	}

	@Override
	public void loadAll() {
		_map.clear();
		List<SearchRule> list = getController().loadAll(SearchRule.class);
		for(SearchRule searchRule : list){
			_map.put(searchRule.getKey().toLowerCase(), searchRule);
		}
	}

}
