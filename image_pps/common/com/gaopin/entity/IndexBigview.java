/* This file IndexBigview.java is part of image_pps .
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FrIndexBigview entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_index_bigview")
public class IndexBigview implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private String memo;
	private String path;
	private String gaopinId;
	private Integer seq;
	private Integer status;
	private Date createTime;
	private Date updateTime; 
	private String linkName;
	private String link;

	// Constructors

	/** default constructor */
	public IndexBigview() {
	}

	/** full constructor */
	public IndexBigview(Integer type, String memo, String path, Integer seq,
			Integer status, Date createTime, Date updateTime,String gaopinId ) {
		this.type = type;
		this.memo = memo;
		this.path = path;
		this.seq = seq;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime; 
		this.gaopinId=gaopinId;
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
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "memo", length = 1000)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "path", length = 256)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "seq")
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", length = 10)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "gaopin_id", length = 100)
	public String getGaopinId() {
		return gaopinId;
	}

	public void setGaopinId(String gaopinId) {
		this.gaopinId = gaopinId;
	}


	@Column(name = "link_name", length = 32)
	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	@Column(name = "link", length = 256)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}