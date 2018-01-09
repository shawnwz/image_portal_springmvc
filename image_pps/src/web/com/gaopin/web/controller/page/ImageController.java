/* This file ImageController.java is part of image_pps .
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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants.SizeType;
import com.gaopin.entity.ImageCategory;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.ImageGroup;
import com.gaopin.entity.ImageGroupImage;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.ImageInfoExtend;
import com.gaopin.entity.Keywords;
import com.gaopin.entity.Photographer;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.ImageInfoService;
import com.gaopin.service.pps.KeywordService;
import com.gaopin.service.pps.LightBoxService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.EncodeingHelper;
import com.gaopin.utils.ImageUtils;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.BaseController;
import com.gaopin.web.utils.RequestInfo;
import com.gaopin.web.utils.RequestUtils;
@Controller
public class ImageController extends BaseController{
	
	@Resource
	private CollectionService collectionService;
	@Resource
	private CacheService cacheService;
	@Resource
	private SearchService searchService;
	@Resource
	private KeywordService keywordService;
	@Resource
	private ImageInfoService imageInfoService;   
	@Resource
	private ImageGroupService imageGroupService;
	@Resource
	private LightBoxService lightBoxService;
	
	private String showSplashDetail(HttpServletRequest request, ModelMap modelMap, String corbisId){
		try {
			if(corbisId!=null){
				String splashId = SearchUtils.getSplashCorbisId(corbisId);
				ImageInfo imageInfo = null;
				try{
					imageInfo = (ImageInfo)cacheService.getRemote(splashId);
				}catch (Exception e) {
					logger.warn("从memcached获取图片异常["+corbisId+"]：", e);
				}
				if(imageInfo==null){
					imageInfo = searchService.getImageInfoByCorbisId(corbisId);
				}
				if(imageInfo!=null){
					if(imageInfo.getPhotographerId()==null)
						imageInfo.setPhotographerId(0);
					Photographer photographer = baseService.getByLocalCache(Photographer.class, imageInfo.getPhotographerId());
					ImageCollection collection = collectionService.getCollection(imageInfo.getCollectionId());
					ImageCategory imageCategory = baseService.getByLocalCache(ImageCategory.class, imageInfo.getCategoryId());
					String modeRelease = imageInfo.getModeStatus()!=null && imageInfo.getModeStatus()==2 ?"有授权":"没有授权";
					String propertyRelease = imageInfo.getPropertyStatus()!=null && imageInfo.getPropertyStatus()==2 ?"有授权":"没有授权";
					
					String licenseType = imageInfo.getLicenseType()!=null && imageInfo.getLicenseType()==2 ? "RM":"RF";
					String maxSize = StrUtils.getNullStr(imageInfo.getMaxSize(), "");
					if(maxSize.startsWith("0")){
						maxSize = "";
					}
					modelMap.put("corbisId", corbisId);
					modelMap.put("maxSize", maxSize);
					modelMap.put("licenseType", licenseType);
					modelMap.put("modeRelease", modeRelease);
					modelMap.put("propertyRelease", propertyRelease);
					
					User user=getSessionUser(request);
					modelMap.put("inbox",lightBoxService.checkInbox(user==null?0:user.getId(), corbisId)?1:0);
					
					
					modelMap.put("photographer", photographer);
					modelMap.put("collection", collection);
					modelMap.put("imageCategory", imageCategory);
					modelMap.put("imageInfo", imageInfo);
					modelMap.put("imageHost", SearchUtils.getImageHostRandom());
					
					// 拍摄日期
					modelMap.put("photoDate", imageInfo.getPhotoDateDes());
					
					// 设置限制说明
					modelMap.put("restrictions", imageInfoService.getRestrictions(imageInfo.getRestrictionIds()));
					String webUrl = "imageview/"+corbisId+".jpg";
//					if(imageInfo.getStorageId()!=null){
//						webUrl += "&sid="+imageInfo.getStorageId();
//					}
 
					modelMap.put("webUrl", webUrl);
					ImageInfoExtend ie = baseService.get(ImageInfoExtend.class, imageInfo.getId());
					Set<String> keyslist= new HashSet<String>();
					List<String> allList = new ArrayList<String>();
					if(ie!=null){
						//~~ 设置更多个性化信息
						 
					}
					
					// 图片组
					ImageGroup imageGroup = imageGroupService.getImageGroupByCode(splashId);
					List<PreviewImageInfo> rstList = new ArrayList<PreviewImageInfo>();
					if(imageGroup!=null){
						List<String> list = imageGroupService.getImageGroupImageList(imageGroup.getId());
						rstList = searchService.getPreviewListBySplash(SearchUtils.getSubList(list, 0, 20), splashId);
					}
					modelMap.put("rstList", rstList);
				}
			}
			else{
				modelMap.put("msg", "图片不存在 ");
			}
		} catch (Exception e) {
			logger.error("查看图片详情异常["+corbisId+"]：", e);
			modelMap.put("msg", "图片不存在 ");
		}
		return "splash/splash";
	}

	@RequestMapping(value = {"/imagesflow{corbisId}", "/imagesflow/{corbisId}"})
	public String showImageFlowDetail(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap, @PathVariable String corbisId){
		try {
			User user = getSessionUser(request);
			 
			if(corbisId!=null){
				
				ImageInfo imageInfo = null;
				try{
					imageInfo = (ImageInfo)cacheService.getRemote(corbisId);
				}catch (Exception e) {
					logger.warn("从memcached获取图片异常["+corbisId+"]：", e);
				}
				if(imageInfo==null){
					imageInfo = searchService.getImageInfoByCorbisId(corbisId);
				}
				if(imageInfo!=null){
					if(imageInfo.getPhotographerId()==null)
						imageInfo.setPhotographerId(0);
					Photographer photographer = baseService.getByLocalCache(Photographer.class, imageInfo.getPhotographerId());
					ImageCollection collection = collectionService.getCollection(imageInfo.getCollectionId());
					ImageCategory imageCategory = baseService.getByLocalCache(ImageCategory.class, imageInfo.getCategoryId());
					String modeRelease = imageInfo.getModeStatus()!=null && imageInfo.getModeStatus()==2 ?"有授权":"没有授权";
					String propertyRelease = imageInfo.getPropertyStatus()!=null && imageInfo.getPropertyStatus()==2 ?"有授权":"没有授权";
					String ext = collection.getExt();
					String licenseType = imageInfo.getLicenseType()!=null && imageInfo.getLicenseType()==2 ? "RM":"RF";
					String maxSize = StrUtils.getNullStr(imageInfo.getMaxSize(), "");
					if(maxSize.startsWith("0")){
						maxSize = "";
					}
					modelMap.put("maxSize", maxSize);
					modelMap.put("licenseType", licenseType);
					modelMap.put("modeRelease", modeRelease);
					modelMap.put("propertyRelease", propertyRelease);
					
					modelMap.put("inbox",lightBoxService.checkInbox(user==null?0:user.getId(), corbisId)?1:0);
					
					
					modelMap.put("photographer", photographer);
					modelMap.put("collection", collection);
					modelMap.put("imageCategory", imageCategory);
					modelMap.put("imageCategory_showname", imageCategory.getShowName());
					// 设置CreditLine
					if(StrUtils.isNotBlank(imageInfo.getCreditLine())){
						if(imageInfo.getCreditLine().equals("©")){
							imageInfo.setCreditLine("©Gaopinimages");
						}
						else{
							imageInfo.setCreditLine(imageInfo.getCreditLine()+"/Gaopinimages");
						}
					}
					else{
						imageInfo.setCreditLine("©Gaopinimages");
					}
					modelMap.put("imageInfo", imageInfo);
					
					// 判断权限 priType
					Map<Integer, Integer> priMap = (Map<Integer, Integer>)request.getSession().getAttribute(UserPrivilege.class.getName());
					if(priMap!=null){
						Integer type = priMap.get(imageInfo.getCollectionId());
						if(type==null){
							modelMap.put("priType", -1);
						}
						else{
							modelMap.put("priType", type);
						}
					}
					
					modelMap.put("prviewimageInfo", searchService.getPreviewListByCorbisIds(new String[]{imageInfo.getCorbisId()}).get(0));
					modelMap.put("imageHost", SearchUtils.getImageHostRandom());
					
					// 拍摄日期
					modelMap.put("photoDate", imageInfo.getPhotoDateDes());
					
					// 设置限制说明
					 
					//modelMap.put("restrictions", imageInfoService.getRestrictions(imageInfo.getRestrictionIds()));
					modelMap.put("restrictions", StringUtils.strip( imageInfoService.getRestrictions(imageInfo.getRestrictionIds()).toString(), "[]"));
					String webUrl = "imageview/"+imageInfo.getCorbisId()+ ext;
//					if(imageInfo.getStorageId()!=null){
//						webUrl += "&sid="+imageInfo.getStorageId();
//					}
 
					modelMap.put("webUrl", webUrl);
					ImageInfoExtend ie = baseService.get(ImageInfoExtend.class, imageInfo.getId());
					Set<String> keyslist= new HashSet<String>();
					List<String> allList = new ArrayList<String>();
					if(ie!=null){
						
						String[] keysArray=ie.getShowKeyCh().split("\\|");
						for(String key : keysArray)
						{
							key = key.trim();
							if(StrUtils.isNotBlank(key))
							{
								allList.add(key);
								key = EncodeingHelper.convert2Gb(key);
								Keywords kw = keywordService.getKeywords(key);
								if(kw!=null && kw.getShowStatus()==1){
									keyslist.add(key);
								}
							}
						}
						int showAll = StrUtils.getIntValue(request.getParameter("s"), -1);
						if(showAll>0){
							modelMap.put("keyslist", allList);
						}
						else{
							modelMap.put("keyslist", keyslist);
						}
					}
					
					// 图片组
					List<ImageGroupImage> groupimageList = imageGroupService.getImageGroupList(corbisId);
					List<ImageGroup> groupList = new ArrayList<ImageGroup>();

					if(groupimageList!=null && groupimageList.size()>0){
						List<List<PreviewImageInfo>> groupsItemList = new ArrayList<List<PreviewImageInfo>>();
						List<Integer> groupIdList = imageGroupService.getImageGroupIdList(corbisId);
						modelMap.put("groupId", groupIdList.get(0));
						// Sean comment this out 
/*						for(ImageGroupImage imageGroup : groupimageList){
							List<String> list = imageGroupService.getImageGroupImageList(imageGroup.getImageGroupId());
							List<PreviewImageInfo> rstList = searchService.getPreviewList(list);
							ImageGroup  group=imageGroupService.getImageGroup(imageGroup.getImageGroupId());
							if(group!=null){
								groupList.add(group);
								groupsItemList.add(rstList);
							}
						}
						modelMap.put("groupsItemList", groupsItemList);//List<List<PreviewImageInfo>>
						modelMap.put("groupsList", groupList);//List<ImageGroupImage>
*/					}
				}
			}
			else{
				modelMap.put("msg", "图片不存在 ");
			}
		} catch (Exception e) {
			logger.error("查看图片详情异常["+corbisId+"]：", e);
			modelMap.put("msg", "图片不存在 ");
		}
		return "image/detailflow";
	}
	
	@RequestMapping(value = {"/image{corbisId}", "/image/{corbisId}"})
	public String showImageDetail(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap, @PathVariable String corbisId){
		try {
			User user = getSessionUser(request);
			 
			if(corbisId!=null){
				if(SearchUtils.isSplashId(corbisId)){
					if(corbisId.indexOf("_")<0){
						return "redirect:/search#spl="+corbisId;
					}
					else{
						return showSplashDetail(request, modelMap, corbisId);
					}
				}
				ImageInfo imageInfo = null;
				try{
					imageInfo = (ImageInfo)cacheService.getRemote(corbisId);
				}catch (Exception e) {
					logger.warn("从memcached获取图片异常["+corbisId+"]：", e);
				}
				if(imageInfo==null){
					imageInfo = searchService.getImageInfoByCorbisId(corbisId);
				}
				if(imageInfo!=null){
					if(imageInfo.getPhotographerId()==null)
						imageInfo.setPhotographerId(0);
					Photographer photographer = baseService.getByLocalCache(Photographer.class, imageInfo.getPhotographerId());
					ImageCollection collection = collectionService.getCollection(imageInfo.getCollectionId());
					ImageCategory imageCategory = baseService.getByLocalCache(ImageCategory.class, imageInfo.getCategoryId());
					String modeRelease = imageInfo.getModeStatus()!=null && imageInfo.getModeStatus()==2 ?"有授权":"没有授权";
					String propertyRelease = imageInfo.getPropertyStatus()!=null && imageInfo.getPropertyStatus()==2 ?"有授权":"没有授权";
					String ext = collection.getExt();
					String licenseType = imageInfo.getLicenseType()!=null && imageInfo.getLicenseType()==2 ? "RM":"RF";
					String maxSize = StrUtils.getNullStr(imageInfo.getMaxSize(), "");
					if(maxSize.startsWith("0")){
						maxSize = "";
					}
					modelMap.put("maxSize", maxSize);
					modelMap.put("licenseType", licenseType);
					modelMap.put("modeRelease", modeRelease);
					modelMap.put("propertyRelease", propertyRelease);
					
					modelMap.put("inbox",lightBoxService.checkInbox(user==null?0:user.getId(), corbisId)?1:0);
					
					
					modelMap.put("photographer", photographer);
					modelMap.put("collection", collection);
					modelMap.put("imageCategory", imageCategory);
					// 设置CreditLine
					if(StrUtils.isNotBlank(imageInfo.getCreditLine())){
						if(imageInfo.getCreditLine().equals("©")){
							imageInfo.setCreditLine("©Gaopinimages");
						}
						else{
							imageInfo.setCreditLine(imageInfo.getCreditLine()+"/Gaopinimages");
						}
					}
					else{
						imageInfo.setCreditLine("©Gaopinimages");
					}
					modelMap.put("imageInfo", imageInfo);
					
					// 判断权限 priType
					Map<Integer, Integer> priMap = (Map<Integer, Integer>)request.getSession().getAttribute(UserPrivilege.class.getName());
					if(priMap!=null){
						Integer type = priMap.get(imageInfo.getCollectionId());
						if(type==null){
							modelMap.put("priType", -1);
						}
						else{
							modelMap.put("priType", type);
						}
					}
					
					modelMap.put("prviewimageInfo", searchService.getPreviewListByCorbisIds(new String[]{imageInfo.getCorbisId()}).get(0));
					modelMap.put("imageHost", SearchUtils.getImageHostRandom());
					
					// 拍摄日期
					modelMap.put("photoDate", imageInfo.getPhotoDateDes());
					
					// 设置限制说明
					modelMap.put("restrictions", imageInfoService.getRestrictions(imageInfo.getRestrictionIds()));
					String webUrl = "imageview/"+imageInfo.getCorbisId()+ext;
//					if(imageInfo.getStorageId()!=null){
//						webUrl += "&sid="+imageInfo.getStorageId();
//					}
 
					modelMap.put("webUrl", webUrl);
					ImageInfoExtend ie = baseService.get(ImageInfoExtend.class, imageInfo.getId());
					Set<String> keyslist= new HashSet<String>();
					List<String> allList = new ArrayList<String>();
					if(ie!=null){
						
						String[] keysArray=ie.getShowKeyCh().split("\\|");
						for(String key : keysArray)
						{
							key = key.trim();
							if(StrUtils.isNotBlank(key))
							{
								allList.add(key);
								key = EncodeingHelper.convert2Gb(key);
								Keywords kw = keywordService.getKeywords(key);
								if(kw!=null && kw.getShowStatus()==1){
									keyslist.add(key);
								}
							}
						}
						int showAll = StrUtils.getIntValue(request.getParameter("s"), -1);
						if(showAll>0){
							modelMap.put("keyslist", allList);
						}
						else{
							modelMap.put("keyslist", keyslist);
						}
					}
					
					// 图片组
					List<ImageGroupImage> groupimageList = imageGroupService.getImageGroupList(corbisId);
					List<ImageGroup> groupList = new ArrayList<ImageGroup>();
					if(groupimageList!=null && groupimageList.size()>0){
						List<List<PreviewImageInfo>> groupsItemList = new ArrayList<List<PreviewImageInfo>>();
						List<Integer> groupIdList = imageGroupService.getImageGroupIdList(corbisId);

						modelMap.put("groupId", groupIdList.get(0));
						//sean comment this out
/*						List<List<PreviewImageInfo>> groupsItemList = new ArrayList<List<PreviewImageInfo>>();
						for(ImageGroupImage imageGroup : groupimageList){
							List<String> list = imageGroupService.getImageGroupImageList(imageGroup.getImageGroupId());
							List<PreviewImageInfo> rstList = searchService.getPreviewList(list);
							ImageGroup  group=imageGroupService.getImageGroup(imageGroup.getImageGroupId());
							if(group!=null){
								groupList.add(group);
								groupsItemList.add(rstList);
							}
						}
						modelMap.put("groupsItemList", groupsItemList);//List<List<PreviewImageInfo>>
						modelMap.put("groupsList", groupList);//List<ImageGroupImage>
*/					}
				}
			}
			else{
				modelMap.put("msg", "图片不存在 ");
			}
		} catch (Exception e) {
			logger.error("查看图片详情异常["+corbisId+"]：", e);
			modelMap.put("msg", "图片不存在 ");
		}
		//return "image/detail";
		return "image/detailflow";
	}
	
	@RequestMapping(value = {"/imageview/{gaopinId}.{ext}"})
	@ResponseBody
	public void showPreview(HttpServletRequest request, HttpServletResponse response, @PathVariable String gaopinId, @PathVariable String ext){
		if(StrUtils.isBlank(gaopinId)) return;
		if(StrUtils.isBlank(ext)) return;
		
		ImageInfo imageInfo = searchService.getImageInfoByCorbisIdCache(gaopinId);
		if(imageInfo==null) return;
		String subPath = SearchUtils.getImageFullPath(gaopinId);
		subPath+=".";
		subPath+=ext;
		File showFile = null;
		if(ext.equals("jpg")){
			if(getSessionUser(request)==null) { // 显示水印图片
				String waterPath =SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.WATERMARK.getPath()+"/"+subPath;
						//SearchUtils.getImageWaterPath()+subPath;
				File waterFile = new File(waterPath);
				if(!waterFile.exists()){ // 水印图片不存在，生成水印
					long t = System.currentTimeMillis();
					genWaterImage(subPath, waterPath, imageInfo.getStorageId());
					logger.debug("生成水印图片，耗时："+(System.currentTimeMillis()-t)+"ms");
				}
				showFile = waterFile;
			}
			else{ // 加超级水印
				//comment out by Sean
				/*String previewPath = SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.PREVIEW.getPath()+"/"+subPath;
				showFile = new File(previewPath);*/
				String supermarkPath =SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.SUPERMARK.getPath()+"/"+subPath;
				File supermarkFile = new File(supermarkPath);
				if(!supermarkFile.exists()){
					long t = System.currentTimeMillis();
					genSupermarkImage(subPath, supermarkPath, imageInfo.getStorageId());
					logger.debug("生成超级水印图片，耗时："+(System.currentTimeMillis()-t)+"ms");
				}
				showFile = supermarkFile;
			}
		}
		else if(ext.equals("gif")){
			if(getSessionUser(request)==null) {
				String waterPath =SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.WATERMARK.getPath()+"/"+subPath;
				File waterFile = new File(waterPath);
				if(!waterFile.exists()){
					long t = System.currentTimeMillis();
					genGifImage(subPath, waterPath, imageInfo.getStorageId());
					logger.debug("生成gif水印图片，耗时："+(System.currentTimeMillis()-t)+"ms");	
				}
				/*String p = SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.WATERMARK.getPath()+"/"+subPath;
				File f = new File(p);*/
				if(!waterFile.exists()){
					waterFile = new File(SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.PREVIEW.getPath()+"/"+subPath);
				}
				showFile=waterFile;
			}
			else{
				String waterPath =SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.SUPERMARK.getPath()+"/"+subPath;
				File waterFile = new File(waterPath);
				if(!waterFile.exists()){
					long t = System.currentTimeMillis();
					genGifImage(subPath, waterPath, imageInfo.getStorageId());
					logger.debug("生成gif水印图片，耗时："+(System.currentTimeMillis()-t)+"ms");	
				}
				/*String p = SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.WATERMARK.getPath()+"/"+subPath;
				File f = new File(p);*/
				if(!waterFile.exists()){
					waterFile = new File(SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.PREVIEW.getPath()+"/"+subPath);
				}
				showFile=waterFile;
				
			}
		}
		else{
			String p = SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.PREVIEW.getPath()+"/"+subPath;
			File f = new File(p);
			showFile=f;
		}

		
		FileInputStream fis = null;
		try{
			if(!showFile.exists()){
				logger.warn("预览图不存在, imagePath="+showFile.getPath());
				return;
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
	
	private synchronized boolean genWaterImage(String subPath, String waterPath, Byte storageId){
		String previewPath = SearchUtils.getImageRootPath(storageId) + SizeType.PREVIEW.getPath()+"/"+subPath;
		File previewFile = new File(previewPath);
		if(!previewFile.exists()){
			logger.warn("预览图不存在，无法生成水印：previewPath=" + previewPath);
			return false;
		}
		File waterFile = new File(waterPath);
		if(waterFile.exists()){
			return true;
		}
		try{
			// 压缩水印图片
			ImageUtils.pressImage(previewFile, waterFile);
		}
		catch (Exception e) {
			logger.warn("压缩水印出现异常：previewPath=" + previewPath);
			return false;
		}
		return true;
	}
	private synchronized boolean genSupermarkImage(String subPath, String waterPath, Byte storageId){
		String previewPath = SearchUtils.getImageRootPath(storageId) + SizeType.PREVIEW.getPath()+"/"+subPath;
		File previewFile = new File(previewPath);
		if(!previewFile.exists()){
			logger.warn("预览图不存在，无法生成水印：previewPath=" + previewPath);
			return false;
		}
		File supermarkFile = new File(waterPath);
		if(supermarkFile.exists()){
			return true;
		}
		try{
			// 压缩水印图片
			ImageUtils.pressImage_superMark(previewFile, supermarkFile);
		}
		catch (Exception e) {
			logger.warn("压缩水印出现异常：previewPath=" + previewPath);
			return false;
		}
		return true;
	}
	private synchronized boolean genGifImage(String subPath, String waterPath, Byte storageId){
		String previewPath = SearchUtils.getImageRootPath(storageId) + SizeType.PREVIEW.getPath()+"/"+subPath;
		File previewFile = new File(previewPath);
		if(!previewFile.exists()){
			logger.warn("预览图不存在，无法生成水印 for gif：previewPath=" + previewPath);
			return false;
		}
		File gifFile = new File(waterPath);
		if(gifFile.exists()){
			return true;
		}
		try{
			// 压缩水印图片
			ImageUtils.pressImage_gif(previewFile, gifFile);
		}
		catch (Exception e) {
			logger.warn("压缩gif水印出现异常：previewPath=" + previewPath);
			return false;
		}
		return true;
	}
}
