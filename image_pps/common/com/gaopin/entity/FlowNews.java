/* This file FlowNews.java is part of image_pps .
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

import com.gaopin.utils.DateUtil;
import com.gaopin.utils.DateUtils;

/**
 * FrFlowNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_flow_news")
public class FlowNews implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String label;
	private String content;
	private Integer num;
	private Integer flowSeq;
	private Date createTime;
	private Date updateTime;
	private Date publishTime;
	private String thumbBig;
	private String thumbMid;
	private String thumbSmall;
	private String intro;
	private String publishTimeStr10;
	private String publishTimeStr16;

	// Constructors

	/** default constructor */
	public FlowNews() {
	}

	/** full constructor */
	public FlowNews(String title, String label, String content, Integer num,
			Integer flowSeq, Date createTime, Date updateTime,
			Date publishTime, String thumbBig, String thumbMid,
			String thumbSmall, String intro) {
		this.title = title;
		this.label = label;
		this.content = content;
		this.num = num;
		this.flowSeq = flowSeq;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.publishTime = publishTime;
		this.thumbBig = thumbBig;
		this.thumbMid = thumbMid;
		this.thumbSmall = thumbSmall;
		this.intro = intro;
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

	@Column(name = "title", length = 300)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "label", length = 50)
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "content", length = 16777215)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "flow_seq")
	public Integer getFlowSeq() {
		return this.flowSeq;
	}

	public void setFlowSeq(Integer flowSeq) {
		this.flowSeq = flowSeq;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 19)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "publish_time", length = 19)
	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "thumb_big", length = 256)
	public String getThumbBig() {
		return this.thumbBig;
	}

	public void setThumbBig(String thumbBig) {
		this.thumbBig = thumbBig;
	}

	@Column(name = "thumb_mid", length = 256)
	public String getThumbMid() {
		return this.thumbMid;
	}

	public void setThumbMid(String thumbMid) {
		this.thumbMid = thumbMid;
	}

	@Column(name = "thumb_small", length = 256)
	public String getThumbSmall() {
		return this.thumbSmall;
	}

	public void setThumbSmall(String thumbSmall) {
		this.thumbSmall = thumbSmall;
	}

	@Column(name = "intro", length = 1024)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Transient
	public String getPublishTimeStr10() {
		return publishTimeStr10;//DateUtils.getDatestr(publishTime, DateUtils.ymdSdf);
	}

	public void setPublishTimeStr10(String publishTimeStr10) {
		this.publishTimeStr10 = publishTimeStr10;
	}
	@Transient
	public String getPublishTimeStr16() {
		return publishTimeStr16;//DateUtils.getDatestr(publishTime, DateUtils.ymdhmSdf);
	}

	public void setPublishTimeStr16(String publishTimeStr16) {
		this.publishTimeStr16 = publishTimeStr16;
	}

}