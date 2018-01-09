/* This file EmailLog.java is part of image_pps .
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
 * FrEmailLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_email_log")
public class EmailLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private String to;
	private String cc;
	private String title;
	private String content;
	private Date createTime;
	private String attchments;

	// Constructors

	/** default constructor */
	public EmailLog() {
	}

	/** full constructor */
	public EmailLog(String type,String to, String cc, String title, String content,
			Date createTime, String attchments) {
		this.type=type;
		this.to = to;
		this.cc = cc;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.attchments = attchments;
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

	@Column(name = "type", length = 32)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Column(name = "mailto", length = 256)
	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Column(name = "cc", length = 256)
	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Column(name = "title", length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 16777215)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "attchments", length = 1024)
	public String getAttchments() {
		return this.attchments;
	}

	public void setAttchments(String attchments) {
		this.attchments = attchments;
	}

}