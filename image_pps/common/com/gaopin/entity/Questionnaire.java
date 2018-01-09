/* This file Questionnaire.java is part of image_pps .
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
 * FrQuestionnaire entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_questionnaire")
public class Questionnaire implements java.io.Serializable {

	// Fields

	private Integer id;
	private Date crateTime;
	private Date updateTime;
	private String cookieId;
	private Integer userId;
	private String ip;
	private String ua;
	private String outEmails;
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String a5;
	private String a6;
	private String a7;
	private String a8;
	private String a9;
	private String a10;
	private String a11;
	private String a12;
	private String a13;
	private String a14;
	private String a15;
	private String a16;

	// Constructors

	/** default constructor */
	public Questionnaire() {
	}

	/** full constructor */
	public Questionnaire(Date crateTime, Date updateTime, String cookieId,
			Integer userId, String ip, String ua, String outEmails, String a1,
			String a2, String a3, String a4, String a5, String a6, String a7,
			String a8, String a9, String a10, String a11, String a12,
			String a13, String a14, String a15, String a16) {
		this.crateTime = crateTime;
		this.updateTime = updateTime;
		this.cookieId = cookieId;
		this.userId = userId;
		this.ip = ip;
		this.ua = ua;
		this.outEmails = outEmails;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.a5 = a5;
		this.a6 = a6;
		this.a7 = a7;
		this.a8 = a8;
		this.a9 = a9;
		this.a10 = a10;
		this.a11 = a11;
		this.a12 = a12;
		this.a13 = a13;
		this.a14 = a14;
		this.a15 = a15;
		this.a16 = a16;
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

	@Column(name = "crate_time", length = 19)
	public Date getCrateTime() {
		return this.crateTime;
	}

	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}

	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "cookie_id", length = 128)
	public String getCookieId() {
		return this.cookieId;
	}

	public void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "ip", length = 32)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "ua", length = 1024)
	public String getUa() {
		return this.ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	@Column(name = "out_emails", length = 1024)
	public String getOutEmails() {
		return this.outEmails;
	}

	public void setOutEmails(String outEmails) {
		this.outEmails = outEmails;
	}

	@Column(name = "a1", length = 1024)
	public String getA1() {
		return this.a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	@Column(name = "a2", length = 1024)
	public String getA2() {
		return this.a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	@Column(name = "a3", length = 1024)
	public String getA3() {
		return this.a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	@Column(name = "a4", length = 1024)
	public String getA4() {
		return this.a4;
	}

	public void setA4(String a4) {
		this.a4 = a4;
	}

	@Column(name = "a5", length = 1024)
	public String getA5() {
		return this.a5;
	}

	public void setA5(String a5) {
		this.a5 = a5;
	}

	@Column(name = "a6", length = 1024)
	public String getA6() {
		return this.a6;
	}

	public void setA6(String a6) {
		this.a6 = a6;
	}

	@Column(name = "a7", length = 1024)
	public String getA7() {
		return this.a7;
	}

	public void setA7(String a7) {
		this.a7 = a7;
	}

	@Column(name = "a8", length = 1024)
	public String getA8() {
		return this.a8;
	}

	public void setA8(String a8) {
		this.a8 = a8;
	}

	@Column(name = "a9", length = 1024)
	public String getA9() {
		return this.a9;
	}

	public void setA9(String a9) {
		this.a9 = a9;
	}

	@Column(name = "a10", length = 1024)
	public String getA10() {
		return this.a10;
	}

	public void setA10(String a10) {
		this.a10 = a10;
	}

	@Column(name = "a11", length = 1024)
	public String getA11() {
		return this.a11;
	}

	public void setA11(String a11) {
		this.a11 = a11;
	}

	@Column(name = "a12", length = 1024)
	public String getA12() {
		return this.a12;
	}

	public void setA12(String a12) {
		this.a12 = a12;
	}

	@Column(name = "a13", length = 1024)
	public String getA13() {
		return this.a13;
	}

	public void setA13(String a13) {
		this.a13 = a13;
	}

	@Column(name = "a14", length = 1024)
	public String getA14() {
		return this.a14;
	}

	public void setA14(String a14) {
		this.a14 = a14;
	}

	@Column(name = "a15", length = 1024)
	public String getA15() {
		return this.a15;
	}

	public void setA15(String a15) {
		this.a15 = a15;
	}

	@Column(name = "a16", length = 1024)
	public String getA16() {
		return this.a16;
	}

	public void setA16(String a16) {
		this.a16 = a16;
	}

}