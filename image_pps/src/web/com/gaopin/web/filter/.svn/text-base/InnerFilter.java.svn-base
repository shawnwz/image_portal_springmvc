/* This file InnerFilter.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.gaopin.utils.PropertyReader;
import com.gaopin.utils.StrUtils;

public class InnerFilter implements Filter {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	private static String FILTER_IPS = PropertyReader.getString("inner.ip", "");
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		
		String ip = StrUtils.getNullStr(request.getHeader("X-Real-Ip"), request.getRemoteAddr());
		if(!FILTER_IPS.startsWith("*") && FILTER_IPS.indexOf(ip)<0){ // 非法
			response.getWriter().print("Invalid Ip.");
			return;
		}
		
		filter.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
