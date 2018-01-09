/* This file JsonFormat.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
/**
 * JSON 字符串和MAP（或数组）互转
 *
 */
public class JsonFormat {
	protected static final Logger logger = Logger.getLogger(JsonFormat.class);
	
	public static Object[] toArray(String str){
		try {
			JSONArray ja = JSONArray.fromObject(str);
			Object[] oa = (Object[])JSONArray.toArray(ja);
			return oa;
		} catch (Exception e) {
			logger.error("【JSON】JSON字符串解析成数组异常[jsonStr = "+str+"]：", e);
		}
		return null;
	}
	
	
	
//	public static Map<String,Object>[] toMapArray(String str){
//		try {
//			JSONArray ja = JSONArray.fromObject(str);
//			Object[] oa = (Object[])JSONArray.toArray(ja);
//			fore
//			
//			List<Map<String,Object>> ret=new ArrayList<Map<String,Object>>();
//			
//			
//			
//			return oa;
//		} catch (Exception e) {
//			logger.error("【JSON】JSON字符串解析成数组异常[jsonStr = "+str+"]：", e);
//		}
//		return null;
//	}
	
	/**
	 * 根据JSON字符串格式解析成MAP类型
	 * @param str
	 * @return
	 */
	public static Map<String, Object> toMap(String str) throws JSONException{
		Map<String, Object> map = null;
		try{
			JSONObject jobj = JSONObject.fromObject(str);
			map = formatJSON(jobj);
		}
		catch(Exception e){
			logger.error("【JSON】JSON字符串解析成MAP异常[jsonStr = "+str+"]：", e);
			throw new JSONException("JSON解析异常", e);
		}
		return map!=null ? map:new HashMap<String, Object>();
	}
	
	/**
	 * 根据JSON对象解析，将KEY->VALUE加入MAP
	 * @param jobj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static Map<String, Object> formatJSON(JSONObject jobj) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator it = jobj.keys();
		while(it.hasNext()){
			Object key = it.next();
			Object value = jobj.get(key);
			if(value instanceof JSONArray){
				map.put(key.toString(), formatJSONArray((JSONArray)value));
			}
			else if(value instanceof JSONObject){
				map.put(key.toString(), formatJSON((JSONObject)value));
			}
			else if(value instanceof JSONNull){
				map.put(key.toString(), null);
			}
			else{
				map.put(key.toString(), value);
			}
		}
		return map;
	}
	
	/**
	 * 处理数组型对象
	 * @param jArray
	 * @return
	 * @throws Exception
	 */
	public static List<Object> formatJSONArray(JSONArray jArray)throws Exception{
		List<Object> list = new ArrayList<Object>();
		for(int i=0; i<jArray.size(); i++){
			Object aobj = jArray.get(i);
			if(aobj!=null){
				if(aobj instanceof JSONObject){ // JSON对象
					list.add(formatJSON((JSONObject)aobj));
				}
				else if(aobj instanceof JSONArray){
					list.add(formatJSONArray((JSONArray)aobj));
				}
				else if(aobj instanceof JSONNull){
					list.add(null);
				}
				else{
					list.add(aobj.toString());
				}
			}
		}
		return list;
	}
	
	public static String toString(Map<String, Object> map){
		try{
			return JSONObject.fromObject(map).toString();
		}
		catch(Exception e){
			logger.error("【JSON】根据MAP对象生成JSON字符串异常：", e);
		}
		return null;
	}
	
	public static String toString(Object obj){
		if(obj==null) return null;
		try{
			return JSONObject.fromObject(obj).toString();
		}
		catch(Exception e){
			logger.error("【JSON】根据对象"+obj.getClass().getName()+"生成JSON字符串异常：", e);
		}
		return null;
	}
	
	@SuppressWarnings("static-access")
	public static Object toObj(String str, Class<? extends Object> clsz) throws JSONException{
		Object obj = null;
		try{
			JSONObject jobj = JSONObject.fromObject(str);
			obj = jobj.toBean(jobj, clsz);
		}
		catch(Exception e){
			logger.error("【JSON】JSON字符串解析成MAP异常[jsonStr = "+str+"]：", e);
			throw new JSONException("JSON解析异常", e);
		}
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T toObject(String str, Class<T> clsz) throws JSONException{
		T obj = null;
		try{
			JSONObject jobj = JSONObject.fromObject(str);
			obj = (T)JSONObject.toBean(jobj, clsz);
		}
		catch(Exception e){
			logger.error("【JSON】JSON字符串解析成MAP异常[jsonStr = "+str+"]：", e);
			throw new JSONException("JSON解析异常", e);
		}
		return obj;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> toObjects(String str, Class<T> clsz) throws JSONException{
		List<T> list = new ArrayList<T>();
		try{
			
			JSONArray jarr = JSONArray.fromObject(str);
			for(int i=0;i<jarr.size();i++)
			{
				JSONObject jobj =jarr.getJSONObject(i);
				T obj = (T)JSONObject.toBean(jobj, clsz);
				list.add(obj);
			}
		}
		catch(Exception e){
			logger.error("【JSON】JSON字符串解析成MAP异常[jsonStr = "+str+"]：", e);
			throw new JSONException("JSON解析异常", e);
		}
		return list;
	}
	
	
	public static void main(String[] args){
		 
	}
}
