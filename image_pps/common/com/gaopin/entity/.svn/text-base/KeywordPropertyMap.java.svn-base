/* This file KeywordPropertyMap.java is part of image_pps .
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

/**
 * FrClarification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_keyword_property_map", catalog = "gaopin_images")
public class KeywordPropertyMap implements java.io.Serializable {

	// Fields

	private Integer id;
	private String keyword;
	private String property;
	private String classify; 
	private Integer type;
	
	 
	@Column(name = "classify", length = 32)
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

	// Constructors

	/** default constructor */
	public KeywordPropertyMap() {
	}

	/** full constructor */
	public KeywordPropertyMap(String keyword, String property) {
		this.keyword = keyword;
		this.property = property;
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

	@Column(name = "keyword", length = 32)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "property", length = 32)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	 
}