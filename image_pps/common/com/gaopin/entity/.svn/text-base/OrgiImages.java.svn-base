/* This file OrgiImages.java is part of image_job .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.gaopin.annotation.JerryFormAfter;
import com.gaopin.annotation.JerryFormAfterGetList;
import com.gaopin.annotation.JerryFormBefore;

/**
 * OrgiImages entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orgi_images")
@JerryFormBefore("orgiImagesService")
@JerryFormAfter
public class OrgiImages implements java.io.Serializable {

	// Fields

	private Long id;
	private String imageUid;
	private String orgiID;
	private String corbisId;
	private Integer storageId;
	private String title;
	private String caption;
	private String imageColor;
	private String originalCaption;
	private String licenseModel;
	private Integer contentTypeId;
	private Integer contentTypeSecondaryId;
	private String subject;
	private String subjectSecondary;
	private String iptccategory;
	private String iptcsupplementalCategory;
	private Integer photographerId;
	private String iptcbyline;
	private String providerSource;
	private String iptcsource;
	private String credit;
	private String iptccredit;
	private String customCreditLine;
	private String manualArchiveCollection;
	private String automatedArchiveCollections;
	private String displaylocation;
	private Integer contractId;
	private String contractName;
	private Boolean modelReleaseRequired;
	private Boolean propertyReleaseRequired;
	private Byte modelReleaseStatus;
	private Byte propertyReleaseStatus;
	private Integer representationrights;
	private String modelReleaseIds;
	private String propertyReleaseIds;
	private String mediaRatingText;
	private Date datePhotographed;
	private String datePhotographedApprox;
	private Integer fineArtCopyrightStatus;
	private String fineArtCreditLine;
	private Boolean isInImageSet;
	private Boolean isInRfcd;
	private Integer isInImageGroup;
	private Date dateExpiration;
	private Date datePublished;
	private Date domesticEmbargoDate;
	private Date internationalEmbargoDate;
	private Integer placement;
	private Integer pricing;
	private Boolean rightOfFirstSale;
	private String outlineSessionUid;
	private Boolean isOutline;
	private String outlineMagazineName;
	private Integer marketingCollectionId;
	private Integer collectionId;
	private String collectionTier;
	private Date createdAt;
	private Date changedAt;
	private String keyEnglish;
	private String keyChinese;
	private String termsSpecial;
	private String restrictionIds;
	private String contentWarningIds;
	private Integer maxSizeCode;
	private Integer height;
	private Integer width;
	private Integer selector;
	private Date selectedDate;
	private Integer lastEditor;
	private Date inputDate;
	private Integer selectionStatus;
	private Integer status;
	private Boolean searchableInternal;
	private Boolean searchableExternal;
	private String renderings;
	private String colorAppearance;
	private String originalMediaFormat;
	private Integer providerId;
	private String originalFilename;
	private String iptc;
	private String salesData;
	private String remark;
	private String aspectRatio;
	private Integer eexsitMaxCode;
	private Integer eheight;
	private Integer ewidth;
	private Integer needTrans;
	//~~
	private String cdName;
	private String keyChinese_PT;
	private String keyChinese_WEB;
	// Constructors

	/** default constructor */
	public OrgiImages() {
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ImageUID", length = 40)
	public String getImageUid() {
		return this.imageUid;
	}

	public void setImageUid(String imageUid) {
		this.imageUid = imageUid;
	}

	@Column(name = "OrgiID")
	public String getOrgiID() {
		return this.orgiID;
	}

	public void setOrgiID(String orgiID) {
		this.orgiID = orgiID;
	}

	@Column(name = "CorbisID", unique = true, length = 16)
	public String getCorbisId() {
		return this.corbisId;
	}

	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}

	@Column(name = "StorageID")
	public Integer getStorageId() {
		return this.storageId;
	}

	public void setStorageId(Integer storageId) {
		this.storageId = storageId;
	}

	@Column(name = "Title", length = 1000)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Caption", length = 1000)
	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Column(name = "imageColor", length = 100)
	public String getImageColor() {
		return this.imageColor;
	}

	public void setImageColor(String imageColor) {
		this.imageColor = imageColor;
	}

	@Column(name = "OriginalCaption", length = 1000)
	public String getOriginalCaption() {
		return this.originalCaption;
	}

	public void setOriginalCaption(String originalCaption) {
		this.originalCaption = originalCaption;
	}

	@Column(name = "LicenseModel", length = 4)
	public String getLicenseModel() {
		return this.licenseModel;
	}

	public void setLicenseModel(String licenseModel) {
		this.licenseModel = licenseModel;
	}

	@Column(name = "ContentTypeId")
	public Integer getContentTypeId() {
		return this.contentTypeId;
	}

	public void setContentTypeId(Integer contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	@Column(name = "ContentTypeSecondaryId")
	public Integer getContentTypeSecondaryId() {
		return this.contentTypeSecondaryId;
	}

	public void setContentTypeSecondaryId(Integer contentTypeSecondaryId) {
		this.contentTypeSecondaryId = contentTypeSecondaryId;
	}

	@Column(name = "Subject", length = 100)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "SubjectSecondary", length = 100)
	public String getSubjectSecondary() {
		return this.subjectSecondary;
	}

	public void setSubjectSecondary(String subjectSecondary) {
		this.subjectSecondary = subjectSecondary;
	}

	@Column(name = "IPTCCategory", length = 50)
	public String getIptccategory() {
		return this.iptccategory;
	}

	public void setIptccategory(String iptccategory) {
		this.iptccategory = iptccategory;
	}

	@Column(name = "IPTCSupplementalCategory", length = 50)
	public String getIptcsupplementalCategory() {
		return this.iptcsupplementalCategory;
	}

	public void setIptcsupplementalCategory(String iptcsupplementalCategory) {
		this.iptcsupplementalCategory = iptcsupplementalCategory;
	}

	@Column(name = "PhotographerId")
	public Integer getPhotographerId() {
		return this.photographerId;
	}

	public void setPhotographerId(Integer photographerId) {
		this.photographerId = photographerId;
	}

	@Column(name = "IPTCByline", length = 100)
	public String getIptcbyline() {
		return this.iptcbyline;
	}

	public void setIptcbyline(String iptcbyline) {
		this.iptcbyline = iptcbyline;
	}

	@Column(name = "ProviderSource", length = 100)
	public String getProviderSource() {
		return this.providerSource;
	}

	public void setProviderSource(String providerSource) {
		this.providerSource = providerSource;
	}

	@Column(name = "IPTCSource", length = 100)
	public String getIptcsource() {
		return this.iptcsource;
	}

	public void setIptcsource(String iptcsource) {
		this.iptcsource = iptcsource;
	}

	@Column(name = "Credit", length = 50)
	public String getCredit() {
		return this.credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	@Column(name = "IPTCCredit", length = 50)
	public String getIptccredit() {
		return this.iptccredit;
	}

	public void setIptccredit(String iptccredit) {
		this.iptccredit = iptccredit;
	}

	@Column(name = "CustomCreditLine", length = 200)
	public String getCustomCreditLine() {
		return this.customCreditLine;
	}

	public void setCustomCreditLine(String customCreditLine) {
		this.customCreditLine = customCreditLine;
	}

	@Column(name = "ManualArchiveCollection", length = 50)
	public String getManualArchiveCollection() {
		return this.manualArchiveCollection;
	}

	public void setManualArchiveCollection(String manualArchiveCollection) {
		this.manualArchiveCollection = manualArchiveCollection;
	}

	@Column(name = "AutomatedArchiveCollections", length = 10)
	public String getAutomatedArchiveCollections() {
		return this.automatedArchiveCollections;
	}

	public void setAutomatedArchiveCollections(
			String automatedArchiveCollections) {
		this.automatedArchiveCollections = automatedArchiveCollections;
	}

	@Column(name = "Displaylocation", length = 100)
	public String getDisplaylocation() {
		return this.displaylocation;
	}

	public void setDisplaylocation(String displaylocation) {
		this.displaylocation = displaylocation;
	}

	@Column(name = "ContractID")
	public Integer getContractId() {
		return this.contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	@Column(name = "ContractName", length = 200)
	public String getContractName() {
		return this.contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	@Column(name = "ModelReleaseRequired")
	public Boolean getModelReleaseRequired() {
		return this.modelReleaseRequired;
	}

	public void setModelReleaseRequired(Boolean modelReleaseRequired) {
		this.modelReleaseRequired = modelReleaseRequired;
	}

	@Column(name = "PropertyReleaseRequired")
	public Boolean getPropertyReleaseRequired() {
		return this.propertyReleaseRequired;
	}

	public void setPropertyReleaseRequired(Boolean propertyReleaseRequired) {
		this.propertyReleaseRequired = propertyReleaseRequired;
	}

	@Column(name = "ModelReleaseStatus")
	public Byte getModelReleaseStatus() {
		return this.modelReleaseStatus;
	}

	public void setModelReleaseStatus(Byte modelReleaseStatus) {
		this.modelReleaseStatus = modelReleaseStatus;
	}

	@Column(name = "PropertyReleaseStatus")
	public Byte getPropertyReleaseStatus() {
		return this.propertyReleaseStatus;
	}

	public void setPropertyReleaseStatus(Byte propertyReleaseStatus) {
		this.propertyReleaseStatus = propertyReleaseStatus;
	}

	@Column(name = "Representationrights")
	public Integer getRepresentationrights() {
		return this.representationrights;
	}

	public void setRepresentationrights(Integer representationrights) {
		this.representationrights = representationrights;
	}

	@Column(name = "ModelReleaseIds", length = 50)
	public String getModelReleaseIds() {
		return this.modelReleaseIds;
	}

	public void setModelReleaseIds(String modelReleaseIds) {
		this.modelReleaseIds = modelReleaseIds;
	}

	@Column(name = "PropertyReleaseIds", length = 50)
	public String getPropertyReleaseIds() {
		return this.propertyReleaseIds;
	}

	public void setPropertyReleaseIds(String propertyReleaseIds) {
		this.propertyReleaseIds = propertyReleaseIds;
	}

	@Column(name = "MediaRatingText", length = 10)
	public String getMediaRatingText() {
		return this.mediaRatingText;
	}

	public void setMediaRatingText(String mediaRatingText) {
		this.mediaRatingText = mediaRatingText;
	}

	@Column(name = "DatePhotographed", length = 0)
	public Date getDatePhotographed() {
		return this.datePhotographed;
	}

	public void setDatePhotographed(Date datePhotographed) {
		this.datePhotographed = datePhotographed;
	}

	@Column(name = "DatePhotographedApprox", length = 100)
	public String getDatePhotographedApprox() {
		return this.datePhotographedApprox;
	}

	public void setDatePhotographedApprox(String datePhotographedApprox) {
		this.datePhotographedApprox = datePhotographedApprox;
	}

	@Column(name = "FineArtCopyrightStatus")
	public Integer getFineArtCopyrightStatus() {
		return this.fineArtCopyrightStatus;
	}

	public void setFineArtCopyrightStatus(Integer fineArtCopyrightStatus) {
		this.fineArtCopyrightStatus = fineArtCopyrightStatus;
	}

	@Column(name = "FineArtCreditLine", length = 100)
	public String getFineArtCreditLine() {
		return this.fineArtCreditLine;
	}

	public void setFineArtCreditLine(String fineArtCreditLine) {
		this.fineArtCreditLine = fineArtCreditLine;
	}

	@Column(name = "IsInImageSet")
	public Boolean getIsInImageSet() {
		return this.isInImageSet;
	}

	public void setIsInImageSet(Boolean isInImageSet) {
		this.isInImageSet = isInImageSet;
	}

	@Column(name = "IsInRFCD")
	public Boolean getIsInRfcd() {
		return this.isInRfcd;
	}

	public void setIsInRfcd(Boolean isInRfcd) {
		this.isInRfcd = isInRfcd;
	}

	@Column(name = "IsInImageGroup")
	public Integer getIsInImageGroup() {
		return this.isInImageGroup;
	}

	public void setIsInImageGroup(Integer isInImageGroup) {
		this.isInImageGroup = isInImageGroup;
	}
	
	@Column(name = "DateExpiration", length = 0)
	public Date getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	@Column(name = "DatePublished", length = 0)
	public Date getDatePublished() {
		return this.datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	@Column(name = "DomesticEmbargoDate", length = 0)
	public Date getDomesticEmbargoDate() {
		return this.domesticEmbargoDate;
	}

	public void setDomesticEmbargoDate(Date domesticEmbargoDate) {
		this.domesticEmbargoDate = domesticEmbargoDate;
	}

	@Column(name = "InternationalEmbargoDate", length = 0)
	public Date getInternationalEmbargoDate() {
		return this.internationalEmbargoDate;
	}

	public void setInternationalEmbargoDate(Date internationalEmbargoDate) {
		this.internationalEmbargoDate = internationalEmbargoDate;
	}

	@Column(name = "Placement")
	public Integer getPlacement() {
		return this.placement;
	}

	public void setPlacement(Integer placement) {
		this.placement = placement;
	}

	@Column(name = "Pricing")
	public Integer getPricing() {
		return this.pricing;
	}

	public void setPricing(Integer pricing) {
		this.pricing = pricing;
	}

	@Column(name = "RightOfFirstSale")
	public Boolean getRightOfFirstSale() {
		return this.rightOfFirstSale;
	}

	public void setRightOfFirstSale(Boolean rightOfFirstSale) {
		this.rightOfFirstSale = rightOfFirstSale;
	}

	@Column(name = "OutlineSessionUID", length = 50)
	public String getOutlineSessionUid() {
		return this.outlineSessionUid;
	}

	public void setOutlineSessionUid(String outlineSessionUid) {
		this.outlineSessionUid = outlineSessionUid;
	}

	@Column(name = "IsOutline")
	public Boolean getIsOutline() {
		return this.isOutline;
	}

	public void setIsOutline(Boolean isOutline) {
		this.isOutline = isOutline;
	}

	@Column(name = "OutlineMagazineName", length = 1000)
	public String getOutlineMagazineName() {
		return this.outlineMagazineName;
	}

	public void setOutlineMagazineName(String outlineMagazineName) {
		this.outlineMagazineName = outlineMagazineName;
	}

	@Column(name = "MarketingCollectionID")
	public Integer getMarketingCollectionId() {
		return this.marketingCollectionId;
	}

	public void setMarketingCollectionId(Integer marketingCollectionId) {
		this.marketingCollectionId = marketingCollectionId;
	}

	@Column(name = "CollectionID")
	public Integer getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	@Column(name = "CollectionTier", length = 10)
	public String getCollectionTier() {
		return this.collectionTier;
	}

	public void setCollectionTier(String collectionTier) {
		this.collectionTier = collectionTier;
	}

	@Column(name = "CreatedAt", length = 0)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "ChangedAt", length = 0)
	public Date getChangedAt() {
		return this.changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	@Column(name = "KeyEnglish", length = 16777215)
	public String getKeyEnglish() {
		return this.keyEnglish;
	}

	public void setKeyEnglish(String keyEnglish) {
		this.keyEnglish = keyEnglish;
	}

	@Column(name = "KeyChinese", length = 16777215)
	public String getKeyChinese() {
		return this.keyChinese;
	}

	public void setKeyChinese(String keyChinese) {
		this.keyChinese = keyChinese;
	}
	
	@Column(name = "KeyPT", length = 16777215)
	public String getKeyChinese_PT() {
		return this.keyChinese_PT;
	}

	public void setKeyChinese_PT(String keyChinesePT) {
		this.keyChinese_PT = keyChinesePT;
	}
	
	@Column(name = "KeyWEB", length = 16777215)
	public String getKeyChinese_WEB() {
		return this.keyChinese_WEB;
	}

	public void setKeyChinese_WEB(String keyChineseWEB) {
		this.keyChinese_WEB = keyChineseWEB;
	}

	@Column(name = "TermsSpecial", length = 16777215)
	public String getTermsSpecial() {
		return this.termsSpecial;
	}

	public void setTermsSpecial(String termsSpecial) {
		this.termsSpecial = termsSpecial;
	}

	@Column(name = "RestrictionIds", length = 100)
	public String getRestrictionIds() {
		return this.restrictionIds;
	}

	public void setRestrictionIds(String restrictionIds) {
		this.restrictionIds = restrictionIds;
	}

	@Column(name = "ContentWarningIds", length = 100)
	public String getContentWarningIds() {
		return this.contentWarningIds;
	}

	public void setContentWarningIds(String contentWarningIds) {
		this.contentWarningIds = contentWarningIds;
	}

	@Column(name = "MaxSizeCode")
	public Integer getMaxSizeCode() {
		return this.maxSizeCode;
	}

	public void setMaxSizeCode(Integer maxSizeCode) {
		this.maxSizeCode = maxSizeCode;
	}

	@Column(name = "Height")
	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Column(name = "Width")
	public Integer getWidth() {
		return this.width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	@Column(name = "Selector")
	public Integer getSelector() {
		return this.selector;
	}

	public void setSelector(Integer selector) {
		this.selector = selector;
	}

	@Column(name = "SelectedDate", length = 0)
	public Date getSelectedDate() {
		return this.selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	@Column(name = "LastEditor")
	public Integer getLastEditor() {
		return this.lastEditor;
	}

	public void setLastEditor(Integer lastEditor) {
		this.lastEditor = lastEditor;
	}

	@Column(name = "InputDate", length = 0)
	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	@Column(name = "SelectionStatus")
	public Integer getSelectionStatus() {
		return this.selectionStatus;
	}

	public void setSelectionStatus(Integer selectionStatus) {
		this.selectionStatus = selectionStatus;
	}

	@Column(name = "Status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "SearchableInternal")
	public Boolean getSearchableInternal() {
		return this.searchableInternal;
	}

	public void setSearchableInternal(Boolean searchableInternal) {
		this.searchableInternal = searchableInternal;
	}

	@Column(name = "SearchableExternal")
	public Boolean getSearchableExternal() {
		return this.searchableExternal;
	}

	public void setSearchableExternal(Boolean searchableExternal) {
		this.searchableExternal = searchableExternal;
	}

	@Column(name = "Renderings", length = 1000)
	public String getRenderings() {
		return this.renderings;
	}

	public void setRenderings(String renderings) {
		this.renderings = renderings;
	}

	@Column(name = "ColorAppearance", length = 100)
	public String getColorAppearance() {
		return this.colorAppearance;
	}

	public void setColorAppearance(String colorAppearance) {
		this.colorAppearance = colorAppearance;
	}

	@Column(name = "OriginalMediaFormat", length = 10)
	public String getOriginalMediaFormat() {
		return this.originalMediaFormat;
	}

	public void setOriginalMediaFormat(String originalMediaFormat) {
		this.originalMediaFormat = originalMediaFormat;
	}

	@Column(name = "ProviderID")
	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	@Column(name = "OriginalFilename", length = 100)
	public String getOriginalFilename() {
		return this.originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	@Column(name = "IPTC", length = 16777215)
	public String getIptc() {
		return this.iptc;
	}

	public void setIptc(String iptc) {
		this.iptc = iptc;
	}

	@Column(name = "SalesData", length = 50)
	public String getSalesData() {
		return this.salesData;
	}

	public void setSalesData(String salesData) {
		this.salesData = salesData;
	}

	@Column(name = "Remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "AspectRatio", length = 10)
	public String getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	@Column(name = "EExsitMaxCode")
	public Integer getEexsitMaxCode() {
		return this.eexsitMaxCode;
	}

	public void setEexsitMaxCode(Integer eexsitMaxCode) {
		this.eexsitMaxCode = eexsitMaxCode;
	}

	@Column(name = "EHeight")
	public Integer getEheight() {
		return this.eheight;
	}

	public void setEheight(Integer eheight) {
		this.eheight = eheight;
	}

	@Column(name = "EWidth")
	public Integer getEwidth() {
		return this.ewidth;
	}

	public void setEwidth(Integer ewidth) {
		this.ewidth = ewidth;
	}

	@Transient
	public String getCdName() {
		return cdName;
	}

	public void setCdName(String cdName) {
		this.cdName = cdName;
	}

	@Column(name = "NeedTrans")
	public Integer getNeedTrans() {
		return this.needTrans;
	}

	public void setNeedTrans(Integer status) {
		this.needTrans = status;
	}
	
}