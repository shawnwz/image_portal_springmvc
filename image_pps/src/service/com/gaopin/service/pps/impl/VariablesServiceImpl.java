/* This file VariablesServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpUtils;

import org.apache.commons.collections.ListUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.poi.util.ArrayUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.gaopin.cache.CacheService;
import com.gaopin.entity.EmailLog;
import com.gaopin.entity.PpsEntity;
import com.gaopin.entity.SystemVariables;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.BeanUtils;
import com.gaopin.utils.EncodeingHelper;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.RequestUtil;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.StringUtil;
import com.gaopin.utils.mail.MailSenderInfo;
import com.gaopin.web.utils.RequestUtils;

@Service("variablesService")
public class VariablesServiceImpl extends BaseServiceImpl implements
		VariablesService {

	@Resource
	private CacheService cacheService;
	
	@PostConstruct
	public void init(){
		loadAll();
	}
	public void cleanCache() {
		List<SystemVariables> list = controller.loadAll(SystemVariables.class);
		for(SystemVariables variables : list){
			cacheService.removeLocalLong(SystemVariables.class.getName()+variables.getName());
		}
	}
	@Override
	public void loadAll() {
		List<SystemVariables> list = controller.loadAll(SystemVariables.class);
		for(SystemVariables variables : list){
			cacheService.putLocalLong(SystemVariables.class.getName()+variables.getName(), variables);
		}
	}

	@Override
	public SystemVariables getVariables(String key) {
		SystemVariables variables = (SystemVariables)cacheService.getLocalLong(SystemVariables.class.getName()+key);
		if(variables==null){
			variables = controller.findUniqueBy(SystemVariables.class, "name", key);
			if(variables!=null){
				cacheService.putLocalLong(SystemVariables.class.getName()+variables.getName(), variables);
			}
		}
		return variables;
	}
	
	@Override
	public SystemVariables getVariablesForce(String key) {
		SystemVariables variables = null;
		if(variables==null){
			variables = controller.findUniqueBy(SystemVariables.class, "name", key);
			if(variables!=null){
				cacheService.putLocalLong(SystemVariables.class.getName()+variables.getName(), variables);
			}
		}
		return variables;
	}

	@Override
	public String getVariablesValue(String key, String def) {
		SystemVariables variables = getVariables(key);
		return variables!=null ? variables.getValue() : def;
	}
	@Override
	public String getVariablesValueForce(String key, String def) {
		SystemVariables variables = getVariablesForce(key);
		return variables!=null ? variables.getValue() : def;
	}
	
	@Override
	public PpsEntity getPpsEntityValue(String key) {
		try {
			return (PpsEntity)JsonFormat.toObj(getVariablesValue(key,""), PpsEntity.class);
		} catch (Exception e) {
			logger.error("getPpsEntityValue error", e);
		}
		return null;
	}
	
	@Override
	public List<PpsEntity> getPpsEntityValues(String key) {
		try {
			List<PpsEntity> list=new ArrayList<PpsEntity>();
			String json=getVariablesValue(key,"");
			return JsonFormat.toObjects(json, PpsEntity.class);
		} catch (Exception e) {
			logger.error("getPpsEntityValue error", e);
		}
		return new ArrayList<PpsEntity>();
	}

	
	public void mailLog(MailSenderInfo info,String type){
		try {
			EmailLog log=new EmailLog();
			log.setCc(info.getCCTo());
			log.setTo(info.getToAddress());
			log.setTitle(info.getSubject());
			//log.setContent(JsonFormat.toString(info.getContent()));
			log.setContent(info.getContent() );
			log.setCreateTime(new Date());
			log.setType(type);
			saveObject(log);
		} catch (Exception e) {
			logger.error("mail log error . ", e);
		}
	}
	
	public void mailLog(String type,String title,String body,String[] accepters,String cc){
		MailSenderInfo info=new MailSenderInfo();
		info.setSubject(title);
		info.setContent(body);
		info.setToAddress(StrUtils.join(accepters, ","));
		info.setCCTo(cc);
		mailLog(info,type);
	}

	
}
