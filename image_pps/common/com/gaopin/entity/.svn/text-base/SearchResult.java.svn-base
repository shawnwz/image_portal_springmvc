/* This file SearchResult.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gaopin.utils.KeyValue;
import com.gaopin.utils.StrUtils;
/**
 * 搜索结果专用
 * @author xcb
 *
 */
public class SearchResult{
	
	private int total; // 结果总数
	private String searchId; // 每次搜索都会生成唯一ID
	private List<String> ids;
//	private List<KeyValue<String, Integer>> datas = new ArrayList<KeyValue<String,Integer>>();
	private boolean isCache = false; // 此结果是否缓存
	private Map<String, Object> extendData = new HashMap<String, Object>();
	private Map<Integer, Integer> relativePageMap = new HashMap<Integer, Integer>();
	private int min;
	private int max;
	
	private List<SolrResult> datas = new ArrayList<SolrResult>();
	
	public SearchResult(){
	}
	
	public void setDatas(List<SolrResult> datas){
		ids = new ArrayList<String>();
		for(SolrResult sr : datas){
			ids.add(sr.getCorbisId());
		}
		this.datas = datas;
	}
	
	/**
	 * 根据真实页码值获取相对页码值(相对页码值用于查询)
	 * @param realPageNo
	 * @return
	 */
	public Integer getRelativePageNo(Integer realPageNo, int basePageNo){
		if(realPageNo==null) return null;
		Integer relativePageNo = relativePageMap.get(realPageNo);
		if(relativePageNo==null){
			relativePageNo = basePageNo + relativePageMap.size() + 1;
			relativePageMap.put(realPageNo, relativePageNo);
		}
		return relativePageNo;
	}
	
	public boolean isRstRange(int offset, int limit){
		
//		System.out.println("@@@@@@@min="+min+", max="+max);
//		System.out.println("@@@@@@@min="+offset+", max="+(offset+limit));
		if(offset>=this.min && (offset+limit)<=this.max){
			return true;
		}
		return false;
	}
	
	public void setExtendData(String key, Object value){
		extendData.put(key, value);
	}
	
	public Map<String, Object> getExtendData(){
		return extendData;
	}
	
	public List<SolrResult> getDatas(){
		return datas;
	}
	
	public SearchResult(int total, List<String> ids){
		this.total = total;
		this.ids = ids;
	}

	public int getTotal() {
		if(total>1000000) return 1000000;
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public List<String> getAllIds(){
		return ids!=null ? ids:new ArrayList<String>();
	}
	
	public List<String> getIds(int start, int num){
		return getIds(start, num, 1000);
	}
	
	public List<String> getIds(int start, int num, int cacheNum) {
		if(ids!=null) {
			if(!isCache) return ids;	// 不是缓存数据，直接返回
			// 处理缓存数据
			start = start % cacheNum;
			int end = start + num;
			if(end>ids.size()){
				end = ids.size();
			}
			if(start>=end) return new ArrayList<String>();
			return ids.subList(start, end);
		}
		ids = new ArrayList<String>();
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public boolean isCache() {
		return isCache;
	}

	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public void clearDatas(){
		this.datas.clear();
	}
}
