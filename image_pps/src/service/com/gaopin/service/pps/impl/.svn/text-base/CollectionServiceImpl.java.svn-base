/* This file CollectionServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.constants.Constants.CommonStatus;
import com.gaopin.entity.CollectionSort;
import com.gaopin.entity.ImageCollection;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.page.vo.CollectionSpec;
@Service("collectionService")
public class CollectionServiceImpl extends BaseServiceImpl implements
		CollectionService {

	private static CollectionService instance = null;
	
	private static Map<Integer, ImageCollection> _map = new HashMap<Integer, ImageCollection>();
	private static Map<String, ImageCollection> _name_map = new HashMap<String, ImageCollection>();
	private static Map<Integer, CollectionSort> _sort_map = new HashMap<Integer, CollectionSort>();
	private static Map<String, List<ImageCollection>> _pricingMap = new HashMap<String, List<ImageCollection>>();
	private final static String SORT_COLLECTION_SPEC_KEY = "spec_collectionIds";
	private final static String SORT_COLLECTION_SPEC_KEY_2000 = "spec_collectionIds_2000";
	private final static String SORT_COLLECTION_SPEC_OBJECT_KEY = "spec_collectionIds_cache_key";
	@Resource
	private VariablesService variablesService;
	
	@PostConstruct
	public void init(){
		instance = this;
		loadAll();
	}
	
	public static CollectionService getInstance(){
		return instance;
	}
	
	public void loadAll(){
		Map<Integer, ImageCollection> map = new HashMap<Integer, ImageCollection>();
		Map<String, ImageCollection> name_map = new HashMap<String, ImageCollection>();
		Map<Integer, CollectionSort> sort_map = new HashMap<Integer, CollectionSort>();
		Map<String, List<ImageCollection>> pricingMap = new HashMap<String, List<ImageCollection>>();
		
		// 需要根据业务逻辑，判断是否根据可用状态加载
		List<ImageCollection> list = getAllShowCollections();
		List<CollectionSort> sortList = new ArrayList<CollectionSort>();
		for(ImageCollection collection : list){
			map.put(collection.getId(), collection);
			name_map.put(collection.getName().toLowerCase(), collection);
			sort_map.put(collection.getId(), new CollectionSort(collection.getId(), collection.getLevel(), collection.getScore()));
			try{
				List<ImageCollection> subList = (List<ImageCollection>)pricingMap.get(collection.getPricingTier().toLowerCase());
				if(subList==null){
					subList = new ArrayList<ImageCollection>();
					pricingMap.put(collection.getPricingTier().toLowerCase(), subList);
				}
				subList.add(collection);
			}
			catch (Exception e) {
				logger.error("初始化图库缓存数据异常[id="+collection.getId()+", name="+collection.getName()+"]：", e);
			}
		}
		_map = map;
		_name_map = name_map;
		_sort_map = sort_map;
		_pricingMap = pricingMap;
		// 重新载入排序规则
		cacheService.removeLocalLong(SORT_COLLECTION_SPEC_OBJECT_KEY);
		System.out.println("sortList = " + sortList.size());
	}
	
	public List<ImageCollection> getAllShowCollections(){
		List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("parentId", 0, CompareType.Equal));
		expressions.add(new CompareExpression("status", CommonStatus.ENABLE.ordinal(), CompareType.Equal));
		return controller.findBy(ImageCollection.class, "showName", true, expressions);
	}
	
	
	public List<ImageCollection> getAllShowCollectionsByCache(){
		return new ArrayList<ImageCollection>(_map.values()) ;
	}
	
	@Override
	public ImageCollection getCollection(Integer id) {
		if(id==null || id<=0) return null;
		ImageCollection collection = _map.get(id);
		if(collection==null){
			collection = get(ImageCollection.class, id);
			if(collection!=null){
				_map.put(id, collection);
				if(collection.getParentId()==0){
					_sort_map.put(id, new CollectionSort(id, collection.getLevel(), collection.getScore()));
				}
			}
		}
		return collection;
	}
	
	@Override
	public ImageCollection getCollection(String collectionName) {
		if(collectionName==null) return null;
		ImageCollection collection = _name_map.get(collectionName.toLowerCase());
		return collection;
	}

	public Map<Integer, CollectionSort> getSortMap(){
		return _sort_map;
	}

	@Override
	public List<ImageCollection> getPricingList(String key) {
		List<ImageCollection> list = null;
		if(key!=null){
			list = _pricingMap.get(key.toLowerCase());
		}
		
		return list!=null ? list:new ArrayList<ImageCollection>();
	}

	public String getSpecIds(){
		
		return variablesService.getVariablesValue(SORT_COLLECTION_SPEC_KEY, "");
		//return variablesService.getVariablesValue(SORT_COLLECTION_SPEC_KEY_2000, "");
	}
	
	public CollectionSpec getCollectionSpec(){
		CollectionSpec cs = (CollectionSpec)cacheService.getLocalLong(SORT_COLLECTION_SPEC_OBJECT_KEY);
		if(cs==null){
			synchronized (this) {
				if(cs==null){
					String cidStr = getSpecIds();
					cs = new CollectionSpec(cidStr);
					cacheService.putLocalLong(SORT_COLLECTION_SPEC_OBJECT_KEY, cs);
				}
			}
		}
		return cs;
	}
}
