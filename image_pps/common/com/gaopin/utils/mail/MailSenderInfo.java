/* This file MailSenderInfo.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils.mail;

public class MailSenderInfo {
	
		//接收地址
		private String toAddress;
		//邮件主题
	 	private String subject;    
	    // 邮件的文本内容    
	    private String content;    
	    // 邮件附件的文件名    
	    private String[] attachFileNames;
	    //抄送地址
	    private String CCTo;  
	    
	    
		public String[] getAttachFileNames() {
			return attachFileNames;
		}
		public void setAttachFileNames(String[] attachFileNames) {
			this.attachFileNames = attachFileNames;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getToAddress() {
			return toAddress;
		}
		public void setToAddress(String toAddress) {
			this.toAddress = toAddress;
		}
		public String getCCTo() {
			return CCTo;
		}
		public void setCCTo(String cCTo) {
			CCTo = cCTo;
		} 
	    
	    
	    
}
