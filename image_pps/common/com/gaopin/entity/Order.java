/* This file Order.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FrOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_order")
public class Order implements java.io.Serializable {

	// Fields

	private Integer id;
	private String orderId;
	private String userName;
	private String operator;
	private String porjectName;
	private Date operateTime;
	private String orderContact;
	private Date confrimTime;
	private String workNo;
	private Date changeTime;
	private String po;
	private Date billingTime;
	private String beneficiary;
	private Date upadteTime;
	private String invoiceType;
	private String orderState;
	private String invoiceNo;
	private String money;
	private String remark;
	private String chargeMoney;
	private String taxRate;
	private String picinfo;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String orderId, String userName, String operator,
			String porjectName, Timestamp operateTime, String orderContact,
			Timestamp confrimTime, String workNo, Timestamp changeTime,
			String po, Timestamp billingTime, String beneficiary,
			Timestamp upadteTime, String invoiceType, String orderState,
			String invoiceNo, String money, String remark, String chargeMoney,
			String taxRate, String picinfo) {
		this.orderId = orderId;
		this.userName = userName;
		this.operator = operator;
		this.porjectName = porjectName;
		this.operateTime = operateTime;
		this.orderContact = orderContact;
		this.confrimTime = confrimTime;
		this.workNo = workNo;
		this.changeTime = changeTime;
		this.po = po;
		this.billingTime = billingTime;
		this.beneficiary = beneficiary;
		this.upadteTime = upadteTime;
		this.invoiceType = invoiceType;
		this.orderState = orderState;
		this.invoiceNo = invoiceNo;
		this.money = money;
		this.remark = remark;
		this.chargeMoney = chargeMoney;
		this.taxRate = taxRate;
		this.picinfo = picinfo;
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

	@Column(name = "order_id", length = 32)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "user_name", length = 32)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "operator", length = 32)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "porject_name", length = 32)
	public String getPorjectName() {
		return this.porjectName;
	}

	public void setPorjectName(String porjectName) {
		this.porjectName = porjectName;
	}

	@Column(name = "operate_time", length = 19)
	public Date getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	@Column(name = "order_contact", length = 32)
	public String getOrderContact() {
		return this.orderContact;
	}

	public void setOrderContact(String orderContact) {
		this.orderContact = orderContact;
	}

	@Column(name = "confrim_time", length = 19)
	public Date getConfrimTime() {
		return this.confrimTime;
	}

	public void setConfrimTime(Date confrimTime) {
		this.confrimTime = confrimTime;
	}

	@Column(name = "work_no", length = 32)
	public String getWorkNo() {
		return this.workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	@Column(name = "change_time", length = 19)
	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "po", length = 32)
	public String getPo() {
		return this.po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	@Column(name = "billing_time", length = 19)
	public Date getBillingTime() {
		return this.billingTime;
	}

	public void setBillingTime(Date billingTime) {
		this.billingTime = billingTime;
	}

	@Column(name = "beneficiary", length = 32)
	public String getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	@Column(name = "upadte_time", length = 19)
	public Date getUpadteTime() {
		return this.upadteTime;
	}

	public void setUpadteTime(Date upadteTime) {
		this.upadteTime = upadteTime;
	}

	@Column(name = "invoice_type", length = 16)
	public String getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	@Column(name = "order_state", length = 16)
	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	@Column(name = "invoice_no", length = 32)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "money", length = 16)
	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Column(name = "remark", length = 256)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "charge_money", length = 16)
	public String getChargeMoney() {
		return this.chargeMoney;
	}

	public void setChargeMoney(String chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	@Column(name = "tax_rate", length = 16)
	public String getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	@Column(name = "picinfo", length = 65535)
	public String getPicinfo() {
		return this.picinfo;
	}

	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}

}