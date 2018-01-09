/* This file IndexPageService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.entity.ImageSets;
import com.gaopin.entity.IndexBigview;
import com.gaopin.entity.IndexMenu;
import com.gaopin.entity.SystemVariables;
import com.gaopin.service.BaseService;

public interface IndexPageService extends BaseService {
	
	public void loadAll();
	/**
	 * 首页大图表
	 * @return
	 */
	public List<IndexBigview> getIndexBigviews();
	
	/**
	 * 每页菜单列表
	 * @param type
	 * @return
	 */
	public List<IndexMenu> IndexMenus(Integer type);
	
	public Integer GetIndexDelay();
	public Integer GetIndexDuration();
	
	public IndexMenu IndexMenu(Integer id);
}
