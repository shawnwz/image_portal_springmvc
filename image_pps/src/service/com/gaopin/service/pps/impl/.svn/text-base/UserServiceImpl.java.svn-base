/* This file UserServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.gaopin.constants.Constants;
import com.gaopin.constants.Constants.CommonStatus;
import com.gaopin.constants.Constants.MailType;
import com.gaopin.entity.BasicReportItem;
import com.gaopin.entity.DownloadHistory;
import com.gaopin.entity.DownloadOrder;
import com.gaopin.entity.SystemVariables;
import com.gaopin.entity.User;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.BaseService;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.UserService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.DateUtil;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.JsonFormat;
import com.gaopin.utils.MD5;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.mail.MailSender;
import com.gaopin.utils.mail.MailSenderInfo;

/**前台用户服务
 * @author 高顺德
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Resource
	VariablesService variablesService;
	@Override
	public Serializable saveObject(Object entity) {
		
		// TODO Auto-generated method stub
		User user=(User)entity;
		if(null!=entity){//因为用email字段代替登陆名  所以这时候判断的是email
			
			if(StrUtils.isEmpty(user.getUserName()))
			{
				user.setUserName(user.getEmail());
			}
			
			if(isExistUserName(user.getUserName())||isExistEmail(user.getEmail())){
				return null;
			}
			user.setStatus(CommonStatus.ENABLE.ordinal());
			 super.saveObject(user);
			 try{
					logger.info("user"+JsonFormat.toString(user));
				}catch (Exception e) {
					e.printStackTrace();
				}
			 
			 return user.getId();
		}
		return null;
	}

	@Override
	public User loginUser(Object entity) {
		// TODO Auto-generated method stub
		User user=(User)entity;
		if(null!=entity&&null!=user.getUserName()){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("userName", user.getUserName(), CompareType.Equal));
			coll.add(new CompareExpression("password", user.getPassword(), CompareType.Equal));
			List<User> list=controller.findBy(User.class,coll);
			if(list.size()>0)
				return list.get(0);
		}
		return null;
	}
	public boolean isExist(String name)//,String email
	{
		return isExistUserName(name);
		
		
		}
	
	public boolean isExistUserName(String loginName){
		if(null!=loginName&&loginName.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("userName", loginName, CompareType.Equal));
			List<User> list=controller.findBy(User.class,coll);
			if(list.size()>0)
			{
				return true;
			}
			else {

				coll=new ArrayList<HibernateExpression>();
				coll.add(new CompareExpression("email", loginName, CompareType.Equal));
				list=controller.findBy(User.class,coll);
				if(list.size()>0)
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean isExistEmail(String email){
		if(null!=email&&email.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("email", email, CompareType.Equal));
			List<User> list=controller.findBy(User.class,coll);
			if(list.size()>0)
				return true;
		}
		return false;
	}
	@Override
	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		if(null!=loginName&&loginName.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("userName", loginName, CompareType.Equal));
			coll.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
			List<User> list=controller.findBy(User.class,coll);
			if(list.size()>0)
			{
				return list.get(0);
			}
			else {
				coll=new ArrayList<HibernateExpression>();
				coll.add(new CompareExpression("email", loginName, CompareType.Equal));
				coll.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
				list=controller.findBy(User.class,coll);
				if(list.size()>0)
				{
					return list.get(0);
				}
			}
		}
		return null;
	}

	@Override
	public User getUserByLoginEmail(String loginEmail) {
		// TODO Auto-generated method stub
		if(null!=loginEmail&&loginEmail.length()>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("email", loginEmail, CompareType.Equal));
			coll.add(new CompareExpression("status", Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
			List<User> list=controller.findBy(User.class,coll);
			if(list.size()>0)
				return list.get(0);
		}
		return null;
	}
	@Override
	public List<DownloadHistory> getDownLoadIMG(Integer id) {
		// TODO Auto-generated method stub
		if(id>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("userId", id, CompareType.Equal));
			List<DownloadHistory> list=controller.findBy(DownloadHistory.class,coll);
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DownloadHistory> getDownLoadIMG(int userId,int pageNo,int pageSize,int type) {
		// TODO Auto-generated method stub
		if(userId>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("userId", userId, CompareType.Equal));
			coll.add(new CompareExpression("type", type, CompareType.Equal));
			//List<DownloadHistory> list=controller.findBy(DownloadHistory.class,pageNo,pageSize,coll);
			List<DownloadHistory> list=controller.findBy(DownloadHistory.class, pageNo, pageSize, "createTime", false, coll);
			return list;
		}
		return null;
	}
	
	@Override
	public long getPageCount(int userId,int pageNo,int pageSize){
		if(userId>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("userId", userId, CompareType.Equal));
			long entityCount=controller.getResultCount(DownloadHistory.class, coll);
			return entityCount%pageSize==0?entityCount/pageSize:entityCount/pageSize+1;
		}
		return 0;
	}
	
	@Override
	public User ResetPasswordAndSendmail(Integer userid) {
		User user=controller.get(User.class, userid);
		String code="";
		if(user!=null)
		{
			code=MD5.getMd5Str(new Date().toString()+user.getId()+user.getUserName()).substring(1,10).toUpperCase();
			user.setPassword(MD5.getMd5Str(user.getId()+MD5.getMd5Str(code)));
			logger.info("reset password"+user.getUserName()+code);
			user.setUpdateTime(new Date());
			controller.update(user);
		}
		
		final User u=user;
		final String c=code;
		//sned mail 
		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					MailSender msMailSender=new MailSender();
					MailSenderInfo info=new MailSenderInfo();
					info.setSubject("密码找回邮件");
					info.setToAddress(u.getEmail());//.getUserName());
					
					SystemVariables objVariables = variablesService.getVariables("mail_findpwd_template");
					String content = objVariables.getValue();
					
					//String content="<p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">亲爱的$$$name先生/女士: </span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">您好！这是您的Gaopin Images网站登录信息。</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">出于安全原因，我们给您指定了临时密码。</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">--------------------------------------------------</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">用户名： $$$username</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">临时密码： $$$password</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">--------------------------------------------------</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">登录后，请您务必在线更新您的密码。</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">用以上信息登录：</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p class=\"MsoListParagraph\" style=\"margin-left: 28px;line-height: 24px\">    <span style=\";font-family:Wingdings\">l<span style=\"font-size: 9px;line-height: normal;font-family: &#39;Times New Roman&#39;\">&nbsp; </span></span><span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">请点击网站地址： </span><a href=\"http://www.gaopinimages.com/\"><span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">http://www.gaopinimages.com/</span></a> </p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p class=\"MsoListParagraph\" style=\"margin-left: 28px;line-height: 24px\">    <span style=\";font-family:Wingdings\">l<span style=\"font-size: 9px;line-height: normal;font-family: &#39;Times New Roman&#39;\">&nbsp; </span></span><span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">如果上面的链接失效，您可以复制完整的网站地址，粘贴到网络浏览器的地址栏。</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">请勿回复此邮件。</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">如有任何疑问或建议，欢迎随时与我们联系，电话：400-820-0268，或直接联系您的高品客户主任。</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height: 24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">感谢您使用高品图像。 </span></p><p style=\"line-height:24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">&nbsp;</span></p><p style=\"line-height:24px\">    <span style=\";font-family:&#39;微软雅黑&#39;,&#39;sans-serif&#39;\">高品图像</span></p><p>    <br/></p>";
					content=content.replace("$$$name", u.getFirstName()==null?"":u.getFirstName())
					.replace("$$$username", u.getUserName())
					.replace("$$$password", c);
					info.setContent(content);
					try {
						logger.info("mail out "+content);
						msMailSender.sendtMail(info,MailType.HTML);
						variablesService.mailLog(info, "Mail");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		return user;
	}

	@Override
	public List<DownloadOrder> getDownLoadOrder(int userId,int pageNo,int pageSize,int type) {
		// TODO Auto-generated method stub
				if(userId>0){
					Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
					coll.add(new CompareExpression("userId", userId, CompareType.Equal));
					coll.add(new CompareExpression("type", type, CompareType.Equal));
					List<DownloadOrder> list=controller.findBy(DownloadOrder.class, pageNo, pageSize, "createTime", false, coll);
					return list;
				}
				return null;
	}

	@Override
	public long getOrderPageCount(int userId,int pageNo,int pageSize,int type) {
		if(userId>0){
			Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("userId", userId, CompareType.Equal));
			coll.add(new CompareExpression("type", type, CompareType.Equal));
			long entityCount=controller.getResultCount(DownloadOrder.class, coll);
			return entityCount%pageSize==0?entityCount/pageSize:entityCount/pageSize+1;
		}
		return 0;
	}

	@Override
	public long getItemCountByOrder(Integer orderid) {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("orderId", orderid, CompareType.Equal));
		long entityCount=controller.getResultCount(DownloadHistory.class, coll);
		return entityCount;
	}

	@Override
	public List<DownloadHistory> getDownloadHistoryByOrderId(Integer orderId) {
		Collection<HibernateExpression> coll=new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("orderId", orderId, CompareType.Equal));
		return controller.findBy(DownloadHistory.class,"createTime",false, coll);
	}

//	@Override
//	public String ResetPassword(Integer userid) {
//		User user=controller.get(User.class, userid);
//		String code="";
//		if(user!=null)
//		{
//			code=MD5.getMd5Str(new Date().toString()+user.getId()+user.getUserName());
//			user.setCode(code);
//			user.setUpdateTime(new Date());
//			controller.update(user);
//		}
//		return code;
//	}
//
//	@Override
//	public User ResetPassword(String code, String newPassword) {
//			User user=controller.findUniqueBy(User.class,"code", code);
//			if(user==null)
//				return null;
//			if(user.getUpdateTime().before(DateUtils.addDays(new Date(), -1)))
//				return null;
//			user.setPassword(MD5.getMd5Str(user.getId()+MD5.getMd5Str(newPassword)));
//			user.setCode("");
//			controller.update(user);
//			return user;
//	}
	
	
	@Override
	public List<DownloadHistory> getHistory(int userId,int pageNo,int pageSize,int type,String typeSearch,String sDate,String eDate ) {
				if(userId>0){

					List<DownloadHistory> ret = new ArrayList<DownloadHistory>();
					Connection conn = null;
					Statement stmt = null;
					ResultSet rst = null;
					try {

						conn = controller.getConn();
						stmt = conn.createStatement();
						

						StringBuilder sql = new StringBuilder();
						sql.append("SELECT ");
						sql.append(" h.corbis_id,h.create_time FROM fr_download_history h LEFT JOIN fr_image_info i ON h.corbis_id = i.corbis_id ");
						sql.append(" WHERE h.user_id=? ");
						if(type != 0)
						{
							sql.append("  AND i.license_type = ? ");
						}
						if(!StrUtils.isBlank(sDate))
						{
							sql.append(" AND h.create_time > ? ");
						}
						if(!StrUtils.isBlank(eDate))
						{
							sql.append(" AND h.create_time < ? ");
						}
						sql.append(" LIMIT ?,? ");
						java.sql.PreparedStatement pstmt=conn.prepareStatement(sql.toString());
						int i = 2;
						pstmt.setInt(1, userId);
						if(type != 0)
						{
							pstmt.setInt(i, type);
							i++;
						}
						if(!StrUtils.isBlank(sDate))
						{
							sDate = sDate.replaceAll("/", "-") + " 00:00:00";
							pstmt.setString(i, sDate);
//							pstmt.setDate(i, new java.sql.Date(DateUtil.convertStringToDate(DateUtil.dateTimePattern,sDate).getTime()));
							i++;
						}
						if(!StrUtils.isBlank(eDate))
						{
							eDate = eDate.replaceAll("/", "-")+ " 23:59:59";
							pstmt.setString(i, eDate);
//							pstmt.setDate(i, new java.sql.Date(DateUtil.convertStringToDate(DateUtil.dateTimePattern,eDate).getTime()));
							i++;
						} 
						pstmt.setInt(i, pageNo*pageSize);
						i++;
						pstmt.setInt(i, pageSize);
						rst=pstmt.executeQuery();
						while (rst.next()) {
							try {
								String corbisId = rst.getString(1); 
								String createTime = rst.getString(2);
								DownloadHistory item=new DownloadHistory();
								item.setCorbisId(corbisId);
								item.setCreateTime(DateUtil.convertStringToDate(DateUtil.dateTimePattern,createTime));
								ret.add(item);
								
							} catch (Exception e) {
								logger.error("数据转换失败", e);
							}

						}
					} catch (Exception e) {
						logger.error("数据查询失败", e);
					} finally {
						try {
							if (conn != null)
								conn.close();
							if (stmt != null)
								stmt.close();
							if (rst != null)
								rst.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					return ret;
				}
				return null;
	}
	
	@Override
	public long getHistoryPageCount(int userId,int pageNo,int pageSize,int type,String sDate,String eDate) {
		if(userId>0){
			
			Connection conn = null;
			Statement stmt = null;
			ResultSet rst = null;
			try {

				conn = controller.getConn();
				stmt = conn.createStatement();
				

				StringBuilder sql = new StringBuilder();
				sql.append("SELECT ");
				sql.append(" count(h.corbis_id) FROM fr_download_history h LEFT JOIN fr_image_info i ON h.corbis_id = i.corbis_id ");
				sql.append(" WHERE h.user_id=? ");
				if(type != 0)
				{
					sql.append("  AND i.license_type = ? ");
				}
				if(!StrUtils.isBlank(sDate))
				{
					sql.append(" AND h.create_time > ? ");
				}
				if(!StrUtils.isBlank(eDate))
				{
					sql.append(" AND h.create_time < ? ");
				}
				java.sql.PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				int i = 2;
				pstmt.setInt(1, userId);
				if(type != 0)
				{
					pstmt.setInt(2, type);
					i++;
				}
				if(!StrUtils.isBlank(sDate))
				{
					sDate = sDate.replaceAll("/", "-") + " 00:00:00";
					pstmt.setString(i, sDate);
//					pstmt.setDate(i, new java.sql.Date(DateUtil.convertStringToDate(DateUtil.datePattern,sDate).getTime()));
					i++;
				}
				if(!StrUtils.isBlank(eDate))
				{
					eDate = eDate.replaceAll("/", "-")+ " 23:59:59";
					pstmt.setString(i, eDate);
//					pstmt.setDate(i, new java.sql.Date(DateUtil.convertStringToDate(DateUtil.datePattern,eDate).getTime()));
				} 
				
				rst=pstmt.executeQuery();
				while (rst.next()) {
					try {
						long count = rst.getLong(1);
						return count%pageSize==0?count/pageSize:count/pageSize+1;

					} catch (Exception e) {
						logger.error("数据转换失败", e);
					}

				}
			} catch (Exception e) {
				logger.error("数据查询失败", e);
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stmt != null)
						stmt.close();
					if (rst != null)
						rst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return 0;
		}
		return 0;
	}
}
