/* This file HttpClientHelper.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/

package com.gaopin.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientHelper {
	
	private static final Log log = LogFactory.getLog(HttpClientHelper.class);  
    
	private volatile boolean shutdown;
	private PoolingHttpClientConnectionManager cm = null;
	private CloseableHttpClient httpClient = null;
	private static HttpClientHelper instance = new HttpClientHelper();
	
	private IdleConnectionMonitorThread idleConnectionMonitorThread = null;
	
	static{
		instance.init();
		instance.idleConnectionMonitorThread = instance.new IdleConnectionMonitorThread();
		instance.idleConnectionMonitorThread.start();
	}
	
	public static HttpClientHelper getInstance(){
		return instance;
	}
	
	private RequestConfig defaultRequestConfig = RequestConfig.custom()
													   .setConnectionRequestTimeout(2000) // 获取连接时间
													   .setConnectTimeout(5000)	// 连接时间
													   .setSocketTimeout(20000)	// 传输时间
													   .build();//设置请求和传输超时时间
	private ConnectionConfig defaultConnectionConfig = ConnectionConfig.custom().setCharset(Consts.UTF_8).build();
	private void init(){
		cm = new PoolingHttpClientConnectionManager();
		
		// Increase max total connection to 200
		cm.setMaxTotal(200);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(100);
		// Increase max connections for localhost:80 to 50
//		HttpHost localhost = new HttpHost("locahost", 80);
//		cm.setMaxPerRoute(new HttpRoute(localhost), 50);
		httpClient = HttpClients.custom().setConnectionManager(cm)
										 .setDefaultConnectionConfig(defaultConnectionConfig).build();
	}
	
	public static String doGet(String url, List<NameValuePair> params, String charSet) throws ClientProtocolException, IOException{
		return instance.get(url, params, charSet);
	}
	
	public static String doGet(String url, List<NameValuePair> params) throws ClientProtocolException, IOException{
		return instance.get(url, params, Consts.UTF_8.name());
	}
	
	public static String doGet(String url) throws ClientProtocolException, IOException{
		return instance.get(url, null, Consts.UTF_8.name());
	}
	
	public static String doPost(String url, Map<String, Object> params, String charSet) throws ClientProtocolException, IOException{
		return instance.post(url, params, charSet);
	}
	
	public static String doPost(String url, Map<String, Object> params) throws ClientProtocolException, IOException{
		return instance.post(url, params, Consts.UTF_8.name());
	}
	public static String doPost(String url, String params) throws ClientProtocolException, IOException{
		return instance.post(url, params, Consts.UTF_8.name());
	}
	public static String doPost(String url, List<NameValuePair> params, String charSet) throws ClientProtocolException, IOException{
		return instance.post(url, params, charSet);
	}
	
	public static String doPost(String url, List<NameValuePair> params) throws ClientProtocolException, IOException{
		return instance.post(url, params, Consts.UTF_8.name());
	}
	
	public String get(String url, List<NameValuePair> params, String charSet) throws ClientProtocolException, IOException{
		CloseableHttpResponse response = null;
		try{
			if(charSet==null) charSet = Consts.UTF_8.name();
			if(params!=null && params.size()>0){
				String paramStr = URLEncodedUtils.format(params, charSet);
				url += url.indexOf("?")<0 ? "?":"&";
				url += paramStr;
			}
			HttpGet httpGet = new HttpGet(url);
			httpGet.setConfig(defaultRequestConfig);
			response = httpClient.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==200){ // 只处理状态为200
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					return EntityUtils.toString(entity, charSet);
				}
			}
			return null;
		}
		finally{
			HttpClientUtils.closeQuietly(response);
		}
	}
	
	public String post(String url, Map<String, Object> map, String charSet) throws ClientProtocolException, IOException{
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if(map!=null){
			for(Entry<String, Object> entry : map.entrySet()){
				NameValuePair nv = new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()));
				params.add(nv);
			}
		}
		return post(url, params, charSet);
	}
	
	public String post(String url, List<NameValuePair> params, String charSet) throws ClientProtocolException, IOException{
		CloseableHttpResponse response = null;
		try{
			if(charSet==null) charSet = Consts.UTF_8.name();
			UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(params, charSet);
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(paramEntity);
			
			httpPost.setConfig(defaultRequestConfig);
			response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode()==200){ // 只处理状态为200
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					return EntityUtils.toString(entity, charSet);
				}
			}
			return null;
		}
		finally{
			HttpClientUtils.closeQuietly(response);
		}
	}
	
	public String post(String url, String params, String charSet) throws ClientProtocolException, IOException{
		CloseableHttpResponse response = null;
		try{
			if(charSet==null) charSet = Consts.UTF_8.name();
			StringEntity paramEntity = new StringEntity(params); 
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(paramEntity);
			httpPost.setConfig(defaultRequestConfig);
			response = httpClient.execute(httpPost);
			if(response.getStatusLine().getStatusCode()==200){ // 只处理状态为200
				HttpEntity entity = response.getEntity();
				if(entity!=null){
					return EntityUtils.toString(entity, charSet);
				}
			}
			return null;
		}
		finally{
			HttpClientUtils.closeQuietly(response);
		}
	}
	
	class IdleConnectionMonitorThread  extends Thread{
		
		public void run(){
			System.out.println("HttpClient 回收过期连接 线程开始...");
			try {
	            while (!shutdown) {
	                synchronized (this) {
	                    wait(5000);
	                    cm.closeExpiredConnections();
	                    // Optionally, close connections
	                    // that have been idle longer than 30 sec
//	                    cm.closeIdleConnections(30, TimeUnit.SECONDS);
	                }
	            }
	        } catch (InterruptedException ex) {
	            // terminate
	        }
		}
		
		public void shutdown() {
	        shutdown = true;
	        synchronized (this) {
	            notifyAll();
	        }
	    }
	}
	
	public static void main(String[] args){
		System.out.println("------------------------S");
		try{
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("q", "人"));
			params.add(new BasicNameValuePair("tn", "baidu"));
			System.out.println(URLEncodedUtils.format(params, Consts.UTF_8));
			String url = "http://www.baidu.com/";
			String content = HttpClientHelper.getInstance().get(url, params, null);
			
			System.out.println("rst="+content);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------------------------E");
	}
}
