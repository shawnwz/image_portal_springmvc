/* This file ImageGroupTopicCategory2del.java is part of image_pps .
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
@Table(name = "fr_imagegroup_topic_category")
public class ImageGroupTopicCategory2del implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name; 
	private String memo;
	private Integer status;
	private Date createTime;
	private Date updateTime; 
	
	// Constructors
 
	/** default constructor */
	public ImageGroupTopicCategory2del() {
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
 

	@Column(name = "memo", length = 1000)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String intro) {
		this.memo = intro;
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
}