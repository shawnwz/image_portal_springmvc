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
import javax.servlet.http.HttpSession;

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
import com.gaopin.entity.LtAwards;
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
import com.gaopin.service.pps.LotteryDrawService;
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
public class SearchController extends BaseController {
	
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
	@Resource
	private LotteryDrawService lotteryDrawService;
	
	
	@RequestMapping(value = "/searchAdv2del",method=RequestMethod.GET)
	public String go2AdvanceSearchPage(HttpServletRequest request, ModelMap model){
		List<ImageCollection> premiumList = collectionService.getPricingList("Premium");
		List<ImageCollection> standardList = collectionService.getPricingList("Standard");
		List<ImageCollection> valueList = collectionService.getPricingList("Value");
		List<ImageCollection> superValueList = collectionService.getPricingList("Super Value");
		
		model.addAttribute("premiumList", premiumList);
		model.addAttribute("standardList", standardList);
		model.addAttribute("valueList", valueList);
		model.addAttribute("superValueList", superValueList);
		
		return "inc/search_adv";
		//return "search/searchflow_adv";
	}
	
	@RequestMapping(value = "/searchAdv",method=RequestMethod.GET)
	public String go2AdvanceSearchPageFlow(HttpServletRequest request, ModelMap model){
//		List<ImageCollection> premiumList = collectionService.getPricingList("Premium");
//		List<ImageCollection> standardList = collectionService.getPricingList("Standard");
//		List<ImageCollection> valueList = collectionService.getPricingList("Value");
//		List<ImageCollection> superValueList = collectionService.getPricingList("Super Value");
//		
//		model.addAttribute("premiumList", premiumList);
//		model.addAttribute("standardList", standardList);
//		model.addAttribute("valueList", valueList);
//		model.addAttribute("superValueList", superValueList);
		
		model.addAttribute("list", collectionService.getAllShowCollectionsByCache());
		model.addAttribute("size", collectionService.getAllShowCollectionsByCache().size());
		
		return "search/searchflow_adv";
	}

	@RequestMapping(value = "/searchCids",method=RequestMethod.GET)
	public String go2AdvanceSearchPageCidsFlow(HttpServletRequest request, ModelMap model){
		
		return "search/searchflow_cids";
	}
	
	@RequestMapping(value = "/group",method=RequestMethod.GET)
	public String go2SearchPageByGroup(HttpServletRequest request, ModelMap model){
		return "search/search";
	}
	
