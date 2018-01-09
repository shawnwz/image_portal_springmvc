/* This file SystemUser.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.gaopin.annotation.JerryFormBefore;

/**
 * SystemUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "system_user")
@JerryFormBefore("systemUserService")
public class SystemUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8210865173460404305L;
	private Integer id;
	private String realName;
	private String frUsername;
	private String enName;
	private String userName;
	private String password;
	private String email;
	private Integer status;
	private String jobTitle;
	private String filiale;
	private String department;
	private String mobileNo;
	private String telphone;
	private Integer userLevel;
	private Date loginTime;
	private Date createTime;
	private Date updateTime;

	//---后台访问权限
	private boolean isAdmin = false;
	private List<String> privileges = new ArrayList<String>();
	// Constructors

	/** default constructor */
	public SystemUser() {
	}

	/** full constructor */
	public SystemUser(String realName, String enName, String userName,
			String password, String email, Integer status, String jobTitle,
			String filiale, String department, String mobileNo,
			String telphone, Integer userLevel, Date loginTime,
			Date createTime, Date updateTime,String frUsername) {
		this.realName = realName;
		this.enName = enName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.status = status;
		this.jobTitle = jobTitle;
		this.filiale = filiale;
		this.department = department;
		this.mobileNo = mobileNo;
		this.telphone = telphone;
		this.userLevel = userLevel;
		this.loginTime = loginTime;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.frUsername=frUsername;
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
	@Column(name = "fr_username", length = 100)
	public String getFrUsername() {
		return this.frUsername;
	}

	public void setFrUsername(String frUsername) {
		this.frUsername = frUsername;
	}
	@Column(name = "real_name", length = 20)
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	@Column(name = "password", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Column(name = "job_title", length = 100)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "filiale", length = 30)
	public String getFiliale() {
		return this.filiale;
	}

	public void setFiliale(String filiale) {
		this.filiale = filiale;
	}

	@Column(name = "department", length = 20)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "mobile_no", length = 20)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "telphone", length = 30)
	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "user_level")
	public Integer getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	@Column(name = "login_time", length = 0)
	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
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

	@Transient
	public String  getNameTest() {
		return null;
	}
	
	@Transient
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Transient
	public List<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<String> privileges) {
		this.privileges = privileges;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}