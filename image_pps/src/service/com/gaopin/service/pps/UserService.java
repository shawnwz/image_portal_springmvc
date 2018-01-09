/* This file UserService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gaopin.entity.DownloadHistory;
import com.gaopin.entity.DownloadOrder;
import com.gaopin.entity.User;
import com.gaopin.service.BaseService;

/**
 * @author 高顺德
 *
 */
public interface UserService extends BaseService {
	public User loginUser(Object entity);
	public boolean isExist(String name);
	public boolean isExistUserName(String name);
	public boolean isExistEmail(String email);
	public User getUserByLoginName(String loginName);
	public List<DownloadHistory> getDownLoadIMG(Integer id);
	public List<DownloadHistory> getDownLoadIMG(int userId,int pageNo,int pageSize,int type);
	public long getPageCount(int userId,int pageNo,int pageSize);
	public Serializable saveObject(Object entity);
	
	public User ResetPasswordAndSendmail(Integer userid);
	
	//public String ResetPassword(Integer userid);
	//public User ResetPassword(String code,String newPassword);
	public List<DownloadOrder> getDownLoadOrder(int userId,int pageNo,int pageSize,int type);
	public long getOrderPageCount(int userId,int pageNo,int pageSize,int type);
	public long getItemCountByOrder(Integer orderId);
	
	public List<DownloadHistory> getDownloadHistoryByOrderId(Integer orderId);
	public User getUserByLoginEmail(String loginEmail);
	public List<DownloadHistory> getHistory(int userId, int pageNo, int pageSize,int type,
			String types, String sDate, String eDate);
	public long getHistoryPageCount(int userId, int pageNo, int pageSize, int type,
			String sDate, String eDate);
}
