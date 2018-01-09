/* This file SearchServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.ImageGroup;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.SearchResult;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.frame.hibernate.InExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.utils.BeanUtils;
import com.gaopin.utils.HttpClientHelper;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.utils.RequestUtils;
@Service("searchService")
public class SearchServiceImpl extends BaseServiceImpl implements SearchService {

	@Resource
	private CacheService cacheService;
	@Resource
	private CollectionService collectionService;
	@Resource
	private ImageGroupService imageGroupService;
	
	@Override
	public List<PreviewImageInfo> getPreviewListSplashEnable(List<String> corbisids)
	{
		
		List<PreviewImageInfo> rstList = new ArrayList<PreviewImageInfo>();
		List<PreviewImageInfo> list0=getPreviewList(corbisids);
		Map<String, List<String>> map= SearchUtils.GetSplashMap(corbisids);
		
		if(map.size()==0)
			return list0;
		List<PreviewImageInfo> list1=new ArrayList<PreviewImageInfo>();
		for(String key :map.keySet())
		{
			list1.addAll(getPreviewListBySplash(map.get(key), key));
		}
		list0.addAll(list1);
		Map<String, PreviewImageInfo> imap=new HashMap<String, PreviewImageInfo>();
		for (PreviewImageInfo previewImageInfo : list0) {
			imap.put(previewImageInfo.getCorbisId(), previewImageInfo);
		}
		for (String cid : corbisids) {
			PreviewImageInfo pv=imap.get(cid);
			if(pv!=null)
				rstList.add(pv);
		}
		return rstList;
	}
	
	@Override
	public List<PreviewImageInfo> getPreviewListBySplash(List<String> list, String spl) {
		List<PreviewImageInfo> rstList = new ArrayList<PreviewImageInfo>();
		try {
			ImageInfo imageInfo = getImageInfoByCorbisIdCache(spl);
			if(imageInfo==null) return rstList;
			ImageCollection collection = collectionService.getCollection(imageInfo.getCollectionId());
			int priType = -1;
			if(collection!=null){
				try {
					Map<Integer, Integer> priMap = RequestUtils.getPriMap();
					if(priMap!=null){
						Integer type = priMap.get(imageInfo.getCollectionId());
						if(type!=null){
							priType = type;
						}
					}
					else{
//			priTypeUserPrivilegeType.QP.ordinal();
					}
				} catch (Exception e) {
				}
			}
			int index = new Random(System.currentTimeMillis()).nextInt(20);
			long viruId = 1;
			for(String splashId : list){
				if(splashId!=null){
					PreviewImageInfo previewImageInfo = new PreviewImageInfo();
					BeanUtils.copyProperties(previewImageInfo, imageInfo);
					previewImageInfo.setCorbisId(splashId);
					previewImageInfo.setId(viruId++);
					if(collection!=null){
						previewImageInfo.setCollectionName(collection.getShowName());
					}
					previewImageInfo.setPriType(priType);
					if(previewImageInfo!=null){
						previewImageInfo.setImageHost(SearchUtils.getImageHost(index++));
						rstList.add(previewImageInfo);
					}
				}
			}
		} catch (Exception e) {
			logger.error("查询splash图片列表异常[spl="+spl+"]：", e);
		}
		return rstList;
	}
	
	@Override
	public List<PreviewImageInfo> getPreviewList(List<String> list) {
		List<PreviewImageInfo> rstList = new ArrayList<PreviewImageInfo>();
		ImageInfo[] rstInfos = null;
		long t = SearchUtils.timeDebug(null, 0);
		long t1 = SearchUtils.timeDebug("getPreviewList================S", t);
		try{
			if(list==null || list.size()==0) return rstList;
			String[] keys = list.toArray(new String[]{});
			t = SearchUtils.timeDebug("service参数准备", t);
			Map<String, Object> rstObjects = cacheService.getMemcached().getMulti(keys);
			t = SearchUtils.timeDebug("memcached获取对象["+rstObjects.size()+"]", t);
			rstInfos = new ImageInfo[keys.length];
			List<String> nullKeyList = new ArrayList<String>();
			for(int i=0; i<keys.length; i++){
				ImageInfo imageInfo = (ImageInfo)rstObjects.get(keys[i]);
				rstInfos[i] = imageInfo;
				if(rstInfos[i] ==null){
					if(keys[i]!=null){
						nullKeyList.add(keys[i]);
					}
				}
			}
			t = SearchUtils.timeDebug("循环检查cache中是否有空值", t);
			if(nullKeyList.size()>0){ // 发现缓存数据为空，查询数据库
				List<ImageInfo> dbList = getListByIds(nullKeyList);
				for(int i=0; i<rstInfos.length; i++){
					ImageInfo info = rstInfos[i];
					if(info==null){
						for(ImageInfo dbInfo : dbList){
							if(keys[i].equals(dbInfo.getCorbisId())){
								rstInfos[i] = dbInfo;
								cacheService.putRemote(dbInfo.getCorbisId(), dbInfo, Constants.CACHE_FOREVER_TIMES);
								break;
							}
						}
					}
				}
			}
			t = SearchUtils.timeDebug("空值请求数据库[size="+nullKeyList.size()+"]", t);
			// 格式化缓存数据，可优化。。。
			int index = new Random(System.currentTimeMillis()).nextInt(20);
			for(ImageInfo info : rstInfos){
				if(info!=null){
					int groupid=0;
					String number = new String();
					if(info.getIsInImageGroup()!=null && info.getIsInImageGroup()!=0){
						List<Integer> groupids = imageGroupService.getImageGroupIdList(info.getCorbisId());
						if(groupids.size()!=0 && !groupids.isEmpty() && groupids!=null){
							groupid = groupids.get(0);
							number = imageGroupService.getImageGroupAmount(groupid);
						}
					}
					PreviewImageInfo preInfo = formatPreviewInfo(info);
					if(groupid!=0 && number!=null){
						preInfo.setGroupId(String.valueOf(groupid));
						preInfo.setGroupAmount(number);
						
					}
					if(preInfo!=null){
						preInfo.setImageHost(SearchUtils.getImageHost(index++));
						rstList.add(preInfo);
					}
				}
			}
			t = SearchUtils.timeDebug("格式化数据对象", t);
		}
		catch (Exception e) {
			logger.error("查询图片预览信息异常：", e);
		}
		//printAll(rstList);
		t = SearchUtils.timeDebug("getPreviewList===================E", t1);
		return rstList;
	}
	
	@Override
	public List<PreviewImageInfo> getPreviewList_exceptGroupImages(List<String> list) {
		
				
		List<PreviewImageInfo> rstList = new ArrayList<PreviewImageInfo>();
		ImageInfo[] rstInfos = null;
		long t = SearchUtils.timeDebug(null, 0);
		long t1 = SearchUtils.timeDebug("getPreviewList_exceptGroupImages================S", t);
		try{
			if(list==null || list.size()==0) return rstList;
			String[] keys = list.toArray(new String[]{});
			t = SearchUtils.timeDebug("service参数准备", t);
			Map<String, Object> rstObjects = cacheService.getMemcached().getMulti(keys);
			t = SearchUtils.timeDebug("memcached获取对象["+rstObjects.size()+"]", t);
			rstInfos = new ImageInfo[keys.length];
			List<String> nullKeyList = new ArrayList<String>();
			for(int i=0; i<keys.length; i++){
				ImageInfo imageInfo = (ImageInfo)rstObjects.get(keys[i]);
				rstInfos[i] = imageInfo;
				if(rstInfos[i] ==null){
					if(keys[i]!=null){
						nullKeyList.add(keys[i]);
					}
				}	
			}
			t = SearchUtils.timeDebug("循环检查cache中是否有空值", t);
			if(nullKeyList.size()>0){ // 发现缓存数据为空，查询数据库
				List<ImageInfo> dbList = getListByIds(nullKeyList);
				for(int i=0; i<rstInfos.length; i++){
					ImageInfo info = rstInfos[i];
					if(info==null){
						for(ImageInfo dbInfo : dbList){
							if(keys[i].equals(dbInfo.getCorbisId())){
								rstInfos[i] = dbInfo;
								cacheService.putRemote(dbInfo.getCorbisId(), dbInfo, Constants.CACHE_FOREVER_TIMES);
								break;
							}
						}
					}
				}
			}
			t = SearchUtils.timeDebug("空值请求数据库[size="+nullKeyList.size()+"]", t);
			// 格式化缓存数据，可优化。。。
			int index = new Random(System.currentTimeMillis()).nextInt(20);
			for(ImageInfo info : rstInfos){
				if(info!=null && info.getIsInImageGroup()!=null /*&& info.getIsInImageGroup()!=1*/ ){
					int groupid=0;
					String number = new String();
					if(info.getIsInImageGroup()==2){
						List<Integer> groupids = imageGroupService.getImageGroupIdList(info.getCorbisId());
						if(groupids.size()!=0 && !groupids.isEmpty() && groupids!=null){
							groupid = groupids.get(0);
							number = imageGroupService.getImageGroupAmount(groupid);
						}
					}
					PreviewImageInfo preInfo = formatPreviewInfo(info);
					if(groupid!=0 && number!=null){
						preInfo.setGroupId(String.valueOf(groupid));
						preInfo.setGroupAmount(number);
						
					}
					if(preInfo!=null){
						preInfo.setImageHost(SearchUtils.getImageHost(index++));
						rstList.add(preInfo);
					}

				}
			}
			t = SearchUtils.timeDebug("格式化数据对象", t);
		}
		catch (Exception e) {
			logger.error("查询图片预览信息异常：", e);
		}
		//printAll(rstList);
		t = SearchUtils.timeDebug("getPreviewList_exceptGroupImages===================E", t1);
		return rstList;
	}
	
	private void printAll(List<PreviewImageInfo> list)
	{
		if(list!=null&&list.size()>0)
		{
			for (PreviewImageInfo previewImageInfo : list) {
				logger.info(previewImageInfo.toString());
			}
		}
		
		
	}
	
	public List<PreviewImageInfo> getPreviewListByCorbisIds(String[] corbisIds){
		 return getPreviewList(Arrays.asList(corbisIds));
	}
	
	/**
	 * 格式化数据
	 * @param info
	 */
	private PreviewImageInfo formatPreviewInfo(ImageInfo info){
		try{
			PreviewImageInfo previewImageInfo = new PreviewImageInfo();
			BeanUtils.copyProperties(previewImageInfo, info);
			try {
				if(RequestUtils.getContain()==null || RequestUtils.getUser()==null){
					previewImageInfo.setPricing(-1);
				}
			} catch (Exception e) {
			}
			ImageCollection collection = collectionService.getCollection(info.getCollectionId());
			
			if(collection!=null){
				previewImageInfo.setCollectionName(collection.getShowName());
				previewImageInfo.setExt(collection.getExt()); //Sean added for
				try {
					Map<Integer, Integer> priMap = RequestUtils.getPriMap();
					if(priMap!=null){
						Integer type = priMap.get(info.getCollectionId());
						if(type==null){
							previewImageInfo.setPriType(-1);
						}
						else{
							previewImageInfo.setPriType(type);
						}
					}
					else{
//					previewImageInfo.setPriType(UserPrivilegeType.QP.ordinal());
					}
				} catch (Exception e) {
				}
			}
			
			// 处理splash
			if(info.getCorbisId()!=null && info.getCorbisId().toLowerCase().startsWith("spl")){
				ImageGroup imageGroup = imageGroupService.getImageGroupByCode(SearchUtils.getSplashCorbisId(info.getCorbisId()));
				if(imageGroup!=null){
					previewImageInfo.setSplashNum(imageGroup.getNum());
				}
			}
			
			return previewImageInfo;
		}
		catch (Exception e) {
			logger.error("处理查询结果类异常["+info.getCorbisId()+"]：", e);
		}
		return null;
	}
	
	private List<ImageInfo> getListByIds(List<String> idList){
		List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new InExpression("corbisId", idList.toArray(new String[]{})));
		List<ImageInfo> list = controller.findBy(ImageInfo.class, "id", true, expressions);
		return list;
	}

	@Override
	public ImageInfo getImageInfoByCorbisId(String corbisId) {
		if(StrUtils.isBlank(corbisId)) return null;
		corbisId = SearchUtils.getSplashCorbisId(corbisId);
		List<ImageInfo> infos = controller.findBy(ImageInfo.class, "corbisId", corbisId);//controller.findBy("from ImageInfo where corbisId=?", corbisId);
		if(infos!=null && infos.size()>0){
			ImageInfo info = infos.get(0);
			cacheService.putRemote(corbisId, info, Constants.CACHE_FOREVER_TIMES);
			return info;
		}
		return null;
	}
	
	@Override
	public ImageInfo getImageInfoByCorbisIdCache(String corbisId) {
		if(StrUtils.isBlank(corbisId)) return null;
		corbisId = SearchUtils.getSplashCorbisId(corbisId);
		ImageInfo info = null;
		try {
			info = (ImageInfo)cacheService.getRemote(corbisId);
			if(info==null){
				info = getImageInfoByCorbisId(corbisId);
			}
		} catch (Exception e) {
			logger.error("根据corbisid从缓存读取数据异常["+corbisId+"]:", e);
		}
		
		return info;
	}
	
	private Map<String, Object> getByProperty(String name, String value, int pageNo, int pageSize){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		
		try{
			int offset = (pageNo-1)*pageSize;
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put(name,value);
			paraMap.put("offset", offset);
			paraMap.put("limit", pageSize);
			String url = SearchUtils.genSearchUrl(paraMap);
			String content = HttpClientHelper.doGet(url);

			SearchResult sr = SearchUtils.getSearchResultFromJson(content, null);
			List<PreviewImageInfo> rstList = null;
			if(sr.getTotal()>0){
				rstList = getPreviewList(sr.getIds(offset, pageSize));
			}
			else{
				rstList = new ArrayList<PreviewImageInfo>();
			}
			
			rstMap.put("success", true);
			rstMap.put("total", sr.getTotal());
			rstMap.put("data", rstList);
			rstMap.put("totalPages", SearchUtils.getTotalPages(sr.getTotal(), pageSize));
			rstMap.put("currentPage", pageNo);
		}
		catch (Exception e) {
			logger.error("根据摄影师名称查询异常[name="+name+"]：", e);
		}
		return rstMap;
	}

	@Override
	public Map<String, Object> getByPhotographerName(String name, int pageNo,
			int pageSize) {
		return getByProperty("photographer", name, pageNo, pageSize);
	}

	@Override
	public Map<String, Object> getByCollectionId(int collectionId, int pageNo,
			int pageSize) {
		return getByProperty("collection_id", ""+collectionId, pageNo, pageSize);
	}
}