	@RequestMapping(value = "/hotKey.do")//,method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getHostKey(String hk, Integer num){
		int top = num==null ? 20:num.intValue();
		if(top>100) top = 100;
		List<Keywords> list = keywordService.getHotkeyList(hk, top);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		map.put("total", list.size());
		return map;
	}
	
	
	@RequestMapping(value = {"/search","/search1","/search2"},method=RequestMethod.GET)
	public String go2SearchPage(HttpServletRequest request, ModelMap model){
		return "search/searchflow";
	}
	
	@RequestMapping(value = {"/searchf"},method=RequestMethod.GET)
	public String go2SearchPageflow(HttpServletRequest request, ModelMap model){
		return "search/searchflow";
	}
	
	@RequestMapping(value = {"/searchfresult"},method=RequestMethod.GET)
	public String searchfresult(HttpServletRequest request,HttpServletResponse response, @ModelAttribute SearchCondition sc, ModelMap model){
		model.addAttribute("result", getSearch(request,response,sc));
		return "search/searchfresult";
	}
	
	@RequestMapping(value = {"/search.do","/search1.do","/search2.do"},method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> getSearch(HttpServletRequest request,HttpServletResponse response, @ModelAttribute SearchCondition sc){
		sc.init(request);
		String orgiKeyword = sc.getQ();
		User user = getSessionUser(request);
		RequestInfo requestInfo = RequestUtils.getContain();
		if(requestInfo==null){
			requestInfo = new RequestInfo(request, response);
			RequestUtils.setContain(requestInfo);
			RequestUtils.setUser(user);
		}
		if(sc.getGroupId()!=null && sc.getGroupId()>0){
			return imageGroupService.getImagesByGroup(request, sc.getGroupId(), sc.getP(), sc.getN());
		}
		else{
			String spl = request.getParameter("spl");
			if(StrUtils.isNotBlank(spl)){
				return imageGroupService.getImagesByCode(request, spl, sc.getP(), sc.getN());
			}
		}
		
		Map<String, Object> rstMap = new HashMap<String, Object>();
		// 返回结果列表
		List<PreviewImageInfo> rstList = null;
		List<PreviewImageInfo> allrstList = null;  //sean
		long t = SearchUtils.timeDebug(null, 0);
		long t1 = SearchUtils.timeDebug(null, 0);
//		String key = getStringValue(request, "key", "").trim();
//		String q = key;
//		String similarId = request.getParameter("smid");
//		searchLog.setSearchKey(key);
//		searchLog.addData("pageNo", pageNo);
//		searchLog.addData("pageSize", pageSize);
//		searchLog.addData("smid", similarId);
//		boolean isSimilar = StrUtils.isNotBlank(similarId);
		String content = null;
		try{
			String corbisIds = StrUtils.getNullStr(sc.getCorbisIds(), "");
			if(corbisIds.length()>0){ // 高级搜索中输入ID列表查询
				sc.getSearchLog().addData("corbisIds", corbisIds);
				String[] corbisIdsArr = getCorbisIds(corbisIds);
				rstList = searchService.getPreviewListByCorbisIds(corbisIdsArr);
				if(rstList.size()==0){
					sc.setIndex(1);	// 设置为首页，目的隐藏图片库真实数量
				}
			}
			else if(sc.isCorbisId(sc.getQ())){ // 搜索输入框中是corbisid格式
				String[] corbisIdsArr = getCorbisIds(sc.getQ());
				rstList = searchService.getPreviewListByCorbisIds(corbisIdsArr);
			}
			
			t = SearchUtils.timeDebug("尝试根据corbisid查询", t);
			
			if(rstList!=null){// && rstList.size()>0) || corbisIds.length()>0){
				sc.setSearchResult(new SearchResult());
				sc.getSearchResult().setTotal(rstList.size());
				// 分页
				rstList = sc.getRstListByPage(rstList);
			}
			else{
				// 处理指定首页(200条)
				if(sc.isIndex() && (sc.getP()*sc.getN())<=200){ // 在指定首页数据范围内
					String indexCorbisIds = variablesService.getVariablesValue("index_corbisids", "");
					if(indexCorbisIds.indexOf("\n")>=0){
						indexCorbisIds = indexCorbisIds.replaceAll("\n", ",");
					}
					String[] eles = indexCorbisIds.split(",");
					for(int i=0;i<eles.length;i++)
					{
						eles[i]=eles[i].trim();
					}
					if(eles.length>=(sc.getP()*sc.getN())){
						sc.setSearchResult(new SearchResult());
						sc.getSearchResult().setIds(Arrays.asList(eles));
						sc.getSearchResult().setTotal(SEARCH_NUM_BLANK);
						sc.getSearchResult().setCache(true);
					}
				}
				
				if(sc.getP()>1500){ // 计算换算后的页码
					// TODO 111111111
					setRelativePageNo(sc, 1500);
				}
				
				// 判断页码，从缓存中获取预存数据
				// 根据排序类型判断是否需要缓存前1000条并排序
				int sortType = getIntValue(request, "sortType", 0);
				if(sortType<=1 && !sc.isSimilar() && sc.getSearchResult()==null && SEARCH_SORT && (sc.getOffset()+sc.getN())<=CACHE_MAX_NUM){ // 在缓存区域
					searchCache(sc);
				}
				//seanif(2>1){  //sean
				if(sc.getSearchResult()==null){ // 普通请求

					searchRequest(sc, sc.getOffset(), sc.getN());
				}
				
				if(sc.getSearchResult().getTotal()>0){ // 有查询结果，从memcached中获取详细数据
					// rstList = searchService.getPreviewList(sc.getSearchResult().getIds(sc.getOffset(), sc.getN(), CACHE_NUM));
					//Sean @ 20150630
					rstList = searchService.getPreviewList_exceptGroupImages(sc.getSearchResult().getIds(sc.getOffset(), sc.getN(), CACHE_NUM));
					//rstList = searchService.getPreviewList_exceptGroupImages(sc.getSearchResult().getIds(sc.getOffset(), CACHE_NUM, CACHE_NUM), sc.getN());
				//	allrstList = searchService.getPreviewList_exceptGroupImages(sc.getSearchResult().getIds(sc.getOffset(),  CACHE_NUM, CACHE_NUM));
					t = SearchUtils.timeDebug("searchService处理", t);
				}
			}
//			searchLog.addData("total", sr.getTotal());
			rstMap.put("success", true);
			rstMap.put("total", sc.getSearchResult().getTotal());
			//rstMap.put("total", allrstList.size());
			rstMap.put("data", rstList);
			rstMap.put("totalPages", SearchUtils.getTotalPages(sc.getSearchResult().getTotal(), sc.getN()));
			//rstMap.put("totalPages", SearchUtils.getTotalPages(allrstList.size(), sc.getN()));
			rstMap.put("currentPage", sc.getP());
			rstMap.putAll(sc.getSearchResult().getExtendData());
			// 判断是否有澄清
			t = SearchUtils.timeDebug(null, t);
			if(StrUtils.isNotBlank(sc.getKey())){
				List<Clarification> claList = clarificationService.getListByName(sc.getKey());
				if(claList!=null && claList.size()>0){
					rstMap.put("claList", claList);
				}
			}
			
			// 设置日志
			if(user!=null){
				sc.getSearchLog().setUserId(user.getId());
			}
			
			String enable_lottery = variablesService.getVariablesValue("enable_lottery", "");
			String uerip = getRemoteHost(request);
			if(Integer.parseInt(enable_lottery)==1 && StrUtils.isBlank(sc.getSmid()) && sc.getP()==1){
				long t3 = SearchUtils.timeDebug(null, 0);
				LtAwards award = lotteryDrawService.doLuckyDraw(user, orgiKeyword, request.getRequestedSessionId(), uerip);
				if(award!=null){
					rstMap.put("lt", true);
					rstMap.put("lt_awardname", award.getName());
					rstMap.put("lt_awarddesc", award.getDescription());
					rstMap.put("lt_message", variablesService.getVariablesValue("lottery_message", ""));
				}
				t = SearchUtils.timeDebug("中奖耗时", t);
			}
			
			sc.getSearchLog().setCreateTime(new Date());
			sc.getSearchLog().setSearchKey(sc.getKey());
			sc.getSearchLog().addData("total", sc.getSearchResult().getTotal());
			final SearchService sservice = searchService;
			final SearchLog searchLog = sc.getSearchLog();
			// 保存搜索日志
			threadPoolTaskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					searchLog.setData();
					sservice.saveObject(searchLog);
				}
			});
		}
		catch (Exception e) {
			logger.error("搜索异常[q="+sc.getQ()+"][content="+content+"]：", e);
			rstMap.put("success", false);
		}
		t = SearchUtils.timeDebug("[q="+sc.getQ()+"][p="+sc.getP()+"][n="+sc.getN()+"]------------------------------------", t1);
		return rstMap;
	}
	
	private SearchResult searchRequest(SearchCondition sc, int offset, int limit){
		long t = SearchUtils.timeDebug("1===============请求搜索引擎开始...");
		if(sc.getSearchResult()==null){
			sc.setSearchResult(new SearchResult());
		}
		Map<String, Object> map = formatQueryParams(sc, offset, limit);
		sc.getSearchLog().addData(map);
		t = SearchUtils.timeDebug("1===获取相似图片关键字结束...", t);
		
		if(StrUtils.isNotBlank(sc.getSearchCorbisId())){
			List<String> ids = new ArrayList<String>();
			ids.add(sc.getSearchCorbisId());
			sc.setSearchResult(new SearchResult(1, ids));
			return sc.getSearchResult();
		}
		
		String content = null;
		
		long t1 = System.currentTimeMillis();
		try{
			String uri = sc.getRequest().getRequestURI();
			String images = "images2";
			if(uri.endsWith("search1.do")){
				images = "images1";
			}
			else if(uri.endsWith("search2.do")){
				images = "images1";
			}
			else if(uri.endsWith("search.do")){
				//sean images = "images1";
				images = "images";
			}
			map.put("solr_name", images);
			t = SearchUtils.timeDebug("post参数处理", t);
			String url = SearchUtils.genSearchUrl(map);
			t = SearchUtils.timeDebug("URL参数处理["+url+"]", t);
			content = HttpClientHelper.doGet(url);
//			content = HttpClientHelper.doPost(SearchUtils.getSearchUrl(), map);
			t = SearchUtils.timeDebug("searchUrl请求", t);
//			Map<String, Object> jsonMap = JsonFormat.toMap(content);
			SearchUtils.getSearchResultFromJson(content, sc.getSearchResult());
			t = SearchUtils.timeDebug("请求结果JSON处理", t);
//			sc.getSearchResult().setTotal(SearchUtils.getMapValue(jsonMap.get("num")));
			t = SearchUtils.timeDebug("获取JSON数据，准备service处理", t);
			if(sc.getSearchResult().getTotal()>0){
				if(sc.isIndex()){
					sc.getSearchResult().setTotal(SEARCH_NUM_BLANK);
				}
//				sc.getSearchResult().setDatas((List<Map<String, Object>>)jsonMap.get("data"));
			}
		}
		catch (Exception e) {
			logger.error("请求搜索引擎异常[q="+sc.getQ()+"][offset="+offset+", limit="+limit+"]：",e);
		}
		t = SearchUtils.timeDebug("1===============请求搜索引擎结束", t1);
		return sc.getSearchResult();
	}
	
	private void searchCache(SearchCondition sc){
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
				sr = searchRequest(sc, sc.getCacheStart(CACHE_NUM), CACHE_NUM);
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
	
	/**
	 * 澄清处理
	 * @param sc
	 */
	private void doClarification(SearchCondition sc){
		sc.getSearchLog().addData("cla", sc.getCla());
		List<Clarification> clarifications = clarificationService.getClarification(sc.getCla());
		if(clarifications!=null && clarifications.size()>0){
			if(clarifications.size()==1){
				Clarification clarification = clarifications.get(0);
				if(StrUtils.isNotBlank(clarification.getQueryKey())){
					sc.setQ(clarification.getQueryKey());
				}
			}
			else{
				StringBuilder sb = new StringBuilder();
				for(Clarification clarification : clarifications){
					if(sb.length()>0){
						sb.append(" OR ");
					}
					sb.append("(").append(clarification.getQueryKey()).append(")");
				}
				sc.setQ(sb.toString());
			}
		}
	}
	
	/**
	 * 根据查询规则，进行关键词替换
	 * @param operator
	 * @param list
	 * @param sc
	 * @return
	 */
	private StringBuilder doSearchRule(String operator, List<String> list, SearchCondition sc){
		StringBuilder sb = new StringBuilder();
		if(list==null || list.size()==0) return sb;
		if(operator.equalsIgnoreCase("and")){
			for(String s : list){
				if(s.length()==0) continue;
				if(sb.length()>0){
					sb.append(" AND ");
				}
				SearchRule rule = searchRuleService.getSearchRule(s.trim());
				if(rule!=null){
					if(StrUtils.isNotBlank(rule.getReplaceKey())){
						sb.append(rule.getReplaceKey().trim());
					}
					else{
						sb.append(s.trim());
					}
					if(StrUtils.isNotBlank(rule.getExcludeKey())){
						sc.appendFq(rule.getExcludeKey().trim());
					}
				}
				else{
					sb.append(SearchUtils.formatPhraseByQuote(s.trim()));
				}
			}
		}
		else if(operator.equalsIgnoreCase("or")){
			for(String s : list){
				if(s.length()==0) continue;
				if(sb.length()>0){
					sb.append(" OR ");
				}
				SearchRule rule = searchRuleService.getSearchRule(s.trim());
				if(rule!=null){
					if(StrUtils.isNotBlank(rule.getReplaceKey())){
						sb.append("(").append(rule.getReplaceKey().trim()).append(")");
					}
					else{
						sb.append(s.trim());
					}
					if(StrUtils.isNotBlank(rule.getExcludeKey())){
						sc.appendFq(rule.getExcludeKey().trim());
					}
				}
				else{
					sb.append(SearchUtils.formatPhraseByQuote(s.trim()));
				}
			}
		}
		else if(operator.equalsIgnoreCase("not")){
			for(String s : list){
				if(s.length()==0) continue;
				sc.appendFq(s.trim());
				SearchRule rule = searchRuleService.getSearchRule(s.trim());
				if(rule!=null){
					if(StrUtils.isNotBlank(rule.getExcludeKey())){
						String[] eles = rule.getExcludeKey().split(",");
						for(String ele : eles){
							if(sb.length()>0) sb.append(" AND ");
							sb.append(ele.trim());
						}
					}
				}
			}
		}
		else if(operator.equals(" ")){
			for(String s : list){
				if(sb.length()>0){
					sb.append(" ");
				}
				SearchRule rule = searchRuleService.getSearchRule(s.trim());
				if(rule!=null){
					if(StrUtils.isNotBlank(rule.getReplaceKey())){
						sb.append(rule.getReplaceKey());
					}
					else{
						sb.append(s.trim());
					}
					if(StrUtils.isNotBlank(rule.getExcludeKey())){
						sc.appendFq(rule.getExcludeKey().trim());
					}
				}
				else{
					sb.append(s.trim());
				}
			}
		}

		String temp = sb.toString();

		String n = temp.replaceAll("\"","");
		
		StringBuilder newsb = new StringBuilder(n);

		return newsb;
	}
	
	/**
	 * 对搜索条件进行预处理
	 * @param request
	 * @param q
	 * @param pageNo
	 * @param limit
	 * @return
	 */
	private Map<String, Object> formatQueryParams(SearchCondition sc, int offset, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean needFormatQ = true;	// 关键字是否需要再处理
		if(StrUtils.isNotBlank(sc.getQ())){ // 关键字处理
			try{
				// 1. 澄清
				if(needFormatQ && StrUtils.isNotBlank(sc.getCla())){
					doClarification(sc);
					needFormatQ = false;
				}
				
				
				
				// 2. 判断是否搜索为摄影师名、图库名
				// add by xcb.摄影师，图库不加入q搜索
//				if(needFormatQ){
//					ImageCollection collection = collectionService.getCollection(sc.getQ());
//					if(collection!=null){
//						map.put("collection_id", collection.getId());
//						sc.setQ("");
//						needFormatQ = false;
//					}
//					else{
//						Photographer photographer = photographerService.getByName(sc.getQ());
//						if(photographer!=null){
//							map.put("photographer", getUrlEncoder(sc.getQ()));
//							sc.setQ("");
//							needFormatQ = false;
//						}
//					}
//				}
				
				// 3. 关键字是否需要进行同义词处理、附加条件处理
				// 3.1 // 不包含"AND/OR/NOT"
				if(needFormatQ && !sc.containsOperator()){
					sc.parseNoOperatorKey(keywordCollectionService);
					if(sc.getKeysCount()<=5){ // 小于5个关键字，默认用AND操作
						sc.setQ(doSearchRule("AND", sc.getAndKeyList(), sc).toString());
					}
					else{
						sc.setQ(doSearchRule(" ", sc.getAndKeyList(), sc).toString());
						sc.getSearchResult().setExtendData("sand", 1);
					}
					needFormatQ = false;
				}
				// 3.2 包含运算符
				if(needFormatQ && sc.containsOperator()){
					sc.parseKey(sc.getQ());
					StringBuilder andSb = doSearchRule("AND", sc.getAndKeyList(), sc);
					StringBuilder orSb = doSearchRule("OR", sc.getOrKeyList(), sc);
					StringBuilder notSb = doSearchRule("NOT", sc.getNotKeyList(), sc);
					StringBuilder sb = new StringBuilder();
					if(andSb.length()>0){
						sb.append(andSb);
					}
					if(orSb.length()>0){
						if(sb.length()>0){
							sb.append(" OR ").append(orSb);
						}
						else{
							sb.append(orSb);
						}
					}
					if(notSb.length()>0){
						if(sb.length()>0){
							sb.append(" AND ").append(notSb);
						}
						else{
							sb.append(notSb);
						}
					}
					
					sc.setQ(sb.toString());
					needFormatQ = false;
				}
				
				// 添加search_words
				if(StrUtils.isNotBlank(sc.getQ())){
					
					map.put("search_words", getUrlEncoder(sc.getQ()));
					
					
					//关键字，并且相似. 
					if(StrUtils.isNotBlank(sc.getSmid())){
						String similarKey = getSimilarKey(sc);
						if(StrUtils.isNotBlank(similarKey)){
							similarKey = sc.getQ()+" AND "+similarKey;
							sc.setQ(similarKey);
							map.put("search_words", getUrlEncoder(sc.getQ()));
						}
					}
				}
			}
			catch (Exception e) {
				logger.error("处理关键字异常["+sc.getQ()+"]：", e);
				map.put("search_words", sc.getKey());
			}
		}
		else{ // 关键字为空
			// 1.相似搜索
			if(StrUtils.isNotBlank(sc.getSmid())){
				String similarKey = getSimilarKey(sc);
				if(StrUtils.isNotBlank(similarKey)){
					sc.setQ(similarKey);
					map.put("search_words", getUrlEncoder(sc.getQ()));
				}
				else{
					sc.setIndex(1);
					sc.setSearchCorbisId(sc.getSmid());
				}
			}
		}
		// 添加左侧条件
		
		// :~~添加前台自定义排除字段FQ
		String frExclude = getStringValue(sc.getRequest(), "exclude", null);
		if(StrUtils.isNotBlank(frExclude)){
			sc.appendFq(frExclude);
		}
		// 添加FQ
		if(sc.getFqBuilder().length()>0){
			map.put("fq", getUrlEncoder(sc.getFqBuilder().toString()));
		}
		
		
		setSearchParams(sc.getRequest(), "cate_id", map);
		setSearchParams(sc.getRequest(), "is_cd", map);
		setSearchParams(sc.getRequest(), "person_num", map);
		setSearchParams(sc.getRequest(), "sex", map);
		setSearchParams(sc.getRequest(), "age", map);
		setSearchParams(sc.getRequest(), "race", map);
		setSearchParams(sc.getRequest(), "color", map);
		setSearchParams(sc.getRequest(), "direction", map);
		setSearchParams(sc.getRequest(), "portrait", map);
		setSearchParams(sc.getRequest(), "style", map);
		setSearchParams(sc.getRequest(), "layout", map);
		setSearchParams(sc.getRequest(), "angle", map);
		setSearchParams(sc.getRequest(), "type", "photo_type", map);
		// 添加高级搜索条件
		setSearchParams(sc.getRequest(), "cid", "collection_id", map);
		setSearchParamsByUrlEncoder(sc.getRequest(), "photographerName", "photographer", map);
		setSearchParamsByUrlEncoder(sc.getRequest(), "locationName", "location", map);
		setSearchParams(sc.getRequest(), "immediateAvailablility", "max_size", map);
		
		// 添加排序
		setSearchParams(sc.getRequest(), "sortType", "order", map);
		
		// 添加拍摄时间条件
		KeyValue<Long, Long> photoKv = sc.getPhotoDate();
		if(photoKv!=null){
			map.put("photo_min_date", photoKv.getKey());
			map.put("photo_max_date", photoKv.getValue());
		}
		// 添加上线时间
		KeyValue<Long, Long> onlineKv = sc.getOnlineDate();
		if(onlineKv!=null){
			map.put("upload_time_min", onlineKv.getKey());
			map.put("upload_time_max", onlineKv.getValue());
		}
		// 添加供应商
		String providerName = sc.getRequest().getParameter("providerName");
		if(StrUtils.isNotBlank(providerName)){
			Integer providerId = contentProviderService.getProviderId(sc.getRequest().getParameter("providerName"));
			providerId = providerId==null ? -1:providerId;
			map.put("provider_id", providerId);
		}
		
		map.put("offset", offset);
		map.put("limit", limit);
		
		// 设置搜索日志
		sc.getSearchLog().addData(map);
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
	
	private void setSearchParamsByUrlEncoder(HttpServletRequest request, String paraName, String sendName, Map<String, Object> map){
		String value = request.getParameter(paraName);
		if(StrUtils.isNotBlank(value)){
			try{map.put(sendName, getUrlEncoder(value));}
			catch (Exception e) {
			}
		}
	}
	
	private String getSimilarKey(SearchCondition sc){
		sc.getSearchLog().addData("smid", sc.getSmid());
		ImageInfo similarInfo = searchService.getImageInfoByCorbisIdCache(sc.getSmid());
		ImageCollection collection = collectionService.getCollection(similarInfo.getCollectionId());
		String ext = collection.getExt();
		if(similarInfo!=null){ 
			ImageInfoExtend ie = baseService.get(ImageInfoExtend.class, similarInfo.getId());
			// 将相似搜索基准图片的缩略图信息加入SearchResult的extendData
			sc.getSearchResult().setExtendData("simUrl", SearchUtils.getImagePreviewUrl(sc.getSmid())+ext);
			sc.getSearchResult().setExtendData("simId", sc.getSmid());
			if(ie!=null && StrUtils.isNotBlank(ie.getShowKeyCh())){
				String[] eles = ie.getShowKeyCh().split("[|]");
				Set<String> keys = new HashSet<String>();
				List<String> list = new ArrayList<String>();
				for(String ele : eles){
					if(StrUtils.isBlank(ele)) continue;
					String gbStr = EncodeingHelper.convert2Gb(ele);
					if(!keys.contains(gbStr)){
						list.add(gbStr);
						keys.add(gbStr);
					}
				}
				String searchKey = formatSimilarKey(list, 15);
				return searchKey;
			}
		}
		return null;
	}
	
	private String formatSimilarKey(List<String> list, int validNum){
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i=0; i<list.size(); i++){
			String key = list.get(i);
			Keywords keywords = keywordService.getKeywords(key);
			if(keywords!=null && keywords.getShowStatus()==1){
				if(sb.length()>0){
					sb.append(" OR ").append(key);
				}
				else{
					sb.append(key);
				}
				count++;
				if(count>=validNum) break;
			}
		}
//		System.out.println("相似查询[list.size="+list.size()+", validNum="+validNum+"]：" + sb.toString());
		return sb.toString().trim();
	}
	
	
	private void setRelativePageNo(SearchCondition sc, Integer basePageNo){
		SearchResult sr = (SearchResult)sc.getRequest().getSession().getAttribute(CACHE_KEY);
		if(sr!=null){
			// 比较ssid是否相同，不同清空session
			if(!sc.getSsid().equals(sr.getSearchId())){ // ssid不同
				sr = null;
				sc.getRequest().getSession().setAttribute(CACHE_KEY, null);
			}
		}
		if(sr==null){
			sr = new SearchResult();
			sr.setSearchId(sc.getSsid());
		}
		Integer relativePageNo = sr.getRelativePageNo(sc.getP(), basePageNo);
		if(relativePageNo!=null){
			sc.setRelativePageNo(relativePageNo);
		}
		sc.getRequest().getSession().setAttribute(CACHE_KEY, sr);
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
	
	/**
	 * 判断查询条件是否为corbisid数组
	 * TODO : 可以用正则组来分割
	 * @param q
	 * @return
	 */
	private String[] getCorbisIds(String q){
//		if(q.length()<8) return null;
//		if(!q.matches(CORBISID_PARAMS)) return null;
		List<String> list = new ArrayList<String>();
		String tmpQ = q.toString();
		if(tmpQ.indexOf("\r\n")>=0){
			tmpQ = tmpQ.replaceAll("\r\n", ",");
		}
		if(tmpQ.indexOf("\n")>=0){
			tmpQ = tmpQ.replaceAll("\n", ",");
		}
		if(tmpQ.indexOf(" ")>=0){
			tmpQ = tmpQ.replace(" ", ",");
		}
		if(tmpQ.indexOf("，")>=0){
			tmpQ = tmpQ.replace("，", ",");
		}
		String[] eles = tmpQ.split(",");
		for(String ele : eles){
			ele = ele.trim();
//			if(ele.matches(CORBISID_REGEX)){
				list.add(ele);
//			}
		}
		return list.toArray(new String[]{});
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
	
	
	//Sean added for get group id and number
	@RequestMapping(value = {"/getgroupid.do"},method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> getGroupId(HttpServletRequest request, ModelMap modelMap){
		String corbisid=getStringValue(request, "corbisid", "");
		if(corbisid==null) return null;
		Map<String, Object> rstMap = new HashMap<String, Object>();
		
		try{
			List<Integer> groupids = imageGroupService.getImageGroupIdList(corbisid);
			if(groupids.size()!=0 && !groupids.isEmpty() && groupids!=null){
				int groupid = imageGroupService.getImageGroupIdList(corbisid).get(0);
				rstMap.put("groupid", groupid);
				rstMap.put("number", imageGroupService.getImageGroupAmount(groupid));
				return rstMap;
			}
			else{
				return null;
			}
		}
		catch (Exception e) {
			logger.error("获取图片组id异常[corbisid="+corbisid+"]：", e);
		}
		return null;
	}
	
    private String getRemoteHost(javax.servlet.http.HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }

	
	
}
