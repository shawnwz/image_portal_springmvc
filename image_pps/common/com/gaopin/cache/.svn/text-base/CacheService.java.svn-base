/* This file CacheService.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.cache;

import net.sf.ehcache.Cache;

import com.gaopin.cache.memcached.MemCachedClientWrapper;

public interface CacheService
{
	public MemCachedClientWrapper getMemcached();
	
	public Cache getCache(String cacheName);
	
	/**
	 * 从ehcache,memcached中读取数据
	 * 本地没有，从memcached中装载
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public Object get(String cacheName, String key)throws Exception;
	
	/**
	 * 向ehcache，memcached中设置数据，时间：秒
	 * @param cacheName
	 * @param key
	 * @param value
	 * @param expiry
	 */
	public void set(String cacheName, String key, Object value, int expiry);
	
	/**
	 * 删除ehcache,memcached中的数据
	 * @param cacheName
	 * @param key
	 */
	public void remove(String cacheName, String key);
	
	/**
	 * 数据存放本地缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public void putLocal(String cacheName, String key, Object value);
	public void putLocalLong(String key, Object value);
	public void putLocalMedium(String key, Object value);
	public void putLocalShort(String key, Object value);
	
	/**
	 * 从本地缓存获取数据
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public Object getLocal(String cacheName, String key);
	public Object getLocalLong(String key);
	public Object getLocalMedium(String key);
	public Object getLocalShort(String key);
	
	/**
	 * 删除本地缓存数据
	 * @param cacheName
	 * @param key
	 */
	public void removeLocal(String cacheName, String key);
	public void removeLocalLong(String key);
	public void removeLocalMedium(String key);
	public void removeLocalShort(String key);
	
	/**
	 * 添加数据到memcached
	 * @param key
	 * @param value
	 * @param expiry
	 */
	public void putRemote(String key, Object value, int expiry);
	
	/**
	 * 从memcached中获取数据
	 * @param key
	 * @return
	 */
	public Object getRemote(String key)throws Exception;
	
	/**
	 * 删除memcached中的数据
	 * @param key
	 */
	public void removeRemote(String key);
	
	/**
	 * 获取计数器的值,如果计数器不存在，返回-1
	 * @param key
	 * @return
	 */
	public long getCounter(String key);
	/**
	 * 保存计数器
	 * @param key
	 * @param counter
	 * @return
	 */
	public boolean storeCounter( String key, long counter);
	/**
	 * 计数器加1，返回增加后的值，如果计数器不存在，返回-1
	 * @param key
	 * @return
	 */
	public long incr( String key );
	/**
	 * 计数器增加inc，返回增加后的值，如果计数器不存在，返回-1
	 * @param key
	 * @param inc
	 * @return
	 */
	public long incr( String key, long inc );

}