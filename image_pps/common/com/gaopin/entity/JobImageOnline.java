/* This file JobImageOnline.java is part of image_pps .
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
@Table(name = "job_image_online")
public class JobImageOnline implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long imageId;
	private String corbisId;
	private Integer status;
	private Integer type;
	private Integer userId;
	private Integer tryTimes;
	private Date createtime;
	private Date updatetime;
	private Date validtime;

	@Column(name="valid_time")
	public Date getValidtime() {
		return validtime;
	}

	public void setValidtime(Date validtime) {
		this.validtime = validtime;
	}

	/** default constructor */
	public JobImageOnline() {
	}

//	/** full constructor */
//	public JobImageOnline(String type, Integer logid, String json, Integer status,
//			String message, Date createtime, Date updatetime) {
//		this.type = type;
//		this.logid = logid;
//		this.json = json;
//		this.status = status;
//		this.message = message;
//		this.createtime = createtime;
//		this.updatetime = updatetime;
//	}

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
 

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
 
	@Column(name = "image_id")
	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	@Column(name = "corbis_id")
	public String getCorbisId() {
		return corbisId;
	}

	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}

	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "try_times")
	public Integer getTryTimes() {
		return tryTimes;
	}

	public void setTryTimes(Integer tryTimes) {
		this.tryTimes = tryTimes;
	}

	
	@Column(name = "create_time", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "update_time", length = 19)
	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}