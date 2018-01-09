/* This file RequestUtil.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

	public static String getIp(HttpServletRequest request){
		String ip = null;
		if(ip==null){
			ip = request.getHeader("X-Real-Ip");
			if(ip==null){
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}
}
