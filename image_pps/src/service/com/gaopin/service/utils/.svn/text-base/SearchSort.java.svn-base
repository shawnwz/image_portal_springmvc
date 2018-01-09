/* This file SearchSort.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gaopin.entity.CollectionSort;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.utils.KeyValue;

public class SearchSort {
	private Logger logger = Logger.getLogger(this.getClass());
	private List<KeyValue<String, Integer>> list;
	private CollectionService collectionService;
	
	public SearchSort(List<KeyValue<String, Integer>> list, CollectionService collectionService){
		this.list = list;
		this.collectionService = collectionService;
		
	}
	
	/**
	 * 根据图库等级排序
	 * @return
	 */
	public List<String> sort() {
		List<String> rst = new ArrayList<String>();
		List<String> badList = new ArrayList<String>();
		Map<Integer, LevelStore> cmap = new HashMap<Integer, LevelStore>();
		int maxLevel = 0; // 默认最高等级
		try {
			for (KeyValue<String, Integer> kv : list) {
				String id = kv.getKey();
				Integer cid = kv.getValue();
				CollectionSort sort = collectionService.getSortMap().get(cid);
				if (sort == null || sort.getScore() < 0 || sort.getLevel() < 0) {
					badList.add(id);
					continue;
				}
				if(sort.getLevel()>maxLevel){
					maxLevel = sort.getLevel();
				}
				LevelStore ls = cmap.get(sort.getLevel()); // 等级
				if (ls == null) {
					ls = new LevelStore();
					cmap.put(sort.getLevel(), ls);
				}

				ScoreStore ss = ls.getScoreStore(sort.getId()); // 评分
				if (ss == null) {
					ss = new ScoreStore(sort.getScore(), sort.getId());
					ls.add(ss);
				}
				ss.add(id);
			}

			for (int i = 1; i <= maxLevel; i++) {
				LevelStore ls = cmap.get(i);
				if (ls != null) {
					Collections.sort(ls.list, new Comparator<ScoreStore>() {
						@Override
						public int compare(ScoreStore o1, ScoreStore o2) {
							int rst = o2.score - o1.score;
							if (rst == 0) {
								rst = o2.collectionId - o1.collectionId;
							}
							return rst;
						}
					});
				}
			}
			
			// DEBUG--
//			for (int i = maxLevel; i > 0; i--) {
//				LevelStore ls = cmap.get(i);
//				if (ls == null) continue;
//				System.out.println("----------------------------------");
//				System.out.println("星级["+i+"]:");
//				for(ScoreStore ss : ls.list){
//					ImageCollection ic = collectionService.getCollection(ss.collectionId);
//					if(ic!=null){
//						System.out.println(ic.getShowName() + "["+ss.list.size()+"]");
//					}
//				}
//				System.out.println("----------------------------------");
//			}
			
			// 5*-1,5*-2,..4*-1,4*-2..
			for (int i = maxLevel; i > 0; i--) {
				LevelStore ls = cmap.get(i);
				if (ls == null) continue;
				String s = null;
				int count = 0;
				while((s=ls.get())!=null){
					rst.add(s.trim());
					count++;
					if(count>2000) break;
				}
			}
				 
			// 5*-1,4*-1,3*-1...
//			while (cmap.size() > 0) {
//				for (int i = 5; i > 0; i--) {
//					LevelStore ss = cmap.get(i);
//					if (ss == null)
//						continue;
//					String s = ss.get();
//					if (s != null) {
//						rst.add(s);
//					} else {
//						cmap.remove(i);
//					}
//				}
//				count++;
//				if (count > 2000) {
//					break;
//				}
//			}
			if (badList.size() > 0) {
				rst.addAll(badList);
			}
		} catch (Exception e) {
			logger.error("排序异常：", e);
			return null;
		}
		return rst;
	}
	
	private class LevelStore{
		public List<ScoreStore> list = new ArrayList<ScoreStore>();
		public int index = 0;
		public LevelStore(){
		}
		
		public String get(){
			if(list.size()==0) return null;
			if(index>=list.size()) index = 0;
			String s = list.get(index).get();
			if(s==null){
				list.remove(index);
				s = get();
			}
			else{
				index++;
			}
			return s;
		}
		
		public void add(ScoreStore s){
			list.add(s);
		}
		
		public ScoreStore getScoreStore(int collectionId){
			for(ScoreStore ss : list){
				if(ss.collectionId==collectionId) return ss;
			}
			return null;
		}
	}
	
	private class ScoreStore{
		public List<String> list = new ArrayList<String>();
		public int collectionId;
		public int score;
		public ScoreStore(int score, int collectionId){
			this.score = score;
			this.collectionId = collectionId;
		}
		
		public void add(String s){
			list.add(s);
		}
		
		public String get(){
			if(list.size()>0) {
				String s = list.get(0);
				list.remove(0);
				return s;
			}
			return null;
		}
	}
	
}
