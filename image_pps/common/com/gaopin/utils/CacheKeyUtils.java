/* This file CacheKeyUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.Serializable;

import com.gaopin.entity.ImageGroup;

public class CacheKeyUtils {
	
	public static String getGroupByCodeKey(String code){
		return ImageGroup.class.getName()+"_code_"+code;
	}
	
	/**
	 * 获取entity缓存key
	 * @param clasz
	 * @param id
	 * @return
	 */
	public static String getEntityKey(Class<?> clasz, Serializable id){
		return clasz.getName()+"_"+id;
	}
	
	/**
	 * 获取entity对应的list列表
	 * @param clasz
	 * @param id
	 * @return
	 */
	public static String getEntityListKey(Class<?> clasz, Serializable id){
		return clasz.getName()+"_list_"+id;
	}
	
	public static String getEntityListKey(Class<?> clasz, String prefix, Serializable id){
		return clasz.getName()+"_"+prefix+"_list_"+id;
	}
}
