/* This file ImageThematicContent2del.java is part of image_pps .
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

import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.StrUtils;

/**
 * FrPhotographer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = " fr_image_thematic_content", catalog = "gaopin_images")
public class ImageThematicContent2del implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String title;
	private String intro;
	private Date createTime;
	private Date updateTime;
	private String template;

	//@Transient
//	private PageTemplate pageTemplate; 
	
	// Constructors

	/** default constructor */
	public ImageThematicContent2del() {
	}

	/** full constructor */
	public ImageThematicContent2del(String name, String title, String intro,
			Date createTime, Date updateTime) {
		this.name = name;
		this.title = title;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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