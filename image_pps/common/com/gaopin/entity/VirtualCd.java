/* This file VirtualCd.java is part of image_pps .
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

/**
 * FrVirtualCd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_virtual_cd")
public class VirtualCd implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer categoryId;
	private Short licenseType;
	private Integer picNum;
	private Integer status;
	private String intro;
	private Date createTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public VirtualCd() {
	}

	/** full constructor */
	public VirtualCd(String name, Integer categoryId, Short licenseType,
			Integer picNum, Integer status, String intro, Date createTime,
			Date updateTime) {
		this.name = name;
		this.categoryId = categoryId;
		this.licenseType = licenseType;
		this.picNum = picNum;
		this.status = status;
		this.intro = intro;
		this.createTime = createTime;
		this.updateTime = updateTime;
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

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "license_type")
	public Short getLicenseType() {
		return this.licenseType;
	}

	public void setLicenseType(Short licenseType) {
		this.licenseType = licenseType;
	}

	@Column(name = "pic_num")
	public Integer getPicNum() {
		return this.picNum;
	}

	public void setPicNum(Integer picNum) {
		this.picNum = picNum;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "intro", length = 1000)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

}