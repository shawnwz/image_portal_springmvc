/* This file PreviewImageInfo.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;

/**
 * FrImageInfo entity. @author MyEclipse Persistence Tools
 */
public class PreviewImageInfo implements java.io.Serializable {

	// Fields

	private Long id;
	private String corbisId;
	private Byte storageId;
	private String title;
	private String caption;
	private Integer photographerId;
	private Integer collectionId;
	private Integer categoryId;
	private Date photoDate;
	private String photoDateDes;
	private Byte status;
	private Byte modeStatus;
	private Byte propertyStatus;
	private String location;
	private String creditLine;
	private Byte licenseType;
	private String maxSize;
	private Boolean isInCd;
	private Boolean isInImageSet;
	private Integer isInImageGroup;
	private Date publishDate;
	private String restrictionIds;
	private String imageHost;
	private int priType = -1;
	private String collectionName;
	private String photographerName;
	private String categoryName;
	private String path;
	private int splashNum;
	private Integer pricing;
	private List<String> restrictionList = new ArrayList<String>();
	private String groupId;
	private String groupAmount;
	private String ext;
	// 页面显示图片分类名称
	public String getScn(){
		if(categoryId!=null){
			switch (categoryId) {
			case 660:
			case 659:
			case 662:
				return "创意类";
			case 661:
				return "编辑类";
			case 665:
				return "时事";
			case 664:
				return "体育";
			case 682:
				return "影视档案";
			case 666:
				return "历史";
			case 680:
				return "艺术作品";
			case 669:
				return "Outline";
			case 690:
				return "Splash";
			case 100:
				return "图片集";
			default:
				break;
			}
		}
		return "编辑类";
	}
	
	public void setPricing(Integer pricing){
		this.pricing = pricing;
	}
	
	public String getPricing(){
		if(pricing==null || pricing==0 || pricing==1) return "$";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<pricing; i++){
			sb.append("$");
		}
		return sb.toString();
	}
	
	public String getModelRelease() {
		if(modeStatus!=null && modeStatus.intValue()==2){
			return "有授权";
		}
		return "没有授权";
	}

	public String getPropertyRelease() {
		if(propertyStatus!=null && propertyStatus.intValue()==2){
			return "有授权";
		}
		return "没有授权";
	}

	public String getPath(){
		if(path==null && corbisId!=null){
			return SearchUtils.getImageFullPath(corbisId);
		}
		return "";
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public String getImageHost() {
		if(StrUtils.isBlank(imageHost)){
			return SearchUtils.getImageHostRandom();
		}
		return imageHost;
	}

	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorbisId() {
		return corbisId;
	}
	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}
	public Byte getStorageId() {
		return storageId;
	}
	public void setStorageId(Byte storageId) {
		this.storageId = storageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPriType() {
		return priType;
	}
	public void setPriType(int priType) {
		this.priType = priType;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Integer getPhotographerId() {
		return photographerId;
	}
	public void setPhotographerId(Integer photographerId) {
		this.photographerId = photographerId;
	}
	public Integer getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Date getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(Date photoDate) {
		this.photoDate = photoDate;
	}
	public String getPhotoDateDes() {
		return photoDateDes;
	}
	public void setPhotoDateDes(String photoDateDes) {
		this.photoDateDes = photoDateDes;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Byte getModeStatus() {
		return modeStatus;
	}
	public void setModeStatus(Byte modeStatus) {
		this.modeStatus = modeStatus;
	}
	public Byte getPropertyStatus() {
		return propertyStatus;
	}
	public void setPropertyStatus(Byte propertyStatus) {
		this.propertyStatus = propertyStatus;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCreditLine() {
		return creditLine;
	}
	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}
	public Byte getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(Byte licenseType) {
		this.licenseType = licenseType;
	}
	public String getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}
	public Boolean getIsInCd() {
		return isInCd;
	}
	public void setIsInCd(Boolean isInCd) {
		this.isInCd = isInCd;
	}
	public Boolean getIsInImageSet() {
		return isInImageSet;
	}
	public void setIsInImageSet(Boolean isInImageSet) {
		this.isInImageSet = isInImageSet;
	}
	public Integer getIsInImageGroup() {
		return isInImageGroup;
	}
	public void setIsInImageGroup(Integer isInImageGroup) {
		this.isInImageGroup = isInImageGroup;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getRestrictionIds() {
		return restrictionIds;
	}
	public void setRestrictionIds(String restrictionIds) {
		this.restrictionIds = restrictionIds;
	}
	
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public String getPhotographerName() {
		return photographerName;
	}
	public void setPhotographerName(String photographerName) {
		this.photographerName = photographerName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<String> getRestrictionList() {
		return restrictionList;
	}
	public void setRestrictionList(List<String> restrictionList) {
		this.restrictionList = restrictionList;
	}
	
	public int getSplashNum() {
		return splashNum;
	}

	public void setSplashNum(int splashNum) {
		this.splashNum = splashNum;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupAmount() {
		return groupAmount;
	}
	public void setGroupAmount(String groupAmount) {
		this.groupAmount = groupAmount;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}

	@Override
	public String toString() {
		return "PreviewImageInfo [id=" + id + ", corbisId=" + corbisId
				+ ", storageId=" + storageId + ", title=" + title
				+ ", caption=" + caption + ", photographerId=" + photographerId
				+ ", collectionId=" + collectionId + ", categoryId="
				+ categoryId + ", photoDate=" + photoDate + ", photoDateDes="
				+ photoDateDes + ", status=" + status + ", modeStatus="
				+ modeStatus + ", propertyStatus=" + propertyStatus
				+ ", location=" + location + ", creditLine=" + creditLine
				+ ", licenseType=" + licenseType + ", maxSize=" + maxSize
				+ ", isInCd=" + isInCd + ", isInImageSet=" + isInImageSet
				+ ", isInImageGroup=" + isInImageGroup
				+ ", groupId=" + groupId
				+ ", groupAmount=" + groupAmount
				+ ", publishDate=" + publishDate + ", restrictionIds="
				+ restrictionIds + "priType="+priType+"]";
	}
}
