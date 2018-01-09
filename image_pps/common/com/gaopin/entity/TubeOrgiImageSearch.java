package com.gaopin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class TubeOrgiImageSearch implements java.io.Serializable {

	private Long id;
	private String uuid;
	private Integer filesize;
	private String orgiFilename;
	private String filename;
	private String storageid;
	private String userid;
	private String title;
	private String caption;
	private Integer status;
	private Date dateupload;
	private String approvedBy;
	private Date dateapproved;
	private Date datePhotographed;
	private Date datePhotographedApprox;
	private String displaylocation;
	private String modelReleaseStatus;
	private String propertyReleaseStatus;
	private Integer contentType;
	private Integer contentSecondType;
	private String customCreditLine;
	private Integer sizeCode;
	private String restriction;
	private String photographer;
	private Integer providerId;
	private Integer orgiLevel;
	private String photoType;
	private String licenseModel;
	private Integer contentTypeId;
	private Integer contentTypeSecondaryId;
	private Integer collectionId;
	private Integer marketingCollectionId;
	private String collectionTier;
	private Integer pricing;
	private int isInImageGroup;
	private String keyChinese;
	private String keyEnglish;
	private String reason;
	private String uploadstartdate;
	private String uploadendate;
	
	
	
	
	
	public TubeOrgiImageSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TubeOrgiImageSearch(Long id, String uuid, Integer filesize,
			String orgiFilename, String filename, String storageid,
			String userid, String title, String caption, Integer status,
			Date dateupload, String approvedBy, Date dateapproved,
			Date datePhotographed, Date datePhotographedApprox,
			String displaylocation, String modelReleaseStatus,
			String propertyReleaseStatus, Integer contentType,
			Integer contentSecondType, String customCreditLine,
			Integer sizeCode, String restriction, String photographer,
			Integer providerId, Integer orgiLevel, String photoType,
			String licenseModel, Integer contentTypeId,
			Integer contentTypeSecondaryId, Integer collectionId,
			Integer marketingCollectionId, String collectionTier,
			Integer pricing, int isInImageGroup, String keyChinese,
			String keyEnglish, String reason) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.filesize = filesize;
		this.orgiFilename = orgiFilename;
		this.filename = filename;
		this.storageid = storageid;
		this.userid = userid;
		this.title = title;
		this.caption = caption;
		this.status = status;
		this.dateupload = dateupload;
		this.approvedBy = approvedBy;
		this.dateapproved = dateapproved;
		this.datePhotographed = datePhotographed;
		this.datePhotographedApprox = datePhotographedApprox;
		this.displaylocation = displaylocation;
		this.modelReleaseStatus = modelReleaseStatus;
		this.propertyReleaseStatus = propertyReleaseStatus;
		this.contentType = contentType;
		this.contentSecondType = contentSecondType;
		this.customCreditLine = customCreditLine;
		this.sizeCode = sizeCode;
		this.restriction = restriction;
		this.photographer = photographer;
		this.providerId = providerId;
		this.orgiLevel = orgiLevel;
		this.photoType = photoType;
		this.licenseModel = licenseModel;
		this.contentTypeId = contentTypeId;
		this.contentTypeSecondaryId = contentTypeSecondaryId;
		this.collectionId = collectionId;
		this.marketingCollectionId = marketingCollectionId;
		this.collectionTier = collectionTier;
		this.pricing = pricing;
		this.isInImageGroup = isInImageGroup;
		this.keyChinese = keyChinese;
		this.keyEnglish = keyEnglish;
		this.reason = reason;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getFilesize() {
		return filesize;
	}
	public void setFilesize(Integer filesize) {
		this.filesize = filesize;
	}
	public String getOrgiFilename() {
		return orgiFilename;
	}
	public void setOrgiFilename(String orgiFilename) {
		this.orgiFilename = orgiFilename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getStorageid() {
		return storageid;
	}
	public void setStorageid(String storageid) {
		this.storageid = storageid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getDateupload() {
		return dateupload;
	}
	public void setDateupload(Date dateupload) {
		this.dateupload = dateupload;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Date getDateapproved() {
		return dateapproved;
	}
	public void setDateapproved(Date dateapproved) {
		this.dateapproved = dateapproved;
	}
	public Date getDatePhotographed() {
		return datePhotographed;
	}
	public void setDatePhotographed(Date datePhotographed) {
		this.datePhotographed = datePhotographed;
	}
	public Date getDatePhotographedApprox() {
		return datePhotographedApprox;
	}
	public void setDatePhotographedApprox(Date datePhotographedApprox) {
		this.datePhotographedApprox = datePhotographedApprox;
	}
	public String getDisplaylocation() {
		return displaylocation;
	}
	public void setDisplaylocation(String displaylocation) {
		this.displaylocation = displaylocation;
	}
	public String getModelReleaseStatus() {
		return modelReleaseStatus;
	}
	public void setModelReleaseStatus(String modelReleaseStatus) {
		this.modelReleaseStatus = modelReleaseStatus;
	}
	public String getPropertyReleaseStatus() {
		return propertyReleaseStatus;
	}
	public void setPropertyReleaseStatus(String propertyReleaseStatus) {
		this.propertyReleaseStatus = propertyReleaseStatus;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public Integer getContentSecondType() {
		return contentSecondType;
	}
	public void setContentSecondType(Integer contentSecondType) {
		this.contentSecondType = contentSecondType;
	}
	public String getCustomCreditLine() {
		return customCreditLine;
	}
	public void setCustomCreditLine(String customCreditLine) {
		this.customCreditLine = customCreditLine;
	}
	public Integer getSizeCode() {
		return sizeCode;
	}
	public void setSizeCode(Integer sizeCode) {
		this.sizeCode = sizeCode;
	}
	public String getRestriction() {
		return restriction;
	}
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public Integer getProviderId() {
		return providerId;
	}
	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}
	public Integer getOrgiLevel() {
		return orgiLevel;
	}
	public void setOrgiLevel(Integer orgiLevel) {
		this.orgiLevel = orgiLevel;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public String getLicenseModel() {
		return licenseModel;
	}
	public void setLicenseModel(String licenseModel) {
		this.licenseModel = licenseModel;
	}
	public Integer getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	public Integer getContentTypeSecondaryId() {
		return contentTypeSecondaryId;
	}
	public void setContentTypeSecondaryId(Integer contentTypeSecondaryId) {
		this.contentTypeSecondaryId = contentTypeSecondaryId;
	}
	public Integer getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}
	public Integer getMarketingCollectionId() {
		return marketingCollectionId;
	}
	public void setMarketingCollectionId(Integer marketingCollectionId) {
		this.marketingCollectionId = marketingCollectionId;
	}
	public String getCollectionTier() {
		return collectionTier;
	}
	public void setCollectionTier(String collectionTier) {
		this.collectionTier = collectionTier;
	}
	public Integer getPricing() {
		return pricing;
	}
	public void setPricing(Integer pricing) {
		this.pricing = pricing;
	}
	public int getIsInImageGroup() {
		return isInImageGroup;
	}
	public void setIsInImageGroup(int isInImageGroup) {
		this.isInImageGroup = isInImageGroup;
	}
	public String getKeyChinese() {
		return keyChinese;
	}
	public void setKeyChinese(String keyChinese) {
		this.keyChinese = keyChinese;
	}
	public String getKeyEnglish() {
		return keyEnglish;
	}
	public void setKeyEnglish(String keyEnglish) {
		this.keyEnglish = keyEnglish;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUploadstartdate() {
		return uploadstartdate;
	}

	public void setUploadstartdate(String uploadstartdate) {
		this.uploadstartdate = uploadstartdate;
	}

	public String getUploadendate() {
		return uploadendate;
	}

	public void setUploadendate(String uploadendate) {
		this.uploadendate = uploadendate;
	}
	
	
	
}
