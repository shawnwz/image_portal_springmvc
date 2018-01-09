/* This file DownloadHistory.java is part of image_pps .
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
import javax.persistence.Transient;

/**
 * FrDownloadHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_download_history")
public class DownloadHistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String corbisId;
	private Integer sizeType;
	private Integer type;
	private Integer odNum;
	private Date createTime;
	private Integer orderId;
	private String imgViewPath;
	private String imgDownloadPath;
	private Long days;

	// Constructors

	/** default constructor */
	public DownloadHistory() {
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
	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	@Column(name = "od_num")
	public Integer getOdNum() {
		return odNum;
	}

	public void setOdNum(Integer odNum) {
		this.odNum = odNum;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "corbis_id")
	public String getCorbisId() {
		return this.corbisId;
	}

	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}
	
	@Column(name = "size_type")
	public Integer getSizeType() {
		return sizeType;
	}

	public void setSizeType(Integer sizeType) {
		this.sizeType = sizeType;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="download_order_id")
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Transient
	public String getImgViewPath() {
		return imgViewPath;
	}

	public void setImgViewPath(String imgViewPath) {
		this.imgViewPath = imgViewPath;
	}
	
	@Transient
	public String getImgDownloadPath() {
		return imgDownloadPath;
	}

	public void setImgDownloadPath(String imgDownloadPath) {
		this.imgDownloadPath = imgDownloadPath;
	}

	@Transient
	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	
}