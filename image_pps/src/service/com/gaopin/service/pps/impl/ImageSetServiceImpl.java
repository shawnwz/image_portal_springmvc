/* This file ImageSetServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.constants.Constants.SizeType;
import com.gaopin.entity.FlowImageset;
import com.gaopin.entity.FlowImagesetSub;
import com.gaopin.entity.ImageGroup;
import com.gaopin.entity.ImageGroupImage;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.ImagePartialSets;
import com.gaopin.entity.ImageSets;
import com.gaopin.entity.Photographer;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.ImageSetService;
import com.gaopin.service.pps.PhotographerService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.utils.CacheKeyUtils;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
@Service("imageSetService")
public class ImageSetServiceImpl extends BaseServiceImpl implements
		ImageSetService {

	@Resource
	private CacheService cacheService;
	@Resource
	private SearchService searchService;
	@Resource
	private  PhotographerService photographerService;
	@Override
	public void cleanCache()
	{
		logger.info("ImageSetServiceImpl.cleanCache 清理图片专题相关mc. ");
		List<FlowImageset> list= getController().loadAll(FlowImageset.class);
		int count=list.size();
		int tp=count/Constants.imageSet_PageSize+((count%Constants.imageSet_PageSize==0)?0:1);
		int n=Constants.imageSet_PageSize;
		for (int i = 0; i <=tp; i++) {
			n=Constants.imageSet_PageSize;
			cacheService.removeRemote(CacheKeyUtils.getEntityListKey(FlowImageset.class,i+"_"+n));
			//目前为止只有pagesize和1000的，没有其他 值. 
			n=1000;
			cacheService.removeRemote(CacheKeyUtils.getEntityListKey(FlowImageset.class,i+"_"+n));
		}
		
		for (FlowImageset flowImageset : list) {
			cacheService.removeRemote(CacheKeyUtils.getEntityListKey(FlowImagesetSub.class, "FlowImagesetSub",flowImageset.getId()));
			cacheService.removeRemote(CacheKeyUtils.getEntityKey(FlowImageset.class, flowImageset.getId()));
		}
		List<FlowImagesetSub> list2= getController().loadAll(FlowImagesetSub.class);
		for (FlowImagesetSub flowImagesetSub : list2) {
			cacheService.removeRemote(CacheKeyUtils.getEntityKey(FlowImagesetSub.class, flowImagesetSub.getId()));
			cacheService.removeRemote(CacheKeyUtils.getEntityListKey(PreviewImageInfo.class, "FlowImagesetSubPreviews",flowImagesetSub.getId()));
		
		}
		
		
	}
	
	public int getTopCount() {
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowImageset.class, 0);
		try{
			Integer list = (Integer)cacheService.getRemote(cacheKey);
			if(list==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				expressions.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
				list= (int)getCount(FlowImageset.class,expressions);
				if(list!=null){
					cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
				}
			}
			return list;
		}
		catch (Exception e) {
			logger.error("getTopList() ", e);
		}
		return 0;
	}
	
	@Override
	public List<FlowImageset> getTopList(int p,int n) {
		if(n<=0) n=Constants.imageSet_PageSize;
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowImageset.class, p+"_"+n);
		try{
			List<FlowImageset> list = (List<FlowImageset>)cacheService.getRemote(cacheKey);
			if(list==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				expressions.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
				list= getList(FlowImageset.class,p-1,Constants.imageSet_PageSize,"id",false, expressions);
				if(list!=null){
					if(list.size()==0){
						return null;
					}
					cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
				}
			}
			return list;
		}
		catch (Exception e) {
			logger.error("getTopList() ", e);
		}
		return null;
	}
	
	public Map<Integer,List<FlowImagesetSub> > getTopMap(int p,int n) {
		List<FlowImageset> list=getTopList(p,n);
		try {
			
		Map<Integer,List<FlowImagesetSub> > map=new HashMap<Integer, List<FlowImagesetSub>>();
		for (FlowImageset flowImageset : list) {
			map.put(flowImageset.getId(), getSubList(flowImageset.getId()));
		}
		return map;

		} catch (Exception e) {
			logger.error("getTopMap() ", e);
		}
		return null;
	}
	
	
	@Override
	public List<FlowImagesetSub> getSubList(Integer topid) {
		String cacheKey = CacheKeyUtils.getEntityListKey(FlowImagesetSub.class, "FlowImagesetSub",topid);
		
		try{
			List<FlowImagesetSub> list = (List<FlowImagesetSub>)cacheService.getRemote(cacheKey);
			if(list==null){
				List<HibernateExpression> expressions=new ArrayList<HibernateExpression>();
				expressions.add(new CompareExpression("imagesetId", topid, CompareType.Equal));
				expressions.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
				list= getList(FlowImagesetSub.class, 0, 1000, "seq", false, expressions);
				if(list!=null){
					if(list.size()==0){
						return null;
					}
					cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
				}
			}
			return list;
		}
		catch (Exception e) {
			logger.error("getSubList() ", e);
		}

		return null;
	}
	@Override
	public FlowImageset getTopItem(Integer id) {
		String cacheKey =CacheKeyUtils.getEntityKey(FlowImageset.class, id);
		try{
			FlowImageset list = (FlowImageset)cacheService.getRemote(cacheKey);
			if(list==null){
				list= get(FlowImageset.class, id);
				if(list!=null){
					if(list.getStatus()!=Constants.CommonStatus.ENABLE.ordinal()){
						return null;
					}
					cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
				}
			}
			return list;
		}
		catch (Exception e) {
			logger.error("getTopList() ", e);
		}

		return null;
	}
	
	@Override
	public FlowImagesetSub getItem(Integer id) {
		String cacheKey =CacheKeyUtils.getEntityKey(FlowImagesetSub.class, id);
		try{
			FlowImagesetSub list = (FlowImagesetSub)cacheService.getRemote(cacheKey);
			if(list==null){
				list= get(FlowImagesetSub.class, id);
				if(list!=null){
					if(list.getStatus()!=Constants.CommonStatus.ENABLE.ordinal()){
						return null;
					}
					cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
				}
			}
			return list;
		}
		catch (Exception e) {
			logger.error("getTopList() ", e);
		}

		return null;
	}
	
	
	public boolean checkImages(Integer subid,String gaopinId)
	{
		FlowImagesetSub item= getItem(subid);
		if(item.getImgList()==null||StrUtils.isBlank(item.getImgList()))
			return false;
		String[] cids=item.getImgList().split(",");
		for (String string : cids) {
			if(string.equals(gaopinId))
				return true;
		}
		return false;
	}
	@Override
	public List<PreviewImageInfo> getImages(Integer subid) {

		String cacheKey = CacheKeyUtils.getEntityListKey(PreviewImageInfo.class, "FlowImagesetSubPreviews",subid);
		FlowImagesetSub item= getItem(subid);
		if(item.getImgList()==null||StrUtils.isBlank(item.getImgList()))
			return null;
		String[] cids=item.getImgList().split(",");
		try{
			List<PreviewImageInfo> list = (List<PreviewImageInfo>)cacheService.getRemote(cacheKey);
			if(list==null){
				list= searchService.getPreviewListByCorbisIds(cids);
				
				if(list!=null){
					if(list.size()==0){
						return null;
					}
					for (PreviewImageInfo previewImageInfo : list) {
						if(previewImageInfo.getPhotographerId()!=null&&previewImageInfo.getPhotographerId()>0)
						{
						Photographer ph=photographerService.get(previewImageInfo.getPhotographerId());
						if(ph!=null&&StrUtils.isNotBlank(ph.getName()))
							previewImageInfo.setPhotographerName(ph.getName());
						}
					}
					cacheService.putRemote(cacheKey, list, Constants.CACHE_HOUR_TIMES);
				}
			}
			return list;
		}
		catch (Exception e) {
			logger.error("getTopList() ", e);
		}
		return null;
	}
	

}
