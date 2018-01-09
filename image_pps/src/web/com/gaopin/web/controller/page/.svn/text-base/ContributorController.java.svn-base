/* This file ContributorController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONException;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.constants.Constants.MailType;
import com.gaopin.entity.Contributor;
import com.gaopin.entity.Questionnaire;
import com.gaopin.entity.SystemVariables;
import com.gaopin.entity.User;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.BeanUtils;
import com.gaopin.utils.CookieUtils;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.mail.MailSender;
import com.gaopin.utils.mail.MailSenderInfo;
import com.gaopin.web.controller.BaseController;

@Controller
public class ContributorController extends BaseController {

	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Resource
	VariablesService variablesService;
	
	@RequestMapping(value="/Contributor/index.na")
	public String index(){
		return "contributor/index";
	}
	
	@RequestMapping(value="/Contributor/submit.na",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submit(HttpServletRequest request,HttpServletResponse response,HttpSession session,@ModelAttribute Contributor contributor)
	{
		try {
			
		contributor.setIp(request.getRemoteAddr());
		contributor.setCreateTime(new Date());
		contributor.setUpdateTime(new Date());
		contributor.setUa(request.getHeader("user-agent"));
		contributor.setUserId(getSessionUserId(request));
		contributor.setCookieId(getStringValue(request, "cookie_id", ""));
		baseService.saveObject(contributor);
		session.setAttribute("cookieId", contributor.getCookieId());
		final Contributor con=contributor;
		//sned mail 
		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String email="contributor@gaopinimages.com";
					MailSender msMailSender=new MailSender();
					MailSenderInfo info=new MailSenderInfo();
					info.setSubject("高品供稿人申请");
					info.setToAddress(email);
					String content = "";
					content+="<br/> 第一页";
					content+="<br/> 姓名："+con.getName();
					content+="<br/> 地址："+con.getAddr();
					content+="<br/> 电话："+con.getTel();
					content+="<br/> 邮箱："+con.getEmail();
					content+="<br/> 网站："+con.getWebsite();
					content+="<br/> 第二页";
					content+="<br/> 多少年："+con.getA21();
					content+="<br/> 兴趣："+con.getA22();
					content+="<br/> 领域："+con.getA23();
					content+="<br/> 领域其他："+con.getA24();
					content+="<br/> 第三页";
					content+="<br/> 是否合作过："+con.getA31();
					content+="<br/> 合作公司："+con.getA32();
					content+="<br/> 方式："+con.getA33();
					content+="<br/> 形式："+con.getA34();
					content+="<br/> 第四页";
					content+="<br/> 数量："+con.getA41();
					content+="<br/> 描述："+con.getA42();
					content+="<br/> 每月数量："+con.getA43();
					content+="<br/> 图像大小："+con.getA44();
					content+="<br/> 拍摄器材"+con.getA45();
					content+="<br/> ====================================";
					
					info.setContent(content);
					try {
						logger.info("mail out "+content);
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

}
