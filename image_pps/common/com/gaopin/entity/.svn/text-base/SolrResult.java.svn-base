/* This file SolrResult.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

import java.util.List;

import com.gaopin.utils.SearchUtils;

public class SolrResult {
	
	private String corbisId;
	private Integer collectionId;
	private Integer rating;
	
	public SolrResult(String corbisId, Integer collectionId, Integer rating){
		this.corbisId = corbisId;
		this.collectionId = collectionId;
		this.rating = rating;
	}
 
	public String getCorbisId() {
		return corbisId;
	}

	public void setCorbisId(String corbisId) {
		this.corbisId = corbisId;
	}

	public Integer getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "SolrResult [corbisId=" + corbisId + ", collectionId="
				+ collectionId + ", rating=" + rating + "]";
	}

	public static void main(String[] args){
		
		String str = "{\"num\":2,\"data\":[{\"corbis_id\":\"42-15220775\",\"collection_id\":\"647\",\"rating\":291},{\"corbis_id\":\"42-15220774\",\"collection_id\":\"647\",\"rating\":60}]}";
		
		SearchResult obj = SearchUtils.getSearchResultFromJson(str, null);
//		
		System.out.println("total = " + obj.getTotal());
		List<SolrResult> datas = obj.getDatas();
		for(SolrResult sr : datas){
			System.out.println(sr);
		}
		
		System.out.println("==============");
		for(String s : obj.getAllIds()){
			System.out.println(s);
		}
		
	}
}
