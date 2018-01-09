/* This file BaseController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.gaopin.entity.User;
import com.gaopin.service.BaseService;
import com.gaopin.utils.StrUtils;
@Controller
public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	protected static final int DEFAULT_START_PAGE = 0;
	protected static final int DEFAULT_PAGE_SIZE = 25;

	@Resource
	protected BaseService baseService;
	
	/**
	 * 页面中下拉框的默认类型值
	 */
	protected static int SELECT_TYPE = -1;

	protected static String SELECT_TYPE_STR = "-1";

	public void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(User.class.getName(), user);
	}
	
	public User getSessionUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(User.class.getName());
		return user;
	}

	public Integer getSessionUserId(HttpServletRequest request) {
		return getSessionUser(request) != null ? getSessionUser(request).getId() : 0;
	}

	public int getIntValue(HttpServletRequest request, String name, int def) {
		return StrUtils.getIntValue(request.getParameter(name), def);
	}

	public String getStringValue(HttpServletRequest request, String name, String def) {
		return StrUtils.getNullStr(request.getParameter(name), def);
	}

	public Map<String, Object> responseSuccess() {
		return responseSuccess("操作成功");
	}

	public Map<String, Object> responseSuccess(String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("msg", msg);
		return result;
	}

	public Map<String, Object> responseFailure() {
		return responseFailure("操作失败");
	}

	public Map<String, Object> responseFailure(String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("msg", msg);
		return result;
	}

	public Map<String, Object> responseQueryList(long total, List<?> list) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("total", total);
		modelMap.put("data", list);
		return modelMap;
	}
	
	public Map<String, Object> responseQueryList(int total, List<?> list) {
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put("total", total);
		modelMap.put("data", list);
		return modelMap;
	}

	public int getPageNo(HttpServletRequest request) {
		return getIntValue(request, "pageNo", DEFAULT_START_PAGE);
	}

	public int getPageSize(HttpServletRequest request) {
		return getIntValue(request, "limit", DEFAULT_PAGE_SIZE);
	}
	
	public void addResponseMessage(HttpServletRequest request,String value){
		request.setAttribute("message",value);
	} 

	public String getIp(HttpServletRequest request){
		String ip = request.getRemoteAddr();
		if(ip==null || ip.startsWith("192") || ip.startsWith("127") || ip.startsWith("local")){
			ip = request.getHeader("X-Real-IP");
		}
		return ip;
	}
}
