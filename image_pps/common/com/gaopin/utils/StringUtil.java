/* This file StringUtil.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

public class StringUtil {
	//判断字符串是否为空
	public static boolean checkNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	public static int setFirstRec(int pageNo,int pageSize)
	{
		int ret = (pageNo-1) * pageSize;// + 1;
		ret = (ret < 1)?0:ret;
		return ret;
	}
}
