/* This file ImageInfoExtend.java is part of image_pps .
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
 * FrImageInfoExtend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_image_info_extend")
public class ImageInfoExtend implements java.io.Serializable {

	// Fields

	private Long imageId;
	private String showKeyCh;
	private String iptc;

	// Constructors

	/** default constructor */
	public ImageInfoExtend() {
	}

	/** full constructor */
	public ImageInfoExtend(String showKeyCh) {
		this.showKeyCh = showKeyCh;
	}

	// Property accessors
	@Id
	@Column(name = "image_id", unique = true, nullable = false)
	public Long getImageId() {
		return this.imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	@Column(name = "show_key_ch")
	public String getShowKeyCh() {
		return this.showKeyCh;
	}

	public void setShowKeyCh(String showKeyCh) {
		this.showKeyCh = showKeyCh;
	}

	@Column(name = "iptc")
	public String getIptc() {
		return iptc;
	}

	public void setIptc(String iptc) {
		this.iptc = iptc;
	}

}