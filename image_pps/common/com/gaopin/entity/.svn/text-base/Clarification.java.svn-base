/* This file Clarification.java is part of image_pps .
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
 * FrClarification entity. @author MyEclipse Persistence Tools
 */
@Entity
@JerryLoadAll
@Table(name = "fr_clarification")
public class Clarification implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String items;
	private String queryKey;
	private Integer type;

	// Constructors

	/** default constructor */
	public Clarification() {
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

	@Column(name = "items", length = 400)
	public String getItems() {
		return this.items;
	}

	public void setItems(String items) {
		this.items = items;
	}
	
	@Column(name = "query_key")
	public String getQueryKey() {
		return queryKey;
	}

	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}