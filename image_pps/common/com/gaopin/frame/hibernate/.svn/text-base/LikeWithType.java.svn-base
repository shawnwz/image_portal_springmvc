/* This file LikeWithType.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.frame.hibernate;

import org.hibernate.criterion.MatchMode;

/**
 * hibernate like查询模式
  *<dl>
  *<dt>类名：LikeWithType</dt>
  *<dd>公司: 炫果壳(北京)信息技术有限公司</dd>
  *<dd>创建时间：2012-5-15  下午4:07:34</dd>
  *<dd>创建人： fming</dd>
  *</dl>
 */
public enum LikeWithType {
	
	LikeAnyWhere(MatchMode.ANYWHERE, "like '%条件%'"),
	LikeStart(MatchMode.START, "like '条件%'"),
	LikeEnd(MatchMode.END, "like '%条件'")
	;
	
	private LikeWithType(MatchMode matchMode, String desc) {
		this.matchMode = matchMode;
		this.desc = desc;
	}
	
	private MatchMode matchMode;
	
	private String desc;

	public MatchMode getMatchMode() {
		return matchMode;
	}

	public void setMatchMode(MatchMode matchMode) {
		this.matchMode = matchMode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
