/* This file BaseServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.frame.HibernateGenericController;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.BaseService;
import com.gaopin.utils.CacheKeyUtils;
@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	protected String DefaultRegion = "110000";//北京
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	protected HibernateGenericController controller;
	@Resource
	protected CacheService cacheService;
	
	@Override
	public <T> T get(Class<T> clasz, Serializable id) {
		return controller.get(clasz, id);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getByLocalCache(Class<T> clasz, Serializable id){
		if(id==null) return null;
		String key = CacheKeyUtils.getEntityKey(clasz, id);
		T t = null;
		try{
			t = (T)cacheService.getLocalLong(key);
		}
		catch (Exception e) {
			logger.error("从缓存查询异常[key="+key+"]：", e);
		}
		if(t==null){
			t = get(clasz, id);
			if(t!=null){
				cacheService.putLocalLong(key, t);
			}
		}
		return t;
	}
 
	@Override
	public Serializable saveObject(Object entity) {
		return controller.save(entity);
	}

	@Override
	public void updateObject(Object entity) {
		controller.update(entity);
	}
	
	@Override
	public void deleteObject(Object entity) {
		controller.delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getList(Class<T> clasz, int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions) {
		return (List<T>)controller.findBy(clasz, pageNo, pageSize, orderBy, isAsc, expressions);
	}

	@Override
	public long getCount(Class<?> clasz,
			Collection<HibernateExpression> expressions) {
		Long count = controller.getResultCount(clasz, expressions);
		return count==null ? 0L : count.longValue();
	}

	@Override
	public HibernateGenericController getController() {
		return controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T>List<T> getList(Class<T> clasz, Collection<HibernateExpression> expressions) {
		return (List<T>)controller.findBy(clasz, expressions);
	}

	@Override
	public Object formBefore(HttpServletRequest request, Object entity) {
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public Object formAfter(HttpServletRequest request, Object entity) {
		// TODO Auto-generated method stub
		return entity;
	}
	
	
}
