/* This file CollectionService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;
import java.util.Map;

import com.gaopin.entity.CollectionSort;
import com.gaopin.entity.ImageCollection;
import com.gaopin.service.BaseService;
import com.gaopin.web.controller.page.vo.CollectionSpec;

public interface CollectionService extends BaseService {
	
	public ImageCollection getCollection(Integer id);
	
	public Map<Integer, CollectionSort> getSortMap();
	
	public List<ImageCollection> getPricingList(String key);
	
	public List<ImageCollection> getAllShowCollectionsByCache();
	
	
	public ImageCollection getCollection(String collectionName);
	
	public void loadAll();
	
	public String getSpecIds();
	
	public CollectionSpec getCollectionSpec();
}
