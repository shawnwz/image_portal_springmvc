/* This file SystemMenu.java is part of image_pps .
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

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gaopin.annotation.JerryEntitySort;

/**
 * SystemMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "system_menu")
public class SystemMenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String menuName;
	private Integer parentId;
	private String menuUrl;
	private String menuCss;
	private String enName;
	
	@JerryEntitySort(isAsc=false)
	private Integer sequence;
	private Integer status;
	private Integer creator;
	private Integer modifier;
	private Date createTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public SystemMenu() {
	}

	/** full constructor */
	public SystemMenu(String menuName, Integer parentId, String menuUrl,
			String menuCss, String enName, Integer sequence, Integer status,
			Integer creator, Integer modifier, Date createTime, Date updateTime) {
		this.menuName = menuName;
		this.parentId = parentId;
		this.menuUrl = menuUrl;
		this.menuCss = menuCss;
		this.enName = enName;
		this.sequence = sequence;
		this.status = status;
		this.creator = creator;
		this.modifier = modifier;
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

	@Column(name = "menu_name", length = 30)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "menu_url", length = 1000)
	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	@Column(name = "menu_css", length = 200)
	public String getMenuCss() {
		return this.menuCss;
	}

	public void setMenuCss(String menuCss) {
		this.menuCss = menuCss;
	}

	@Column(name = "en_name", length = 100)
	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "sequence")
	public Integer getSequence() {
		return this.sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "creator")
	public Integer getCreator() {
		return this.creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	@Column(name = "modifier")
	public Integer getModifier() {
		return this.modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
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
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}