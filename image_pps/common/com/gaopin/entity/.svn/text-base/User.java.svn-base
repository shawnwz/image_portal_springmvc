/* This file User.java is part of image_pps .
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
 * FrUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_user")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String enName;
	private String userName;
	private String password;
	private String code;
	private Integer sex;
	private String email;
	private Integer status;
	private String registerSource;
	private String jobTitle;
	private Integer score;
	private String saleArea;
	private String contactsInfo;
	private Integer bobo;
	private Integer qp;
	private Integer od;
	private Integer outline;
	private Integer amId;
	private Integer asId;
	private Integer creator;
	private Integer modifier;
	private Date createTime;
	private Date updateTime;
	private String sapEx;
	private Integer logid;
	
	private Integer isByEmail;
	private Integer isTellNew;
	private Integer isTellNewProduct;
	
	@Column(name = "logid")
	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}
	private Integer sapid;
	

	//My Fields
	private String comName;
	private String comPhone;
	private String comAddress;
	
	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Integer customerId, String firstName, String lastName,
			String enName, String userName, String password, Integer sex,
			String email, Integer status, String registerSource,
			String jobTitle, Integer score, String saleArea,
			String contactsInfo, Integer bobo, Integer qp, Integer outline,
			Integer amId, Integer asId, Integer creator, Integer modifier,
			Date createTime, Date updateTime,String sapex,Integer sapid,Integer logid) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enName = enName;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.status = status;
		this.registerSource = registerSource;
		this.jobTitle = jobTitle;
		this.score = score;
		this.saleArea = saleArea;
		this.contactsInfo = contactsInfo;
		this.bobo = bobo;
		this.qp = qp;
		this.outline = outline;
		this.amId = amId;
		this.asId = asId;
		this.creator = creator;
		this.modifier = modifier;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sapEx=sapex;
		this.sapid=sapid;
		this.logid=logid;
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

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "first_name", length = 20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "en_name", length = 20)
	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "user_name", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Column(name = "code", length = 100)
	public String getCode() {
		return this.password;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "register_source", length = 10)
	public String getRegisterSource() {
		return this.registerSource;
	}

	public void setRegisterSource(String registerSource) {
		this.registerSource = registerSource;
	}

	@Column(name = "job_title", length = 100)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "sale_area", length = 30)
	public String getSaleArea() {
		return this.saleArea;
	}

	public void setSaleArea(String saleArea) {
		this.saleArea = saleArea;
	}

	@Column(name = "contacts_info", length = 4000)
	public String getContactsInfo() {
		return this.contactsInfo;
	}

	public void setContactsInfo(String contactsInfo) {
		this.contactsInfo = contactsInfo;
	}

	@Column(name = "bobo")
	public Integer getBobo() {
		return this.bobo;
	}

	public void setBobo(Integer bobo) {
		this.bobo = bobo;
	}
	
	@Column(name = "od")
	public Integer getOd() {
		return this.od;
	}

	public void setOd(Integer od) {
		this.od = od;
	}
	
	@Column(name = "qp")
	public Integer getQp() {
		return this.qp;
	}

	public void setQp(Integer qp) {
		this.qp = qp;
	}

	@Column(name = "outline")
	public Integer getOutline() {
		return this.outline;
	}

	public void setOutline(Integer outline) {
		this.outline = outline;
	}

	@Column(name = "am_id")
	public Integer getAmId() {
		return this.amId;
	}

	public void setAmId(Integer amId) {
		this.amId = amId;
	}

	@Column(name = "as_id")
	public Integer getAsId() {
		return this.asId;
	}

	public void setAsId(Integer asId) {
		this.asId = asId;
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

	//My fields's encapsulation
	@Transient
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
	@Transient
	public String getComPhone() {
		return comPhone;
	}

	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}
	
	@Transient
	public String getComAddress() {
		return comAddress;
	}

	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}
	
	


	@Column(name = "sapex", length = 4000)
	public String getSapEx() {
		return sapEx;
	}

	public void setSapEx(String sapEx) {
		this.sapEx = sapEx;
	}

	@Column(name = "sapid", length = 10)
	public Integer getSapid() {
		return sapid;
	}

	public void setSapid(Integer sapid) {
		this.sapid = sapid;
	}
	


	@Column(name = "is_by_email", length = 10)
	public Integer getIsByEmail() {
		return isByEmail;
	}
	public void setIsByEmail(Integer isByEmail) {
		this.isByEmail = isByEmail;
	}

	@Column(name = "is_tell_new", length = 10)
	public Integer getIsTellNew() {
		return isTellNew;
	}
	public void setIsTellNew(Integer isTellNew) {
		this.isTellNew = isTellNew;
	}

	@Column(name = "is_tell_newProduct", length = 10)
	public Integer getIsTellNewProduct() {
		return isTellNewProduct;
	}
	public void setIsTellNewProduct(Integer isTellNewProduct) {
		this.isTellNewProduct = isTellNewProduct;
	}

}