/* This file AccessFilter.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.service.pps.UserPrivilegeService;
import com.gaopin.service.pps.UserService;
import com.gaopin.service.pps.impl.UserServiceImpl;
import com.gaopin.utils.BeanFactoryUtil;
import com.gaopin.utils.CookieUtils;
import com.gaopin.utils.MD5;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.utils.RequestInfo;
import com.gaopin.web.utils.RequestUtils;

public class AccessFilter implements Filter {
	
	private UserService userService = (UserService)BeanFactoryUtil.getBean("userService");
	private UserPrivilegeService userPrivilegeService = (UserPrivilegeService)BeanFactoryUtil.getBean("userPrivilegeService");
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	protected  String exclude = new String();
	private String[] getExclude(){
		if(StringUtils.isNotBlank(exclude)){
			return exclude.split(",");
		}
		return new String[0];
	}
	
	@Override
	public void destroy() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		RequestInfo requestInfo = new RequestInfo(request, response);
		RequestUtils.setContain(requestInfo);
		long t = System.currentTimeMillis();
		User user = (User)request.getSession().getAttribute(User.class.getName());
		//cookie relogin start . 
		if(user==null)
		{
			try {
			
				if(CookieUtils.CheckHashCookie(request))	
				{
					String id=CookieUtils.getCookie(request, "id").getValue();
					user=userService.get(User.class,Integer.parseInt(id));
						//set session as login.
						request.getSession().setAttribute(User.class.getName(), user);
						 // 载入用户下载权限
						List<UserPrivilege> list = userPrivilegeService.getPrivilegeList(user.getId());
							Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 图库和权限类型
							for(UserPrivilege userPrivilege : list){
								Integer cid = userPrivilege.getCollectionId();
								Integer type = userPrivilege.getType();
								if(cid!=null && type!=null){
									map.put(cid, type.intValue());
								}
							}
						request.getSession().setAttribute(UserPrivilege.class.getName(), map);
				}else {
					request.getSession().setAttribute(User.class.getName(), null);
					request.getSession().setAttribute(UserPrivilege.class.getName(), null);
					CookieUtils.setCookie(response, "id", "", 1);
					CookieUtils.setCookie(response, "hash", "", 1);
				}
			} catch (Exception e) {
				logger.error("getfrom cookie error", e);
			}
		}
		//cookie relogin end
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
//		logger.debug("过滤器：" + uri);
		if(uri.endsWith("logout.do")){
			request.getSession().setAttribute(User.class.getName(), null);
			request.getSession().setAttribute(UserPrivilege.class.getName(), null);
			CookieUtils.setCookie(response, "id", "", 1);
			CookieUtils.setCookie(response, "hash", "", 1);
			String url = (StrUtils.isBlank(contextPath)? "index":contextPath+"/index");
			response.sendRedirect(url);
			return;
			
		}
		
		// 用户判断
		if(user!=null){
			if(uri.endsWith("registpage") || uri.endsWith("login")){
				response.sendRedirect("/index");
				return;
			}
		}
		else{
			if(uri.indexOf("/my/")>=0){
				String type = request.getMethod();
				if(!StrUtils.equals(type, "POST"))
				{
					if(uri.indexOf("/pps/")>=0)
					{
						response.sendRedirect("/pps/login");
					}
					else {
						response.sendRedirect("/login");
					}
					return;
				}
			}
		}

		RequestUtils.setUser(user);
		RequestUtils.setPriMap((Map<Integer, Integer>)request.getSession().getAttribute(UserPrivilege.class.getName()));
//		System.out.println("filter.time=" + (System.currentTimeMillis()-t));
		filter.doFilter(request, response);
	}
	
	
	
	private boolean isExclude(String path){
		if(logger.isDebugEnabled()) logger.debug("验证路径是否在排除列表中：path=" + path);
		String[] excludes = getExclude();
		for(int i = 0; i < excludes.length; i++) {
			if(path.indexOf(excludes[i]) != -1) {
				if(logger.isDebugEnabled()) logger.debug("排除列表，不做认证");
				return true;
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.exclude = filterConfig.getInitParameter("exclude");
	}

}
