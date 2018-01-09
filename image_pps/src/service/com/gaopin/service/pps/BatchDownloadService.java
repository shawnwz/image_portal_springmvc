/* This file BatchDownloadService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps;

import java.util.Date;
import java.util.List;

import com.gaopin.service.BaseService;
import com.gaopin.utils.KeyValue;

public interface BatchDownloadService extends BaseService {
	
	/**
	 * 生成压缩文件，并返回下载地址
	 * @param userId
	 * @param corbisIds
	 * @param sizeCodes
	 * @param fileName
	 * @param expireDate
	 * @param comment
	 * @return
	 */
	public KeyValue<Boolean, String> compressImages(Integer userId, List<String> corbisIds, List<Integer> sizeCodes, String fileName, Date expireDate, String comment);
	
	/**
	 * 下载文件，如果符合条件下载，记录下载记录
	 * @param userId
	 * @param fileName
	 * @param secretKey
	 * @return
	 */
	public KeyValue<Boolean, String> download(Integer userId, String fileName, String secretKey, String ip);
}
