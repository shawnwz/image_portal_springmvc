/* This file ImageGroupServiceImpl.java is part of image_pps .
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
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.entity.ImageGroup;
import com.gaopin.entity.ImageGroupImage;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.ImagePartialSets;
import com.gaopin.entity.ImageSets;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.utils.CacheKeyUtils;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
@Service("imageGroupService")
public class ImageGroupServiceImpl extends BaseServiceImpl implements
		ImageGroupService {

	@Resource
	private CacheService cacheService;
	@Resource
	private SearchService searchService;
	
	@Override
	public List<Integer> getImageGroupIdList(String corbisId) {
		List<ImageGroupImage> list = controller.findBy(ImageGroupImage.class, "imageId", corbisId);
		List<Integer> groupIdList = new ArrayList<Integer>();
		for(ImageGroupImage igi : list){
			groupIdList.add(igi.getImageGroupId());
		}
		return groupIdList;
	}
	@Override
	public List<ImageGroupImage> getImageGroupList(String corbisId) {
		List<ImageGroupImage> list = controller.findBy(ImageGroupImage.class, "imageId", corbisId);
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getImageGroupImageList(Integer imageGroupId) {
		String cacheKey = CacheKeyUtils.getEntityListKey(ImageGroupImage.class, imageGroupId);
		List<String> list = null;
		try{
			list = (List<String>)cacheService.getRemote(cacheKey);
			if(list==null){ // 查询数据库
				List<ImageGroupImage> igiList = controller.findBy(ImageGroupImage.class, "imageGroupId", imageGroupId);
				list = new ArrayList<String>();
				for(ImageGroupImage igi : igiList){
					list.add(igi.getImageId());
				}
				cacheService.putRemote(cacheKey, list, Constants.CACHE_DAY_TIMES);
			}
		}
		catch (Exception e) {
			logger.error("获取图库图片列表异常[groupId="+imageGroupId+"]：", e);
		}
		return list!=null ? list:new ArrayList<String>();
	}

	@Override
	public ImageGroup getImageGroup(Integer id) {
		if(id==null) return null;
		String cacheKey = CacheKeyUtils.getEntityKey(ImageGroup.class, id);
		try{
			ImageGroup imageGroup = (ImageGroup)cacheService.getRemote(cacheKey);
			if(imageGroup==null){
				imageGroup = get(ImageGroup.class, id);
				if(imageGroup!=null){
					if(imageGroup.getStatus()==null || imageGroup.getStatus()!=Constants.CommonStatus.ENABLE.ordinal()){
						return null;
					}
					cacheService.putRemote(cacheKey, imageGroup, Constants.CACHE_DAY_TIMES);
				}
			}
			return imageGroup;
		}
		catch (Exception e) {
			logger.error("获取图片组对象异常[id="+id+"]：", e);
		}
		return null;
	}
	
	@Override
	public ImageGroup getImageGroupByCode(String code) {
		if(StrUtils.isBlank(code)) return null;
		String cacheKey = CacheKeyUtils.getGroupByCodeKey(code);
		try{
			ImageGroup imageGroup = (ImageGroup)cacheService.getRemote(cacheKey);
			if(imageGroup==null){
				imageGroup = getController().findUniqueBy(ImageGroup.class, "code", code);
				if(imageGroup!=null){
					if(imageGroup.getStatus()==null || imageGroup.getStatus()!=Constants.CommonStatus.ENABLE.ordinal()){
						return null;
					}
					cacheService.putRemote(cacheKey, imageGroup, Constants.CACHE_FOREVER_TIMES);
				}
			}
			return imageGroup;
		}
		catch (Exception e) {
			logger.error("根据CODE获取图片组对象异常[code="+code+"]：", e);
		}
		return null;
	}
	
	public List<ImageGroup> getImageGroupsByCategoryId(int categoryId, int pageNo, int pageSize){
		Collection<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("categoryId", categoryId, CompareType.Equal));
		expressions.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
		List<ImageGroup> list = getController().findBy(ImageGroup.class, pageNo-1, pageSize, "id", false, expressions);
		return list;
	}
	
	public long getImageGroupCountByCategoryId(int categoryId){
		Collection<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("categoryId", categoryId, CompareType.Equal));
		expressions.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
		return getController().getResultCount(ImageGroup.class, expressions);
	}
	
	public Map<String, Object> getGroupsByCategoryId(HttpServletRequest request, int categoryId, int pageNo, int pageSize){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		long count = getImageGroupCountByCategoryId(categoryId);
		List<ImageGroup> groupList = new ArrayList<ImageGroup>();
		if(count>0){
			groupList = getImageGroupsByCategoryId(categoryId, pageNo, pageSize);
		}
		List<PreviewImageInfo> rstList = new ArrayList<PreviewImageInfo>();
		for(ImageGroup imageGroup : groupList){
			PreviewImageInfo previewImageInfo = new PreviewImageInfo();
			previewImageInfo.setCorbisId(""+imageGroup.getId());
			previewImageInfo.setTitle(imageGroup.getName());
		}
		
		return rstMap;
	}
	
	public Map<String, Object> getImagesByCode(HttpServletRequest request, String code, int pageNo, int pageSize){
		
		if(StrUtils.isBlank(code)){
			return new HashMap<String, Object>();
		}
		ImageGroup imageGroup = getImageGroupByCode(code);
		if(imageGroup==null){
			return new HashMap<String, Object>();
		}
		Map<String, Object> rstMap= getImagesByGroup(request, imageGroup, pageNo, pageSize);
		
	    ImageInfo imageInfo = searchService.getImageInfoByCorbisId(code);
		rstMap.put("groupName", imageInfo.getTitle());
		rstMap.put("groupId", code);
		return rstMap;
	}
	
	/**
	 * 根据图片组ID显示图片组结果列表
	 */
	public Map<String, Object> getImagesByGroup(HttpServletRequest request, int imageGroupId, int pageNo, int pageSize){
		if(imageGroupId<=0){
			return new HashMap<String, Object>();
		}
		ImageGroup imageGroup = getImageGroup(imageGroupId);
		if(imageGroup==null){
			return new HashMap<String, Object>();
		}
		return getImagesByGroup(request, imageGroup, pageNo, pageSize);
	}
	
	
	public Map<String, Object> getImagesByGroup(HttpServletRequest request, ImageGroup imageGroup, int pageNo, int pageSize){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		
		// 读取图片组数据
		int offset = (pageNo-1)*pageSize;
		List<String> list = getImageGroupImageList(imageGroup.getId());
		List<PreviewImageInfo> rstList = null;
		if(SearchUtils.isSplashId(imageGroup.getCode())){
			rstList = searchService.getPreviewListBySplash(SearchUtils.getSubList(list, offset, pageSize), imageGroup.getCode());
		}
		else{
			rstList = searchService.getPreviewList(SearchUtils.getSubList(list, offset, pageSize));
		}
		
		if(imageGroup!=null){
			rstMap.put("groupName", imageGroup.getGaopin_name());
			rstMap.put("groupId", imageGroup.getId());
			rstMap.put("groupIntro", imageGroup.getGaopin_intro());
			if(imageGroup.getCreateTime()!=null){
				rstMap.put("createTime", DateUtils.getYMD(imageGroup.getCreateTime()));
			}
			if(StrUtils.isNotBlank(imageGroup.getPhotographerName())){
				rstMap.put("photographer", imageGroup.getPhotographerName());
			}
		}
		rstMap.put("success", true);
		rstMap.put("total", list.size());
		rstMap.put("data", rstList);
		rstMap.put("totalPages", SearchUtils.getTotalPages(list.size(), pageSize));
		rstMap.put("currentPage", pageNo);
		return rstMap;
	}

	@Override
	public List<ImagePartialSets> getImagePartialSets(Integer[] ids) {
		List<ImagePartialSets> list=new ArrayList<ImagePartialSets>();
		for (Integer id :ids){
			ImagePartialSets itemImagePartialSets=getImagePartialSets(id);
			if(itemImagePartialSets!=null)
				list.add(itemImagePartialSets);
		}
		return list;
	}

	@Override
	public ImagePartialSets getImagePartialSets(Integer id) {
		if(id==null) return null;
		String cacheKey = CacheKeyUtils.getEntityKey(ImagePartialSets.class, id);
		try{
			ImagePartialSets imageGroup = (ImagePartialSets)cacheService.getRemote(cacheKey);
			if(imageGroup==null){
				imageGroup = get(ImagePartialSets.class, id);
				if(imageGroup!=null){
					cacheService.putRemote(cacheKey, imageGroup, Constants.CACHE_DAY_TIMES);
				}
			}
			return imageGroup;
		}
		catch (Exception e) {
			logger.error("获取图片组对象异常[id="+id+"]：", e);
		}
		return null;
	}

	@Override
	public List<ImageSets> getImageSets() {
		List<ImageSets> variables = (List<ImageSets>)cacheService.getLocalLong(ImageSets.class.getName()+"all");
		if(variables==null){
			variables =  controller.loadAll(ImageSets.class);
			if(variables!=null){
				cacheService.putLocalLong(ImageSets.class.getName()+"all", variables);
			}
		}
		return variables;
	}

	@Override
	public List<ImageGroup> getImageGroupByCatalog(Integer catalogid) {

		if(catalogid==null) return null;
		String cacheKey = CacheKeyUtils.getEntityListKey(ImageGroup.class, "catalogid", catalogid);
		try{
			List<ImageGroup> imageGroup = (List<ImageGroup>)cacheService.getRemote(cacheKey);
			if(imageGroup==null){
				imageGroup = super.getController().findBy(ImageGroup.class, "categoryId", catalogid, "updateTime", false);
				if(imageGroup!=null){
					cacheService.putRemote(cacheKey, imageGroup, Constants.CACHE_DAY_TIMES);
				}
			}
			return imageGroup;
		}
		catch (Exception e) {
			logger.error("获取图片组列表异常[catalogid="+catalogid+"]：", e);
		}
		return null;
		
	}

	@Override
	public List<ImageGroup> getImageGroups(Integer[] ids) {
		List<ImageGroup> ret=new ArrayList<ImageGroup>();
		for (Integer id : ids) {
			ret.add(getImageGroup(id));
		}
		return ret;
	}
	@Override
	public List<ImageGroup> getImageGroups(String[] ids) {
		List<Integer> ret=new ArrayList<Integer>();
		for (String id : ids) {
			ret.add(Integer.parseInt(id));
		}
		return getImageGroups(ret.toArray(new Integer[]{}));
	}
	
	
	@Override
	public String getImageGroupAmount(Integer imageGroupId) {
		//String cacheKey = CacheKeyUtils.getEntityListKey(ImageGroup.class, imageGroupId);
		//List<String> list = null;
		if (imageGroupId==null) return null;
		String cacheKey = CacheKeyUtils.getEntityListKey(ImageGroup.class, "id", imageGroupId);
		try{
			List<ImageGroup> imageGroup = (List<ImageGroup>)cacheService.getRemote(cacheKey);
			if(imageGroup==null){
				imageGroup = super.getController().findBy(ImageGroup.class, "id", imageGroupId, "updateTime", false);
				if(imageGroup!=null){
					cacheService.putRemote(cacheKey, imageGroup, Constants.CACHE_DAY_TIMES);
				}
			}
			ImageGroup ig = imageGroup.get(0);
			String number = String.valueOf(ig.getNum());
			return number;
		}
		catch (Exception e) {
			logger.error("获取图片组中图片数量异常[groupid="+imageGroupId+"]：", e);
		}
		return null;

	}
	
}
