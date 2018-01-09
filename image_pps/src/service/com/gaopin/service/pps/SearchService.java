/* This file SearchService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;
import java.util.Map;

import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.service.BaseService;

public interface SearchService extends BaseService {
	
	public List<PreviewImageInfo> getPreviewListSplashEnable(List<String> corbisids);
	public List<PreviewImageInfo> getPreviewList(List<String> searchList);
	public List<PreviewImageInfo> getPreviewList_exceptGroupImages(List<String> searchList); //Sean added @20150630
	public List<PreviewImageInfo> getPreviewListBySplash(List<String> list, String spl);
	public List<PreviewImageInfo> getPreviewListByCorbisIds(String[] corbisIds);
	public ImageInfo getImageInfoByCorbisId(String corbisId);
	public ImageInfo getImageInfoByCorbisIdCache(String corbisId);
	
	public Map<String, Object> getByPhotographerName(String name, int pageNo, int pageSize);
	public Map<String, Object> getByCollectionId(int collectionId, int pageNo, int pageSize);
}
