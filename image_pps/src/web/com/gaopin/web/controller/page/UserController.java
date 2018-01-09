/* This file UserController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONException;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.constants.Constants;
import com.gaopin.entity.DownloadHistory;
import com.gaopin.entity.DownloadOrder;
import com.gaopin.entity.LightBoxRel;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.SystemVariables;
import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.service.pps.LightBoxService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.service.pps.UserPrivilegeService;
import com.gaopin.service.pps.UserService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.service.pps.LotteryDrawService;
import com.gaopin.utils.CookieUtils;
import com.gaopin.utils.ImageUtils;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.MD5;
import com.gaopin.utils.PropertyReader;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.mail.MailSender;
import com.gaopin.web.controller.BaseController;

@Controller
public class UserController extends BaseController {

	@Resource
	private SearchService searchService;
	@Resource
	private LightBoxService lightBoxService;
	@Resource
	private UserService userService;
	@Resource
	private UserPrivilegeService userPrivilegeService;
	
	@Resource
	private VariablesService variablesService;
	@Resource
	private LotteryDrawService lotteryDrawService;

	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@RequestMapping(value="/registpage")
	public String pageRegist(){
		return "regist";
	}
	
	/**
	 * 用户注册
	 * @author 高顺德
	 * @param request
	 * @param userForm 
	 * @param session
	 * @return Map  state 登陆状态  0  失败 failed 1 成功 success
	 */
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> userRegist(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("registForm") User userForm,HttpSession session){
		Map<String,Object> message=new HashMap<String,Object>();
		if(provingEmail(userForm.getEmail())&&
				provingPassword(userForm.getPassword())){
			userForm.setStatus(Constants.CommonStatus.DISABLE.ordinal());
			userForm.setCreateTime(new Date());
			userForm.setUpdateTime(new Date());
			Serializable id=userService.saveObject(userForm);
			logger.info("Serializable id=userService.saveObject(userForm);"+id);
			
			if(null==id){
				message.put("message", "注册失败");
				message.put("state", "0");//state 登陆状态  0  失败 failed 1 成功 success
			}else{
				
				
				try {
				
				
				
				//密码加密:MD5(ID+MD5(密码))
				userForm.setPassword(MD5.getMd5Str(id+MD5.getMd5Str(userForm.getPassword())));
				userService.updateObject(userForm);
				logger.info("注册成功 and upate pwd . "+JsonFormat.toString(userForm));
				message.put("message", "注册成功");
				message.put("state", "1");//state 登陆状态  0  失败 failed 1 成功 success
				setSessionUser(request, userForm);
				CookieUtils.setHashCookie(response, userForm.getId());
				setUserPrivilege(request, null); // 新注册用户，设置空权限
				String body0=variablesService.getVariablesValue("mail_registration_template","");
				final String  body=body0.replace("$$$username", userForm.getEmail());
				final String mail=userForm.getEmail();
				
					threadPoolTaskExecutor.execute(new Runnable() {
					
					@Override
					public void run() {
					try {
						if(StrUtils.isNotBlank(body))
							MailSender.sendMail("高品欢迎您！", body, mail);

						variablesService.mailLog("Mail","高品欢迎您！",body,new String[]{mail},"");
					} catch (Exception e) {
						e.printStackTrace();
					}
					}
				});
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				String enable_lottery = variablesService.getVariablesValue("enable_lottery", "");
				if(Integer.parseInt(enable_lottery)==1){
					lotteryDrawService.checkAndAcceptAwardForNonLoginUser(getSessionUser(request), request.getRequestedSessionId());
				}
			}
		}else{
				message.put("message", "用户名或密码验证失败");
				message.put("state", "-1");//state 登陆状态  0  失败 failed 1 成功 success -1 用户名或密码验证不通过 
		}
		logger.info("userRegist resp"+JsonFormat.toString(message));
		return message;
	}
	
	
	/**检测用户名称
	 * @author 高顺德
	 * @param request param名称：userName
	 * @return	Map  state 用户名是否重复  0  失败 failed 1 成功 success
	 */
	@RequestMapping(value="/checkName",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkName(HttpServletRequest request){
		Map<String,Object> message=new HashMap<String,Object>();
		String userName=getStringValue(request, "userName", null);
		if(provingEmail(userName)){
			if(userService.isExist(userName)){
				message.put("message", "用户已存在");
				message.put("state", "0");//state 用户名是否重复  0  失败 failed 1 成功 success
			}else{
				message.put("message", "可以注册");
				message.put("state", "1");//state 用户名是否重复  0  失败 failed 1 成功 success
			}
		}else{
				message.put("message", "用户名验证失败");
				message.put("state", "-1");//state  用户名是否重复     -1 用户名或密码验证不通过 
		}
		return message;
	}
	
	@RequestMapping(value = {"/login"})
	public String login(HttpServletRequest request, ModelMap modelMap){
		request.getSession().setAttribute("backurl",request.getHeader("Referer"));
		String backurlString=request.getHeader("Referer");
		if(StrUtils.isBlank(backurlString)||backurlString.indexOf("login")>0
				||backurlString.indexOf("registpage")>0||backurlString.indexOf("getPwd")>0)
			backurlString="search";
		modelMap.put("backurl", backurlString);
		modelMap.put("loginedusr", CookieUtils.getCookie(request, "loginedusr")==null?"":CookieUtils.getCookie(request, "loginedusr").getValue());
		return "login";
	}
	
	/**
	 * 用户登录
	 * @author 高顺德
	 * @param request
	 * @param userForm
	 * @param session
	 * @return 	Map  state 登陆状态 0 失败 failed 1 成功 success
	 */
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> userLogin(HttpServletRequest request,@ModelAttribute("registForm") User userForm,HttpSession session,HttpServletResponse response){
		Map<String,Object> message=new HashMap<String,Object>();
		/*if(provingEmail(userForm.getEmail())&&
				provingPassword(userForm.getPassword())){*/
		
		String enable_lottery = variablesService.getVariablesValue("enable_lottery", "");
			
			
		User user=userService.getUserByLoginName(userForm.getUserName());
		if (null != user) {
			String pwd = MD5.getMd5Str(user.getId()
					+ MD5.getMd5Str(userForm.getPassword()));
			if (pwd.equals(user.getPassword())) {
				message.put("message", "登陆成功");
				message.put("state", "1");// state 登陆状态 0 失败 failed 1 成功 success
				setSessionUser(request, user);
				setUserPrivilege(request, user.getId());
				
//				CookieUtils.setCookie(response, "loginedusr", user.getUserName(), 365*24*3600);

				CookieUtils.setHashCookie(response, user.getId());
				
				if(Integer.parseInt(enable_lottery)==1){
					lotteryDrawService.checkAndAcceptAwardForNonLoginUser(user, request.getRequestedSessionId());
				}
				
				return message;
			}

		}
		
		//mail login
		User userMail=userService.getUserByLoginEmail(userForm.getUserName());
		if (null != userMail) {
			String pwd = MD5.getMd5Str(userMail.getId()
					+ MD5.getMd5Str(userForm.getPassword()));
			if (pwd.equals(userMail.getPassword())) {
				message.put("message", "登陆成功");
				message.put("state", "1");// state 登陆状态 0 失败 failed 1 成功 success
				setSessionUser(request, userMail);
				setUserPrivilege(request, userMail.getId());
				//CookieUtils.setCookie(response, "loginedusr", userMail.getUserName(), 365*24*3600);

				CookieUtils.setHashCookie(response, userMail.getId());
				
				if(Integer.parseInt(enable_lottery)==1){
					lotteryDrawService.checkAndAcceptAwardForNonLoginUser(user, request.getRequestedSessionId());
				}
				
				return message;
			}

		}
		
		message.put("message", "登陆失败");
		message.put("state", "0");//state 登陆状态  0  失败 failed 1 成功 success
		/*}else{
				message.put("message", "用户名或密码验证失败");
				message.put("state", "-1");//state 登陆状态  0  失败 failed 1 成功 success -1 用户名或密码验证不通过 
		}*/
		return message;
	}
	
	/**个人信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"/my/person"})
	public String personInfo(HttpServletRequest request,HttpSession session){
		/*setSessionUser(request, userService.get(User.class, 8));*///测试账户
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
		/*user1.setComAddress(conMap.get("comAddress")==null?null:conMap.get("comAddress").toString());
		user1.setComName(conMap.get("comName")==null?null:conMap.get("comName").toString());
		user1.setComPhone(conMap.get("comPhone")==null?null:conMap.get("comPhone").toString());
		user1.setMyMailingAddress(conMap.get("myMailingAddress")==null?null:conMap.get("comPhone").toString());*/
		request.setAttribute("testUser", user1);
		
		return "person";
	}
	
	/**
	 * 载入用户下载权限
	 * @param userId
	 */
	private void setUserPrivilege(HttpServletRequest request, Integer userId){
		List<UserPrivilege> list = userPrivilegeService.getPrivilegeList(userId);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 图库和权限类型
		for(UserPrivilege userPrivilege : list){
			Integer cid = userPrivilege.getCollectionId();
			Integer type = userPrivilege.getType();
			if(cid!=null && type!=null){
				map.put(cid, type.intValue());
			}
		}
		request.getSession().setAttribute(UserPrivilege.class.getName(), map);
	}
	
	@RequestMapping(value = {"/my/lightbox"})
	public String lightbox(HttpServletRequest request,HttpSession session){
		if(getSessionUser(request)!=null){
			session.setAttribute("sendEmailer", getSessionUser(request).getEmail());
		}
		String lightboxId = getStringValue(request, "lightboxId", "");
		request.setAttribute("lightboxId", lightboxId);
		return "user/flow_lightbox";
	}
	
	@RequestMapping(value = {"/my/cart"})
	public String cart(HttpServletRequest request,HttpSession session){
		if(getSessionUser(request)!=null){
			session.setAttribute("sendEmailer", getSessionUser(request).getEmail());
		}
		String cartid = getStringValue(request, "cartId", "");
		request.setAttribute("cartId", cartid);
		return "user/cart";
	}
	
	/**
	 * @author 高顺德
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"/my/myod"})
	public String myOD(HttpServletRequest request){
//		User user=userService.get(User.class, 8);
//		setSessionUser(request, userService.get(User.class, 10));//测试用的代码
		int p=Integer.parseInt(StrUtils.getNullStr(request.getParameter("p"),"1"))-1;
		int ps=Integer.parseInt(StrUtils.getNullStr(request.getParameter("ps"),"50"));
		List<DownloadOrder> order = null;
		try {
			order = userService.getDownLoadOrder(getSessionUserId(request),p,
					ps,Constants.UserPrivilegeType.OD.ordinal()
					);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (order!=null) {
			for (int i = 0; i < order.size(); i++) {
				order.get(i).setItemCount(
						(int) userService.getItemCountByOrder(order.get(i)
								.getId()));
			}
		}
		request.setAttribute("orderitem", order);
		try {
			request.setAttribute("pageCount", userService.getOrderPageCount(
					getSessionUserId(request),p,
					ps,Constants.UserPrivilegeType.OD.ordinal()
					));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		request.setAttribute("entityCount", order==null?0:order.size());

		return "user/myod";
	}
	
	/**
	 * @author 高顺德
	 * @param request
	 * @return
	 */
	@RequestMapping(value = {"/my/myqp"})
	public String myQP(HttpServletRequest request){
		int p=Integer.parseInt(StrUtils.getNullStr(request.getParameter("p"),"1"))-1;
		int ps=Integer.parseInt(StrUtils.getNullStr(request.getParameter("ps"),"50"));
		List<DownloadOrder> order = null;
		try {
			order = null;
//			order = userService.getDownLoadOrder(
//					getSessionUserId(request),p,
//							ps,Constants.UserPrivilegeType.QP.ordinal()
//					);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (order!=null) {
			for (int i = 0; i < order.size(); i++) {
				order.get(i).setItemCount(
						(int) userService.getItemCountByOrder(order.get(i)
								.getId()));
			}
		}
		request.setAttribute("orderitem", order);
		try {
			request.setAttribute("pageCount", 1
//					userService.getOrderPageCount(
//					getSessionUserId(request),p,
//					ps,Constants.UserPrivilegeType.QP.ordinal())
					);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		request.setAttribute("entityCount", order==null?0:order.size());

		return "user/flow_myqp";
	}
	
	
	/**
	 * 用户注册
	 * @author 高顺德
	 */
	@RequestMapping(value="/my/myQPPage")
	@ResponseBody
	public Map<String,Object> myQPPage(HttpServletRequest request){
		Map<String,Object> message=new HashMap<String,Object>();
		int p=Integer.parseInt(StrUtils.getNullStr(request.getParameter("p"),"1"))-1;
		int ps=Integer.parseInt(StrUtils.getNullStr(request.getParameter("ps"),"50"));
		int type=Integer.parseInt(StrUtils.getNullStr(request.getParameter("type"),"0"));
		try {
			List<DownloadOrder> list=userService.getDownLoadOrder(
					getSessionUserId(request),p,
					ps
					,type);
			
			if (list!=null) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setItemCount(
							(int) userService.getItemCountByOrder(list.get(i)
									.getId()));
				}
			}
			message.put("orderItems", list);
			message.put("pageCount", userService.getOrderPageCount(
					getSessionUserId(request),p,
					ps
					,type
					));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	/**修改个人信息
	 * @author 高顺德
	 * @param request param名称：userName
	 * @return	Map  state 用户名是否重复  0  失败 failed 1 成功 success
	 */
	@RequestMapping(value="/my/updateMyInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateMyInfo(HttpServletRequest request,@ModelAttribute("gerenziliao") User myInfo){
		Map<String,Object> message=new HashMap<String,Object>();
		
		/*setSessionUser(request, userService.get(User.class, 8));*/
		
		User user=getSessionUser(request);
		 
		Integer isByEmail = StrUtils.getIntValue(getStringValue(request,"isByEmail",""), -1);
		Integer isTellNew = StrUtils.getIntValue(getStringValue(request,"isTellNew",""), -1);
		Integer isTellNewProduct = StrUtils.getIntValue(getStringValue(request,"isTellNewProduct",""), -1);
		
		//String userName=getStringValue(request, "userName", null);
		try {
			if(isTellNewProduct>=0)
			{
				user.setIsTellNewProduct(isTellNewProduct);
			}
			else {
				user.setIsTellNewProduct(1);
			}
			if(isTellNew>=0)
			{
				user.setIsTellNew(isTellNew);
			}
			else {
				user.setIsTellNew(1);
			}
			if(isByEmail>=0)
			{
				user.setIsByEmail(isByEmail);
			}
			else {
				user.setIsByEmail(1);
			}
			
			
			userService.updateObject(user);
		} catch (Exception e) {
			message.put("message","修改失败，请联系技术人员");
			message.put("state", "0");//state   0  失败 failed 1 成功 success
		}
		message.put("message","修改成功");
		message.put("state", "1");//state   0  失败 failed 1 成功 success
		
		return message;
	}
	
	
	
	/**修改公司信息
	 * @author 高顺德
	 * @param request param名称：userName
	 * @return	Map  state 用户名是否重复  0  失败 failed 1 成功 success
	 */
	@RequestMapping(value="/my/updateComInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateComInfo(HttpServletRequest request,@ModelAttribute("comForm") User comInfo){
		Map<String,Object> message=new HashMap<String,Object>();
		
		/*setSessionUser(request, userService.get(User.class, 8));*/
		Map<String,Object> conMap=null;
		Map<String,Object> userConMap=null;
		User user=getSessionUser(request);
		if(null!=comInfo&&comInfo.getContactsInfo()!=null){
			conMap= JsonFormat.toMap(comInfo.getContactsInfo());
		}
		if(1==1){ //user.getContactsInfo()!=null ){
			try {
				userConMap= JsonFormat.toMap(user.getContactsInfo());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(null!=conMap){
			if(null!=userConMap){
				Set<String> key=conMap.keySet();
				for (Iterator<String> iterator = key.iterator(); iterator.hasNext();) {
					String string = iterator.next();
					userConMap.put(string, conMap.get(string));
				}
				user.setContactsInfo(JsonFormat.toString(userConMap));
				
			}else{
				user.setContactsInfo(JsonFormat.toString(conMap));
			}
			user.setJobTitle(comInfo.getJobTitle());
			user.setLastName(comInfo.getLastName());
			//user.setFirstName("");
			user.setSex(comInfo.getSex());
			user.setUserName(comInfo.getUserName());
		}
		//String userName=getStringValue(request, "userName", null);
		try {
			userService.updateObject(user);
		} catch (Exception e) {
			message.put("message","修改失败，请联系技术人员");
			message.put("state", "0");//state   0  失败 failed 1 成功 success
		}
		message.put("message","修改成功");
		message.put("state", "1");//state   0  失败 failed 1 成功 success
		
		return message;
	}
	
	
	/**修改密码
	 * @author 高顺德
	 * @param request 
	 * @return	Map  state 0  失败 failed 1 成功 success
	 */
	@RequestMapping(value="/my/updatemypwd.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateMyPwd(HttpServletRequest request){
		Map<String,Object> message=new HashMap<String,Object>();
		message.put("message","修改成功");
		message.put("state", "1");//state   0  失败 failed 1 成功 success
		String currentPassword=request.getParameter("CurrentPassword");
		String newPassword=request.getParameter("NewPassword");
		
		if(provingPassword(newPassword)){
			User user=getSessionUser(request);
			if(user.getPassword().equals(MD5.getMd5Str(user.getId()+MD5.getMd5Str(currentPassword)))){
			
				user.setPassword(MD5.getMd5Str(user.getId()+MD5.getMd5Str(newPassword)));
				try {
					userService.updateObject(user);
					message.put("message","修改成功");
					message.put("state", "1");//state   0  失败 failed 1 成功 success
				} catch (Exception e) {
					message.put("message","修改失败");
					message.put("state", "0");//state   0  失败 failed 1 成功 success
					e.printStackTrace();
				}
			}else{
				message.put("message","修改失败，请输入正在使用的密码");
				message.put("state", "0");//state   0  失败 failed 1 成功 success
			}
		}else{
			message.put("message","修改失败，请请使用长度大于6位小于20位的密码");
			message.put("state", "-1");//state   0  失败 failed 1 成功 success
		}
		return message;
	}

	private boolean provingPassword(String password) {
		if(password!=null&&password.length()>=6&&password.length()<=20){
			return true;
		}
		return false;
	}

	/**用户名是Eamil 
	 * @param email 用户名
	 * @return boolean
	 */
	private boolean provingEmail(String email) {
		if(email!=null&&email.length()>=5){
			return true;
		}
		return false;
	}
	@RequestMapping(value="/registSuccess.do")
	public String getSuccess(HttpServletRequest request){
		return "registSuccess";
	}
	@RequestMapping(value="/getPwd")
	public String getPwdget(HttpServletRequest request){
		
		 
		return "getPwd";
	}
	@RequestMapping(value="/resetpwd.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getPwd(HttpServletRequest request,@ModelAttribute("registForm") User userForm,HttpSession session){
		Map<String,Object> message=new HashMap<String,Object>();
		 	
		User user=userService.getUserByLoginName(userForm.getUserName());
		if (null != user) {

			//userid
			int id = user.getId();
			//获取pwd
			user=userService.ResetPasswordAndSendmail(id);
			//发邮件
			
			//返回
			if(user!=null){
			message.put("message", "受理成功");
			message.put("state", "1");
			}
			else{
				message.put("message", "");
				message.put("state", "0");
			}
			return message;

		}
		message.put("message", "");
		message.put("state", "0");
		 
		return message;
	}
	
	
	/**
	 * 小样图下载内容页
	 * @author 高顺德
	 */
	@RequestMapping(value="/my/qpdetail/{orderId}")
	public String OPDetail(HttpServletRequest request,@PathVariable Integer orderId){
		if(orderId!=null){
			List<DownloadHistory> list=userService.getDownloadHistoryByOrderId(orderId);
			if(list!=null){
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setImgViewPath(SearchUtils.getImageFullPath(list.get(i).getCorbisId()));
					//dl/getImg.do?type=0&corbisId=
					list.get(i).setImgDownloadPath("dl/getImg.do?type="+list.get(i).getType()+"&corbisId="+list.get(i).getCorbisId());
					list.get(i).setDays(getDownloadImgDays(list.get(i).getCreateTime()));
				}
			}
			
			request.setAttribute("orderItems", list);
			request.setAttribute("itemscount", list.size());
		}
		return "user/qpdetail";
	}
	
	private long getDownloadImgDays(Date createDate){
		if(createDate!=null){
		    long to = 0;
			long from = 0;
			try {
				to =new Date().getTime();
				from = createDate.getTime();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(to<from){
				return 0;
			}
			
		    return 60-((to - from) / (1000 * 60 * 60 * 24));
		}
		return 0;
	}
	
	public static void main(String[] args){
		System.out.println(MD5.getMd5Str( MD5.getMd5Str("yunzhi123")));
	}
	
	@RequestMapping(value="/checkUserLogin.do",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkUserLogin(HttpServletRequest request,HttpSession session){
		Map<String,Object> message=new HashMap<String,Object>();
		 	
		User user = (User)session.getAttribute(User.class.getName());
		if(user!=null){
			message.put("message", "已登录");
			message.put("state", "1");
		}
		else {
			message.put("message", "未登录");
			message.put("state", "0");
		}
		
		return message;
	}
	
	
	
	@RequestMapping(value="/my/myHistory")
	@ResponseBody
	public Map<String,Object> myHistory(HttpServletRequest request){
		Map<String,Object> message=new HashMap<String,Object>();
		int p=Integer.parseInt(StrUtils.getNullStr(request.getParameter("p"),"1"))-1;
		int ps=Integer.parseInt(StrUtils.getNullStr(request.getParameter("ps"),"50"));
		int type=Integer.parseInt(StrUtils.getNullStr(request.getParameter("type"),"0"));
		
		String typeSearch = getStringValue(request, "type", "");
		String sDate = getStringValue(request, "sDate", "");
		String eDate = getStringValue(request, "eDate", "");
		try {
			
			List<DownloadHistory> list=  userService.getHistory(getSessionUserId(request),p,ps,type,typeSearch,sDate,eDate);
			long count = userService.getHistoryPageCount(getSessionUserId(request),p,ps,type,sDate,eDate);
			
			List<String> ids = new ArrayList<String>();
			for (DownloadHistory lbr : list) {
				ids.add(lbr.getCorbisId());
			}
			List<PreviewImageInfo> lightsValue = new ArrayList<PreviewImageInfo>();
			lightsValue = searchService.getPreviewListSplashEnable(ids);
			Map<String, PreviewImageInfo> map = new HashMap<String, PreviewImageInfo>();
			for (PreviewImageInfo preview : lightsValue) {
//				if(typeSearch.equals("2"))//RM
//				{
//					if(preview.getModelRelease().equals("2"))
//					{
//						map.put(preview.getCorbisId(), preview);
//					}
//				}
//				else {
//					if(!preview.getModelRelease().equals("2"))
//					{
						map.put(preview.getCorbisId(), preview);
//					}
//				}
				
			}
			message.put("map", map);
			message.put("data", list);
			message.put("pageCount", count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return message;
	}
}
