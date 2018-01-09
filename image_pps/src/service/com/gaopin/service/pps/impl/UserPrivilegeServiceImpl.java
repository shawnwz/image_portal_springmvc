/* This file UserPrivilegeServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gaopin.constants.Constants.CommonStatus;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.UserPrivilegeService;
@Service("userPrivilegeService")
public class UserPrivilegeServiceImpl extends BaseServiceImpl implements
		UserPrivilegeService {

	@Override
	public UserPrivilege getPrivilege(Integer userId, Integer collectionId, Integer type) {
		if(userId==null || collectionId==null || type==null) return null;
		List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("userId", userId, CompareType.Equal));
		expressions.add(new CompareExpression("collectionId", collectionId, CompareType.Equal));
		expressions.add(new CompareExpression("type", type, CompareType.Equal));
		expressions.add(new CompareExpression("status", CommonStatus.ENABLE.ordinal(), CompareType.Equal));
		expressions.add(new CompareExpression("expireTime", new Date(), CompareType.Gt));
		expressions.add(new CompareExpression("sizeId", 0, CompareType.Gt));
		List<UserPrivilege> list = controller.findBy(UserPrivilege.class, expressions);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public List<UserPrivilege> getPrivilegeList(Integer userId){
		if(userId==null) return new ArrayList<UserPrivilege>();
		List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("userId", userId, CompareType.Equal));
		expressions.add(new CompareExpression("status", CommonStatus.ENABLE.ordinal(), CompareType.Equal));
		expressions.add(new CompareExpression("expireTime", new Date(), CompareType.Gt));
		expressions.add(new CompareExpression("sizeId", 0, CompareType.Gt));
		List<UserPrivilege> list = controller.findBy(UserPrivilege.class, expressions);
		return list;
	}

}
