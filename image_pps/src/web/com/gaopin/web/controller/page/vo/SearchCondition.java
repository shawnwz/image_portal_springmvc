/* This file SearchCondition.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page.vo;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;

import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.SearchLog;
import com.gaopin.entity.SearchResult;
import com.gaopin.service.pps.KeywordCollectionService;
import com.gaopin.utils.DateUtil;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.KeyValue;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;

public class SearchCondition {
	private static Logger logger = Logger.getLogger(SearchCondition.class);
	private static String CORBISID_REGEX = ".*(\\d{5,}|-).*";
	private Integer index;		// 是否首页，1：是；其他：否
	private String uri;			// 请求地址：search.do;search1.do;search2.do
	private String q;			// 传入关键词
	private String key;			// 搜索关键词
	private Integer n;			// 每页显示数量
	private Integer p;			// 页码
	private Integer relativePageNo; // 相对页码
	private String smid;		// 相似图片CorbisId
	private String corbisId;    // 单个corbisId @ Sean
	private String corbisIds;	// 高级搜索.corbisId集合
	private String cla;			// 澄清ID组
	private Integer groupId;	// 图片组ID
	private String ssid;		// 搜索sessionId，判断是否为同一次搜索，不同翻页所用
	private String searchCorbisId; 	// 根据corbisId进行搜索，主要用于逻辑中的跳出口，如：相似搜索图片无任何关键字
//	private String cate_id;		// 分类ID
//	private String is_cd;		// 是否在CD里
//	private String person_num;	// 人数
//	private String sex;			// 性别
//	private String age;			// 年龄
//	private String race;		// 种族
//	private String color;		// 颜色
//	private String direction;	// 方向
//	private String portrait;	// 肖像权
//	private String style;		// 风格
//	private String layout;		// 布局
//	private String angle;		// 角度
//	private String type;		// 照片类型：黑白；彩色
//	private String cid;			// 图库ID
//	private String photographerName;			// 摄影师名称
//	private String locationName;				// 拍摄地点
//	private String immediateAvailablility;		// 尺寸：网页、手机；（高级搜索）
//	private String sortType;	// 排序
	private String photoDate; // 高级搜索，拍摄日期
	private String onlineDate;	// 图片上线时间
	
	private HttpServletRequest request;
	private SearchLog searchLog = new SearchLog();
	private SearchResult searchResult = null;	// 所有请求的原始结果集
	
	private List<String> andKeyList = new ArrayList<String>();		// AND操作关键字集合
	private List<String> orKeyList = new ArrayList<String>();		// OR操作关键字集合
	private List<String> notKeyList = new ArrayList<String>();		// NOT操作关键字集合
	private StringBuilder fqBuilder = new StringBuilder();			// fq
	private int keysCount = 1;	// 关键字数量
	
	public void init(HttpServletRequest request){
		this.request = request;
		if(n==null) n = 50;
		if(p==null || p<=0) p = 1;
		relativePageNo = p;
		key = key==null ? "":key;
		q = key.trim();
		if(index==null){
			index = StrUtils.getIntValue(request.getParameter("index"), -1);
		}
		if(!isCorbisId(q)){
			q = SearchUtils.clearSpecSymbol(q);
		}

		String onlineDate = request.getParameter("create_time");
		if(StrUtils.isNotBlank(onlineDate)){
			this.onlineDate = onlineDate; 
		}
		
		photoDate = request.getParameter("photoDate");
		
	}
	
	public boolean isCorbisId(String s){
		return s.matches(CORBISID_REGEX);
	}
	
	// 根据AND/OR/NOT解析关键字
	public void parseKey(String s){
		String[] ands = s.split("AND");
		for(String and : ands){
			String[] ors = and.split("OR");
			for(int i=0; i<ors.length; i++){
				String or = ors[i];
				String[] nots = or.split("NOT");
				String key = nots[0].trim();
				if(StrUtils.isNotBlank(key)){
					if(i==0){
						andKeyList.add(key);
					}
					else{
						orKeyList.add(key);
					}
				}
				for(int j=1; j<nots.length; j++){
					String notKey = nots[j].trim();
					if(StrUtils.isNotBlank(notKey)){
						notKeyList.add(notKey);
					}
				}
			}
		}
		this.keysCount = andKeyList.size()+orKeyList.size()+notKeyList.size();
	}
	
	// 不含操作关键字的解析方式
	public void parseNoOperatorKey(KeywordCollectionService keywordCollectionService) throws UnsupportedEncodingException{
		if(q.length()==q.getBytes("UTF-8").length){ // 英文
			//:~~~~
			q = StrUtils.filterMultiSpace(q);
			List<String> list = keywordCollectionService.parseEnKey(q);
			for(String s : list){
				andKeyList.add(s.trim());
			}
		}
		else{ // 中文，以空格做分割
			String[] eles = q.split(" |　|,|\\+|，");//半解和全解
			for(String ele : eles){
				ele = ele.trim();
				if(StrUtils.isNotBlank(ele)){
					andKeyList.add(ele);
				}
			}
		}
		this.keysCount = andKeyList.size();
	}
	
	// 判断是否包含逻辑表达字符“AND,OR,NOT”
	public boolean containsOperator(){
		return q.indexOf("AND")>=0 || q.indexOf("OR")>=0 || q.indexOf("NOT")>=0;
	}
	
	public void appendFq(String fqKey){
		if(fqBuilder.length()>0){
			fqBuilder.append(",");
		}
		fqBuilder.append(fqKey);
	}
	
	public StringBuilder getFqBuilder(){
		return fqBuilder;
	}
	
	// 判断是否首页
	public boolean isIndex(){
		if(index==null || index<0) return false;
		return true;
	}
	
	// 判断是否为相似搜索
	public boolean isSimilar() {
		return StrUtils.isNotBlank(smid);
	}
	
	public int getOffset(){
		if(getRelativePageNo()!=null && getRelativePageNo()>0){
			return (getRelativePageNo()-1)*getN();
		}
		return (getP()-1)*getN();
	}
	
	public int getCacheStart(int baseNum){
		int st = getOffset()/baseNum * baseNum;
		return st;
	}
	
	public void setPhotoDate(String photoDate) {
		this.photoDate = photoDate;
	}

	/**
	 * 获取上传时间（上线时间）
	 * @return
	 */
	public KeyValue<Long, Long> getOnlineDate(){
		KeyValue<Long, Long> kv = null;
		try{
			// 先判断高级搜索
			String beginDate = request.getParameter("beginDate");
			String endDate = request.getParameter("endDate");
			if(StrUtils.isNotBlank(beginDate) && StrUtils.isNotBlank(endDate)){
				Date leftDate = DateUtils.parse(beginDate, DateUtils.ymdSdf);
				Date rightDate = DateUtils.parse(endDate, DateUtils.ymdSdf);
				kv = new KeyValue<Long, Long>(DateUtils.getSecondStamp(leftDate), DateUtils.getSecondStamp(rightDate));
			}
			else if(StrUtils.isNotBlank(request.getParameter("days"))){
				int days = StrUtils.getIntValue(request.getParameter("days"), 1);
				Date nowDate = new Date();
				Date rightDate = DateUtil.getPrevDay(nowDate, days);
				kv = new KeyValue<Long, Long>(DateUtils.getSecondStamp(nowDate), DateUtils.getSecondStamp(rightDate));
			}
			else if(StrUtils.isNotBlank(onlineDate) && onlineDate.indexOf(":")>=0){
				String[] eles = onlineDate.split(":");
				if(eles.length==2){
					Date nowDate = new Date();
					Date leftDate = null;
					int num = StrUtils.getIntValue(eles[0], 1);
					if(eles[1].equalsIgnoreCase("D")){
						leftDate = DateUtil.getPrevDay(nowDate, num);
					}
					else if(eles[1].equalsIgnoreCase("W")){
						leftDate = DateUtil.getPrevWeek(nowDate, num);
					}
					else if(eles[1].equalsIgnoreCase("M")){
						leftDate = DateUtil.getPrevMonth(nowDate, num);
					}
					else if(eles[1].equalsIgnoreCase("Y")){
						leftDate = DateUtil.getPrevYear(nowDate, num);
					}
					if(leftDate!=null){
						kv = new KeyValue<Long, Long>(leftDate.getTime()/1000L, nowDate.getTime()/1000L);
					}
				}
			}
		}
		catch (Exception e) {
			logger.error("获取上线时间异常[onlineDate="+onlineDate+"]:", e);
		}
		return kv;
	}
	
	/**
	 * 获取拍摄时间
	 * @return
	 */
	public KeyValue<Long, Long> getPhotoDate(){
		
		if(StrUtils.isBlank(photoDate)) return null;
		KeyValue<Long, Long> kv = null;
		try{
			if(photoDate.indexOf("-")>0){ // 1931-1945
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				String[] eles = photoDate.split("-");
				if(eles.length!=2) return null;
				kv = new KeyValue<Long, Long>();
				kv.setKey(sdf.parse(eles[0]).getTime()/1000L);
				kv.setValue(sdf.parse(eles[1]).getTime()/1000L);
			}
			else{ // 单条日期
				String dateStr = photoDate.replace("年", "-");
				dateStr = dateStr.replace("月", "-");
				dateStr = dateStr.replace("日", "");
				if(dateStr.endsWith("-")){
					dateStr = dateStr.substring(0, dateStr.length()-1);
				}
				kv = DateUtils.parseYmdDatePeriod(dateStr);
			}
		}
		catch (Exception e) {
			logger.error("获取拍摄时间异常[photoDate="+photoDate+"]:", e);
		}
		return kv;
	}
	
	public List<PreviewImageInfo> getRstListByPage(List<PreviewImageInfo> rstList){
		try{
			int st = (p-1) * n;
			if(st>rstList.size()) return new ArrayList<PreviewImageInfo>();
			int et = p * n;
			if(et>rstList.size()){
				et = rstList.size();
			}
			return rstList.subList(st, et);
		}
		catch (Exception e) {
			return rstList;
		}
	}
	
	public SearchLog getSearchLog(){
		return searchLog;
	}

	public SearchResult getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(SearchResult searchResult) {
		this.searchResult = searchResult;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	public Integer getP() {
		return p;
	}

	public void setP(Integer p) {
		this.p = p;
	}

	public Integer getRelativePageNo() {
		return relativePageNo;
	}

	public void setRelativePageNo(Integer relativePageNo) {
		this.relativePageNo = relativePageNo;
	}

	public String getSmid() {
		return smid;
	}

	public void setSmid(String smid) {
		this.smid = smid;
	}

	public String getCorbisIds() {
		return corbisIds;
	}

	public void setCorbisIds(String corbisIds) {
		this.corbisIds = corbisIds;
	}
	
	public String getCorbisId() {
		return corbisId;
	}

	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}

	public String getCla() {
		return cla;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public int getKeysCount() {
		return keysCount;
	}

	public void setKeysCount(int keysCount) {
		this.keysCount = keysCount;
	}

	public List<String> getAndKeyList() {
		return andKeyList;
	}
	
	public void setAndKeyList(List<String> andKeyList){
		this.andKeyList = andKeyList;
	}
	
	public List<String> getOrKeyList() {
		return orKeyList;
	}

	public List<String> getNotKeyList() {
		return notKeyList;
	}
	
	public String getSearchCorbisId() {
		return searchCorbisId;
	}

	public void setSearchCorbisId(String searchCorbisId) {
		this.searchCorbisId = searchCorbisId;
	}
	


	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
