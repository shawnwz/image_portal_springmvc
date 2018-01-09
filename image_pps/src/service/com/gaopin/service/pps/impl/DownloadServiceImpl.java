/* This file DownloadServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gaopin.constants.Constants.SizeType;
import com.gaopin.constants.Constants.UserPrivilegeType;
import com.gaopin.entity.DownloadHistory;
import com.gaopin.entity.DownloadOrder;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.DownloadService;
import com.gaopin.service.pps.ImageInfoService;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.ImageUtils;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.utils.RequestUtils;
@Service("downloadService")
public class DownloadServiceImpl extends BaseServiceImpl implements
		DownloadService {

	private static String[] fileExts = new String[]{".jpg",".tif",".gif"}; 
	@Resource
	private ImageInfoService imageInfoService;
	@Resource
	private CollectionService collectionService;
	@Override
	public Map<String, Object> getDownloadPath(ImageInfo imageInfo, UserPrivilege userPrivilege) {
		
		Integer sizeId;
		if(userPrivilege==null){
			sizeId = SizeType.SUPERMARK.getSizecode();
		}
		else{
			sizeId = userPrivilege.getSizeId();
		}
		 
		if(sizeId==null) return null;
		SizeType sizeType = SizeType.getEnum(sizeId);
		if(sizeType==null){
			return null;
		}
		
		String rootPath = SearchUtils.getImageRootPath(imageInfo.getStorageId());
		
		if(StrUtils.isBlank(rootPath)){
			logger.error("图片根路径配置错误, storageid="+imageInfo.getStorageId()+", rootPath="+rootPath);
			return null;
		}
		
		String imageFolder = SearchUtils.getImageFolder(imageInfo.getCorbisId());
		SizeType[] lessSizeTypes =sizeType.getLessType();
		for(SizeType stype : lessSizeTypes){
			String foldPath = rootPath + stype.getPath()+"/"+imageFolder;
			for(String fileExt : fileExts){
				String filePath = foldPath+imageInfo.getCorbisId()+fileExt;
				System.out.println("尝试查找图片物理地址:" + filePath);
				if(new File(filePath).exists()){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("filePath", filePath);
					map.put("sizeType", stype);
					return map;
				}
			}
		}
		return null;
	}

	@Override
	public boolean recordDownloadLog(ImageInfo imageInfo, User user,UserPrivilegeType userPrivilegeType, SizeType sizeType)
	{
		int orderId=saveDownloadOrderLog(user.getId(),userPrivilegeType.ordinal());
		return recordDownloadLog(imageInfo,user,userPrivilegeType,sizeType,orderId);
	}

	private boolean recordDownloadLog(ImageInfo imageInfo, User user,
			UserPrivilegeType userPrivilegeType, SizeType sizeType,int orderId) {
		
		if(userPrivilegeType.ordinal()==UserPrivilegeType.OD.ordinal()){ // od下载
			// 1.根据历史记录，判断本次下载是否扣除od值
			Date date = new Date(System.currentTimeMillis() - 7*24*60*60*1000L);
			List<DownloadHistory> list = getHistoryList(user.getId(), imageInfo.getCorbisId(), date, UserPrivilegeType.OD.ordinal());
			boolean deduct = true;
			for(DownloadHistory dh:list){
				if(dh.getOdNum()>0){
					deduct = false;
					break;
				}
			}
			if(deduct){ // 需要扣点
				if(checkAndDeductOD(user)){ // 检查通过，并扣点成功
					saveDownloadLog(imageInfo.getCorbisId(), sizeType.getSizecode(), userPrivilegeType.ordinal(), user.getId(), 1,orderId);
				}
				else{
					return false;
				}
			}
			else { // 不需要扣点直接记录日志
				saveDownloadLog(imageInfo.getCorbisId(), sizeType.getSizecode(), userPrivilegeType.ordinal(), user.getId(), 0,orderId);
			}
		}
		else{ // qp下载，只记录日志
			saveDownloadLog(imageInfo.getCorbisId(), sizeType.getSizecode(), userPrivilegeType.ordinal(), user.getId(), 0,orderId);
		}
		return true;
	}

	@Override
	public boolean recordDownloadLog(PreviewImageInfo[] imageses, SizeType[] sizeTypes, User user,
			UserPrivilegeType userPrivilegeType) {
		logger.info("recordDownloadLogimageses.length/sizeTypes.length"+imageses.length+"/"+sizeTypes.length);
		if(imageses.length!=sizeTypes.length)
			return false;
		int orderId=saveDownloadOrderLog(user.getId(),userPrivilegeType.ordinal());
		for (int i=0;i<imageses.length;i++) {
			ImageInfo imageInfo=imageInfoService.getImageInfo(imageses[i].getCorbisId());
			SizeType sizeType=sizeTypes[i];
			recordDownloadLog(imageInfo,user,userPrivilegeType,sizeType,orderId);
		}
		return true;
	}

	private int saveDownloadOrderLog(Integer userId,Integer userPrivilegeType){
		//记录Order表 guopeng add 20140410
		DownloadOrder order = new DownloadOrder();
		order.setUserId(userId);
		order.setCreateTime(new Date());
		order.setName(DateUtils.getDatestr(new Date(), DateUtils.ymdSdf));
		order.setState(0);
		order.setType(userPrivilegeType);
		saveObject(order);
		return order.getId();
	}
	
	private void saveDownloadLog(String corbisId, int sizeType, int type, int userId, int odNum,int orderId){
		DownloadHistory dh = new DownloadHistory();
		dh.setCorbisId(corbisId);
		dh.setOdNum(odNum);
		dh.setSizeType(sizeType);
		dh.setType(type);
		dh.setUserId(userId);
		dh.setCreateTime(new Date());
		dh.setOrderId(orderId);
		saveObject(dh);
		
	}
	
	/**
	 * 判断用户od值合法性，如合法，则扣除本次下载
	 * @param user
	 * @return
	 */
	private synchronized boolean checkAndDeductOD(User user){
		try {
			User loadUser = get(User.class, user.getId());
			if(loadUser!=null && loadUser.getOd()>0){
				String hql = "update User set od=od-1 where id="+user.getId();
				controller.executeUpdate(hql);
				return true;
			}
			else{
				RequestUtils.setErrorInfo(300, "OD点不足");
			}
		} catch (Exception e) {
			RequestUtils.setErrorInfo(301, "扣除OD点失败.");
			logger.error("【OD下载】检查并扣除用户od点异常[userId="+user.getId()+"]：", e);
			return false;
		}
		return false;
	}
	
	private List<DownloadHistory> getHistoryList(int userId, String corbisId, Date createTime, int type){
		List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("userId", userId, CompareType.Equal));
		expressions.add(new CompareExpression("corbisId", corbisId, CompareType.Equal));
		expressions.add(new CompareExpression("type", type, CompareType.Equal));
		expressions.add(new CompareExpression("createTime", createTime, CompareType.Gt));
		return controller.findBy(DownloadHistory.class, expressions);
	}
	
	@Override
	public void checkAndGenSuperMark(ImageInfo imageInfo) {
		
		ImageCollection collection = collectionService.getCollection(imageInfo.getCollectionId());
		String ext = collection.getExt();
		String rootPath = SearchUtils.getImageRootPath(imageInfo.getStorageId());
		String subPath = SearchUtils.getImageFullPath(imageInfo.getCorbisId());
		subPath+=ext;
		if(StrUtils.isBlank(rootPath)){
			logger.error("图片根路径配置错误, storageid="+imageInfo.getStorageId()+", rootPath="+rootPath);
		}
		String imageFolder = SearchUtils.getImageFolder(imageInfo.getCorbisId());
		
		if(ext.equals(".jpg")){
			String supermarkPath =SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.SUPERMARK.getPath()+"/"+subPath;
			File supermarkFile = new File(supermarkPath);
			if(!supermarkFile.exists()){
				long t = System.currentTimeMillis();
				genSupermarkImage(subPath, supermarkPath, imageInfo.getStorageId());
				logger.debug("生成超级水印图片，耗时："+(System.currentTimeMillis()-t)+"ms");
			}
			if(!supermarkFile.exists()){
				supermarkFile= new File(SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.WATERMARK.getPath()+"/"+subPath);
			}
			
		}else if(ext.equals(".gif")){
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
				waterFile = new File(SearchUtils.getImageRootPath(imageInfo.getStorageId()) + SizeType.WATERMARK.getPath()+"/"+subPath);
			}
			
		}
		
		
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
