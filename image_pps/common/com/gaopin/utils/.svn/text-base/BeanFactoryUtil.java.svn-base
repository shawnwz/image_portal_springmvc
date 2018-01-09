/* This file BeanFactoryUtil.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gaopin.exception.BeanFactoryException;

public class BeanFactoryUtil implements ServletContextListener {
	
	private static final Logger logger = Logger.getLogger(BeanFactoryUtil.class);

	private static ApplicationContext context;

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent event) {
		logger.info("初始化BeanFactory....");
		context = WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext());
		logger.info("初始化BeanFactory....OK.");
	}

	public static Object getBean(String beanName) throws BeanFactoryException {
		if (context == null) {
			logger.warn("ApplicationContext 没有初始化！您无法获得业务处理对象，系统无法正常运行");
			throw new BeanFactoryException(
					"ApplicationContext 没有初始化！您无法获得业务处理对象，系统无法正常运行");
		}
		try {
			return context.getBean(beanName);
		} catch (BeansException exp) {
			if (exp instanceof NoSuchBeanDefinitionException) {
				logger.debug("bean[" + beanName + "]尚未装载到容器中！");
			} else {
				logger.error("读取[" + beanName + "]失败！", exp);
			}
			throw new BeanFactoryException("读取[" + beanName + "]失败！", exp);
		}
	}

}
