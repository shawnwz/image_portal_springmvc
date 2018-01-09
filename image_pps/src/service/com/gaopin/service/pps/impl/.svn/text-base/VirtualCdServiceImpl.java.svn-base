/* This file VirtualCdServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.gaopin.constants.Constants;
import com.gaopin.entity.Photographer;
import com.gaopin.entity.VirtualCd;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.VirtualCdService;
import com.gaopin.utils.StrUtils;

@Service("virtualCdService")
public class VirtualCdServiceImpl extends BaseServiceImpl implements VirtualCdService {

	@Override
	public VirtualCd get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VirtualCd getByName(String name) {
		if(StrUtils.isBlank(name)) return null;
		
		String key = VirtualCd.class.getName()+"_"+name;
		VirtualCd virtualCd = null;
		try {
			virtualCd = (VirtualCd)cacheService.getRemote(key);
		} catch (Exception e) {
		}
		if(virtualCd==null){
			virtualCd = loadByName(name);
			if(virtualCd!=null){
				cacheService.putRemote(key, virtualCd, Constants.CACHE_DEFAULT_TIMES);
			}
		}
		return virtualCd;
	}

	@Override
	public VirtualCd load(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VirtualCd loadByName(String name) {
		VirtualCd virtualCd = controller.findUniqueBy(VirtualCd.class, "name", name);
		return virtualCd;
	}

	@Override
	public VirtualCd getOrCreateByName(String name) {
		if(StrUtils.isBlank(name)) return null;
		VirtualCd virtualCd = getByName(name);
		if(virtualCd==null){
			virtualCd = new VirtualCd();
			virtualCd.setName(name);
			virtualCd.setStatus(Constants.CommonStatus.ENABLE.ordinal());
			virtualCd.setCreateTime(new Date());
			saveObject(virtualCd);
			cacheService.putRemote(VirtualCd.class.getName()+"_"+name, virtualCd, Constants.CACHE_DEFAULT_TIMES);
		}
		return virtualCd;
	}

}
