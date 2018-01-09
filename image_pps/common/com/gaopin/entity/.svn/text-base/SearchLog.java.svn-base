/* This file SearchLog.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.gaopin.utils.JsonFormat;

@Entity
@Table(name = "fr_search_log")
public class SearchLog implements java.io.Serializable{
	
	private Long id;
	private Integer userId;
	private String searchKey;
	private String searchData;
	private Date createTime;
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "search_key")
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
	@Column(name = "search_data")
	public String getSearchData() {
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}
	
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Transient
	public void addData(String key, Object value){
		map.put(key, value);
	}
	
	@Transient
	public void addData(Map<String, Object> map){
		this.map.putAll(map);
	}
	
	@Transient
	public void setData(){
		if(map!=null && map.size()>0){
			try{
				if(map.containsKey("search_words")){
					map.put("search_words", URLDecoder.decode((String)map.get("search_words"), "UTF-8"));
				}
				if(map.containsKey("fq")){
					map.put("fq", URLDecoder.decode((String)map.get("fq"), "UTF-8"));
				}
			}catch (Exception e) {
			}
			setSearchData(JsonFormat.toString(map));
		}
	}
}
