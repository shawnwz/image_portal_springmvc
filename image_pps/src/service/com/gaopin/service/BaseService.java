/* This file BaseService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gaopin.frame.HibernateGenericController;
import com.gaopin.frame.hibernate.HibernateExpression;

public interface BaseService {
	
	public HibernateGenericController getController();
	
	public <T> T get(Class<T> clasz, Serializable id);
	
	public <T> T getByLocalCache(Class<T> clasz, Serializable id);
	
	public <T> List<T> getList(Class<T> clasz, int pageNo, int pageSize,
			String orderBy, boolean isAsc,
			Collection<HibernateExpression> expressions);

	public long getCount(Class<?> clasz, Collection<HibernateExpression> expressions);
	
	public Serializable saveObject(Object entity);
	
	public void updateObject(Object entity);
	
	public void deleteObject(Object entity);
	
	public <T>List<T> getList(Class<T> clasz, Collection<HibernateExpression> expressions);

	/**
	 * 添加或更新entity前后调用的方法
	 * @return
	 */
	public Object formBefore(HttpServletRequest request, Object entity);
	public Object formAfter(HttpServletRequest request, Object entity);
}
