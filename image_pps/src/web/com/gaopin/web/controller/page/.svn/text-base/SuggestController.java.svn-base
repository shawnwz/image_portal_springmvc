/* This file SearchController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.entity.Clarification;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.ImageInfo;
import com.gaopin.entity.ImageInfoExtend;
import com.gaopin.entity.Keywords;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.SearchLog;
import com.gaopin.entity.SearchResult;
import com.gaopin.entity.SearchRule;
import com.gaopin.entity.User;
import com.gaopin.service.pps.ClarificationService;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.ContentProviderService;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.KeywordCollectionService;
import com.gaopin.service.pps.KeywordService;
import com.gaopin.service.pps.PhotographerService;
import com.gaopin.service.pps.SearchRuleService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.EncodeingHelper;
import com.gaopin.utils.HttpClientHelper;
import com.gaopin.utils.KeyValue;
import com.gaopin.utils.PropertyReader;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.BaseController;
import com.gaopin.web.controller.page.vo.CollectionSpec;
import com.gaopin.web.controller.page.vo.SearchCondition;
import com.gaopin.web.utils.RequestInfo;
import com.gaopin.web.utils.RequestUtils;
@Controller
public class SuggestController extends BaseController {
	
//	private static String CORBISID_REGEX = "(?![a-zA-Z\\s]+$)[0-9A-Za-z\\-\\s]{8,30}+";
//	private static String CORBISID_PARAMS = "(?![a-zA-Z\\-\\s]+$)[0-9A-Za-z\\-\\s,，\r\n]+";
	//.+[\\d{5,}|-].+
	private static String SPLIT_NOT = " NOT ";
	private static int SEARCH_NUM_BLANK = 10000;
	private static boolean SEARCH_SORT = true;
	private static int CACHE_NUM = PropertyReader.getInt("search.cache.num", 500);
	private static int CACHE_MAX_NUM = PropertyReader.getInt("search.cache.maxNum", 300000);
	private static String CACHE_KEY = "searchResult";
	
	@Resource
	private SearchService searchService;
	@Resource
	private CollectionService collectionService;
	@Resource
	private KeywordService keywordService;
	@Resource
	private ClarificationService clarificationService;
	@Resource
	private ImageGroupService imageGroupService;
	@Resource
	private VariablesService variablesService;
	@Resource
	private PhotographerService photographerService;
	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Resource
	private SearchRuleService searchRuleService;
	@Resource
	private ContentProviderService contentProviderService;
	@Resource
	private KeywordCollectionService keywordCollectionService;
	
	
	
	


	

	
	@RequestMapping(value = {"/suggest.do","/suggest.do","/suggest2.do"},method={RequestMethod.POST})
	@ResponseBody
	public Object[] getSuggest(HttpServletRequest request,HttpServletResponse response, @ModelAttribute SearchCondition sc){
		sc.init(request);
		User user = getSessionUser(request);
		RequestInfo requestInfo = RequestUtils.getContain();
		if(requestInfo==null){
			requestInfo = new RequestInfo(request, response);
			RequestUtils.setContain(requestInfo);
			RequestUtils.setUser(user);
		}
		
		
		Object[] result = new Object[4];
		try{
			result = suggestRequest(sc);
		}catch(Exception e){
			logger.error("搜索异常[q="+sc.getQ()+"]：", e);
			
		}

		return result;
	}
	
	private Object[] suggestRequest(SearchCondition sc){
		long t = SearchUtils.timeDebug("1===============获取搜索建议 === 请求搜索引擎开始...");
		if(sc.getSearchResult()==null){
			sc.setSearchResult(new SearchResult());
		}
		Map<String, Object> map = formatSuggestParams(sc);
		Object[] rst = new Object[4];

		
		String content = null;
		
		long t1 = System.currentTimeMillis();
		try{
			String uri = sc.getRequest().getRequestURI();
			String images = "images2";
			if(uri.endsWith("suggest1.do")){
				images = "images1";
			}
			else if(uri.endsWith("suggest2.do")){
				images = "images1";
			}
			else if(uri.endsWith("suggest.do")){
				images = "images";
			}
			map.put("solr_name", images);
			t = SearchUtils.timeDebug("===获取搜索建议 post参数处理", t);
			String url = SearchUtils.genSuggestUrl(map);
			t = SearchUtils.timeDebug("===获取搜索建议 URL参数处理["+url+"]", t);
			content = HttpClientHelper.doGet(url);
			t = SearchUtils.timeDebug("suggestUrl请求", t);
			rst = SearchUtils.getSuggestResultFromJson(content);
			t = SearchUtils.timeDebug("===获取搜索建议 请求结果JSON处理", t);
			t = SearchUtils.timeDebug("===获取搜索建议获取JSON数据，准备service处理", t);
			if(sc.getSearchResult().getTotal()>0){
				if(sc.isIndex()){
					sc.getSearchResult().setTotal(SEARCH_NUM_BLANK);
				}
			}
		}
		catch (Exception e) {
			logger.error("===获取搜索建议 请求搜索引擎异常[q="+sc.getQ()+"]：",e);
		}
		t = SearchUtils.timeDebug("===获取搜索建议 ===============请求搜索引擎结束", t1);
		return rst;
	}
	
	/*private void searchCache(SearchCondition sc){
		SearchResult sr = null;
		long t = SearchUtils.timeDebug("2===============请求缓存开始...");
		long t1 = System.currentTimeMillis();
		if(StrUtils.isNotBlank(sc.getSsid())){
			sr = (SearchResult)sc.getRequest().getSession().getAttribute(CACHE_KEY);
			if(sr!=null){
				// 比较ssid是否相同，不同清空session
				if(!sc.getSsid().equals(sr.getSearchId())){ // ssid不同
					sr = null;
					sc.getRequest().getSession().setAttribute(CACHE_KEY, null);
				}
				else{
					sc.getSearchLog().addData("isCache", true);
				}
			}
			
			if(sr==null || !sr.isRstRange(sc.getOffset(), sc.getN())){ // 没有缓存数据，请求搜索引擎
				sc.setSearchResult(sr);
				sr = suggestRequest(sc);
				sr.setSearchId(sc.getSsid());
				sr.setCache(true);
				sr.setMin(sc.getCacheStart(CACHE_NUM));
				sr.setMax(sr.getMin()+CACHE_NUM);
				
				// 排序 
				t = SearchUtils.timeDebug("开始排序：：：：", t);
				// 指定图库顺序排序
				CollectionSpec cs = collectionService.getCollectionSpec();
				List<String> sortedList = null;
				if(cs==null){
					logger.warn("未设置指定排序图库ID！！！，不执行100排序逻辑！！！！！！");
				}
				else{
					sortedList = cs.sortTop100(sr.getDatas());
					//sean sr.clearDatas();
				}
				// 根据图库级别排序 注释掉，2014-08-19
				//sortedList = new SearchSort(sr.getDatas(), collectionService).sort();
				
				if(sortedList!=null && sortedList.size()>0){
					sr.setIds(sortedList);
				}
				t = SearchUtils.timeDebug("排序结束：：：：", t);
				// 保存到session
				sc.getRequest().getSession().setAttribute(CACHE_KEY, sr);
			}
			else{
//				System.out.println("命中缓存，无需重新查询~~~~~~~~~~~~~~");
			}
		}
		t = SearchUtils.timeDebug("2===============请求缓存结束", t1);
		sc.setSearchResult(sr);
	}
	*/

	

	
	/**
	 * 对搜索条件进行预处理
	 * @param request
	 * @param q
	 * @param pageNo
	 * @param limit
	 * @return
	 */
	private Map<String, Object> formatSuggestParams(SearchCondition sc){
		Map<String, Object> map = new HashMap<String, Object>();
		if(StrUtils.isNotBlank(sc.getQ())){ // 关键字处理
			try{

				
				// 添加search_words
				if(StrUtils.isNotBlank(sc.getQ())){
										
					map.put("q", getUrlEncoder(sc.getQ()));

				}
			}
			catch (Exception e) {
				logger.error("处理关键字异常["+sc.getQ()+"]：", e);
				map.put("q", sc.getKey());
			}
		}
		else{ // 关键字为空
			

		}

		return map;
	}
	
	private void setSearchParams(HttpServletRequest request, String paraName, Map<String, Object> map){
		setSearchParams(request, paraName, paraName, map);
	}
	
	private void setSearchParams(HttpServletRequest request, String paraName, String sendName, Map<String, Object> map){
		String value = request.getParameter(paraName);
		if(StrUtils.isNotBlank(value)){
			try{map.put(sendName, value);}
			catch (Exception e) {
			}
		}
	}
	

	

	
	private String getUrlEncoder(String value){
		try{
			String s = URLEncoder.encode(value, "utf-8");
			return s;
		}catch (Exception e) {
			logger.error("URLEncoder exception["+value+"]:", e);
		}
		return value;
	}
	

	
	@Override
	public int getPageSize(HttpServletRequest request){
		return getIntValue(request, "n", DEFAULT_PAGE_SIZE);
	}
	
	@Override
	public int getPageNo(HttpServletRequest request) {
		return getIntValue(request, "p", 1);
	}
	
	public static void main(String[] args){
		System.out.println("------------------------------S");
		// (?![a-zA-Z\\s]+$)[0-9A-Za-z\\-\\s]{8,30}+
		String str = "a11111";
		System.out.println(str.matches(".*(\\d{5,}|-).*"));
		System.out.println("------------------------------E");
	}
	
	
	

	
	
}
