/* This file CollectionSpec.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.SolrResult;
import com.gaopin.service.pps.impl.CollectionServiceImpl;
import com.gaopin.utils.StrUtils;

/**
 * 
 * @author 
 * 指定图库排序专用
 * 记录处理中间值，待排序使用
 */
public class CollectionSpec implements java.io.Serializable{
	private Logger logger = Logger.getLogger(this.getClass());
	
	private static int CID_NUM = 1000;
	
	private List<Integer> cidList = new ArrayList<Integer>();
	// 需要排序的总数量
	private int num = 0;
	private String cidStr = null;
	
	public CollectionSpec(String cidStr){
		this.cidStr = cidStr;
		try{
			String[] eles = cidStr.split(",");
			for(String ele : eles){
				Integer cid = StrUtils.getIntValue(ele, null);
				if(cid==null) continue;
				cidList.add(cid);
			}
			num = cidList.size();
		}
		catch (Exception e) {
			logger.error("初始化排序对象异常：", e);
		}
	}
	
	private Map<Integer, List<Integer>> getSortMap(){
		Map<Integer, List<Integer>> sortMap = new HashMap<Integer, List<Integer>>();
		for(int i=0; i<cidList.size(); i++){
			Integer cid = cidList.get(i);
			List<Integer> list = sortMap.get(cid);
			if(list==null){
				list = new ArrayList<Integer>();
				sortMap.put(cid, list);
			}
			list.add(i);
		}
		return sortMap;
	}
	
	public List<String> sortTop100(List<SolrResult> list){
		List<String> rstList = new ArrayList<String>();
		if(list==null) return rstList;
		try{
			Map<Integer, List<Integer>> sortMap = getSortMap();
			String[] rst = new String[num];
			int count = 0;
			for(int i=0; i<list.size(); i++){
				SolrResult sr = list.get(i);
				List<Integer> sortList = sortMap.get(sr.getCollectionId());
				if(sortList!=null && sortList.size()>0){
					int index = sortList.get(0);
					if(index<rst.length){
						rst[index] = sr.getCorbisId();
						list.remove(i);
						sortList.remove(0);
						i--;
						count++;
						continue;
					}
				}
				if(count>=num){
					break;
				}
			}
			for(int i=rst.length-1; i>=0; i--){
				if(rst[i]!=null){
					rstList.add(0, rst[i]);
				}
			}
			List<String> sortList = sortList(list);
			rstList.addAll(sortList);
		}
		catch (Exception e) {
			logger.error("根据指定图库进行排序异常：", e);
		}
		return rstList;
	}
	
	public List<String> sortList(List<SolrResult> list){
		Map<Integer, Integer> cidSortMap = new HashMap<Integer, Integer>();
		int firstSortValue = 1000;
		for(SolrResult sr : list){
			Integer sv = cidSortMap.get(sr.getCollectionId());
			if(sv==null){
				ImageCollection ic = CollectionServiceImpl.getInstance().getCollection(sr.getCollectionId());
				if(ic!=null && ic.getLevel()!=null){
					sv = 1000-ic.getLevel();
				}
				else{
					sv = firstSortValue++;
				}
			}
			else{
				sv += CID_NUM;
			}
			cidSortMap.put(sr.getCollectionId(), sv);
			sr.setRating(sv);
		}
		Collections.sort(list, new Comparator<SolrResult>() {
			@Override
			public int compare(SolrResult o1,
					SolrResult o2) {
				return o1.getRating() - o2.getRating();
			}
		});
		List<String> rstList = new ArrayList<String>();
		for(SolrResult sr : list){
			rstList.add(sr.getCorbisId());
		}
		return rstList;
	}
	
	public String getCidStr(){
		return this.cidStr;
	}
	
	public static void main(String[] args){
		System.out.println(Integer.MAX_VALUE/1000);
		
	}
}
