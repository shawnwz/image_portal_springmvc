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
import com.gaopin.service.pps.LightBoxService;
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
public class LightBoxController extends BaseController {
@Resource 
private DownloadService downloadService;
	@Resource
	private UserService userService;
	@Resource
	private SearchService searchService;
	@Resource
	private LightBoxService lightBoxService;
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

	@RequestMapping(value = { "/my/addlightbox" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addlightbox(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			int key = getIntValue(request, "key", 0);
			String name = getStringValue(request, "name", "");
			if (StrUtils.isNotBlank(name)) {
				if (key > 0) {
					LightBox father = lightBoxService.getLightBox(key);
					System.out.println(father.getOwnerId() + ", "
							+ user.getId());
					if (father.getOwnerId().intValue() != user.getId()
							.intValue()) {// user.getId().intValue())
						ret.put("error", 401);
						return ret;
					}
				}
				LightBox item = lightBoxService.addBox(user.getId(),
						user.getUserName(), name, key);
				ret.put("data", item);
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/setlightboxfather" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> setlightboxfather(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			int key = getIntValue(request, "key", 0);
			int fid = getIntValue(request, "fid", 0);
			if (key > 0) {
				LightBox item = lightBoxService.getLightBox(key);
				if (item.getOwnerId() == user.getId().intValue()) {
					item = lightBoxService.setBoxFather(key, fid);
					ret.put("data", item);
				} else {
					ret.put("error", 401);
				}
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/setlightboxmemo" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> setlightboxmemo(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			int key = getIntValue(request, "key", 0);
			LightBoxRel rel = lightBoxService.getLightBoxItem(key);
			if (rel == null) {
				ret.put("error", 400);
				return ret;
			}
			LightBox father = lightBoxService.getLightBox(rel.getBoxId());
			if (father == null) {
				ret.put("error", 400);
				return ret;
			}
			if (father.getOwnerId() != (user.getId().intValue())) {
				ret.put("error", 401);
				return ret;
			}
			String memo = getStringValue(request, "memo", "");
			if (key > 0) {
				LightBoxRel item = lightBoxService.SetBoxItem(key, memo);
				ret.put("data", item);
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/addlightboximagesdownload" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addlightboximagesdownload(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
			
		} else {
			int key = getIntValue(request, "key", 0);
			LightBox father = lightBoxService.getLightBox(key);
			if (father == null) {
				ret.put("error", 400);
				return ret;
			}
			if (father.getOwnerId() != (user.getId().intValue())) {
				ret.put("error", 401);
				return ret;
			}
			
			if (key > 0) {
				List<LightBoxRel> items = new ArrayList<LightBoxRel>();
				items=lightBoxService.getListByBox(key);
				List<String> cids=new ArrayList<String>();
				for (LightBoxRel lightBoxRel : items) {
					cids.add(lightBoxRel.getCorbisId());
				}
				List<PreviewImageInfo> images=searchService.getPreviewListSplashEnable(cids);
				List<UserPrivilege> userps=userPrivilegeService.getPrivilegeList(user.getId());
				HashMap<Integer, UserPrivilege> map=new HashMap<Integer, UserPrivilege>();
				for (UserPrivilege userPrivilege : userps) {
					if(userPrivilege.getType()==Constants.UserPrivilegeType.QP.ordinal())
						map.put(userPrivilege.getCollectionId(), userPrivilege);
				}
				
				
				List<Integer> sizes=new ArrayList<Integer>();
				List<SizeType> sizets=new ArrayList<SizeType>();
				cids=new ArrayList<String>();
				
				for (PreviewImageInfo imageInfo : images) {
					UserPrivilege userPrivilege = map.get(imageInfo.getCollectionId());
					if(userPrivilege==null){
						// Sean
						cids.add(imageInfo.getCorbisId());
						userPrivilege = new UserPrivilege();
						//userPrivilege.setSizeId(SizeType.SUPERMARK.getSizecode());
						userPrivilege.setSizeId(SizeType.PREVIEW.getSizecode());
						sizes.add(userPrivilege.getSizeId());
						sizets.add(SizeType.getEnum(userPrivilege.getSizeId()));
						continue;
					}
					cids.add(imageInfo.getCorbisId());
					sizes.add(userPrivilege.getSizeId());
					sizets.add(SizeType.getEnum(userPrivilege.getSizeId()));
				}
				logger.info("corbisids:"+ StrUtils.join(cids.toArray()));
				logger.info("sizes:"+ StrUtils.join(sizes.toArray()));
				
				KeyValue<Boolean, String> retKeyValue=batchDownloadService.compressImages(user.getId(),
						cids, sizes, 
						father.getId()+".lightbox.zip", DateUtils.addHours(new Date(),24), "searchresult.lightbox");
				if(retKeyValue.getKey())
				{
					ret.put("url", retKeyValue.getValue());
					////////////////////////////////////////////////
					//log. 
					try {
						downloadService.recordDownloadLog(images.toArray(new PreviewImageInfo[]{}), sizets.toArray(new SizeType[]{}), user, UserPrivilegeType.QP);
					} catch (Exception e) {
						logger.info("log batch download error . ");
						e.printStackTrace();
					}
					
				}
				else {
					ret.put("error", 500);
					ret.put("url", retKeyValue.getValue());
				}
				
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}
	
	
	@RequestMapping(value = { "/my/addlightboximagesfromimagegroup" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addlightboximagesfromimagegroup(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			int key = getIntValue(request, "key", 0);
			LightBox father = lightBoxService.getLightBox(key);
			if (father == null) {
				ret.put("error", 400);
				return ret;
			}
			if (father.getOwnerId() != (user.getId().intValue())) {
				ret.put("error", 401);
				return ret;
			}

			Integer groupid = getIntValue(request, "groupid", 0);
			
			/////////////////////////
			//for splash 
			String groupString=getStringValue(request, "groupid", "");
			if(!StrUtils.isNumeric(groupString)&&groupid.intValue()==0){
				ImageGroup group=imageGroupService.getImageGroupByCode(groupString.trim());
				if(group!=null)
					groupid=group.getId();
			}
			/////////////////////////
			
			if (key > 0 &&groupid>0) {
				List<String> ids = new ArrayList<String>();
				List<String> corbisIds= imageGroupService.getImageGroupImageList(groupid);
				for (String corbisId : corbisIds) {
					LightBoxRel item = lightBoxService.addBoxItem(key, corbisId);
					ids.add(corbisId);
				}
				List<PreviewImageInfo> mapList = searchService
						.getPreviewListSplashEnable(ids);
				if (mapList != null && mapList.size() > 0)
					ret.put("map", mapList.get(0));
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/addlightboximagesdetailpage2del" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addlightboximagesdetailpage2del(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			LightBox father = lightBoxService.getListByUser(user.getId(),0).get(0);
			if (father == null) {
				ret.put("error", 400);
				return ret;
			}
			if (father.getOwnerId() != (user.getId().intValue())) {
				ret.put("error", 401);
				return ret;
			}

			String corbisId = getStringValue(request, "corbisId", "");
			if (StrUtils.isNotBlank(corbisId)) {
				LightBoxRel item = lightBoxService.addBoxItem(father.getId(), corbisId);
				ret.put("data", item);
				List<String> ids = new ArrayList<String>();
				ids.add(corbisId);
//				if(SearchUtils.isSplashId(corbisId)){
//					if(corbisId.indexOf("_")<0){
//						List<PreviewImageInfo> mapList = searchService
//								.getPreviewListBySplash(ids,SearchUtils.getSplashCorbisId(corbisId));
//						if (mapList != null && mapList.size() > 0)
//							ret.put("map", mapList.get(0));
//					}
//					else{
//					}
//				}else 
				{
					List<PreviewImageInfo> mapList = searchService
							.getPreviewListSplashEnable(ids);
					if (mapList != null && mapList.size() > 0)
						ret.put("map", mapList.get(0));
				}
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}
	
	
	@RequestMapping(value = { "/my/addlightboximages" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addlightboximages(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			int key = getIntValue(request, "key", 0);
			LightBox father = lightBoxService.getLightBox(key);
			if (father == null) {
				ret.put("error", 400);
				return ret;
			}
			if (father.getOwnerId() != (user.getId().intValue())) {
				ret.put("error", 401);
				return ret;
			}

			String corbisId = getStringValue(request, "corbisId", "");
			try {
				if (key > 0 && StrUtils.isNotBlank(corbisId)) {
					 
					LightBoxRel item = lightBoxService.addBoxItem(key, corbisId);
	
					ret.put("data", item);
					List<String> ids = new ArrayList<String>();
					ids.add(corbisId);
					
	//				if(SearchUtils.isSplashId(corbisId)){
	//					if(corbisId.indexOf("_")<0){
	//						List<PreviewImageInfo> mapList = searchService
	//								.getPreviewListBySplash(ids,SearchUtils.getSplashCorbisId(corbisId));
	//						if (mapList != null && mapList.size() > 0)
	//							ret.put("map", mapList.get(0));
	//					}
	//					else{
	//					}
	//				}else 
					{
						List<PreviewImageInfo> mapList = searchService
								.getPreviewListSplashEnable(ids);
						if (mapList != null && mapList.size() > 0)
							ret.put("map", mapList.get(0));
					}
					
					
				} else {
					ret.put("error", 400);
				}
			} catch (Exception e) {
				ret.put("error", 600);//图片已在当前图库
			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/dellightboximages" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dellightboximages(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			String key = getStringValue(request, "key", "0");
			int lightBoxId = getIntValue(request, "lightBoxId", 0);
			if (!StrUtils.equals(key, "0")) {
				LightBoxRel rel = null;
				if(lightBoxId>0)
				{
					//key :corbisid
					 rel = lightBoxService.getLightBoxItem(key,lightBoxId);
				}
				else {
					//key :boxrelId
					 rel = lightBoxService.getLightBoxItem(Integer.parseInt(key));
				}
				if (rel == null) {
					ret.put("error", 400);
					return ret;
				}
				LightBox father = lightBoxService.getLightBox(rel.getBoxId());
				if (father == null) {
					ret.put("error", 400);
					return ret;
				}
				if (father.getOwnerId() != (user.getId().intValue())) {
					ret.put("error", 401);
					return ret;
				}

				lightBoxService.delBoxItem(rel.getId());
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/dellightbox" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> dellightbox(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			int key = getIntValue(request, "key", 0);
			if (key > 0) {
				LightBox father = lightBoxService.getLightBox(key);
				if (father == null) {
					ret.put("error", 400);
					return ret;
				}
				if (father.getOwnerId() != (user.getId().intValue())) {
					ret.put("error", 401);
					return ret;
				}

				lightBoxService.delBox(key);
			} else {
				ret.put("error", 400);
			}
		}
		return ret;
	}


	
	
	@RequestMapping(value = { "/my/getlightboxitems" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getlightboxitems(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			List<PreviewImageInfo> lightsValue = new ArrayList<PreviewImageInfo>();
			List<PreviewMotionInfo> lightsValue_motioin = new ArrayList<PreviewMotionInfo>();
			int key = getIntValue(request, "key", 0);
			if (key > 0) {
				LightBox father = lightBoxService.getLightBox(key);
				if (father == null) {
					ret.put("error", 400);
					return ret;
				}
				if (father.getOwnerId() != (user.getId().intValue())) {
					ret.put("error", 401);
					return ret;
				}

				List<LightBoxRel> list = lightBoxService.getListByBox(key);
				List<String> ids = new ArrayList<String>();
				for (LightBoxRel lbr : list) {
					ids.add(lbr.getCorbisId());
				}
				lightsValue = searchService.getPreviewListSplashEnable(ids);
				Map<String, PreviewImageInfo> map = new HashMap<String, PreviewImageInfo>();

				for (PreviewImageInfo preview : lightsValue) {
					map.put(preview.getCorbisId(), preview);
				}

				ret.put("map", map);
				ret.put("data", list);

			}
		}
		return ret;
	}

	@RequestMapping(value = { "/my/getlightboxeslist" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getlightboxeslist(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		int key = getIntValue(request, "key", 0);// 0时间 1名字
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			List<LightBox> list = lightBoxService.getListByUser(user.getId(),
					key);
			Map<Integer, List<LightBox>> formatlist = new HashMap<Integer, List<LightBox>>();
			if (list != null && list.size() == 0) {
				LightBox lb0 = lightBoxService.addBoxDefault(user.getId(),
						user.getUserName());
				list.add(lb0);
			}

			for (LightBox lb : list) {
				if (lb.getOwnerId() == (user.getId().intValue())) {
					if (!formatlist.containsKey(lb.getParentId())) {
						formatlist.put(lb.getParentId(),
								new ArrayList<LightBox>());
					}
					formatlist.get(lb.getParentId()).add(lb);
				}
			}
			List<LightBox> lightsValue = new ArrayList<LightBox>();
			List<LightBox> father0list = formatlist.get(0);
			for (LightBox f0lb : father0list) {
				lightsValue.add(f0lb);
				if (formatlist.containsKey(f0lb.getId())) {
					lightsValue.addAll(makeLightsValuesList(formatlist,
							f0lb.getId(), 1));
				}
			}
			ret.put("data", lightsValue);

		}
		// 灯箱列表ok .
		return ret;
	}

	@RequestMapping(value = { "/my/getlightboxes" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getlightboxes(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("error", 0);
		User user = getSessionUser(request);
		if (user == null || user.getId() <= 0) {
			ret.put("error", 401);
		} else {
			List<LightBox> list = lightBoxService
					.getListByUser(user.getId(), 0);
			Map<Integer, List<LightBox>> formatlist = new HashMap<Integer, List<LightBox>>();
			if (list != null && list.size() == 0) {
				LightBox lb0 = lightBoxService.addBoxDefault(user.getId(),
						user.getUserName());
				list.add(lb0);
			}

			for (LightBox lb : list) {
				if (lb.getOwnerId() == (user.getId().intValue())) {
					if (!formatlist.containsKey(lb.getParentId())) {
						formatlist.put(lb.getParentId(),
								new ArrayList<LightBox>());
					}
					formatlist.get(lb.getParentId()).add(lb);
				}
			}
			List<KeyValue<Integer, String>> lightsValue = new ArrayList<KeyValue<Integer, String>>();
			List<LightBox> father0list = formatlist.get(0);
			for (LightBox f0lb : father0list) {
				lightsValue.add(new KeyValue(f0lb.getId(), f0lb.getName()));
				if (formatlist.containsKey(f0lb.getId())) {
					lightsValue.addAll(makeLightsValues(formatlist,
							f0lb.getId(), 1));
				}
			}
			ret.put("data", lightsValue);

		}
		// 灯箱列表ok .
		return ret;
	}

	private List<KeyValue<Integer, String>> makeLightsValues(
			Map<Integer, List<LightBox>> formatlist, Integer curfid, int level) {
		List<KeyValue<Integer, String>> lightsValue = new ArrayList<KeyValue<Integer, String>>();
		List<LightBox> sonlist = formatlist.get(curfid);
		String pre = "";
		for (int i = 0; i < level; i++)
			pre += "&gt;";
		for (LightBox sonlb : sonlist) {
			lightsValue.add(new KeyValue(sonlb.getId(), pre + sonlb.getName()));
			if (formatlist.containsKey(sonlb.getId())) {
				lightsValue.addAll(makeLightsValues(formatlist, sonlb.getId(),
						level + 1));
			}
		}
		return lightsValue;
	}

	private List<LightBox> makeLightsValuesList(
			Map<Integer, List<LightBox>> formatlist, Integer curfid, int level) {
		List<LightBox> lightsValue = new ArrayList<LightBox>();
		List<LightBox> sonlist = formatlist.get(curfid);
		String pre = "";
		for (int i = 0; i < level; i++)
			pre += "&gt;";
		for (LightBox sonlb : sonlist) {
			lightsValue.add(sonlb);
			if (formatlist.containsKey(sonlb.getId())) {
				lightsValue.addAll(makeLightsValuesList(formatlist,
						sonlb.getId(), level + 1));
			}
		}
		return lightsValue;
	}
	
	
	@RequestMapping(value = {"/anounymous/lightbox","/public/lightbox"})
	public String public_lightbox(HttpServletRequest request, ModelMap model) {
		List<PreviewImageInfo> lightsValue = new ArrayList<PreviewImageInfo>();
		String key = getStringValue(request, "code", "");
			LightBox box = lightBoxService.getLightBox(key);
			if (box != null) {
				model.addAttribute("box", box);
				List<LightBoxRel> list = lightBoxService.getListByBox(box.getId());
				logger.info("public_lightbox"+key+"\t\t"+list.size()+"items");
				
				List<String> ids = new ArrayList<String>();
				for (LightBoxRel lbr : list) {
					ids.add(lbr.getCorbisId());
				}
				lightsValue = searchService.getPreviewListSplashEnable(ids);
				Map<String, LightBoxRel> map = new HashMap<String, LightBoxRel>();
				for (LightBoxRel preview : list) {
					map.put(preview.getCorbisId(), preview);
				}
				
				for (PreviewImageInfo preview : lightsValue) {
					LightBoxRel rel=map.get(preview.getCorbisId());
					preview.setCaption("");
					if(rel!=null&&rel.getMemo()!=null)
						preview.setCaption(rel.getMemo());
				}
				
//				Map<String, PreviewImageInfo> map = new HashMap<String, PreviewImageInfo>();
//				for (PreviewImageInfo preview : lightsValue) {
//					map.put(preview.getCorbisId(), preview);
//				}
//				for (LightBoxRel lbr : list) {
//					if(!map.containsKey(lbr.getCorbisId()))
//						list.remove(lbr);
//				}
				
				model.addAttribute("user",userService.get(User.class, box.getOwnerId()) );
//				model.addAttribute("map", map);
				model.addAttribute("data", lightsValue);
				model.addAttribute("en",true);
			}
			return "page/publiclightbox";
	}
	
	
	// author:Peter delelightboximg
	@RequestMapping(value = { "/my/delelightboximg" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleLightBoxImg(HttpServletRequest request) {
		lightBoxService.delBoxImgByBoxIDAndCorbisId(
				getIntValue(request, "box", 0),
				getStringValue(request, "id", "0"));
		return null;
	}

	// author:Peter updateImgMemo 
	@RequestMapping(value = { "/my/updateImgMemo" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateImgMemo(HttpServletRequest request) {
		lightBoxService.SetBoxItem(getIntValue(request, "id", 0),
				getStringValue(request, "memo", ""));
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("msg", "修改成功");
		return msg;
	}

	// author:Peter sendEmail
	@RequestMapping(value = { "/my/sendEmail" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendEmail(HttpServletRequest request) {
		Map<String, Object> msg = new HashMap<String, Object>();
		if (getSessionUser(request) != null) {
			final String[] emailAddress = getStringValue(request, "accepter",
					"Gaopin").split(";");
			String localPpath = getStringValue(request, "localPpath",
					"http://www.gaopinimages.com/");
			try {
				final String emailContent=variablesService.getVariables("mail_send_lightboxToEmail").getValue();
				final String content=emailContent.replace("#localPpath", localPpath)
				.replace("#msg", getStringValue(request, "msg", "这是一个消息")	)
				.replace("#url",  getStringValue(request, "url", "http://www.gaopinimages.com/"));
				final String title=getStringValue(request, "title", "Gaopin");
				threadPoolTaskExecutor.execute(new Runnable() {
					@Override
					public void run() {
					try {
						MailSender.sendMail(title
								,content,emailAddress);
						
						variablesService.mailLog("Mail",title,content,emailAddress,"");
					} catch (Exception e) {
						e.printStackTrace();
					}
					}
				});
				
				
				/*MailSender.sendMail(
						getStringValue(request, "title", "Gaopin"),
						"<div align=\"left\"> <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"513\">"
        +"<tbody><tr><td bgcolor=\"#8B8E85\" width=\"9\">&nbsp;</td><td bgcolor=\"#8B8E85\" width=\"485\"><a href=\""
        +localPpath
        +" target=\"_blank\"><img border=\"0\" src=\""+localPpath+"images/logo.png"+"\" width=\"236\" height=\"59\"></a></td>"
        +"<td bgcolor=\"#8B8E85\" width=\"23\">&nbsp;</td></tr><tr><td colspan=\"3\" bgcolor=\"#61635D\">&nbsp;</td></tr>"
        +"<tr><td>&nbsp;</td><td><span style=\"font-size: 10pt; font-family: Verdana; color: #61635D\">"
        + getStringValue(request, "msg", "这是一个消息")	+"	<p>Gaopin专业授权网站上的一个灯箱已经转发给您。如要访问该灯箱内的图片，请单击下列URL："
		+"</p><p><a style=\"color: #61635D\" href=\""
        +getStringValue(request, "url", "baidu.com")+"\" target=\"_blank\">"
        + getStringValue(request, "url", "http://www.gaopinimages.com/")+"</a></p><p>您不是会员，可以用此链接查看、保存备注及发送灯箱。要创建、发送和分享新灯箱，非会员必须在<a style=\"color: #61635D\" href=\""
		+localPpath+"registpage"+"\" target=\"_blank\">"+	localPpath+"registpage"+"</a>注册。"	
        +"</p><p>	如您无法直接打开电子邮件中的链接，可以复制URL，将其粘贴到浏览器中。  </p></span></td> </tr> <tr><td colspan=\"3\"><p align=\"center\"> <img src=\""
		+localPpath+"/images/div.gif\" width=\"500\" height=\"12\">"
		+" </p></td></tr> </tbody></table></div>",
						emailAddress);*/
				msg.put("msg", "发送成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block     /images/div.gif
				msg.put("msg", "发送失败");
				e.printStackTrace();
			}

		} else {
			msg.put("msg", "发送失败");
		}

		return msg;
	}

	// author:Peter getcode
	@RequestMapping(value = { "/my/getcode" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getCode(HttpServletRequest request) {
		Map<String, Object> msg = new HashMap<String, Object>();
		if (getSessionUser(request) != null) {
			int boxId = getIntValue(request, "boxid", 0);

			try {
				LightBox entity = lightBoxService.get(LightBox.class, boxId);
				msg.put("code", entity.getCodeKey());
				msg.put("msg", "成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				msg.put("code", 0);
				msg.put("msg", "失败");
			}

		} else {
			msg.put("msg", "发送失败");
		}

		return msg;
	}
	
	
	// author:Peter checkuser
	@RequestMapping(value = { "/my/checkuser" }, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkUser(HttpServletRequest request) {
		Map<String, Object> msg = new HashMap<String, Object>();
		if (getSessionUser(request) != null) {
			String name = getStringValue(request, "user", "");
			if(userService.isExist(name)){
				msg.put("code", 1);
				msg.put("msg", "存在");
			}else{
				msg.put("code", 0);
				msg.put("msg", "不存在");
			}
		} else {
			msg.put("msg", "发送失败");
			msg.put("code",-1);
		}
		return msg;
	}
	
	// author:Peter shiftlightbox
		@RequestMapping(value = { "/my/shiftlightbox" }, method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> shiftLightBox(HttpServletRequest request) {
			Map<String, Object> msg = new HashMap<String, Object>();
			if (getSessionUser(request) != null) {
				int boxId = getIntValue(request, "boxid", 0);//boxid
				String[] userIds = getStringValue(request, "userid", "").split(";");//userids
				for (int i = 0; i < userIds.length; i++) {
					try {
						User userEntity=userService.getUserByLoginName(userIds[i]);
						if(null!=userEntity){
							LightBox boxEntity=lightBoxService.get(LightBox.class, boxId);
							boxEntity.setOwnerId(userEntity.getId());
							boxEntity.setId(0);
							lightBoxService.saveObject(boxEntity);
							List<LightBoxRel> list=lightBoxService.getListByBox(boxId);
							for (int j = 0; j < list.size(); j++) {
								lightBoxService.addBoxItem(boxEntity.getId(), list.get(j).getCorbisId());
							}
							msg.put("code", 1);
							msg.put("msg", "成功");
						}
					} catch (Exception e) {
						e.printStackTrace();
						msg.put("code", 0);
						msg.put("msg", "移动失败");
						return msg;
					}
				}
					
			} else {
				msg.put("msg", "发送失败");
				msg.put("code",-1);
			}
			return msg;
		}
		
		
		
		// author:Peter updateboxname
				@RequestMapping(value = { "/my/updateboxname" }, method = RequestMethod.POST)
				@ResponseBody
				public Map<String, Object> updateBoxName(HttpServletRequest request) {
					Map<String, Object> msg = new HashMap<String, Object>();
					if (getSessionUser(request) != null) {
						int boxId = getIntValue(request, "boxid", 0);//boxid
						String newBoxName = getStringValue(request, "boxname", "我的灯箱");//boxname
						if(newBoxName.equals("我的灯箱")){
							msg.put("code", 0);
							msg.put("msg", "修改失败");
							return msg;
						}
						
						LightBox currentLightBox=userService.get(LightBox.class, boxId);
						if(currentLightBox!=null){
							currentLightBox.setName(newBoxName);
							try {
								lightBoxService.UpdateLightBox(currentLightBox);
							} catch (Exception e) {
								e.printStackTrace();
								msg.put("code", 0);
								msg.put("msg", "修改失败");
								return msg;
							}
						}
						msg.put("code", 1);
						msg.put("msg", "修改成功");
						return msg;
							
					} else {
						msg.put("msg", "发送失败");
						msg.put("code",-1);
					}
					return msg;
				}
				
				
				// author:Peter saveboxinfo
				@RequestMapping(value = { "/my/saveboxinfo" }, method = RequestMethod.POST)
				@ResponseBody
				public Map<String, Object> saveBoxInfo(HttpServletRequest request) {
					Map<String, Object> msg = new HashMap<String, Object>();
					if (getSessionUser(request) != null) {
						int boxId = getIntValue(request, "boxid", 0);//boxid
						String customer = getStringValue(request, "customer", "");//customer
						String memo = getStringValue(request, "memo", "");//memo
						String projectName = getStringValue(request, "projectname", "");//projectName
						
						LightBox currentLightBox=lightBoxService.get(LightBox.class, boxId);
						if(currentLightBox!=null){
							if(!StrUtils.isBlank(customer))
							{
								currentLightBox.setCustomer(customer);
							}
							if(!StrUtils.isBlank(memo))
							{
								currentLightBox.setMemo(memo);
							}
							if(!StrUtils.isBlank(projectName))
							{
								currentLightBox.setProjectName(projectName);
							}
							try {
								lightBoxService.UpdateLightBox(currentLightBox);
							} catch (Exception e) {
								e.printStackTrace();
								msg.put("code", 0);
								msg.put("msg", "修改失败");
								return msg;
							}
						}
						msg.put("code", 1);
						msg.put("msg", "修改成功");
						return msg;
							
					} else {
						msg.put("msg", "发送失败");
						msg.put("code",-1);
					}
					return msg;
				}
				
				
		// author:Peter moveImg
		@RequestMapping(value = { "/my/moveImg" }, method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> moveImg(HttpServletRequest request) {
			Map<String, Object> msg = new HashMap<String, Object>();
			if (getSessionUser(request) != null) {
				int boxId = getIntValue(request, "boxid", 0);//boxid
				String[] imgids = getStringValue(request, "imgids", "").split(",");//customer
				int isDel = getIntValue(request, "isDel", 0);//memo
				
				try {
					lightBoxService.moveImg(boxId,imgids,isDel);
					msg.put("code", 1);
					msg.put("msg", "操作成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					msg.put("msg", "操作失败");
					msg.put("code",0);
				}
					
			} else {
				msg.put("msg", "操作失败");
				msg.put("code",-1);
			}
			return msg;
		}
		
		
		
		@RequestMapping(value = {"/lbFormShareMember.na"})
		public String lbFormShareMember(HttpServletRequest request,HttpSession session){
			int lightboxid = getIntValue(request, "lightboxid", 0);
			request.setAttribute("lightboxId", lightboxid);
			return "user/lbFormShareMember";
		}
		@RequestMapping(value = {"/lbFormShareEmail.na"})
		public String lbFormShareEmail(HttpServletRequest request,HttpSession session){
			int lightboxid = getIntValue(request, "lightboxid", 0);
			request.setAttribute("lightboxId", lightboxid);
			
			request.setAttribute("sendEmailer",getStringValue(request, "sendEmailer", ""));
			return "user/lbFormShareEmail";
		}
		

		@RequestMapping(value = { "/my/deletelightboximg" }, method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> deleteImg(HttpServletRequest request) {
			Map<String, Object> msg = new HashMap<String, Object>();
			try {
				lightBoxService.deleteBoxImg(getIntValue(request, "boxId", 0));
				msg.put("code", 1);
				msg.put("msg", "操作成功");
			} catch (Exception e) {
				e.printStackTrace();
				msg.put("msg", "操作失败");
				msg.put("code",0);
			}
			return msg;
		}

		@RequestMapping(value = { "/my/copylightboximg" }, method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> copyImg(HttpServletRequest request) {
			Map<String, Object> msg = new HashMap<String, Object>();
			Integer boxId = getIntValue(request, "oldBoxId", 0);
			Integer newBoxId = getIntValue(request, "newBoxId", 0);
			String corbisId = getStringValue(request, "imgId", "");
			
			try {
				if(boxId > 0 && StrUtils.isNotBlank(corbisId))
				{
					boolean result = lightBoxService.copyBoxImg(boxId, corbisId, newBoxId);
					if(result)
					{
						msg.put("code", 1);
						msg.put("msg", "操作成功");
					}
					else {
						msg.put("msg", "操作失败");
						msg.put("code",0);
					}
				}
				else {
					msg.put("msg", "操作失败");
					msg.put("code",0);
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg.put("msg", "操作失败");
				msg.put("code",0);
			}
			return msg;
		}
}
