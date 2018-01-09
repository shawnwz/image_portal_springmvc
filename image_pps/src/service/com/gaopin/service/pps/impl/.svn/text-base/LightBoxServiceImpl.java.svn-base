/* This file LightBoxServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.service.pps.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.constants.Constants;
import com.gaopin.entity.LightBox;
import com.gaopin.entity.LightBoxRel;
import com.gaopin.entity.User;
import com.gaopin.frame.HibernateGenericController;
import com.gaopin.frame.hibernate.CompareExpression;
import com.gaopin.frame.hibernate.CompareType;
import com.gaopin.frame.hibernate.HibernateExpression;
import com.gaopin.frame.hibernate.InExpression;
import com.gaopin.service.BaseService;
import com.gaopin.service.impl.BaseServiceImpl;
import com.gaopin.service.pps.KeywordService;
import com.gaopin.service.pps.LightBoxService;
import com.gaopin.utils.CacheKeyUtils;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.MD5;
import com.gaopin.utils.StrUtils;

@Service("lightBoxService")
public class LightBoxServiceImpl extends BaseServiceImpl implements
		LightBoxService {

	@Resource
	private CacheService cacheService;

	@Override
	public boolean checkInbox(Integer userId, String corbisid) {
		if(userId.intValue()==0)
			return true;
		List<LightBox> boxes = getListByUser(userId, 0);
		List<Integer> boxids = new ArrayList<Integer>();
		boxids.add(-1);
		for (LightBox lightBox : boxes) {
			boxids.add(lightBox.getId());
		}
		List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new InExpression("boxId", boxids));
		expressions.add(new CompareExpression("corbisId", corbisid,
				CompareType.Equal));
		List<LightBoxRel> list = super.getList(LightBoxRel.class, expressions);
		if (list.size() > 0)
			return true;
		return false;
	}

	@Override
	/*
	 * /order 0时间 1名字
	 */
	public List<LightBox> getListByUser(Integer userId, int order) {
		// TODO Auto-generated method stub
		String key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				userId);
		List<LightBox> list = null;
		try {
			list = (List<LightBox>) cacheService.getRemote(key);
			if (list == null) {
				if (order == 0)
					list = super.getController().findBy(LightBox.class,
							"ownerId", userId, "id", true);
				else
					list = super.getController().findBy(LightBox.class,
							"ownerId", userId, "name", true);

				if (list != null && list.size() > 0)
					cacheService.putRemote(key, list,
							Constants.CACHE_HOUR_TIMES);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list != null ? list : new ArrayList<LightBox>();
	}

	@Override
	public LightBox getLightBox(Integer id) {
		// TODO Auto-generated method stub
		String key = CacheKeyUtils.getEntityKey(LightBox.class, id);
		LightBox item = null;
		try {
			item = (LightBox) cacheService.getRemote(key);
			if (item == null) {
				item = super.get(LightBox.class, id);
				if (item != null)
					cacheService.putRemote(key, item,
							Constants.CACHE_HOUR_TIMES);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public LightBox getLightBox(String code) {
		// TODO Auto-generated method stub
		String key = CacheKeyUtils.getEntityKey(LightBox.class, code);
		LightBox item = null;
		try {
			item = (LightBox) cacheService.getRemote(key);
			if (item == null) {
				List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
				expressions.add(new CompareExpression("codeKey", code,
						CompareType.Equal));
				expressions.add(new CompareExpression("status",
						Constants.CommonStatus.ENABLE.ordinal(),
						CompareType.Equal));
				List<LightBox> list = super
						.getList(LightBox.class, expressions);
				item = list.get(0);
				if (item != null)
					cacheService.putRemote(key, item,
							Constants.CACHE_HOUR_TIMES);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public LightBoxRel getLightBoxItem(Integer id) {
		// TODO Auto-generated method stub
		String key = CacheKeyUtils.getEntityKey(LightBoxRel.class, id);
		LightBoxRel item = null;
		try {
			item = (LightBoxRel) cacheService.getRemote(key);
			if (item == null) {
				item = super.get(LightBoxRel.class, id);
				if (item != null)
					cacheService.putRemote(key, item,
							Constants.CACHE_HOUR_TIMES);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
	@Override
	public LightBoxRel getLightBoxItem(String code,int lightBoxId) {
		// TODO Auto-generated method stub
		LightBoxRel item = null;
		try {
				List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
				expressions.add(new CompareExpression("corbisId", code,
						CompareType.Equal));
				expressions.add(new CompareExpression("boxId",lightBoxId,CompareType.Equal));
				List<LightBoxRel> list = super
						.getList(LightBoxRel.class, expressions);
				item = list.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
	@Override
	public List<LightBoxRel> getListByBox(Integer boxId) {
		// TODO Auto-generated method stub
		String key = CacheKeyUtils.getEntityListKey(LightBoxRel.class, "boxId",
				boxId);
		List<LightBoxRel> list = null;
		try {
			list = (List<LightBoxRel>) cacheService.getRemote(key);
			if (list == null) {
				list = super.getController().findBy(LightBoxRel.class, "boxId",
						boxId, "id", true);
				if (list != null && list.size() > 0)
					cacheService.putRemote(key, list,
							Constants.CACHE_HOUR_TIMES);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list != null ? list : new ArrayList<LightBoxRel>();
	}

	public int getListCountByBox(Integer boxId) {
		List<HibernateExpression> elist = new ArrayList<HibernateExpression>();
		elist.add(new CompareExpression("boxId", boxId, CompareType.Equal));
		int count = (int) super.getCount(LightBoxRel.class, elist);
		return count;
	}

	@Override
	public LightBox addBox(Integer userId, String userName, String name,
			Integer pid) {

		LightBox fbox = getLightBox(pid);
		int level = fbox == null ? 0 : fbox.getLevel() + 1;
		LightBox lb0 = new LightBox();
		lb0.setUpdateTime(new Date());
		lb0.setCodeKey(MD5.getMd5Str(name + userName + userId + pid
				+ DateUtils.getDateStr(new Date())));
		lb0.setCreateTime(new Date());
		lb0.setCustomer(userName);
		lb0.setImageNum(0);
		lb0.setLevel(level);
		lb0.setName(name);
		lb0.setOwnerId(userId);
		lb0.setParentId(pid);
		lb0.setSequence(0);
		lb0.setStatus(Constants.CommonStatus.ENABLE.ordinal());
		super.saveObject(lb0);
		String key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				userId);
		cacheService.removeRemote(key);

		return lb0;
	}

	@Override
	public LightBox addBoxDefault(Integer userId, String userName) {
		LightBox lb0 = new LightBox();
		lb0.setUpdateTime(new Date());
		lb0.setCodeKey(MD5.getMd5Str(userName + userId
				+ DateUtils.getDateStr(new Date())));
		lb0.setCreateTime(new Date());
		lb0.setCustomer(userName);
		lb0.setImageNum(0);
		lb0.setLevel(0);
		lb0.setName("我的灯箱");
		lb0.setOwnerId(userId);
		lb0.setParentId(0);
		lb0.setSequence(0);
		lb0.setStatus(Constants.CommonStatus.ENABLE.ordinal());
		super.saveObject(lb0);
		String key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				userId);
		cacheService.removeRemote(key);
		return lb0;
	}

	@Override
	public LightBox setBoxFather(Integer id, Integer pid) {
		LightBox fbox = getLightBox(pid);
		int level = fbox == null ? 0 : fbox.getLevel() + 1;
		LightBox lb0 = super.get(LightBox.class, id);
		lb0.setParentId(pid);
		lb0.setLevel(level);
		lb0.setUpdateTime(new Date());
		super.updateObject(lb0);
		String key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				lb0.getOwnerId());
		cacheService.removeRemote(key);
		key = CacheKeyUtils.getEntityKey(LightBox.class, id);
		cacheService.removeRemote(key);
		return lb0;
	}

	@Override
	public LightBox UpdateLightBox(LightBox lb0) {
		lb0.setUpdateTime(new Date());
		super.updateObject(lb0);
		String key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				lb0.getOwnerId());
		cacheService.removeRemote(key);
		key = CacheKeyUtils.getEntityKey(LightBox.class, lb0.getId());
		cacheService.removeRemote(key);
		return lb0;
	}

	@Override
	public LightBoxRel delBoxItem(Integer id) {
		LightBoxRel item = super.get(LightBoxRel.class, id);
		int boxId = item.getBoxId();
		LightBox lbBox = getLightBox(boxId);
		if (item != null && item.getId() > 0) {
			String key = CacheKeyUtils.getEntityListKey(LightBoxRel.class,
					"boxId", item.getBoxId());
			cacheService.removeRemote(key);
			super.deleteObject(item);

			lbBox.setImageNum(getListCountByBox(boxId));
			super.updateObject(lbBox);
		}

		String key = CacheKeyUtils.getEntityListKey(LightBoxRel.class, "boxId",
				boxId);
		cacheService.removeRemote(key);
		key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				lbBox.getOwnerId());
		cacheService.removeRemote(key);

		return item;
	}

	@Override
	public LightBox delBox(Integer id) {
		LightBox item = super.get(LightBox.class, id);
		if (item != null && item.getId() > 0) {
			// delete images.
			List<LightBoxRel> list = getListByBox(id);
			for (LightBoxRel lb : list)
				super.deleteObject(lb);
			List<LightBox> lbs = getListByUser(item.getOwnerId(), 0);
			for (LightBox lb : lbs)
				if (lb.getParentId() == item.getId().intValue()) {
					delBox(lb.getId());
				}
			super.deleteObject(item);
		}
		String key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				item.getOwnerId());
		cacheService.removeRemote(key);
		return item;
	}

	@Override
	public LightBoxRel addBoxItem(Integer boxId, String corbisId) {

		LightBox lbBox = getLightBox(boxId);

		LightBoxRel item = new LightBoxRel();
		{
			item.setBoxId(boxId);
			item.setCorbisId(corbisId);
			item.setCreateTime(new Date());
			item.setUpdateTime(new Date());
			item.setMemo("");
			super.saveObject(item);

			lbBox.setImageNum(getListCountByBox(boxId));
			super.updateObject(lbBox);

		}

		String key = CacheKeyUtils.getEntityListKey(LightBoxRel.class, "boxId",
				boxId);
		cacheService.removeRemote(key);
		key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
				lbBox.getOwnerId());
		cacheService.removeRemote(key);

		return item;
	}

	@Override
	public LightBoxRel SetBoxItem(Integer id, String memo) {
		LightBoxRel item = super.get(LightBoxRel.class, id);
		if (item == null)
			return null;
		item.setMemo(memo);
		super.updateObject(item);
		String key = CacheKeyUtils.getEntityListKey(LightBoxRel.class, "boxId",
				item.getBoxId());
		cacheService.removeRemote(key);
		return item;
	}

	@Override
	public boolean delBoxImgByBoxIDAndCorbisId(int boxId, String corbisId) {
		try {
			Collection<HibernateExpression> coll = new ArrayList<HibernateExpression>();
			coll.add(new CompareExpression("corbisId", corbisId,
					CompareType.Equal));
			coll.add(new CompareExpression("boxId", boxId, CompareType.Equal));
			List<LightBoxRel> list = controller.findBy(LightBoxRel.class, coll);
			if (list.size() > 0)
				delBoxItem(list.get(0).getId());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean moveImg(int boxId, String[] imgids, int isDel)
			throws Exception {
		for (int i = 0; i < imgids.length; i++) {
			int imgId = StrUtils.getIntValue((imgids[i]), 0);
			LightBoxRel entity = getLightBoxItem(imgId);
			if (entity != null) {
				if (isDel == 1) {
					delBoxItem(imgId);
				}
				entity.setBoxId(boxId);
				addBoxItem(boxId, entity.getCorbisId());
			}
		}
		return true;
	}

	@Override
	public boolean deleteBoxImg(int boxId)
			throws Exception {
		
		Collection<HibernateExpression> coll = new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("boxId", boxId, CompareType.Equal));
		List<LightBoxRel> list = controller.findBy(LightBoxRel.class, coll);
 
		
		for (LightBoxRel rel : list) {
			delBoxItem(rel.getId());
		}
		return true;
	}

	@Override
	public boolean copyBoxImg(int boxId,String corbisId,int newBoxId)
	{
		
		Collection<HibernateExpression> coll = new ArrayList<HibernateExpression>();
		coll.add(new CompareExpression("boxId", boxId, CompareType.Equal));
		coll.add(new CompareExpression("corbisId", corbisId,CompareType.Equal));
		List<LightBoxRel> list = controller.findBy(LightBoxRel.class, coll);
 
		LightBox lbBox = getLightBox(newBoxId);
		if (list.size() > 0)
		{
			//delBoxItem(list.get(0).getId());
			LightBoxRel rel = new LightBoxRel();
			rel.setBoxId(newBoxId);
			rel.setCorbisId(corbisId);
			rel.setCreateTime(new Date());
			rel.setMemo(list.get(0).getMemo());
			

			super.saveObject(rel);

			lbBox.setImageNum(getListCountByBox(newBoxId));
			super.updateObject(lbBox);

	
			String key = CacheKeyUtils.getEntityListKey(LightBoxRel.class, "boxId",
					newBoxId);
			cacheService.removeRemote(key);
			key = CacheKeyUtils.getEntityListKey(LightBox.class, "userId",
					lbBox.getOwnerId());
			cacheService.removeRemote(key);
			
			return true;
		}
		else {
			return false;
		}
	}
}
