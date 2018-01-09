/* This file QuestionnaireController.java is part of image_pps .
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.constants.Constants.MailType;
import com.gaopin.entity.Questionnaire;
import com.gaopin.entity.SystemVariables;
import com.gaopin.entity.User;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.CookieUtils;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.mail.MailSender;
import com.gaopin.utils.mail.MailSenderInfo;
import com.gaopin.web.controller.BaseController;

@Controller
public class QuestionnaireController extends BaseController {

	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Resource
	VariablesService variablesService;
	
	@RequestMapping(value="/Questionnaire/index.na")
	public String index(){
		return "questionnaire/index";
	}

	@RequestMapping(value="/Questionnaire/submit.na",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> submit(HttpServletRequest request,HttpServletResponse response,Questionnaire ques,HttpSession session)
	{
		ques.setIp(request.getRemoteAddr());
		ques.setCrateTime(new Date());
		ques.setUpdateTime(new Date());
		ques.setUa(request.getHeader("user-agent"));
		baseService.saveObject(ques);
		session.setAttribute("cookieId", ques.getCookieId());
		return responseSuccess();
	}
	
	
	@RequestMapping(value={"/Questionnaire/step2.na","/Questionnaire/Questionnaire/step2.na"})
	public String indexs2(){
		return "questionnaire/step2";
	}
	
	
	@RequestMapping(value={"/Questionnaire/step3.do","/Questionnaire/Questionnaire/step3.do"})
	public String indexs3(HttpServletRequest request,HttpSession session){
		
		User user1=getSessionUser(request);
		if(null!=user1&&user1.getContactsInfo()!=null){
			Map<String, Object> conMap;
			try {
				conMap = JsonFormat.toMap(user1.getContactsInfo());
				request.setAttribute("conMap", conMap);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("testUser", user1);
		
		String loginString = getStringValue(request, "login", "0");
		request.setAttribute("login", loginString);
		
		return "questionnaire/step3";
	}
	
	@RequestMapping(value={"/Questionnaire/step4.do","/Questionnaire/Questionnaire/step4.do"})
	public String indexs4(HttpServletRequest request,HttpSession session,String A16){
		
		String cookieId=CookieUtils.getCookieValue(request, "cookieId");
		List<Questionnaire> list= baseService.getController().findBy(Questionnaire.class, "cookieId", cookieId, "id", false);
		if(list.size()>0)
		{
			Questionnaire ques=list.get(0);
			ques.setA16(A16);
			
			User user = (User)session.getAttribute(User.class.getName());
			if(user!=null){
				Integer userId = user.getId();
				ques.setUserId(userId);
			}
			
			
			baseService.updateObject(ques);
		}
		return "questionnaire/step4";
	}
	
	@RequestMapping(value="/Questionnaire/outmail.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> outmail(HttpServletRequest request,String formEmail)
	{
		String emails = formEmail;
		if(StrUtils.isBlank(emails))
			return responseFailure("邮箱为能不空");
		final String[] emailStrings=emails.split(",");
		//save emails. 
		String cookieId=CookieUtils.getCookieValue(request, "cookieId");
		List<Questionnaire> list= baseService.getController().findBy(Questionnaire.class, "cookieId", cookieId, "id", false);
		if(list.size()>0)
		{
			Questionnaire ques=list.get(0);
			ques.setOutEmails(emails);
			baseService.updateObject(ques);
		}
		User user=getSessionUser(request);
		if(user==null)
			return responseFailure("您需要登录");
		String uname=StrUtils.getNullStr(user.getFirstName(), "")+StrUtils.getNullStr(user.getLastName(), "");
		if(StrUtils.isBlank(uname))
			uname=StrUtils.getNullStr(user.getEnName(),"");
		if(StrUtils.isBlank(uname))
			uname=StrUtils.getNullStr(user.getUserName(),"");
		if(StrUtils.isBlank(uname))
			uname=StrUtils.getNullStr(user.getEmail(),"");
		final String username=uname;
		///////////////////////////////////////////////////////////////
		
		//sned mail 
		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					for (String email : emailStrings) {
						if(StrUtils.isBlank(email))
							continue;
						MailSender msMailSender=new MailSender();
						MailSenderInfo info=new MailSenderInfo();
						info.setSubject("好礼大家享，参与有惊喜-高品图像");
						info.setToAddress(email);
						
						SystemVariables objVariables = variablesService.getVariables("mail_questionnaire_template");
						String content = objVariables.getValue();
						content=content.replace("$$$username", username);
						info.setContent(content);
						try {
							logger.info("mail out "+content);
							msMailSender.sendtMail(info,MailType.HTML);
							variablesService.mailLog(info, "Mail");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		return responseSuccess();
	}
	
	@RequestMapping(value="/Questionnaire/updateUserId.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateUserId(HttpServletRequest request,HttpSession session)
	{
		User user = (User)session.getAttribute(User.class.getName());
		if(user!=null){
			Integer userId = user.getId();
			String cookieId=CookieUtils.getCookieValue(request, "cookieId");
			List<Questionnaire> list= baseService.getController().findBy(Questionnaire.class, "cookieId", cookieId, "id", false);
			if(list.size()>0)
			{
				Questionnaire ques=list.get(0);
				ques.setUserId(userId);
				baseService.updateObject(ques);
			}
		///////////////////////////////////////////////////////////////
		}
		
		return responseSuccess();
	}
	
	@RequestMapping(value="/Questionnaire/updateA16.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateA16(HttpServletRequest request,String A16,HttpSession session)
	{
			String cookieId=CookieUtils.getCookieValue(request, "cookieId");
			List<Questionnaire> list= baseService.getController().findBy(Questionnaire.class, "cookieId", cookieId, "id", false);
			if(list.size()>0)
			{
				Questionnaire ques=list.get(0);
				ques.setA16(A16);
				
				User user = (User)session.getAttribute(User.class.getName());
				if(user!=null){
					Integer userId = user.getId();
					ques.setUserId(userId);
				}
				
				
				baseService.updateObject(ques);
			}
		///////////////////////////////////////////////////////////////
		
		return responseSuccess();
	}
}
