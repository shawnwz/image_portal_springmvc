/* This file Photographer.java is part of image_pps .
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
 * FrPhotographer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_photographer")
public class Photographer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String showName;
	private String intro;
	private Date createTime;
	private Date updateTime;
	private String template;

	//@Transient
//	private PageTemplate pageTemplate; 
	
	// Constructors

	/** default constructor */
	public Photographer() {
	}

	/** full constructor */
	public Photographer(String name, String showName, String intro,
			Date createTime, Date updateTime) {
		this.name = name;
		this.showName = showName;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "show_name")
	public String getShowName() {
		return this.showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	@Column(name = "intro")
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "template", length = 16777215)
	public String getTemplate() {
		 
//		try{
//			if( template!=null){
//				template = StrUtils.getSqlInArray(
//						JsonFormat.toObject(template, PageTemplate.class).getThumbimages() );
//			}
//		}
//		catch (Exception e) {
//		}
		return template;
	}

	public void setTemplate(String template) {

//		PageTemplate obj = new PageTemplate();
//		obj.setThumbimages(template);
//		if(obj!=null){
//			template = JsonFormat.toString(obj);
//		}
		this.template = template;
	}
	
	 
	
}