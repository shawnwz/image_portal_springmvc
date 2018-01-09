/* This file CookieUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	
	public static String getCookieValue(HttpServletRequest request, String cookieName){
		Cookie[] cookies = request.getCookies();
		if(cookies==null) return null;
		for(Cookie c : cookies){
			if(c.getName().equalsIgnoreCase(cookieName)){
				return c.getValue();
			}
		}
		return null;
	}
	
	public static Cookie getCookie(HttpServletRequest request, String cookieName){
		Cookie[] cookies = request.getCookies();
		if(cookies==null) return null;
		for(Cookie c : cookies){
			if(c.getName().equalsIgnoreCase(cookieName)){
				return c;
			}
		}
		return null;
	}
	
	public static String getCookieValue(HttpServletRequest request, String cookieName, String def){
		String value = getCookieValue(request, cookieName);
		return value==null ? def:value;
	}
	static String hash_salt="ADSF$fdoif923jsdfjr29%^&*(oksdfsdfjsd";
	
	public static void setHashCookie(HttpServletResponse response,Integer userId)
	{
		CookieUtils.setCookie(response, "id", userId.toString(), 7*24*3600);
		CookieUtils.setCookie(response, "hash", MD5.getMd5Str(hash_salt+userId.toString()), 7*24*3600);
	}
	public static boolean CheckHashCookie(HttpServletRequest request)
	{
		String id	=	getCookieValue(request, "id","");
		String hash	=	getCookieValue(request, "hash","");
		if(StrUtils.isNumeric(id)&&StrUtils.isNotEmpty(hash))
		{
			if(hash.equals(MD5.getMd5Str(hash_salt+id)))
				return true;
		}
		return false;
	}
	
	public static void setCookie(HttpServletResponse response, String key, String value, int expiry){
		Cookie cookie = new Cookie(key, value);
		cookie.setPath("/");
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}
	
	public static void setCookie(HttpServletResponse response, String key, String value, String domain, String path, int expiry){
		Cookie cookie = new Cookie(key, value);
		if(StrUtils.isNotBlank(domain)){
			cookie.setDomain(domain);
		}
		if(StrUtils.isNotBlank(path)){
			cookie.setPath(path);
		}
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}
}
