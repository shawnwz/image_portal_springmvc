/* This file KeywordService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.entity.Keywords;
import com.gaopin.service.BaseService;

public interface KeywordService extends BaseService {

	/**
	 * 根据key查找对象
	 * @param key
	 * @return
	 */
	public Keywords getKeywords(String key);
	
	/**
	 * @param key
	 * @param top
	 * @return
	 */
	public List<Keywords> getHotkeyList(String key, int top);
	
	public void loadAll();
	
}
