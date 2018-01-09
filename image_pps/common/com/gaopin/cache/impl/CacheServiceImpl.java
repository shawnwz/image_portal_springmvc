/* This file CacheServiceImpl.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.cache.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gaopin.cache.CacheService;
import com.gaopin.cache.memcached.MemCachedClientWrapper;
import com.gaopin.cache.memcached.NullObject;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {
	private Logger log = Logger.getLogger(this.getClass());
	@SuppressWarnings("unused")
	private static String VERSION_KEY = "V@";
	private String configFilename = "ehcache.xml";
	public static final String CACHE_SHORT = "cache_short";
	public static final String CACHE_MEDIUM = "cache_medium";
	public static final String CACHE_LONG = "cache_long";
	private CacheManager cacheManager;
	@Resource
	private MemCachedClientWrapper memcached;

	@PostConstruct
	public void init() throws Exception {
		URL url = CacheService.class.getClassLoader().getResource(
				configFilename);
		cacheManager = CacheManager.create(url);
		
		if (log.isInfoEnabled()) {
			log.info("初始化本地缓存ehcache:" + url.toString());
			
			String[] names = cacheManager.getCacheNames();
			for(String name : names){
				log.info("cacheName=" + name);
			}
		}
	}

	public Cache getCache(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {
			return cache;
		}
		log.warn("本地缓存【" + cacheName + "】不存在!");
		return null;
	}

	public MemCachedClientWrapper getMemcached() {
		return memcached;
	}

	public Object get(String cacheName, String key) throws Exception {
		Object value = getLocal(cacheName, key);
		//TODO 这里value值可能为NullObject所有追加了instanceof的判断
		if (value != null && !(value instanceof NullObject)) {
			return value;
		}

		value = getRemote(key);
		//TODO 这里value值可能为NullObject所有追加了instanceof的判断
		if (value != null && !(value instanceof NullObject)) {
			putLocal(cacheName, key, value);
			return value;
		}

		return null;
	}

	public void set(String cacheName, String key, Object value, int expiry) {
		if (value == null)
			return;
		putLocal(cacheName, key, value);
		putRemote(key, value, expiry);
	}

	public void remove(String cacheName, String key) {
		this.removeLocal(cacheName, key);
		this.removeRemote(key);
	}

	/**
	 * 存入本地缓存
	 * 
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public void putLocal(String cacheName, String key, Object value) {
		Element e = new Element(key, value);
		Cache cache = getCache(cacheName);
		if (cache != null) {
			cache.put(e);
		}
	}

	/**
	 * 设置memcached缓存，时间单位：秒
	 * 
	 * @param key
	 * @param value
	 * @param expiry
	 */
	@SuppressWarnings("static-access")
	public void putRemote(String key, Object value, int expiry) {
		if (memcached != null) {
			memcached.set(key, value, expiry*memcached.SECOND);
		}
	}

	/**
	 * 从本地缓存查询数据
	 * 
	 * @param cacheName
	 * @param key
	 * @param expire
	 * @return
	 */
	public Object getLocal(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		if (cache == null) {
			return null;
		}
		Element e = cache.get(key);
		if (e != null) {
			if (log.isDebugEnabled()) {
				log.debug("local_cache key=" + key + ", value="
						+ e.getValue().getClass().getName());
			}
			return e.getValue();
		}
		return null;
	}

	/**
	 * 从memcached查询缓存
	 * 
	 * @param key
	 * @return
	 */
	public Object getRemote(String key) throws Exception {
		if (memcached != null) {
			return memcached.get(key);
		}
		return null;
	}

	public void removeLocal(String cacheName, String key) {
		Cache cache = getCache(cacheName);
		if (cache != null) {
			cache.remove(key);
		}
	}

	public void removeRemote(String key) {
		try {
			if (memcached != null)
				memcached.delete(key);
		} catch (Exception ex) {
			log.error("delete from memcached error key=" + key + ":", ex);
		}
	}

	@Override
	public long getCounter(String key) {
		try{
			return memcached.getCounter(key);
		}
		catch(Exception exception){
			log.error("getCounter error key=" + key, exception);
		}
		return 0;
	}

	@Override
	public boolean storeCounter(String key, long counter) {
		try{
			return memcached.storeCounter(key, counter);
		}
		catch (Exception e) {
			log.error("storeCounter error key="+key+", counter="+counter, e);
		}
		return false;
	}

	@Override
	public long incr(String key) {
		try{
			return memcached.incr(key);
		}
		catch(Exception e){
			log.error("incr error key= " + key, e);
		}
		return 0;
	}

	@Override
	public long incr(String key, long inc) {
		try{
			return memcached.incr(key, inc);
		}
		catch(Exception e){
			log.error("incr is error key="+key+", inc="+inc, e);
		}
		return 0;
	}

	@Override
	public void putLocalLong(String key, Object value) {
		putLocal(CACHE_LONG, key, value);
	}

	@Override
	public void putLocalMedium(String key, Object value) {
		putLocal(CACHE_MEDIUM, key, value);
	}

	@Override
	public void putLocalShort(String key, Object value) {
		putLocal(CACHE_SHORT, key, value);
	}

	@Override
	public Object getLocalLong(String key) {
		return getLocal(CACHE_LONG, key);
	}

	@Override
	public Object getLocalMedium(String key) {
		return getLocal(CACHE_MEDIUM, key);
	}

	@Override
	public Object getLocalShort(String key) {
		return getLocal(CACHE_SHORT, key);
	}

	@Override
	public void removeLocalLong(String key) {
		removeLocal(CACHE_LONG, key);
	}

	@Override
	public void removeLocalMedium(String key) {
		removeLocal(CACHE_MEDIUM, key);
	}

	@Override
	public void removeLocalShort(String key) {
		removeLocal(CACHE_SHORT, key);
	}

	
}
