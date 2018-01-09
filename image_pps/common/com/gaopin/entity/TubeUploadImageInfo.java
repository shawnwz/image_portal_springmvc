package com.gaopin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;

public class TubeUploadImageInfo {

	private String imageid;
	private String userid;
	private String title;
	private String description;
	private String collectionId;
	private String providerId;
	private String status;
	private int modelReleaseStatus;
	private int propertyReleaseStatus;
	private int contentType;
	private String customCreditLine;
	private String licenseModel;
	private String keywords;
	private String keywordsEnglish;
	public String getimageid() {
		return imageid;
	}
	public void setimageid(String imageid) {
		this.imageid = imageid;
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
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public String getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(String collectionId) {
		this.collectionId = collectionId;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getModelReleaseStatus() {
		return modelReleaseStatus;
	}
	public void setModelReleaseStatus(int modelReleaseStatus) {
		this.modelReleaseStatus = modelReleaseStatus;
	}
	public int getPropertyReleaseStatus() {
		return propertyReleaseStatus;
	}
	public void setPropertyReleaseStatus(int propertyReleaseStatus) {
		this.propertyReleaseStatus = propertyReleaseStatus;
	}
	public int getContentType() {
		return contentType;
	}
	public void setContentType(int contentType) {
		this.contentType = contentType;
	}
	public String getCustomCreditLine() {
		return customCreditLine;
	}
	public void setCustomCreditLine(String customCreditLine) {
		this.customCreditLine = customCreditLine;
	}
	public String getLicenseModel() {
		return licenseModel;
	}
	public void setLicenseModel(String licenseModel) {
		this.licenseModel = licenseModel;
	}
	public String getkeywords() {
		return keywords;
	}
	public void setkeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getKeywordsEnglish() {
		return keywordsEnglish;
	}
	public void setKeywordsEnglish(String keywordsEnglish) {
		this.keywordsEnglish = keywordsEnglish;
	}
	@Override
	public String toString() {
		return "TubeUploadImageInfo [imageid=" + imageid + ", userid=" + userid
				+ ", title=" + title + ", description=" + description
				+ ", collectionId=" + collectionId + ", providerId="
				+ providerId + ", status=" + status + ", modelReleaseStatus="
				+ modelReleaseStatus + ", propertyReleaseStatus="
				+ propertyReleaseStatus + ", contentType=" + contentType
				+ ", customCreditLine=" + customCreditLine + ", licenseModel="
				+ licenseModel + ", keywords=" + keywords
				+ ", keywordsEnglish=" + keywordsEnglish + ", getimageid()="
				+ getimageid() + ", getUserid()=" + getUserid() + ", getTitle()="
				+ getTitle() + ", getdescription()=" + getdescription()
				+ ", getCollectionId()=" + getCollectionId()
				+ ", getProviderId()=" + getProviderId() + ", getStatus()="
				+ getStatus() + ", getModelReleaseStatus()="
				+ getModelReleaseStatus() + ", getPropertyReleaseStatus()="
				+ getPropertyReleaseStatus() + ", getContentType()="
				+ getContentType() + ", getCustomCreditLine()="
				+ getCustomCreditLine() + ", getLicenseModel()="
				+ getLicenseModel() + ", getkeywords()="
				+ getkeywords() + ", getKeywordsEnglish()="
				+ getKeywordsEnglish() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
	
	
	
}
