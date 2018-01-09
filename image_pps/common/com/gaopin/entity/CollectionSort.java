/* This file CollectionSort.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.entity;

/**
 * 图库属性，搜索排序专用
 * @author xcb
 *
 */
public class CollectionSort {
	private int id;
	private Integer level;
	private Integer score;
	
	public CollectionSort(int id, Integer level, Integer score){
		this.id = id;
		this.level = level;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getLevel() {
		if(level!=null && level>0) return level;
		return -1;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getScore() {
		if(score!=null && score>0) return score;
		return -1;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
