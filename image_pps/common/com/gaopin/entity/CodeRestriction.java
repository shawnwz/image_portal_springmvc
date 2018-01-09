/* This file CodeRestriction.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "code_restriction")
public class CodeRestriction implements java.io.Serializable{
	
	private Integer restrictionid;
	private String restrictionnotice;
	private String chinese;
	
	@Id
	@Column(name = "restrictionid", unique = true, nullable = false)
	public Integer getRestrictionid() {
		return restrictionid;
	}
	public void setRestrictionid(Integer restrictionid) {
		this.restrictionid = restrictionid;
	}
	
	@Column(name = "restrictionnotice")
	public String getRestrictionnotice() {
		return restrictionnotice;
	}
	public void setRestrictionnotice(String restrictionnotice) {
		this.restrictionnotice = restrictionnotice;
	}
	
	@Column(name = "chinese")
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	
}
