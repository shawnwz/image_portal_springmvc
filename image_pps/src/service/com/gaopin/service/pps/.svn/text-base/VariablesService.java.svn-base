/* This file VariablesService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;

import com.gaopin.entity.PpsEntity;
import com.gaopin.entity.SystemVariables;
import com.gaopin.service.BaseService;
import com.gaopin.utils.mail.MailSenderInfo;

public interface VariablesService extends BaseService {
	
	public void loadAll();
	public void cleanCache();
	public SystemVariables getVariables(String key);
	
	public String getVariablesValue(String key, String def);
	
	public PpsEntity getPpsEntityValue(String key) ;
	
	public List<PpsEntity> getPpsEntityValues(String key);
	
	public void mailLog(MailSenderInfo info,String type);
	
	public void mailLog(String type,String title,String body,String[] accepters,String cc);
	public SystemVariables getVariablesForce(String key);
	public String getVariablesValueForce(String key, String def);
}
