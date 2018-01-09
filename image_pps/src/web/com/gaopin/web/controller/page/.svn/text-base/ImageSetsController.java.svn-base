/* This file ImageSetsController.java is part of image_pps .
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
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.constants.Constants;
import com.gaopin.constants.Constants.SizeType;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.User;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.ImageSetService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.ImageUtils;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.BaseController;
import com.gaopin.web.utils.RequestInfo;
import com.gaopin.web.utils.RequestUtils;

@Controller
public class ImageSetsController extends BaseController {
	@Resource
	private ImageSetService imageSetService;
	@Resource
	private SearchService searchService;
	@Resource
	private VariablesService variablesService;
	@Resource
	private CollectionService collectionService;
	@RequestMapping(value = { "/imgsets{sid}", "/imgsets/{sid}",
			"/imgset/{sid}" })
	public String imagessets(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap,
			@PathVariable Integer sid) {
		
		User user = getSessionUser(request);
		RequestInfo requestInfo = RequestUtils.getContain();
		if(requestInfo==null){
			requestInfo = new RequestInfo(request, response);
			RequestUtils.setContain(requestInfo);
			RequestUtils.setUser(user);
		}
		
		String s=getStringValue(request, "s", "");
		if(s.equals("1"))
		{
			imageSetService.cleanCache();
		}
		
		//////////////////////////////////////////////////////////////////////
		if (sid == null || sid <= 0)
		{
			int p=getIntValue(request, "p", 1);
			modelMap.addAttribute("item1", variablesService.getPpsEntityValue("flow_imageSetLanding_1"));
			modelMap.addAttribute("list",imageSetService.getTopList(p,-1));
			modelMap.addAttribute("map",imageSetService.getTopMap(p,-1));
			int total=imageSetService.getTopCount();
			int tp=total/Constants.imageSet_PageSize+(total%Constants.imageSet_PageSize==0?0:1);
			modelMap.addAttribute("tp",tp);
			modelMap.addAttribute("p",p);
			return "page/imagessetslading";
		}else {
			modelMap.addAttribute("item1", imageSetService.getItem(sid));
			modelMap.addAttribute("list",imageSetService.getTopList(1,1000));
			modelMap.addAttribute("map",imageSetService.getTopMap(1,1000));
			List<PreviewImageInfo> list=imageSetService.getImages(sid);
			modelMap.addAttribute("imglist",list);
			modelMap.addAttribute("imgcount",list.size());
			return "page/imagessets";
		}

	}
	


	@RequestMapping(value = {"/imagesetsview/{sid}/{gaopinId}.jpg"})
	@ResponseBody
	public void showPreview(HttpServletRequest request, HttpServletResponse response, @PathVariable String gaopinId,@PathVariable int sid){
		if(StrUtils.isBlank(gaopinId)) return;
		ImageInfo imageInfo = searchService.getImageInfoByCorbisIdCache(gaopinId);
		if(imageInfo==null) return;
		if(!imageSetService.checkImages(sid, gaopinId)) return;
		
		ImageCollection collection = collectionService.getCollection(imageInfo.getCollectionId());  //Sean
		String ext = collection.getExt();  //Sean
		String subPath = SearchUtils.getImageFullPath(gaopinId);
		File showFile = null;
		String previewPath = SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.M2.getPath()+"/"+subPath;
		previewPath+=ext; //Sean
		showFile = new File(previewPath);
		FileInputStream fis = null;
		try{
			if(!showFile.exists()){
				logger.warn("2M图不存在, imagePath="+showFile.getPath());
				showFile=new File(ImageSetsController.class.getResource("/default.jpg").getFile());
				if(!showFile.exists()){
					return;
				}
			}
			fis = new FileInputStream(showFile);
			OutputStream output = response.getOutputStream();
			BufferedOutputStream bufo = new BufferedOutputStream(output);
			byte[] buffer = new byte[524288];
			int length = 0;
			while ((length = fis.read(buffer)) != -1) {
				bufo.write(buffer, 0, length);
				bufo.flush();
			}
			output.close();
			bufo.close();
		}
		catch (Exception e) {
			logger.error("登录用户显示预览图异常imagePath="+showFile.getPath(), e);
		}
		finally{
			try{
				if(fis!=null) fis.close();
			}catch (Exception e) {
			}
		}
	}
}
