/* This file MemCachedClientWrapper.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.cache.memcached;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemCachedClientWrapper {

	private static final Logger logger = LoggerFactory
			.getLogger(MemCachedClientWrapper.class);

	public static final int SECOND = 1000;

	public static final int MINUTE = 1000 * 60;

	public static final int HOUR = 1000 * 60 * 60;

	private SockIOPool pool;

	private MemCachedClient mcc;

	private String name;

	private String serverList;

	private String weightList;

	private int initConn = 10;

	private int minConn = 5;

	private int maxConn = 50;

	private long maxIdleTime = 1000 * 60 * 30;

	private long maxBusyTime = 1000 * 60 * 5;

	private long maintThreadSleep = 1000 * 5;

	private int socketTimeOut = 1000 * 5;

	private int socketConnectTO = 1000 * 3;

	private boolean failover = false;

	private boolean nagleAlg = false;

	private boolean aliveCheck = true;

	private int cacheTimeSeconds = 300 * 1000;

	private boolean dogpilePreventionEnabled = true;

	private double dogpilePreventionExpirationFactor = 2;

	public static final Integer DOGPILE_TOKEN = 0;

	public boolean isDogpilePreventionEnabled() {
		return dogpilePreventionEnabled;
	}

	public void setDogpilePreventionEnabled(boolean dogpilePreventionEnabled) {
		this.dogpilePreventionEnabled = dogpilePreventionEnabled;
	}

	public double getDogpilePreventionExpirationFactor() {
		return dogpilePreventionExpirationFactor;
	}

	public void setDogpilePreventionExpirationFactor(
			double dogpilePreventionExpirationFactor) {
		if (dogpilePreventionExpirationFactor < 1.0) {
			throw new IllegalArgumentException(
					"dogpilePreventionExpirationFactor must be greater than 1.0");
		}
		this.dogpilePreventionExpirationFactor = dogpilePreventionExpirationFactor;
	}

	private String dogpileTokenKey(String objectKey) {
		return objectKey + ".dogpileTokenKey";
	}

	public void init() {
		try {
			if (null == pool || !pool.isInitialized()) {
				pool = SockIOPool.getInstance(name);

				pool.setServers(StringUtils.split(serverList, ','));
				String[] tmp = StringUtils.split(weightList, ',');
				Integer[] weights = new Integer[tmp.length];

				for (int i = 0; i < tmp.length; ++i) {
					weights[i] = NumberUtils.toInt(tmp[i], 0);
				}
				pool.setWeights(weights);
				pool.setInitConn(initConn);
				pool.setMinConn(minConn);
				pool.setMaxConn(maxConn);
				pool.setMaxIdle(maxIdleTime);
				pool.setMaxBusyTime(maxBusyTime);
				pool.setMaintSleep(maintThreadSleep);
				pool.setSocketConnectTO(socketConnectTO);
				pool.setSocketTO(socketTimeOut);
				pool.setNagle(nagleAlg);
				pool.setFailover(failover);
				pool.setAliveCheck(aliveCheck);
				pool.setHashingAlg(SockIOPool.NEW_COMPAT_HASH);
				pool.initialize();
			}
			mcc = new MemCachedClient(name);
			mcc.setCompressEnable(true);
			mcc.setCompressThreshold(4096);
		} catch (Exception e) {
			logger.error("[初始化SocketPool异常=" + e.getMessage() + "]", e);
		}

	}

	public void destroy() {
		if (null != pool) {
			pool.shutDown();
			pool = null;
		}
	}

	public void set(String key, Object value, int expire) {

		int cacheTime = (int) expire;
		if (dogpilePreventionEnabled) {
			String dogpileKey = dogpileTokenKey(key);
			if (logger.isDebugEnabled()) {
				logger
						.debug("Dogpile prevention enabled, setting token and adjusting object cache time. Key: "
								+ dogpileKey);

			}
			mcc.set(dogpileKey, DOGPILE_TOKEN, new Date(expire*SECOND));
			cacheTime = (int) (expire * dogpilePreventionExpirationFactor);
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Memcache.set　" + key);
		}
		mcc.set(key, value, new Date(cacheTime*SECOND));
	}

	public void setNormal(String key, Object value, int expire) {
		mcc.set(key, value, new Date(expire*SECOND));
	}

	public void set(String key, Object value) {
		set(key, value, HOUR);
	}

	public void delete(String key) {
		if (mcc != null)
			mcc.delete(key);
	}

	public Object get(String key) throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");

		if (dogpilePreventionEnabled) {
			String dogpileKey = dogpileTokenKey(key);
			if (logger.isDebugEnabled()) {
				logger.debug("Checking dogpile key: " + dogpileKey);
			}

			if (mcc.get(dogpileKey) == null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Dogpile key " + dogpileKey
							+ " not found updating token and returning null");
				}
				mcc.set(dogpileKey, DOGPILE_TOKEN, new Date(cacheTimeSeconds));
				return null;
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("Dogpile token found for key " + dogpileKey
							+ ", getting cached object");
				}
			}
		}

		return mcc.get(key);
	}

	public Object getNormal(String key) throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.get(key);
	}
	
	public Map<String, Object> getMulti(String[] keys)throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.getMulti(keys);
	}
	
	public Object[] getMultiArray(String[] keys)throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.getMultiArray(keys);
	}


	public boolean storeCounter(String key, long counter) {
		if (null == mcc)
			return false;
		else
			return mcc.storeCounter(key, counter);
	}

	public long getCounter(String key) throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.getCounter(key);
	}

	public long incr(String key) throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.incr(key);
	}

	public long incr(String key, long value) throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.incr(key, value);
	}

	public long decr(String key) throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.decr(key);
	}

	public long decr(String key, long value) throws Exception {
		if (null == mcc)
			throw new Exception("MemCachedClient没有正常初始化");
		return mcc.decr(key, value);
	}

	/**
	 * @return the aliveCheck
	 */
	public boolean isAliveCheck() {
		return aliveCheck;
	}

	/**
	 * @param aliveCheck
	 *            the aliveCheck to set
	 */
	public void setAliveCheck(boolean aliveCheck) {
		this.aliveCheck = aliveCheck;
	}

	/**
	 * @return the failover
	 */
	public boolean isFailover() {
		return failover;
	}

	/**
	 * @param failover
	 *            the failover to set
	 */
	public void setFailover(boolean failover) {
		this.failover = failover;
	}

	/**
	 * @return the initConn
	 */
	public int getInitConn() {
		return initConn;
	}

	/**
	 * @param initConn
	 *            the initConn to set
	 */
	public void setInitConn(int initConn) {
		this.initConn = initConn;
	}

	/**
	 * @return the maintThreadSleep
	 */
	public long getMaintThreadSleep() {
		return maintThreadSleep;
	}

	/**
	 * @param maintThreadSleep
	 *            the maintThreadSleep to set
	 */
	public void setMaintThreadSleep(long maintThreadSleep) {
		this.maintThreadSleep = maintThreadSleep;
	}

	/**
	 * @return the maxBusyTime
	 */
	public long getMaxBusyTime() {
		return maxBusyTime;
	}

	/**
	 * @param maxBusyTime
	 *            the maxBusyTime to set
	 */
	public void setMaxBusyTime(long maxBusyTime) {
		this.maxBusyTime = maxBusyTime;
	}

	/**
	 * @return the maxConn
	 */
	public int getMaxConn() {
		return maxConn;
	}

	/**
	 * @param maxConn
	 *            the maxConn to set
	 */
	public void setMaxConn(int maxConn) {
		this.maxConn = maxConn;
	}

	/**
	 * @return the maxIdleTime
	 */
	public long getMaxIdleTime() {
		return maxIdleTime;
	}

	/**
	 * @param maxIdleTime
	 *            the maxIdleTime to set
	 */
	public void setMaxIdleTime(long maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

	/**
	 * @return the minConn
	 */
	public int getMinConn() {
		return minConn;
	}

	/**
	 * @param minConn
	 *            the minConn to set
	 */
	public void setMinConn(int minConn) {
		this.minConn = minConn;
	}

	/**
	 * @return the nagleAlg
	 */
	public boolean isNagleAlg() {
		return nagleAlg;
	}

	/**
	 * @param nagleAlg
	 *            the nagleAlg to set
	 */
	public void setNagleAlg(boolean nagleAlg) {
		this.nagleAlg = nagleAlg;
	}

	/**
	 * @return the serverList
	 */
	public String getServerList() {
		return serverList;
	}

	/**
	 * @param serverList
	 *            the serverList to set
	 */
	public void setServerList(String serverList) {
		this.serverList = serverList;
	}

	/**
	 * @return the socketConnectTO
	 */
	public int getSocketConnectTO() {
		return socketConnectTO;
	}

	/**
	 * @param socketConnectTO
	 *            the socketConnectTO to set
	 */
	public void setSocketConnectTO(int socketConnectTO) {
		this.socketConnectTO = socketConnectTO;
	}

	/**
	 * @return the socketTimeOut
	 */
	public int getSocketTimeOut() {
		return socketTimeOut;
	}

	/**
	 * @param socketTimeOut
	 *            the socketTimeOut to set
	 */
	public void setSocketTimeOut(int socketTimeOut) {
		this.socketTimeOut = socketTimeOut;
	}

	/**
	 * @return the weightList
	 */
	public String getWeightList() {
		return weightList;
	}

	/**
	 * @param weightList
	 *            the weightList to set
	 */
	public void setWeightList(String weightList) {
		this.weightList = weightList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
