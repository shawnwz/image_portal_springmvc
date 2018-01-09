/* This file InnerController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.cache.CacheService;
import com.gaopin.entity.Clarification;
import com.gaopin.entity.ImageCollection;
import com.gaopin.entity.KeywordCollection;
import com.gaopin.entity.Keywords;
import com.gaopin.entity.SearchRule;
import com.gaopin.entity.SystemVariables;
import com.gaopin.entity.LtIpExclusive;
import com.gaopin.service.pps.ClarificationService;
import com.gaopin.service.pps.CollectionService;
import com.gaopin.service.pps.KeywordCollectionService;
import com.gaopin.service.pps.KeywordService;
import com.gaopin.service.pps.SearchRuleService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.service.pps.LotteryDrawService;
import com.gaopin.utils.StrUtils;
import com.gaopin.web.controller.BaseController;
/**
 * 内部调用接口，所有路径需要包含/inner/，经过过滤器进行IP验证
 * @author xcb
 *
 */
@Controller
public class InnerController extends BaseController {
	
	@Resource
	private CacheService cacheService;
	@Resource
	private SearchRuleService searchRuleService;
	@Resource
	private ClarificationService clarificationService;
	@Resource
	private CollectionService collectionService;
	@Resource
	private KeywordService keywordService;
	@Resource
	private VariablesService variablesService;
	@Resource
	private KeywordCollectionService keywordCollectionService;
	@Resource
	private LotteryDrawService lotteryDrawService;
	@RequestMapping(value = "/inner/compress.do",method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> compressBatchFile(HttpServletRequest request){
		
		return null;
	}
	
	//sean
	@RequestMapping(value = "/inner/clearCache.do")
	@ResponseBody
	public Map<String, Object> clearCache(HttpServletRequest request){
		String cacheKey = request.getParameter("cacheKey");
		if(StrUtils.isNotBlank(cacheKey)){
			logger.info("后台清除本地缓存：cacheKey="+cacheKey);
			cacheService.removeLocalLong(cacheKey);
			cacheService.removeLocalMedium(cacheKey);
			cacheService.removeLocalShort(cacheKey);
		}
		
		String loadName = request.getParameter("loadName"); // 全表载入
		logger.info("后台请求，重新载入数据库：cacheKey="+loadName);
		if(StrUtils.isNotBlank(loadName)){
			if(loadName.equals(SearchRule.class.getName())){	// 查询规则
				searchRuleService.loadAll();
			}
			else if(loadName.equals(KeywordCollection.class.getName())){	// 英文关键词
				keywordCollectionService.loadAll();
			}
			else if(loadName.equals(Clarification.class.getName())){	// 澄清
				clarificationService.loadAll();
			}
			else if(loadName.equals(ImageCollection.class.getName())){	// 图片库
				collectionService.loadAll();
			}
			else if(loadName.equals(Keywords.class.getName())){	// 关键词库
				keywordService.loadAll();
			}
			else if(loadName.equals(SystemVariables.class.getName())){	// 系统关键词表
				variablesService.loadAll();
			}
			else if(loadName.equals(LtIpExclusive.class.getName())){	// lottery exclusive ip list
				lotteryDrawService.loadExclusiveIpList();
			}
		}
		return null;
	}
}
