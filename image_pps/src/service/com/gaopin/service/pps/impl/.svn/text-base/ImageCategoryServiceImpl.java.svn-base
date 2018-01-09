/* This file ImageCategoryServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gaopin.constants.Constants;
import com.gaopin.entity.ImageCategory;
import com.gaopin.entity.IndexMenu;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.ImageCategoryService;
import com.gaopin.service.pps.IndexPageService;
import com.gaopin.utils.KeyValue;
import com.gaopin.utils.StrUtils;

@Service("imageCategoryService")
public class ImageCategoryServiceImpl extends BaseServiceImpl implements
		ImageCategoryService {
@Resource
private IndexPageService indexPageService;
	
	@Override
	public ImageCategory get(Integer id) {
		if(id==null) return null;
		
		String key = ImageCategory.class.getName()+"_id"+id;
		ImageCategory category = null;
		try{
			category = (ImageCategory)cacheService.getRemote(key);
		}catch (Exception e) {
		}
		if(category==null){
			category = controller.get(ImageCategory.class, id);
			if(category!=null){
				cacheService.putRemote(key, category, Constants.CACHE_DEFAULT_TIMES);
			}
		}
		return category;
	}

	@Override
	public ImageCategory getByName(String name) {
		if(StrUtils.isBlank(name)) return null;
		
		String key = ImageCategory.class.getName()+"_"+name;
		ImageCategory category = null;
		try{
			category = (ImageCategory)cacheService.getRemote(key);
		}catch (Exception e) {
		}
		if(category==null){
			category = loadByName(name);
			if(category!=null){
				cacheService.putRemote(key, category, Constants.CACHE_DEFAULT_TIMES);
			}
		}
		return category;
	}

	@Override
	public ImageCategory load(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageCategory loadByName(String name) {
		ImageCategory category = controller.findUniqueBy(ImageCategory.class, "name", name);
		return category;
	}

	@Override
	public ImageCategory getOrCreateByName(String name) {
		if(StrUtils.isBlank(name)) return null;
		ImageCategory category = getByName(name);
		if(category==null){
			category = new ImageCategory();
			category.setName(name);
			category.setEnName(name);
			category.setIsPrimary(true);
			category.setCreateTime(new Date());
			saveObject(category);
			cacheService.putRemote(ImageCategory.class.getName()+"_"+name, category, Constants.CACHE_DEFAULT_TIMES);
		}
		return category;
	}

	
	private Integer getIndexMenuId(Integer categoryId){
		List<IndexMenu> indexMenuList = controller.getAll(IndexMenu.class);
		 
		for(IndexMenu indexMenu : indexMenuList)
		{
			if(indexMenu.getCategoryIds() !="" && indexMenu.getCategoryIds()!=null)
			{
				String[] categoryIds = indexMenu.getCategoryIds().split(",");
				for(int i = 0;i<categoryIds.length;i++)
				{
					if(categoryIds[i]==""+categoryId)
					{
						return indexMenu.getId();
					}
				}
			}
		}
		return -1; 
	}

	@Override
	public IndexMenu GetIndexMenu(Integer categoryid) {
		
		String key = ImageCategory.class.getName()+"_GetIndexMenuId_"+categoryid;
		Integer ret = null;
		try{
			ret = (Integer)cacheService.getRemote(key);
		}catch (Exception e) {
		}
		if(ret==null){
			ret = getIndexMenuId(categoryid);
			if(ret!=null&&ret.intValue()>0){
				cacheService.putRemote(key, ret, Constants.CACHE_DAY_TIMES);
			}
		}
		if((ret==null)||ret.intValue()<=0)
			return indexPageService.IndexMenu(1);
		///////////////////////////////////////////////
		IndexMenu menu=indexPageService.IndexMenu(ret);
		return menu;
		
	}
}
