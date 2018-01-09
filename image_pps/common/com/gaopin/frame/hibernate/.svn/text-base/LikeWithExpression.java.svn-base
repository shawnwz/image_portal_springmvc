/* This file LikeWithExpression.java is part of image_pps .
*  Copyright © 2015 Gaopin Images. All rights reserved.  
*  This software, including documentation, is protected by copyright controlled by Gaopin Images. All rights are reserved. 
*  Copying, including reproducing, storing, adapting or translating, any or all of this material requires the prior written consent of Gaopin Images. 
*  This material also contains confidential information which may not be disclosed to others without the prior written consent of Gaopin Images.
* 
*/
package com.gaopin.frame.hibernate;

import java.io.Serializable;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LikeExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * 封装Hibernate的like相关查询
  *<dl>
  *<dt>类名：LikeWithException</dt>
  *<dd>公司: 炫果壳(北京)信息技术有限公司</dd>
  *<dd>创建时间：2012-5-15  下午3:59:48</dd>
  *<dd>创建人： fming</dd>
  *</dl>
 */
public class LikeWithExpression extends LikeExpression implements Serializable, HibernateExpression {

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private String propertyName;
	
	private String value;
	
	private LikeWithType likeWithType;
	
	public LikeWithExpression(String propertyName, String value,
			LikeWithType likeWithType) {
		super(propertyName, value, likeWithType.getMatchMode());
		this.propertyName = propertyName;
		this.value = value;
		this.likeWithType = likeWithType;
	}

	public Criterion createCriteria() {
		if(value == null)
			return null;
		MatchMode mm = MatchMode.ANYWHERE;
		switch (likeWithType) {
		case LikeAnyWhere:
			mm = MatchMode.ANYWHERE;
			break;
		case LikeStart:
			mm = MatchMode.START;
			break;
		case LikeEnd:
			mm = MatchMode.END;
			break;
		default:
			break;
		}
		return Restrictions.like(propertyName, value, mm);
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LikeWithType getLikeWithType() {
		return likeWithType;
	}

	public void setLikeWithType(LikeWithType likeWithType) {
		this.likeWithType = likeWithType;
	}
	
}
