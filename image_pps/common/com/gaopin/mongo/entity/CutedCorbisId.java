/* This file CutedCorbisId.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cuteCorbisId")
public class CutedCorbisId implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7274187146873541778L;
	
	@Id
	private String _id;
	private String corbisId;
	private String name;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCorbisId() {
		return corbisId;
	}
	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CutedCorbisId [_id=" + _id + ", corbisId=" + corbisId
				+ ", name=" + name + "]";
	}
	
}
