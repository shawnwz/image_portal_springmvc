/* This file OrderDetailReportItem.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;



public class OrderDetailReportItem  implements java.io.Serializable 
{
	private String orderDate;
	private String custormName;
	private String userName;
	private Integer orderNumber;
	private String corbisId;
	private String productName;
	private String photographer;
	private String productSize;
	private String contentType;
	private String priceTier;
	private String collecton;
	private String userLoginName;
	
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustormName() {
		return custormName;
	}
	public void setCustormName(String custormName) {
		this.custormName = custormName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCorbisId() {
		return corbisId;
	}
	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getPriceTier() {
		return priceTier;
	}
	public void setPriceTier(String priceTier) {
		this.priceTier = priceTier;
	}
	public String getCollecton() {
		return collecton;
	}
	public void setCollecton(String collecton) {
		this.collecton = collecton;
	} 
	
}