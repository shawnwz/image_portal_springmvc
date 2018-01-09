/* This file FlowJoinUs.java is part of image_pps .
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
 * FrFlowJoinUs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_flow_join_us")
public class FlowJoinUs implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String department;
	private String area;
	private String jobContent;
	private String requires;
	private Date createTime;
	private Date updateTime;
	private Integer sortId;

	// Constructors

	/** default constructor */
	public FlowJoinUs() {
	}

	/** full constructor */
	public FlowJoinUs(String title, String department, String area,
			String jobContent, String requires, Date createTime,
			Date updateTime, Integer sortId) {
		this.title = title;
		this.department = department;
		this.area = area;
		this.jobContent = jobContent;
		this.requires = requires;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sortId = sortId;
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

	@Column(name = "title", length = 32)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "department", length = 32)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "area", length = 16)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "job_content", length = 16777215)
	public String getJobContent() {
		return this.jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	@Column(name = "requires", length = 16777215)
	public String getRequires() {
		return this.requires;
	}

	public void setRequires(String requires) {
		this.requires = requires;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "sort_id")
	public Integer getSortId() {
		return this.sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

}