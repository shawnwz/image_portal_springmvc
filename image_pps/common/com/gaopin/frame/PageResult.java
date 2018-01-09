/* This file PageResult.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.frame;

import java.util.ArrayList;
import java.util.List;
/**
 * 分页查询对象
 * @param <T>
 */
public class PageResult<T> implements java.io.Serializable{
	// 数据集
	private List<T> data;
	// 总数
	private int total;
	// 每页数量
	private int n;
	// 页码
	private int p;
	// 总页数
	private int mp;
	
	private String sortName;
	
	private Boolean isAsc;
	
	public PageResult(int p, int n){
		this.p = p<=0 ? 1:p;
		this.n = n<=0 ? 20:n;
	}
	
	public void setSearchData(List<T> data, int total){
		setData(data);
		setTotal(total);
	}
	
	public void setSearchData(List<T> data, long total){
		setSearchData(data, (int)total);
	}
	
	public List<T> getData() {
		if(data==null){
			data = new ArrayList<T>();
		}
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		this.mp = total/n + (total%n>0 ? 1:0);
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}

	public String getSortName() {
		if(sortName==null || sortName.equals("")){
			return "id";
		}
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public boolean isAsc() {
		if(isAsc==null) return false;
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}
	
	public int getRequestMin(){
		return (p-1) * n;
	}
	
	public int getRequestMax(){
		return p*n;
	}
}
