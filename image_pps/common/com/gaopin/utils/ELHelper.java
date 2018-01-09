/* This file ELHelper.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.util.ArrayList;
import java.util.List;


/*
 * 用于el表达式.
 * 
 * 
 * */
public class ELHelper {
	
	public static String xxxxxappend(String str1, String str2) {  
	       return str1 + str2;  
	    }
	
	public static String[] getLines(String src)
	{
		List<String> ret=new ArrayList<String>();
		String[] as=src.split("\r\n");
		for (int i = 0; i < as.length; i++) {
			if(StrUtils.isNotBlank(as[i].trim()))
				ret.add(as[i]);
		}
		return ret.toArray(new String[]{});
	}
}
