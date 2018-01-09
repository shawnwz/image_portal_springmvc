/* This file KeywordCollection.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gaopin.annotation.JerryFormAfter;
import com.gaopin.annotation.JerryLoadAll;

/**
 * FrClarification entity. @author MyEclipse Persistence Tools
 */
@JerryLoadAll
@Entity
@Table(name = "fr_keyword_collection")
@JerryFormAfter(service="cmsKeywordCollection")
public class KeywordCollection implements java.io.Serializable {

	// Fields

	private Integer id;
	private String english;
	private String chinese;
	private Integer pt;
	private Integer status;
	

	// Constructors

	/** default constructor */
	public KeywordCollection() {
	}

	/** full constructor */
	public KeywordCollection(String english, String chinese,Integer status) {
		this.english = english;
		this.chinese = chinese;
		this.status = status;
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

	@Column(name = "english", length = 32)
	public String getEnglish() {
		return this.english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	@Column(name = "chinese", length = 32)
	public String getChinese() {
		return this.chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	@Column(name = "PT")
	public Integer getPt() {
		return this.pt;
	}

	public void setPt(Integer pt) {
		this.pt = pt;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}