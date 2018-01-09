/* This file SystemOperateLog.java is part of image_pps .
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
 * SystemOperateLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "system_operate_log")
public class SystemOperateLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String intro;
	private String oldData;
	private String newData;
	private String userIp;
	private Date createTime;

	// Constructors

	/** default constructor */
	public SystemOperateLog() {
	}

	/** full constructor */
	public SystemOperateLog(Integer userId, String intro, String oldData,
			String newData, String userIp, Date createTime) {
		this.userId = userId;
		this.intro = intro;
		this.oldData = oldData;
		this.newData = newData;
		this.userIp = userIp;
		this.createTime = createTime;
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

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "intro", length = 300)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(name = "old_data", length = 16777215)
	public String getOldData() {
		return this.oldData;
	}

	public void setOldData(String oldData) {
		this.oldData = oldData;
	}

	@Column(name = "new_data", length = 16777215)
	public String getNewData() {
		return this.newData;
	}

	public void setNewData(String newData) {
		this.newData = newData;
	}

	@Column(name = "user_ip", length = 20)
	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}