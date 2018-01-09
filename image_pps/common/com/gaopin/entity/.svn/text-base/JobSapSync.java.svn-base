/* This file JobSapSync.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JobSapSync entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "job_sap_sync")
public class JobSapSync implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private Integer logid;
	private String json;
	private Integer status;
	private String message;
	private Date createtime;
	private Date updatetime;

	// Constructors

	/** default constructor */
	public JobSapSync() {
	}

	/** full constructor */
	public JobSapSync(String type, Integer logid, String json, Integer status,
			String message, Date createtime, Date updatetime) {
		this.type = type;
		this.logid = logid;
		this.json = json;
		this.status = status;
		this.message = message;
		this.createtime = createtime;
		this.updatetime = updatetime;
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

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "logid")
	public Integer getLogid() {
		return this.logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	@Column(name = "json", length = 16777215)
	public String getJson() {
		return this.json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "message", length = 100)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "createtime", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "updatetime", length = 19)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}