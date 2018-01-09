/* This file ImageGroupService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gaopin.entity.ImageGroup;
import com.gaopin.entity.ImageGroupImage;
import com.gaopin.entity.ImagePartialSets;
import com.gaopin.entity.ImageSets;
import com.gaopin.service.BaseService;

public interface ImageGroupService extends BaseService {
	/**
	 * 根据corbisId获取图片对应的图片组ID列表（一张图片可在多个图片组）
	 * @param corbisId
	 * @return
	 */
	public List<Integer> getImageGroupIdList(String corbisId);
	
	

	public List<ImageGroupImage> getImageGroupList(String corbisId);
	/**
	 * 根据图片组ID，获取其下所有图片的corbisId
	 * @param groupId
	 * @return
	 */
	public List<String> getImageGroupImageList(Integer imageGroupId);
	
	/**
	 * 根据图片组ID，获取图片组对象
	 * @param id
	 * @return
	 */
	public ImageGroup getImageGroup(Integer id);
	

	public List<ImageGroup> getImageGroups(Integer[] ids);
	public List<ImageGroup> getImageGroups(String[] ids);
	/**
	 * 根据图片组ID查询页面显示结果
	 * @param request
	 * @param imageGroupId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> getImagesByGroup(HttpServletRequest request, int imageGroupId, int pageNo, int pageSize);
	
	/**
	 * 根据图片组CODE查询页面显示结果
	 * @param request
	 * @param code
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> getImagesByCode(HttpServletRequest request, String code, int pageNo, int pageSize);
	
	/**
	 * 根据分类查询图片组对象列表
	 * @param categoryId
	 * @return
	 */
	public List<ImageGroup> getImageGroupsByCategoryId(int categoryId, int pageNo, int pageSize);
	
	/**
	 * 取得模版列表
	 * @param ids
	 * @return
	 */
	public List<ImagePartialSets> getImagePartialSets(Integer[] ids);
	/**
	 * 取得模版列表
	 * @param ids
	 * @return
	 */
	public ImagePartialSets getImagePartialSets(Integer id);
	/**
	 * 图片组分类表
	 * @return
	 */
	public List<ImageSets> getImageSets();
	
	/**
	 * 图片组分类表
	 * @return
	 */
	public List<ImageGroup> getImageGroupByCatalog(Integer catalogid);
	
	/**
	 * 根据code获取图片组对象
	 * @param code
	 * @return
	 */
	public ImageGroup getImageGroupByCode(String code);
	
	//Sean added for get group amount
	public String getImageGroupAmount(Integer code);
}
