/* This file UserPrivilegeService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.entity.UserPrivilege;
import com.gaopin.service.BaseService;

public interface UserPrivilegeService extends BaseService {
	
	/**
	 * 获取用户下载权限
	 * @param userId
	 * @param collectionId
	 * @param type
	 * @return
	 */
	public UserPrivilege getPrivilege(Integer userId, Integer collectionId, Integer type);
	
	/**
	 * 获取用户下载权限
	 * @param userId
	 * @return
	 */
	public List<UserPrivilege> getPrivilegeList(Integer userId);
}
