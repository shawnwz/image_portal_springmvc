/* This file ImageGroup.java is part of image_pps .
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
import com.gaopin.annotation.JerryFormBefore;

/**
 * FrImageGroup entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "fr_image_group")
@JerryFormAfterGetList("imageGroupService")
public class ImageGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String gaopin_name;
	private Integer categoryId;
	private Integer num;
//	private Integer photographerId;
	private String intro;
	private String gaopin_intro;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	private String coverImage;

	private String photographerName;
	private String location;
	private String backName;
	private String code;
	private String urlCode;
	private String categoryName;
	
	
	// Constructors
	@Transient
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "location", length = 128)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "back_name", length = 128)
	public String getBackName() {
		return backName;
	}

	public void setBackName(String backName) {
		this.backName = backName;
	}

	@Column(name = "code", length = 128)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "url_code", length = 128)
	public String getUrlCode() {
		return urlCode;
	}

	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}

	@Column(name = "photographer", length = 128)
	public String getPhotographerName() {
		return photographerName;
	}

	public void setPhotographerName(String photographerName) {
		this.photographerName = photographerName;
	}

	/** default constructor */
	public ImageGroup() {
	}

	/** full constructor */
	public ImageGroup(String name, Integer categoryId, Integer num,
			String intro, Integer status,
			Date createTime, Date updateTime) {
		this.name = name;
		this.categoryId = categoryId;
		this.num = num;
//		this.photographerId = photographerId;
		this.intro = intro;
		this.status = status;
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
	@Column(name = "gaopin_name", length = 100)
	public String getGaopin_name() {
		return gaopin_name;
	}

	public void setGaopin_name(String gaopin_name) {
		this.gaopin_name = gaopin_name;
	}

	@Column(name = "category_id")
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

//	@Column(name = "photographer_id")
//	public Integer getPhotographerId() {
//		return this.photographerId;
//	}
//
//	public void setPhotographerId(Integer photographerId) {
//		this.photographerId = photographerId;
//	}

	@Column(name = "intro", length = 1000)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	@Column(name = "gaopin_intro", length = 1000)
	public String getGaopin_intro() {
		return gaopin_intro;
	}

	public void setGaopin_intro(String gaopin_intro) {
		this.gaopin_intro = gaopin_intro;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Column(name = "cover_image", length = 1000)
	public String getCoverImage() {
		return this.coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
}