/* This file RequestUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaopin.entity.User;

public class RequestUtils {
	
	private static ThreadLocal<RequestInfo> contain = new ThreadLocal<RequestInfo>();
	
	public static RequestInfo getContain(){
		return contain.get();
	}
	
	public static void setContain(RequestInfo requestInfo){
		contain.set(requestInfo);
	}
	
	public static void setUser(User user){
		getContain().setUser(user);
	}
	
	public static void setPriMap(Map<Integer, Integer> priMap){
		contain.get().setPriMap(priMap);
	}
	
	public static HttpServletRequest getRequest(){
		return contain.get().getRequest();
	}
	
	public static HttpServletResponse getResponse(){
		return contain.get().getResponse();
	}
	
	public static User getUser(){
		return contain.get().getUser();
	}
	
	public static Map<Integer, Integer> getPriMap(){
		return contain.get().getPriMap();
	}
	
	public static void setErrorMsg(String errorMsg){
		contain.get().setErrorMsg(errorMsg);
	}
	public static String getErrorMsg(){
		return contain.get().getErrorMsg();
	}
	public static String getErrorMsg(String def){
		String msg = contain.get().getErrorMsg();
		return msg!=null ? msg:def;
	}
	
	public static void setErrorCode(int errorCode){
		contain.get().setErrorCode(errorCode);
	}
	public static int getErrorCode(){
		return contain.get().getErrorCode();
	}
	public static void setErrorInfo(int errorCode, String errorMsg){
		contain.get().setErrorCode(errorCode);
		contain.get().setErrorMsg(errorMsg);
	}
}
