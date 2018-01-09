/* This file DownloadService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.Map;

import com.gaopin.constants.Constants.SizeType;
import com.gaopin.constants.Constants.UserPrivilegeType;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.service.BaseService;

public interface DownloadService extends BaseService {
	
	/**
	 * 获取图片物理地址，根据imageInfo.storageId寻找盘符
	 * 根据userPrivilege判断用户可下载的SizeType，并判断存在的图片文件，向下兼容，处理不同的文件后缀
	 * @param imageInfo
	 * @param userPrivilege
	 * @return
	 */
	public Map<String, Object> getDownloadPath(ImageInfo imageInfo, UserPrivilege userPrivilege);
	
	/**
	 * 记录下载日志，如果是OD下载，判断是否扣点并记录
	 * @param imageInfo
	 * @param user
	 * @param userPrivilegeType
	 * @return
	 */
	public boolean recordDownloadLog(ImageInfo imageInfo, User user, UserPrivilegeType userPrivilegeType, SizeType sizeType);
	
	
	public boolean recordDownloadLog(PreviewImageInfo[] corbisIds, SizeType[] sizeTypes, User user,
			UserPrivilegeType userPrivilegeType);

	void checkAndGenSuperMark(ImageInfo imageInfo);
	
	
}
