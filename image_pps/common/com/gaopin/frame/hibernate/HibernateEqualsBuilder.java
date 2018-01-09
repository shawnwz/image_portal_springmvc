/* This file HibernateEqualsBuilder.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.frame.hibernate;

import com.gaopin.utils.BeanUtils;


public class HibernateEqualsBuilder {

	public static boolean reflectionEquals(Object obj, Object target,
			String keyfield) {
		if (target == null || obj == null)
			return false;
		if (target.getClass().equals(obj.getClass())) {
			try {
				Object objId = BeanUtils.forceGetProperty(obj, keyfield);
				Object targetId = BeanUtils.forceGetProperty(target, keyfield);
				if (objId.equals(targetId))
					return true;
			} catch (Exception e) {
			}
		}
		return false;
	}
}
