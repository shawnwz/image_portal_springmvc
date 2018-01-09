/* This file PropertyReader.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class PropertyReader {
	private static final Properties prop = new Properties();

	private static String fileName = "config_property.properties";
	
	public static String CmsUrlPre = "cms_url_pre";
	
	static{
		try {
			prop.load(PropertyReader.class.getResourceAsStream("/" + fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getString(String propertyName, String def) {
		String v = getString(propertyName);
		return v!=null&&!v.equals("")? v:def;
	}
	
	public static String getString(String propertyName) {

		String propertyValue = prop.getProperty(propertyName);
		try {
			if (propertyValue != null) {
				propertyValue = new String(propertyValue.getBytes("ISO-8859-1"), "GBK");
			} else {
				return "";
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "";
		}
		return propertyValue;
	}
	
	public static int getInt(String name, int def){
		String value = getString(name);
		try{
			return Integer.parseInt(value);
		}
		catch(Exception e){
			return def;
		}
	}
	
	public static boolean getBoolean(String name, boolean def){
		String value = getString(name);
		if(value==null) return def;
		if(value.equalsIgnoreCase("true")) return true;
		if(value.equalsIgnoreCase("false")) return false;
		return def;
	}
}
