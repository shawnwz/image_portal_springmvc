/* This file SearchRule.java is part of image_pps .
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

import com.gaopin.annotation.JerryLoadAll;

/**
 *  entity. @author MyEclipse Persistence Tools
 */
@JerryLoadAll
@Entity
@Table(name = "fr_search_rule")
public class SearchRule implements java.io.Serializable {

	// Fields

	private Integer id; 
	private String  key;
	private String replaceKey; 
	private String excludeKey; 

	// Constructors

	/** default constructor */
	public SearchRule() {
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
 
	@Column(name = "search_key", length = 100)
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "replace_key", length = 200)
	public String getReplaceKey() {
		return replaceKey;
	}

	public void setReplaceKey(String replaceKey) {
		this.replaceKey = replaceKey;
	}

	@Column(name = "exclude_key", length = 200)
	public String getExcludeKey() {
		return excludeKey;
	}

	public void setExcludeKey(String excludeKey) {
		this.excludeKey = excludeKey;
	}

	

}