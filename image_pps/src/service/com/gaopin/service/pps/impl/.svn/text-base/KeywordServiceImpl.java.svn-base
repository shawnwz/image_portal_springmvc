/* This file KeywordServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.gaopin.entity.Keywords;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.KeywordService;
import com.gaopin.utils.PropertyReader;
import com.gaopin.utils.StrUtils;
@Service("keywordService")
public class KeywordServiceImpl extends BaseServiceImpl implements
		KeywordService {

	private static Map<String, Keywords> _map = new HashMap<String, Keywords>();
	private static List<Keywords> _list = new ArrayList<Keywords>();
	
	@PostConstruct
	public void init(){
		long t = System.currentTimeMillis();
		if(PropertyReader.getInt("local.debug", -1)<=0){
			loadAll();
		}
		System.out.println("关键词载入时间：" + (System.currentTimeMillis()-t));
	}
	
	public void loadAll(){
		_map.clear();
		_list.clear();
		List<Keywords> list = controller.getAll(Keywords.class);
		for(Keywords kw : list){
			_map.put(kw.getKeyword(), kw);
			_list.add(kw);
		}
		// 对list列表排序
		Collections.sort(_list, new Comparator<Keywords>(){

			@Override
			public int compare(Keywords o1, Keywords o2) {
				return o2.getNum()-o1.getNum();
			}
			
		});
	}
	
	@Override
	public List<Keywords> getHotkeyList(String key, int top){
		if(StrUtils.isBlank(key)){
			return _list.subList(0, top);
		}
		List<Keywords> list = new ArrayList<Keywords>();
		for(Keywords kw : _list){
			if(kw.getKeyword().startsWith(key)){
				list.add(kw);
				if(list.size()>=top){
					break;
				}
			}
		}
		return list;
	}

	@Override
	public Keywords getKeywords(String key) {
		return _map.get(key);
	}

}
