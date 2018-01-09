/* This file DownloadController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.constants.Constants.SizeType;
import com.gaopin.constants.Constants.UserPrivilegeType;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.exception.ServiceException;
import com.gaopin.service.pps.DownloadService;
import com.gaopin.service.pps.ImageInfoService;
import com.gaopin.service.pps.UserPrivilegeService;
import com.gaopin.service.pps.UserService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.SearchUtils;
import com.gaopin.web.controller.BaseController;
import com.gaopin.web.utils.RequestUtils;
@Controller
public class DownloadController extends BaseController {
	
	@Resource
	private ImageInfoService imageInfoService;
	@Resource
	private UserPrivilegeService userPrivilegeService;
	@Resource
	private UserService userService;
	@Resource
	private DownloadService downloadService;
	@Resource
	private VariablesService variablesService;
	
	@RequestMapping(value = "/dl/getImg.do")
	public String downloadImage(HttpServletRequest request, HttpServletResponse response, String corbisId, Integer type, ModelMap model){
		System.out.println("下载产品图片......");
		// 判断权限
		User user = getSessionUser(request);
		if(user==null){ // 跳转登录页
			logger.debug("用户未登录。user=" + user);
			return "redirect:/login";
		}
		
		try {
			UserPrivilegeType userPrivilegeType = UserPrivilegeType.get(type);
			if(userPrivilegeType==null){
				logger.debug("用户权限类型错误：type="+type);
				RequestUtils.setErrorInfo(100, "没有此类型下载，非QP且非OD");
				throw new ServiceException();
			}
			
			ImageInfo imageInfo = imageInfoService.getImageInfo(SearchUtils.getSplashCorbisId(corbisId));
			if(imageInfo==null){
				logger.debug("图片信息不存在, imageInfo=" + imageInfo);
				RequestUtils.setErrorInfo(101, "数据库不存在此图片");
				throw new ServiceException();
			}
			
			// 判断权限
			// 判断OD值是否合法
//		if(userPrivilegeType.ordinal()==UserPrivilegeType.OD.ordinal()){ // 如果是QD下载
//			User loadUser = userService.get(User.class, user.getId());
//			if(loadUser==null || loadUser.getOd()==null || loadUser.getOd()<=0){
//				msg = "od为0.";
//				logger.debug("od非法,od="+user.getOd());
//				return null;
//			}
//		}
			// 判断用户是否有此图库，此类型(TYPE)的下载权限，需要处理权限的状态和过期时间
			UserPrivilege userPrivilege = userPrivilegeService.getPrivilege(user.getId(), imageInfo.getCollectionId(), type);
			if(userPrivilege==null){
				// changed download logic
				/*RequestUtils.setErrorInfo(102, "没有此下载权限");
				logger.debug("用户没有此权限！userId="+user.getId()+", collectionId="+imageInfo.getCollectionId()+", type="+type);
				throw new ServiceException();*/
				userPrivilege = new UserPrivilege();
				userPrivilege.setSizeId(SizeType.SUPERMARK.getSizecode());
				downloadService.checkAndGenSuperMark(imageInfo);
			}
			
			// 根据权限生成图片地址（需要根据图片大小、后缀判断图片是否存在）
			// 如果是splash需要赋值原始的corbisID
			imageInfo.setCorbisId(corbisId);
			Map<String, Object> rstMap = downloadService.getDownloadPath(imageInfo, userPrivilege);
			if(rstMap!=null){
				String filePath = (String)rstMap.get("filePath");
				File file = new File(filePath);
				if(!file.exists()){
					logger.debug("待下载文件不存在：" + filePath);
					RequestUtils.setErrorInfo(103, "图片文件不存在");
					throw new ServiceException();
				}
				
				// 文件存在，记录日志，如果是OD下载，进行扣点
				SizeType downloadSizeType = (SizeType)rstMap.get("sizeType");
				boolean checkAndLogRst = downloadService.recordDownloadLog(imageInfo, user, userPrivilegeType, downloadSizeType);
				if(checkAndLogRst){
					boolean downloadRst = downloadFile(response, corbisId, file);
					logger.debug("用户["+user.getId()+"]下载图片["+imageInfo.getCorbisId()+"]结果："+downloadRst+", 图片地址：" + filePath);
				}
				else{
					logger.warn("进行OD下载校验失败，禁止用户下载：userId="+user.getId()+",corbisId="+imageInfo.getCorbisId());
					throw new ServiceException();
				}
			}
			else{
				RequestUtils.setErrorInfo(103, "图片文件不存在");
				logger.warn("用户下载图片不存在[userId="+user.getId()+"][corbisId="+corbisId+"]");
				throw new ServiceException();
			}
		} 
		catch (ServiceException e) {
			int errorCode = RequestUtils.getErrorCode();
			String msg = RequestUtils.getErrorMsg("");
			msg = variablesService.getVariablesValue("dl_err_msg_"+errorCode, msg);
			model.addAttribute("msg", msg);
			return "page/errordownload";
		}
		return null;
	}
	
	private boolean downloadFile(HttpServletResponse response, String corbisId, File file){
		FileInputStream fis = null;
		try{
			response.setContentType("application/x-download;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + corbisId + ".jpg");
			fis = new FileInputStream(file);
			OutputStream output = response.getOutputStream();
			BufferedOutputStream bufo = new BufferedOutputStream(output); // 对象转换成字符流
			byte[] buffer = new byte[524288];
			int length = 0;
			while ((length = fis.read(buffer)) != -1) // 读取本地文件，并在存放在buffer 数组
			{
				bufo.write(buffer, 0, length);// 预备向客户端推送
				bufo.flush();// 清空缓存，并立即推送
			}
			output.close();
			bufo.close();
			return true;
		}
		catch (Exception e) {
			logger.error("下载产品图片异常["+file.getPath()+"]：", e);
		}
		finally{
			try{
				if(fis!=null) fis.close();
			}catch (Exception e) {
			}
		}
		return false;
	}
}
