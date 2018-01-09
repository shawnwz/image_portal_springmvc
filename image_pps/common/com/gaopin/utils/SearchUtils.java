/* This file SearchUtils.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.gaopin.constants.Constants;
import com.gaopin.entity.SearchResult;
import com.gaopin.entity.SolrResult;

public class SearchUtils {
	protected static final Logger logger = Logger.getLogger(SearchUtils.class);
	private static String SEARCH_URL = PropertyReader.getString("search.url");
	private static String SUGGEST_URL = PropertyReader.getString("suggest.url");

	private static String[] IMAGE_HOSTS = null;
	private static String[] MOTION_HOSTS = null;
	static {
		String hosts = PropertyReader.getString("img.hosts");
		if (StrUtils.isNotBlank(hosts)) {
			IMAGE_HOSTS = hosts.split(",");
			for (int i = 0; i < IMAGE_HOSTS.length; i++) {
				IMAGE_HOSTS[i] = IMAGE_HOSTS[i].trim();
			}
		} else {
			IMAGE_HOSTS = new String[] { "http://124.202.155.73:8080/" };
		}
	}
	
	static {
		String mhosts = PropertyReader.getString("motion.hosts");
		if (StrUtils.isNotBlank(mhosts)) {
			MOTION_HOSTS = mhosts.split(",");
			for (int i = 0; i < MOTION_HOSTS.length; i++) {
				MOTION_HOSTS[i] = MOTION_HOSTS[i].trim();
			}
		} else {
			MOTION_HOSTS = new String[] { "http://124.202.155.73:8080/" };
		}
	}
	
	public static String getImagePreviewUrl(String corbisId) {
		if (StrUtils.isBlank(corbisId))
			return null;
		return getImageHostRandom() + "THUMBNAIL/180/"
				+ getImageFullPath(corbisId);
	}
	
	public static String getMotionPreviewUrl(String gaopinId) {
		if (StrUtils.isBlank(gaopinId))
			return null;
		return getMotionHostRandom() + "PreviewMP4/"
				+ getImageFullPath(gaopinId);
	}

	public static String getImageHost(int index) {
		return IMAGE_HOSTS[index % IMAGE_HOSTS.length];
	}
	public static String getMotionHost(int index) {
		return MOTION_HOSTS[index % MOTION_HOSTS.length];
	}

	public static String getImageHostRandom() {
		return IMAGE_HOSTS[new Random().nextInt(IMAGE_HOSTS.length)];
	}
	public static String getMotionHostRandom() {
		return MOTION_HOSTS[new Random().nextInt(MOTION_HOSTS.length)];
	}

	public static String getImageRootPath(Byte storageId) {
		if (storageId == null) {
			return getImageRootPath((Integer) null);
		}
		return getImageRootPath(storageId.intValue());
	}

	public static String getImageRootPath(Integer storageId) {
		String rootPathKey = storageId == null ? Constants.IMAGE_DISK_PATH_ROOT_DEFAULT
				: Constants.IMAGE_DISK_PATH_ROOT_PREFIX + storageId;
		return PropertyReader.getString(rootPathKey, PropertyReader
				.getString(Constants.IMAGE_DISK_PATH_ROOT_DEFAULT));
	}

	public static String getMotionRootPath(Integer storageId) {
		String rootPathKey = storageId == null ? Constants.MOTION_DISK_PATH_ROOT_DEFAULT
				: Constants.MOTION_DISK_PATH_ROOT_PREFIX + storageId;
		return PropertyReader.getString(rootPathKey, PropertyReader
				.getString(Constants.MOTION_DISK_PATH_ROOT_DEFAULT));
	}
	public static String getImageWaterPath2del() {
		return PropertyReader.getString(Constants.IMAGE_DISK_PATH_WATERMARK);
	}

	public static String getImageFullPath(String corbisId) {
		StringBuilder sb = getImageFolderBuilder(corbisId).append(corbisId);
			//by Sean	.append("");
		return sb.toString();
	}
	public static String getMotionImageFullPath(String corbisId) {
		StringBuilder sb = getImageFolderBuilder(corbisId).append(corbisId)
				.append(".jpg");
		return sb.toString();
	}
	public static String getMotionMp4FullPath(String corbisId) {
		StringBuilder sb = getImageFolderBuilder(corbisId).append(corbisId)
				.append(".mp4");
		return sb.toString();
	}
	public static String getMotionFlvFullPath(String corbisId) {
		StringBuilder sb = getImageFolderBuilder(corbisId).append(corbisId)
				.append(".flv");
		return sb.toString();
	}
	public static String getMotionWebmFullPath(String corbisId) {
		StringBuilder sb = getImageFolderBuilder(corbisId).append(corbisId)
				.append(".webm");
		return sb.toString();
	}
	public static String getDetailMp4MotionFullPath(String gaopinId) {
		StringBuilder sb = getImageFolderBuilder(gaopinId).append(gaopinId)
				.append(".mp4");
		return sb.toString();
	}
	public static String getDetailWebmMotionFullPath(String gaopinId) {
		StringBuilder sb = getImageFolderBuilder(gaopinId).append(gaopinId)
				.append(".webm");
		return sb.toString();
	}

	public static String getImagePath(String corbisId) {
		StringBuilder sb = getImageFolderBuilder(corbisId).append(corbisId)
				.append(".jpg");
		return sb.toString();
	}

	public static StringBuilder getImageFolderBuilder(String corbisId) {
		String md5Str = getSplashCorbisId(corbisId);
		String md5 = MD5.getMd5Str(md5Str);
		StringBuilder sb = new StringBuilder();
		sb.append(md5.substring(0, 2)).append("/").append(md5.substring(2, 4))
				.append("/").append(md5.substring(4, 6)).append("/")
				.append(md5.substring(6, 8)).append("/");
		return sb;
	}

	public static String getImageFolder(String corbisId) {
		return getImageFolderBuilder(corbisId).toString();
	}
	
	public static String getMotionFolder(String gaopinId) {
		return getMotionFolderBuilder(gaopinId).toString();
	}
	public static StringBuilder getMotionFolderBuilder(String gaopinId) {
		String md5Str = gaopinId;
		String md5 = MD5.getMd5Str(md5Str);
		StringBuilder sb = new StringBuilder();
		sb.append(md5.substring(0, 2)).append("/").append(md5.substring(2, 4))
				.append("/").append(md5.substring(4, 6)).append("/")
				.append(md5.substring(6, 8)).append("/");
		return sb;
	}

	public static Map<String, List<String>> GetSplashMap(List<String> corbisIds) {

		Map<String, List<String>> spllist = new HashMap<String, List<String>>();
		for (String string : corbisIds) {
			if(isSplashId(string))
			{
				String fidString=getSplashCorbisId(string);
				List<String> spls=spllist.get(fidString);
				if(spls==null)
				{
					spllist.put(fidString, new ArrayList<String>());
					spls=spllist.get(fidString);
				}
				spls.add(string);
			}
		}
		return spllist;
	}

	public static boolean isSplashId(String corbisId) {
		if (StrUtils.isBlank(corbisId))
			return false;
		return corbisId.toLowerCase().startsWith("spl");
	}

	public static boolean isSplashParentId(String corbisId) {
		return isSplashId(corbisId) && corbisId.indexOf("_") > 0;
	}

	public static String getSplashCorbisId(String corbisId) {
		if (isSplashId(corbisId)) {
			int lastIndex = corbisId.lastIndexOf("_");
			if (lastIndex > 0) {
				return corbisId.substring(0, lastIndex);
			}
		}
		return corbisId;
	}

	public static String getImagePathByExist(String rootPath, String folder,
			String corbisId, String[] exts) {
		if (StrUtils.isBlank(corbisId))
			return null;
		if (exts == null || exts.length == 0) {
			exts = new String[] { ".jpg" };
		}
		String subFolder = getImageFolder(corbisId);
		for (String ext : exts) {
			String path = rootPath + folder + "/" + subFolder + corbisId + ext;
			if (new File(path).exists()) {
				return path;
			}
		}
		return null;
	}

	public static List<String> getSubList(List<String> list, int start, int num) {
		if (list != null) {
			int end = start + num;
			if (end > list.size()) {
				end = list.size();
			}
			if (start >= end)
				return new ArrayList<String>();
			return list.subList(start, end);
		}
		return new ArrayList<String>();
	}

	/**
	 * 获取总页数
	 * 
	 * @param total
	 * @param limit
	 * @return
	 */
	public static int getTotalPages(int total, int limit) {
		if (limit <= 0)
			return 0;
		int pages = total / limit;
		if (total % limit != 0)
			pages++;
		return pages;
	}

	public static String getSearchUrl() {
		return SEARCH_URL;
	}

	public static String genSearchUrl(Map<String, Object> map) {
		if (map != null && map.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Entry<String, Object> entry : map.entrySet()) {
				if (sb.length() > 0) {
					sb.append("&");
				}
				sb.append(entry.getKey()).append("=").append(entry.getValue());
			}
			if (sb.length() > 0) {
				return SEARCH_URL + "?" + sb.toString();
			}
			
		}
		//System.out.println(SEARCH_URL);
		return SEARCH_URL;
	}

	public static String genSuggestUrl(Map<String, Object> map) {
		if (map != null && map.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (Entry<String, Object> entry : map.entrySet()) {
				if (sb.length() > 0) {
					sb.append("&");
				}
				sb.append(entry.getKey()).append("=").append(entry.getValue());
			}
			if (sb.length() > 0) {
				return SUGGEST_URL + "?" + sb.toString();
			}
			
		}
		//System.out.println(SEARCH_URL);
		return SUGGEST_URL;
	}
	public static int getMapValue(Object object) {
		if (object == null)
			return 0;
		try {
			return (Integer) object;
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * 如果是英文，有空格的在两边加上引号
	 * 如果是中文，在两边加上引号
	 * @param phrase
	 * @return
	 */
	public static String formatPhraseByQuote(String phrase){
		if(StrUtils.isEnglish(phrase)){
			if(phrase.indexOf(" ")>0){
				return "\""+phrase+"\"";
			}
		}
		else{
			return "\""+phrase+"\""; 
		}
		return phrase;
	}
	
	public static String appenQuote(String str){
		if(str.indexOf("\"")<0){
			return "\""+str+"\"";
		}
		return str;
	}

	public String showMap(Map<String, Object> map) {
		if (map == null)
			return null;
		StringBuilder sb = new StringBuilder("@map[");
		for (Entry<String, Object> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue())
					.append(",");
		}
		sb.append(",]");
		return sb.toString();
	}

	public static long timeDebug(String key) {
		if (key != null) {
			System.out.println("【TIME_DEBUG】" + key);
		}
		return System.currentTimeMillis();
	}

	public static long timeDebug(String key, long t) {
		if (key != null) {
			System.out.println("【TIME_DEBUG】" + key + ", time="
					+ (System.currentTimeMillis() - t));
		}
		return System.currentTimeMillis();
	}

	public static void parseKey(String s) {
		System.out.println("S==" + s);

		List<String> aList = new ArrayList<String>();
		List<String> oList = new ArrayList<String>();
		List<String> nList = new ArrayList<String>();
		String[] ands = s.split("AND");
		for (String and : ands) {
			String[] ors = and.split("OR");
			for (int i = 0; i < ors.length; i++) {
				String or = ors[i];
				String[] nots = or.split("NOT");
				if (i == 0) {
					aList.add(nots[0].trim());
				} else {
					oList.add(nots[0].trim());
				}
				for (int j = 1; j < nots.length; j++) {
					nList.add(nots[j].trim());
				}
			}
		}
		print("AND", aList);
		print("OR", oList);
		print("NOT", nList);
	}
	
	public static String clearSpecSymbol(String q){
		if(q.indexOf("·")>=0){
			q = q.replace("·", "");
		}
		if(q.indexOf("-")>=0){
			q = q.replace("-", "");
		}
		if(q.indexOf(".")>=0){
			q = q.replace(".", "");
		}
		return q;
	}
	
	public static SearchResult getSearchResultFromJson(String json, SearchResult sr){
		if(sr==null) sr = new SearchResult();
		try{
			JSONObject jobj = JSONObject.fromObject(json);
			sr.setTotal(jobj.getInt("num"));
			JSONArray jArray = jobj.getJSONArray("data");
			List<SolrResult> datas = new ArrayList<SolrResult>();
			if(jArray!=null){
				for(int i=0; i<jArray.size(); i++){
					JSONObject subJobj = jArray.getJSONObject(i);
//					Integer rating = subJobj.getInt("rating");
//					if(rating==null) rating = 0;
					int rating = 0;
					datas.add(new SolrResult(subJobj.getString("corbis_id"), subJobj.getInt("collection_id"), rating));
				}
			}
			sr.setDatas(datas);
			return sr;
		}
		catch(Exception e){
			logger.error("【SearchUtils】solr 返回JSON字符串解析异常[jsonStr = "+json+"]：", e);
		}
		return sr;
	}
	
	public static Object[] getSuggestResultFromJson(String json){
		//if(sr==null) sr = new SearchResult();
		List<String> result = new ArrayList<String>();
		Object[] s = new Object[4];
		try{
			JSONObject jobj = JSONObject.fromObject(json);
			
			//sr.setTotal(jobj.getInt("num"));
			JSONArray jArray = jobj.getJSONArray("data");
			//Object[] s=jArray.toArray();
			s = jArray.toArray();
			//result = jArray.toList(jArray);
			/*List<String> datas = new ArrayList<String>();
			if(jArray!=null){
				for(int i=0; i<jArray.size(); i++){
					JSONObject subJobj = jArray.getJSONObject(i);
//					Integer rating = subJobj.getInt("rating");
//					if(rating==null) rating = 0;
					int rating = 0;
					datas.add(new SolrResult(subJobj.getString("corbis_id"), subJobj.getInt("collection_id"), rating));
				}
			}
			sr.setDatas(datas);*/
			return s;
		}
		catch(Exception e){
			logger.error("【SearchUtils】solr 返回JSON字符串解析异常[jsonStr = "+json+"]：", e);
		}
		return s;
	}
	
	public static SearchResult motion_getSearchResultFromJson(String json, SearchResult sr){
		if(sr==null) sr = new SearchResult();
		try{
			JSONObject jobj = JSONObject.fromObject(json);
			sr.setTotal(jobj.getInt("num"));
			JSONArray jArray = jobj.getJSONArray("data");
			List<SolrResult> datas = new ArrayList<SolrResult>();
			if(jArray!=null){
				for(int i=0; i<jArray.size(); i++){
					JSONObject subJobj = jArray.getJSONObject(i);
//					Integer rating = subJobj.getInt("rating");
//					if(rating==null) rating = 0;
					int rating = 0;
					datas.add(new SolrResult(subJobj.getString("gaopin_id"), subJobj.getInt("collection_id"), rating));
				}
			}
			sr.setDatas(datas);
			return sr;
		}
		catch(Exception e){
			logger.error("【SearchUtils】solr 返回JSON字符串解析异常[jsonStr = "+json+"]：", e);
		}
		return sr;
	}

	public static void print(String key, List<String> list) {
		System.out.println("============" + key);
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		
		System.out.println("------------------------------S");
		System.out.println(SearchUtils.getImageFullPath("133101301827"));
		System.out.println("------------------------------E");
	}
}
