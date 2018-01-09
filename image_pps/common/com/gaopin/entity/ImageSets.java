/* This file ImageSets.java is part of image_pps .
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
@Table(name = "fr_image_sets")
public class ImageSets implements java.io.Serializable {

	// Fields
	private Integer id;
	private Integer parentId;
	private String title;
	private String intro; 
	private Integer num;
	private String imageList;
	private Integer seq;
	private Date photographedDate;
	private String photographerName;
	private String location; 
	private Date createTime;
	private Date updateTime; 
	 

	/** default constructor */
	public ImageSets() {
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
 

	@Column(name = "content_num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
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

	@Column(name = "parent_id")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "title", length = 20)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "imagelist", length = 2048)
	public String getImageList() {
		return imageList;
	}

	public void setImageList(String imageList) {
		this.imageList = imageList;
	}

	@Column(name = "sequence")
	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	@Column(name = "photographed_date", length = 0)
	public Date getPhotographedDate() {
		return photographedDate;
	}

	public void setPhotographedDate(Date photographedDate) {
		this.photographedDate = photographedDate;
	}

	@Column(name = "photographor_name", length = 100)
	public String getPhotographerName() {
		return photographerName;
	}


	public void setPhotographerName(String photographerName) {
		this.photographerName = photographerName;
	}


	@Column(name = "location", length = 100)
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

}