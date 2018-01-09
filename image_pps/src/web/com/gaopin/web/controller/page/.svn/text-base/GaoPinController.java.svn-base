/* This file GaoPinController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.utils.PropertyReader;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.mail.MailSender;
import com.gaopin.web.controller.BaseController;

@Controller
public class GaoPinController extends BaseController {
	

	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	@RequestMapping(value="/cookie")
	public String cookie(){
		return "static/cookie";
	}
	
	@RequestMapping(value="/privacy")
	public String privacy(){
		return "static/privacy";
	}
	
	@RequestMapping(value="/usera")
	public String userAgreement(){
		return "static/useragreement";
	}
	
	@RequestMapping(value="/callme")
	public String callMe(){
		return "static/callme";
	}
	
	@RequestMapping(value="/job")
	public String job(){
		return "static/job";
	}
	
	@RequestMapping(value="/myinfo")
	public String myInof(){
		return "static/myinfo";
	}
	
	@RequestMapping(value="/tellme")
	public String callMe1(){
		return "static/callme1";
	}
	
	@RequestMapping(value="/contactus",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> contactus(HttpServletRequest request){
		
		Map<String, Object> msg = new HashMap<String, Object>();
		if (request != null) {
			final String about=getStringValue(request,"about","");
			final String lastName=getStringValue(request,"lastName","");
			final String firstName=getStringValue(request,"firstName","");
			final String email=getStringValue(request,"email","");
			final String telephone=getStringValue(request,"telephone","");
			final String myProvince=getStringValue(request,"myProvince","");
			final String comments=getStringValue(request,"comments","");
			
			try {
				threadPoolTaskExecutor.execute(new Runnable() {
					
					@Override
					public void run() {
					try {
						MailSender.sendMail(
								"用户发来的关于:"+about+"信件</br>",
								"用户姓名为："+lastName+firstName
											+ "</br>Email为："+email
											+"发送来的信件 </br>用户的联系电话为："+telephone
											+ "</br>用户的省份:"+myProvince
											+ "</br>留言内容为："
											+ comments,
											PropertyReader.getString("mail.username"));
							
					} catch (Exception e) {
						e.printStackTrace();
					}
					}
				});
				
				
				msg.put("msg", "发送成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				msg.put("msg", "发送失败");
			}

		} else {
			msg.put("msg", "发送失败");
		}

		return msg;
		
		
	}
}
