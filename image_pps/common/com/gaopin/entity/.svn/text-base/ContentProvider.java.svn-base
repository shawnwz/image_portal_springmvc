/* This file ContentProvider.java is part of image_pps .
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
 * FrContentProvider entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_content_provider")
public class ContentProvider implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String showName;
	private String intro;
	private Date createTime;
	private Date updateTime;

	private String sapEx;
	private Integer logid;
	@Column(name = "logid")
	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	private Integer sapid;
	// Constructors

	/** default constructor */
	public ContentProvider() {
	}

	/** full constructor */
	public ContentProvider(String name, String showName, String intro,
			Date createTime, Date updateTime,String sapex,Integer sapid,Integer logid) {
		this.name = name;
		this.showName = showName;
		this.intro = intro;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sapEx=sapex;
		this.sapid=sapid;
		this.logid=logid;
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

	@Column(name = "show_name", length = 100)
	public String getShowName() {
		return this.showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
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


	@Column(name = "sapex", length = 4000)
	public String getSapEx() {
		return sapEx;
	}

	public void setSapEx(String sapEx) {
		this.sapEx = sapEx;
	}



	@Column(name = "sapid", length = 10)
	public Integer getSapid() {
		return sapid;
	}

	public void setSapid(Integer sapid) {
		this.sapid = sapid;
	}
	
	
}