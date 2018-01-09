/* This file ImagePartialSets.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * FrImageGroup entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "fr_image_partial_set")
public class ImagePartialSets implements java.io.Serializable {

	// Fields
	private Integer id; 
	private String title;
	private String intro;  
	private String indexImages;
	private String indexImagePaths;
	private String imageGroupId;
	private Integer templateType; 
	private Date createTime;
	private Date updateTime; 
	
	private String imageCreditline;
	
	
	private List<PreviewImageInfo> indexImageslist;
	private List<ImageGroup> imageGroupslist;
	@Transient
	public String getImageCreditline() {
		return imageCreditline;
	}


	public void setImageCreditline(String imageCreditline) {
		this.imageCreditline = imageCreditline;
	}
	@Transient
	public List<PreviewImageInfo> getIndexImageslist() {
		return indexImageslist;
	}


	public void setIndexImageslist(List<PreviewImageInfo> indexImageslist) {
		this.indexImageslist = indexImageslist;
	}

	@Transient
	public List<ImageGroup> getImageGroupslist() {
		return imageGroupslist;
	}


	public void setImageGroupslist(List<ImageGroup> imageGroupslist) {
		this.imageGroupslist = imageGroupslist;
	}


	/** default constructor */
	public ImagePartialSets() {
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
  
	@Column(name = "intro", length = 1000)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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
 
	@Column(name = "title", length = 20)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
   
	@Column(name = "index_images", length = 2000)
	public String getIndexImages() {
		return indexImages;
	} 
	public void setIndexImages(String indexImages) {
		this.indexImages = indexImages;
	} 
	
	@Column(name = "index_image_paths", length = 2048)
	public String getIndexImagePaths() {
		return indexImagePaths;
	} 
	public void setIndexImagePaths(String indexImagePaths) {
		this.indexImagePaths = indexImagePaths;
	}

	@Column(name = "image_group_id", length = 1000)
	public String getImageGroupId() {
		return imageGroupId;
	} 
	public void setImageGroupId(String imageGroupId) {
		this.imageGroupId = imageGroupId;
	}

	@Column(name = "template_type")
	public Integer getTemplateType() {
		return templateType;
	} 
	public void setTemplateType(Integer templateType) {
		this.templateType = templateType;
	}


}