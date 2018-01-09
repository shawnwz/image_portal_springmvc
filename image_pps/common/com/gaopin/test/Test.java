/* This file Test.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.test;

import java.util.HashMap;
import java.util.Map;

import com.gaopin.utils.JsonFormat;

public class Test {
	
	public static void main(String[] args){
		System.out.println("======================S");
		
//		System.out.println(getFinance());
		String origiFileName = "adfadsfs.gif";
		String ext = origiFileName.substring(origiFileName.lastIndexOf("."));
		System.out.println(ext);
		System.out.println("======================E");
	}
	
	public static String getContact(){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("country", "86");
		map.put("prov", "110000");
		map.put("city", "110105");
		map.put("zipCode", "100000");
		map.put("telphone", "010-88888888");
		map.put("fax", "010-66666666");
		return JsonFormat.toString(map);
	}
	
	public static String getFinance(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("financeName", "zhurenjie");
		map.put("financePhone", "13800138000");
		map.put("invoiceType", "1");
		return JsonFormat.toString(map);
	}
}
