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
import com.gaopin.entity.FrCart;
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
import com.gaopin.service.pps.CartService;
import com.gaopin.utils.CacheKeyUtils;
import com.gaopin.utils.DateUtils;
import com.gaopin.utils.MD5;
import com.gaopin.utils.StrUtils;

@Service("cartService")
public class CartServiceImpl extends BaseServiceImpl implements
		CartService {

	@Resource
	private CacheService cacheService;

	@Override
	public FrCart getCart(Integer userid, String gaopinId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCart(Integer userid, String gaopinId) {
		try {
			Collection<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
			expressions.add(new CompareExpression("gaopinId", gaopinId,	CompareType.Equal));
			expressions.add(new CompareExpression("userId", userid, CompareType.Equal));
			List<FrCart> list = controller.findBy(FrCart.class, expressions);
			if (list.size() > 0)
				delCart(list.get(0).getId());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<FrCart> getListByUser(Integer userId, int order) {
		// TODO Auto-generated method stub
		String key = CacheKeyUtils.getEntityListKey(FrCart.class, "userId",
				userId);
		List<FrCart> list = null;
		try {
			list = (List<FrCart>) cacheService.getRemote(key);
			if (list == null) {
				List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
				expressions.add(new CompareExpression("userId", userId,	CompareType.Equal));
				expressions.add(new CompareExpression("status",	Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
				list = super.getList(FrCart.class, expressions);

				if (list != null && list.size() > 0)
					cacheService.putRemote(key, list,
							Constants.CACHE_HOUR_TIMES);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list != null ? list : new ArrayList<FrCart>();
	}

	@Override
	public FrCart addCart(Integer userid, String gaopinId) {

		
		FrCart cart = new FrCart();
		cart.setCreateDate(new Date());
		cart.setChangeDate(new Date());
		cart.setUserId(userid);
		cart.setGaopinId(gaopinId);
		cart.setStatus(Constants.CommonStatus.ENABLE.ordinal());
		super.saveObject(cart);
		String key = CacheKeyUtils.getEntityListKey(LightBox.class, "cartId",	cart.getId());
		cacheService.putRemote(key, cart, Constants.CACHE_HOUR_TIMES);
		

		return cart;
	}

	@Override
	public int getCartItemCount(Integer userid) {
		List<HibernateExpression> expressions = new ArrayList<HibernateExpression>();
		expressions.add(new CompareExpression("userId", userid, CompareType.Equal));
		expressions.add(new CompareExpression("status",	Constants.CommonStatus.ENABLE.ordinal(), CompareType.Equal));
		int count = (int) super.getCount(LightBoxRel.class, expressions);
		return count;
	}

	
	@Override
	public FrCart delCart(Integer id) {
		FrCart item = super.get(FrCart.class, id);
		/*int cartId = item.getBoxId();
		FrCart lbBox = getCart(id);*/
		if (item != null && item.getId() > 0) {
			String key = CacheKeyUtils.getEntityListKey(FrCart.class, "cartId", item.getId());
			cacheService.removeRemote(key);
			//super.deleteObject(item);
			item.setStatus(Constants.CommonStatus.DELETE.ordinal());
			//lbBox.setImageNum(getListCountByBox(boxId));
			super.updateObject(item);
		}

		String key = CacheKeyUtils.getEntityListKey(FrCart.class, "userId",	item.getUserId());
		cacheService.removeRemote(key);
		
		return item;
	}
	
	@Override
	public FrCart getCart(Integer id) {
		// TODO Auto-generated method stub
		String key = CacheKeyUtils.getEntityKey(FrCart.class, id);
		FrCart cart = null;
		try {
			cart = (FrCart) cacheService.getRemote(key);
			if (cart == null) {
				cart = super.get(FrCart.class, id);
				if (cart != null)
					cacheService.putRemote(key, cart,
							Constants.CACHE_HOUR_TIMES);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}



	


	



	
	



	

	

	




}
