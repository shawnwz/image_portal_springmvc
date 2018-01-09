/* This file Customer.java is part of image_pps .
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

import com.gaopin.utils.JsonFormat;

/**
 * FrCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fr_customer")
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8841938998018596446L;
	private Integer id;
	private String name;
	private String parentCompany;
	private String industryType;
	private String industryProperty;
	private Integer level;
	private String memo;
	private String saleArea;
	private Integer status;
	private Integer amId;
	private Integer asId;
	private Integer balance;
	private String financeInfo;
	private String billInfo;
	private String contactsInfo;
	private Integer onDemand;
	
	private Integer credit;
	private Integer creator;
	private Integer modifier;
	private Date createTime;
	private Date updateTime;
	
	private String sapEx;
	private Integer logid;
	@Column(name = "logid")
	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	private Integer sapid;
	
	//@Transient
	private ContactsInfo contactsObj;
	private FinanceInfo financeObj;
	private BillInfo billObj;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String name, String parentCompany, String industryType,
			String industryProperty, Integer level, String memo,
			String saleArea, Integer status, Integer amId, Integer asId,
			String financeInfo, String billInfo, String contactsInfo,
			Integer credit, Integer creator, Integer modifier,
			Date createTime, Date updateTime,String sapex,Integer sapid,Integer logid) {
		this.name = name;
		this.parentCompany = parentCompany;
		this.industryType = industryType;
		this.industryProperty = industryProperty;
		this.level = level;
		this.memo = memo;
		this.saleArea = saleArea;
		this.status = status;
		this.amId = amId;
		this.asId = asId;
		this.financeInfo = financeInfo;
		this.billInfo = billInfo;
		this.contactsInfo = contactsInfo;
		this.credit = credit;
		this.creator = creator;
		this.modifier = modifier;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.sapEx=sapex;
		this.sapid=sapid;
		this.logid=logid;
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
	@Column(name = "on_demand")
	public Integer getOnDemand() {
		return onDemand;
	}

	public void setOnDemand(Integer onDemand) {
		this.onDemand = onDemand;
	}
	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parent_company", length = 200)
	public String getParentCompany() {
		return this.parentCompany;
	}

	public void setParentCompany(String parentCompany) {
		this.parentCompany = parentCompany;
	}

	@Column(name = "industry_type", length = 100)
	public String getIndustryType() {
		return this.industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	@Column(name = "industry_property", length = 100)
	public String getIndustryProperty() {
		return this.industryProperty;
	}

	public void setIndustryProperty(String industryProperty) {
		this.industryProperty = industryProperty;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "memo", length = 4000)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "sale_area", length = 30)
	public String getSaleArea() {
		return this.saleArea;
	}

	public void setSaleArea(String saleArea) {
		this.saleArea = saleArea;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "am_id")
	public Integer getAmId() {
		return this.amId;
	}

	public void setAmId(Integer amId) {
		this.amId = amId;
	}

	@Column(name = "as_id")
	public Integer getAsId() {
		return this.asId;
	}

	public void setAsId(Integer asId) {
		this.asId = asId;
	}

	@Column(name = "balance")
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Column(name = "finance_info", length = 2000)
	public String getFinanceInfo() {
		return this.financeInfo;
	}

	public void setFinanceInfo(String financeInfo) {
		this.financeInfo = financeInfo;
	}

	@Column(name = "bill_info", length = 2000)
	public String getBillInfo() {
		return this.billInfo;
	}

	public void setBillInfo(String billInfo) {
		this.billInfo = billInfo;
	}

	@Column(name = "contacts_info", length = 4000)
	public String getContactsInfo() {
		return this.contactsInfo;
	}

	public void setContactsInfo(String contactsInfo) {
		this.contactsInfo = contactsInfo;
	}

	@Column(name = "credit")
	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Column(name = "creator")
	public Integer getCreator() {
		return this.creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	@Column(name = "modifier")
	public Integer getModifier() {
		return this.modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
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

	//----------------------------
	@Transient
	public ContactsInfo getContactsObj() {
		try{
			if(contactsObj==null && contactsInfo!=null){
				contactsObj = JsonFormat.toObject(contactsInfo, ContactsInfo.class);
			}
		}
		catch (Exception e) {
		}
		return contactsObj;
	}
	public void setContactsObj(ContactsInfo contactsObj) {
		this.contactsObj = contactsObj;
		if(contactsObj!=null){
			contactsInfo = JsonFormat.toString(contactsObj);
		}
	}
	
	@Transient
	public FinanceInfo getFinanceObj() {
		try{
			if(financeObj==null && financeInfo!=null){
				financeObj = JsonFormat.toObject(financeInfo, FinanceInfo.class);
			}
		}
		catch (Exception e) {
		}
		return financeObj;
	}
	public void setFinanceObj(FinanceInfo financeObj) {
		this.financeObj = financeObj;
		if(financeObj!=null){
			financeInfo = JsonFormat.toString(financeObj);
		}
	}
	
	@Transient
	public BillInfo getBillObj() {
		try{
			if(billObj==null && billInfo!=null){
				billObj = JsonFormat.toObject(billInfo, BillInfo.class);
			}
		}
		catch (Exception e) {
		}
		return billObj;
	}
	public void setBillObj(BillInfo billObj) {
		this.billObj = billObj;
		if(billObj!=null){
			billInfo = JsonFormat.toString(billObj);
		}
	}


	@Column(name = "sapex", length = 4000)
	public String getSapEx() {
		return sapEx;
	}

	public void setSapEx(String sapEx) {
		this.sapEx = sapEx;
	}


	@Column(name = "sapid", length = 10)
	public Integer getSapid() {
		return sapid;
	}

	public void setSapid(Integer sapid) {
		this.sapid = sapid;
	}
	

}