/* This file ContentProviderServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.entity.ContentProvider;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.ContentProviderService;
import com.gaopin.utils.StrUtils;
@Service("contentProviderService")
public class ContentProviderServiceImpl extends BaseServiceImpl implements
		ContentProviderService {

	@Resource
	private CacheService cacheService;
	
	@Override
	public Integer getProviderId(String providerName) {
		if(StrUtils.isBlank(providerName)){
			return null;
		}
		Map<String, Integer> map = (Map<String, Integer>)cacheService.getLocalLong("providerIdMap");
		if(map==null){
			map = new HashMap<String, Integer>();
			List<ContentProvider> list = getController().loadAll(ContentProvider.class);
			for(ContentProvider cp : list){
				if(StrUtils.isNotBlank(cp.getShowName())){
					String[] eles = cp.getShowName().split("[|]");
					for(String ele : eles){
						map.put(ele.toLowerCase(), cp.getId());
					}
				}
			}
			cacheService.putLocalLong("providerIdMap", map);
		}
		return map.get(providerName.toLowerCase());
	}

}
