/* This file FinanceInfo.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.io.Serializable;

/**
 * 财务信息
 * @author xcb
 *
 */
public class FinanceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5050941137009856506L;
	
	private String financeName;
	private String financePhone;
	private String invoiceType;
	private String payType;
	private String payer;
	public String getFinanceName() {
		return financeName;
	}
	public void setFinanceName(String financeName) {
		this.financeName = financeName;
	}
	public String getFinancePhone() {
		return financePhone;
	}
	public void setFinancePhone(String financePhone) {
		this.financePhone = financePhone;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
