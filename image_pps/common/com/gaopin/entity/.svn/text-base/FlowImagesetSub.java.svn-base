/* This file FlowImagesetSub.java is part of image_pps .
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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * FrFlowImagesetSub entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_flow_imageset_sub")
public class FlowImagesetSub implements java.io.Serializable {

	// Fields
	private Integer id;
	private Integer imagesetId;
	private String name;
	private String info;
	private Integer num;
	private Integer seq;
	private String src;
	private String imageSetSrc;
	private String imgList;
	private String imagesetName;
	private String statusName;
	private Integer status;

	private String style;
	private Date createTime;
	private Date updateTime;
	
	@Column(name = "style")
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	// Constructors

	/** default constructor */
	public FlowImagesetSub() {
	}

	/** full constructor */
	public FlowImagesetSub(Integer imagesetId, String name, String info,String imageSetSrc,
			Integer num,Integer status, Integer seq, String src, String imgList,String imagesetName,String statusName) {
		this.imagesetId = imagesetId;
		this.name = name;
		this.info = info;
		this.num = num;
		this.seq = seq;
		this.src = src;
		this.imgList = imgList;
		this.imagesetName=imagesetName;
		this.status = status;
		this.statusName=statusName;
		this.imageSetSrc=imageSetSrc;
	}
	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Transient
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Column(name = "image_set_src")
	public String getImageSetSrc() {
		return imageSetSrc;
	}

	public void setImageSetSrc(String imageSetSrc) {
		this.imageSetSrc = imageSetSrc;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	@Transient
	public String getImagesetName() {
		return imagesetName;
	}

	public void setImagesetName(String imagesetName) {
		this.imagesetName = imagesetName;
	}

	@Column(name = "imageset_id")
	public Integer getImagesetId() {
		return this.imagesetId;
	}

	public void setImagesetId(Integer imagesetId) {
		this.imagesetId = imagesetId;
	}
	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "info")
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	@Column(name = "seq")
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	@Column(name = "src")
	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	@Column(name = "img_list")
	public String getImgList() {
		return this.imgList;
	}

	public void setImgList(String imgList) {
		this.imgList = imgList;
	}

}