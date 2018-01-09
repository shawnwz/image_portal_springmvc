/**
 * 
 */
package com.gaopin.frame.hibernate;

import java.io.Serializable;

import org.hibernate.criterion.Criterion;

/**
 *
 */
@SuppressWarnings("serial")
public class LogicalExpression extends  org.hibernate.criterion.LogicalExpression implements HibernateExpression, Serializable {

	
	
	public LogicalExpression(HibernateExpression lhs,HibernateExpression rhs,LogicalType type)
	{
		super(lhs.createCriteria(),rhs.createCriteria(),type.getValue());
	}

	public Criterion createCriteria() {
		return  this;
	}

}
