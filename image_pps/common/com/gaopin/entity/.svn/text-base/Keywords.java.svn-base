/* This file Keywords.java is part of image_pps .
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
@JerryLoadAll
@Entity
@Table(name = "fr_keywords")
public class Keywords implements java.io.Serializable {

	// Fields

	private int id;
	private String keyword;
	private int num;
	private byte showStatus;
	

	// Constructors

	/** default constructor */
	public Keywords() {
	}

	/** full constructor */
	public Keywords(String keyword, int num) {
		this.keyword = keyword;
		this.num = num;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "keyword", length = 30)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "num")
	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Column(name = "show_status")
	public byte getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(byte showStatus) {
		this.showStatus = showStatus;
	}
	
	
}