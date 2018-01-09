/* This file ImageCollection.java is part of image_pps .
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

import com.gaopin.annotation.JerryFormAfterGetList;
import com.gaopin.annotation.JerryLoadAll;

/**
 * FrImageCollection entity. @author MyEclipse Persistence Tools
 */
@JerryLoadAll
@Entity
@Table(name = "fr_image_collection")
@JerryFormAfterGetList("imageCollectionService")
public class ImageCollection implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer parentId;
	private String name;
	private String showName;
	private String pricingTier;
	private String caption;
	private String intro;
	private Integer categoryId;
	private Integer cpId;
	private String brandName;
	private Integer imageNum;
	private Integer licenseType;
	private Integer status;
	private Integer score;
	private Integer level;
	private String coverUrl;
	private Integer showSimilar;
	private String template;
	private Integer sortId;
	private Date createTime;
	private Date updateTime;

	private Integer secondCategoryId;
	private String parentName;
	private String categoryName;
	private String secondCategorysName;
	private String cpName;
	private String showSimilarName;
	private String licenseTypeName;
	private Integer sizeId;
	  
	private Date expireTime;
	private Date auditTime;
 
	private String ext;
	
	@Transient
	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	@Transient
	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	@Transient
	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	@Transient
	public String getLicenseTypeName() {
		return licenseTypeName;
	}

	public void setLicenseTypeName(String licenseTypeName) {
		this.licenseTypeName = licenseTypeName;
	}

	@Transient
	public String getShowSimilarName() {
		return showSimilarName;
	}

	public void setShowSimilarName(String showSimilarName) {
		this.showSimilarName = showSimilarName;
	}

	// Constructors
	@Transient
	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
 
	@Transient
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	@Transient
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Transient
	public String getSecondCategorysName() {
		return secondCategorysName;
	}

	public void setSecondCategorysName(String secondCategorysName) {
		this.secondCategorysName = secondCategorysName;
	}

	@Column(name = "second_category_id")
	public Integer getSecondCategoryId() {
		return secondCategoryId;
	}

	public void setSecondCategoryId(Integer secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	/** default constructor */
	public ImageCollection() {
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "show_name", length = 100)
	public String getShowName() {
		return this.showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	@Column(name = "pricing_tier")
	public String getPricingTier() {
		return pricingTier;
	}

	public void setPricingTier(String pricingTier) {
		this.pricingTier = pricingTier;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "score")
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "caption", length = 200)
	public String getCaption() {
		return this.caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Column(name = "intro", length = 4000)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "cp_id")
	public Integer getCpId() {
		return this.cpId;
	}

	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}

	@Column(name = "brand_name")
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name = "image_num")
	public Integer getImageNum() {
		return this.imageNum;
	}

	public void setImageNum(Integer imageNum) {
		this.imageNum = imageNum;
	}

	@Column(name = "license_type")
	public Integer getLicenseType() {
		return this.licenseType;
	}

	public void setLicenseType(Integer licenseType) {
		this.licenseType = licenseType;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "cover_url", length = 1000)
	public String getCoverUrl() {
		return this.coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	@Column(name = "show_similar")
	public Integer getShowSimilar() {
		return this.showSimilar;
	}

	public void setShowSimilar(Integer showSimilar) {
		this.showSimilar = showSimilar;
	}

	@Column(name = "template", length = 4000)
	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Column(name = "sort_id")
	public Integer getSortId() {
		return this.sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 0)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Column(name = "ext")
	public String getExt() {
		return this.ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	 
}