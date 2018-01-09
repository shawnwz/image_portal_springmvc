/* This file AreaHelper.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 行政区域帮助类
 * @author Administrator
 *
 */
public class AreaHelper {
	
	private static Logger log = Logger.getLogger(AreaHelper.class);
	private static final String fileName = "area.txt";
	
	private static Map<String, KeyValue<String, String>> _areaMap = new HashMap<String, KeyValue<String, String>>();
	private static List<KeyValue<String, String>> _list = new ArrayList<KeyValue<String, String>>();
	
	private static final String REGEX_PROV = "[0-9]{2}0000";
	private static final String REGEX_CITY = "[0-9]{2}([1-9][0-9]|[0-9][1-9])00";
	private static final String REGEX_COUNTY = "[0-9]{4}([1-9][0-9]|[0-9][1-9])";
	
	@SuppressWarnings("serial")
	private static Set<String> excludeName = new HashSet<String>(){{
//		add("县");
	}};
	
	static{load();}
	
	private static void load(){
		BufferedReader br = null;
		InputStream is = null;
		try{
			is = AreaHelper.class.getResourceAsStream("/"+fileName);
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));  
			String line = null;
			while((line=br.readLine())!=null){
				try{
					line = line.trim();
					if(line.startsWith("#")) continue;
					String[] eles = line.split(",");
					if(eles.length!=2) continue;
					if(excludeName.contains(eles[1])){
						log.info("地区["+eles[1]+"]非常规区，排除掉，不载入！");
						continue;
					}
					KeyValue<String, String> kv = new KeyValue<String, String>(eles[0], eles[1]);
					_areaMap.put(eles[0], kv);
					_list.add(kv);
				}
				catch(Exception e){
					log.error("载入逐行内容异常：line = " + line, e);
				}
			}
		}
		catch(Exception e){
			log.error("载入文件异常：fileName=" + fileName, e);
		}
		finally{
			try{if(br!=null) br.close();if(is!=null) is.close();}catch(Exception e){}
		}
	}
	
	public static List<KeyValue<String, String>> getProv(){
		List<KeyValue<String, String>> rstList = new ArrayList<KeyValue<String,String>>();
		for(KeyValue<String, String> kv : _list){
			if(kv.getKey().matches(REGEX_PROV)){
				rstList.add(kv);
			}
		}
		return rstList;
	}
	
	public static List<KeyValue<String, String>> getSons(String key){
		List<KeyValue<String, String>> rstList = new ArrayList<KeyValue<String,String>>();
		String regex = null;
		if(key.matches(REGEX_PROV)) {
			regex = key.substring(0,2)+"([1-9][0-9]|[0-9][1-9])00";
		}
		else if(key.matches(REGEX_CITY)){
			regex = key.substring(0, 4)+"([1-9][0-9]|[0-9][1-9])";
		}
		if(StrUtils.isNotBlank(regex)){
			for(KeyValue<String, String> kv : _list){
				if( kv.getKey().matches(regex)){
					rstList.add(kv);
				}
			}
		}
		return rstList;
	}
	
	public static List<KeyValue<String, String>> getCity(String provId){
		List<KeyValue<String, String>> rstList = new ArrayList<KeyValue<String,String>>();
		for(KeyValue<String, String> kv : _list){
			if( kv.getKey().matches(provId.substring(0,2)+".*") && kv.getKey().matches(REGEX_CITY)){
				rstList.add(kv);
			}
		}
		return rstList;
	}
	
	public static List<KeyValue<String, String>> getCounty(String cityId){
		List<KeyValue<String, String>> rstList = new ArrayList<KeyValue<String,String>>();
		for(KeyValue<String, String> kv : _list){
			if( kv.getKey().matches(cityId.substring(0,4)+".*") && kv.getKey().matches(REGEX_COUNTY)){
				rstList.add(kv);
			}
		}
		return rstList;
	}
	
	public static KeyValue<String, String> get(String key){
		return _areaMap.get(key);
	}
	
	public static KeyValue<String, String> getParent(String key){
		if(key.matches(REGEX_PROV)) return null;
		if(key.matches(REGEX_CITY)){
			return _areaMap.get(key.substring(0,2)+"0000");
		}
		if(key.matches(REGEX_COUNTY)){
			return _areaMap.get(key.substring(0, 4)+"00");
		}
		return null;
	}
	
	public static KeyValue<String, String> getFixedProv(String key ){
		String provPrifix = key.substring(0, 2);
		String provKey = provPrifix + "0000";
		return _areaMap.get(provKey);
	}
	
	public static KeyValue<String, String> getFixedCity(String key ){
		if(key.endsWith("0000")){
			return null;
		}
		String cityPrifix = key.substring(0, 4);
		String cityKey = cityPrifix + "00";
		return _areaMap.get(cityKey);
	}
	
	public static KeyValue<String, String> getFixedCounty(String key ){
		if(key.endsWith("0000") ||  key.endsWith("00")){
			return null;
		}
		return _areaMap.get(key);
	}

	public static boolean isProv(String key) {
		if(StringUtils.isBlank(key)) {
			return false;
		}
		if(key.matches(REGEX_PROV)) return true;
		return false;
	}
	public static boolean isCity(String key) {
		if(StringUtils.isBlank(key)) {
			return false;
		}
		if(key.matches(REGEX_CITY)) return true;
		return false;
	}
	public static boolean isCounty(String key) {
		if(StringUtils.isBlank(key)) {
			return false;
		}
		if(key.matches(REGEX_COUNTY)) return true;
		return false;
	}
	
	public static int getAreaLevel(String key){
		if(isProv(key)) return 1;
		if(isCity(key)) return 2;
		if(isCounty(key)) return 3;
		
		return -1;
	}
	
	public static String getAreaPrefix(String key){
		if(isProv(key)){
			return key.substring(0,2);
		}
		if(isCity(key)){
			return key.substring(0, 4);
		}
		if(isCounty(key)){
			return key;
		}
		return "";
	}
	
	public static void main(String[] args){
		List<KeyValue<String, String>> list = getCounty("130900");
		
		for(KeyValue<String, String> kv : list){
			System.out.println(kv.getKey()+":"+kv.getValue());
			
		}
		
		System.out.println("====================");
		
		System.out.println(getAreaPrefix("130100"));;
	}
}
