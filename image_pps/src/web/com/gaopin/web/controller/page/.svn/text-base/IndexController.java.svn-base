/* This file IndexController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.ezmorph.bean.MorphDynaBean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gaopin.entity.IndexBigview;
import com.gaopin.entity.PpsEntity;
import com.gaopin.service.pps.IndexPageService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.JsonFormat;
import com.gaopin.web.controller.BaseController;
@Controller
public class IndexController extends BaseController {
	@Resource
	private IndexPageService indexPageService;
	
	@Resource
	private VariablesService variablesService;
	
	@RequestMapping(value = {"/error"})
	public String error(HttpServletRequest request, ModelMap modelMap){
		
		return "page/errornotfound";
	}
	@RequestMapping(value = {"/", "/index"})
	public String index(HttpServletRequest request, ModelMap modelMap){
		try {
		List<IndexBigview> list= indexPageService.getIndexBigviews();
		if(getStringValue(request, "s", "0").equals("1"))
			variablesService.cleanCache();
		//int count =list.size();		
		//int index = (int)(Math.random()*100)%count;
		//List<IndexBigview> newList = new ArrayList<IndexBigview>();
		//newList.add(list.get(index));
		//modelMap.put("list", newList);
		
		modelMap.put("list", list);
		//modelMap.put("imgFirst", list.get(index));
		modelMap.put("delay", indexPageService.GetIndexDelay());
		modelMap.put("duration", indexPageService.GetIndexDuration());
		modelMap.put("listSize", 1);

		//首页推广
		PpsEntity questionType =  variablesService.getPpsEntityValue("flow_index_questionType");
		modelMap.put("questionType", questionType.getInfo());
		if(questionType.getInfo().equals("1"))
		{
			PpsEntity questionI =  variablesService.getPpsEntityValue("flow_index_questionI");
			modelMap.put("questionISrc", questionI.getSrc());
			modelMap.put("questionIUrl", questionI.getUrl());
		}
		else
		{
			List<PpsEntity> questionII = variablesService.getPpsEntityValues("flow_index_questionII");
				
			modelMap.put("questionIITitle", questionII.get(0).getTitle());
			modelMap.put("questionIIInfo", questionII.get(0).getInfo());
			modelMap.put("questionIISrc", questionII.get(0).getSrc());
			modelMap.put("questionIIUrl", questionII.get(0).getUrl());

			modelMap.put("questionIISrc0", questionII.get(1).getSrc());
			modelMap.put("questionIIUrl0", questionII.get(1).getUrl());
		}
		//推广——窄屏
		PpsEntity questionSM =  variablesService.getPpsEntityValue("flow_index_question_sm");
		modelMap.put("questionSMInfo", questionSM.getInfo());//描述1
		modelMap.put("questionSMSrc", questionSM.getSrc());//描述2
		modelMap.put("questionSMUrl", questionSM.getUrl());
		modelMap.put("questionSMTitle", questionSM.getTitle());
		
		
		//最新上线
		//String newOnline =  variablesService.getVariablesValue("flow_index_newOnline", "");
		List<PpsEntity> online = variablesService.getPpsEntityValues("flow_index_newOnline");
		//Object[] online =  JsonFormat.toArray(newOnline);

		int index=0;
		for (PpsEntity jobj : online) {
			index++;
			modelMap.put("newOnlineTitle"+index, jobj.getTitle());
			modelMap.put("newOnlineSrc"+index, jobj.getSrc());
			modelMap.put("newOnlineUrl"+index, jobj.getUrl());
			
		}
		
		
		//高品之选
		//String gaopinSelect =  variablesService.getVariablesValue("flow_index_gaopinSelect", "");
		List<PpsEntity> select = variablesService.getPpsEntityValues("flow_index_gaopinSelect");
		logger.info(select.size());
		index=0;
		for (PpsEntity jobj : select) {
			index++;
			modelMap.put("gaopinSelectTitle"+index, jobj.getTitle());
			modelMap.put("gaopinSelectSrc"+index, jobj.getSrc());
			modelMap.put("gaopinSelectUrl"+index, jobj.getUrl());
			
		}
		
		
		} catch (Exception e) {
			logger.error("index error",e);
		}
		return "index";
	}
	@RequestMapping(value = {"/index2"})//页面
	public String index2(HttpServletRequest request, ModelMap modelMap){
		List<IndexBigview> list= indexPageService.getIndexBigviews();
		
		modelMap.put("list", list);
		modelMap.put("delay", indexPageService.GetIndexDelay());
		modelMap.put("duration", indexPageService.GetIndexDuration());
		
		return "index2";
	}
	@RequestMapping(value = {"/index3"})//iframe 静态页面
	public String index3(HttpServletRequest request){
		return "index3";
	}
	
	@RequestMapping(value = {"/index4"})//页面
	public String index4(HttpServletRequest request, ModelMap modelMap){
		try {
			List<IndexBigview> list= indexPageService.getIndexBigviews();
			modelMap.put("list", list);
			modelMap.put("imgFirst", list.get(0));
			modelMap.put("delay", indexPageService.GetIndexDelay());
			modelMap.put("duration", indexPageService.GetIndexDuration());
			modelMap.put("listSize", list.size());
		} catch (Exception e) {
			logger.error(e);
		}
		return "index";
	}
	
	@RequestMapping(value = {"/lottery"})//抽奖说明页面
	public String lottery(HttpServletRequest request){
		return "user/lottery";
	}
}
