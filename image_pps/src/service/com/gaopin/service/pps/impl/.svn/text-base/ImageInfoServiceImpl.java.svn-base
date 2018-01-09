/* This file ImageInfoServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.entity.CodeRestriction;
import com.gaopin.entity.ImageInfo;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.ImageInfoService;
import com.gaopin.utils.CacheKeyUtils;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
@Service("imageInfoService")
public class ImageInfoServiceImpl extends BaseServiceImpl implements
		ImageInfoService {

	@Resource
	private CacheService cacheService;
	
	@Override
	public ImageInfo getImageInfo(String corbisId) {
		if(StrUtils.isBlank(corbisId)) return null;
		String orgiId=corbisId;
		if(SearchUtils.isSplashId(corbisId))
		{
			corbisId=SearchUtils.getSplashCorbisId(corbisId);
		}
		
		ImageInfo info = null;
		try{
			info = (ImageInfo)cacheService.getRemote(corbisId);
			if(info==null){
				info = getImageInfoByCorbisId(corbisId);
				if(info!=null){
					cacheService.putRemote(corbisId, info, Constants.CACHE_FOREVER_TIMES);
				}
			}
			info.setCorbisId(orgiId);
			return info;
		}
		catch (Exception e) {
			logger.error("根据CorbisId获取图片信息异常：["+corbisId+"]", e);
		}
		return null;
	}
	
	public ImageInfo getImageInfoByCorbisId(String corbisId) {
		if(StrUtils.isBlank(corbisId)) return null;
		List<ImageInfo> infos = controller.findBy(ImageInfo.class, "corbisId", corbisId);//controller.findBy("from ImageInfo where corbisId=?", corbisId);
		if(infos!=null && infos.size()>0){
			return infos.get(0);
		}
		return null;
	}

	@Override
	public List<String> getRestrictions(String ids) {
		List<String> list = new ArrayList<String>();
		try{
			if(StrUtils.isBlank(ids)) return list;
			String[] eles = ids.split(",");
			for(String ele : eles){
				int id = StrUtils.getIntValue(ele.trim(), -1);
				if(id<=0) continue;
				String key = CacheKeyUtils.getEntityKey(CodeRestriction.class, id);
				CodeRestriction cr = (CodeRestriction)cacheService.getLocalLong(key);
				if(cr==null){
					cr = get(CodeRestriction.class, id);
					if(cr==null){
						cr = new CodeRestriction();
					}
					cacheService.putLocalLong(key, cr);
				}
				if(StrUtils.isNotBlank(cr.getChinese())){
					list.add(cr.getChinese());
				}
			}
		}
		catch (Exception e) {
			logger.error("获取限制说明列表异常[ids="+ids+"]：", e);
		}
		return list;
	}

}
