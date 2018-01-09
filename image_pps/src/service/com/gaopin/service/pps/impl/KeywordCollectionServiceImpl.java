/* This file KeywordCollectionServiceImpl.java is part of image_pps .
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
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.KeywordCollectionService;
import com.gaopin.utils.StrUtils;
@Service("keywordCollectionService")
public class KeywordCollectionServiceImpl extends BaseServiceImpl implements
		KeywordCollectionService {

	private Map<String, List<String>> _map = new HashMap<String, List<String>>();
	
	@PostConstruct
	public void init(){
		loadAll();
	}
	
	public void loadAll(){
		_map = new HashMap<String, List<String>>();
		List<String> list = getUniqueKeys();
		
		for(String english : list){
			if(StrUtils.isBlank(english)) continue;
			english = english.trim();
			if(english.length()<2) continue;
			english = english.toLowerCase();
			String key = english.substring(0,2);
			List<String> subList = _map.get(key);
			if(subList==null){
				subList = new ArrayList<String>();
				_map.put(key, subList);
			}
			subList.add(english);
		}
		// 按照长度排序
		for(Entry<String, List<String>> entry : _map.entrySet()){
			List<String> subList = entry.getValue();
			if(subList==null || subList.size()==0) continue;
			Collections.sort(subList, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o2.length()-o1.length();
				}
			});
		}
	}
	
	private List<String> getUniqueKeys(){
		String hql = "select distinct english from KeywordCollection";
		List<String> list = controller.findBy(hql);
		System.out.println("list.size=" + list.size());
		return list;
	}
	
	@Override
	public List<String> parseEnKey(String keyword) {
		List<String> rstList = new ArrayList<String>();
		if(StrUtils.isBlank(keyword)) return rstList;
		keyword = keyword.trim().toLowerCase();
		if(keyword.length()<2) {
			rstList.add(keyword);
			return rstList;
		}
		String mapKey = keyword.substring(0,2);
		List<String> list = _map.get(mapKey);
		boolean isMatch = false;
		if(list!=null){
			for(String s : list){
				if(!keyword.startsWith(s)){
					continue;
				}
				// 已keyword开头
				if(keyword.equals(s)){
					rstList.add(s);
					isMatch = true;
					return rstList;
				}
				else if(keyword.startsWith(s+" ")){
					rstList.add(s);
					String rightKeyword = keyword.substring(s.length()+1);
					if(rightKeyword.length()>0){
						rstList.addAll(parseEnKey(rightKeyword));
					}
					isMatch = true;
					return rstList;
				}
			}
		}
		if(!isMatch){
			int et = keyword.indexOf(" ");
			if(et<0){
				if(keyword.length()>0){
					rstList.add(keyword);
				}
			}
			else{
				String leftKey = keyword.substring(0, et);
				if(leftKey.length()>2){
//					rstList.add(leftKey);
				}
				else {
					et = keyword.indexOf(" ", et+1);
					if(et<0){
						leftKey = keyword;
//						rstList.add(keyword);
					}
					else{
						leftKey = keyword.substring(0, et);
//						rstList.add(keyword.substring(0, et));
					}
				}
				if(et>0){
					String rightKey = keyword.substring(et).trim();
					if(rightKey.length()<=2){
						leftKey = keyword;
						rstList.add(leftKey);
					}
					else{
						rstList.add(leftKey);
						rstList.addAll(parseEnKey(rightKey));
					}
				}
				else{
					rstList.add(leftKey);
				}
			}
		}
		return rstList;
	}

	public static void main(String[] args){
		String str = "girl house    mouse German Grand           Prix blue sea";
		char lastChar = 0;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch==' ' && lastChar==' '){
				continue;
			}
			sb.append(ch);
			lastChar = ch;
		}
		System.out.println(sb.toString());
	}
}
