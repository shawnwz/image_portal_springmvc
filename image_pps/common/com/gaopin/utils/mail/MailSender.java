/* This file MailSender.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils.mail;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.gaopin.constants.Constants.MailType;
import com.gaopin.utils.PropertyReader;

public class MailSender {
	
	private String mailServerHost;
	private Integer port;
	//邮件发送者地址
	private String fromAddress;
	// 登陆邮件服务器用户名密码
	private String username;    
    private String password;  
    // 是否需要身份验证    
    private boolean validate = false;
    
    public MailSender(){
    	this.mailServerHost = PropertyReader.getString("mail.servername");
    	this.port = PropertyReader.getInt("mail.serverport",0);
    	this.fromAddress = PropertyReader.getString("mail.username");
    	this.username = PropertyReader.getString("mail.username");
    	this.password = PropertyReader.getString("mail.password");
    	this.validate = PropertyReader.getBoolean("mail.validate",true);
    }
    
    public boolean sendtMail(MailSenderInfo mailInfo,MailType type) throws Exception {   
	     MyAuthenticator authenticator = null;     
	     if (validate) {    
	       authenticator = new MyAuthenticator(username, password);    
	     }   
	     Session sendMailSession = Session.getDefaultInstance(getProperties(),authenticator);    
	     try {    
		     Message mailMessage = new MimeMessage(sendMailSession);    
		     Address from = new InternetAddress(this.fromAddress);    
		     mailMessage.setFrom(from);    
		     // 创建邮件的接收者地址，并设置到邮件消息中    
		     Address to = new InternetAddress(mailInfo.getToAddress());    
		     mailMessage.setRecipient(Message.RecipientType.TO,to);    
		     mailMessage.setSubject(mailInfo.getSubject());     
		     mailMessage.setSentDate(new Date());      
			String mailContent = mailInfo.getContent(); 
			
//			if(mailInfo.getAttachFileNames()==null||mailInfo.getAttachFileNames().length==0)
//			{
//				Multipart multipart = new MimeMultipart();
//			}
//			
		     if(type == MailType.HTML){  
		    	 Multipart mainPart = new MimeMultipart();    
			     // 创建一个包含HTML内容的MimeBodyPart    
			     BodyPart html = new MimeBodyPart(); 
			     html.setContent(mailInfo.getContent(), "text/html; charset=UTF-8");
			     mainPart.addBodyPart(html);   
			     if(mailInfo.getAttachFileNames()!=null&&mailInfo.getAttachFileNames().length>0)
			     {
			    	 String[] afiles=mailInfo.getAttachFileNames();
			    	 for (String file : afiles) {
			    		 	BodyPart attachmentBodyPart = new MimeBodyPart();
			    		 	File attachment=new File(file);
			                DataSource source = new FileDataSource(attachment);
			                attachmentBodyPart.setDataHandler(new DataHandler(source));
			                // 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
			                // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
			                //sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
			                //messageBodyPart.setFileName("=?GBK?B?" + enc.encode(attachment.getName().getBytes()) + "?=");
			                //MimeUtility.encodeWord可以避免文件名乱码
			                attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
			                mainPart.addBodyPart(attachmentBodyPart);
			    	 }
			     }
			     // 将MiniMultipart对象设置为邮件内容    
			     mailMessage.setContent(mainPart);    
		     }else{
		    	 mailMessage.setText(mailContent);
		     }
		     
		     if(mailInfo!=null&&mailInfo.getCCTo()!=null){//如果有抄送地址 那么就设置
		    	 mailMessage.setRecipient(Message.RecipientType.CC, new InternetAddress(mailInfo.getCCTo()));
		     }
		     // 发送邮件    
		     Transport.send(mailMessage);   
		     return true;    
	     } catch (MessagingException ex) {    
	         ex.printStackTrace();    
	     }    
	     return false;    
    }
    
    public boolean sendtMail1(MailSenderInfo mailInfo,MailType type,boolean cs) throws Exception {   
	     MyAuthenticator authenticator = null;     
	     if (validate) {    
	       authenticator = new MyAuthenticator(username, password);    
	     }   
	     Session sendMailSession = Session.getDefaultInstance(getProperties(),authenticator);    
	     try {    
		     Message mailMessage = new MimeMessage(sendMailSession);    
		     Address from = new InternetAddress(this.fromAddress);    
		     mailMessage.setFrom(from);    
		     // 创建邮件的接收者地址，并设置到邮件消息中    
		     Address to = new InternetAddress(mailInfo.getToAddress());    
		     mailMessage.setRecipient(Message.RecipientType.TO,to);    
		     mailMessage.setSubject(mailInfo.getSubject());     
		     mailMessage.setSentDate(new Date());      
		     if (cs) {
				
			}
		     
			String mailContent = mailInfo.getContent(); 
		     if(type == MailType.HTML){  
		    	 Multipart mainPart = new MimeMultipart();    
			     // 创建一个包含HTML内容的MimeBodyPart    
			     BodyPart html = new MimeBodyPart(); 
			     html.setContent(mailInfo.getContent(), "text/html; charset=UTF-8");
			     mainPart.addBodyPart(html);    
			     if(mailInfo.getAttachFileNames()==null||mailInfo.getAttachFileNames().length==0)
			     {
			    	 String[] afiles=mailInfo.getAttachFileNames();
			    	 for (String file : afiles) {
			    		 	BodyPart attachmentBodyPart = new MimeBodyPart();
			    		 	File attachment=new File(file);
			                DataSource source = new FileDataSource(attachment);
			                attachmentBodyPart.setDataHandler(new DataHandler(source));
			                // 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
			                // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
			                //sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
			                //messageBodyPart.setFileName("=?GBK?B?" + enc.encode(attachment.getName().getBytes()) + "?=");
			                //MimeUtility.encodeWord可以避免文件名乱码
			                attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
			                mainPart.addBodyPart(attachmentBodyPart);
			    	 }
			     }
			     // 将MiniMultipart对象设置为邮件内容    
			     mailMessage.setContent(mainPart);    
		     }else{
		    	 mailMessage.setText(mailContent);
		     }
		     // 发送邮件    
		     Transport.send(mailMessage);   
		     return true;    
	     } catch (MessagingException ex) {    
	         ex.printStackTrace();    
	     }    
	     return false;    
   }
    
   private  class MyAuthenticator extends Authenticator{   
 	   String username=null;   
 	   String password=null;   
 	        
// 	    public MyAuthenticator(){   
// 	   }   
 	    public MyAuthenticator(String username, String password) {    
 	        this.username = username;    
 	        this.password = password;    
 	    }    
 	    protected PasswordAuthentication getPasswordAuthentication(){   
 	        return new PasswordAuthentication(username, password);   
 	   }   
 	}    
    
    private Properties getProperties(){    
	      Properties p = new Properties();    
	      p.put("mail.smtp.host", mailServerHost);    
	      p.put("mail.smtp.port", port);    
	      p.put("mail.smtp.auth", validate ? "true" : "false");    
	      return p;    
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setMailServerHost(String mailServerHost) {
		this.mailServerHost = mailServerHost;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}    
	
	public static void sendMail(String title,String body,String ... accepters) throws Exception{
		MailSender sender = new MailSender();
//		sender.fromAddress="redzhu1985@126.com";
//		//sender.mailServerHost="smtp.126.com";
//		sender.username="redzhu1985@126.com";
//		sender.validate = true;
//		sender.port=25;
		for (int i = 0; i < accepters.length; i++) {
			MailSenderInfo mailSenderInfo = new MailSenderInfo();
			mailSenderInfo.setContent(body);
			mailSenderInfo.setSubject(title);
			
			mailSenderInfo.setToAddress(accepters[i]);
			sender.sendtMail(mailSenderInfo, MailType.HTML);
		}
		
    }
	
	public static void sendMail(String title,String body,String[] accepters,String cc) throws Exception{
		MailSender sender = new MailSender();
//		sender.fromAddress="redzhu1985@126.com";
//		//sender.mailServerHost="smtp.126.com";
//		sender.username="redzhu1985@126.com";
//		sender.validate = true;
//		sender.port=25;
		MailSenderInfo mailSenderInfo = new MailSenderInfo();
		mailSenderInfo.setContent(body);
		mailSenderInfo.setSubject(title);
		mailSenderInfo.setCCTo(cc);
		for (int i = 0; i < accepters.length; i++) {
			mailSenderInfo.setToAddress(accepters[i]);
			sender.sendtMail(mailSenderInfo, MailType.HTML);
		}
		
		
    }
	
	public static void main(String args[]) throws Exception{
		//java -Djava.ext.dirs=lib -classpath ./classes com.gaopin.utils.mail.MailSender
		MailSender sender = new MailSender();
//		sender.fromAddress="redzhu1985@126.com";
//		//sender.mailServerHost="smtp.126.com";
//		sender.username="redzhu1985@126.com";
//		sender.validate = true;
//		sender.port=25;
		MailSenderInfo mailSenderInfo = new MailSenderInfo();
		mailSenderInfo.setContent("邮件测试邮件测试邮件测试邮件测试邮件测试邮件测试邮件测试邮件测试");
		mailSenderInfo.setSubject("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		mailSenderInfo.setToAddress("27038337@qq.com");
		sender.sendtMail(mailSenderInfo, MailType.HTML);
	}

}
