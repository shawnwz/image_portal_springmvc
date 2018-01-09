/* This file ImageGroupImage.java is part of image_pps .
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
 * FrClarification entity. @author MyEclipse Persistence Tools
 */
@Entity
/*@Table(name = "fr_imagegroup_image", catalog = "gaopin_images")*/
@Table(name = "fr_imagegroup_image")
public class ImageGroupImage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer imageGroupId;
	private String imageId;
	

	// Constructors

	/** default constructor */
	public ImageGroupImage() {
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

	@Column(name = "image_group_id", length = 32)
	public Integer getImageGroupId() {
		return this.imageGroupId;
	}

	public void setImageGroupId(Integer imageGroupId) {
		this.imageGroupId = imageGroupId;
	}

	@Column(name = "image_id", length = 32)
	public String getImageId() {
		return this.imageId;
	}

	public void setImageId(String imageid) {
		this.imageId = imageid;
	}
	
	 
}