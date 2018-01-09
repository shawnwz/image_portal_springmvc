/* This file BottomPageServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.entity.FlowJoinUs;
import com.gaopin.entity.FlowNews;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.frame.hibernate.LikeWithExpression;
import com.gaopin.frame.hibernate.LikeWithType;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.BottomPageService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.CacheKeyUtils;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.StrUtils;

@Service("bottomPageService")
public class BottomPageServiceImpl extends BaseServiceImpl implements
		BottomPageService {

	private static BottomPageService instance = null;
	@Resource
	private VariablesService variablesService;
	@Resource
	private CacheService cacheService;

	public List<FlowJoinUs> getCareers() {
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowJoinUs.class, 0);
		List<FlowJoinUs> list=new ArrayList<FlowJoinUs>();
		try {
			logger.info("get info from mc "+cacheKey);
			list = (List<FlowJoinUs>)cacheService.getRemote(cacheKey);
			if(list==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				expressions.add(new CompareExpression("id",0,CompareType.NotEqual));
				list= getList(FlowJoinUs.class,0,10000,"sortId",false, expressions);
				if(list!=null){
					if(list.size()==0){
						return null;
					}
					cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
				}
			}
			return list;
		} catch (Exception e) {
			logger.error("getTopList() ", e);
		}
		return list;
	}


	public Integer GetNewsCount(String type) {
		int pageSize=5;
		//type可能为"", 但不能为null . 
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowNews.class,type+"_count", 0);
		
		Integer count=0;
		try {
			count = (Integer)cacheService.getRemote(cacheKey);
			if(count==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				if(StrUtils.isNotBlank(type))
					expressions.add(new LikeWithExpression("label", type, LikeWithType.LikeAnyWhere));
				count=(int)getCount(FlowNews.class, expressions);
					if(count!=null){
						cacheService.putRemote(cacheKey, count, Constants.CACHE_HOUR_TIMES);
						return count;
					}
			}
			return count;
		} catch (Exception e) {
			logger.error("GetNewsCount() ", e);
		}
		return count;
	}
	
	
	public List<FlowNews> GetNews(int p, String type) {
		int pageSize=5;
		if(p<1) p=1;
		//type可能为"", 但不能为null . 
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowNews.class,type+"_"+p, 0);
		
		List<FlowNews> list=new ArrayList<FlowNews>();
		try {
			list = (List<FlowNews>)cacheService.getRemote(cacheKey);
			if(list==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				if(StrUtils.isNotBlank(type))
					expressions.add(new LikeWithExpression("label", type, LikeWithType.LikeAnyWhere));
				list= getList(FlowNews.class,(p-1),5,"flowSeq",false, expressions);
					if(list!=null){
						if(list.size()==0){
							return null;
						}
						for (FlowNews n : list) {
							n.setPublishTimeStr10(DateUtils.getDatestr(n.getPublishTime(), DateUtils.ymdSdf));
							n.setPublishTimeStr16(DateUtils.getDatestr(n.getPublishTime(), DateUtils.ymdhmSdf));
						}
						
						cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
						return list;
					}
			}
			return list;
		} catch (Exception e) {
			logger.error("GetNews() ", e);
		}
		return list;
	}
	

	public List<FlowNews> GetNewsByTime(int p, String type) {
		int pageSize=5;
		if(p<1) p=1;
		//type可能为"", 但不能为null . 
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowNews.class,type+"_time"+p, 0);
		
		List<FlowNews> list=new ArrayList<FlowNews>();
		try {
			list = (List<FlowNews>)cacheService.getRemote(cacheKey);
			if(list==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				if(StrUtils.isNotBlank(type))
					expressions.add(new LikeWithExpression("label", type, LikeWithType.LikeAnyWhere));
				list= getList(FlowNews.class,(p-1),5,"id",false, expressions);
					if(list!=null){
						if(list.size()==0){
							return null;
						}
						for (FlowNews n : list) {
							n.setPublishTimeStr10(DateUtils.getDatestr(n.getPublishTime(), DateUtils.ymdSdf));
							n.setPublishTimeStr16(DateUtils.getDatestr(n.getPublishTime(), DateUtils.ymdhmSdf));
						}
						
						cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
						return list;
					}
			}
			return list;
		} catch (Exception e) {
			logger.error("GetNews() ", e);
		}
		return list;
	}
	

	public List<Integer> GetNewsIds(String type) {
		//type可能为"", 但不能为null . 
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowNews.class,type+"_ids", 0);
		List<Integer> list=new ArrayList<Integer>();
		try {
			list = (List<Integer>)cacheService.getRemote(cacheKey);
			if(list==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				if(StrUtils.isNotBlank(type))
					expressions.add(new LikeWithExpression("label", type, LikeWithType.LikeAnyWhere));
				List<FlowNews> items= getList(FlowNews.class,0,10000,"flowSeq",false, expressions);
					if(items!=null){
						if(items.size()==0){
							return null;
						}
						list=new ArrayList<Integer>();
						for (FlowNews item : items) {
							list.add(item.getId());
						}
						cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
						return list;
					}
			}
			return list;
		} catch (Exception e) {
			logger.error("GetNews() ", e);
		}
		return list;
	}
	public FlowNews GetNewsById(int id){
		String cacheKey = CacheKeyUtils.getEntityKey(FlowNews.class,id);
		FlowNews item=null;
		try {
			item = (FlowNews)cacheService.getRemote(cacheKey);
			if(item==null){
				item= get(FlowNews.class, id);
					if(item!=null){
						item.setPublishTimeStr10(DateUtils.getDatestr(item.getPublishTime(), DateUtils.ymdSdf));
						item.setPublishTimeStr16(DateUtils.getDatestr(item.getPublishTime(), DateUtils.ymdhmSdf));
						
						cacheService.putRemote(cacheKey, item, Constants.CACHE_HOUR_TIMES);
						return item;
					}
			}
			return item;
		} catch (Exception e) {
			logger.error("GetNewsById() ", e);
		}
		return item;
		
		
	}

}
