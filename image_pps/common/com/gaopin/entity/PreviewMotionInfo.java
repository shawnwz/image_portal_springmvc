package com.gaopin.entity;

// Generated May 13, 2015 2:24:33 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;

/**
 * FrMotionInfo generated by hbm2java
 */
public class PreviewMotionInfo implements java.io.Serializable {

	private long id;
	private String gaopinId;
	private Byte storageId;
	private String title;
	private String caption;
	private Integer photographerId;
	private Integer collectionId;
	private Integer categoryId;
	private Date shotDate;
	private String shotDateDes;
	private Byte status;
	private Byte modeStatus;
	private Byte propertyStatus;
	private String location;
	private String creditLine;
	private Byte licenseType;
	private String maxSize;
	private Boolean isInCd;
	private Boolean isInMotionSet;
	private Boolean isInMotionGroup;
	private Date publishDate;
	private String restrictionIds;
	private Integer sortId;
	private Date createTime;
	private Date updateTime;
	private Integer pricing;
	private String motionHost;
	private String mp4PosterPath;
	private String flvPosterPath;
	private String mp4MotionPath;
	private String flvMotionPath;
	private String webmPosterPath;
	private String webmMotionPath;
	private String collectionName;
	private int priType = -1;
	
	// 页面显示分类名称
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
	
	public PreviewMotionInfo() {
	}

	public PreviewMotionInfo(long id) {
		this.id = id;
	}

	public PreviewMotionInfo(long id, String gaopinId, Byte storageId, String title,
			String caption, Integer photographerId, Integer collectionId,
			Integer categoryId, Date shotDate, String shotDateDes, Byte status,
			Byte modeStatus, Byte propertyStatus, String location,
			String creditLine, Byte licenseType, String maxSize,
			Boolean isInCd, Boolean isInMotionSet, Boolean isInMotionGroup,
			Date publishDate, String restrictionIds, Integer sortId,
			Date createTime, Date updateTime, Integer pricing, Integer priType) {
		this.id = id;
		this.gaopinId = gaopinId;
		this.storageId = storageId;
		this.title = title;
		this.caption = caption;
		this.photographerId = photographerId;
		this.collectionId = collectionId;
		this.categoryId = categoryId;
		this.shotDate = shotDate;
		this.shotDateDes = shotDateDes;
		this.status = status;
		this.modeStatus = modeStatus;
		this.propertyStatus = propertyStatus;
		this.location = location;
		this.creditLine = creditLine;
		this.licenseType = licenseType;
		this.maxSize = maxSize;
		this.isInCd = isInCd;
		this.isInMotionSet = isInMotionSet;
		this.isInMotionGroup = isInMotionGroup;
		this.publishDate = publishDate;
		this.restrictionIds = restrictionIds;
		this.sortId = sortId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.pricing = pricing;
		this.priType = priType;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGaopinId() {
		return this.gaopinId;
	}

	public void setGaopinId(String gaopinId) {
		this.gaopinId = gaopinId;
	}

	public Byte getStorageId() {
		return this.storageId;
	}

	public void setStorageId(Byte storageId) {
		this.storageId = storageId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Integer getPhotographerId() {
		return this.photographerId;
	}

	public void setPhotographerId(Integer photographerId) {
		this.photographerId = photographerId;
	}

	public Integer getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Date getShotDate() {
		return this.shotDate;
	}

	public void setShotDate(Date shotDate) {
		this.shotDate = shotDate;
	}

	public String getShotDateDes() {
		return this.shotDateDes;
	}

	public void setShotDateDes(String shotDateDes) {
		this.shotDateDes = shotDateDes;
	}

	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getModeStatus() {
		return this.modeStatus;
	}

	public void setModeStatus(Byte modeStatus) {
		this.modeStatus = modeStatus;
	}

	public Byte getPropertyStatus() {
		return this.propertyStatus;
	}

	public void setPropertyStatus(Byte propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCreditLine() {
		return this.creditLine;
	}

	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}

	public Byte getLicenseType() {
		return this.licenseType;
	}

	public void setLicenseType(Byte licenseType) {
		this.licenseType = licenseType;
	}

	public String getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(String maxSize) {
		this.maxSize = maxSize;
	}

	public Boolean getIsInCd() {
		return this.isInCd;
	}

	public void setIsInCd(Boolean isInCd) {
		this.isInCd = isInCd;
	}

	public Boolean getIsInMotionSet() {
		return this.isInMotionSet;
	}

	public void setIsInMotionSet(Boolean isInMotionSet) {
		this.isInMotionSet = isInMotionSet;
	}

	public Boolean getIsInMotionGroup() {
		return this.isInMotionGroup;
	}

	public void setIsInMotionGroup(Boolean isInMotionGroup) {
		this.isInMotionGroup = isInMotionGroup;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getRestrictionIds() {
		return this.restrictionIds;
	}

	public void setRestrictionIds(String restrictionIds) {
		this.restrictionIds = restrictionIds;
	}

	public Integer getSortId() {
		return this.sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getPricing() {
		return this.pricing;
	}

	public void setPricing(Integer pricing) {
		this.pricing = pricing;
	}
	
	public String getMotionHost() {
	
		if(StrUtils.isBlank(motionHost)){
			return SearchUtils.getImageHostRandom();
		}
		return motionHost;
	}

	public void setMotionHost(String motionHost) {
		this.motionHost = motionHost;
	}
	
	public String getMp4PosterPath(){
		if(mp4PosterPath==null && gaopinId!=null){
			return SearchUtils.getMotionImageFullPath(gaopinId);
		}
		return "";
	}
	
	public void setMp4PosterPath(String path){
		this.mp4PosterPath = path;
	}
	public String getFlvPosterPath(){
		if(mp4PosterPath==null && gaopinId!=null){
			return SearchUtils.getMotionImageFullPath(gaopinId);
		}
		return "";
	}
	
	public void setFlvPosterPath(String path){
		this.mp4PosterPath = path;
	}
	
	public String getWebmPosterPath(){
		if(webmPosterPath==null && gaopinId!=null){
			return SearchUtils.getMotionImageFullPath(gaopinId);
		}
		return "";
	}
	
	public void setWebmPosterPath(String path){
		this.webmPosterPath = path;
	}
	
	public String getMp4MotionPath(){
		if(mp4MotionPath==null && gaopinId!=null){
			return SearchUtils.getMotionMp4FullPath(gaopinId);
		}
		return "";
	}
	
	public void setMp4MotionPath(String path){
		this.mp4MotionPath = path;
	}
	
	public String getFlvMotionPath(){
		if(flvMotionPath==null && gaopinId!=null){
			return SearchUtils.getMotionFlvFullPath(gaopinId);
		}
		return "";
	}
	
	public void setFlvMotionPath(String path){
		this.flvMotionPath = path;
	}
	
	public String getWebmMotionPath(){
		if(webmMotionPath==null && gaopinId!=null){
			return SearchUtils.getMotionWebmFullPath(gaopinId);
		}
		return "";
	}
	
	public void setWebmMotionPath(String path){
		this.webmMotionPath = path;
	}
	
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	
	public int getPriType() {
		return priType;
	}
	public void setPriType(int priType) {
		this.priType = priType;
	}
	


}