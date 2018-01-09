/* This file PhotographerServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.entity.Photographer;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.PhotographerService;
import com.gaopin.utils.CacheKeyUtils;

@Service("photographerService")
public class PhotographerServiceImpl extends BaseServiceImpl implements
		PhotographerService {

	
	@Resource
	private CacheService cacheService;
	
	
/*remove mc logical . 
 * String key=CacheKeyUtils.getEntityKey(Photographer.class, id);
 * String key=CacheKeyUtils.getEntityListKey(Photographer.class,"getByName_"+name,0);  name=item.getName();
 * String key=CacheKeyUtils.getEntityListKey(Photographer.class,"getByNameOrShowName_"+name,0);   name=item.getName()  item.getShowName();
 * 举例:{id:1,name:"sys",show_name:"sysshowname"}==〉{id:1,name:"sys1",show_name:"sysshowname1"}
 * CacheKeyUtils.getEntityKey(Photographer.class, 1);
 * CacheKeyUtils.getEntityListKey(Photographer.class,"getByName_"+"sys",0);
 * CacheKeyUtils.getEntityListKey(Photographer.class,"getByName_"+"sys1",0);
 * CacheKeyUtils.getEntityListKey(Photographer.class,"getByNameOrShowName_"+"sys",0);
 * CacheKeyUtils.getEntityListKey(Photographer.class,"getByNameOrShowName_"+"sys1",0);
 * CacheKeyUtils.getEntityListKey(Photographer.class,"getByNameOrShowName_"+"sysshowname",0);
 * CacheKeyUtils.getEntityListKey(Photographer.class,"getByNameOrShowName_"+"sysshowname1",0);
 * 
 * 
 * */
	
	@Override
	public Photographer get(Integer id) {
		String key=CacheKeyUtils.getEntityKey(Photographer.class, id);
		if(id==null) return null;
		Photographer photographer = null;
		try{
			photographer = (Photographer)cacheService.getRemote(key);
			if(photographer==null){
				photographer = get(Photographer.class, id);
				if(photographer!=null){
					cacheService.putRemote(key, photographer, Constants.CACHE_HOUR_TIMES);
				}
			}
		}
		catch (Exception e) {
			logger.error("获取摄影师异常[id="+id+"]：", e);
		}
		return photographer;
	}
	
	@Override
	public Photographer getByName(String name)
	{
		String key=CacheKeyUtils.getEntityListKey(Photographer.class,"getByName_"+name,0);
		Photographer photographer = null;
		try{
			photographer = (Photographer)cacheService.getRemote(key);
			if(photographer==null){
				Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
				CompareExpression comex=new CompareExpression("name", name, CompareType.Equal);
				coll.add(comex);
				List<Photographer> list=controller.findBy(Photographer.class,coll);
				if(list!=null&&list.size()>0)
					photographer= list.get(0);
				if(photographer!=null){
					cacheService.putRemote(key, photographer, Constants.CACHE_HOUR_TIMES);
				}
			}
		}
		catch (Exception e) {
			logger.error("获取摄影师异常[name="+name+"]：", e);
		}
		return photographer;
	}
	@Override
	public Photographer getByNameOrShowName(String name)
	{
		String key=CacheKeyUtils.getEntityListKey(Photographer.class,"getByNameOrShowName_"+name,0);
		Photographer photographer = null;
		try{
			photographer = (Photographer)cacheService.getRemote(key);
			if(photographer==null){
				name=name.trim();
				String hsql="from Photographer where name='"+name +"' or showName='"+name+"'";
				List<Photographer> list=controller.findListByHql(hsql);
				if(list!=null&&list.size()>0)
					photographer= list.get(0);
				if(photographer!=null){
					cacheService.putRemote(key, photographer, Constants.CACHE_HOUR_TIMES);
				}
			}
		}
		catch (Exception e) {
			logger.error("获取摄影师异常[name="+name+"]：", e);
		}
		return photographer;
	}

}
