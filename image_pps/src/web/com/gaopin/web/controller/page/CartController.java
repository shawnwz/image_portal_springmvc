/* This file LightBoxController.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.web.controller.page;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.ListView;

import org.apache.poi.util.ArrayUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gaopin.constants.Constants;
import com.gaopin.constants.Constants.SizeType;
import com.gaopin.constants.Constants.UserPrivilegeType;
import com.gaopin.entity.ImageGroup;
import com.gaopin.entity.ImageGroupImage;
import com.gaopin.entity.FrCart;
import com.gaopin.entity.LightBox;
import com.gaopin.entity.LightBoxRel;
import com.gaopin.entity.PreviewImageInfo;
import com.gaopin.entity.PreviewMotionInfo;
import com.gaopin.entity.User;
import com.gaopin.entity.UserPrivilege;
import com.gaopin.exception.ServiceException;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.service.pps.BatchDownloadService;
import com.gaopin.service.pps.DownloadService;
import com.gaopin.service.pps.ImageGroupService;
import com.gaopin.service.pps.CartService;
import com.gaopin.service.pps.SearchService;
import com.gaopin.service.pps.UserPrivilegeService;
import com.gaopin.service.pps.UserService;
import com.gaopin.service.pps.VariablesService;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.KeyValue;
import com.gaopin.utils.MD5;
import com.gaopin.utils.SearchUtils;
import com.gaopin.utils.StrUtils;
import com.gaopin.utils.mail.MailSender;
import com.gaopin.web.controller.BaseController;
import com.gaopin.web.utils.RequestUtils;
import com.mchange.v1.util.ArrayUtils;

@Controller
public class CartController extends BaseController {
@Resource 
private DownloadService downloadService;
	@Resource
	private UserService userService;
	@Resource
	private SearchService searchService;
	@Resource
	private CartService cartService;
	@Resource
	private ImageGroupService imageGroupService;
	@Resource
	private BatchDownloadService batchDownloadService;
	@Resource
	private UserPrivilegeService userPrivilegeService;
	@Resource
	VariablesService variablesService;

	@Resource
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@RequestMapping(value = { "/my/getcartitems" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getCartItems(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			List<PreviewImageInfo> imagePreviewInfo = new ArrayList<PreviewImageInfo>();
			List<PreviewMotionInfo> motionPreviewInfo = new ArrayList<PreviewMotionInfo>();
			
			List<FrCart> cartitems = cartService.getListByUser(user.getId(), 0);
			Map<String, PreviewImageInfo> imagemap = new HashMap<String, PreviewImageInfo>();
			Map<String, PreviewMotionInfo> motionmap = new HashMap<String, PreviewMotionInfo>();
			if(cartitems.size()>0){
				List<String> imageids = new ArrayList<String>();
				List<String> motionids = new ArrayList<String>();
				for (FrCart c : cartitems) {
					if(StrUtils.getMediaType(c.getGaopinId()).equals("image")){
						imageids.add(c.getGaopinId());
					}else if(StrUtils.getMediaType(c.getGaopinId()).equals("motion")){
						motionids.add(c.getGaopinId());
					}
				}
				
				if(imageids.size()>0){
					imagePreviewInfo = searchService.getPreviewListSplashEnable(imageids);
					for(PreviewImageInfo pre:imagePreviewInfo){
						imagemap.put(pre.getCorbisId(), pre);
					}
					
					
					
				}
				
				if(motionids.size()>0){
					
					
				}
				
				ret.put("data", cartitems);
				ret.put("images", imagemap);
				ret.put("motions", motionmap);
				
			}
									
		}
		return ret;
	}

	@RequestMapping(value = { "/my/addtocart" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addToCart(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			String gaopinId = getStringValue(request, "gaopinId", "");
			//int key = getIntValue(request, "key", 0);
			//String name = getStringValue(request, "name", "");
			if(StrUtils.isNotBlank(gaopinId)){
				FrCart cart = cartService.addCart(user.getId(), gaopinId);
				ret.put("data", cart);
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/getcartitemscount" }, method = RequestMethod.POST)
	@ResponseBody
	public int getCartItemsCount(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			int key = getIntValue(request, "key", 0);
			int count = cartService.getCartItemCount(user.getId());
			return count;
		}
		return 0;
	}

	@RequestMapping(value = { "/my/removefromcart" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> removeCartItems(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
			
		} else {
			//int key = getIntValue(request, "key", 0);
			//LightBox father = lightBoxService.getLightBox(key);
			String gaopinId = getStringValue(request, "gaopinId", "");
			if(StrUtils.isNotBlank(gaopinId)){
				cartService.deleteCart(user.getId(), gaopinId);
				ret.put("msg", "success");
			}else{
				ret.put("error", 400);
				return ret;
			}
		}
		return ret;
	}
	
	

}
