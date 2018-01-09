/* This file BottomController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gaopin.constants.Constants.MailType;
import com.gaopin.entity.FlowNews;
import com.gaopin.entity.ImageCategory;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.Photographer;
import com.gaopin.entity.VirtualCd;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.pps.BottomPageService;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.ImageCategoryService;
import com.gaopin.service.pps.PhotographerService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.service.pps.VirtualCdService;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.FileUtils;
import com.gaopin.utils.PropertyReader;
import com.gaopin.utils.RandomGen;
import com.gaopin.utils.RequestUtil;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.mail.MailSender;
import com.gaopin.utils.mail.MailSenderInfo;
import com.gaopin.web.controller.BaseController;
import com.gaopin.web.utils.RequestUtils;
@Controller
public class BottomController extends BaseController {

	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Resource
	VariablesService variablesService;
	@Resource
	private ImageCategoryService imageCategoryService;
	@Resource
	private CollectionService collectionService;
	@Resource
	private PhotographerService photographerService;
	@Resource
	private VirtualCdService virtualCdService;
	@Resource
	private BottomPageService bottomPageService;


	@RequestMapping(value = "/aboutus.html")
	public String aboutus(HttpServletRequest request, ModelMap modelMap){
		return "/bottom/aboutus";
	}
	
	@RequestMapping(value = "/terms.html")
	public String termsPolicies(HttpServletRequest request, ModelMap modelMap){
		return "/bottom/terms";
	}
	
	@RequestMapping(value = "/contactus.html")
	public String contactus(HttpServletRequest request, ModelMap modelMap){
		return "/bottom/contactus";
	}
	@RequestMapping(value = "/contactus_submit.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> contactus_submit(HttpServletRequest request, ModelMap modelMap){
		String name=getStringValue(request, "name","");
		String tel=getStringValue(request, "tel","");
		String email=getStringValue(request, "email","");
		String todo=getStringValue(request, "todo","");
		String com_name=getStringValue(request, "com_name","");
		String cookieId=getStringValue(request, "cookie_id","");
		String content="";
		content+="<br/> 第一页";
		content+="<br/> 姓名："+name;
		content+="<br/> 电话："+tel;
		content+="<br/> 邮箱："+email;
		content+="<br/> 公司名称："+com_name;
		content+="<br/> 相关事项："+todo;
		content+="<br/>cookie:"+cookieId;
		final String mc=content;
		try {
			threadPoolTaskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						String email="service@gaopinimages.com";
						MailSender msMailSender=new MailSender();
						MailSenderInfo info=new MailSenderInfo();
						info.setSubject("高品官网联系表单");
						info.setToAddress(email);
						info.setContent(mc);
						try {
							logger.info("mail out "+mc);
							msMailSender.sendtMail(info,MailType.HTML);
							variablesService.mailLog(info, "Mail");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("contributor email  errror . ",e);
					}
				}
			});
			return responseSuccess();
		} catch (Exception e) {
			logger.error("contributor post  errror . ",e);
			return responseFailure(e.getMessage());
		}
		
	}

	@RequestMapping(value = "/careers.html")
	public String careers(HttpServletRequest request, ModelMap modelMap){
		modelMap.addAttribute("list", bottomPageService.getCareers());
		return "/bottom/careers";
	}
	@RequestMapping(value = "/careers_submit.do",method=RequestMethod.POST)
//	@ResponseBody
	public String careers_submit(HttpServletRequest request,@RequestParam MultipartFile file, ModelMap modelMap){

		String name=getStringValue(request, "name","");
		String tel=getStringValue(request, "tel","");
		/////////////////////////////////////////
		String filepath="";
		String path = PropertyReader.getString("bath.download.path");
		logger.info("bath.download.path"+path);
		if(file!=null){
		try {
		String origiFileName = file.getOriginalFilename();
		String ext = origiFileName.substring(origiFileName.lastIndexOf("."));
		String fileName = System.currentTimeMillis() +"_"+ RandomGen.getRandomString(3)+ext;
		String lastpath = DateUtils.getYYYYMMDD(new Date());
		FileUtils.writeFile(file.getInputStream(), path+lastpath+"/",fileName);
		filepath=path+lastpath+"/"+fileName;
		//Map<String, Object> rst = responseSuccess("上传成功");
		//rst.put("fileName",lastpath+"/"+fileName);
		//return rst;
		} catch (IOException e) {
			logger.error("上传客户临时证件图片异常：", e);
		}
		}
		
		String info=getStringValue(request, "info","");
		final String title =getStringValue(request, "title","");
		String cookieId=getStringValue(request, "cookie_id","");
		String content="";
		content+="<br/> 第一页";
		content+="<br/> 姓名："+name;
		content+="<br/> 电话："+tel;
		content+="<br/> 相关事项："+info;
		content+="<br/>cookie:"+cookieId;
		content+="<br/>doc:"+filepath;
		final String mc=content;
		final String[] fpaths=new String[]{filepath};
//		final VariablesService fvariablesService=variablesService;
		try {
			threadPoolTaskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						String email="careers@gaopinimages.com";//careers@gaopinimages.com
						MailSender msMailSender=new MailSender();
						MailSenderInfo info=new MailSenderInfo();
						info.setSubject(title);
						info.setToAddress(email);
						info.setContent(mc);
						info.setAttachFileNames(fpaths);
						try {
							logger.info("mail out "+mc);
							msMailSender.sendtMail(info,MailType.HTML);
							variablesService.mailLog(info, "Mail");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("contributor email  errror . ",e);
					}
				}
			});
			return "/bottom/careersSucc";
		} catch (Exception e) {
			logger.error("contributor post  errror . ",e);
			return "/bottom/careersErr";
		}
	}

	@RequestMapping(value = "/news.html")
	public String news(HttpServletRequest request, ModelMap modelMap){
		int p=getIntValue(request, "p", 1);
		String type=getStringValue(request, "type","");
		//modelMap.addAttribute("list", bottomPageService.GetNews(p, type));
		modelMap.addAttribute("tags", variablesService.getPpsEntityValues("flow_gaoPinNews_label"));
		return "/bottom/news";
	}

	@RequestMapping(value = "/news.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> newspost(HttpServletRequest request, ModelMap modelMap){
		int p=getIntValue(request, "p", 1);
		String type=getStringValue(request, "type","");
		Map<String,Object> ret= responseSuccess();
		ret.put("data",bottomPageService.GetNews(p, type));
		ret.put("p",p);
		int t=bottomPageService.GetNewsCount(type);
		ret.put("t",t);
		ret.put("tp",t/5+(t%5==0?0:1));
		return ret;
	}
	
	@RequestMapping(value = "/newsdetails/{id}.html")
	public String newsdetails(HttpServletRequest request, ModelMap modelMap,@PathVariable String id){
		
		int nid=StrUtils.getIntValue(id, 1);
		FlowNews item=bottomPageService.GetNewsById(nid);
		String type=getStringValue(request, "type", "");
		
		if(StrUtils.isNotBlank(type))
			type=item.getLabel();
		modelMap.addAttribute("item", item);
		modelMap.addAttribute("list", bottomPageService.GetNewsByTime(1, type));
		modelMap.addAttribute("type", type);
		List<Integer> ids=bottomPageService.GetNewsIds(type);
		Integer prev=0;
		Integer next=0;
		if(ids!=null&&ids.size()>0)
		{
		for(int i=0;i<ids.size();i++)
		{
			if(ids.get(i)==nid)
			{
				if(i>1)
					prev=ids.get(i-1);
				if(i<ids.size()-1)
					next=ids.get(i+1);
				break;
			}
		}
		}
		
		modelMap.addAttribute("prev", prev);
		modelMap.addAttribute("next", next);
		return "/bottom/news_detail";
	}
	
	
}
