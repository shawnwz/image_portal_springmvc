/* This file VirtualCdRel.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FrVirtualCdRel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_virtual_cd_rel")
public class VirtualCdRel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer cdId;
	private Long imageId;

	// Constructors

	/** default constructor */
	public VirtualCdRel() {
	}

	/** full constructor */
	public VirtualCdRel(Integer cdId, Long imageId) {
		this.cdId = cdId;
		this.imageId = imageId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cd_id")
	public Integer getCdId() {
		return this.cdId;
	}

	public void setCdId(Integer cdId) {
		this.cdId = cdId;
	}

	@Column(name = "image_id")
	public Long getImageId() {
		return this.imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

}