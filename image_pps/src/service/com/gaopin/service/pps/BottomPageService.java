/* This file BottomPageService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.entity.FlowJoinUs;
import com.gaopin.entity.FlowNews;
import com.gaopin.service.BaseService;

public interface BottomPageService extends BaseService {
	
	public List<FlowJoinUs> getCareers();
	public List<FlowNews> GetNews(int p,String type);
	public List<FlowNews> GetNewsByTime(int p, String type) ;
	public Integer GetNewsCount(String type);
	public FlowNews GetNewsById(int id);
	public List<Integer> GetNewsIds(String type) ;
	
}
