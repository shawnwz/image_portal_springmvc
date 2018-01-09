/* This file BatchFileFilter.java is part of image_pps .
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

import com.gaopin.entity.User;
import com.gaopin.service.pps.BatchDownloadService;
import com.gaopin.utils.BeanFactoryUtil;
import com.gaopin.utils.KeyValue;
import com.gaopin.utils.StrUtils;

public class BatchFileFilter implements Filter {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		
		String ip = StrUtils.getNullStr(request.getHeader("X-Real-Ip"), request.getRemoteAddr());
		User user = (User)request.getSession().getAttribute(User.class.getName());
		
		BatchDownloadService batchDownloadService = (BatchDownloadService)BeanFactoryUtil.getBean("batchDownloadService");
		
		String uri = request.getRequestURI();
		String fileName = uri.substring(uri.lastIndexOf("/")+1);
		logger.info("batchDownload:"+uri+"\t\t"+ip+request.getParameter("s"));
		KeyValue<Boolean, String> kw = batchDownloadService.download(user==null?null:user.getId(), fileName, request.getParameter("s"), ip);
		if(kw==null){
			response.getWriter().print("ERROR.");
			return;
		}
		else{
			if(kw.getKey()){
				filter.doFilter(request, response);
			}
			else{
				response.setHeader("Content-Type", "text/html; charset=UTF-8");
				System.out.println(kw.getKey()+":"+kw.getValue());
				response.setCharacterEncoding("UTF-8");
				response.getWriter().println(kw.getValue());
//				response.sendRedirect("/index");
				return;
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
