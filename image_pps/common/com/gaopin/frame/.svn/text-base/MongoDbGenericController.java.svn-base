/* This file MongoDbGenericController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.frame;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.gaopin.utils.StrUtils;


public class MongoDbGenericController {
	
	private MongoTemplate template;

	public MongoTemplate getTemplate() {
		return template;
	}

	public void setTemplate(MongoTemplate template) {
		this.template = template;
	}
	
	public <T> T findOne(Class<T> clasz, String name, Object value){
		return template.findOne(new Query(Criteria.where(name).is(value)), clasz);
	}
	
	public <T> List<T> findList(Class<T> clasz, String key, Object value, String sortName, boolean isAsc, int pageNo, int pageSize){
		Query query =  new Query();
		if(StrUtils.isNotBlank(key)){
			query.addCriteria(new Criteria(key).is(value));
		}
		if(StrUtils.isNotBlank(sortName)){
			query.sort().on(sortName, isAsc ? Order.ASCENDING:Order.DESCENDING);
		}
		if(pageNo<0) pageNo = 0;
		query.skip(pageNo*pageSize).limit(pageSize);
		
		List<T> list = template.find(query, clasz);
		return list;
	}
	
	public long getCount(Class<?> clasz, String key, Object value){
		Query query =  new Query();
		if(StrUtils.isNotBlank(key)){
			query.addCriteria(new Criteria(key).is(value));
		}
		return template.count(query, clasz);
	}
	
	public void save(Object entity) {
		template.save(entity);
	}
	
	public void update(Object entity, Update update, String key, Object value){
		Query queryUpdate = new Query();  
		queryUpdate.addCriteria(new Criteria(key).is(value));
		template.updateFirst(queryUpdate, update,entity.getClass());
	}
	
	public void remove(Object entity){
		template.remove(entity);
	}
	
	public static void main(String[] args){
		
 
	}
	
}
